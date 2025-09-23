package com.librarymanagement.library.service;

import com.librarymanagement.library.dtos.patch.BookPatchDTO;
import com.librarymanagement.library.dtos.request.BookRequestDTO;
import com.librarymanagement.library.dtos.response.BookResponseDTO;
import com.librarymanagement.library.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {

    BookResponseDTO createBook(BookRequestDTO bookRequestDTO);
    BookResponseDTO getBookById(Long bookId);
    List<BookResponseDTO> getAllBooks();
    BookResponseDTO updateBook(Long bookId, BookPatchDTO bookPatchDTO);
    void deleteBook(Long bookId);
}
