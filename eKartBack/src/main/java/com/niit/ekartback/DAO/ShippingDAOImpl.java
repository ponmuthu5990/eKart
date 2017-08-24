package com.niit.ekartback.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.Shipping;

@Repository
public class ShippingDAOImpl implements ShippingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Shipping shipping) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(shipping);

	}

	public void update(Shipping shipping) {
		// TODO Auto-generated method stub
		
	}

	public Shipping getByShippingId(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Shipping where id= '" + id + "'");
		//query.setString(0,username);
		Shipping shipping=(Shipping)query.uniqueResult();
		return shipping;
	}

	public Shipping delete(Shipping shipping) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(shipping);
		return null;
	}
	
	

}
