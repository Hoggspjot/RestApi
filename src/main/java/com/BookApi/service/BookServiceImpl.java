package com.BookApi.service;

import com.BookApi.dto.BookRequestDto;
import com.BookApi.dto.BookResponseDto;
import com.BookApi.mapper.BookMapper;
import com.BookApi.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    //Хранение списка книг - пока без БД не добавил
    private final List<Book> books = new ArrayList<>();
    //счетчик для генерации ID
    private final AtomicLong counter = new AtomicLong(1);

    //Mapper для конвертации DTO <-> Entity
    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        return books.stream()
                .map(bookMapper::toResponseDto)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .map(bookMapper::toResponseDto)
                .orElse(null);
    }

    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        Book book = bookMapper.toEntity(bookRequestDto);
        book.setId(counter.getAndIncrement());
        books.add(book);
        return bookMapper.toResponseDto(book);
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto bookRequestDto) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                book.setTitle(bookRequestDto.getTitle());
                book.setAuthor(bookRequestDto.getAuthor());
                book.setYear(bookRequestDto.getYear());
                return bookMapper.toResponseDto(book);
            }
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
