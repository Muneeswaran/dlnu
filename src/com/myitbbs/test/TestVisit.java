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
		System.out.println("�ܷ�������"+vdao.findALL());
		System.out.println("���·�������"+vdao.findCURMONTH());
		System.out.println("���ܷ�������"+vdao.findCURWEEK());
		System.out.println("�����������"+vdao.findCURDATE());
		System.out.println("���7���������"+vdao.findLATE7DAYS());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
}
