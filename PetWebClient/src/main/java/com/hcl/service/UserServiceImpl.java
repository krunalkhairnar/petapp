package com.hcl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.UserDaoImpl;
import com.hcl.model.User;

@Service
public class UserServiceImpl {

	@Autowired
	UserDaoImpl userDaoImpl;

	public void userSignUp(User user) {
		userDaoImpl.userSignUp(user);
	}

	public boolean userSignIn(String userName, String userPassword) {
		return userDaoImpl.userSignIn(userName, userPassword);
	}
}
