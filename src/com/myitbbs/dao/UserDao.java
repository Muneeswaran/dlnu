package com.myitbbs.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.myitbbs.model.User;
import com.myitbbs.uitl.Pager;

public interface UserDao {
	// public boolean add(User user);
	// public boolean delete(User user);
	// public User findById(int id);
	// public User findByName(String name);
	// public boolean exist(User user);
	// public List<?> getAll();

	public boolean delete(int id);//通过id删除

	public boolean delete(User user);//通过实体类删除

	public int countAll();//查找所有
	public int countAllManager();//查找所有
	public int countAllNotManager();//查找所有

	public User existById(int id);//通过id判断是否存在

	public List<User> existByName(String name);//通过名字判断是否存在

	public boolean save(User user);//通过实体类保存

	public User get(int id);//通过id获取实体

	public boolean update(User user);//通过实体更新

	public List<User> findPage(Pager p);//对所有分页查找
	public List<User> findManager(Pager p);//对所有分页查找
	public List<User> findNotManager(Pager p);//对所有分页查找

	public List<User> get(String name);//通过名字获取

	
}
