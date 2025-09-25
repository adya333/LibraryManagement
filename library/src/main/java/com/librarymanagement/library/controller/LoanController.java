package com.librarymanagement.library.controller;

import com.librarymanagement.library.dtos.request.LoanRequestDTO;
import com.librarymanagement.library.dtos.response.LoanResponseDTO;
import com.librarymanagement.library.service.serviceImpl.LoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
public class LoanController {
    LoanServiceImpl loanServiceImpl;

    @Autowired
    public LoanController(LoanServiceImpl loanServiceImpl)
    {
        this.loanServiceImpl=loanServiceImpl;
    }

    @PostMapping("/create")
    public ResponseEntity<LoanResponseDTO> createLoan(@RequestBody LoanRequestDTO loanRequestDTO)
    {
        LoanResponseDTO loanResponseDTO=loanServiceImpl.createLoan(loanRequestDTO);
        return new ResponseEntity<>(loanResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<List<LoanResponseDTO>> getAllByMemberId(@PathVariable Long memberId)
    {
        List<LoanResponseDTO> loans = loanServiceImpl.getAllLoansByMemberId(memberId);
        return new ResponseEntity<>(loans,HttpStatus.OK);
    }
}
