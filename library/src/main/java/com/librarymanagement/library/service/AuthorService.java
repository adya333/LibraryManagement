package com.librarymanagement.library.service;

import com.librarymanagement.library.dtos.patch.AuthorPatchDTO;
import com.librarymanagement.library.dtos.request.AuthorRequestDTO;
import com.librarymanagement.library.dtos.response.AuthorResponseDTO;

import java.util.List;

public interface AuthorService {

     AuthorResponseDTO createAuthor(AuthorRequestDTO authorRequestDTO);
     AuthorResponseDTO getAuthorById(Long authorId);
     List<AuthorResponseDTO> getAllAuthors();
     AuthorResponseDTO updateAuthor(Long authorId, AuthorPatchDTO authorPatchDTO);
     void deleteAuthor(Long authorId);
}
