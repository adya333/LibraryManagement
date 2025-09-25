package com.librarymanagement.library.service;

import com.librarymanagement.library.dtos.request.LoanRequestDTO;
import com.librarymanagement.library.dtos.response.LoanResponseDTO;
import com.librarymanagement.library.entity.LoanStatus;

import java.time.LocalDate;
import java.util.List;

public interface LoanService {
    LoanResponseDTO createLoan(LoanRequestDTO loanRequestDTO);
//    LoanResponseDTO returnBook(Long loanId, LocalDate returnDate);
    LoanResponseDTO getLoanById(Long loanId);
    List<LoanResponseDTO> getAllLoans();
    List<LoanResponseDTO> getAllLoansByMemberId(Long memberId);

//    List<LoanResponseDTO> getLoanByStatus(LoanStatus status);
//    LoanResponseDTO updateLoan(Long loanId, LoanRequeDTO );
}
