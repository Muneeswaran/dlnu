package com.myitbbs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.myitbbs.model.Comment;
import com.myitbbs.model.Reply;

public interface ReplyDao {


	public boolean delete(int id);//通过id删除

	public boolean delete(Reply reply);//通过实例删除

	public List<Reply> findAll();//查找所有

	public boolean save(Reply reply);//通过实例保存

	public Reply get(int id);//通过id获取回复

	public boolean update(Reply reply);//通过实体更新

	public List<Reply> findPage(int page, int number);//分页更新

	public List<Reply> getByCommentId(int id);//通过评论提取回复
	
	public List<Reply> getPageByCommentId(int page, int number,int id);//通过评论提取回复
	


}
