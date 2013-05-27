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

import com.myitbbs.dao.MB_ReplyDao;
import com.myitbbs.model.MB_Reply;
import com.myitbbs.model.MessageBoard;
import com.myitbbs.uitl.Pager;
@Component("mB_ReplyDaoImpl")
@Scope("prototype")
public class MB_ReplyDaoImpl implements MB_ReplyDao{
	private	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public MB_Reply getCbject(int id){
		return (MB_Reply) this.hibernateTemplate.get(MB_Reply.class, id);
		
	}
	public boolean delete(int id) {
		MB_Reply mbr = this.getCbject(id);
		this.hibernateTemplate.delete(mbr);
	return true;
	}

	public List<MB_Reply> find(final Pager p, final int id) {
		List<MB_Reply> mbList = null;
		mbList = this.hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session s)
			throws HibernateException, SQLException {
		Query query = s
				.createQuery("from MB_Reply where messageBoardId = "
						+ id + " order by id desc");
		query.setFirstResult(p.getFirstResult());
		query.setMaxResults(p.getPageSize());
		List list = query.list();
		return list;
	}
		});
		return mbList;
	}

	public boolean save(MB_Reply mbReply) {
	this.hibernateTemplate.save(mbReply);
		return true;
	}

	public boolean upDate(MB_Reply mbReply) {
     this.hibernateTemplate.update(mbReply);
		return true;
	}
	public MB_Reply find(int id) {
		return this.getCbject(id);
	}

}
