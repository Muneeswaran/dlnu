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

import com.myitbbs.dao.FriendDao;
import com.myitbbs.model.Friend;
import com.myitbbs.model.User;
import com.myitbbs.uitl.Pager;
@Component
@Scope("prototype")

public class FriendDaoImpl implements FriendDao{
	private	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public Friend findById(int id){
		return (Friend) this.hibernateTemplate.get(Friend.class, id);
	}
	public int delete( Friend f) {
		
		this.hibernateTemplate.delete(f);
		return f.getId();
	}

	public List<User> find(Pager p, int groupID, int masterId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findIgnoreGroup(final Pager p, final int masterId) {
		List<User> lf = this.hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session s)
			throws HibernateException, SQLException {
		Query query = s.createQuery("select u from User as u,Friend as f where (u.id = f._friend.id and f.master.id="+masterId+
				") or (u.id = f.master.id and f._friend.id="+masterId+")");//查找我加的好友和加我的好友。
		//	.createQuery("select u from User as u,Friend as f,com.myitbbs.model.Group1 as g where u.id = f._friend.id and g.id = f.group.id and g.master.id="+masterId);
		query.setFirstResult(p.getFirstResult());               
		query.setMaxResults(p.getPageSize());
		List list = query.list();
		return list;
	}
		});
		return lf;
//		System.out.println(this.hibernateTemplate.find("select new Group(id) from Group g where g.masterId=1"));
//		return null;
	}

	public int save(Friend friend) {
		this.hibernateTemplate.save(friend);
		return friend.getId();
	}

	public int update(Friend friend) {
this.hibernateTemplate.update(friend);
		return friend.getId();
	}
	public int countOfFriendIgnoreGroup(int masterId) {
		int count = Integer.parseInt(this.hibernateTemplate.find("select Count(*) from User as u,Friend as f where u.id = f._friend.id and f.master.id=?))",masterId).get(0).toString());
		return count;
	}
	@SuppressWarnings("unchecked")
	public List<User> topicGlory() {//帖子光荣榜
		List<User> lf = this.hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session s)
			throws HibernateException, SQLException {
		Query query = s

//		.createQuery("select u from User as u  where u.id = (select t.user.id from  Topic as t group by t.user.id order by count(*) desc)");
		.createQuery("select t.user from  Topic as t group by t.user.id order by count(*) desc");
		query.setFirstResult(0);               
		query.setMaxResults(5);
		List list = query.list();
		return list;
	}
		});
		return lf;
//	List<Integer> ll = 	this.hibernateTemplate.executeFind(new HibernateCallback(){
//	public Object doInHibernate(Session s) throws HibernateException, SQLException {
//			Query query = s.createQuery("select t.user.id from  Topic as t group by t.user.id order by count(*) desc");
//			return query.list();
//		}	
//	});
//		System.out.println(ll);
//		return null;
	}
	public List<User> resourceGlory() {//资源光荣榜
		List<User> lf = this.hibernateTemplate.executeFind(new HibernateCallback(){
			public Object doInHibernate(Session s)
			throws HibernateException, SQLException {
		Query query = s

//		.createQuery("select u from User as u  where u.id = (select t.user.id from  Topic as t group by t.user.id order by count(*) desc)");
		.createQuery("select r.user from  Resourcefile as r group by r.user.id order by count(*) desc");
		query.setFirstResult(0);               
		query.setMaxResults(5);
		List list = query.list();
		return list;
	}
		});
		return lf;
	}
	public List<Friend> findFriend(int id,int id2) {
	
		return  this.hibernateTemplate.find("from Friend as f where f.master.id = "+id+" and f._friend.id="+id2);
	}
	public Friend getFriend(int id,int id2) {
		Friend f = (Friend) this.hibernateTemplate.find("from Friend as f where (f.master.id = "+id+" and f._friend.id="+id2+") or (f.master.id = "+id2+" and f._friend.id="+id+")").get(0);
	System.out.println(f);
		return f;
	}                                      
	public int update(int id, int id2) {
		
		return 0;
	}

}
