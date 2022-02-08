package com.cashtrackloans.cashtracksloans.service;

import com.cashtrackloans.cashtracksloans.domain.Loan;
import com.cashtrackloans.cashtracksloans.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public List<Loan> findLoans(int userNo){
        return loanRepository.findByUserNo(userNo);
    }

    public int saveLoan(Loan loan){
        return loanRepository.insertLoan(loan);
    }
}
