package com.niit.ekartback.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Customer customer) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);

	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub
	}

	public Customer getByUserName(String username) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Customer where user.username= '" + username + "'");
		//query.setString(0,username);
		Customer customer=(Customer)query.uniqueResult();
		return customer;
	}

}
