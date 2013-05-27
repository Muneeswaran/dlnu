package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.Comment;
import com.myitbbs.uitl.Pager;

public interface CommentDao {

	public boolean delete(int id);// 通过ID删除

	public boolean delete(Comment comment);// 通过实体删除


	public boolean save(Comment comment);// 通过实体保存

	public Comment get(int id);// 通过ID获取

	public boolean update(Comment comment);// 通过实体更新

	public List<Comment> findPage(Pager p);// 分页查找

	public List<Comment> getByTopicId(int id);// 通过帖子提取评论

	public List<Comment> getPageByTopicId(Pager p, int id);// 通过帖子提取评论

	public List<Comment> getPageByUserId(Pager p, int id);// 通过帖子提取评论
	
	public int countComment();
	public int countComment_T(int id);
	public int countComment_U(int id);
}
