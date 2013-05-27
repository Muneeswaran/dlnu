package com.myitbbs.service;

/*
 *       PageInfoService interface by 虞增勇 
 *       version 1.0
 *       Date:2012-10-16
 * 
 * 
 * */

import java.util.List;
import java.util.Map;

import com.myitbbs.model.Category;
import com.myitbbs.model.CategoryChild;
import com.myitbbs.model.Comment;
import com.myitbbs.model.News;
import com.myitbbs.model.Reply;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.SystemMessage;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.model.UserReadTopic;
import com.myitbbs.uitl.Pager;

public interface PageInfoService {
	public List<Category> getAllCategory();// 取得所有的模块

	public List<Category> getCategoryByPage(int page, int number);// 分页查找模块

	public List<CategoryChild> getAllCategoryChild();// 取得所有二级分类

	public List<CategoryChild> getCategoryChildByC(int id);// 取得特定二级分类

	public List<CategoryChild> getCategoryChildByPage(int page, int number);// 分页查找二级分类

	// //////////////////////////////////////////////////////////////

	public List<User> getUserByPage(Pager p);// 分页查找用户

	public User getUser(int id);

	// //////////////////////////////////////////////////////////////

	public News getNewsById(int id);// 通过本身的id找到相应的新闻

	public List<News> getNewsByPage(Pager p);// 分页查找新闻

	public List<News> lateNews();// 最新新闻

	public List<News> lateNews(int id);// 模块的最新新闻

	public List<Topic> getTopTopic();// 取得所有的帖子

	public List<Topic> getTopicByPageByCategoryChildId(Pager p, int id);// 取得子模块的帖子

	public List<Topic> getTopicByPageByCategoryId(Pager p, int id);// 取得父模块的帖子

	public List<Topic> getTopicByPage(Pager p);// 分页查找帖子

	public List<Topic> lateTopic();// 最新帖子

	public List<Topic> lateTopic_C(int id);// 模块的最新帖子

	public List<Topic> lateTopic_CH(int id);// 模块的最新帖子

	public List<Topic> findTopicByUser(Pager p, int id);// 取得用户的帖子

	public List<Comment> getCommentByPage(Pager p);// 分页查找评论

	public List<Comment> getCommentByPageByTopic(Pager p, int id);// 通过帖子分页查找评论

	public List<Reply> getAllReply();// 取得所有的回复

	public List<Reply> getReplyByPage(int page, int number);// 分页查找所有回复

	public List<Reply> getReplyByPageByComment(int page, int number, int id);// 通过评论

	// 分页查找所有回复
	public int getCommentCountByTopicId(int id);// 每个帖子的评论的总数

	public int getCategoryCount(); // 获取category对象的总个数

	public int getNewsCount(); // 获取News对象的总个数

	public int getNewsCountByCategoryId(int id); // 获取相应模块的News对象的总个数

	public int getTopicCountByCategoryId(int id); // 获取相应模块的Topic对象的总个数

	public int getUserCount(); // 获取User对象的总个数

	public int getTopicCount(); // 获取Topic对象的总数

	public int getTopicCountByUserId(int id); // 获取每个用户Topic对象的总数

	public int getTopicCountByCategoryChildId(int id); // 获取Topic对象的总数

	public Topic getTopicById(int id);

	public List<Comment> getCommentByTopicId(int id);// 通过帖子提取评论

	public List<Reply> getReplyByCommentId(int id);// 通过评论提取回复

	public List<CategoryChild> getCategoryChildByPageByCategoryId(int page,
			int number, int id); // 通过Category的Id获取categoryChild列表

	public List<News> getNewsByPageByCategoryId(Pager p, int id); // 通过Category的Id获取News列表

	/******************************** 资源的 ****************************/
	public int getResourcefileCount();

	public int getResourcefileCountByUser(int id);

	public int getResourcefileCountByCategory(int id);

	public List<Resourcefile> findResourcefileAll(Pager p);// 提取全部资源

	public List<Resourcefile> findResourcefileHot();// 提起热门资源

	public List<Resourcefile> findResourcefileByUserId(Pager p, int id);

	public List<Resourcefile> findResourcefileByCategoryId(Pager p, int id);

	public Resourcefile findResourcefile(int id);

	public List<Resourcefile> lateResource();// 最新资源

	public List<Resourcefile> lateResource_C(int id);// 模块的最新资源

	public List<Topic> findUserJionTopics(Pager p, int id);// 我参与过的帖子

	public int countOfUserJoinTopics(int id);// 我参与的帖子的个数

	public List<User> findIgnoreGroup(Pager p, int masterId);// 不分组查找、

	public int countOfFriendIgnoreGroup(int masterId);

	public List<User> resourceGlory();

	public List<User> topicGlory();

	public List<Topic> userHadReadTopic(int topicId);// 看过此贴的用户还看过的帖子

	public void buildUserReadTopic(UserReadTopic urt);
	
	public List <Topic> HotTopic()throws Exception;//热门帖子
	
	public List<Topic> recommendTopic()throws Exception;//推荐帖子

	public Map<Comment, List<Reply>> getCommentAndReply(Pager p, int id)//找出一个帖子里面的评论和回复
			throws Exception;
	
	public List<SystemMessage> findSystemMessage(int friendId,Pager p)throws Exception;
	
	public int countOfNotCheck(int id);
	
	public int countOfSystemMessage(int id);
	
	public void saveVisit();
}
