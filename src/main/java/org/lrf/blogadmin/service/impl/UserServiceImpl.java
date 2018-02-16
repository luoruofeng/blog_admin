package org.lrf.blogadmin.service.impl;

import org.lrf.blogadmin.entity.User;
import org.lrf.blogadmin.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

	@Value("${admin.username}")
	private String username;
	
	@Value("${admin.password}")
	private String password;
	
	@Override
	public boolean login(User user) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		return true;
	}

}
