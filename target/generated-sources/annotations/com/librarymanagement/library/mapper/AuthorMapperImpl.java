package com.librarymanagement.library.mapper;

import com.librarymanagement.library.dtos.request.AuthorRequestDTO;
import com.librarymanagement.library.dtos.response.AuthorResponseDTO;
import com.librarymanagement.library.entity.Author;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-23T23:55:35+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Microsoft)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author toEntity(AuthorRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Author author = new Author();

        author.setName( dto.getName() );
        author.setNationality( dto.getNationality() );
        author.setBirthDate( dto.getBirthDate() );
        author.setDeathDate( dto.getDeathDate() );

        return author;
    }

    @Override
    public AuthorResponseDTO toDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorResponseDTO authorResponseDTO = new AuthorResponseDTO();

        authorResponseDTO.setAuthorId( author.getAuthorId() );
        authorResponseDTO.setName( author.getName() );
        authorResponseDTO.setNationality( author.getNationality() );
        authorResponseDTO.setBirthDate( author.getBirthDate() );
        authorResponseDTO.setDeathDate( author.getDeathDate() );

        return authorResponseDTO;
    }
}
