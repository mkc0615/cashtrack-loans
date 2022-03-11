package com.cashtrackloans.cashtracksloans.service;

import com.cashtrackloans.cashtracksloans.domain.HistoryLog;
import com.cashtrackloans.cashtracksloans.domain.Loan;
import com.cashtrackloans.cashtracksloans.domain.Repayment;
import com.cashtrackloans.cashtracksloans.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            c.setNewAmount(newAmount);
        });
        return todayList;
    }

    // Add Loan case
    public int saveLoan(Loan loan){
        return loanRepository.insertLoan(loan);
    }

    // Expire Loan case
    public int expireLoan(Loan loan){
        return loanRepository.deleteLoan(loan);
    }

    // Get Repayment List
    public List<Repayment> findRepayments(int userNo){
        return loanRepository.getRepaymentByNo(userNo);
    }

    // Add Repayment case
    public int saveRepay(int repayTotalAmount, LocalDate repayDate, Loan loan){

        int thisLoanNo = loan.getBondNo();

        String thisStatus = "0";

        LocalDate todayTime = LocalDate.now();
        LocalDate expireDate = loan.getExpireTime();
        int timeDiff = expireDate.compareTo(todayTime);

        double thisRate = loan.getInterestRate();
        int interestAmount = Math.toIntExact(Math.round(repayTotalAmount * (1+thisRate / 100)));

        Repayment repayment = new Repayment();
        repayment.createRepayEntry(repayTotalAmount, repayTotalAmount-interestAmount, interestAmount, thisStatus);

        return loanRepository.insertRepayment(repayment);
    }

    public int loanLog (Loan loan){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String dateStr = LocalDate.now().format(dtf);

        HistoryLog loanLog = new HistoryLog();
        loanLog.createEntry(dateStr, "Loan", "New", loan.getAmount());

        return loanRepository.addHistoryLog(loanLog);
    }

}
