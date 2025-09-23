package com.librarymanagement.library.dtos.patch;

import com.librarymanagement.library.entity.BookStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/*So this patch dto is pretty same as request dto because, admin can send fields they want and leave other
* which is why non of them contain @NotNull*/
@Getter
@Setter
public class BookPatchDTO {

    private String isbn;


    private String title;


    private Long authorId; // Only the ID to link Author

    private String publisher;

    private Integer year;

    private String genre;


    private Integer totalCopies;
    private BookStatus status;
}
