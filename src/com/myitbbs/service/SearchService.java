package com.myitbbs.service;

import java.util.List;

import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.uitl.Pager;

public interface SearchService {
public List<Topic> findTopicByKey(Pager p,String Key);//�������
public List<Resourcefile> findResourcefileByKey(Pager p,String Key);//�����Դ
public List<User> findUserByKey(Pager p,String Key);//����û�
public int countOfAboutTopic(String Key);
public int countOfAboutResourcefile(String Key);
}
