package com.BookApi.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 * @Data аннотация Lombok автоматически генерирующая - геттеры , сеттеры
 * переопределяет  toString() hashCode и equals
 * НЕ добавляет конструктор со всеми полями — для этого есть @AllArgsConstructor
 * @NoArgsConstructor - указал явно что нужен пустой конструктор
 * пустой конструктор нужен для фреймворка при десериализации JSON
 * подстраховка
 *
 * @Data НЕ подходит для иммутабельных классов
 * классов с final полями
 * и с переопределенными вручную equals и hashcode
 * */

@Data
@NoArgsConstructor

//класс является сущностью
@Entity
//Имя таблицы в бд
@Table(name = "books")
public class Book {

    //поле является primary key
    @Id
    //является автогенерируемым
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    //в H2 имя year является зарезервированным, необходимо
    // явно указать название колонки отличное от year
    @Column(name = "year_of_publication", nullable = false)
    private Integer year;
}
