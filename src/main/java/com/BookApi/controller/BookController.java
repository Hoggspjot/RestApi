package com.BookApi.controller;


import com.BookApi.dto.BookRequestDto;
import com.BookApi.dto.BookResponseDto;
import com.BookApi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



/*@RestController — это специализированная аннотация в Spring,
которая используется для обозначения класса как контроллера,
возвращающего данные (обычно в формате JSON или XML),
а не представления
объединяет в себе две аннотации
@Controller — указывает, что класс является Spring-бином, отвечающим за обработку HTTP-запросов.
@ResponseBody — указывает, что возвращаемое значение методов должно быть сериализовано
в тело HTTP-ответа (например, как JSON)*/
@RestController

/*@RequestMapping — это аннотация общего назначения, которая используется для
сопоставления HTTP-запросов с методами контроллера.
Она определяет, какие URL-адреса и HTTP-методы должны обрабатываться
тем или иным методом (или всем классом)
то есть ->> сопоставление запросов с обработчиками*/
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    // GET /api/books - получить все книги
    @GetMapping
    public List<BookResponseDto> getAllBooks() {
       return bookService.getAllBooks();
    }


    // GET /api/books/id
    @GetMapping("/{id}")
    public BookResponseDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    //POST - /api/books - добавить новую книгу
    @PostMapping
    public BookResponseDto addBook(@Valid @RequestBody BookRequestDto requestDto) {
        return bookService.addBook(requestDto);
    }


    //PUT - /api/books/id - обновить книгу
    @PutMapping("/{id}")
    public BookResponseDto updateBook(@PathVariable Long id, @RequestBody BookRequestDto requestDto) {
        return bookService.updateBook(id, requestDto);
    }

    //DELETE - /api/books/id - удалить книгу
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
