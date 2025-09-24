package com.librarymanagement.library.dtos.request;

import com.librarymanagement.library.entity.LoanStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LoanRequestDTO {

    @NotNull
    private Long memberId;
    @NotNull
    private Long bookId;

    private String bookName;

    private int numberOfCopies;
    @NotNull
    private LocalDate issueDate;
    @NotNull
    private LocalDate dueDate;
    @NotNull
    private LoanStatus status;


}
