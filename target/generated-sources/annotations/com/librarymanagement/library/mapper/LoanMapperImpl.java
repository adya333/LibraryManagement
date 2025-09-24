package com.librarymanagement.library.mapper;

import com.librarymanagement.library.dtos.request.LoanRequestDTO;
import com.librarymanagement.library.dtos.response.LoanResponseDTO;
import com.librarymanagement.library.entity.Book;
import com.librarymanagement.library.entity.Loan;
import com.librarymanagement.library.entity.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-24T23:47:16+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Microsoft)"
)
@Component
public class LoanMapperImpl extends LoanMapper {

    @Override
    public Loan toEntity(LoanRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Loan loan = new Loan();

        loan.setBook( mapBook( dto.getBookId() ) );
        loan.setMember( mapMember( dto.getMemberId() ) );
        loan.setIssueDate( dto.getIssueDate() );
        loan.setNumberOfCopies( dto.getNumberOfCopies() );
        loan.setDueDate( dto.getDueDate() );
        loan.setStatus( dto.getStatus() );

        return loan;
    }

    @Override
    public LoanResponseDTO toDTO(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanResponseDTO loanResponseDTO = new LoanResponseDTO();

        loanResponseDTO.setMemberId( loanMemberMemberId( loan ) );
        loanResponseDTO.setMemberName( loanMemberName( loan ) );
        loanResponseDTO.setBookId( loanBookBookId( loan ) );
        loanResponseDTO.setBookName( loanBookTitle( loan ) );
        loanResponseDTO.setLoanId( loan.getLoanId() );
        loanResponseDTO.setNumberOfCopies( loan.getNumberOfCopies() );
        loanResponseDTO.setIssueDate( loan.getIssueDate() );
        loanResponseDTO.setDueDate( loan.getDueDate() );
        loanResponseDTO.setReturnDate( loan.getReturnDate() );
        loanResponseDTO.setFineAmount( loan.getFineAmount() );
        loanResponseDTO.setStatus( loan.getStatus() );

        return loanResponseDTO;
    }

    private Long loanMemberMemberId(Loan loan) {
        if ( loan == null ) {
            return null;
        }
        Member member = loan.getMember();
        if ( member == null ) {
            return null;
        }
        Long memberId = member.getMemberId();
        if ( memberId == null ) {
            return null;
        }
        return memberId;
    }

    private String loanMemberName(Loan loan) {
        if ( loan == null ) {
            return null;
        }
        Member member = loan.getMember();
        if ( member == null ) {
            return null;
        }
        String name = member.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long loanBookBookId(Loan loan) {
        if ( loan == null ) {
            return null;
        }
        Book book = loan.getBook();
        if ( book == null ) {
            return null;
        }
        Long bookId = book.getBookId();
        if ( bookId == null ) {
            return null;
        }
        return bookId;
    }

    private String loanBookTitle(Loan loan) {
        if ( loan == null ) {
            return null;
        }
        Book book = loan.getBook();
        if ( book == null ) {
            return null;
        }
        String title = book.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }
}
