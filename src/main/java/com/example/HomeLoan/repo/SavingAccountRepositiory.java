package com.example.HomeLoan.repo;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 99a4d62c95ad322c30edd4be034c65000044e42d

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
	
<<<<<<< HEAD
	@Query(value="SELECT r FROM SavingAccount r WHERE r.user.userId = :userid")
		//Optional<SavingAccount> findById(@Param("userid") Integer user_id);	
		List<SavingAccount> findSavingAccByUserid(int userid);


	@Query("SELECT a FROM SavingAccount a WHERE a.user.userId = :userid")
	SavingAccount findSavingAccountByUserid(@Param("userid") Integer userid);
=======
	

	List<SavingAccount> findSavingAccountByUser(int userid);
>>>>>>> 99a4d62c95ad322c30edd4be034c65000044e42d
	
	SavingAccount findByAccountno(Long accountno);
	
	//Count of Rows code
	@Query(value="SELECT count(sequenceId) FROM SavingAccount r WHERE r.user.userId = :userid")
	public long  countofSA(long userid);

	SavingAccount findByAccountnoAndUser(Long accountNo, Users users);

}
