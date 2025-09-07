package com.BookApi.service;

import com.BookApi.dto.BookRequestDto;
import com.BookApi.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    List<BookResponseDto> getAllBooks();
    BookResponseDto getBookById(Long id);
    BookResponseDto addBook(BookRequestDto bookRequestDto);
    BookResponseDto updateBook(Long id, BookRequestDto bookRequestDto);
    void deleteBook(Long id);
}
