package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.Comment;
import com.myitbbs.uitl.Pager;

public interface CommentDao {

	public boolean delete(int id);// ͨ��IDɾ��

	public boolean delete(Comment comment);// ͨ��ʵ��ɾ��


	public boolean save(Comment comment);// ͨ��ʵ�屣��

	public Comment get(int id);// ͨ��ID��ȡ

	public boolean update(Comment comment);// ͨ��ʵ�����

	public List<Comment> findPage(Pager p);// ��ҳ����

	public List<Comment> getByTopicId(int id);// ͨ��������ȡ����

	public List<Comment> getPageByTopicId(Pager p, int id);// ͨ��������ȡ����

	public List<Comment> getPageByUserId(Pager p, int id);// ͨ��������ȡ����
	
	public int countComment();
	public int countComment_T(int id);
	public int countComment_U(int id);
}
