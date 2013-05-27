package com.myitbbs.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.CommentDao;
import com.myitbbs.dao.FriendDao;
import com.myitbbs.dao.LetterDao;
import com.myitbbs.dao.ReplyDao;
import com.myitbbs.dao.ResourcefileDao;
import com.myitbbs.dao.SystemMessageDao;
import com.myitbbs.dao.TopicDao;
import com.myitbbs.dao.UserDao;
import com.myitbbs.model.Comment;
import com.myitbbs.model.Friend;
import com.myitbbs.model.Letter;
import com.myitbbs.model.Reply;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.SystemMessage;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.service.UserService;
import com.myitbbs.uitl.Pager;

@Component("userServiceImpl")
@Scope("prototype")
public class UserServiceImpl implements UserService {
	private UserDao userDaoImpl;
	public LetterDao getLetterDaoImpl() {
		return letterDaoImpl;
	}
	@Resource
	public void setLetterDaoImpl(LetterDao letterDaoImpl) {
		this.letterDaoImpl = letterDaoImpl;
	}
	private TopicDao topicDaoImpl;
	private CommentDao commentDaoImpl;
	private ReplyDao replyDaoImpl;
	private ResourcefileDao resourcefileDaoImpl;
    private FriendDao friendDaoImpl;
    private LetterDao letterDaoImpl;
    private SystemMessageDao systemMessageDaoImpl;
	public SystemMessageDao getSystemMessageDaoImpl() {
		return systemMessageDaoImpl;
	}
	@Resource
	public void setSystemMessageDaoImpl(SystemMessageDao systemMessageDaoImpl) {
		this.systemMessageDaoImpl = systemMessageDaoImpl;
	}
	public FriendDao getFriendDaoImpl() {
		return friendDaoImpl;
	}
	@Resource(name = "friendDaoImpl")
	public void setFriendDaoImpl(FriendDao friendDaoImpl) {
		this.friendDaoImpl = friendDaoImpl;
	}
	public ResourcefileDao getResourcefileDaoImpl() {
		return resourcefileDaoImpl;
	}
	@Resource(name = "resourcefileDaoImpl")
	public void setResourcefileDaoImpl(ResourcefileDao resourcefileDaoImpl) {
		this.resourcefileDaoImpl = resourcefileDaoImpl;
	}

	public ReplyDao getReplyDaoImpl() {
		return replyDaoImpl;
	}

	@Resource(name = "replyDaoImpl")
	public void setReplyDaoImpl(ReplyDao replyDaoImpl) {
		this.replyDaoImpl = replyDaoImpl;
	}

	public CommentDao getCommentDaoImpl() {
		return commentDaoImpl;
	}

	@Resource(name = "commentDaoImpl")
	public void setCommentDaoImpl(CommentDao commentDaoImpl) {
		this.commentDaoImpl = commentDaoImpl;
	}

	public TopicDao getTopicDaoImpl() {
		return topicDaoImpl;
	}

	@Resource(name = "topicDaoImpl")
	public void setTopicDaoImpl(TopicDao topicDaoImpl) {
		this.topicDaoImpl = topicDaoImpl;
	}

	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}

	@Resource(name = "userDaoImpl")
	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	public void writeComment(Comment comment) {// ��������
		System.out.println(comment);
		try {
			commentDaoImpl.save(comment);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void changeUser(User user) {// �޸��û�

		try {
			userDaoImpl.update(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean deleteTopic(int id) {// ɾ��
		Topic t = null;
		try {
			t = topicDaoImpl.get(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if (t != null) {
			try {
				topicDaoImpl.delete(id);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			} 
		} else {
			return false;
		}

	}

	public User getUser(int id) {// ȡ���û���Ϣ
		try {
			return userDaoImpl.get(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

//	public List<Topic> readTopic(int userId) {// ��ȡuser_idΪid���ֵ�������
//		List<Topic> topicList = null;
//		try {
//			topicList = topicDaoImpl.findByUser(userId);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return topicList;
//	}

	public void writeTopic(Topic topic) {// ��������
		try {
			topicDaoImpl.save(topic);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void writeReply(Reply reply) {// ����ظ�
		try {
			replyDaoImpl.save(reply);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public int getResourcefileCountByUser(int id) {
		try {
			return resourcefileDaoImpl.countR_U(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	public Resourcefile findResourcefile(int id) {
		try {
			return resourcefileDaoImpl.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	public List<Topic> getTopicByPageByUserId(Pager p,int userId) {
		List<Topic> lc = null;
	try {
		lc = topicDaoImpl.findByUser(p, userId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return lc;
	}
	public List<Resourcefile> findByUserId(Pager p, int id) {
		 List<Resourcefile> lr = null;
        try {
			lr = resourcefileDaoImpl.findByUserId(p, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lr;
	}
	
	public void uploadFile(Resourcefile resourcefile) {  // �ϴ��ļ�
		try {
//			System.out.println("**********1*******=======");
			resourcefileDaoImpl.save(resourcefile);
//			System.out.println("**********2*******=======");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public void deleteResourcefile(Resourcefile resourcefile) {
		try {
			resourcefileDaoImpl.delete(resourcefile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean changePassword(int id, String password1, String password2,
			String password3) {
		User u = this.getUser(id);
		
		if(u.getPassWord().equals(password1)){
			u.setPassWord(password2);
			
			this.changeUser(u);
			return true;
		}else{
		return false;
		}
	}
	public void delectFriend(int id1,int id2){
		Friend f = friendDaoImpl.getFriend(id1, id2);
		friendDaoImpl.delete(f);
	}
	public boolean makeFriend(Friend friend) {
		Friend f = null;
		
		try {
			f = friendDaoImpl.findFriend(friend.getMaster().getId(),friend.get_friend().getId()).get(0);
			System.out.println("1��"+f);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("2��"+f);
		if(friend.get_friend().getId() != friend.getMaster().getId() && f == null )
		{
			this.friendDaoImpl.save(friend);
			return true;
			}else{
				return false;
			}
		}
	public int countreceiveLetter(int id) {
		int count = 0;
		try {
			  count = this.letterDaoImpl.countreceiveLetter(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public int countsenderLetter(int id) {
		int count = 0;
		try {
			  count = this.letterDaoImpl.countsenderLetter(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public boolean deleteLetter(int id) {
		
		return this.letterDaoImpl.delete(id);
	}
	public List<Letter> receiveLetter(Pager p, int id) {
		List<Letter> ll = null;
		try {
			ll = this.letterDaoImpl.receiveLetter(p, id);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return ll;
	}
	public boolean sendLetter(Letter letter) {
		return this.letterDaoImpl.save(letter);
		
	}
	public List<Letter> senderLetter(Pager p, int id) {
		List<Letter> ll = null;
		try {
			ll = this.letterDaoImpl.senderLetter(p, id);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return ll;
	}
	public int countNotReadLetter(int id) {
int count = 0;
try {
	count = this.letterDaoImpl.countNotReadLetter(id);
} catch (Exception e) {
e.printStackTrace();
}
		return count;
	}
	public Letter getLetterById(int id) {
		Letter l = null;
		try {
			l = this.letterDaoImpl.get(id);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return l;
	}
	public void delLette(Letter letter) {
	try {
		this.letterDaoImpl.delete(letter);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}
	public void updateLette(Letter letter) {
		try {
			this.letterDaoImpl.update(letter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void updateTopic(Topic topic) {
		try {
			this.topicDaoImpl.update(topic);
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	public void CheckSystemMessage(SystemMessage s) {
	try {
		this.systemMessageDaoImpl.update(s);
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}
	public void saveSystemMessage(SystemMessage s) {
		try {
			this.systemMessageDaoImpl.save(s);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public SystemMessage getSystemMessage(int id) {
		SystemMessage s = null;
		try {
			s = this.systemMessageDaoImpl.getObject(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	public void addReply(Reply r) {
		this.replyDaoImpl.save(r);
		
	}
	public SystemMessage getTheSame(int id, int id2) {
		try {
			return this.systemMessageDaoImpl.getComment(id, id2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public Comment getCommentById(int id) {
		
		return this.commentDaoImpl.get(id);
	}
			
		
}
