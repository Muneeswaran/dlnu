package com.myitbbs.service;

import com.myitbbs.model.User;

public interface LoginService {
	/**
	 * @param userName �û���
	 * @param password �û�����
	 * @param permission �û�Ȩ��
	 * @return 
	 */
	public User login(String userName,String password);
}
