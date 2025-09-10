package com.BookApi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;




/*
* @Data аннотация Lombok автоматически генерирующая - геттеры , сеттеры
* переопределяет  toString() hashCode и equals
* НЕ добавляет конструктор со всеми полями — для этого есть @AllArgsConstructor
* */
@Data
public class BookRequestDto {

    @NotBlank(message = "Название не может быть пустым")
    private String title;
    @NotBlank(message = "Требуется ввести имя автора")
    private String author;
    @NotNull(message = "Введите год издания")
    private Integer year;
}
