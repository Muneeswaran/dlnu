package com.myitbbs.dao;

import java.util.List;

import com.myitbbs.model.News;
import com.myitbbs.model.Resourcefile;
import com.myitbbs.uitl.Pager;

public interface ResourcefileDao {
	public boolean delete(int id);// 通过id删除

	public boolean delete(Resourcefile resourcefile);// 通过实体类删除

	public List<Resourcefile> findAll(Pager p);// 查找所有

	public boolean save(Resourcefile resourcefile);// 通过实体保存

	public Resourcefile get(int id);// 通过id获得

	public boolean update(Resourcefile resourcefile);// 通过实体更新

	public List<Resourcefile> findByCategoryId(Pager p, int id);// 通过模块查找

	public List<Resourcefile> findByUserId(Pager p, int id);// 通过用户查找
	public List<Resourcefile> findByUserId(int id);// 通过用户查找

	public List<Resourcefile> lateResource();// 最近资源

	public List<Resourcefile> hotResource();// 热门资源

	public List<Resourcefile> lateCategoryResource(int id);// 最近资源

	public int countR();// 资源的个数

	public int countR_C(int id);// 板块资源资源的个数

	public int countR_U(int id);// 用户资源资源的个数
	
	public List<Resourcefile> findByKey(Pager p,String key);//条件查找
	public int countOfKey(String key);
}
