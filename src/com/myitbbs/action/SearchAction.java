package com.myitbbs.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.constant.Constant;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.service.SearchService;
import com.myitbbs.uitl.Pager;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope("prototype")
public class SearchAction extends ActionSupport{
	private String key;//关键字
	private List<Resourcefile> resourcefileList;//资源序列
	private Pager resourcefilePager;//资源分页
	private List<Topic> topicList;//帖子序列
	private Pager topicPager;////帖子用户分页
	private List<User> userList;//用户序列
	private Pager userPager;//用户分页
	private SearchService searchServiceImpl;
	private int topicPageNum = 1;
	private int resourcePageNum = 1;
	private int userPageNum = 1;
	public int getTopicPageNum() {
		return topicPageNum;
	}
	public void setTopicPageNum(int topicPageNum) {
		this.topicPageNum = topicPageNum;
	}
	public int getResourcePageNum() {
		return resourcePageNum;
	}
	public void setResourcePageNum(int resourcePageNum) {
		this.resourcePageNum = resourcePageNum;
	}
	public int getUserPageNum() {
		return userPageNum;
	}
	public void setUserPageNum(int userPageNum) {
		this.userPageNum = userPageNum;
	}
	public SearchService getSearchServiceImpl() {
		return searchServiceImpl;
	}
	@Resource
	public void setSearchServiceImpl(SearchService searchServiceImpl) {
		this.searchServiceImpl = searchServiceImpl;
	}
	public String getKey() {
		return key;
	}
	public List<Resourcefile> getResourcefileList() {
		return resourcefileList;
	}
	public Pager getResourcefilePager() {
		return resourcefilePager;
	}
	public List<Topic> getTopicList() {
		return topicList;
	}
	public Pager getTopicPager() {
		return topicPager;
	}
	public List<User> getUserList() {
		return userList;
	}
	public Pager getUserPager() {
		return userPager;
	}
	public void setKey(String key) {
		try {
			this.key = new String(key.getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setResourcefileList(List<Resourcefile> resourcefileList) {
		this.resourcefileList = resourcefileList;
	}
	public void setResourcefilePager(Pager resourcefilePager) {
		this.resourcefilePager = resourcefilePager;
	}
	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}
	public void setTopicPager(Pager topicPager) {
		this.topicPager = topicPager;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public void setUserPager(Pager userPager) {
		this.userPager = userPager;
	}
	 public String toAboutAdmin(){//跳到搜索的主页面
	    	
	    	return "toAboutAdmin";
	    }
	 public String toAboutTopic(){
		 topicPager = new Pager(topicPageNum,searchServiceImpl.countOfAboutTopic(key),Constant.SEARCHTOPIC);
	
		 topicList = this.searchServiceImpl.findTopicByKey(topicPager, key);
		 return "toAboutTopic";
	 }
	 public String toAboutResource(){
		 resourcefilePager = new Pager(resourcePageNum,searchServiceImpl.countOfAboutResourcefile(key),Constant.SEARCHRESOURS);
		resourcefileList = searchServiceImpl.findResourcefileByKey(resourcefilePager, key);
		 return "toAboutResource";
	 }
}
