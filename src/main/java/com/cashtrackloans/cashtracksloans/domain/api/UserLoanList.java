package com.cashtrackloans.cashtracksloans.domain.api;

import com.cashtrackloans.cashtracksloans.domain.Loan;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserLoanList {

    private int userNo;

    List<Loan> loanList = new ArrayList<>();

    public void createList(int userNo, List<Loan> loanList){
        this.userNo = userNo;
        this.loanList = loanList;
    }
}
