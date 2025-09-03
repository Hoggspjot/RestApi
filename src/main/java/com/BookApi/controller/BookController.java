package com.BookApi.controller;


import com.BookApi.dto.BookRequestDto;
import com.BookApi.dto.BookResponseDto;
import com.BookApi.mapper.BookMapper;
import com.BookApi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookMapper bookMapper = new BookMapper();

    private List<Book> books = new ArrayList<>();
    private AtomicLong counter = new AtomicLong(1);

    // GET /api/books - получить все книги
    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        return books.stream()
                .map(bookMapper::toResponseDto)
                .collect(Collectors.toList());
    }


    // GET /api/books/id
    @GetMapping("/{id}")
    public BookResponseDto getBookById(@PathVariable Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .map(bookMapper::toResponseDto)
                .orElse(null);
    }

    //POST - /api/books - добавить новую книгу
    @PostMapping
    public BookResponseDto addBook(@RequestBody BookRequestDto requestDto) {
        Book book = bookMapper.toEntity(requestDto);
        book.setId(counter.getAndIncrement());
        books.add(book);
        return bookMapper.toResponseDto(book);
    }


    //PUT - /api/books/id - обновить книгу
    @PutMapping("/{id}")
    public BookResponseDto updateBook(@PathVariable Long id, @RequestBody BookRequestDto requestDto) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(requestDto.getTitle());
                book.setAuthor(requestDto.getAuthor());
                book.setYear(requestDto.getYear());
                return bookMapper.toResponseDto(book);
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
