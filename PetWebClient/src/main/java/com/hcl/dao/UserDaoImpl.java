package com.hcl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.model.User;
import com.hcl.repository.UserRepository;

@Component
public class UserDaoImpl {

	@Autowired
	UserRepository userRepositoryImpl;

	public void userSignUp(User user) {
		userRepositoryImpl.save(user);
	}

	public boolean userSignIn(String userName, String userPassword) {
		boolean status = false;

		for (User user : userRepositoryImpl.findAll()) {
			if (user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword)) {
				status = true;
			}
		}
		return status;
	}
}
