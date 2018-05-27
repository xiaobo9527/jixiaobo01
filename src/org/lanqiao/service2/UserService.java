package org.lanqiao.service2;

import org.lanqiao.dao2.UserDao;
import org.lanqiao.enity2.User;

public class UserService {
	public User findUserByUsername(String username) {
		UserDao dao = new UserDao();
		
		return dao.findUserByUsername(username);
	}
}
