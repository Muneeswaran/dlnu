package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.MB_Reply;
import com.myitbbs.uitl.Pager;

public interface MB_ReplyDao {
public boolean save(MB_Reply mb_Reply);
public boolean delete(int id);
public boolean upDate(MB_Reply mb_Reply);
public List<MB_Reply> find(Pager p,int id);
public MB_Reply find(int id);
}
