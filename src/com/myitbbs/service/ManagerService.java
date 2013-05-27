package com.myitbbs.service;

import java.util.Date;
import java.util.List;

import com.myitbbs.model.Category;
import com.myitbbs.model.CategoryChild;
import com.myitbbs.model.Comment;
import com.myitbbs.model.News;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.model.Visit;
import com.myitbbs.uitl.Pager;

/*
 *       ManagerService interface by 虞增勇 
 *       version 1.0
 *       Date:2012-10-16
 *       版权所有 翻版必究 
 * 
 * */
public interface ManagerService {
	/* =================关于Topic的============================= */
	public boolean delectTopicById(int id);// 通过id删除

	public boolean delectTopicByUserId(int userId);// 通过用户删除

	public boolean delectTopicByDate(Date firstDate, Date secondDate);

	public boolean deleteTopicByTitle(String title);// 通过主题删除

	public List<Topic> findTopic(Pager p);// 分页查找帖子

	public List<Topic> getTopTopic();
	
	public List<Topic> getReportTopic();

	public int countOfReportTopic();
	
	public List<Comment> findComment(Pager p, int id);

	public List<Comment> findComment(Pager p);

	public void deleteComment(int id);

	public int commentCount();

	public int topicCount();

	public void updateTopic(Topic topic);

	public Topic findTopicById(int id);

	/* ===================================================== */

	/* =================关于User的============================= */
	public boolean deleteUserById(int id);// 删除用户

	public boolean deleteUserByName(String name);// 通过名字删除（名字是唯一的）

	public boolean changeUser(User user);// 更新用户信息

	public boolean addUser(User user);// 增加用户

	public List<User> findUser(Pager p);

	public User findUserById(int id);

	public int userCount();

	public int managerCount();

	public int notManagerCount();

	public List<User> findManager(Pager p);

	public List<User> findNotManager(Pager p);

	/* ============================================================== */

	/* =====================关于News的================================ */
	public boolean deleteNewsById(int id);// 删除新闻

	public boolean deleteNewsByDate(Date firstDate, Date secondDate);

	public boolean addNews(News news);// 增加新闻

	public boolean chageNews(News news);// 更新新闻

	public List<News> findAllNews(Pager p);// 分页查找新闻

	public List<News> findByCategory(Pager p, int id);// 根据模块查找新闻

	public int newsCount();

	/* ============================================================== */

	/* ========================关于模块=============================== */
	public void addCategory(Category category);

	public List<Category> findCategory();

	public void updateCategory(Category category);

	public void deleteCategory(Category category);

	public void addCategoryChild(CategoryChild categoryChild);

	public List<CategoryChild> findCategoryChild();

	public void updateCategoryChild(CategoryChild categoryChild);

	public void deleteCategoryChild(CategoryChild categoryChild);

	public Category findCategoryById(int id);

	public CategoryChild findCategoryChildById(int id);

	/******************************** 资源的 ****************************/
	public int getResourcefileCount();

	public int getResourcefileCountByUser(int id);

	public int getResourcefileCountByCategory(int id);

	public List<Resourcefile> findAll(Pager p);

	public List<Resourcefile> findByUserId(Pager p, int id);

	public List<Resourcefile> findByCategoryId(Pager p, int id);

	public Resourcefile findResourcefile(int id);

	public List<Resourcefile> findResourceByUserId(int id);
	
	public void deleteResource(int id);
	
	public int findCURDATEVisit();//当天访问记录
	public int findCURWEEKVisit();//本周访问记录
	public int findCURMONTHVisit();//本月访问记录
	public int findLATE7DAYSVisit();//最近七天访问记录
	public int findALLVisit();//总访问记录
	
}
