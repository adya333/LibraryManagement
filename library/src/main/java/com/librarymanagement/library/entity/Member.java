package com.librarymanagement.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    private String phone;

    private String address;

    @NotNull
    @Column(nullable = false)
    private LocalDate membershipDate;
    private MemberStatus status; // e.g., ACTIVE, INACTIVE, Blacklisted

    @NotNull
    @Column(nullable = false)
    private Integer maxBooksAllowed;


}
