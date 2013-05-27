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
public class Comment {
	private int id;
	private String content;
	private Date date;
	private User user;
	private Topic topic;
	private String read;
	@Column(name = "comment_read")
	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	@Id
	@OneToMany(cascade={CascadeType.ALL})
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "comment_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "comment_content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "comment_date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToOne
	@JoinColumn(name = "comment_user_Id",nullable = false, referencedColumnName = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "comment_topic_Id",nullable = false, referencedColumnName = "topic_id")
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
