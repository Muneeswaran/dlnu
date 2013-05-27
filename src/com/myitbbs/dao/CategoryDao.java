package com.myitbbs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.myitbbs.model.Category;


public interface CategoryDao {
	public boolean delete(int id);//ͨ��IDɾ��ģ��

	public boolean delete(Category category);//ͨ��ʵ��ɾ��ģ��

	public List<Category> findAll();//�������е�ģ��

	public boolean save(Category category);//ͨ��ʵ��ɾ��ģ��

	public Category get(int id);//ͨ��idȡ��ʵ��

	public boolean update(Category category);//ͨ��ʵ�����

	public List<Category> findPage(int page, int number);//��ҳ����

	
}
