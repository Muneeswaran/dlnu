package com.myitbbs.action;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.constant.Constant;
import com.myitbbs.model.User;
import com.myitbbs.service.LoginService;
import com.myitbbs.uitl.Md5Util;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope("prototype")
public class LoginAction extends ActionSupport {

	private Map session;
	private String userName;
	private String userPassword;
	private User user;
	private LoginService loginService;
	
	public String doLogin() {
		session = ActionContext.getContext().getSession();
		if (userName.equals("") || userName == null) {
			session.put("tip",Constant.LOGIN_FAIL);
			return "login_fail";
		} else {
			user = loginService.login(userName, userPassword);
			if (user != null) {
				session.put("userName", userName);
				
				session.put("userId", user.getId());
				session.put("permission", user.getPermission());
				return "login_success";
			} else {
				session.put("tip",Constant.LOGIN_FAIL);
				return "login_fail";
			}
		}
	}
	
	public String toLoginPage(){
		return "toLoginPage";
	}

	@Resource(name="loginServiceImpl")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		try {
			this.userName = new String(userName.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = Md5Util.MD5(userPassword);
	}
	
	
}
