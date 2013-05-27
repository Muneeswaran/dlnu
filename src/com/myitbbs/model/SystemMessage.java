package com.myitbbs.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class SystemMessage {
private int id;//ID属性
private User master;//主人
private User friend;//要加的好友
private String check;//审核
private Date date;//添加的时间
@Override
public String toString() {
	String comtent = "id = "+this.id+"\t master = "+this.master.getName()+"\t friend = "+this.friend.getName()+"\t 审核状态："+this.check+"\t 时间="+this.date;
	return comtent;
}
@Id
@OneToMany(cascade={CascadeType.ALL})
@Column(name="id")
@GeneratedValue(strategy=GenerationType.AUTO)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@ManyToOne
@JoinColumn(name = "masterId", nullable = false,referencedColumnName = "user_id")
public User getMaster() {
	return master;
}
public void setMaster(User master) {
	this.master = master;
}
@ManyToOne
@JoinColumn(name = "friendId", nullable = false,referencedColumnName = "user_id")
public User getFriend() {
	return friend;
}
public void setFriend(User friend) {
	this.friend = friend;
}
@Column(name="_check")
public String getCheck() {
	return check;
}
public void setCheck(String check) {
	this.check = check;
}
@Column(name="date")
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
}
