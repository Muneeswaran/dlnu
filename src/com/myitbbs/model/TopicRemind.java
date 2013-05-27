package com.myitbbs.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TopicRemind {
private int id;
private User u;
private Topic t;
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
@JoinColumn(name = "uid",nullable = false, referencedColumnName = "user_id")
public User getU() {
	return u;
}
public void setU(User u) {
	this.u = u;
}
@ManyToOne
@JoinColumn(name = "tid",nullable = false, referencedColumnName = "topic_id")
public Topic getT() {
	return t;
}
public void setT(Topic t) {
	this.t = t;
}

}
