package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.Friend;
import com.myitbbs.model.User;
import com.myitbbs.uitl.Pager;

public interface FriendDao {
public int save(Friend friend);
public Friend getFriend(int id,int id2);
public int delete(Friend f);
public int update(int id,int id2);
public List<User> find(Pager p,int groupID,int masterId);
public List<User> findIgnoreGroup(Pager p,int masterId);//��������ҡ�
public int countOfFriendIgnoreGroup(int masterId);//��������ң����ѵĸ�����
public List<Friend> findFriend(int id,int id2);
public List<User> topicGlory();//���ӹ��ٰ񣨻�Ծ���ٰ�
public List<User> resourceGlory();//��Դ���ٰ񣨹��׹��ٰ�

}
