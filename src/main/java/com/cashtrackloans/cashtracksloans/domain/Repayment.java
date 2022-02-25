package com.cashtrackloans.cashtracksloans.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Repayment {

    @Id
    private int repayNo;

    private int repayAmount;

    private int actualAmount;
    private int interestAmount;

    private LocalDate repayDate;

    public void createRepayEntry(int repayAmount, int actualAmount, int interestAmount){
        this.repayAmount = repayAmount;
        this.actualAmount = actualAmount;
        this.interestAmount = interestAmount;
    }

    public void setActualAmount(int newAmount){
        this.actualAmount = newAmount;
    }

    public void setInterestAmount(int newAmount){
        this.interestAmount = newAmount;
    }

}
