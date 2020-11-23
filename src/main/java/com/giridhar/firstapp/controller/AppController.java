package com.giridhar.firstapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.giridhar.firstapp.model.User;
import com.giridhar.firstapp.services.UserService;

@Controller
public class AppController {

	private UserService us;

	@Autowired
	public void setUserService(UserService us) {
		this.us = us;
	}

	
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "commonpage";
	}
	
	@RequestMapping("/register")
	public String register (HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "commonpage";
	}
	
	@RequestMapping("/login")
	public String login (HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "commonpage";
	}

	@PostMapping("/saveUser")
	public String saveUser(
			@RequestParam String name, 
			@RequestParam String userName, 
			@RequestParam String password,
			HttpServletRequest request
	) {
		User user = new User(name, userName, password);
		us.saveUserToDB(user);
		request.setAttribute("mode", "MODE_LOGIN");
		return "commonpage";
	}
	
	@PostMapping("/checkUser")
	public String checkUser(@ModelAttribute User user, 
			HttpServletRequest request, 
			HttpSession session
	) {
		User myUser = us.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		if (myUser != null) {
			session.setAttribute("loggedIn", true);
			session.setAttribute("userName", myUser.getUserName());
			request.setAttribute("mode", "MODE_LOGGEDIN");
			System.out.println(myUser);
			return "dashboard";
		} else {
			session.setAttribute("loggedIn", false);
			request.setAttribute("mode", "MODE_LOGIN");
			return "commonpage";
		}
	}
	
	@RequestMapping("/logout")
	public void logout(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session
	) {
		session.removeAttribute("loggedIn");
		session.removeAttribute("userName");
		request.setAttribute("mode", "MODE_HOME");
		try {
			response.sendRedirect("/");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	@RequestMapping("/dashboard")
	public String showDashboard() {
		return "dashboard";
	}

}
