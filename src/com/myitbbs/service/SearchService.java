package com.myitbbs.service;

import java.util.List;

import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.uitl.Pager;

public interface SearchService {
public List<Topic> findTopicByKey(Pager p,String Key);//相关贴子
public List<Resourcefile> findResourcefileByKey(Pager p,String Key);//相关资源
public List<User> findUserByKey(Pager p,String Key);//相关用户
public int countOfAboutTopic(String Key);
public int countOfAboutResourcefile(String Key);
}
