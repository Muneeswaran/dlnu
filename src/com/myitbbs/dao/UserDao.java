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

	public boolean delete(int id);//ͨ��idɾ��

	public boolean delete(User user);//ͨ��ʵ����ɾ��

	public int countAll();//��������
	public int countAllManager();//��������
	public int countAllNotManager();//��������

	public User existById(int id);//ͨ��id�ж��Ƿ����

	public List<User> existByName(String name);//ͨ�������ж��Ƿ����

	public boolean save(User user);//ͨ��ʵ���ౣ��

	public User get(int id);//ͨ��id��ȡʵ��

	public boolean update(User user);//ͨ��ʵ�����

	public List<User> findPage(Pager p);//�����з�ҳ����
	public List<User> findManager(Pager p);//�����з�ҳ����
	public List<User> findNotManager(Pager p);//�����з�ҳ����

	public List<User> get(String name);//ͨ�����ֻ�ȡ

	
}
