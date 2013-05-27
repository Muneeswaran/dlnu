package com.myitbbs.service;

import java.util.List;

import com.myitbbs.model.Comment;
import com.myitbbs.model.Friend;
import com.myitbbs.model.Letter;
import com.myitbbs.model.Reply;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.SystemMessage;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.uitl.Pager;

public interface UserService {
	public void changeUser(User user);// �޸��û���Ϣ

	public User getUser(int id);// ȡ���û���Ϣ

//	public List<Topic> readTopic(int userId);// ��ȡ����
	public void delectFriend(int id1,int id2);
	public void writeTopic(Topic topic);// д������

	public void writeComment(Comment comment);// д������

	public boolean deleteTopic(int id);// ɾ������

	public void writeReply(Reply reply);// д������

	public List<Topic> getTopicByPageByUserId(Pager p, int userId);
	 	
	public List<Resourcefile> findByUserId(Pager p, int id);

	public Resourcefile findResourcefile(int id);

	public int getResourcefileCountByUser(int id);
	
	public void uploadFile(Resourcefile resourcefile);  // �ϴ��ļ�
	
	public void deleteResourcefile(Resourcefile resourcefile);
	
	public boolean changePassword(int id,String password1,String password2,String password3);
  
	public boolean makeFriend(Friend friend);//��Ӻ�����
	public boolean deleteLetter(int id);//ɾ����Ϣ
	public boolean sendLetter(Letter letter);//������Ϣ
	public List<Letter> receiveLetter(Pager p,int id);//�յ�����Ϣ
	public List<Letter> senderLetter(Pager p,int id);//���͵���Ϣ
    public int countsenderLetter(int id);//������Ϣ�ĸ���
	
	public int countreceiveLetter(int id);//������Ϣ�ĸ���
	public int countNotReadLetter(int id);//δ����Ϣ�ĸ���
	public Letter getLetterById(int id);//ȡ���ż�
	public void updateLette(Letter letter);
	public void delLette(Letter letter);
	public void updateTopic(Topic topic);//��������
	public void saveSystemMessage(SystemMessage s);
	public void CheckSystemMessage(SystemMessage s);
	public SystemMessage getSystemMessage(int id);
	public void addReply(Reply r);
	public SystemMessage getTheSame(int id, int id2);
	
	public Comment getCommentById(int id);
	
}
