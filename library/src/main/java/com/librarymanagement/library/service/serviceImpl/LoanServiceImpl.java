package com.librarymanagement.library.service.serviceImpl;
import com.librarymanagement.library.dtos.response.BookResponseDTO;
import com.librarymanagement.library.entity.Book;
import com.librarymanagement.library.entity.Loan;
import com.librarymanagement.library.dtos.request.LoanRequestDTO;
import com.librarymanagement.library.dtos.response.LoanResponseDTO;
import com.librarymanagement.library.exception.LoanNotFoundException;
import com.librarymanagement.library.exception.NoLoansException;
import com.librarymanagement.library.exception.NotEnoughCopiesAvailable;
import com.librarymanagement.library.mapper.BookMapper;
import com.librarymanagement.library.mapper.LoanMapper;
import com.librarymanagement.library.repository.BookRepository;
import com.librarymanagement.library.repository.LoanRepository;
import com.librarymanagement.library.service.BookService;
import com.librarymanagement.library.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanMapper loanMapper;
    private final BookServiceImpl bookServiceImpl;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;
    private final BookMapper bookMapper;

    @Autowired
    public LoanServiceImpl(LoanMapper loanMapper,BookMapper bookMapper, BookServiceImpl bookServiceImpl, BookRepository bookRepository, LoanRepository loanRepository)
    {
        this.loanMapper=loanMapper;
        this.loanRepository=loanRepository;
        this.bookRepository=bookRepository;
        this.bookServiceImpl=bookServiceImpl;
        this.bookMapper=bookMapper;
    }


    @Override
    public LoanResponseDTO createLoan(LoanRequestDTO loanRequestDTO)
    {
       Loan loan = loanMapper.toEntity(loanRequestDTO);
       Book book = loan.getBook();
        if(book.getAvailableCopies()< loanRequestDTO.getNumberOfCopies())
        {
            throw new NotEnoughCopiesAvailable("Not enough copies available. Available: "+book.getAvailableCopies());
        }
       Loan saved = loanRepository.save(loan);
        if(book.getAvailableCopies()>= loanRequestDTO.getNumberOfCopies())
        {
            book.setAvailableCopies(book.getAvailableCopies()-loanRequestDTO.getNumberOfCopies());
        }
        bookRepository.save(book);
       return loanMapper.toDTO(saved);
    }

    @Override
    public LoanResponseDTO getLoanById(Long loanId){
        Loan loan = loanRepository.findById(loanId).orElseThrow(()-> new LoanNotFoundException("Loan record doesn't exists."));
        return loanMapper.toDTO(loan);
    }

    @Override
    public List<LoanResponseDTO> getAllLoans()
    {
        List<Loan> loans= loanRepository.findAll();
        if(loans.size()==0)
        {
            throw new NoLoansException("There are currently no loans");
        }
        return loans.stream().map(loanMapper::toDTO).toList();
    }

    @Override
    public List<LoanResponseDTO> getAllLoansByMemberId(Long memberId)
    {
       List<Loan> loans = loanRepository.findAllByMemberId(memberId);
       return loans.stream().map(loanMapper::toDTO).toList();
    }

}
