package org.lrf.blogadmin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lrf.blogadmin.entity.User;
import org.lrf.blogadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
    private MessageSource messageSource;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path= {"/home"})
	public String home() {
		return "main";
	}
	
	@RequestMapping(path= {"/show_login"})
	public ModelAndView showLogin(@RequestParam(value="error",required=false)Object errorCode) {
		return new ModelAndView("login","error",errorCode);
	}
	
	@RequestMapping(path= {"/login"})
	public ModelAndView login(User user,HttpServletRequest request) {
		return userService.login(user,request.getSession()) ? new ModelAndView("redirect:/home") : new ModelAndView("redirect:/show_login","error",1);
	}
	
}
