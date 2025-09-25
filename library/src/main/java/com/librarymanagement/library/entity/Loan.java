package com.librarymanagement.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @NotNull
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false) // tells db that this column can't have null values.
    @NotNull // for validation purpose
    private Member member;

    @Column(nullable = false)
    @NotNull
    private LocalDate issueDate;

    @NotNull
    @Column(nullable = false)
    @Min(value = 1, message="Atleast 1 quantity to place an order")
    private int numberOfCopies;

    @NotNull
    @Column(nullable = false)
    private LocalDate dueDate;

    private LocalDate returnDate;

    private Double fineAmount; // Fine for late return

    @Enumerated(EnumType.STRING) // keeps it readable in DB
    private LoanStatus status; // e.g., ISSUED, RETURNED, OVERDUE

}
