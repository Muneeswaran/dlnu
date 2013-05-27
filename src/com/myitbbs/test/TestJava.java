package com.myitbbs.test;



import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myitbbs.dao.SystemMessageDao;
import com.myitbbs.model.SystemMessage;
import com.myitbbs.model.User;

public class TestJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
		"beans.xml");
/*		UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
		MessageBoardDao mbDao = (MessageBoardDao) applicationContext.getBean("messageBoardDaoImpl");
		MessageBoard m = new MessageBoard();
		m.setContent("·��");
//		m.setDate(new Date(1));
	m.setReaded("1");
//		m.setId("6");
		User u1 = userService.getUser(1);
		System.out.println(u1.getName());
		User u2 = userService.getUser(2);
		System.out.println(u2.getName());
		m.setMaster(u1);
		m.setVisitor(u2);
		mbDao.save(m);

		SystemMessageDao sdao = (SystemMessageDao) applicationContext.getBean("systemMessageDaoImpl");
		SystemMessage s = new SystemMessage();
		s.setCheck("0");
		s.setDate(new Date());
		User u = new User();
		u.setId(3);
		s.setFriend(u);
		User u2 = new User();
		u2.setId(1);
		s.setMaster(u);
		try {
			sdao.save(s);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		int B = (int)  (Math.sqrt(2)*15);
		
	}
	
}
