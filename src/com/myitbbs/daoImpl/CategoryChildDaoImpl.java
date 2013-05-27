package com.myitbbs.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.myitbbs.dao.CategoryChildDao;
import com.myitbbs.model.Category;
import com.myitbbs.model.CategoryChild;
/**
 * 以下方法注解在Dao里面已经有了，这里就不在重复了。
 * 如若不明白请联系虞增勇
 * @author Administrator
 *
 */
@Component("categoryChildDaoImpl")
@Scope("prototype")
public class CategoryChildDaoImpl implements CategoryChildDao {
	HibernateTemplate hibernateTemplate;

	@Resource(name = "hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean update(CategoryChild categoryChild) {
		try {
			this.hibernateTemplate.update(categoryChild);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(int id) {

		CategoryChild categoryChild = null;
		try {
			categoryChild = (CategoryChild) hibernateTemplate.get(
					Category.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (categoryChild != null) {
			try {
				hibernateTemplate.delete(categoryChild);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			
		} else {
			return false;
		}
	}
	public CategoryChild existById(int id) {// 通过Id去查找数据库是否存在这个实体

		try {
			return (CategoryChild) hibernateTemplate.get(CategoryChild.class,
					id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean delete(CategoryChild categoryChild) {
		if(this.existById(categoryChild.getId())!=null){
			try {
				hibernateTemplate.delete(categoryChild);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
				}else{
					return false;
				}
	}

	public List<CategoryChild> findAll() {
		try {
			// TODO Auto-generated method stub
			return (List<CategoryChild>) hibernateTemplate
					.find("from CategoryChild");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<CategoryChild> findPage(int page, int number) {
		List<CategoryChild> categoryChildList = null;
		try {
			categoryChildList = hibernateTemplate.find("from CategoryChild");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(page + "--" + number);
		if ((number * page - 1) < categoryChildList.size()) {
			return categoryChildList.subList(number * (page - 1), number * page);//这个算法，耐心点去思考应该不难理解
		} else {
			return categoryChildList.subList(number * (page - 1), categoryChildList
					.size());
		}

	}

	public CategoryChild get(int id) {
		try {
			return (CategoryChild) hibernateTemplate.get(CategoryChild.class,
					id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public boolean save(CategoryChild categoryChild) {
		try {
			hibernateTemplate.save(categoryChild);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	public List<CategoryChild> findByCategoryId(int id) {
		List<CategoryChild> categoryChildList = null;
		try {
			categoryChildList = hibernateTemplate.find(
					"from CategoryChild where categoryChild_category_id=?", id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return categoryChildList;
	}

	public List<CategoryChild> findPageByCategoryId(int page, int number, int id) {
		List<CategoryChild> categoryChildList = null;
		try {
			categoryChildList = hibernateTemplate.find(
					"from CategoryChild where categoryChild_category_id=?", id);
			       
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if ((number * page - 1) < categoryChildList.size()) {
			return categoryChildList.subList(number * (page - 1), number * page);
		} else {
			return categoryChildList.subList(number * (page - 1), categoryChildList
					.size());
		}
	}

	public void add(CategoryChild categoryChild) {
		try {
			this.hibernateTemplate.save(categoryChild);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
