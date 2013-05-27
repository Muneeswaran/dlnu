package com.myitbbs.dao;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.myitbbs.model.Comment;
import com.myitbbs.model.Reply;

public interface ReplyDao {


	public boolean delete(int id);//ͨ��idɾ��

	public boolean delete(Reply reply);//ͨ��ʵ��ɾ��

	public List<Reply> findAll();//��������

	public boolean save(Reply reply);//ͨ��ʵ������

	public Reply get(int id);//ͨ��id��ȡ�ظ�

	public boolean update(Reply reply);//ͨ��ʵ�����

	public List<Reply> findPage(int page, int number);//��ҳ����

	public List<Reply> getByCommentId(int id);//ͨ��������ȡ�ظ�
	
	public List<Reply> getPageByCommentId(int page, int number,int id);//ͨ��������ȡ�ظ�
	


}
