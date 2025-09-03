package com.BookApi.controller;


import com.BookApi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private List<Book> books = new ArrayList<>();
    private AtomicLong counter = new AtomicLong(1);

    // GET /api/books - получить все книги
    @GetMapping
    public List<Book> getAllBooks() {
        return List.copyOf(books);
    }


    // GET /api/books/id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //POST - /api/books - добавить новую книгу
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        book.setId(counter.getAndIncrement());
        books.add(book);
        return book;
    }

    //PUT - /api/books/id - обновить книгу
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setYear(updatedBook.getYear());
                return book;
            }
        }
        return null;
    }

    //DELETE - /api/books/id - удалить книгу
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
