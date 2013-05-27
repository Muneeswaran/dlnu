package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.MessageBoard;
import com.myitbbs.uitl.Pager;

public interface MessageBoardDao {
public boolean save(MessageBoard m);//保存or增加
public boolean delete(int id);//删除
public boolean update(MessageBoard m);//更新
public MessageBoard getById(int id);
public List<MessageBoard> findByMaster(Pager p,int id);//查找主人的
public List<MessageBoard> findByVisitor(Pager p,int id);//查找来访者的 
}
