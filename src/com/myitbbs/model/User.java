package com.myitbbs.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
	private int Id;
	private String name;
	private String passWord;
	private String qq;
	private String email;
	private String tel;
	private String truename;
	private Date birthday;

	private String sex;
	private String nation;
	private String major;
	private int entranceYear;
	private String state;
	private int permission;
	private String online;
	@Id
	@Column(name="user_id")
	@OneToMany(cascade=CascadeType.ALL)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	@Column(name="user_name",unique=true,nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="user_password",nullable = false)
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Column(name="user_qq")
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	@Column(name="user_email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="user_tel")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name="user_trueName")
	public String getTruename() {
		return truename;
	}
	public void setTruename(String turename) {
		this.truename = turename;
	}
	@Column(name="user_birthday")
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Column(name="user_sex",nullable = false)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Column(name="user_nation")
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	@Column(name="user_major")
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Column(name="user_entranceYear")
	public int getEntranceYear() {
		return entranceYear;
	}
	
	public void setEntranceYear(int entranceYear) {
		this.entranceYear = entranceYear;
	}
	@Column(name="user_state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="user_permission",nullable = false)
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
	@Column(name="user_online")
	public String isOnline() {
		return online;
	}
	public void setOnline(String online) {
		this.online = online;
	}
	
}
