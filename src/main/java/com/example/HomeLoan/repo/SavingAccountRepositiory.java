package com.example.HomeLoan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HomeLoan.model.SavingAccount;
import com.example.HomeLoan.model.Users;

public interface SavingAccountRepositiory extends JpaRepository<SavingAccount, Integer> {

	// SavingAccount findbyUser(Users user);

}
