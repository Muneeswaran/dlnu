package com.myitbbs.model;
/*
 * 好友
 */
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Friend {
private int id;//好友的标识id
private User master;
private User _friend;//好友
@Id
@OneToMany(cascade={CascadeType.ALL})
@GeneratedValue(strategy = GenerationType.AUTO )
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@ManyToOne
@JoinColumn(name = "masterId",nullable = false, referencedColumnName = "user_id")
public User getMaster() {
	return master;
}
public void setMaster(User master) {
	this.master = master;
}
//@ManyToOne
//@JoinColumn(name = "friendId",nullable = false, referencedColumnName = "user_id")
//public User getFriend() {
//	return friend;
//}
//public void setFriend(User friend) {
//	this.friend = friend;
//}
@Override
public String toString() {
	System.out.println("*********************");
	System.out.println("id = "+this.id);
	
	System.out.println("好友 = " +this.get_friend().getName());
	System.out.println("*********************");
	return null;
}
@ManyToOne
@JoinColumn(name = "_friendId",nullable = false, referencedColumnName = "user_id")
public User get_friend() {
	return _friend;
}
public void set_friend(User friend) {
	_friend = friend;
}


}
