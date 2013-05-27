package com.myitbbs.dao;

import com.myitbbs.model.User;
import com.myitbbs.model.UserReadTopic;

public interface UserReadTopicDao {
public void save(UserReadTopic userReadTopic);
public User  qurey(int topicId);//≤È’“”√ªß
}
