package com.cashtrackloans.cashtracksloans.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue
    private int bondNo;

    private int userNo;

    private int entry;
    private int amount;
    private double interestRate;
    private LocalDate lendTime;
    private LocalDate expireTime;

    // 내부 생성자 메서드
    public void createLoanEntry(int entry,
                                int amount,
                                double interestRate,
                                int interestAmount,
                                String lendTimeStr
    ){
        this.entry=entry;
        this.amount=amount;
        this.interestRate = interestRate;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        this.lendTime = LocalDate.parse(lendTimeStr, dtf);
    }

}
