package com.cashtrackloans.cashtracksloans.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Repayment {

    @Id
    @GeneratedValue
    private int repayNo;

    private int repayAmount;

    private int actualAmount;
    private int interestAmount;

    private String settleStatus;

    private LocalDate repayDate;

    public void createRepayEntry(
            int repayAmount, int actualAmount, int interestAmount, String settleStatus
    ) {
        this.repayAmount = repayAmount;
        this.actualAmount = actualAmount;
        this.interestAmount = interestAmount;
        this.settleStatus = settleStatus;
    }

    public void setActualAmount(int newAmount){
        this.actualAmount = newAmount;
    }

    public void setInterestAmount(int newAmount){
        this.interestAmount = newAmount;
    }

}
