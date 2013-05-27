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
public class Resourcefile {
	public int id;
	public Date date;
	public String fileName;
	public int downNum;
	public String filePath;
	public float size;
	public String state;
	public User user;
	public Category category;

	@Id
	@Column(name = "resourcefile_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "resourcefile_date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "resourcefile_filename")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "resourcefile_downNum")
	public int getDownNum() {
		return downNum;
	}

	public void setDownNum(int downNum) {
		this.downNum = downNum;
	}

	@Column(name = "resourcefile_filePath")
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "resourcefile_size")
	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	@Column(name = "resourcefile_state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@ManyToOne
	@JoinColumn(name = "resourcefile_user_Id", nullable = false,referencedColumnName = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name = "resourcefile_category_Id", nullable = false,referencedColumnName = "category_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
