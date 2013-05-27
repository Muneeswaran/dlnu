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
 *       ManagerService interface by ������ 
 *       version 1.0
 *       Date:2012-10-16
 *       ��Ȩ���� ����ؾ� 
 * 
 * */
public interface ManagerService {
	/* =================����Topic��============================= */
	public boolean delectTopicById(int id);// ͨ��idɾ��

	public boolean delectTopicByUserId(int userId);// ͨ���û�ɾ��

	public boolean delectTopicByDate(Date firstDate, Date secondDate);

	public boolean deleteTopicByTitle(String title);// ͨ������ɾ��

	public List<Topic> findTopic(Pager p);// ��ҳ��������

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

	/* =================����User��============================= */
	public boolean deleteUserById(int id);// ɾ���û�

	public boolean deleteUserByName(String name);// ͨ������ɾ����������Ψһ�ģ�

	public boolean changeUser(User user);// �����û���Ϣ

	public boolean addUser(User user);// �����û�

	public List<User> findUser(Pager p);

	public User findUserById(int id);

	public int userCount();

	public int managerCount();

	public int notManagerCount();

	public List<User> findManager(Pager p);

	public List<User> findNotManager(Pager p);

	/* ============================================================== */

	/* =====================����News��================================ */
	public boolean deleteNewsById(int id);// ɾ������

	public boolean deleteNewsByDate(Date firstDate, Date secondDate);

	public boolean addNews(News news);// ��������

	public boolean chageNews(News news);// ��������

	public List<News> findAllNews(Pager p);// ��ҳ��������

	public List<News> findByCategory(Pager p, int id);// ����ģ���������

	public int newsCount();

	/* ============================================================== */

	/* ========================����ģ��=============================== */
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

	/******************************** ��Դ�� ****************************/
	public int getResourcefileCount();

	public int getResourcefileCountByUser(int id);

	public int getResourcefileCountByCategory(int id);

	public List<Resourcefile> findAll(Pager p);

	public List<Resourcefile> findByUserId(Pager p, int id);

	public List<Resourcefile> findByCategoryId(Pager p, int id);

	public Resourcefile findResourcefile(int id);

	public List<Resourcefile> findResourceByUserId(int id);
	
	public void deleteResource(int id);
	
	public int findCURDATEVisit();//������ʼ�¼
	public int findCURWEEKVisit();//���ܷ��ʼ�¼
	public int findCURMONTHVisit();//���·��ʼ�¼
	public int findLATE7DAYSVisit();//���������ʼ�¼
	public int findALLVisit();//�ܷ��ʼ�¼
	
}
