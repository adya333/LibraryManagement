package com.librarymanagement.library.mapper;

import com.librarymanagement.library.dtos.request.LoanRequestDTO;
import com.librarymanagement.library.dtos.response.LoanResponseDTO;
import com.librarymanagement.library.entity.Book;
import com.librarymanagement.library.entity.Loan;
import com.librarymanagement.library.entity.Member;
import com.librarymanagement.library.exception.BookNotFoundException;
import com.librarymanagement.library.repository.BookRepository;
import com.librarymanagement.library.repository.MemberRepository;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class LoanMapper {

    @Autowired
    protected BookRepository bookRepository;

    @Autowired
    protected MemberRepository memberRepository;

    // ===================== Request DTO → Entity =====================
    @BeanMapping(ignoreByDefault = false)
    @Mapping(target = "book", source = "bookId", qualifiedByName = "mapBook")
    @Mapping(target = "member", source = "memberId", qualifiedByName = "mapMember")
    public abstract Loan toEntity(LoanRequestDTO dto);

    @Named("mapBook")
    protected Book mapBook(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id " + bookId));
    }

    @Named("mapMember")
    protected Member mapMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found with id " + memberId));
    }

    // ===================== Entity → Response DTO =====================
    @BeanMapping(ignoreByDefault = false)
    @Mapping(target = "memberId", source = "member.memberId")
    @Mapping(target = "memberName", source = "member.name")
    @Mapping(target = "bookId", source = "book.bookId")
    @Mapping(target = "bookName", source = "book.title")
    public abstract LoanResponseDTO toDTO(Loan loan);
}
