package com.librarymanagement.library.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AuthorResponseDTO {

    Long authorId;
    String name;
    String nationality;
    LocalDate birthDate;
    LocalDate deathDate;
}
