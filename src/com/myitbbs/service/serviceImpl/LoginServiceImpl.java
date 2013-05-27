package com.myitbbs.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.service.LoginService;
import com.myitbbs.dao.UserDao;
import com.myitbbs.model.User;

/**
 * 
 * @author Administrator
 *
 */
@Component("loginServiceImpl")
@Scope("prototype")
public class LoginServiceImpl implements LoginService{
	
	
	private UserDao userDaoImpl;
	
	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}
	@Resource(name = "userDaoImpl")
	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	/**
	 * @param userName 用户名
	 * @param password 用户密码
	 * @return 
	 */
	public User login(String userName,String password){
		System.out.println(userName + password);
		List<User> user = userDaoImpl.get(userName);
		if (user == null || user.size()==0){
			System.out.println(userName + password);
			return null;
		}
		System.out.println(user.get(0));
		String userPassword = user.get(0).getPassWord();
		if(userPassword.equals(password)){
			return user.get(0);
		}else{
			return null;		
		}
	}
}
