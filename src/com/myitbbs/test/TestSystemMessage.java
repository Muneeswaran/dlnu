package com.myitbbs.test;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myitbbs.dao.SystemMessageDao;
import com.myitbbs.model.SystemMessage;
import com.myitbbs.model.User;
import com.myitbbs.uitl.Pager;


public class TestSystemMessage {
	public static ApplicationContext applicationContext;
	public static SystemMessageDao sdao;
	@BeforeClass
	public static void beforClass(){
	 applicationContext = new ClassPathXmlApplicationContext(
		"beans.xml");
	  sdao = (SystemMessageDao) applicationContext.getBean("systemMessageDaoImpl");
	}
	@Test
	public void testSava(){
		
		SystemMessage s = new SystemMessage();
		s.setCheck("0");
		s.setDate(new Date());
		User u = new User();
		u.setId(3);
		s.setFriend(u);
		User u2 = new User();
		u2.setId(2);
		s.setMaster(u2);
		try {
			sdao.save(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdate(){
		try {
			SystemMessage s = sdao.getObject(2);
			s.setCheck("1");
			sdao.update(s);
		} catch (Exception e) {
e.printStackTrace();
		}
	}
	@Test
	public void testQurey(){
		try {
			Pager p = new Pager(1, 10, 10);
			List<SystemMessage> ls = sdao.find(2, p);
			for(SystemMessage s : ls){
				System.out.println(s);
			}
			System.out.println(sdao.countOfNotCheck(2));
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	@Test
	public void testGet(){
		try {
			System.out.println(sdao.getComment(2, 5));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
