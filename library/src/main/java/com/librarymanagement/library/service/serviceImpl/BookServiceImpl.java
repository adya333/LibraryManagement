package com.librarymanagement.library.service.serviceImpl;

import com.librarymanagement.library.dtos.patch.BookPatchDTO;
import com.librarymanagement.library.dtos.request.BookRequestDTO;
import com.librarymanagement.library.dtos.response.BookResponseDTO;
import com.librarymanagement.library.entity.Author;
import com.librarymanagement.library.entity.Book;
import com.librarymanagement.library.exception.AuthorNotFoundException;
import com.librarymanagement.library.exception.BookNotFoundException;
import com.librarymanagement.library.mapper.BookMapper;
import com.librarymanagement.library.repository.AuthorRepository;
import com.librarymanagement.library.repository.BookRepository;
import com.librarymanagement.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, BookMapper bookMapper)
    {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookMapper = bookMapper;
    }
    @Override
    public BookResponseDTO createBook(BookRequestDTO bookRequestDTO){
        Book book = bookMapper.toEntity(bookRequestDTO);
        Author author = authorRepository.findById(bookRequestDTO.getAuthorId()).orElseThrow(
                ()->new AuthorNotFoundException("Author not found"));
        book.setAuthor(author);
        book.setAvailableCopies(bookRequestDTO.getTotalCopies());
        book.setTotalCopies(bookRequestDTO.getTotalCopies());
        book.setStatus(bookRequestDTO.getStatus());
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDTO(savedBook);
    }

    @Override
    public BookResponseDTO getBookById(Long bookId)
    {
        // This findById actually returns an Optional<Book>. this elsethrow helps unwrap it.
        Book book = bookRepository.findById(bookId).orElseThrow(()-> new BookNotFoundException("The book with id "+bookId+" doesn't exists."));
        return bookMapper.toDTO(book);
    }

    @Override
    public List<BookResponseDTO> getAllBooks(){
        // NO null cuz it will return an empty list.
        List<Book>  books = bookRepository.findAll();
        return books.stream().map(bookMapper::toDTO).toList();
    }

    @Override
    public BookResponseDTO updateBook(Long bookId, BookPatchDTO bookPatchDTO)
    {
        Book book = bookRepository.findById(bookId).orElseThrow(()->
                new BookNotFoundException("The book with id"+bookId+" doesn't exists. Enter a valid book id"));
        if(bookPatchDTO.getIsbn()!=null)
        {
            book.setIsbn(bookPatchDTO.getIsbn());
        }
        if(bookPatchDTO.getTitle()!=null)
            book.setTitle(bookPatchDTO.getTitle());
        if(bookPatchDTO.getAuthorId()!=null)
        {
            Author author = authorRepository.findById(bookPatchDTO.getAuthorId()).orElseThrow(
                    ()->new AuthorNotFoundException("Author not found"));
            book.setAuthor(author);
        }
        if(bookPatchDTO.getPublisher()!=null)
          book.setPublisher(bookPatchDTO.getPublisher());
        if(bookPatchDTO.getYear()!=null)
            book.setYear(bookPatchDTO.getYear());
        if (bookPatchDTO.getGenre() != null) book.setGenre(bookPatchDTO.getGenre());
        if (bookPatchDTO.getTotalCopies() != null) book.setTotalCopies(bookPatchDTO.getTotalCopies());
        if (bookPatchDTO.getStatus() != null) book.setStatus(bookPatchDTO.getStatus());

        Book patched = bookRepository.save(book);
        return bookMapper.toDTO(patched);
    }


    public void deleteBook(Long id)
    {
        Book book = bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("The book with id "+id+" doesn't exists."));
        bookRepository.delete(book);

    }
}

