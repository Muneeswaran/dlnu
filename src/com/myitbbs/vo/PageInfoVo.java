package com.myitbbs.vo;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.myitbbs.constant.Constant;
import com.myitbbs.model.Category;
import com.myitbbs.model.CategoryChild;
import com.myitbbs.model.Comment;
import com.myitbbs.model.News;
import com.myitbbs.model.Reply;
import com.myitbbs.model.Topic;
import com.myitbbs.uitl.Pager;

public class PageInfoVo {
	// 各个显示列表的当前页数
	private int topicPageNum = 1;
	private int newsPageNum = 1;
	private int userPageNum = 1;
	private int resourcePageNum = 1;
	private int commentPageNum = 1;
	private int replyPageNum = 1;
	private int categoryChildPageNum = 1;
	private int resourcrfilePageNum = 1;
//各个页面的属性
	private Pager tp;//帖子的。
    private Pager np;//新闻的
	private Pager cp;//评论的。
	private Pager u_p;//用户的。
    private Pager rfp;//资源的。

    
//    private List<News> lt;
//
//	public List<News> getLt() {
//		return lt;
//	}
//
//	public void setLt(List<News> lt) {
//		this.lt = lt;
//	}

	public Pager getRfp() {
		return rfp;
	}

	public void setRfp(Pager rfp) {
		this.rfp = rfp;
	}

	public Pager getU_p() {
		return u_p;
	}

	public void setU_p(Pager uP) {
		u_p = uP;
	}

	public Pager getCp() {
		return cp;
	}

	public void setCp(Pager cp) {
		this.cp = cp;
	}

	public Pager getNp() {
		return np;
	}

	public void setNp(Pager np) {
		this.np = np;
	}

	public Pager getTp() {
		return tp;
	}

	public void setTp(Pager tp) {
		this.tp = tp;
	}

	public int getResourcrfilePageNum() {
		return resourcrfilePageNum;
	}

	public void setResourcrfilePageNum(int resourcrfilePageNum) {
		this.resourcrfilePageNum = resourcrfilePageNum;
	}

	public int getCategoryChildPageNum() {
		return categoryChildPageNum;
	}

	public void setCategoryChildPageNum(int categoryChildPageNum) {
		this.categoryChildPageNum = categoryChildPageNum;
	}

	// 各个所要访问或当前访问的实体Id号
	private int categoryId = 0;
	private int categoryChildId = 0;
	private int userId = 0;
	private int topicId = 0;
	private int commentId = 0;
	private int ReplyId = 0;
	private int newsId = 0;
	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	
	//用户信息
	private String name;
	private Date birthday;
	private String address;
	private String email;
	private String tel;
	private String file;
	private String nation;
	
	public int friendId;
	
	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		try {
			this.nation = new String(nation.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 二级分类页面中的每页的数据个数
	public int secondNewsPageNum = Constant.SECOND_NEWS_NUM;
	public int secondTopicPageNum = Constant.SECOND_TOPIC_NUM;
	public int secondResourcefilePageNum = Constant.SECOND_RESOURCE_NUM;
	public int secondCommentPageNum = Constant.SECOND_COMMENT_NUM;
	public int secondReplyPageNum = Constant.SECOND_REPLY_NUM;
	public int secondCategoryChildPageNum = Constant.SECOND_CATEGORYCHID_NUM;
	public int secondResourcePageNum = Constant.SECOND_RESOURCE_NUM;
	

	public int getSecondResourcePageNum() {
		return secondResourcePageNum;
	}

	private int topicByCategoryChildCount; // 每个板块帖子的总数-------------->可以删
	private int newsCountByCategoryId;// 每个模块新闻的个数-------------->可以删
	private int resourceCountByCategoryId;// 每个模块资源的个数
	public int getResourceCountByCategoryId() {
		return resourceCountByCategoryId;
	}

	public void setResourceCountByCategoryId(int resourceCountByCategoryId) {
		this.resourceCountByCategoryId = resourceCountByCategoryId;
	}

	private int comentCountByTopicId;//每个帖子评论的个数
	private int topicByUserCount;//每个用户帖子的总数
	private int resourceByUserCount;//每个用户资源的总数

	public int getResourceByUserCount() {
		return resourceByUserCount;
	}

	public void setResourceByUserCount(int resourceByUserCount) {
		this.resourceByUserCount = resourceByUserCount;
	}

	public int getTopicByUserCount() {
		return topicByUserCount;
	}

	public void setTopicByUserCount(int topicByUserCount) {
		this.topicByUserCount = topicByUserCount;
	}

	private Topic topic;//前台的一个帖子	
	private Comment comment;//前台的一个评论
	private List<Reply> replyList;
	private List<Comment> commentList;
	private List<CategoryChild> categoryChildList;
	private News news;// 用来显示新闻
	private Category category;

	
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	

	private Map<Comment, List<Reply>> cAndr;// 存放评论和回复

	public Map<Comment, List<Reply>> getcAndr() {
		return cAndr;
	}

	public void setcAndr(Map<Comment, List<Reply>> cAndr) {
		this.cAndr = cAndr;
	}

	public int getNewsCountByCategoryId() {
		return newsCountByCategoryId;
	}

	public void setNewsCountByCategoryId(int newsCountByCategoryId) {
		this.newsCountByCategoryId = newsCountByCategoryId;
	}

	public List<CategoryChild> getCategoryChildList() {
		return categoryChildList;
	}

	public void setCategoryChildList(List<CategoryChild> categoryChildList) {
		this.categoryChildList = categoryChildList;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public int getSecondCommentPageNum() {
		return secondCommentPageNum;
	}

	public void setSecondCommentPageNum(int secondCommentPageNum) {
		this.secondCommentPageNum = secondCommentPageNum;
	}

	public int getSecondReplyPageNum() {
		return secondReplyPageNum;
	}

	public void setSecondReplyPageNum(int secondReplyPageNum) {
		this.secondReplyPageNum = secondReplyPageNum;
	}

	public int getSecondCategoryChildPageNum() {
		return secondCategoryChildPageNum;
	}

	public void setSecondCategoryChildPageNum(int secondCategoryChildPageNum) {
		this.secondCategoryChildPageNum = secondCategoryChildPageNum;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public int getTopicPageNum() {
		return topicPageNum;
	}

	public void setTopicPageNum(int topicPageNum) {
		this.topicPageNum = topicPageNum;
	}

	public int getNewsPageNum() {
		return newsPageNum;
	}

	public void setNewsPageNum(int newsPageNum) {
		this.newsPageNum = newsPageNum;
	}

	public int getUserPageNum() {
		return userPageNum;
	}

	public void setUserPageNum(int userPageNum) {
		this.userPageNum = userPageNum;
	}

	public int getResourcePageNum() {
		return resourcePageNum;
	}

	public void setResourcePageNum(int resourcePageNum) {
		this.resourcePageNum = resourcePageNum;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCategoryChildId() {
		return categoryChildId;
	}
	            
	public void setCategoryChildId(int categoryChildId) {
		this.categoryChildId = categoryChildId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getSecondNewsPageNum() {
		return secondNewsPageNum;
	}

	public void setSecondNewsPageNum(int secondNewsPageNum) {
		this.secondNewsPageNum = secondNewsPageNum;
	}

	public int getSecondTopicPageNum() {
		return secondTopicPageNum;
	}

	public void setSecondTopicPageNum(int secondTopicPageNum) {
		this.secondTopicPageNum = secondTopicPageNum;
	}

	public int getSecondResourcefilePageNum() {
		return secondResourcefilePageNum;
	}

	public void setSecondResourcefilePageNum(int secondResourcefilePageNum) {
		this.secondResourcefilePageNum = secondResourcefilePageNum;
	}

	public int getTopicByCategoryChildCount() {
		return topicByCategoryChildCount;
	}

	public void setTopicByCategoryChildCount(int topicByCategoryChildCount) {
		this.topicByCategoryChildCount = topicByCategoryChildCount;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getReplyId() {
		return ReplyId;
	}

	public void setReplyId(int replyId) {
		ReplyId = replyId;
	}

	public int getCommentPageNum() {
		return commentPageNum;
	}

	public void setCommentPageNum(int commentPageNum) {
		this.commentPageNum = commentPageNum;
	}

	public int getReplyPageNum() {
		return replyPageNum;
	}

	public void setReplyPageNum(int replyPageNum) {
		this.replyPageNum = replyPageNum;
	}

	public void setComentCountByTopicId(int comentCountByTopicId) {
		this.comentCountByTopicId = comentCountByTopicId;
	}

	public int getComentCountByTopicId() {
		return comentCountByTopicId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		try {
			this.name = new String(name.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		try {
			this.address = new String(address.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		try {
			this.email = new String(email.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}


	
}
