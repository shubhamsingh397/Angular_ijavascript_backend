package com.iJavascript.service;

import java.util.Collection;

import com.iJavascript.model.UserTransactions;

public interface UserTransactionService {
	
	public UserTransactions addTransactions(UserTransactions trans, String userId);
	public Collection<UserTransactions> getTransactions(String userId);
}
