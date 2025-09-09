package com.BookApi.repository;


import com.BookApi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Long> {

    //Spring Data JPA автоматически генерирует методы базовых crud операций
    //Jpa repository  findAll(), findById(), save(), deleteById()
    //и еще кучу всего
}
