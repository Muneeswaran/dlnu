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
//public User getTopicAuther(int tid)throws Exception;//��������
public User getCommentAuther(int cid)throws Exception;//�ҳ����۵����� 
public List<User> findJionReply(int cid,int tuid,int cuid)throws Exception;//�ҳ��������ۻظ������ߣ������ߺ������������
public List<Topic> findTopicByRemind(int uid)throws Exception;
}
