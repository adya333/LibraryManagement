package com.librarymanagement.library.service.serviceImpl;

import com.librarymanagement.library.dtos.patch.AuthorPatchDTO;
import com.librarymanagement.library.dtos.request.AuthorRequestDTO;
import com.librarymanagement.library.dtos.response.AuthorResponseDTO;
import com.librarymanagement.library.entity.Author;
import com.librarymanagement.library.exception.AuthorNotFoundException;
import com.librarymanagement.library.mapper.AuthorMapper;
import com.librarymanagement.library.repository.AuthorRepository;
import com.librarymanagement.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;
    AuthorMapper authorMapper;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper)
    {
        this.authorRepository=authorRepository;
        this.authorMapper=authorMapper;
    }


    @Override
    public AuthorResponseDTO createAuthor(AuthorRequestDTO authorRequestDTO)
    {
      Author book = authorMapper.toEntity(authorRequestDTO);
      Author created = authorRepository.save(book);
      return authorMapper.toDTO(created);
    }

    @Override
    public AuthorResponseDTO getAuthorById(Long authorId)
    {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(()-> new AuthorNotFoundException("Author with id "+authorId+" doesn't exists."));
        return authorMapper.toDTO(author);
    }

    @Override
    public List<AuthorResponseDTO> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
         return authors.stream().map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDTO updateAuthor(Long authorId, AuthorPatchDTO authorPatchDTO)
    {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(()-> new AuthorNotFoundException("Author with id "+authorId+" doesn't exists."));
        if(authorPatchDTO.getName()!=null)
            author.setName(authorPatchDTO.getName());
        if(authorPatchDTO.getNationality()!=null)
            author.setNationality(authorPatchDTO.getNationality());
        if(authorPatchDTO.getBirthDate()!=null)
            author.setBirthDate(authorPatchDTO.getBirthDate());
        if(authorPatchDTO.getDeathDate()!=null)
            author.setDeathDate(authorPatchDTO.getDeathDate());

        Author patched = authorRepository.save(author);
        return authorMapper.toDTO(patched);
    }

    @Override
    public void deleteAuthor(Long authorId)
    {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(()-> new AuthorNotFoundException("Author with id "+authorId+" doesn't exists."));
        authorRepository.delete(author);
    }
}
