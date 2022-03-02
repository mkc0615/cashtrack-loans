package com.cashtrackloans.cashtracksloans.domain.api;

import com.cashtrackloans.cashtracksloans.domain.Repayment;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserRepayList {

    private int userNo;

    List<Repayment> repaymentList = new ArrayList<>();

    public void createList(int userNo, List<Repayment> repayList){
        this.userNo = userNo;
        this.repaymentList = repayList;
    }
}
