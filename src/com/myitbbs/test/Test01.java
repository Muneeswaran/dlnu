package com.myitbbs.test;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myitbbs.dao.CategoryChildDao;
import com.myitbbs.dao.FriendDao;
import com.myitbbs.dao.SystemMessageDao;
import com.myitbbs.dao.TopicDao;
import com.myitbbs.dao.UserReadTopicDao;
import com.myitbbs.model.CategoryChild;
import com.myitbbs.model.Friend;
import com.myitbbs.model.SystemMessage;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.service.PageInfoService;
import com.myitbbs.service.UserService;
import com.myitbbs.uitl.Pager;


public class Test01 {
	public static ApplicationContext applicationContext;
@BeforeClass
public static void beforClass(){
 applicationContext = new ClassPathXmlApplicationContext(
	"beans.xml");
}
@Test
public void addTopic(){
	TopicDao topicDaoImpl = (TopicDao) applicationContext.getBean("topicDaoImpl");
	
	CategoryChildDao categorychildDaoImpl = (CategoryChildDao) applicationContext.getBean("categoryChildDaoImpl");
	CategoryChild cch = categorychildDaoImpl.get(1);
	Topic t = null;
	String content = "hahahahaha";
	String key1 = "java";
	String key2 = "c++";
	
	UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
	User u = userService.getUser(1);
	
	for(int i = 0; i < 10; i++){
		int x = i % 3;
		t = new Topic();
		if(x == 0){
			t.setContents(key1+content);
		}else if(x == 1){
			t.setContents(content+key2);
		}else{
			t.setContents(key1+content+key2);
		}
		t.setCategoryChild(cch);
		t.setTitle("title"+i);
		t.setUser(u);
		t.setReadOrNot("0");
		t.setTop("0");
		t.setDate(new Date());
		topicDaoImpl.save(t);
	}
}
@Test
public void findTopicByKey(){
	TopicDao topicDaoImpl = (TopicDao) applicationContext.getBean("topicDaoImpl");
	String key1 = "java";
	String key2 = "c++";
	Pager p = new Pager(1, 10, 10);
	List<Topic> lt = topicDaoImpl.findByKey(p, key1);
	System.out.println("=========="+key1+"============");
	for(int i=0; i<lt.size();i++){
		System.out.println("*********************");
		System.out.println("标题："+lt.get(i).getTitle());
		System.out.println("内容："+lt.get(i).getContents());
		System.out.println("*********************");
	}
	int count = topicDaoImpl.countOfKey(key1);
	System.out.println("=========="+count+"============");
	lt = topicDaoImpl.findByKey(p, key2);
	System.out.println("=========="+key2+"============");
	for(int i=0; i<lt.size();i++){
		System.out.println("*********************");
		System.out.println("标题："+lt.get(i).getTitle());
		System.out.println("内容："+lt.get(i).getContents());
		System.out.println("*********************");
	}
	count = topicDaoImpl.countOfKey(key2);
	System.out.println("=========="+count+"============");
}
@Test
public void testFriend(){
	Pager p = new Pager(1, 10, 10); 
	FriendDao friendDaoImpl = (FriendDao) applicationContext.getBean("friendDaoImpl");
	List<User> lu = friendDaoImpl.findIgnoreGroup(p, 1);
	
	for(int i=0; i<lu.size();i++){
		System.out.println("好友"+i+1+"、"+lu.get(i).getName());
	}
	
}
@Test			
public void testTopicGlory(){
	FriendDao friendDaoImpl = (FriendDao) applicationContext.getBean("friendDaoImpl");
	List<User> lu = friendDaoImpl.topicGlory();
	for(int i=0; i<lu.size();i++){
		System.out.println("好友"+i+1+"、"+lu.get(i).getName());
	}
	
}
@Test			
public void testResourceGlory(){
	FriendDao friendDaoImpl = (FriendDao) applicationContext.getBean("friendDaoImpl");
//	List<User> lu = friendDaoImpl.resourceGlory();
//	for(int i=0; i<lu.size();i++){
//		System.out.println("好友"+i+1+"、"+lu.get(i).getName());
//	}
	System.out.println("111222");
	Friend f = friendDaoImpl.getFriend(1, 4);
	System.out.println("222111");
	System.out.println(f.getMaster().getId()+"------"+f.get_friend().getId());
	
}
@Test
public void testUserReadTopic(){
	UserReadTopicDao urtDao = (UserReadTopicDao) applicationContext.getBean("userReadTopicDaoImpl");
	User u = urtDao.qurey(172);
	System.out.println(u);
//	System.out.println(u.getName());
}
@Test
public void testUserHadRead(){
	TopicDao topicDaoImpl = (TopicDao) applicationContext.getBean("topicDaoImpl");
	List<Topic> lt = topicDaoImpl.userHadRead(2, 172);
	for(int i=0; i<lt.size();i++){
		System.out.println("*********************");
		System.out.println("ID："+lt.get(i).getId());
		System.out.println("标题："+lt.get(i).getTitle());
		System.out.println("内容："+lt.get(i).getContents());
		System.out.println("*********************");
	}
}
@Test
public void testSava(){
	SystemMessageDao sdao = (SystemMessageDao) applicationContext.getBean("systemMessageDaoImpl");
	SystemMessage s = new SystemMessage();
	s.setCheck("0");
	s.setDate(new Date());
	User u = new User();
	u.setId(2);
	s.setFriend(u);
	u.setId(1);
	s.setMaster(u);
	try {
		sdao.save(s);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
@Test
public void xxx(){
	TopicDao topicDaoImpl = (TopicDao) applicationContext.getBean("topicDaoImpl");
	try {
		
		Pager p = new Pager(1, 100, 100);
		
		List<Topic> lt = topicDaoImpl.findByUser(p, 1);
		for (Topic t : lt) {
			System.out.println(t);
		}
	} catch (Exception e) {
e.printStackTrace();
	}
}
@Test
public void XXX2(){
//	PageInfoService pageInfoServiceImpl = (PageInfoService) applicationContext.getBean("pageInfoServiceImpl");
//	List<Topic> lt = pageInfoServiceImpl.userHadReadTopic(172);
//	for (Topic t : lt) {
//		System.out.println(t);
//	}
	
}
}
