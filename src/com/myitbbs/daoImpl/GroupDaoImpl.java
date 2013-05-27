package com.myitbbs.daoImpl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.Group1Dao;
import com.myitbbs.model.Group1;
import com.myitbbs.uitl.Pager;

@Component
@Scope("prototype")
public class GroupDaoImpl implements Group1Dao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Group1 get(int id) {
		return (Group1) this.hibernateTemplate.get(Group1.class, id);
	}

	public int delete(int id) {
		Group1 g = this.get(id);
		this.hibernateTemplate.delete(g);
		return g.getId();
	}

	public List<Group1> find(final Pager p, final int masterId) {
		List<Group1> lg = null;
		lg = this.hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session s)
			throws HibernateException, SQLException {
		Query query = s
				.createQuery("from _Group where masterId = "
						+ masterId );
		query.setFirstResult(p.getFirstResult());
		query.setMaxResults(p.getPageSize());
		List list = query.list();
		return list;
		
	}
		});
		return lg;
		}
	public int save(Group1 group) {
		this.hibernateTemplate.save(group);
		return group.getId();
	}

	public int update(Group1 group) {
		this.hibernateTemplate.update(group);
		return group.getId();
	}

	public Group1 find(int id) {
		return (Group1) this.hibernateTemplate.get(Group1.class, id);
	}

}
