package org.lrf.blogadmin.service.impl;

import javax.servlet.http.HttpSession;

import org.lrf.blogadmin.entity.User;
import org.lrf.blogadmin.service.UserService;
import org.lrf.blogadmin.util.Key;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("userService")
@PropertySource("classpath:admin.properties")
public class UserServiceImpl implements UserService {


	@Value("${admin.username}")
	private String username;
	
	@Value("${admin.password}")
	private String password;
	
	@Override
	public boolean login(User user,HttpSession session) {
		if(user== null || user.getUsername() == null || user.getPassword() == null) {
			return false;
		}
		if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
			session.setAttribute(Key.USER,user);
			return true;
		}
		return false;
	}

}
