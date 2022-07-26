package com.example.HomeLoan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.HomeLoan.model.LoanAccount;
import com.example.HomeLoan.model.SavingAccount;
import com.example.HomeLoan.model.Users;

@Repository
public interface SavingAccountRepositiory extends JpaRepository<SavingAccount, Integer> {

	// SavingAccount findbyUser(Users user);
	
	
	@Query("SELECT a FROM SavingAccount a WHERE a.user.userId = :userid")
	SavingAccount findSavingAccountByUserid(@Param("userid") Integer userid);
	
	SavingAccount findByAccountno(Long accountno);
	
	//Count of Rows code
	@Query(value="SELECT count(sequenceId) FROM SavingAccount r WHERE r.user.userId = :userid")
	public long  countofSA(long userid);

}
