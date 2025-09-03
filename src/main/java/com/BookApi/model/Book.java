package com.BookApi.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Book {
    private Long id;
    private String title;
    private String author;
    private Integer year;
}
