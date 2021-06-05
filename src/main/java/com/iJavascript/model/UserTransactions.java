package com.iJavascript.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String desc;
	private Date date;
	private int amount;
	
	@ManyToOne
	@JsonBackReference
	private User user;
}
