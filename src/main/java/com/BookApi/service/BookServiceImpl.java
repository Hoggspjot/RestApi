package com.BookApi.service;

import com.BookApi.dto.BookRequestDto;
import com.BookApi.dto.BookResponseDto;
import com.BookApi.mapper.BookMapper;
import com.BookApi.model.Book;
import com.BookApi.repository.BookJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    //репозиторий для выполнения операций с сущностями в БД
    private final BookJpaRepository bookJpaRepository;

    //Mapper для конвертации DTO <-> Entity
    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookMapper bookMapper, BookJpaRepository bookJpaRepository) {
        this.bookMapper = bookMapper;
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        return bookJpaRepository.findAll().stream()
                .map(bookMapper::toResponseDto)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        return bookJpaRepository.findById(id)
                .map(bookMapper::toResponseDto)
                        .orElse(null);
    }

    @Override
    public BookResponseDto addBook(BookRequestDto bookRequestDto) {
        Book book = bookMapper.toEntity(bookRequestDto);
        Book addedBook = bookJpaRepository.save(book);
        return bookMapper.toResponseDto(addedBook);
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto bookRequestDto) {
        return bookJpaRepository.findById(id)
                .map(book -> {
                    book.setTitle(bookRequestDto.getTitle());
                    book.setAuthor(bookRequestDto.getAuthor());
                    book.setYear(bookRequestDto.getYear());
                    Book updateBook = bookJpaRepository.save(book);
                    return bookMapper.toResponseDto(updateBook);
                })
                .orElse(null);
    }

    @Override
    public void deleteBook(Long id) {
       bookJpaRepository.deleteById(id);
    }
}
