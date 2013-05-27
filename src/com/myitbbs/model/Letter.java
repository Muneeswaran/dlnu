package com.myitbbs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Letter {
	private int id;
	private Date date;
	private String content;
	private User sender;
	private User receiver;
	private String readOrNot;		

	@Id
	@Column(name="letter_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	@Column(name="letter_content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	@ManyToOne
	@JoinColumn(name = "Letter_sender_Id",nullable = false, referencedColumnName = "user_id")
	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}
	@ManyToOne
	@JoinColumn(name = "Letter_receiver_Id",nullable = false, referencedColumnName = "user_id")
	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		System.out.println(receiver);
		this.receiver = receiver;
	}
	@Column(name="letter_readOrNot")
	public String getReadOrNot() {
		return readOrNot;
	}

	public void setReadOrNot(String readOrNot) {
		this.readOrNot = readOrNot;
	}
	@Column(name="letter_date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
