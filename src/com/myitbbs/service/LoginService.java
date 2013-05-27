package com.myitbbs.service;

import com.myitbbs.model.User;

public interface LoginService {
	/**
	 * @param userName 用户名
	 * @param password 用户密码
	 * @param permission 用户权限
	 * @return 
	 */
	public User login(String userName,String password);
}
