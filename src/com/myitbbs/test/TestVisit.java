package com.myitbbs.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myitbbs.dao.VisitDao;
import com.myitbbs.model.Visit;


public class TestVisit {
	public static ApplicationContext applicationContext;
	public static VisitDao vdao;
	@BeforeClass
	public static void beforClass(){
	 applicationContext = new ClassPathXmlApplicationContext(
		"beans.xml");
	vdao = (VisitDao) applicationContext.getBean("visitDaoImpl");
	}
	@Test
	public void test(){
	
	try {
		vdao.save(new Visit());
		System.out.println("总访问量："+vdao.findALL());
		System.out.println("本月访问量："+vdao.findCURMONTH());
		System.out.println("本周访问量："+vdao.findCURWEEK());
		System.out.println("今天访问量："+vdao.findCURDATE());
		System.out.println("最近7天访问量："+vdao.findLATE7DAYS());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
}
