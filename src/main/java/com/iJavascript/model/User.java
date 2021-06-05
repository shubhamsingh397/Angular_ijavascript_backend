package com.iJavascript.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userId;
	private String password;
	private String name;
	private Date lastLogin;
	private int balance;
	
	@OneToMany(mappedBy = "user")
	
	private Collection<UserTransactions> transactions = new ArrayList<UserTransactions>();
	
	
	
}
