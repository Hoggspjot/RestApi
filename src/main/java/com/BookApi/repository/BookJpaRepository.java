package com.BookApi.repository;


import com.BookApi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Long> {
    //Jpa repository  findAll(), findById(), save(), deleteById()
    //Ничего писать не нужно Spring Data JPA автоматически реализует интерфейс

}
