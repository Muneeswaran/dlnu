package com.myitbbs.daoImpl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.myitbbs.dao.ReportTopicDao;
import com.myitbbs.model.ReportTopic;

public class ReportTopicDaoImpl implements ReportTopicDao{
private HibernateTemplate hibernateTemplate;
@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}

	public int count() throws Exception {
		//int count = this.hibernateTemplate.find("select Count(distinct t) from Topic as t,ReportTopic as")
		return 0;
	}

	public int delete(int id) throws Exception {
		return 0;
	}

	public int save(ReportTopic rt) throws Exception {
		return 0;
	}

}
