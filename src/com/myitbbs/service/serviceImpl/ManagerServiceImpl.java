package com.myitbbs.service.serviceImpl;

/*
 *       ManagerServiceImpl interface by 虞增勇 
 *       version 1.0
 *       Date:2012-10-16
 * 
 * 
 * */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.CategoryChildDao;
import com.myitbbs.dao.CategoryDao;
import com.myitbbs.dao.CommentDao;
import com.myitbbs.dao.NewsDao;
import com.myitbbs.dao.ResourcefileDao;
import com.myitbbs.dao.TopicDao;
import com.myitbbs.dao.UserDao;
import com.myitbbs.dao.VisitDao;
import com.myitbbs.model.Category;
import com.myitbbs.model.CategoryChild;
import com.myitbbs.model.Comment;
import com.myitbbs.model.News;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.service.ManagerService;
import com.myitbbs.uitl.Pager;

@Component("managerServiceImpl")
@Scope("prototype")
public class ManagerServiceImpl implements ManagerService {
	private TopicDao topicDaoImpl;
	private UserDao userDaoImpl;
	private NewsDao newsDaoImpl;

	private CategoryChildDao categoryChildDaoImpl;
	private CommentDao commentDaoImpl;
    private VisitDao visitDaoImpl;
	private CategoryDao categoryDaoImpl;
	private ResourcefileDao resourcefileDaoImpl;
	@Resource
	public void setVisitDaoImpl(VisitDao visitDaoImpl) {
		this.visitDaoImpl = visitDaoImpl;
	}
	public VisitDao getVisitDaoImpl() {
		return visitDaoImpl;
	}
		public ResourcefileDao getResourcefileDaoImpl() {
			return resourcefileDaoImpl;
		}
		@Resource(name = "resourcefileDaoImpl")
		public void setResourcefileDaoImpl(ResourcefileDao resourcefileDaoImpl) {
			this.resourcefileDaoImpl = resourcefileDaoImpl;
		}
	public CategoryDao getCategoryDaoImpl() {
		return categoryDaoImpl;
	}

	@Resource(name = "categoryDaoImpl")
	public void setCategoryDaoImpl(CategoryDao categoryDaoImpl) {
		this.categoryDaoImpl = categoryDaoImpl;
	}

	public CommentDao getCommentDaoImpl() {
		return commentDaoImpl;
	}

	@Resource(name = "commentDaoImpl")
	public void setCommentDaoImpl(CommentDao commentDaoImpl) {
		this.commentDaoImpl = commentDaoImpl;
	}

	public CategoryChildDao getCategoryChildDaoImpl() {
		return categoryChildDaoImpl;
	}

	@Resource(name = "categoryChildDaoImpl")
	public void setCategoryChildDaoImpl(CategoryChildDao categoryChildDaoImpl) {
		this.categoryChildDaoImpl = categoryChildDaoImpl;
	}

	public TopicDao getTopicDaoImpl() {
		return topicDaoImpl;
	}

	@Resource(name = "topicDaoImpl")
	public void setTopicDaoImpl(TopicDao topicDaoImpl) {
		this.topicDaoImpl = topicDaoImpl;
	}

	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}

	@Resource(name = "userDaoImpl")
	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	public NewsDao getNewsDaoImpl() {
		return newsDaoImpl;
	}

	@Resource(name = "newsDaoImpl")
	public void setNewsDaoImpl(NewsDao newsDaoImpl) {
		this.newsDaoImpl = newsDaoImpl;
	}

	public boolean addNews(News news) {

		newsDaoImpl.save(news);
		return true;
	}

	public boolean addUser(User user) {
		List<User> userList = null;
		try {
			userList = userDaoImpl.get(user.getName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (userList.size() != 0) {

			return false;
		} else {
			userDaoImpl.save(user);
			return true;
		}

	}

	public boolean chageNews(News news) {
		List<News> nl = null;
		try {
			nl = newsDaoImpl.existByName(news.getName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (nl.size() != 0) {// 不为零那就说明没有同名的。
			try {
				newsDaoImpl.update(news);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean changeUser(User user) {
		User u = null;
		try {
			u = userDaoImpl.existById(user.getId());// 返回一个对象，对象要么为空要么存在
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (u == null) {
			return false;
		} else {
			try {
				userDaoImpl.update(user);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}

	}

	public boolean delectTopicByDate(Date firstDate, Date secondDate) {
		/************************/
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delectTopicById(int id) {
		Topic t = null;
		try {
			t = topicDaoImpl.get(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (t != null) {
			try {
				topicDaoImpl.delete(t);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean delectTopicByUserId(int userId) {
		User u = null;
		try {
			u = userDaoImpl.existById(userId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (u != null) {
			try {
				userDaoImpl.delete(u);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean deleteNewsByDate(Date firstDate, Date secondDate) {
		/************************/

		return false;
	}

	public boolean deleteNewsById(int id) {

		News n = null;
		try {
			n = newsDaoImpl.get(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (n != null) {
			newsDaoImpl.delete(n);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteTopicByTitle(String title) {
		List<Topic> t = null;
		try {
			t = topicDaoImpl.existByTitle(title);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (t.size() != 0) {
			topicDaoImpl.delete(t.get(0));
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteUserByDate(Date firstDate, Date secondDate) {
		/************************/
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUserById(int id) {
		User u = null;
		try {
			u = userDaoImpl.existById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (u != null) {
			userDaoImpl.delete(u);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteUserByName(String name) {

		List<User> u = null;
		try {
			u = userDaoImpl.existByName(name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("XXXXXXX");
		if (u.size() != 0) {
			userDaoImpl.delete(u.get(0));
			return true;
		} else {
			return false;
		}
	}

	public List<News> findAllNews(Pager p) {
		List<News> newsList = null;
		try {
			newsList = newsDaoImpl.findAllDesc(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newsList;
	}

	public List<News> findByCategory(Pager p, int id) {
		List<News> newsList = null;
		try {
			newsList = newsDaoImpl.findByCategoryId(p, id);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return newsList;
	}

	public void addCategoryChild(CategoryChild categoryChild) {
		try {
			categoryChildDaoImpl.add(categoryChild);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void addCategory(Category category) {
		try {
			categoryDaoImpl.save(category);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void deleteCategory(Category category) {
		try {
			categoryDaoImpl.delete(category);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void deleteCategoryChild(CategoryChild categoryChild) {
		try {
			categoryChildDaoImpl.delete(categoryChild);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Category> findCategory() {
		try {
			return categoryDaoImpl.findAll();
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	public List<CategoryChild> findCategoryChild() {
		try {
			return categoryChildDaoImpl.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Comment> findComment(Pager p, int id) {
		List<Comment> cl = null;

		try {
			cl = commentDaoImpl.getPageByTopicId(p, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cl;

	}

	public List<Topic> findTopic(Pager p) {
		List<Topic> topicList = null;
		try {
			topicList = topicDaoImpl.findAll(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicList;
	}

	public List<User> findUser(final Pager p) {
		try {
			return userDaoImpl.findPage(p);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public User findUserById(int id) {
		try {
			return userDaoImpl.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void updateCategory(Category category) {
		try {
			categoryDaoImpl.update(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCategoryChild(CategoryChild categoryChild) {
		try {
			categoryChildDaoImpl.update(categoryChild);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Category findCategoryById(int id) {
		try {
			return categoryDaoImpl.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public CategoryChild findCategoryChildById(int id) {
		try {
			return categoryChildDaoImpl.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int userCount() {
		try {
			return userDaoImpl.countAll();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int newsCount() {
		try {
			return newsDaoImpl.countAllNews();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int topicCount() {
		try {
			return topicDaoImpl.CountAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	public void updateTopic(Topic topic) {
		try {
			topicDaoImpl.update(topic);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Topic findTopicById(int id) {
		try {
			return topicDaoImpl.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Comment> findComment(Pager p) {
		
		try {
			return commentDaoImpl.findPage(p);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public int commentCount() {
		try {
			return commentDaoImpl.countComment();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public void deleteComment(int id) {
		try {
			commentDaoImpl.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Resourcefile> findAll(Pager p) {
        List<Resourcefile> lr = null;
        try {
			lr = resourcefileDaoImpl.findAll(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lr;
	}

	public List<Resourcefile> findByCategoryId(Pager p,int id) {
      
		 List<Resourcefile> lr = null;
      try {
			lr = resourcefileDaoImpl.findByCategoryId(p, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lr;
	}

	

	public Resourcefile findResourcefile(int id) {
		try {
			return resourcefileDaoImpl.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}

	public int getResourcefileCount() {
		try {
			return resourcefileDaoImpl.countR();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	public int getResourcefileCountByCategory(int id) {
		try {
			return resourcefileDaoImpl.countR_C(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	public int getResourcefileCountByUser(int id) {
		try {
			return resourcefileDaoImpl.countR_U(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	public List<Resourcefile> findByUserId(Pager p, int id) {
		 List<Resourcefile> lr = null;
      try {
			lr = resourcefileDaoImpl.findByUserId(p, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lr;
	}
	public List<Topic> getTopTopic() {
		try {
			return topicDaoImpl.findAllTop();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public List<User> findManager(Pager p) {
		try {
			return userDaoImpl.findManager(p);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<User> findNotManager(Pager p) {
		try {
			return userDaoImpl.findNotManager(p);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public int managerCount() {
		try {
			return userDaoImpl.countAllManager();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public int notManagerCount() {
		try {
			return userDaoImpl.countAllNotManager();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	public List<Resourcefile> findResourceByUserId(int id) {
		
		return resourcefileDaoImpl.findByUserId(id);
	}
	public void deleteResource(int id) {
		resourcefileDaoImpl.delete(id);
		
	}
	public List<Topic> getReportTopic() {
		
		try {
			return this.topicDaoImpl.findReportTopic();
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	public int countOfReportTopic() {
		
		try {
			return this.topicDaoImpl.countOfReportTopic();
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
	}
	public int findALLVisit() {
		try {
			return this.visitDaoImpl.findALL();
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
		
	}
	public int findCURDATEVisit() {
		try {
			return this.visitDaoImpl.findCURDATE();
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
	}
	public int findCURMONTHVisit() {
		try {
			return this.visitDaoImpl.findCURMONTH();
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
	}
	public int findCURWEEKVisit() {
		try {
			return this.visitDaoImpl.findCURWEEK();
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
	}
	public int findLATE7DAYSVisit() {
		try {
			return this.visitDaoImpl.findLATE7DAYS();
		} catch (Exception e) {
			
			e.printStackTrace();
			return 0;
		}
	}
	

}
