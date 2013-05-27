package com.myitbbs.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.TopicRemindDao;
import com.myitbbs.model.Comment;
import com.myitbbs.model.Topic;
import com.myitbbs.model.TopicRemind;
import com.myitbbs.model.User;
import com.myitbbs.service.TopicRemindService;
@Component
@Scope("prototype")
public class TopicRemindServiceImpl implements TopicRemindService{
private TopicRemindDao topicRemindDaoImpl;

	public TopicRemindDao getTopicRemindDaoImpl() {
	return topicRemindDaoImpl;
}
	@Resource
public void setTopicRemindDaoImpl(TopicRemindDao topicRemindDaoImpl) {
	this.topicRemindDaoImpl = topicRemindDaoImpl;
}

	public void remindByComment(Topic t) {
			TopicRemind tr = new TopicRemind();
			tr.setT(t);
			tr.setU(t.getUser());
			try {
				topicRemindDaoImpl.save(tr);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void remindByReply(Comment c) {
		System.out.println("1%%%%%%%%%%%%%%%%%");
		List<TopicRemind> ltr = new ArrayList<TopicRemind>();
		System.out.println("%%%%%%%%%%%%%%%%%"+c.getTopic().getTitle());
		System.out.println("%%%%%%%%%%%%%%%%%"+c.getTopic().getUser().getName());
		System.out.println(get11(c.getTopic(),c.getTopic().getUser()));
		System.out.println("3%%%%%%%%%%%%%%%%%");
		ltr.add(get11(c.getTopic(),c.getTopic().getUser()));

		ltr.add(get11(c.getTopic(),c.getUser()));
		List<User> lu;
		try {
			lu = topicRemindDaoImpl.findJionReply(c.getId(), c.getTopic().getId(), c.getUser().getId());
			for(User u: lu){
				ltr.add(get11(c.getTopic(),u));
			}
			for(TopicRemind tr:ltr){
				topicRemindDaoImpl.save(tr);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}	
	

		
	}
public TopicRemind get11(Topic t , User u){
	
	TopicRemind tr = new TopicRemind();	
	tr.setT(t);
	tr.setU(u);
	return tr;
}
	public int topicCountNew(int uid) {
		try {
			return this.topicRemindDaoImpl.CountNew(uid);
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
	
	}
	public List<TopicRemind> findTopicRemind(int uid,int tid) {
	
		try {
			return this.topicRemindDaoImpl.find(uid, tid);
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
	}
	public List<Topic> findRemindTopic(int uid) {
		
		try {
			return this.topicRemindDaoImpl.findTopicByRemind(uid);
		} catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
	}
	public void deleteTopicRemind(int uid, int tid) {
		List<TopicRemind> lt = findTopicRemind(uid,tid);
		try {
			if(lt != null){
			this.topicRemindDaoImpl.delete(lt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
