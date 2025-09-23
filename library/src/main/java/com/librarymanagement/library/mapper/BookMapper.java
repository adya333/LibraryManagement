package com.librarymanagement.library.mapper;

import com.librarymanagement.library.dtos.request.BookRequestDTO;
import com.librarymanagement.library.dtos.response.BookResponseDTO;
import com.librarymanagement.library.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {



    // RequestDTO → Entity
    @Mapping(target = "availableCopies", ignore = true) // handled in service
    @Mapping(target = "status", ignore = true)         // handled in service
    @Mapping(target = "author", ignore = true)         // set in service
    Book toEntity(BookRequestDTO dto);

    // Entity → ResponseDTO
    @Mapping(source = "author.name", target = "authorName")
    @Mapping(source = "status", target = "status") // Enum → String automatically
    BookResponseDTO toDTO(Book book);
}
