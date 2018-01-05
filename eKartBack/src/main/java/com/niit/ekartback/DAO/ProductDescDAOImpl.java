package com.niit.ekartback.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.ProductDesc;

@Repository
public class ProductDescDAOImpl implements ProductDescDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDesc save(ProductDesc productDesc) {
		Session session = sessionFactory.getCurrentSession();
		session.save(productDesc);
		return productDesc;
	}

	public void update(ProductDesc productDesc) {
		Session session = sessionFactory.getCurrentSession();
		session.update(productDesc);		
	}

	public List<ProductDesc> list(String productId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ProductDesc where pid = '" + productId + "'";
		Query query = session.createQuery(hql);
		List<ProductDesc> productdescList = query.list();
 		return productdescList;
	}

	public void delete(ProductDesc productDesc) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(productDesc);
	}

	public ProductDesc getByProductDescId(String descId) {
		Session session = sessionFactory.getCurrentSession();
		ProductDesc productDesc = (ProductDesc) session.get(ProductDesc.class, descId);
		return productDesc;
	}

}
