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

import com.myitbbs.dao.MessageBoardDao;
import com.myitbbs.model.MessageBoard;
import com.myitbbs.uitl.Pager;
@Component
@Scope("prototype")
public class MessageBoardDaoImpl implements MessageBoardDao{
private	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
public MessageBoard findById(int id){
	return (MessageBoard) this.hibernateTemplate.get(MessageBoard.class, id);
}

	public boolean delete(int id){
		MessageBoard m = this.findById(id);
		this.hibernateTemplate.delete(m);
		return true;
	}

	public List<MessageBoard> findByMaster(final Pager p, final int id) {
		List<MessageBoard> mbList = null;
		mbList = this.hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session s)
			throws HibernateException, SQLException {
		Query query = s
				.createQuery("from MessageBoard where masterId = "
						+ id + " order by masterId desc");
		query.setFirstResult(p.getFirstResult());
		query.setMaxResults(p.getPageSize());
		List list = query.list();
		return list;
	}
		});
		return mbList;
	}

	public List<MessageBoard> findByVisitor(Pager p, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(MessageBoard m) {
		this.hibernateTemplate.save(m);
		return true;
	}

	public boolean update(MessageBoard m) {
		this.hibernateTemplate.update(m);
		return true;
	}
	public MessageBoard getById(int id) {
		return this.findById(id);
	}

}
