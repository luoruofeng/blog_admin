package org.lrf.blogadmin.controller;

import org.lrf.blogadmin.entity.User;
import org.lrf.blogadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path= {"/home"})
	public String home() {
		return "main";
	}
	
	@RequestMapping(path= {"/show_login"})
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping(path= {"/login"})
	@ResponseBody
	public boolean login(User user) {
		
		return userService.login(user);
	}
	
}
