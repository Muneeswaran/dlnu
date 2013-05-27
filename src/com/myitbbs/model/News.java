package com.myitbbs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.myitbbs.model.Category;

@Entity
public class News {
	private Category category;
	private String content;
	private Date date;
	private int id;
	private String name;

	private boolean top;

	@ManyToOne()
	@JoinColumn(name = "news_category_Id", nullable = false,referencedColumnName = "category_id")
	public Category getCategory() {
		return category;
	}

	@Type(type = "text")
	@Column(name = "news_content")
	public String getContent() {
		return content;
	}

	@Column(name = "news_date")
	public Date getDate() {
		return date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "news_id")
	public int getId() {
		return id;
	}

	@Column(name = "news_name")
	public String getName() {
		return name;
	}

	@Column(name = "news_top")
	public boolean isTop() {
		return top;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

}
