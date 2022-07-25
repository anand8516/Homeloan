package com.example.HomeLoan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	@Column(name = "user_id")
//<<<<<<< HEAD
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer userId;
//	
//	@Column(name="user_name",unique = true)
//	private String username;
//	
//	@Column(name="user_firstname")
//	private String firstname;
//	
//	@Column(name="user_lastname")
//	private String lastname;

    @SequenceGenerator(name="SEQ_GEN", sequenceName="SEQ_JUST_FOR_TEST", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
	private Integer userId;	

	
	@Column(name="user_password")
	private String password;
	
	@Column(name="user_email",unique = true)
	private String email;
	
	@Column(name="user_phone")
	private Long phone;
	
	
}

