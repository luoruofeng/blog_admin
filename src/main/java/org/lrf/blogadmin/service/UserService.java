package org.lrf.blogadmin.service;

import javax.servlet.http.HttpSession;

import org.lrf.blogadmin.entity.User;

public interface UserService {
	public boolean login(User user,HttpSession session);
}
