package com.myitbbs.service;

import java.util.List;

import com.myitbbs.model.Comment;
import com.myitbbs.model.Topic;
import com.myitbbs.model.TopicRemind;

public interface TopicRemindService {
	public void remindByComment(Topic t);
	public void remindByReply(Comment c);
	public int topicCountNew(int uid);
   // public List<TopicRemind> findTopicRemind(int uid,int tid);
	public List<Topic> findRemindTopic(int uid);
	public void deleteTopicRemind(int uid,int tid);
}
