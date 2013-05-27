package com.myitbbs.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Entity;

@Entity
public class Topic {
	private CategoryChild categoryChild;
	private String contents;//帖子内容;
	private Date date;//日期
	private int id;
    private int countBrowse;//浏览数
    private int countComment;//回复数
    private int report;//举报
    @Column(name = "topic_report")
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	@Column(name = "topic_countBrowse")
	public int getCountBrowse() {
		return countBrowse;
	}
	public void setCountBrowse(int countBrowse) {
		this.countBrowse = countBrowse;
	}
	@Column(name = "topic_countComment")
	public int getCountComment() {
		return countComment;
	}
	public void setCountComment(int countComment) {
		this.countComment = countComment;
	}

	private String readOrNot;//是否已读

	private String title;//帖子标题
	private String top;//置顶
	private User user;//用户
	@ManyToOne
	@JoinColumn(name = "topic_categorychild_Id", nullable = false,referencedColumnName = "categorychild_id")
	public CategoryChild getCategoryChild() {
		return categoryChild;
	}
	@Column(name = "topic_contents")
	public String getContents() {
		return contents;
	}

	@Column(name = "topic_date")
	public Date getDate() {
		return date;
	}

	@Id
	@OneToMany(cascade={CascadeType.ALL})
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "topic_id")
	public int getId() {
		return id;
	}
	@Column(name = "topic_readOrNot",nullable = false)
	public String getReadOrNot() {
		return readOrNot;
	}

	@Column(name = "topic_title")
	public String getTitle() {
		return title;
	}

	@Column(name = "topic_top",nullable = false)
	public String getTop() {
		return top;
	}

	@ManyToOne
	@JoinColumn(name = "topic_user_Id",nullable = false, referencedColumnName = "user_id")
	public User getUser() {
		return user;
	}

	public void setCategoryChild(CategoryChild categoryChild) {
		this.categoryChild = categoryChild;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(int id) {
	
		this.id = id;
	}

	public void setReadOrNot(String readOrNot) {
		this.readOrNot = readOrNot;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		String str = "id="+this.id+"\n 标题 = "+this.title+"\n 作者 = "+this.user.getName()+"\n 举报数："+this.report;
		return str;
	}

	

}
