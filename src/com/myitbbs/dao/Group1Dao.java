package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.Group1;
import com.myitbbs.uitl.Pager;

public interface Group1Dao {
public int save(Group1 group);
public int delete(int id);
public int update(Group1 group);
public List<Group1> find(Pager p,int masterId);
public Group1 find(int id);
}
