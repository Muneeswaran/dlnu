package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.MessageBoard;
import com.myitbbs.uitl.Pager;

public interface MessageBoardDao {
public boolean save(MessageBoard m);//����or����
public boolean delete(int id);//ɾ��
public boolean update(MessageBoard m);//����
public MessageBoard getById(int id);
public List<MessageBoard> findByMaster(Pager p,int id);//�������˵�
public List<MessageBoard> findByVisitor(Pager p,int id);//���������ߵ� 
}
