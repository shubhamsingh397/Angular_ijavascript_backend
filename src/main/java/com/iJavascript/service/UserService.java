package com.iJavascript.service;

import com.iJavascript.model.User;

public interface UserService {
	
	public User getUserDetails(String userId);
	public User authenticateUser(String id, String password);
	public User addUser(User user);
}
