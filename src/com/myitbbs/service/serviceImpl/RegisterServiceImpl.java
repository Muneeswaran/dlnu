package com.myitbbs.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.UserDao;
import com.myitbbs.model.User;
import com.myitbbs.service.RegisterService;
@Component("registerServiceImpl")
@Scope("prototype")
public class RegisterServiceImpl implements RegisterService {
	private UserDao userDaoImpl;
	public UserDao getUserDaoImpl() {
	return userDaoImpl;
}
	@Resource(name = "userDaoImpl")
public void setUserDaoImpl(UserDao userDaoImpl) {
	this.userDaoImpl = userDaoImpl;
}

	public boolean checkName(String userName) {
		List<User> userList = null;
		try {
			userList = userDaoImpl.get(userName);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(userList.size() != 0){//�����ַ���true
			return true;
		}else{//û�����ַ���false
		return false;
	}
	}
	public void save(User user) {
		try {
			userDaoImpl.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
