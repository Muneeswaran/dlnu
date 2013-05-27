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
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;

import org.hibernate.annotations.Type;
@Entity
public class MessageBoard {
private String content;//���԰������
private Date date;//�������� 
private int id;//id
private String readed;//�Ƿ������
@Column
public String getReaded() {
	return readed;
}
public void setReaded(String readed) {
	this.readed = readed;
}
private User master;//����
private User visitor;//������
@Id
@Column(name = "id")
@OneToMany(cascade={CascadeType.ALL})
@GeneratedValue(strategy = GenerationType.AUTO )
public int getId() {
	return id;
}
@Column(name = "content")
public String getContent() {
	return content;
}
@Column(name = "date")
public Date getDate() {
	return date;
}


@OneToOne
@JoinColumn(name = "masterId",nullable = false, referencedColumnName = "user_id")
public User getMaster() {
	return master;
}
@ManyToOne
@JoinColumn(name = "visitorId",nullable = false, referencedColumnName = "user_id")
public User getVisitor() {
	return visitor;
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

public void setMaster(User master) {
	this.master = master;
}
public void setVisitor(User visitor) {
	this.visitor = visitor;
}
@Override
public String toString() {

	System.out.println("*********************");
	System.out.println("id = "+this.id);
	System.out.println("���� = " +this.getMaster().getName());
	System.out.println("���� = " +this.getVisitor().getName());
	return "������ ��"+this.content+"\n"+"*********************";

}

}
