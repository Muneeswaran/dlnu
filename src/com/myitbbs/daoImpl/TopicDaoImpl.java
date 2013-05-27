package com.myitbbs.daoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.myitbbs.constant.Constant;
import com.myitbbs.dao.TopicDao;
import com.myitbbs.model.Topic;
import com.myitbbs.uitl.Pager;

@Component("topicDaoImpl")
@Scope("prototype")
public class TopicDaoImpl implements TopicDao {
	HibernateTemplate hibernateTemplate;

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean update(Topic topic) {
		try {
			hibernateTemplate.update(topic);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(int id) {
		Topic topic = this.existById(id);

		try {

			hibernateTemplate.delete(topic);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	public Topic existById(int id) {
		Topic t = null;
		try {
			t = (Topic) hibernateTemplate.get(Topic.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t;
	}

	public boolean delete(Topic topic) {
		Topic t = null;
		t = this.get(topic.getId());// 返回一个对象，对象要么为空要么存在
		if (t == null) {
			return false;
		} else {
			try {
				hibernateTemplate.delete(topic);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	

	public Topic get(int id) {
		Topic t = null;
		try {
			t = (Topic) hibernateTemplate.get(Topic.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t;
	}

	public boolean save(Topic topic) {
		try {
			hibernateTemplate.save(topic);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Topic> findByUser(final Pager p, final int id) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					Query query = s
							.createQuery("from Topic as t where t.user.id = "
									+ id + " order by t.date desc");
					query.setFirstResult(p.getFirstResult());
					query.setMaxResults(p.getPageSize());
					List list = query.list();
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}

	public boolean deleteByName(String name) {
		try {
			Topic t = (Topic) hibernateTemplate.find("from Topic as t where t.name=?",
					name);
			hibernateTemplate.delete(t);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	/**********************************/
	public List<Topic> findByCategoryChildId(final Pager p,
			final int id) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					Query query = s
							.createQuery("from Topic as t where t.categoryChild.id = "
									+ id + " order by t.date desc");
					query.setFirstResult(p.getFirstResult());
					query.setMaxResults(p.getPageSize());
					List list = query.list();
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}

	public List<Topic> findByTitleByDesc(final Pager p,
			final String title) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					Query query = s
							.createQuery("from Topic where topic_top = 0 and topic_title = "
									+ title + " order by topic_date desc");
					query.setFirstResult(p.getFirstResult());
					query.setMaxResults(p.getPageSize());
					List list = query.list();
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}

	

	public List<Topic> existByTitle(String title) {

		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.find(
					"from Topic where title=? order by topic_date desc", title);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lt;
	}

	public List<Topic> findAll(final Pager p) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					Query query = s
				//					.createQuery("from Topic order by topic_id desc");
				.createQuery("from Topic where topic_top = 0 order by topic_date desc");
					query.setFirstResult(p.getFirstResult());
					query.setMaxResults(p.getPageSize());
					List list = query.list();
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}

	public int CountByCategoryChild(int id) {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from Topic where topic_categoryChild_id = "
							+ id).get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}

	public int CountByUser(int id) {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from Topic where  topic_user_id = "
							+ id).get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}


	public List<Topic> findAllTop() {
		try {
			return hibernateTemplate.find("from Topic where topic_top=1 order by topic_date desc");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public int CountAll() {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from Topic where topic_top=0").get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}

	public List<Topic> lateTopic() throws Exception{
	
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					Query query = s
							.createQuery("from Topic order by topic_date desc");
					query.setFirstResult(0);
					query.setMaxResults(Constant.LATE_TOPIC);
					List list = query.list();
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}

	public List<Topic> lateTopic_C(final int id) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					Query query = s
							.createQuery("from Topic t where t.categoryChild in (from CategoryChild where categoryChild_category_Id ="+id+") order by topic_date desc");
					query.setFirstResult(0);                                                
					query.setMaxResults(Constant.LATE_TOPIC);

					List list = query.list();
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}

	public List<Topic> lateTopic_CH(final int id) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					Query query = s
							.createQuery("from Topic where topic_categoryChild_id = "
									+ id + " order by topic_date desc");
					query.setFirstResult(0);
					query.setMaxResults(Constant.LATE_TOPIC);
					List list = query.list();
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}

	public List<Topic> allTopic_C(final Pager p,final int id) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					Query query = s
							.createQuery("from Topic t where t.categoryChild in (from CategoryChild where categoryChild_category_Id ="+id+") order by topic_date desc");
					query.setFirstResult(0);                                                
					query.setMaxResults(Constant.LATE_TOPIC);

					List list = query.list();
				
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}

	public int CountByCategory(final int id) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					Query query = s
							.createQuery("from Topic t where t.top = 0 and t.categoryChild in (from CategoryChild where categoryChild_category_Id ="+id+") order by topic_date desc");
					
					List list = query.list();
				
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt.size();
	}

	public List<Topic> findByCategoryId(final Pager p, final int id) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					Query query = s
							.createQuery("from Topic t where t.categoryChild in (from CategoryChild where categoryChild_category_Id ="+id+") order by topic_date desc");
					query.setFirstResult(p.getFirstResult());                                                
					query.setMaxResults(p.getPageSize());

					List list = query.list();
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return lt;
	}

	public List<Topic> findByKey(final Pager p,final String key) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					String key1 = "%"+key+"%";
					Query query = s
							.createQuery("from Topic as t where t.title like '"+key1+"' or t.contents like '"+key1+"' order by t.date desc");
//					.createQuery("from Topic where topic_title like '%'"+key+"'%' or topic_contents like '%'"+key+"'%' order by topic_id desc");
					query.setFirstResult(p.getFirstResult());
					query.setMaxResults(p.getPageSize());
					List list = query.list();
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}
	public int countOfKey(String key) {
		String key1 = "%"+key+"%";
		return Integer.parseInt(this.hibernateTemplate.find("select Count(*) from Topic as t where t.title like '"+key1+"' or t.contents like '"+key1+"'").get(0).toString());
		
	}

	public List<Topic> findUserJoinTopics(final Pager p ,final int id) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					
					Query query = s
							.createQuery("select distinct(t) from Topic as t,Comment c where t.id=c.topic.id and c.user.id="+id);
//					.createQuery("from Topic where topic_title like '%'"+key+"'%' or topic_contents like '%'"+key+"'%' order by topic_id desc");
					query.setFirstResult(p.getFirstResult());
					query.setMaxResults(p.getPageSize());
					List list = query.list();
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}

	public int countOfUserJoinTopics(int id) {
		 int count = Integer.parseInt(this.hibernateTemplate.find("select Count(distinct t) from Topic as t,Comment c where t.id=c.topic.id and c.user.id="+id+")").get(0).toString());
		 System.out.println(count);
		 return count;
		 
	}

	public List<Topic> userHadRead(final int userId, final int topicId) {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					
					Query query = s
							.createQuery("select distinct(t) from Topic as t where t.id != "+topicId+" and t.id in (select urt.topic.id from UserReadTopic as urt where urt.user.id="+userId+")order by t.date desc");
                    if(query.list().size() != 0){
					query.setFirstResult(0);
					query.setMaxResults(6);
					List list = query.list();
					return list;
                    }else{
                    	return null;
                    }
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}

	public int countOfReportTopic() throws Exception {
		int count = Integer.parseInt(this.hibernateTemplate.find("select Count(*) from Topic as t where t.report > 0").get(0).toString());
		return count;
	}

	public List<Topic> findReportTopic(final Pager p) throws Exception {
		List<Topic> lt = null;
		try {
			lt = hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session s)
						throws HibernateException, SQLException {
					
					Query query = s
							.createQuery("from Topic as t where t.report > 0 order by t.report");

					query.setFirstResult(p.getFirstResult());
					query.setMaxResults(p.getPageSize());
					List list = query.list();
					return list;
				}
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return lt;
	}
	public List<Topic> findReportTopic() throws Exception {
		List<Topic> lt = null;
		lt = this.hibernateTemplate.find("from Topic as t where t.report > 0 order by t.report");
		return lt;
	}
	public List<Topic> HotTopic() throws Exception{
		List<Topic> lt = null;
		lt = hibernateTemplate.executeFind(new HibernateCallback() {

			public Object doInHibernate(Session s)
					throws HibernateException, SQLException {
				
				Query query = s
						.createQuery("from Topic as t order by t.countComment desc");

				query.setFirstResult(0);
				query.setMaxResults(Constant.HOT_TOPIC);
				List list = query.list();
				return list;
			}
		});
		return lt;
	}

	public List<Topic> recommendTopic() throws Exception{
		List<Topic> lt = null;
		lt = hibernateTemplate.executeFind(new HibernateCallback() {

			public Object doInHibernate(Session s)
					throws HibernateException, SQLException {
				
				Query query = s
						.createQuery("from Topic as t order by t.countBrowse desc");

				query.setFirstResult(0);
				query.setMaxResults(Constant.HOT_TOPIC);
				List list = query.list();
				return list;
			}
		});
		return lt;
	}
	
}
