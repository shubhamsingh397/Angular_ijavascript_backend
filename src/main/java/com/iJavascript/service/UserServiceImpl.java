package com.iJavascript.service;

import java.sql.Date;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iJavascript.dao.UserDao;
import com.iJavascript.model.User;
import com.iJavascript.model.UserTransactions;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao; 
	@Autowired
	private UserTransactionService transService ;
	
	@Override
	public User getUserDetails(String userId) {
		// TODO Auto-generated method stub
		User user = dao.findByUserId(userId);
		Collection<UserTransactions> transactions = transService.getTransactions(userId);
		Iterator<UserTransactions> itr = transactions.iterator();
		Integer amount = 0;
		while(itr.hasNext())
		{
			amount = amount + itr.next().getAmount();
		}
		user.setBalance(amount);
		User user2 = dao.save(user);
		return user2;
	}

	@Override
	public User authenticateUser(String id, String password) {
		// TODO Auto-generated method stub
		User user = dao.findByUserId(id);
		if(user.getPassword().equals(password)) {
			user.setLastLogin(new Date(System.currentTimeMillis()));
			Collection<UserTransactions> transactions = transService.getTransactions(id);
			Iterator<UserTransactions> itr = transactions.iterator();
			Integer amount = 0;
			while(itr.hasNext())
			{
				amount = amount + itr.next().getAmount();
			}
			user.setBalance(amount);
			User user2 = dao.save(user);
			return user2;
		}
		else
			return null;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

}
