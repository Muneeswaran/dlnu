package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.News;
import com.myitbbs.uitl.Pager;

public interface NewsDao {

	public boolean delete(int id);// ͨ��idɾ��

	public boolean delete(News news);// ͨ��ʵ��ɾ��

	public int countAllNews();//���ŵĸ���
	public int countCNews(int id);//ÿ��ģ�����ŵĸ���
	
	public List<News> findAllDesc(Pager p);// ��������

	public boolean save(News news);// ͨ��ʵ�屣��

	public News get(int id);// ͨ��id��ȡ

	public boolean update(News news);// ͨ��ʵ�����

	public List<News> existByName(String name);// ͨ�����ֲ��ң����id�������Ƿ����

	public List<News> findByCategoryId(Pager p,int id);// ͨ��Category��ģ�飩 ��id��������

	/******************************** 10��22�� ------>������ **************************************/
	public List<News> findByName(String name);
	
	public List<News> lateNews();
	public List<News> lateCategoryNews(int id);
	public List<News> findByKey(Pager p,String key);//��������
	public int countOfKey(String key);//�ؼ����������������ļ�¼
	
}
