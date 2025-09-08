package com.BookApi.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * @Data аннотация Lombok автоматически генерирующая - геттеры , сеттеры
 * переопределяет  toString() hashCode и equals
 * НЕ добавляет конструктор со всеми полями — для этого есть @AllArgsConstructor
 * @NoArgsConstructor - добавляем явно что нужен пустой конструктор
 * пустой конструктор нужен для фреймворка при десериализации JSON
 * подстраховка
 *
 * @Data НЕ подходит для иммутабельных классов
 * классов с final полями
 * и с переопределенными вручную equals и hashcode
 * */

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(name = "yer_of_publication", nullable = false)
    private Integer year;
}
