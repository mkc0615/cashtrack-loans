package com.cashtrackloans.cashtracksloans.service;

import com.cashtrackloans.cashtracksloans.domain.Loan;
import com.cashtrackloans.cashtracksloans.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    // Get Loan list
    public List<Loan> findLoans(int userNo){

        List<Loan> todayList = loanRepository.findByUserNo(userNo);

        LocalDate todayTime = LocalDate.now();

        todayList.forEach(c -> {
            LocalDate lendTime = c.getLendTime();
            int dateDiff = todayTime.compareTo(lendTime);
            int newAmount = Math.toIntExact(Math.round(c.getAmount() * (dateDiff * (c.getInterestRate()/100))));
            c.setInterestAmount(newAmount);
        });
        return todayList;
    }

    // Add Loan case
    public int saveLoan(Loan loan){
        return loanRepository.insertLoan(loan);
    }
}
