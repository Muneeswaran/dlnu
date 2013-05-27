package com.myitbbs.vo;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.myitbbs.constant.Constant;
import com.myitbbs.uitl.Pager;

public class ManagerInfoVo {
	private int select = 2;
	public int getSelect() {
		return select;
	}
	private String message;//提示消息
	private String path;//路径
	public String getPath() {
		
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	
	public String getMessage() {
	
		return this.message;
	}
	public void setMessage(String message) {

		this.message = message;
	}
	// 用户信息
	private int userId;
	private String userName;
	private String userPassword;
	private String userQq;
	private String userEmail;
	private String userTel;
	private String userTruename;
	private Date userBirthday;
	private String userSex;
	private String userNation;
	private String userMajor;
	private int userEntranceYear;
	private String userState;
	private String userPermission;
	private int userPermission1;
    private Pager u_p;//用户分页的信息
	public Pager getU_p() {
		return u_p;
	}
	public void setU_p(Pager uP) {
		u_p = uP;
	}
	public int getUserPageNum() {
		return userPageNum;
	}

	private int userPage = 1;
	private int userCount;//用户的个数
	private int userPageNum = Constant.MANAGER_USER_NUM;
	public int getUserPage() {
		return userPage;
	}
	public void setUserPage(int userPage) {
		
		this.userPage = userPage;
	}
	public int getUserPermission1() {
		return userPermission1;
	}
	public void setUserPermission1(int userPermission1) {
		this.userPermission1 = userPermission1;
	}
	private String userTip;    // 显示添加用户或修改用户的提示信息

	/*********模块的属性*****************/
	private String categoryName;
	private String categoryDescribe;
	private int categoryId;
	
	
	/****************子模块的属性*********************/
	private int categoryChildId;
	public int getCategoryChildId() {
		return categoryChildId;
	}
	public void setCategoryChildId(int categoryChildId) {
		this.categoryChildId = categoryChildId;
	}
	private String categoryChildName;
	private String categoryChildDescribe;	
	
	/**************新闻属性****************************/
	
	private String newsName;
	private String content1;
	private int newsCount;
	private int newsPageNum = Constant.MANAGER_NEWS_NUM;//每页显示的个数
	private int newsPage = 1;//页数
	private String newsTitle;
	private int newsId;
	private Pager np;
	public Pager getNp() {
		return np;
	}
	public void setNp(Pager np) {
		this.np = np;
	}
	/********************帖子属性**********************************/
	private int topicPageNum = Constant.MANAGER_TOPIC_NUM;//每页显示的个数
	private int topicPage = 1;//页数
	private int topicCount;/********************可以删******************/
	private int topicid;
	private String topicTop;//帖子是否置顶
	private  Pager tp;
	
	public void setTp(Pager tp) {
		this.tp = tp;
	}
	public Pager getTp() {
		return tp;
	}
	 /**********评论***********/
	private int commentPageNum = Constant.MANAGER_COMMENT_NUM;
	private int commentPage = 1;
	private int commentCount;
	private int commentId;
	private Pager cp;
	public Pager getCp() {
		return cp;
	}
	public void setCp(Pager cp) {
		this.cp = cp;
	}
	public int getCommentPage() {
		return commentPage;
	}
	public void setCommentPage(int commentPage) {
		this.commentPage = commentPage;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getCommentPageNum() {
		return commentPageNum;
	}
	public String getTopicTop() {

		return topicTop;
	}
	public void setTopicTop(String topicTop) {
	
		this.topicTop = topicTop;
	}
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public int getTopicCount() {
		return topicCount;
	}
	public void setTopicCount(int topicCount) {
		this.topicCount = topicCount;
	}
	public int getTopicPage() {
		return topicPage;
	}
	public void setTopicPage(int topicPage) {
		
		this.topicPage = topicPage;
	}
	public int getTopicPageNum() {
		return topicPageNum;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getNewsCount() {
		return newsCount;
	}
	public void setNewsCount(int newsCount) {
		this.newsCount = newsCount;
	}
	public int getNewsPage() {
		return newsPage;
	}
	public void setNewsPage(int newsPage) {
		this.newsPage = newsPage;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public int getNewsPageNum() {
		return newsPageNum;
	}
	public String getNewsName() {
		return newsName;
	}
	public void setNewsName(String newsName) {
		try {
			this.newsName = new String(newsName.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		try {
			this.content1 = new String(content1.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/******************用户的权限*****************************/
	private int adminP = Constant.ADMIN_PERMISSION;   //管理员权限
	private int permission;
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	public int getAdminP() {
		return adminP;
	}
	public int getUserP() {
		return userP;
	}
	private int userP = Constant.USER_PERMISSION;     //普通用户权限
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		
		this.categoryId = categoryId;
	}
	public String getCategoryChildName() {
		return categoryChildName;
	}
	public void setCategoryChildName(String categoryChildName) {
		try {
			this.categoryChildName = new String(categoryChildName.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}                
	
	public String getCategoryChildDescribe() {
	
		return categoryChildDescribe;
	}
	public void setCategoryChildDescribe(String categoryChildDescribe) {
		
		try {
			this.categoryChildDescribe = new String(categoryChildDescribe.getBytes("ISO8859-1"),"utf-8");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		try {
			this.categoryName = new String(categoryName.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getCategoryDescribe() {
		return categoryDescribe;
	}
	public void setCategoryDescribe(String categoryDescribe) {
		try {
			this.categoryDescribe = new String(categoryDescribe.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		try {
			this.userName = new String(userName.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserQq() {
		return userQq;
	}
	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserTruename() {
		return userTruename;
	}
	public void setUserTruename(String userTruename) {
		try {
			this.userTruename = new String(userTruename.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Date getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		try {
			this.userSex = new String(userSex.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUserNation() {
		return userNation;
	}
	public void setUserNation(String userNation) {
		try {
			this.userNation = new String(userNation.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUserMajor() {
		return userMajor;
	}
	public void setUserMajor(String userMajor) {
		try {
			this.userMajor = new String(userMajor.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getUserEntranceYear() {
		return userEntranceYear;
	}
	public void setUserEntranceYear(int userEntranceYear) {
		this.userEntranceYear = userEntranceYear;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		try {
			this.userState = new String(userState.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getUserPermission() {
		return userPermission;
	}
	public void setUserPermission(String userPermission) {
		this.userPermission = userPermission;
	}
	public String getUserTip() {
		return userTip;
	}
	public void setUserTip(String userTip) {
		this.userTip = userTip;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public int getUserCount() {
		return userCount;
	}

}
