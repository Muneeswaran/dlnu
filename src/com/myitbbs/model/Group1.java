package com.myitbbs.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/*
 * 组，好友的分组
 * import java.util.Date;

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
 */
@Entity(name="_Group")
public class Group1 {
private int id;//组的标识id
private String name;//组的名字
private User master;//归属于哪个用户
@ManyToOne
@JoinColumn(name = "masterId",nullable = false, referencedColumnName = "user_id")
public User getMaster() {
	return master;
}
public void setMaster(User master) {
	this.master = master;
}
@Id
@Column(name = "id")
@OneToMany(cascade={CascadeType.ALL})
@GeneratedValue(strategy = GenerationType.AUTO )
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Column(name = "name")
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {

	System.out.println("*********************");
	System.out.println("id = "+this.id);
	System.out.println("组的名字 = " +this.getName());
	System.out.println("主人 = " +this.getMaster().getName());
	System.out.println("*********************");
	return null;

}

}
