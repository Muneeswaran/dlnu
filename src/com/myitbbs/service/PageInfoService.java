package com.myitbbs.service;

/*
 *       PageInfoService interface by ������ 
 *       version 1.0
 *       Date:2012-10-16
 * 
 * 
 * */

import java.util.List;
import java.util.Map;

import com.myitbbs.model.Category;
import com.myitbbs.model.CategoryChild;
import com.myitbbs.model.Comment;
import com.myitbbs.model.News;
import com.myitbbs.model.Reply;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.model.SystemMessage;
import com.myitbbs.model.Topic;
import com.myitbbs.model.User;
import com.myitbbs.model.UserReadTopic;
import com.myitbbs.uitl.Pager;

public interface PageInfoService {
	public List<Category> getAllCategory();// ȡ�����е�ģ��

	public List<Category> getCategoryByPage(int page, int number);// ��ҳ����ģ��

	public List<CategoryChild> getAllCategoryChild();// ȡ�����ж�������

	public List<CategoryChild> getCategoryChildByC(int id);// ȡ���ض���������

	public List<CategoryChild> getCategoryChildByPage(int page, int number);// ��ҳ���Ҷ�������

	// //////////////////////////////////////////////////////////////

	public List<User> getUserByPage(Pager p);// ��ҳ�����û�

	public User getUser(int id);

	// //////////////////////////////////////////////////////////////

	public News getNewsById(int id);// ͨ�������id�ҵ���Ӧ������

	public List<News> getNewsByPage(Pager p);// ��ҳ��������

	public List<News> lateNews();// ��������

	public List<News> lateNews(int id);// ģ�����������

	public List<Topic> getTopTopic();// ȡ�����е�����

	public List<Topic> getTopicByPageByCategoryChildId(Pager p, int id);// ȡ����ģ�������

	public List<Topic> getTopicByPageByCategoryId(Pager p, int id);// ȡ�ø�ģ�������

	public List<Topic> getTopicByPage(Pager p);// ��ҳ��������

	public List<Topic> lateTopic();// ��������

	public List<Topic> lateTopic_C(int id);// ģ�����������

	public List<Topic> lateTopic_CH(int id);// ģ�����������

	public List<Topic> findTopicByUser(Pager p, int id);// ȡ���û�������

	public List<Comment> getCommentByPage(Pager p);// ��ҳ��������

	public List<Comment> getCommentByPageByTopic(Pager p, int id);// ͨ�����ӷ�ҳ��������

	public List<Reply> getAllReply();// ȡ�����еĻظ�

	public List<Reply> getReplyByPage(int page, int number);// ��ҳ�������лظ�

	public List<Reply> getReplyByPageByComment(int page, int number, int id);// ͨ������

	// ��ҳ�������лظ�
	public int getCommentCountByTopicId(int id);// ÿ�����ӵ����۵�����

	public int getCategoryCount(); // ��ȡcategory������ܸ���

	public int getNewsCount(); // ��ȡNews������ܸ���

	public int getNewsCountByCategoryId(int id); // ��ȡ��Ӧģ���News������ܸ���

	public int getTopicCountByCategoryId(int id); // ��ȡ��Ӧģ���Topic������ܸ���

	public int getUserCount(); // ��ȡUser������ܸ���

	public int getTopicCount(); // ��ȡTopic���������

	public int getTopicCountByUserId(int id); // ��ȡÿ���û�Topic���������

	public int getTopicCountByCategoryChildId(int id); // ��ȡTopic���������

	public Topic getTopicById(int id);

	public List<Comment> getCommentByTopicId(int id);// ͨ��������ȡ����

	public List<Reply> getReplyByCommentId(int id);// ͨ��������ȡ�ظ�

	public List<CategoryChild> getCategoryChildByPageByCategoryId(int page,
			int number, int id); // ͨ��Category��Id��ȡcategoryChild�б�

	public List<News> getNewsByPageByCategoryId(Pager p, int id); // ͨ��Category��Id��ȡNews�б�

	/******************************** ��Դ�� ****************************/
	public int getResourcefileCount();

	public int getResourcefileCountByUser(int id);

	public int getResourcefileCountByCategory(int id);

	public List<Resourcefile> findResourcefileAll(Pager p);// ��ȡȫ����Դ

	public List<Resourcefile> findResourcefileHot();// ����������Դ

	public List<Resourcefile> findResourcefileByUserId(Pager p, int id);

	public List<Resourcefile> findResourcefileByCategoryId(Pager p, int id);

	public Resourcefile findResourcefile(int id);

	public List<Resourcefile> lateResource();// ������Դ

	public List<Resourcefile> lateResource_C(int id);// ģ���������Դ

	public List<Topic> findUserJionTopics(Pager p, int id);// �Ҳ����������

	public int countOfUserJoinTopics(int id);// �Ҳ�������ӵĸ���

	public List<User> findIgnoreGroup(Pager p, int masterId);// ��������ҡ�

	public int countOfFriendIgnoreGroup(int masterId);

	public List<User> resourceGlory();

	public List<User> topicGlory();

	public List<Topic> userHadReadTopic(int topicId);// �����������û�������������

	public void buildUserReadTopic(UserReadTopic urt);
	
	public List <Topic> HotTopic()throws Exception;//��������
	
	public List<Topic> recommendTopic()throws Exception;//�Ƽ�����

	public Map<Comment, List<Reply>> getCommentAndReply(Pager p, int id)//�ҳ�һ��������������ۺͻظ�
			throws Exception;
	
	public List<SystemMessage> findSystemMessage(int friendId,Pager p)throws Exception;
	
	public int countOfNotCheck(int id);
	
	public int countOfSystemMessage(int id);
	
	public void saveVisit();
}
