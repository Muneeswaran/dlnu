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

import com.myitbbs.dao.LetterDao;
import com.myitbbs.model.Letter;
import com.myitbbs.uitl.Pager;
@Component("letterDaoImpl")
@Scope("prototype")
public class LetterDaoImpl implements LetterDao{
	HibernateTemplate hibernateTemplate;

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean update(Letter letter) {
	
			try {
				hibernateTemplate.update(letter);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}

		}
		
	
	public boolean delete(int id) {
		try {
			this.hibernateTemplate.delete(this.existById(id));
			return true;
		} catch (Exception e) {
		e.printStackTrace();
		return false;
		}
	}
	public Letter existById(int id) {// 通过Id去查找数据库是否存在这个实体

		try {
			return (Letter) hibernateTemplate.get(Letter.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public boolean delete(Letter letter) {
		if(this.existById(letter.getId())!=null){
			try {
				hibernateTemplate.delete(letter);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
				}else{
					return false;
				}
	}

	public List<Letter> findAll() {
		try {
			return (List<Letter>) hibernateTemplate.find("from Letter");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	
	public Letter get(int id) throws Exception{
		try {
			return (Letter) hibernateTemplate.get(Letter.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public boolean save(Letter letter) {
	try {
		this.hibernateTemplate.save(letter);
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
	}

	public List<Letter> receiveLetter(final Pager p,final int id) throws Exception{
	List<Letter> l = null;
	try {
		l = this.hibernateTemplate.executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query q = session
						.createQuery("From Letter as l where l.receiver.id="
								+ id);
				q.setFirstResult(p.getFirstResult());
				q.setMaxResults(p.getPageSize());
				List list = q.list();
				return list;
			}
		});
	} catch (Exception e) {
e.printStackTrace();
	}
		return l;
	}

	
	public List<Letter> senderLetter(final Pager p, final int id) throws Exception{
		List<Letter> l = null;
		try {
			l = this.hibernateTemplate.executeFind(new HibernateCallback() {

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query q = session
							.createQuery("From Letter as l where l.sender.id="
									+ id);
					q.setFirstResult(p.getFirstResult());
					q.setMaxResults(p.getPageSize());
					List list = q.list();
					return list;
				}
			});
		} catch (Exception e) {
	e.printStackTrace();
		}
			return l;
	}

	public int countreceiveLetter(int id) throws Exception{
		int count  = Integer.parseInt(this.hibernateTemplate.find("select Count(*) From Letter as l where l.receiver.id=?",id).get(0).toString());
		return count;
	}

	public int countsenderLetter(int id) throws Exception{
		int count  = Integer.parseInt(this.hibernateTemplate.find("select Count(*) From Letter as l where l.sender.id=?",id).get(0).toString());
		return count;
	}

	public int countNotReadLetter(int id) throws Exception {
		
		int count  = Integer.parseInt(this.hibernateTemplate.find("select Count(*) From Letter as l where l.readOrNot= '未读' and l.receiver.id="+id).get(0).toString());
		return count;
	}

	
}
