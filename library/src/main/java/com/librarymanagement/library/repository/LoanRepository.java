package com.librarymanagement.library.repository;

import com.librarymanagement.library.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {

    @Query("select l from Loan l where l.member.memberId=:memberId")
    List<Loan> findAllByMember_MemberId(Long memberId);
}
