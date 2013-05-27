package com.myitbbs.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class QuitAction {
	private Map session;
	
	public String execute(){
		try{
		session = ActionContext.getContext().getSession();

			session.remove("userId");
			session.remove("userName");		
			return "success";
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "success";
	}
}
