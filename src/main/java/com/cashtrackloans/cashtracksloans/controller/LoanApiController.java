package com.cashtrackloans.cashtracksloans.controller;

import com.cashtrackloans.cashtracksloans.domain.Loan;
import com.cashtrackloans.cashtracksloans.domain.Repayment;
import com.cashtrackloans.cashtracksloans.domain.User;
import com.cashtrackloans.cashtracksloans.domain.api.UserLoanList;
import com.cashtrackloans.cashtracksloans.domain.api.UserRepayList;
import com.cashtrackloans.cashtracksloans.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanApiController {

    @Autowired
    LoanService loanService;

    @GetMapping("/list/{userNo}")
    public ResponseEntity<UserLoanList> myLoanList(@PathVariable("userNo") int userNo){
        List<Loan> resultList = loanService.findLoans(userNo);
        UserLoanList response = new UserLoanList();
        response.createList(userNo, resultList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/addLoans")
    public ResponseEntity<Integer> addLoans(@RequestBody Loan loan){
        int result = loanService.saveLoan(loan);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/expireLoans")
    public ResponseEntity<Integer> expireLoans(@RequestBody Loan loan){
        int result = loanService.expireLoan(loan);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/repay/{userNo}")
    public ResponseEntity<UserRepayList> repayList(@PathVariable("userNo") int userNo){
        List<Repayment> resultList = loanService.findRepayments(userNo);
        UserRepayList response = new UserRepayList();
        response.createList(userNo, resultList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/addRepay")
    public ResponseEntity<Integer> addRepay(Loan loan){

        int totalAmount = 0;
        LocalDate repayDate = LocalDate.now();

        int result = loanService.saveRepay(totalAmount, repayDate, loan);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
