package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.CategoryChild;
import com.myitbbs.model.News;

public interface CategoryChildDao {
	public boolean delete(int id);//通过ID删除
    
	public void add(CategoryChild categoryChild);
	
	public boolean delete(CategoryChild categoryChild);//通过实体删除

	public List<CategoryChild> findAll();//查找所有

	public boolean save(CategoryChild categoryChild);//保存

	public CategoryChild get(int id);//通过ID取得

	public boolean update(CategoryChild categoryChild);//更新项目
	/**
	 * 
	 * @param page页码数
	 * @param number一页放几个
	 * @return
	 */

	public List<CategoryChild> findPage(int page, int number);//分页查找

	public List<CategoryChild> findByCategoryId(int id);//通过模块的ID查找
	/**
	 * 
	 * @param page页码数
	 * @param number一页放几个
	 * @param id
	 * @return
	 */

	public List<CategoryChild> findPageByCategoryId(int page, int number, int id);
}
