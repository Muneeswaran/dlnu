package com.myitbbs.daoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.myitbbs.constant.Constant;
import com.myitbbs.dao.NewsDao;

import com.myitbbs.model.News;
import com.myitbbs.uitl.Pager;

@Component("newsDaoImpl")
@Scope("prototype")
public class NewsDaoImpl implements NewsDao {
	HibernateTemplate hibernateTemplate;

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean update(News news) {
		try {
			hibernateTemplate.update(news);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(int id) {
		News news = null;
		try {
			news = (News) hibernateTemplate.get(News.class, id);
			if (news != null) {
				hibernateTemplate.delete(news);
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {		
			e.printStackTrace();
			return false;
		}

		

	}

	public boolean delete(News news) {
		if (this.get(news.getId()) != null) {
			try {
				hibernateTemplate.delete(news);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	

	public News get(int id) {

		News news = null;
		try {
			news = (News) hibernateTemplate.get(News.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return news;
	}

	public boolean save(News news) {
		try {
			hibernateTemplate.save(news);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	public List<News> existByName(String name) {
		List<News> li = null;
		try {
			li = hibernateTemplate.find("from News where name=?", name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
	}

	public List<News> findByCategoryId(final Pager p,final int id) {
		List<News> newsList = null;
	
		try {
			
			newsList = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query q = session.createQuery("from News where news_category_id="+id+"order by news_id desc");
					q.setFirstResult(p.getFirstResult());
					q.setMaxResults(p.getPageSize());
					List list = q.list();
					return list;
				}});
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
		return newsList;
	}

	

	public List<News> findByName(String name) {
		List<News> li = null;
		try {
			li = hibernateTemplate.find(
					"from News where name=? order by news_id desc", name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
	}

	public List<News> findAllDesc(final Pager p) {
		List<News> li = null;
	
		try {
			li = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
                   Query q = session.createQuery("from News order by news_id desc");
                   q.setFirstResult(p.getFirstResult());
                   q.setMaxResults(p.getPageSize());
                   List list = q.list();
					return list;
				}});
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return li;
	}

	public int countAllNews() {
             int count = 0;
             try {
				count = Integer.parseInt(hibernateTemplate.find("select Count(*) from News").get(0).toString());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DataAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return count;
	}

	public int countCNews(int id) {
		  int count = 0;
          try {
				count = Integer.parseInt(hibernateTemplate.find("select Count(*) from News where news_category_Id ="+id).get(0).toString());
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (DataAccessException e) {
				
				e.printStackTrace();
			}
		return count;
	}

	public List<News> lateCategoryNews(final int id) {
		List<News> newsList = null;
		
		try {
			
			newsList = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query q = session.createQuery("from News where news_category_id="+id+"order by news_id desc");
					q.setFirstResult(0);
					q.setMaxResults(Constant.LATE_NEWS);
					List list = q.list();
					return list;
				}});
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		
		return newsList;
	}

	public List<News> lateNews() {
		List<News> li = null;
		
		try {
			li = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
                   Query q = session.createQuery("from News order by news_id desc");
                   
                   q.setFirstResult(0);
                   q.setMaxResults(Constant.LATE_NEWS);
            
                   List list = q.list();
     
					return list;
				}});
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	
		return li;
	}

public List<News> findByKey(final Pager p,final String key) {
List<News> li = null;
		
		try {
			li = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					String key1 = "%"+key+"%";
                   Query q = session.createQuery("from News where news_name like '"+key1+"' or news_content like '"+key1+"' order by news_id desc");
                
                   q.setFirstResult(p.getFirstResult());
                   q.setMaxResults(p.getPageSize());
                   List list1 = q.list();
					return list1;
				}});
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return li;
	}

public int countOfKey(String key) {
	String key1 = "%"+key+"%";
	return Integer.parseInt(this.hibernateTemplate.find("select Count(*) from News where news_name like '"+key1+"' or news_content like '"+key1+"'").get(0).toString());
	
}


}
