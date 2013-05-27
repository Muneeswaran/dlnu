package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.Topic;
import com.myitbbs.model.TopicRemind;
import com.myitbbs.model.User;

public interface TopicRemindDao {
public void save(TopicRemind tr)throws Exception;
public void delete(List<TopicRemind> trlist)throws Exception;
public int CountNew(int id)throws Exception;
public List<TopicRemind> find(int uid,int tid)throws Exception;
public Topic getTopicByComment(int cid)throws Exception;
//public User getTopicAuther(int tid)throws Exception;//帖子作者
public User getCommentAuther(int cid)throws Exception;//找出评论的作者 
public List<User> findJionReply(int cid,int tuid,int cuid)throws Exception;//找出参与评论回复的作者，发帖者和评论者以外的
public List<Topic> findTopicByRemind(int uid)throws Exception;
}
