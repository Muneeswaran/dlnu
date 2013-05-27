package com.myitbbs.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MB_Reply {
private String content;//留言板回复的内容
private Date date;//回复的时间
private int id;//id
private MessageBoard messageBoard;//留言板
private User replyer;//来访者
private String readed;//判断是否已读

public String getReaded() {
	return readed;
}
public void setReaded(String readed) {
	this.readed = readed;
}
public String getContent() {
	return content;
}
public Date getDate() {
	return date;
}
@Id
@OneToMany(cascade={CascadeType.ALL})
@GeneratedValue(strategy = GenerationType.AUTO )
public int getId() {
	return id;
}
@ManyToOne
@JoinColumn(name = "messageBoardId",nullable = false, referencedColumnName = "id")
public MessageBoard getMessageBoard() {
	return messageBoard;
}
@ManyToOne
@JoinColumn(name = "replyerId",nullable = false, referencedColumnName = "user_id")
public User getReplyer() {
	return replyer;
}
public void setContent(String content) {
	this.content = content;
}
public void setDate(Date date) {
	this.date = date;
}
public void setId(int id) {
	this.id = id;
}
public void setMessageBoard(MessageBoard messageBoard) {
	this.messageBoard = messageBoard;
}
public void setReplyer(User replyer) {
	this.replyer = replyer;
}
@Override
public String toString() {
	System.out.println("*********************");
	System.out.println("id = "+this.id);
	System.out.println("留言板  = " + this.getMessageBoard().getContent());
	System.out.println("回复者 = " +this.getReplyer().getName());
	System.out.println("回复内容  = " + this.getContent());
	
	return "*********************";
}

}
