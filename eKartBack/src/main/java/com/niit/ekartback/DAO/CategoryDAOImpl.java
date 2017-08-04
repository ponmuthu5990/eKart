package com.niit.ekartback.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void save(Category category) {
		Session session=sessionFactory.getCurrentSession();
		session.save(category);
	}

	public void update(Category category) {
		Session session=sessionFactory.getCurrentSession();
		session.update(category);
	}

	public List<Category> list() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Category");
		List<Category> categoryList=query.list();
		return categoryList;
	}

	public void delete(Category category) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(category);
	}

	public Category getByCategoryId(int categoryId) {
		Session session=sessionFactory.getCurrentSession();
		Category category=(Category) session.get(Category.class, categoryId);
		return category;
	}

}
