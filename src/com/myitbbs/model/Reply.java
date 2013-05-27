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
public class Reply {
	private int id;
	private String content;
	private Date date;
	private User user;
	private Comment comment;
    private String read;
    @Column(name = "reply_read")
	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToMany(cascade={CascadeType.ALL})
	@Column(name = "reply_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "reply_content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "reply_date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@ManyToOne
	@JoinColumn(name = "reply_user_Id", nullable = false,referencedColumnName = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "reply_comment_Id", nullable = false,referencedColumnName = "comment_id")
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		String str = "id = "+this.id+"\n ÆÀÂÛ="+this.comment.getContent()+"\n ÄÚÈÝ"+this.content;
		return str;
	}

}
