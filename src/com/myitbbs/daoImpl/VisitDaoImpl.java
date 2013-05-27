package com.myitbbs.daoImpl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.VisitDao;
import com.myitbbs.model.Visit;
@Component("visitDaoImpl")
@Scope("prototype")
public class VisitDaoImpl implements VisitDao {
	HibernateTemplate hibernateTemplate;

	
	public int findCURDATE() throws Exception {
		String Count = this.hibernateTemplate.find("select Count(*) from Visit as v where date(v.date)=curdate()").get(0).toString();
		return Integer.parseInt(Count);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public int findCURMONTH() throws Exception {
		String Count = this.hibernateTemplate.find("select Count(*) from Visit as v where month(v.date)=month(now())").get(0).toString();
		return Integer.parseInt(Count);
	}

	public int findCURWEEK() throws Exception {
		String Count = this.hibernateTemplate.find("select Count(*) from Visit as v where WEEK(CURDATE(),0)=WEEK(v.date,0)").get(0).toString();
		return Integer.parseInt(Count);
	}

	public int findLATE7DAYS() throws Exception {
		String Count = this.hibernateTemplate.find("select Count(*) from Visit as v where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(v.date)").get(0).toString();
		return Integer.parseInt(Count);
	}

	public void save(Visit v) throws Exception {
	this.hibernateTemplate.save(v);
	}

	public int findALL() throws Exception {
		String Count = this.hibernateTemplate.find("select Count(*) from Visit").get(0).toString();
		return Integer.parseInt(Count);
	}

}
