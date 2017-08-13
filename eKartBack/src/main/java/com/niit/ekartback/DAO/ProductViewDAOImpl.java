package com.niit.ekartback.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.ProductView;

@Repository
public class ProductViewDAOImpl implements ProductViewDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductView save(ProductView productView) {
		Session session = sessionFactory.getCurrentSession();
		session.save(productView);
		return productView;
	}

	public void update(ProductView productView) {
		Session session = sessionFactory.getCurrentSession();
		session.update(productView);
	}

	public List<ProductView> list(int userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql ="from ProductView where userId = '" + userId + "'";
		Query query = session.createQuery(hql);
		List<ProductView> productViews = query.list();
		return productViews;
	}

	public void delete(ProductView productView) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(productView);
	}

	public ProductView getByProductViewId(String id) {
		Session session = sessionFactory.getCurrentSession();
		ProductView productView = (ProductView) session.get(ProductView.class, id);
		return productView;
	}

	public boolean getByCustomerAndProductId(int userId, String pid) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from ProductView where userId = '" + userId +"' and pid = '" + pid + "'";
		Query query = session.createQuery(hql);
		List<ProductView> productViews = query.list();		
		if (productViews != null && !productViews.isEmpty()) {
			return true;
		}
		return false;
	}

}
