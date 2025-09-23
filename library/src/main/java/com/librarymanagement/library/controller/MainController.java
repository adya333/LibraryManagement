package com.librarymanagement.library.controller;

import com.librarymanagement.library.dtos.patch.BookPatchDTO;
import com.librarymanagement.library.dtos.request.BookRequestDTO;
import com.librarymanagement.library.dtos.response.BookResponseDTO;
import com.librarymanagement.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class MainController {

    private final BookService bookService;

    @Autowired
    public MainController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String testing() {
        return "Hello, Library API is working!";
    }

    @PostMapping("/add")
    public ResponseEntity<BookResponseDTO> create(@RequestBody BookRequestDTO bookRequestDTO)
    {
        BookResponseDTO createdBook = bookService.createBook(bookRequestDTO);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookId(@PathVariable Long id)
    {
        BookResponseDTO bookResponseDTO = bookService.getBookById(id);
        return new ResponseEntity<>(bookResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks()
    {
        List<BookResponseDTO> books = bookService.getAllBooks();
        return new ResponseEntity<List<BookResponseDTO>>(books,HttpStatus.OK);
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @RequestBody BookPatchDTO bookPatchDTO)
    {
        BookResponseDTO patched = bookService.updateBook(id, bookPatchDTO);
        return new ResponseEntity<BookResponseDTO>(patched, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id)
    {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}

