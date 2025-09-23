package com.librarymanagement.library.controller;

import com.librarymanagement.library.dtos.patch.AuthorPatchDTO;
import com.librarymanagement.library.dtos.request.AuthorRequestDTO;
import com.librarymanagement.library.dtos.response.AuthorResponseDTO;
import com.librarymanagement.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService)
    {
        this.authorService=authorService;
    }

    @PostMapping("/add")
    public ResponseEntity<AuthorResponseDTO> addAuthor(@RequestBody AuthorRequestDTO authorRequestDTO)
    {
        AuthorResponseDTO authorResponseDTO=authorService.createAuthor(authorRequestDTO);
        return new ResponseEntity<>(authorResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Long id)
    {
        AuthorResponseDTO authorResponseDTO = authorService.getAuthorById(id);
        return new ResponseEntity<>(authorResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AuthorResponseDTO>> getAllAuthors()
    {
        List<AuthorResponseDTO> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AuthorResponseDTO> updateAuthor(@PathVariable Long id, @RequestBody  AuthorPatchDTO authorPatchDTO)
    {
        AuthorResponseDTO authorResponseDTO = authorService.updateAuthor(id, authorPatchDTO);
        return new ResponseEntity<>(authorResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id)
    {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
