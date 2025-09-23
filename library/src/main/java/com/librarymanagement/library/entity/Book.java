package com.librarymanagement.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "books") // Optional: table name
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long bookId;

    @NotNull
    @Column(nullable = false, unique = true)
    private String isbn;

    @NotNull
    @Column(nullable = false)
    private String title;

    // Many books can have one author
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id") // FK in book table
    private Author author;

    private String publisher;

    private Integer year; // Year of publication

    private String genre;

    @NotNull
    @Column(nullable = false)
    private Integer totalCopies;

    @NotNull
    @Column(nullable = false)
    private Integer availableCopies;
    private BookStatus status; // e.g., AVAILABLE, BORROWED, RESERVED

}
