package com.niit.ekartback.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.Category;
import com.niit.ekartback.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Product save(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.save(product);
		return product;
	}
	public Product saveOrUpdate(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		return product;
	}
	public void update(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
	}

	public List<Product> list() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product");
		List<Product> productList=query.list();
		return productList;
	}

	public void delete(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(product);
	}

	public Product getByProductId(String id) {
		Session session=sessionFactory.getCurrentSession();
		Product product=(Product) session.get(Product.class, id);
		return product;
	}
	public List<Product> activeList() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Product where status = TRUE");
		List<Product> productList=query.list();
		return productList;
	}

}
