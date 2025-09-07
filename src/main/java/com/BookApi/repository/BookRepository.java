package com.BookApi.repository;

import com.BookApi.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();
    Book findById(Long id);
    Book save(Book book);
    void deleteBook(Long id);
}

