package com.iJavascript.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iJavascript.model.User;
import com.iJavascript.model.UserTransactions;

public interface UserTransactionDao extends JpaRepository<UserTransactions, Long>{

	@Query
	public Collection<UserTransactions> findByUser(User user);
}
