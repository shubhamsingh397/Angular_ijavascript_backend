package com.iJavascript.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iJavascript.model.User;

@Repository
public interface UserDao extends JpaRepository<User,Long>{

	@Query
	public User findByUserId(String id);
}
