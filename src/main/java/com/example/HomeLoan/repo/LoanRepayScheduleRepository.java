package com.example.HomeLoan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.HomeLoan.model.Repayment;
@Repository
public interface LoanRepayScheduleRepository extends JpaRepository<Repayment, Integer> {
	
//	List<Repayment> findLoanRepayScheduleByLoanAccountId(Long accountNo);
	
}
