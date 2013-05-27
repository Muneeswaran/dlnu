package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.News;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.uitl.Pager;

public interface ResourcefileDao {
	public boolean delete(int id);// ͨ��idɾ��

	public boolean delete(Resourcefile resourcefile);// ͨ��ʵ����ɾ��

	public List<Resourcefile> findAll(Pager p);// ��������

	public boolean save(Resourcefile resourcefile);// ͨ��ʵ�屣��

	public Resourcefile get(int id);// ͨ��id���

	public boolean update(Resourcefile resourcefile);// ͨ��ʵ�����

	public List<Resourcefile> findByCategoryId(Pager p, int id);// ͨ��ģ�����

	public List<Resourcefile> findByUserId(Pager p, int id);// ͨ���û�����
	public List<Resourcefile> findByUserId(int id);// ͨ���û�����

	public List<Resourcefile> lateResource();// �����Դ

	public List<Resourcefile> hotResource();// ������Դ

	public List<Resourcefile> lateCategoryResource(int id);// �����Դ

	public int countR();// ��Դ�ĸ���

	public int countR_C(int id);// �����Դ��Դ�ĸ���

	public int countR_U(int id);// �û���Դ��Դ�ĸ���
	
	public List<Resourcefile> findByKey(Pager p,String key);//��������
	public int countOfKey(String key);
}
