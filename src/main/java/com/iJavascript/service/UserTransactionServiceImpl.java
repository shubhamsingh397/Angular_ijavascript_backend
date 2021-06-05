package com.iJavascript.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iJavascript.dao.UserDao;
import com.iJavascript.dao.UserTransactionDao;
import com.iJavascript.model.User;
import com.iJavascript.model.UserTransactions;
@Service
public class UserTransactionServiceImpl implements UserTransactionService{

	@Autowired
	private UserTransactionDao dao;
	@Autowired
	private UserDao userDao;
	@Override
	public UserTransactions addTransactions(UserTransactions trans, String userId) {
		// TODO Auto-generated method stub
		User user = userDao.findByUserId(userId);
		trans.setDate(new Date(System.currentTimeMillis()));
		Collection<UserTransactions> transactions = new ArrayList<UserTransactions>();
		 transactions.add(trans);
		user.setTransactions(transactions);
		trans.setUser(user);
		UserTransactions transObj = dao.save(trans);
		userDao.save(user);
		return transObj;
	}

	@Override
	public Collection<UserTransactions> getTransactions(String userId) {
		// TODO Auto-generated method stub
		
		return dao.findByUser(userDao.findByUserId(userId));
	}

}
