package com.BookApi.model;


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
public class Book {
    private Long id;
    private String title;
    private String author;
    private Integer year;
}
