package com.myitbbs.vo;

import java.io.UnsupportedEncodingException;

import com.myitbbs.uitl.Md5Util;

public class RegisterInfoVo {
	
	private String userName = null;
	private String userPassword = null;
	private String userPassword2 = null;
	private String userEmail = null;
	private String tip = null;
	private String message;
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getUserPassword2() {
		return userPassword2;
	}
	public void setUserPassword2(String userPassword2) {
		this.userPassword2 = Md5Util.MD5(userPassword2);
	}
	
}
