package com.myitbbs.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*
 * 用户浏览帖子的记录
 * 
 */
@Entity
public class UserReadTopic {
private int id;//记录的ID
private User user;//用户
private Topic topic;//帖子
@Id
@OneToMany(cascade={CascadeType.ALL})
@GeneratedValue(strategy=GenerationType.AUTO)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@ManyToOne
@JoinColumn(name = "userId",nullable = false, referencedColumnName = "user_id")
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@ManyToOne
@JoinColumn(name = "topicId",nullable = false, referencedColumnName = "topic_id")
public Topic getTopic() {
	return topic;
}
public void setTopic(Topic topic) {
	this.topic = topic;
}
}
