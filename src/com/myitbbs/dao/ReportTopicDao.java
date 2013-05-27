package com.myitbbs.dao;

import com.myitbbs.model.ReportTopic;

public interface ReportTopicDao {
public int save(ReportTopic rt)throws Exception;
public int delete(int id)throws Exception;
public int count()throws Exception;
}
