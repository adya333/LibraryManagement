package com.librarymanagement.library.dtos.patch;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuthorPatchDTO {

    String Name;

    String nationality;

    LocalDate birthDate;

    LocalDate deathDate;
}
