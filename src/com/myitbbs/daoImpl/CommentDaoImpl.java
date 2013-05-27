package com.myitbbs.daoImpl;
import com.myitbbs.uitl.Pager;
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

import com.myitbbs.dao.CommentDao;

import com.myitbbs.model.Comment;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;

@Component("commentDaoImpl")
@Scope("prototype")
public class CommentDaoImpl implements CommentDao {
	HibernateTemplate hibernateTemplate;

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean update(Comment comment) {
		try {
			hibernateTemplate.update(comment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Comment existById(int id) {
		try {
			return this.get(id);
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(int id) {
		Comment comment = null;
		try {
			comment = this.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (comment != null) {
			hibernateTemplate.delete(comment);
			return true;
		} else {
			return false;
		}
	}

	public boolean delete(Comment comment) {
		if (this.existById(comment.getId()) != null) {
			try {
				hibernateTemplate.delete(comment);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	

	public List<Comment> findPage(final Pager p) {
		List<Comment> CommentList = null;
		try {
			CommentList = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query q = session.createQuery("from Comment");
					q.setFirstResult(p.getFirstResult());
					q.setMaxResults(p.getPageSize());
					List list = q.list();
					return list;
				}});
			return CommentList;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
	}

	public Comment get(int id) {
		Comment comment = null;
		try {
			comment = (Comment) hibernateTemplate.get(Comment.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (comment != null) {
			return comment;
		} else {
			return null;
		}
	}

	public boolean save(Comment comment) {
		
		try {
			hibernateTemplate.save(comment);
			return true;
		} catch (Exception e) {
		
			e.printStackTrace();
			return false;
		}
	}

	public List<Comment> getByTopicId(int id) {
		List<Comment> c = null;
		try {
			
			c =  this.hibernateTemplate.find(
					"from Comment as c where c.topic.id = ? order by c.date desc", id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return c;
	}

	public List<Comment> getPageByTopicId(final Pager p, final int id) {
		List<Comment> CommentList = null;
		try {
			CommentList = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query q = session.createQuery("from Comment as c where c.topic.id = "+id+" order by c.date desc");
					q.setFirstResult(p.getFirstResult());
					q.setMaxResults(p.getPageSize());
					List list = q.list();
					return list;
				}});
			return CommentList;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public List<Comment> getPageByUserId(final Pager p, final int id) {
		List<Comment> CommentList = null;
		try {
			CommentList = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query q = session.createQuery("from Comment where comment_user_id ="+id);
					q.setFirstResult(p.getFirstResult());
					q.setMaxResults(p.getPageSize());
					List list = q.list();
					return list;
				}});
			return CommentList;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public int countComment() {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from Comment ").get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}

	public int countComment_T(int id) {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from Comment where  comment_topic_id = "
							+ id).get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}

	public int countComment_U(int id) {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from Comment where  comment_user_id = "
							+ id).get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}

	
}
