package com.cashtrackloans.cashtracksloans.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@RequiredArgsConstructor
public class HistoryLog {

    @Id
    private int entryNo;

    private int userNo;

    private LocalDate entryDate;
    private String entryType;
    private String entryDivision;
    private int entryAmount;
    private String entryDetail;
    private LocalDate inputDate;

    public void createEntry(String entryDateStr, String entryType, String entryDivision, int entryAmount){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.entryDate = LocalDate.parse(entryDateStr, dtf);
        this.entryType = entryType;
        this.entryDivision = entryDivision;
        this.entryAmount = entryAmount;
        this.entryDetail = entryDetail;
        this.inputDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "HistoryLog{" +
                "entryNo=" + entryNo +
                ", entryDate=" + entryDate +
                ", entryType='" + entryType + '\'' +
                ", entryDivision='" + entryDivision + '\'' +
                ", entryAmount=" + entryAmount +
                ", entryDetail='" + entryDetail + '\'' +
                ", inputDate=" + inputDate +
                '}';
    }

}
