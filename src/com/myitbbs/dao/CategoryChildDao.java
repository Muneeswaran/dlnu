package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.CategoryChild;
import com.myitbbs.model.News;

public interface CategoryChildDao {
	public boolean delete(int id);//ͨ��IDɾ��
    
	public void add(CategoryChild categoryChild);
	
	public boolean delete(CategoryChild categoryChild);//ͨ��ʵ��ɾ��

	public List<CategoryChild> findAll();//��������

	public boolean save(CategoryChild categoryChild);//����

	public CategoryChild get(int id);//ͨ��IDȡ��

	public boolean update(CategoryChild categoryChild);//������Ŀ
	/**
	 * 
	 * @param pageҳ����
	 * @param numberһҳ�ż���
	 * @return
	 */

	public List<CategoryChild> findPage(int page, int number);//��ҳ����

	public List<CategoryChild> findByCategoryId(int id);//ͨ��ģ���ID����
	/**
	 * 
	 * @param pageҳ����
	 * @param numberһҳ�ż���
	 * @param id
	 * @return
	 */

	public List<CategoryChild> findPageByCategoryId(int page, int number, int id);
}
