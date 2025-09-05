package com.BookApi.dto;

import lombok.Data;


/*
* @Data аннотация Lombok автоматически генерирующая - геттеры , сеттеры
* переопределяет  toString() hashCode и equals
* НЕ добавляет конструктор со всеми полями — для этого есть @AllArgsConstructor
* */
@Data
public class BookRequestDto {
    private String title;
    private String author;
    private Integer year;
}
