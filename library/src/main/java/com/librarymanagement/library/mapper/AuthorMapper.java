package com.librarymanagement.library.mapper;

import com.librarymanagement.library.dtos.request.AuthorRequestDTO;
import com.librarymanagement.library.dtos.response.AuthorResponseDTO;
import com.librarymanagement.library.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    // Request DTO -> Entity
    Author toEntity(AuthorRequestDTO dto);

    // Entity -> Response DTO
    AuthorResponseDTO toDTO(Author author);
}
