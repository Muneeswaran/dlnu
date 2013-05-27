package com.myitbbs.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.UserReadTopicDao;
import com.myitbbs.model.User;
import com.myitbbs.model.UserReadTopic;
@Component
@Scope("prototype")
public class UserReadTopicDaoImpl implements UserReadTopicDao{
	HibernateTemplate hibernateTemplate;

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public User qurey(int topicId) {
		List<User> lu = this.hibernateTemplate.find("select urt.user from UserReadTopic as urt where urt.id = (select MAX(urt1.id) from UserReadTopic as urt1 where urt1.topic.id=?)",topicId);
		if(lu.size() != 0) {
			
			return (User)lu.get(0);
		}   
		else return null;
	}

	public void save(UserReadTopic userReadTopic) {
		this.hibernateTemplate.save(userReadTopic);
		
	}

}
