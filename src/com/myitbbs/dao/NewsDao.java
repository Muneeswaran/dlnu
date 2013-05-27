package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.News;
import com.myitbbs.uitl.Pager;

public interface NewsDao {

	public boolean delete(int id);// 通过id删除

	public boolean delete(News news);// 通过实体删除

	public int countAllNews();//新闻的个数
	public int countCNews(int id);//每个模块新闻的个数
	
	public List<News> findAllDesc(Pager p);// 查找所有

	public boolean save(News news);// 通过实体保存

	public News get(int id);// 通过id获取

	public boolean update(News news);// 通过实体更新

	public List<News> existByName(String name);// 通过名字查找，这个id的新闻是否存在

	public List<News> findByCategoryId(Pager p,int id);// 通过Category（模块） 的id查找新闻

	/******************************** 10月22日 ------>虞增勇 **************************************/
	public List<News> findByName(String name);
	
	public List<News> lateNews();
	public List<News> lateCategoryNews(int id);
	public List<News> findByKey(Pager p,String key);//条件查找
	public int countOfKey(String key);//关键字收索出来个数的记录
	
}
