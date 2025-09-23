package com.librarymanagement.library.dtos.request;

import com.librarymanagement.library.entity.BookStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestDTO {

    @NotNull
    private String isbn;

    @NotNull
    private String title;

    @NotNull
    private Long authorId; // Only the ID to link Author

    private String publisher;

    private Integer year;

    private String genre;

    @NotNull
    private Integer totalCopies;
    private BookStatus status;

}
