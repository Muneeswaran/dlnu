package com.myitbbs.action;

import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.constant.Constant;
import com.myitbbs.model.User;
import com.myitbbs.service.serviceImpl.RegisterServiceImpl;
import com.myitbbs.vo.RegisterInfoVo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component
@Scope("prototype")
public class RegisterAction extends ActionSupport implements ModelDriven<RegisterInfoVo>{

	private RegisterInfoVo registerInfoVo = new RegisterInfoVo();
	private RegisterServiceImpl registerServiceImpl;
	private User user;
	
	public String toRegisterPage(){
		return "toRegisterPage";
	}
	
	public String doRegister(){
		if (check()){
			String dir = ServletActionContext.getServletContext().getRealPath("/uploadfiles");
			user.setSex(Constant.SEX);
			registerServiceImpl.save(user);
			registerInfoVo.setMessage("恭喜"+user.getName()+"注册成功");
			File file = new File(dir+"\\"+user.getId());
			if (file.exists()){
				file.delete();
			}
			else {
				file.mkdir();
			}
			return "register_success";
		}

		return "register_fail";
	}
	
	public boolean check(){
		boolean flag = true;
		user = new User();
		if (registerInfoVo.getUserName().equals("") || registerInfoVo.getUserPassword().equals("") || registerInfoVo.getUserPassword2().equals("") || registerInfoVo.getUserEmail().equals("")){
			flag = false;
			System.out.println("safsdafdsfsdfdsf");
			registerInfoVo.setTip("请将信息输入完全！");
			return flag;
		}
		user.setName(registerInfoVo.getUserName());
		if (!registerInfoVo.getUserPassword().equals(registerInfoVo.getUserPassword2())){
			flag = false;
			registerInfoVo.setTip("密码和确认密码不一致！");
			return flag;
		}
		user.setPassWord(registerInfoVo.getUserPassword());
		if (registerServiceImpl.checkName(registerInfoVo.getUserName())){
			flag = false;
			registerInfoVo.setTip("用户名已存在！");
			return flag;
		}
		user.setEmail(registerInfoVo.getUserEmail());
		return true;
	}
	
	public RegisterServiceImpl getRegisterServiceImpl() {
		return registerServiceImpl;
	}
	
	@Resource(name="registerServiceImpl")
	public void setRegisterServiceImpl(RegisterServiceImpl registerServiceImpl) {
		this.registerServiceImpl = registerServiceImpl;
	}

	public RegisterInfoVo getRegisterInfoVo() {
		return registerInfoVo;
	}

	public void setRegisterInfoVo(RegisterInfoVo registerInfoVo) {
		this.registerInfoVo = registerInfoVo;
	}

	public RegisterInfoVo getModel() {
		
		return registerInfoVo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
