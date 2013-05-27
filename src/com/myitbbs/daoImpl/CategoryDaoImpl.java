package com.myitbbs.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.CategoryDao;
import com.myitbbs.model.Category;



@Component("categoryDaoImpl")
@Scope("prototype")
public class CategoryDaoImpl implements CategoryDao {
	HibernateTemplate hibernateTemplate;

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean update(Category category) {

		try {
			hibernateTemplate.update(category);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(int id) {
		Category category = null;
		try {
			category = (Category) hibernateTemplate.get(Category.class, id);
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		if (category != null) {
			hibernateTemplate.delete(category);
			return true;
		} else {
			return false;
		}

	}

	public Category existById(int id) {// 通过Id去查找数据库是否存在这个实体

		try {
			return (Category) hibernateTemplate.get(Category.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(Category category) {
		if (this.existById(category.getId()) != null) {
			try {
				hibernateTemplate.delete(category);
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

	public List<Category> findAll() {
		List<Category> listCategory = null;
		try {
			listCategory = hibernateTemplate.find("from Category");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listCategory;
	}

	public List<Category> findPage(int page, int number) {
		List<Category> CategoryList = null;
		try {
			CategoryList = hibernateTemplate.find("from Category");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(page + "--" + number);
		List<Category> cl;
		if ((number * page - 1) < CategoryList.size()) {
			
			return CategoryList.subList(number * (page - 1), number * page);
		} else {
			return CategoryList.subList(number * (page - 1), CategoryList
					.size());
		}

	}

	public Category get(int id) {

		try {
			return (Category) hibernateTemplate.get(Category.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public boolean save(Category category) {
		try {
			hibernateTemplate.save(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}

}
