package com.myitbbs.service.serviceImpl;

/*
 *       PageInfoServiceImpl interface by 虞增勇 
 *       version 1.0
 *       Date:2012-10-16
 * 
 * 
 * */
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.CategoryChildDao;
import com.myitbbs.dao.CategoryDao;
import com.myitbbs.dao.CommentDao;
import com.myitbbs.dao.FriendDao;
import com.myitbbs.dao.NewsDao;
import com.myitbbs.dao.ReplyDao;
import com.myitbbs.dao.ResourcefileDao;
import com.myitbbs.dao.SystemMessageDao;
import com.myitbbs.dao.TopicDao;
import com.myitbbs.dao.UserDao;
import com.myitbbs.dao.UserReadTopicDao;
import com.myitbbs.dao.VisitDao;
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
import com.myitbbs.model.Visit;
import com.myitbbs.service.PageInfoService;
import com.myitbbs.uitl.Pager;

@Component("pageInfoServiceImpl")
@Scope("prototype")
public class PageInfoServiceImpl implements PageInfoService {
	private CategoryDao categoryDaoImpl;
	private CategoryChildDao categoryChildDaoImpl;
	private CommentDao commentDaoImpl;
	private NewsDao newsDaoImpl;
	private ReplyDao replyDaoImpl;
	private TopicDao topicDaoImpl;
	private UserDao userDaoImpl;
	private ResourcefileDao resourcefileDaoImpl;
	private FriendDao friendDaoImpl;
	private UserReadTopicDao userReadTopicDaoImpl;
    private SystemMessageDao systemMessageDaoImpl;
    private VisitDao visitDaoImpl;
	public SystemMessageDao getSystemMessageDaoImpl() {
		return systemMessageDaoImpl;
	}
	@Resource
	public void setSystemMessageDaoImpl(SystemMessageDao systemMessageDaoImpl) {
		this.systemMessageDaoImpl = systemMessageDaoImpl;
	}
	public UserReadTopicDao getUserReadTopicDaoImpl() {
		return userReadTopicDaoImpl;
	}
	@Resource
	public void setUserReadTopicDaoImpl(UserReadTopicDao userReadTopicDaoImpl) {
		this.userReadTopicDaoImpl = userReadTopicDaoImpl;
	}
	public FriendDao getFriendDaoImpl() {
		return friendDaoImpl;
	}
	@Resource
	public void setFriendDaoImpl(FriendDao friendDaoImpl) {
		this.friendDaoImpl = friendDaoImpl;
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

	public CategoryChildDao getCategoryChildDaoImpl() {
		return categoryChildDaoImpl;
	}

	@Resource(name = "categoryChildDaoImpl")
	public void setCategoryChildDaoImpl(CategoryChildDao categoryChildDaoImpl) {
		this.categoryChildDaoImpl = categoryChildDaoImpl;
	}

	public CommentDao getCommentDaoImpl() {
		return commentDaoImpl;
	}

	@Resource(name = "commentDaoImpl")
	public void setCommentDaoImpl(CommentDao commentDaoImpl) {
		this.commentDaoImpl = commentDaoImpl;
	}

	public NewsDao getNewsDaoImpl() {
		return newsDaoImpl;
	}

	@Resource(name = "newsDaoImpl")
	public void setNewsDaoImpl(NewsDao newsDaoImpl) {
		this.newsDaoImpl = newsDaoImpl;
	}

	public ReplyDao getReplyDaoImpl() {
		return replyDaoImpl;
	}

	@Resource(name = "replyDaoImpl")
	public void setReplyDaoImpl(ReplyDao replyDaoImpl) {
		this.replyDaoImpl = replyDaoImpl;
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

	public List<Category> getAllCategory() {
		List<Category> lc = null;
	
		try {
		
			lc = categoryDaoImpl.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lc;
	}

	public List<CategoryChild> getAllCategoryChild() {

		try {
			return categoryChildDaoImpl.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	public List<News> getAllNews() {
//
//		try {
//			return newsDaoImpl.findAll();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return null;
//		}
//	}

	public List<Reply> getAllReply() {

		try {
			return replyDaoImpl.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	

	public List<Category> getCategoryByPage(int page, int number) {

		try {
			return categoryDaoImpl.findPage(page, number);
		} catch (Exception e) {
	
			e.printStackTrace();
			return null;
		}
	}

	public List<CategoryChild> getCategoryChildByPage(int page, int number) {

		try {
			return categoryChildDaoImpl.findPage(page, number);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Comment> getCommentByPage(Pager p) {

		try {
			return commentDaoImpl.findPage(p);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<News> getNewsByPage(Pager p) {
		
		try {
		
			return newsDaoImpl.findAllDesc(p);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Reply> getReplyByPage(int page, int number) {
		try {
			return replyDaoImpl.findPage(page, number);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Topic> getTopicByPage(Pager p) {
		try {
			return topicDaoImpl.findAll(p);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getUserByPage(Pager p) {
		try {
			return userDaoImpl.findPage(p);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getCategoryCount() {

		try {
			return getAllCategory().size();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int getNewsCount() {

		try {
			return newsDaoImpl.countAllNews();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int getTopicCount() {

		try {
			return topicDaoImpl.CountAll();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int getUserCount() {

		try {
			return userDaoImpl.countAll();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<CategoryChild> getCategoryChildByPageByCategoryId(int page,
			int number, int id) {
		List<CategoryChild> lc = null;
		try {
			lc = categoryChildDaoImpl.findPageByCategoryId(page, number, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lc;
	}

	public List<News> getNewsByPageByCategoryId(Pager p, int id) {
		List<News> ln = null;
		try {
			
			return newsDaoImpl.findByCategoryId(p, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Topic> getTopicByPageByCategoryChildId(Pager p,
			int id) {
		List<Topic> lt = null;
		try {
			lt = topicDaoImpl.findByCategoryChildId(p, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lt;
	}

	public int getTopicCountByCategoryChildId(int id) {
		try {
			return topicDaoImpl.CountByCategoryChild(id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public Topic getTopicById(int id) {
		try {
			return topicDaoImpl.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<Comment> getCommentByTopicId(int id) {
		List<Comment> c = null;
		try {
			c = commentDaoImpl.getByTopicId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public List<Reply> getReplyByCommentId(int id) {
		List<Reply> r = null;
		try {
			r = replyDaoImpl.getByCommentId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	public List<Comment> getCommentByPageByTopic(Pager p, int id) {
		List<Comment> lc = null;
		try {
			lc = commentDaoImpl.getPageByTopicId(p, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lc;
	}

	public List<Reply> getReplyByPageByComment(int page, int number, int id) {
		List<Reply> lr = null;
		try {
			lr = replyDaoImpl.getPageByCommentId(page, number, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lr;
	}

	public int getNewsCountByCategoryId(int id) {
		int a = 0;
		try {
			a = newsDaoImpl.countCNews(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public int getTopicCountByUserId(int id) {
		int a = 0;
		try {
			a = topicDaoImpl.CountByUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public News getNewsById(int id) {
		News n = null;
		try {
			n = newsDaoImpl.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	public int getCommentCountByTopicId(int id) {
		int size = 0;
		try {
			List<Comment> lc = commentDaoImpl.getByTopicId(id);
			size = lc.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return size;
	}

	public List<Resourcefile> findResourcefileAll(Pager p) {
		List<Resourcefile> lr = null;

		try {
			lr = resourcefileDaoImpl.findAll(p);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lr;
	}

	public List<Resourcefile> findResourcefileByCategoryId(Pager p, int id) {

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
			e.printStackTrace();
			return null;
		}

	}

	public int getResourcefileCount() {
		try {
			return resourcefileDaoImpl.countR();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public int getResourcefileCountByCategory(int id) {
		try {
			return resourcefileDaoImpl.countR_C(id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public int getResourcefileCountByUser(int id) {
		try {
			return resourcefileDaoImpl.countR_U(id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public List<Resourcefile> findResourcefileByUserId(Pager p,int id) {
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

	public List<Topic> lateTopic() {
		try {
		return	topicDaoImpl.lateTopic();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public List<Topic> lateTopic_C(int id) {
		try {
			return	topicDaoImpl.lateTopic_C(id);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}

	public List<News> lateNews() {
		List<News> ln = null;
		try {
			
			return newsDaoImpl.lateNews();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Topic> findTopicByUser(Pager p, int id) {
		try {
			return this.topicDaoImpl.findByUser(p, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<News> lateNews(int id) {
		List<News> ln = null;
		try {
			
			return newsDaoImpl.lateCategoryNews(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Resourcefile> lateResource() {
		List<Resourcefile> lr = null;
		try {
			lr = resourcefileDaoImpl.lateResource();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lr;
	}

	public List<Resourcefile> lateResource_C(int id) {
		List<Resourcefile> lr = null;
		try {
			lr = resourcefileDaoImpl.lateCategoryResource(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lr;
	}

	public List<Topic> getTopicByPageByCategoryId(Pager p, int id) {
		List <Topic> lt = null;
		try {
			
		lt = 	topicDaoImpl.findByCategoryId(p, id);
	
			} catch (Exception e) {
				e.printStackTrace();
		
			}
			return lt;
	}

	public List<Topic> lateTopic_CH(int id) {
		try {
			return	topicDaoImpl.lateTopic_CH(id);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
	}

	public List<CategoryChild> getCategoryChildByC(int id) {
		try {
			return categoryChildDaoImpl.findByCategoryId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}

	public int getTopicCountByCategoryId(int id) {
		try {
			return topicDaoImpl.CountByCategory(id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	
	}

	public List<Resourcefile> findResourcefileHot() {
	try {
		return resourcefileDaoImpl.hotResource();
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
		
	}

	public List<Topic> findUserJionTopics(Pager p, int id) {
		
		return this.topicDaoImpl.findUserJoinTopics(p, id);
	}

	public int countOfUserJoinTopics(int id) {
		
		return this.topicDaoImpl.countOfUserJoinTopics(id);
	}

	public int countOfFriendIgnoreGroup(int masterId) {
		
		return this.friendDaoImpl.countOfFriendIgnoreGroup(masterId);
	}

	public List<User> findIgnoreGroup(Pager p, int masterId) {
		
		return this.friendDaoImpl.findIgnoreGroup(p, masterId);
	}
	public List<User> resourceGlory() {
	
		return this.friendDaoImpl.resourceGlory();
	}
	public List<User> topicGlory() {
		return this.friendDaoImpl.topicGlory();
	}
	public List<Topic> userHadReadTopic(int topicId) {
		User u = null;
		List<Topic> lt = null;
		try {
			System.out.println("1、userHadReadTopic");
			u = userReadTopicDaoImpl.qurey(topicId);
			if(u == null){//如果这个帖子没有被人读过。则找出来的用户就是null
				return null;
			}
			System.out.println("2、userHadReadTopic");
			lt = topicDaoImpl.userHadRead(u.getId(), topicId);
			System.out.println("3、userHadReadTopic");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lt;
	}
	public User getUser(int id) {
		
		return this.userDaoImpl.get(id);
	}
	public void buildUserReadTopic(UserReadTopic urt) {
		this.userReadTopicDaoImpl.save(urt);
		
	}
	public Map<Comment, List<Reply>> getCommentAndReply(Pager p, int id)
			throws Exception {
		List<Comment> lc = this.commentDaoImpl.getPageByTopicId(p, id);
		Map<Comment, List<Reply>> m = new HashMap<Comment, List<Reply>>();
		List<Reply> lr = null;
		for(Comment c : lc){
			lr = this.replyDaoImpl.getByCommentId(c.getId());
			m.put(c, lr);
		}
		return m;
	}
	public List<Topic> HotTopic() throws Exception {
		List<Topic> lt = this.topicDaoImpl.HotTopic();
		return lt;
	}
	public List<Topic> recommendTopic() throws Exception {
		List<Topic> lt = this.topicDaoImpl.recommendTopic();
		return lt;
	}
	public List<SystemMessage> findSystemMessage(int friendId,Pager p) throws Exception {
		List<SystemMessage> lsm = this.systemMessageDaoImpl.find(friendId , p);
		return lsm;
	}
	public int countOfNotCheck(int id) {
		int count = 0;
		try {
			count = this.systemMessageDaoImpl.countOfNotCheck(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public int countOfSystemMessage(int id) {
		int count = 0;
		try {
			count = this.systemMessageDaoImpl.countOfSystemMessage(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	@Resource
	public void setVisitDaoImpl(VisitDao visitDaoImpl) {
		this.visitDaoImpl = visitDaoImpl;
	}
	public VisitDao getVisitDaoImpl() {
		return visitDaoImpl;
	}
	public void saveVisit() {		
		try {
			this.visitDaoImpl.save( new Visit());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	

}
