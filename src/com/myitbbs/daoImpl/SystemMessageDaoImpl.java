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

import com.myitbbs.dao.SystemMessageDao;
import com.myitbbs.model.SystemMessage;
import com.myitbbs.uitl.Pager;
@Component("systemMessageDaoImpl")
@Scope("prototype")
public class SystemMessageDaoImpl implements SystemMessageDao{
private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}
@Resource(name="hibernateTemplate")
public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}

	public int save(SystemMessage s) throws Exception {
        this.hibernateTemplate.save(s);
		return s.getId();
	}

	public int update(SystemMessage s) throws Exception {
		this.hibernateTemplate.update(s);
		return s.getId();
	}
	public List<SystemMessage> find(final int friendId, final Pager p) throws Exception {
		List<SystemMessage> ls = this.hibernateTemplate.executeFind(new HibernateCallback() {

			public Object doInHibernate(Session s)
					throws HibernateException, SQLException {
				Query query = s
						.createQuery("from SystemMessage as s where s.friend.id = "
								+ friendId + " and s.check = '0' order by s.date desc");
				query.setFirstResult(p.getFirstResult());
				query.setMaxResults(p.getPageSize());
				List list = query.list();
				return list;
			}
		});
		return ls;
	}
	public int countOfNotCheck(int id) throws Exception {
		int count = Integer.parseInt(this.hibernateTemplate.find("select Count(*) From SystemMessage as s where s.check = '0' and s.friend.id = ?",id).get(0).toString());
		return count;
	}
	public int countOfSystemMessage(int id) throws Exception {
		int count = Integer.parseInt(this.hibernateTemplate.find("select Count(*) From SystemMessage as s where s.check = '0' and s.friend.id = ?",id).get(0).toString());
		return count;
	}
	public SystemMessage getObject(int id) throws Exception {
	
		return (SystemMessage) this.hibernateTemplate.get(SystemMessage.class, id);
	}
	public SystemMessage getComment(int id, int id2) throws Exception {
		SystemMessage s = (SystemMessage) this.hibernateTemplate.find("from SystemMessage as s where ((s.master.id="+id+"and s.friend.id ="+id2+") or (s.master.id="+id2+"and s.friend.id ="+id+")) and s.check = '0'").get(0);

		return s;
	}

}
