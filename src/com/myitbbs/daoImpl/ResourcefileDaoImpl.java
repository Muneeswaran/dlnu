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

import com.myitbbs.constant.Constant;
import com.myitbbs.dao.ResourcefileDao;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.uitl.Pager;

@Component("resourcefileDaoImpl")
@Scope("prototype")
public class ResourcefileDaoImpl implements ResourcefileDao{
	HibernateTemplate hibernateTemplate;

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public boolean update(Resourcefile resourcefile) {
	try {
		this.hibernateTemplate.update(resourcefile);
		return true;
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return false;
	}
	}

	public boolean delete(int id) {
		
		Resourcefile resourcefile = (Resourcefile) hibernateTemplate.get(Resourcefile.class, id); 
			if(resourcefile!=null){
				try {
					hibernateTemplate.delete(resourcefile);
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
	public Resourcefile existById(int id) {// 通过Id去查找数据库是否存在这个实体
		Resourcefile r = null;
		try {
			r = (Resourcefile) hibernateTemplate.get(Resourcefile.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	public boolean delete(Resourcefile resourcefile) {
		if(this.existById(resourcefile.getId())!=null){
			try {
				hibernateTemplate.delete(resourcefile);
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

	public List<Resourcefile> findAll(final Pager p) {
		List<Resourcefile> lr = null;
		try {
			lr = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
                       Query q = session.createQuery("from Resourcefile order by resourcefile_id desc");
                       q.setFirstResult(p.getFirstResult());
                       q.setMaxResults(p.getPageSize());
                       List list = q.list();
					return list;
				}});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lr;
	}

	

	public Resourcefile get(int id) {
		Resourcefile r = null;
		try {
			r = (Resourcefile) hibernateTemplate.get(Resourcefile.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	public boolean save(Resourcefile resourcefile) {
		try {
			hibernateTemplate.save(resourcefile);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	public List<Resourcefile> findByCategoryId(final Pager p,final int id) {
		
		List<Resourcefile> lr = null;
		try {
			lr = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
                       Query q = session.createQuery("from Resourcefile where resourcefile_category_id="+id+"order by resourcefile_id desc");
                       q.setFirstResult(p.getFirstResult());
                       q.setMaxResults(p.getPageSize());
                       List list = q.list();
					return list;
				}});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lr;
	}
	public List<Resourcefile> findByUserId( final Pager p,final int id) {
             System.out.println("id--------->"+id);
		List<Resourcefile> lr = null;
		try {
			lr = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
                       Query q = session.createQuery("from Resourcefile as r where r.user.id="+id+"order by r.id desc");
                       q.setFirstResult(p.getFirstResult());
                       q.setMaxResults(p.getPageSize());
                       List list = q.list();
					return list;
				}});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lr;
	}
	public List<Resourcefile> lateCategoryResource(final int id) {
	
		List<Resourcefile> lr = null;
		try {
			lr = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
                       Query q = session.createQuery("from Resourcefile where resourcefile_category_id="+id+"order by resourcefile_id desc");
                       q.setFirstResult(0);
                       q.setMaxResults(Constant.LATE_RESOURCE);
                       List list = q.list();
					return list;
				}});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lr;
	}
	public List<Resourcefile> lateResource() {
		List<Resourcefile> lr = null;
		try {
			lr = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
                       Query q = session.createQuery("from Resourcefile order by resourcefile_id desc");
                       q.setFirstResult(0);
                       q.setMaxResults(Constant.LATE_RESOURCE);
                       List list = q.list();
					return list;
				}});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lr;
	}
	public int countR() {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from Resourcefile").get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}
	
	public int countR_C(int id) {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from Resourcefile where resourcefile_category_id = "
							+ id).get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}
	public int countR_U(int id) {
		int count = 0;
		try {
			count = Integer.parseInt(this.hibernateTemplate.find(
					"select Count(*) from Resourcefile where resourcefile_user_Id = "
							+ id).get(0).toString());
		
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return count;
	}
	public List<Resourcefile> hotResource() {
		List<Resourcefile> lr = null;
		try {
			lr = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
                       Query q = session.createQuery("from Resourcefile order by resourcefile_downNum desc");
                       q.setFirstResult(0);
                       q.setMaxResults(Constant.HOT_RESOURCE);
                       List list = q.list();
					return list;
				}});
		} catch (Exception e) {

			e.printStackTrace();
		}
		return lr;
	}
	public List<Resourcefile> findByKey(final Pager p,final String key) {
		List<Resourcefile> lr = null;
		try {
			lr = hibernateTemplate.executeFind(new HibernateCallback(){

				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					String key1 = "%"+key+"%";
                       Query q = session.createQuery("from Resourcefile where resourcefile_filename like '"+key1+"' or resourcefile_state like '"+key1+"' order by resourcefile_id desc");
                       q.setFirstResult(p.getFirstResult());
                       q.setMaxResults(p.getPageSize());
                       List list = q.list();
					return list;
				}});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lr;
	}
	public int countOfKey(String key) {
		
			String key1 = "%"+key+"%";
			return Integer.parseInt(this.hibernateTemplate.find("select Count(*) from Resourcefile where resourcefile_filename like '"+key1+"' or resourcefile_state like '"+key1+"'").get(0).toString());
			
		
	}
	public List<Resourcefile> findByUserId(int id) {
		
		return this.hibernateTemplate.find("from Resourcefile where resourcefile_user_Id = ?",id);
	}

}
