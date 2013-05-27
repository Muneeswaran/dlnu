package com.myitbbs.dao;

import com.myitbbs.model.Visit;

public interface VisitDao {
public int findCURDATE()throws Exception;
public int findCURWEEK()throws Exception;
public int findCURMONTH()throws Exception;
public int findLATE7DAYS()throws Exception;
public int findALL()throws Exception;
public void save(Visit v)throws Exception;
}
