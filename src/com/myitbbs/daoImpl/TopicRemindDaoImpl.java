package com.myitbbs.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.TopicRemindDao;
import com.myitbbs.model.Topic;
import com.myitbbs.model.TopicRemind;
import com.myitbbs.model.User;
@Component
@Scope("prototype")
public class TopicRemindDaoImpl implements TopicRemindDao{
	HibernateTemplate hibernateTemplate;

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public int CountNew(int id) {
		int count =0;
		count = Integer.parseInt(this.hibernateTemplate.find("select Count(*) from TopicRemind as tr where tr.u.id = ?",id).get(0).toString());
		return count;
	}

	public void delete(List<TopicRemind> trlist) throws Exception {
		
		this.hibernateTemplate.deleteAll(trlist);
	}

	public void save(TopicRemind tr) throws Exception {
		this.hibernateTemplate.save(tr);
	}
	public List<TopicRemind> find(int uid,int tid) throws Exception {
		List<TopicRemind> ltr = null;
		ltr = this.hibernateTemplate.find("from TopicRemind as tr where tr.u.id="+uid+" and tr.t.id= "+tid);
		return ltr;
	}
	public List<User> findJionReply(int cid,int tuid,int cuid) throws Exception {
		List<User> lu = this.hibernateTemplate.find("select r.user from Reply as r where r.comment.id="+cid+" and r.user.id !="+tuid+" and r.user.id !="+cuid);
		return lu;
	}
	public User getCommentAuther(int cid) throws Exception {
		
		return (User) this.hibernateTemplate.find("select c.user from Comment as c where c.id = ?",cid).get(0);
	}
//	public User getTopicAuther(int tid) throws Exception {
//		
//		return (User) this.hibernateTemplate.find("select t.user from Topic as t where t.id = ?",tid).get(0);
//	}
	public Topic getTopicByComment(int cid) throws Exception {
		
		return (Topic) this.hibernateTemplate.find("select c.topic from Comment as c where c.id = ?",cid).get(0);
	}
	public List<Topic> findTopicByRemind(int uid) throws Exception {
		
		return this.hibernateTemplate.find("select distinct(t) from Topic as t where t.id in(select tr.t.id from TopicRemind as tr where tr.u.id="+uid+")");
	}

}
