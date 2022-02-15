package com.cashtrackloans.cashtracksloans.repository;

import com.cashtrackloans.cashtracksloans.domain.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LoanRepository {

    private final EntityManager em;

    // Get Loan list
    public List<Loan> findByUserNo(int userNo){
        return em.createQuery("select sa from Loan sa where sa.userNo = :userNo", Loan.class)
                .setParameter("userNo", userNo)
                .getResultList();
    }

    // Insert loan case
    public int insertLoan(Loan loan){
        em.persist(loan);
        return loan.getUserNo();
    }

    // delete loan case
    public int deleteLoan(Loan loan){
        int removeNo = loan.getUserNo();
        em.remove(loan);
        return removeNo;
    }
}
