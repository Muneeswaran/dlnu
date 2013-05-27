package com.myitbbs.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.constant.Constant;
import com.myitbbs.model.Category;
import com.myitbbs.model.CategoryChild;
import com.myitbbs.model.Comment;
import com.myitbbs.model.Letter;
import com.myitbbs.model.News;
import com.myitbbs.model.Reply;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.SystemMessage;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.model.UserReadTopic;
import com.myitbbs.service.ManagerService;
import com.myitbbs.service.PageInfoService;
import com.myitbbs.service.TopicRemindService;
import com.myitbbs.service.UserService;
import com.myitbbs.service.serviceImpl.ManagerServiceImpl;
import com.myitbbs.service.serviceImpl.PageInfoServiceImpl;
import com.myitbbs.service.serviceImpl.UserServiceImpl;
import com.myitbbs.uitl.Pager;
import com.myitbbs.vo.PageInfoVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component
@Scope("prototype")
public class PageInfoAction extends ActionSupport implements
		ModelDriven<PageInfoVo> {

	private List<CategoryChild> categoryChildList;
	private List<Category> categoryList;
    private int countNotReadLetter = 0;
	private List<Resourcefile> hotResourceList;
    private List<SystemMessage> listSystemMessage;
    private int notCheck;
	public List<SystemMessage> getListSystemMessage() {
		return listSystemMessage;
	}
	public void setListSystemMessage(List<SystemMessage> listSystemMessage) {
		this.listSystemMessage = listSystemMessage;
	}

	private int letterId;
	private TopicRemindService topicRemindServiceImpl;
	public TopicRemindService getTopicRemindServiceImpl() {
		return topicRemindServiceImpl;
	}
	@Resource
	public void setTopicRemindServiceImpl(TopicRemindService topicRemindServiceImpl) {
		this.topicRemindServiceImpl = topicRemindServiceImpl;
	}

	private int letterNum = 1;
    public int getMpNumber() {
		return mpNumber;
	}
	public void setMpNumber(int mpNumber) {
		this.mpNumber = mpNumber;
	}

	private int mpNumber = 1;

	private List<Letter> listLetter;

	private Pager lp;
	private ManagerService managerServiceImpl;
	private List<News> newsList;
	private PageInfoService pageInfoServiceImpl;
	private PageInfoVo pageInfoVo = new PageInfoVo();


	@SuppressWarnings("unchecked")
	private Map request;
private Pager SMp;

	public Pager getSMp() {
	return SMp;
}
public void setSMp(Pager sMp) {
	SMp = sMp;
}

	private List<Resourcefile> resourcefileList;


	private Map session;
    private Map<Comment, List<Reply>> cr;
	public Map<Comment, List<Reply>> getCr() {
		return cr;
	}
	public void setCr(Map<Comment, List<Reply>> cr) {
		this.cr = cr;
	}

	private List<Topic> topicList;
	private int msCount ;
	public int getMsCount() {
		return msCount;
	}
	public void setMsCount(int msCount) {
		this.msCount = msCount;
	}
private int topicRemind;
	public int getTopicRemind() {
	return topicRemind;
}
public void setTopicRemind(int topicRemind) {
	this.topicRemind = topicRemind;
}

	private List<Topic> topicListRecomend;
	public List<Topic> getTopicListRecomend() {
		return topicListRecomend;
	}
	public void setTopicListRecomend(List<Topic> topicListRecomend) {
		this.topicListRecomend = topicListRecomend;
	}

	private List<Topic> topicListHot;
	
	private User u;
	private List<User> userActive;
	private List<User> userContribute;
	private List<User> userList;
	private UserService userServiceImpl;
	private Letter letter;
	public Letter getLetter() {
		return letter;
	}
	public void setLetter(Letter letter) {
		this.letter = letter;
	}
	public int userId(){
		session = ActionContext.getContext().getSession();
		HttpServletResponse response = (HttpServletResponse) ActionContext
		.getContext().get(ServletActionContext.HTTP_RESPONSE);
		Object o = (Integer)session.get("userId");
		if(o != null){
		int userId = (Integer)o;
		return userId;
		}
		return -1;
	}
	public boolean checkOn() {
		if(userId() == -1){
			return false;
		}else{
			return true;
		}
	}
	public String topicRemind(){
		
		int userId = userId();
		topicList = this.topicRemindServiceImpl.findRemindTopic(userId);
		return "topicRemind";
	}
	// ��ʾ��ҳ����
	public String firstPage() {
		try {
			
			if(userId() != -1){
			int userId = userId();;
			this.countNotReadLetter = userServiceImpl.countNotReadLetter(userId);
			notCheck = pageInfoServiceImpl.countOfNotCheck(userId);
			this.topicRemind = this.topicRemindServiceImpl.topicCountNew(userId);
			msCount = this.countNotReadLetter + this.notCheck+this.topicRemind;
			session.put("msCount", msCount);
			}
			categoryList = pageInfoServiceImpl.getAllCategory();
			newsList = pageInfoServiceImpl.lateNews();
			topicList = pageInfoServiceImpl.lateTopic();//��������
			topicListHot = pageInfoServiceImpl.HotTopic();//��������
			topicListRecomend = pageInfoServiceImpl.recommendTopic();
			resourcefileList = pageInfoServiceImpl.lateResource();
			pageInfoServiceImpl.saveVisit();
			int tv = managerServiceImpl.findCURDATEVisit();
			int allv = managerServiceImpl.findALLVisit();
			session = ActionContext.getContext().getSession();
			session.put("tv", tv);
			session.put("allv", allv);
			
		//	userActive = pageInfoServiceImpl.topicGlory();
		//	userContribute = pageInfoServiceImpl.resourceGlory();
		} catch (Exception e) {

			System.out.println(e);
		}
		return "firstPage";
	}
	public List<CategoryChild> getCategoryChildList() {
	
		return categoryChildList;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}
	 public int getCountNotReadLetter() {
		return countNotReadLetter;
	}
		public List<Resourcefile> getHotResourceList() {
			return hotResourceList;
		}

		public int getLetterId() {
			return letterId;
		}
	public int getLetterNum() {
		return letterNum;
	}
	public List<Letter> getListLetter() {
		return listLetter;
	}
	public Pager getLp() {
		return lp;
	}
	public ManagerService getManagerServiceImpl() {
		return managerServiceImpl;
	}

	public PageInfoVo getModel() {
		return pageInfoVo;
	}

	public List<News> getNewsList() {
		return newsList;
	}
	public PageInfoService getPageInfoServiceImpl() {
		return pageInfoServiceImpl;
	}
	 public PageInfoVo getPageInfoVo() {
		return pageInfoVo;
	}

		public List<Resourcefile> getResourcefileList() {
			return resourcefileList;
		}

		public List<Topic> getTopicList() {
		
			return topicList;
		}

	public List<Topic> getTopicListHot() {
		return topicListHot;
	}

	public User getU() {
		return u;
	}

	public List<User> getUserActive() {
		return userActive;
	}
	public List<User> getUserContribute() {
		return userContribute;
	}
	public List<User> getUserList() {
		return userList;
	}

	


	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public String informationChange(){
	
		   u = userServiceImpl.getUser(pageInfoVo.getUserId());
		   return "informationChange";
	   }

	public String readNewsPage() { 
		 categoryList =
	  pageInfoServiceImpl.getAllCategory(); News news =
	  pageInfoServiceImpl.getNewsById(pageInfoVo.getNewsId());
	  pageInfoVo.setNews(news);
	  
	  Category c = pageInfoVo.getNews().getCategory();
	  pageInfoVo.setCategoryId(c.getId()); pageInfoVo.setCategory(c); 
	  newsList  = pageInfoServiceImpl.lateNews();
	  return "readNewsPage";
	  }

	public String readTopicPage() {
	
		categoryList = pageInfoServiceImpl.getAllCategory();
		Topic t = pageInfoServiceImpl.getTopicById(pageInfoVo
				.getTopicId());
		pageInfoVo.setTopic(t);// ��ȡ�õ����ӷŵ�VO����ȥ
		Pager cp = new Pager(pageInfoVo.getCommentPageNum(),
				pageInfoServiceImpl.getCommentCountByTopicId(pageInfoVo
						.getTopicId()), Constant.SECOND_COMMENT_NUM);
		int readCount = t.getCountBrowse();
		readCount++;
		t.setCountBrowse(readCount);//���������Ժ�˵���Ѿ����������������������ϼ�һ
		this.userServiceImpl.updateTopic(t);
		try {
			cr = this.pageInfoServiceImpl.getCommentAndReply(cp, pageInfoVo.getTopicId());
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		pageInfoVo.setCp(cp);
		
	
		this.topicList = this.pageInfoServiceImpl.userHadReadTopic(pageInfoVo.getTopicId());//ȡ�����������û������������
		
		if(userId() != -1){//���flagUserΪ�գ�˵�����û��������û�����Ϊ�վͿ��Խ����û��ʹ���Ķ��뱻���Ĺ�ϵ
		int readUserId = userId();		
		UserReadTopic urt = new UserReadTopic();
		urt.setTopic(pageInfoServiceImpl.getTopicById(pageInfoVo.getTopicId()));
		urt.setUser(pageInfoServiceImpl.getUser(readUserId));
		this.pageInfoServiceImpl.buildUserReadTopic(urt);
		//���������Ժ�˵���Ѿ����������������������ϼ�һ
	    this.topicRemindServiceImpl.deleteTopicRemind(readUserId, t.getId());//������Ӷ�̬
		}
		return "readTopicPage";
	}

	// ��ʾ��������ҳ�溯��
	public String secondPage() {
		
		try {
		
			categoryList = pageInfoServiceImpl.getAllCategory();
			categoryChildList = pageInfoServiceImpl.getCategoryChildByC(pageInfoVo
					.getCategoryId());
	pageInfoVo.setCategoryChildList(categoryChildList);
			resourcefileList = pageInfoServiceImpl.lateResource_C(pageInfoVo
					.getCategoryId());
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return "secondPage";
	}

	
	public void setCategoryChildList(List<CategoryChild> categoryChildList) {
		this.categoryChildList = categoryChildList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
public void setCountNotReadLetter(int countNotReadLetter) {
	this.countNotReadLetter = countNotReadLetter;
}
public void setHotResourceList(List<Resourcefile> hotResourceList) {
	this.hotResourceList = hotResourceList;
}
	public void setLetterId(int letterId) {
		this.letterId = letterId;
	}

	public void setLetterNum(int letterNum) {
		this.letterNum = letterNum;
	}

	public void setListLetter(List<Letter> listLetter) {
		this.listLetter = listLetter;
	}
	 public void setLp(Pager lp) {
		this.lp = lp;
	}
	 
	@Resource(name = "managerServiceImpl")
	public void setManagerServiceImpl(ManagerServiceImpl managerServiceImpl) {
		this.managerServiceImpl = managerServiceImpl;
	}
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	@Resource(name = "pageInfoServiceImpl")
	public void setPageInfoServiceImpl(PageInfoServiceImpl pageInfoServiceImpl) {
		this.pageInfoServiceImpl = pageInfoServiceImpl;
	}
    public void setPageInfoVo(PageInfoVo pageInfoVo) {
		this.pageInfoVo = pageInfoVo;
	}
    public void setResourcefileList(List<Resourcefile> resourcefileList) {
		this.resourcefileList = resourcefileList;
	}
    public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
    public void setTopicListHot(List<Topic> topicListHot) {
		this.topicListHot = topicListHot;
	}
    public void setU(User u) {
		this.u = u;
	}
    public void setUserActive(List<User> userActive) {
		this.userActive = userActive;
	}
    public void setUserContribute(List<User> userContribute) {
		this.userContribute = userContribute;
	}
    public void setUserList(List<User> userList) {
		this.userList = userList;
	}
   @Resource(name = "userServiceImpl")
public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
	this.userServiceImpl = userServiceImpl;
}
	public String showFriendInfo(){//��ʾ���ѵ���Ϣ
		u = userServiceImpl.getUser(pageInfoVo.getFriendId());
		return "showFriendInfo";
	}

	public String showUserInfo() {// ��ʾ�û���Ϣ
		if (checkOn()) {
			try {
				
				u = userServiceImpl.getUser(pageInfoVo.getUserId());
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return "showUserInfo";

		}
		return "toLoginPage";
	}

	public String toCHTopicList(){//��ȡ��ģ����������ӣ�ע�⣬��categoryChild
	
		Pager p = new Pager(pageInfoVo.getTopicPageNum(),pageInfoServiceImpl.getTopicCountByCategoryChildId(pageInfoVo.getCategoryChildId()),Constant.SECOND_TOPIC_NUM);
		topicList = pageInfoServiceImpl.getTopicByPageByCategoryChildId(p, pageInfoVo.getCategoryChildId());
		pageInfoVo.setTp(p);
		return "toCHTopicList";
	}

	public String toCTopicList(){//��ȡ��ģ����������ӣ�ע�⣬��category
	
		Pager p = new Pager(pageInfoVo.getTopicPageNum(),pageInfoServiceImpl.getTopicCountByCategoryId(pageInfoVo.getCategoryId()),Constant.SECOND_TOPIC_NUM);
	
		topicList = pageInfoServiceImpl.getTopicByPageByCategoryId(p, pageInfoVo.getCategoryId());
	
		pageInfoVo.setTp(p);
		return "toCTopicList";
		
	}

	public String toFriendCenter(){
    	u = userServiceImpl.getUser(pageInfoVo.getFriendId());
    	return "toFriendCenter";
    }

	public String toFriendTopices(){
		int friendId = pageInfoVo.getFriendId();
    	Pager  p = new Pager(pageInfoVo.getTopicPageNum(),pageInfoServiceImpl.getTopicCountByUserId(friendId),Constant.SECOND_TOPIC_NUM);
    	
    	topicList = pageInfoServiceImpl.findTopicByUser(p, friendId);
    	System.out.println("toFriendTopices"+topicList);
    	pageInfoVo.setTp(p);
		return "toFriendTopices";
	}

	public String toInbox(){ //��ת���ռ���
    
		session = ActionContext.getContext().getSession();
    	int userId = Integer.parseInt(session.get("userId").toString());
    	this.lp = new Pager(this.letterNum,userServiceImpl.countreceiveLetter(userId),Constant.LETTERNUM);
        this.listLetter = userServiceImpl.receiveLetter(lp, userId);
    	return "toInbox";
    }

	public String toNewsList(){
		try {
			categoryList = pageInfoServiceImpl.getAllCategory();
			Pager np = new Pager(pageInfoVo.getNewsPageNum(),
					managerServiceImpl.newsCount(), 5);
			pageInfoVo.setNp(np);
			newsList = managerServiceImpl.findAllNews(np);
//			pageInfoVo.setLt(newsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "toNewsList";
	}
	public String toOutbox(){ //��ת��������
    	session = ActionContext.getContext().getSession();
    	int userId = Integer.parseInt(session.get("userId").toString());
    	this.lp = new Pager(this.letterNum,userServiceImpl.countsenderLetter(userId),Constant.LETTERNUM);
        this.listLetter = userServiceImpl.senderLetter(lp, userId);
    	return "toOutbox";
    }
	public String toPersonCenter(){//��������
    	int userId = pageInfoVo.getUserId();
    	pageInfoVo.setUserId(userId);
    	Pager p = new Pager(pageInfoVo.getUserPageNum(),pageInfoServiceImpl.countOfFriendIgnoreGroup(pageInfoVo.getUserId()),Constant.MANAGER_USER_NUM);
    	userList = pageInfoServiceImpl.findIgnoreGroup(p, pageInfoVo.getUserId());
    	System.out.println("toPersonCenter"+userList);
		pageInfoVo.setU_p(p);
		this.countNotReadLetter = userServiceImpl.countNotReadLetter(userId);
		notCheck = pageInfoServiceImpl.countOfNotCheck(userId);
		this.topicRemind = this.topicRemindServiceImpl.topicCountNew(userId);
    	return "toPersonCenter";
    }
	public String toPersonTopic(){//����˵�����
    	int userId = pageInfoVo.getUserId();
    	Pager  p = new Pager(pageInfoVo.getTopicPageNum(),pageInfoServiceImpl.getTopicCountByUserId(userId),Constant.SECOND_TOPIC_NUM);
    	topicList = pageInfoServiceImpl.findTopicByUser(p, userId);
    	
    	pageInfoVo.setTp(p);
    		return "toPersonTopic";
    }

	public String topicListPage() {
		Pager p = new Pager(pageInfoVo.getTopicPageNum(),
				pageInfoServiceImpl.getTopicCount(), Constant.ALLTOPIC);
		categoryList = pageInfoServiceImpl.getAllCategory();
		topicList = pageInfoServiceImpl.getTopicByPage(p);
		if(1 == pageInfoVo.getTopicPageNum()){
		topicList.addAll(0, pageInfoServiceImpl.getTopTopic());
		}
		pageInfoVo.setTp(p);
		return "topicListPage";
	}

	public String toReadFriendResource(){//������Դ��ҳ��
    	int friendId = pageInfoVo.getFriendId();
    	Pager p = new Pager(pageInfoVo.getResourcrfilePageNum(),pageInfoServiceImpl.getResourcefileCountByUser(friendId)
    			,Constant.SECOND_RESOURCE_NUM);
    	
    	resourcefileList = pageInfoServiceImpl.findResourcefileByUserId(p, friendId);
    	System.out.println(resourcefileList);
    	pageInfoVo.setRfp(p);
    	return "toReadFriendResource";
    }

	public String toReadJoinTopic(){//���Ҳ������������
    	int userId = pageInfoVo.getUserId();
    	Pager  p = new Pager(pageInfoVo.getTopicPageNum(),pageInfoServiceImpl.countOfUserJoinTopics(userId),Constant.SECOND_TOPIC_NUM);
    	topicList = pageInfoServiceImpl.findUserJionTopics(p, userId);
    	pageInfoVo.setTp(p);
    	return "toReadJoinTopic";
    }

	public void toReadMessag(){
		categoryList = pageInfoServiceImpl.getAllCategory();
		this.letter = this.userServiceImpl.getLetterById(this.letterId);
		
		
	}
	public String toReadInMessag(){
		this.toReadMessag();
		if(this.letter.getReadOrNot().equals(Constant.LETTERNOTREAD)){//������Ϣδ��������Ϊ�Ѷ�
			this.letter.setReadOrNot(Constant.LETTERREAD);
			this.userServiceImpl.updateLette(letter);
		}
		return "toReadInMessag";
	}
	public String toReadOutMessag(){
		this.toReadMessag();
		return "toReadOutMessag";
	}
	public String toReadPersonResource(){//����˵���Դ
    	int userId = pageInfoVo.getUserId();
    	Pager p = new Pager(pageInfoVo.getResourcrfilePageNum(),pageInfoServiceImpl.getResourcefileCountByUser(userId)
    			,Constant.SECOND_RESOURCE_NUM);
    	resourcefileList = pageInfoServiceImpl.findResourcefileByUserId(p, userId);
    	pageInfoVo.setRfp(p);
    	return"toReadPersonResource";
    }

	public String toResourcePage(){//����Դ��
    	try {
			categoryList = pageInfoServiceImpl.getAllCategory();
			Pager rp = new Pager(pageInfoVo.getResourcePageNum(),pageInfoServiceImpl.getResourcefileCount(),Constant.SECOND_RESOURCE_NUM);
			resourcefileList = pageInfoServiceImpl.findResourcefileAll(rp);
			pageInfoVo.setRfp(rp);
			hotResourceList = pageInfoServiceImpl.findResourcefileHot();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return "toResourcePage";
    }
	
	public String systemMessages(){
		session = ActionContext.getContext().getSession();
		HttpServletResponse response = (HttpServletResponse) ActionContext
		.getContext().get(ServletActionContext.HTTP_RESPONSE);
		int userId = (Integer)session.get("userId");
		SMp = new Pager(mpNumber,this.pageInfoServiceImpl.countOfSystemMessage(userId),15);
		try {
			listSystemMessage = this.pageInfoServiceImpl.findSystemMessage(
					userId, SMp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "systemMessages";
	}
	public void setNotCheck(int notCheck) {
		this.notCheck = notCheck;
	}
	public int getNotCheck() {
		return notCheck;
	}

}
