package com.librarymanagement.library.dtos.response;


import com.librarymanagement.library.entity.BookStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponseDTO {

    private Long bookId;

    private String isbn;

    private String title;

    private String authorName; // Flattened from Author entity

    private String publisher;

    private Integer year;

    private String genre;

    private Integer totalCopies;

    private Integer availableCopies;

    private BookStatus status; // e.g., AVAILABLE, BORROWED, RESERVED




}
