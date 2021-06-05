package com.iJavascript.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iJavascript.model.UserTransactions;
import com.iJavascript.service.UserTransactionService;

@RestController
@CrossOrigin(origins="*")
public class UserTransactionController {

	@Autowired
	private UserTransactionService service;
	
	@PostMapping("/addTrans/{id}")
	public UserTransactions addTransactions(@RequestBody UserTransactions trans,@PathVariable("id") String userId)
	{
		return service.addTransactions(trans, userId);
	}
	
	@GetMapping("/trans/{id}")
	public Collection<UserTransactions> getTransactions(@PathVariable("id") String userId)
	{
		return service.getTransactions(userId);
	}
	
}
