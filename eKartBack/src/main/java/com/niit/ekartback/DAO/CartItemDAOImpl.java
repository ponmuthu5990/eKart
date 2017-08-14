package com.niit.ekartback.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.Cart;
import com.niit.ekartback.model.CartItem;

@Repository
public class CartItemDAOImpl implements CartItemDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void save(CartItem cartItem) {
		Cart cart = cartItem.getCart();
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cart);
		session.saveOrUpdate(cartItem);		
	}

	public void delete(CartItem cartItem) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(cartItem);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public void saveOrUpdate(CartItem cartItem) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);		
	}

}
