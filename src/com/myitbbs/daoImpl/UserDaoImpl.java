package com.myitbbs.daoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.myitbbs.constant.Constant;
import com.myitbbs.dao.UserDao;
import com.myitbbs.model.User;
import com.myitbbs.uitl.Pager;

@Component("userDaoImpl")
@Scope("prototype")
public class UserDaoImpl implements UserDao {

	HibernateTemplate hibernateTemplate;

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean delete(User user) {// do
		User u = null;
		u = existById(user.getId());// 返回一个对象，对象要么为空要么存在
		if (u == null) {
			return false;
		} else {
			try {
				hibernateTemplate.delete(user);
				return true;
			} catch (Exception e) {
			
				e.printStackTrace();
				return false;
			}
		}
	}

	public User existById(int id) {// 通过Id去查找数据库是否存在这个实体
		User u = null;
		try {
			u = this.get(id);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return u;
	}

	public boolean update(User user) {// do
		System.out.println(user.getName() + "**");
		try {
			hibernateTemplate.update(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {// do
		System.out.println(id + "***");
		User user = this.existById(id);
		if (user == null) {
			return false;
		} else {
			try {
				hibernateTemplate.delete(user);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}
	}

	public List<User> findPage(final Pager p) {

		List<User> userList = null;

		try {
			userList = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query q = session
							.createQuery("from User");
					q.setFirstResult(p.getFirstResult());
					q.setMaxResults(p.getPageSize());
					List list = q.list();
					return list;
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return userList;
	}

	public User get(int id) {// do

		User u = null;
		try {
			u = (User) hibernateTemplate.get(User.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return u;

	}

	public boolean save(User user) {// do

		try {
			hibernateTemplate.save(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	public List<User> get(String name) {

		List<User> lu = null;
		try {
			lu = hibernateTemplate.find("from User where name=?", name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lu;
	}

	public List<User> existByName(String name) {
		List<User> lu = null;
		try {
			lu = this.get(name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lu;

	}

	public int countAll() {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from User ").get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}

	public int countAllManager() {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from User where  user_permission = "
							+ Constant.ADMIN_PERMISSION).get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}

	public int countAllNotManager() {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from User where  user_permission = "
							+ Constant.USER_PERMISSION).get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}

	public List<User> findManager(final Pager p) {
		List<User> userList = null;

		try {
			userList = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query q = session
							.createQuery("from User where user_permission = "
							+ Constant.ADMIN_PERMISSION);
					q.setFirstResult(p.getFirstResult());
					q.setMaxResults(p.getPageSize());
					List list = q.list();
					return list;
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return userList;
	}

	public List<User> findNotManager(final Pager p) {
		List<User> userList = null;

		try {
			userList = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query q = session
							.createQuery("from User where  user_permission = "
							+ Constant.USER_PERMISSION);
					q.setFirstResult(p.getFirstResult());
					q.setMaxResults(p.getPageSize());
					List list = q.list();
					return list;
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return userList;
	}

	

}
