package com.hcl.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.dao.UserDaoImpl;
import com.hcl.model.User;
import com.hcl.repository.UserRepository;
import com.hcl.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController{

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	UserRepository repo;

	@RequestMapping(value = { "/", "/signin" }, method = RequestMethod.GET)
	public ModelAndView userSignIn() {
		ModelAndView model = new ModelAndView();

		model.setViewName("signin");
		return model;
	}
	
	@RequestMapping(value = { "/validate" }, method = RequestMethod.POST)
	public ModelAndView dbValidate(@ModelAttribute("uservalidate") User user) {
		User user2 = new User();
		ModelAndView model = new ModelAndView();
		
		user2 = repo.findByUserName(user.getUserName());
		if(user2!=null)
		{
			if((user.getUserPassword()).equals(user2.getUserPassword()))
			{
				model.setViewName("welcome");
				return model;
			}
			model.addObject("error", "invalid password");
			model.setViewName("signin");
			return model;
		}
//		model.addObject("Status", "Invalid UserName & Password");
//		model.setViewName("signin");
		return null;
	}

	@GetMapping("/welcome")
	public String sayWelcome() {
		return "CS";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addUser() {
		ModelAndView model = new ModelAndView();

		User user = new User();
		model.addObject("userForm", user);

		model.setViewName("user_form");
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveOrUpdate(@ModelAttribute("userForm") User user) {

		userServiceImpl.userSignUp(user);

		System.out.println("SignUp Done");
		return new ModelAndView("redirect:/user/signin");
	}

}
