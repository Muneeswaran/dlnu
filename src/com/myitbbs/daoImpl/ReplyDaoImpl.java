package com.myitbbs.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.ReplyDao;
import com.myitbbs.model.Reply;
import com.myitbbs.model.User;

@Component("replyDaoImpl")
@Scope("prototype")
public class ReplyDaoImpl implements ReplyDao {

	HibernateTemplate hibernateTemplate;

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean update(Reply reply) {
		try {
			hibernateTemplate.update(reply);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Reply existById(int id) {
		Reply r = null;
		try {
			r = (Reply) hibernateTemplate.get(Reply.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

	public boolean delete(int id) {
		Reply reply = this.existById(id);
		if (reply != null) {
			try {
				hibernateTemplate.delete(reply);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean delete(Reply reply) {
		if (this.existById(reply.getId()) != null) {
			try {
				hibernateTemplate.delete(reply);
				return true;
			} catch (Exception e) {
				return false;
			}

		} else {
			return false;
		}
	}

	public List<Reply> findAll() {
		List<Reply> lr = null;
		try {
			lr = (List<Reply>) hibernateTemplate.find("from Reply");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lr;
	}

	public List<Reply> findPage(int page, int number) {
		List<Reply> ReplyList = null;
		try {
			ReplyList = hibernateTemplate.find("from Reply");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(page + "--" + number);
		if ((number * page - 1) < ReplyList.size()) {
			return ReplyList.subList(number * (page - 1), number * page);
		} else {
			return ReplyList.subList(number * (page - 1), ReplyList.size());
		}
	
	}

	public Reply get(int id) {
		Reply r = null;
		try {
			r = (Reply) hibernateTemplate.get(Reply.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}

	public boolean save(Reply reply) {
		try {
			hibernateTemplate.save(reply);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

	public List<Reply> getByCommentId(int id) {
		List<Reply> r = null;
		try {
			r =  this.hibernateTemplate.find(
					"from Reply as r where r.comment.id = ? order by r.date", id);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return r;
	}

	public List<Reply> getPageByCommentId(int page, int number, int id) {
		List<Reply> ReplyList = null;
		try {
			ReplyList =  this.hibernateTemplate.find(
					"from Reply where reply_comment_id = ?", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if ((number * page - 1) <= ReplyList.size()) {
			return ReplyList.subList(number * (page - 1), number * page);
		} else {
			return ReplyList.subList(number * (page - 1), ReplyList.size());
		}
	}

}
