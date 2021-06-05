package com.iJavascript.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iJavascript.model.User;
import com.iJavascript.service.UserService;

@RestController
@CrossOrigin(origins="*")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user)
	{
		return service.addUser(user);
	}
	@GetMapping("/user/{id}")
	public User getUserDetails(@PathVariable("id") String userId)
	{
		//System.out.println(userId);
		return service.getUserDetails(userId);
	}
	
	@GetMapping("/authenticate/{id}/{pass}")
	public ResponseEntity<?> authenticateUser(@PathVariable("id") String Id,@PathVariable("pass")String password)
	{
		User user = service.authenticateUser(Id, password);
		
		if(user==null)
			return   ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong Credentials");
		else return ResponseEntity.ok(user);
	}
}
