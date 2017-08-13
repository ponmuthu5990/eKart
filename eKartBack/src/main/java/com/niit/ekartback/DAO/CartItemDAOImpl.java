package com.niit.ekartback.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.CartItem;

@Repository
public class CartItemDAOImpl implements CartItemDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void save(CartItem cartItem) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);		
	}

	public void delete(CartItem cartItem) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(cartItem);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	
}
