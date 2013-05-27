package com.myitbbs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.myitbbs.model.Category;


public interface CategoryDao {
	public boolean delete(int id);//通过ID删除模块

	public boolean delete(Category category);//通过实体删除模块

	public List<Category> findAll();//查找所有的模块

	public boolean save(Category category);//通过实体删除模块

	public Category get(int id);//通过id取得实体

	public boolean update(Category category);//通过实体更新

	public List<Category> findPage(int page, int number);//分页查找

	
}
