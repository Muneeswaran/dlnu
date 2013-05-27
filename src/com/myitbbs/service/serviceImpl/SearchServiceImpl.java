package com.myitbbs.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.ResourcefileDao;
import com.myitbbs.dao.TopicDao;
import com.myitbbs.dao.UserDao;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.service.SearchService;
import com.myitbbs.uitl.Pager;
@Component
@Scope("prototype")
public class SearchServiceImpl implements SearchService{
	private TopicDao topicDaoImpl;
	private ResourcefileDao resourcefileDaoImpl;
	private UserDao userDaoImpl;
	public TopicDao getTopicDaoImpl() {
		return topicDaoImpl;
	}
	@Resource
	public void setTopicDaoImpl(TopicDao topicDaoImpl) {
		this.topicDaoImpl = topicDaoImpl;
	}
	public ResourcefileDao getResourcefileDaoImpl() {
		return resourcefileDaoImpl;
	}
	@Resource
	public void setResourcefileDaoImpl(ResourcefileDao resourcefileDaoImpl) {
		this.resourcefileDaoImpl = resourcefileDaoImpl;
	}
	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}
	@Resource
	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	public int countOfAboutResourcefile(String Key) {
	
		return this.resourcefileDaoImpl.countOfKey(Key);
	}

	public int countOfAboutTopic(String Key) {
		
		return this.topicDaoImpl.countOfKey(Key);
	}

	public List<Resourcefile> findResourcefileByKey(Pager p,String Key) {
		return this.resourcefileDaoImpl.findByKey(p, Key);
	}

	public List<Topic> findTopicByKey(Pager p,String Key) {
		return this.topicDaoImpl.findByKey(p, Key);
	}

	public List<User> findUserByKey(Pager p,String Key) {
		// TODO Auto-generated method stub
		return null;
	}

}
