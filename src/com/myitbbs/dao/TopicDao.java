package com.myitbbs.dao;

import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.myitbbs.model.News;
import com.myitbbs.model.Topic;
import com.myitbbs.uitl.Pager;

public interface TopicDao {

	public boolean delete(int id);// ͨ��idɾ��

	public boolean delete(Topic topic);// ͨ��ʵ����ɾ��

	public boolean deleteByName(String name);// ͨ��������ɾ��

	public boolean save(Topic topic);// ͨ��ʵ������ɾ��

	public Topic get(int id);// ͨ��id��ȡ
	public List<Topic> findReportTopic() throws Exception;
	public boolean update(Topic topic);// ͨ��ʵ����������

	public List<Topic> findByUser(Pager p, int id);// ͨ���û�����������������

	public List<Topic> findByCategoryChildId(Pager p, final int id);// ͨ����������������
	public List<Topic> findByCategoryId(Pager p, final int id);// ͨ����������������

	public List<Topic> findAll(Pager p);

	public List<Topic> findAllTop();

	public List<Topic> findByTitleByDesc(Pager p,
			final String title);// �������


	public List<Topic> existByTitle(String title);

	public int CountByCategoryChild(int id);
	public int CountByCategory(int id);

	public int CountByUser(int id);// 

	public int CountAll();// ����Ǽ�ȥ�ö��ĸ����Ժ��
	
	public List <Topic> HotTopic()throws Exception;//��������
	
	public List<Topic> recommendTopic()throws Exception;//�Ƽ�����
	
	
	public List<Topic> lateTopic()throws Exception;//��������
	
	public List<Topic> lateTopic_C(int id);//��ģ�����������
	public List<Topic> lateTopic_CH(int id);//��ģ�����������
	public List<Topic> allTopic_C(Pager p,int id);//��ģ�����������
	
	public List<Topic> findByKey(final Pager p ,String key);//��������
	public int countOfKey(String key);
	
	public List<Topic> findUserJoinTopics(Pager p ,int id);//�Ҳ��������
	public int countOfUserJoinTopics(int id);//�Ҳ�������ӵĸ���
	
	public List<Topic> userHadRead(int userId,int topicId);
	
	public List<Topic> findReportTopic(Pager p)throws Exception;//���ٱ�������
	public int countOfReportTopic()throws Exception;//���ٱ����ӵĸ���
}
