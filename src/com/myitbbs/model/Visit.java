package com.myitbbs.model;

import java.util.Date;
//select * from visit where date(date)=curdate(); ȡ�õ�����ʵ�
//select * from visit where month(Date)=month(now()) ;
//SELECT * from visit where WEEK(CURDATE(),0)=WEEK(date,0); ����
//select * from visit where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(date);���7��
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Visit {
private int id;//id����
private Date date;//ʱ������
@Id
@OneToMany(cascade={CascadeType.ALL})
@GeneratedValue(strategy=GenerationType.AUTO)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Column
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
}
