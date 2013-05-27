package com.myitbbs.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.myitbbs.model.News;
import com.myitbbs.model.Topic;
import com.myitbbs.uitl.Pager;

public interface TopicDao {

	public boolean delete(int id);// 通过id删除

	public boolean delete(Topic topic);// 通过实体类删除

	public boolean deleteByName(String name);// 通过名字来删除

	public boolean save(Topic topic);// 通过实体类来删除

	public Topic get(int id);// 通过id获取
	public List<Topic> findReportTopic() throws Exception;
	public boolean update(Topic topic);// 通过实体类来更新

	public List<Topic> findByUser(Pager p, int id);// 通过用户来查找所发的帖子

	public List<Topic> findByCategoryChildId(Pager p, final int id);// 通过二级分类来查找
	public List<Topic> findByCategoryId(Pager p, final int id);// 通过二级分类来查找

	public List<Topic> findAll(Pager p);

	public List<Topic> findAllTop();

	public List<Topic> findByTitleByDesc(Pager p,
			final String title);// 降序查找


	public List<Topic> existByTitle(String title);

	public int CountByCategoryChild(int id);
	public int CountByCategory(int id);

	public int CountByUser(int id);// 

	public int CountAll();// 这个是减去置顶的个数以后的
	
	public List <Topic> HotTopic()throws Exception;//热门帖子
	
	public List<Topic> recommendTopic()throws Exception;//推荐帖子
	
	
	public List<Topic> lateTopic()throws Exception;//最新帖子
	
	public List<Topic> lateTopic_C(int id);//子模块的最新帖子
	public List<Topic> lateTopic_CH(int id);//父模块的最新帖子
	public List<Topic> allTopic_C(Pager p,int id);//父模块的最新帖子
	
	public List<Topic> findByKey(final Pager p ,String key);//条件查找
	public int countOfKey(String key);
	
	public List<Topic> findUserJoinTopics(Pager p ,int id);//我参与的帖子
	public int countOfUserJoinTopics(int id);//我参与的帖子的个数
	
	public List<Topic> userHadRead(int userId,int topicId);
	
	public List<Topic> findReportTopic(Pager p)throws Exception;//被举报的帖子
	public int countOfReportTopic()throws Exception;//被举报帖子的个数
}
