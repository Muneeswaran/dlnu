package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.SystemMessage;
import com.myitbbs.uitl.Pager;

public interface SystemMessageDao {
public int save(SystemMessage s) throws Exception;
public int update(SystemMessage s) throws Exception;
public List<SystemMessage> find(int friendId,final Pager p) throws Exception;//查找被请求的人的系统信息
public int countOfSystemMessage(int id)throws Exception;
public int countOfNotCheck(int id)throws Exception;
public SystemMessage getObject(int id)throws Exception;
public SystemMessage getComment(int id,int id2)throws Exception;

}
