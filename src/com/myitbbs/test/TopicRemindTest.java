package com.myitbbs.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myitbbs.dao.CommentDao;
import com.myitbbs.dao.TopicRemindDao;
import com.myitbbs.dao.UserDao;
import com.myitbbs.daoImpl.CommentDaoImpl;
import com.myitbbs.model.Topic;
import com.myitbbs.model.TopicRemind;
import com.myitbbs.model.User;
import com.myitbbs.service.TopicRemindService;
import com.myitbbs.service.serviceImpl.TopicRemindServiceImpl;
import com.myitbbs.uitl.Md5Util;
import com.myitbbs.uitl.Pager;


public class TopicRemindTest {
	public static ApplicationContext applicationContext;
	public static TopicRemindDao trDao;
	public static TopicRemindService trs;
	public static CommentDao cd;
	public static UserDao udao;
	@BeforeClass
	public static void beforClass(){
	 applicationContext = new ClassPathXmlApplicationContext(
		"beans.xml");
	 trDao = (TopicRemindDao) applicationContext.getBean("topicRemindDaoImpl");
	 trs = (TopicRemindServiceImpl) applicationContext.getBean("topicRemindServiceImpl");
	 cd = (CommentDaoImpl) applicationContext.getBean("commentDaoImpl");
	 udao = (UserDao) applicationContext.getBean("userDaoImpl");
	}
	@Test
	public void save(){
		TopicRemind tr = new TopicRemind();
		User u = new User();
		u.setId(1);
		Topic t = new Topic();
		t.setId(20);
		tr.setT(t);
		tr.setU(u);
		try {
			trDao.save(tr);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Test
	public void Count(){
		try {
			int count = trDao.CountNew(1);
			System.out.println(count);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Test
	public void findAndDelete(){
		List<TopicRemind> ltr = null;
		try {
			
			ltr = trDao.find(1, 20);
			for(TopicRemind t : ltr){
			System.out.println(t.getId());
			}
			trDao.delete(ltr);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Test
	public void Service(){
//		Comment c = cd.get(17);
//		trs.remindByReply(c);
		//System.out.println(Md5Util.MD5("sadas"));
		List<User> lu = udao.findPage(new Pager(1,100,100));
		String str = null;
		for(User u : lu){
			str = Md5Util.MD5(u.getPassWord());
			u.setPassWord(str);
			udao.update(u);
		}
	}
	@Test
	public void testAll(){
		try {
//			System.out.println(trDao.getTopicByComment(1).getId());
//			System.out.println(trDao.getCommentAuther(11).getId());
//			List<User> lu = trDao.findJionReply(15, 1, 2);
			List<Topic> lt  = trDao.findTopicByRemind(1);
//			for(User u : lu){
//			System.out.println(u.getId());
//			}
			for(Topic u : lt){
				System.out.println(u.getId());
				}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
