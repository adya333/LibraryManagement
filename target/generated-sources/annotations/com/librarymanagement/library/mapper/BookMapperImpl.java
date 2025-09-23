package com.librarymanagement.library.mapper;

import com.librarymanagement.library.dtos.request.BookRequestDTO;
import com.librarymanagement.library.dtos.response.BookResponseDTO;
import com.librarymanagement.library.entity.Author;
import com.librarymanagement.library.entity.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-23T23:55:35+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Microsoft)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book toEntity(BookRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Book book = new Book();

        book.setIsbn( dto.getIsbn() );
        book.setTitle( dto.getTitle() );
        book.setPublisher( dto.getPublisher() );
        book.setYear( dto.getYear() );
        book.setGenre( dto.getGenre() );
        book.setTotalCopies( dto.getTotalCopies() );

        return book;
    }

    @Override
    public BookResponseDTO toDTO(Book book) {
        if ( book == null ) {
            return null;
        }

        BookResponseDTO bookResponseDTO = new BookResponseDTO();

        bookResponseDTO.setAuthorName( bookAuthorName( book ) );
        bookResponseDTO.setStatus( book.getStatus() );
        bookResponseDTO.setBookId( book.getBookId() );
        bookResponseDTO.setIsbn( book.getIsbn() );
        bookResponseDTO.setTitle( book.getTitle() );
        bookResponseDTO.setPublisher( book.getPublisher() );
        bookResponseDTO.setYear( book.getYear() );
        bookResponseDTO.setGenre( book.getGenre() );
        bookResponseDTO.setTotalCopies( book.getTotalCopies() );
        bookResponseDTO.setAvailableCopies( book.getAvailableCopies() );

        return bookResponseDTO;
    }

    private String bookAuthorName(Book book) {
        if ( book == null ) {
            return null;
        }
        Author author = book.getAuthor();
        if ( author == null ) {
            return null;
        }
        String name = author.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
