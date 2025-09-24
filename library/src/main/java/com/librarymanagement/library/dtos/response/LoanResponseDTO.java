package com.librarymanagement.library.dtos.response;

import com.librarymanagement.library.entity.LoanStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LoanResponseDTO {

    private Long loanId;

    private Long memberId;
    private String memberName; // easier for frontend

    private Long bookId;
    private String bookName; // display purpose

    private Integer numberOfCopies;

    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private Double fineAmount;

    private LoanStatus status;
}
