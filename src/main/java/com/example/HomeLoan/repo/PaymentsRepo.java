package com.example.HomeLoan.repo;

import com.example.HomeLoan.model.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentsRepo extends CrudRepository<Repayment,Integer> {

    List<Repayment> getpaymentDetails (int loanaccountno);

    public Double updateEMIDetails(Double amount,int month,int year);


}
