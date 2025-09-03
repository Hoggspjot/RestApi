package com.BookApi.mapper;


import com.BookApi.dto.BookRequestDto;
import com.BookApi.dto.BookResponseDto;
import com.BookApi.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    //Entity -> Response DTO
    public BookResponseDto toResponseDto(Book book) {
        BookResponseDto dto = new BookResponseDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setYear(book.getYear());
        return dto;
    }

    //Request DTO -> Entity
    public Book toEntity(BookRequestDto requestDto) {
        Book book = new Book();
        book.setTitle(requestDto.getTitle());
        book.setAuthor(requestDto.getAuthor());
        book.setYear(requestDto.getYear());
        return book;
    }
}
