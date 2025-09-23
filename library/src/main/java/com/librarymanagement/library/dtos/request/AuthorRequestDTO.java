package com.librarymanagement.library.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuthorRequestDTO {

    @NotNull
    private String name;
    @NotNull
    private String nationality;
    private LocalDate birthDate;
    private LocalDate deathDate;

}
