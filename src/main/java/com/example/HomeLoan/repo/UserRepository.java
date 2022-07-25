package com.example.HomeLoan.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HomeLoan.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>  {

}
