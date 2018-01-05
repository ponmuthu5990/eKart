package com.niit.ekartback.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.CustomerOrder;
import com.niit.ekartback.model.CustomerOrderItem;
import com.niit.ekartback.model.Product;
import com.niit.ekartback.model.ProductDesc;
import com.niit.ekartback.model.ProductView;

@Repository
public class CustomerOrderItemDAOImpl implements CustomerOrderItemDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void save(CustomerOrderItem customerOrderItem) {
		CustomerOrder customerOrder = customerOrderItem.getCustomerOrder();
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(customerOrder);
		session.saveOrUpdate(customerOrderItem);		
	}

	public void delete(CustomerOrderItem customerOrderItem) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(customerOrderItem);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub		
	}

	public void saveOrUpdate(CustomerOrderItem customerOrderItem) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(customerOrderItem);		
	}

	public boolean checkingOrderItem(String id, String status) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from CustomerOrderItem where products.id = '" + id +"' and status = '" + status + "'";
		Query query = session.createQuery(hql);
		List<CustomerOrderItem> customerOrderItems = query.list();		
		if (customerOrderItems != null && !customerOrderItems.isEmpty()) {
			return true;
		}
		return false;
	}

	public List<CustomerOrderItem> myOrder(int userId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from CustomerOrderItem where customerOrder.customer.userId = '" + userId + "' and status = 'MOVETOSHIPPED' ";
		Query query = session.createQuery(hql);
		List<CustomerOrderItem> customerOrderItems = query.list();
 		return customerOrderItems;
	}

	public List<CustomerOrderItem> Order() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CustomerOrderItem");
		List<CustomerOrderItem> customerOrderItems=query.list();
		return customerOrderItems;
	}
	

	public List<CustomerOrderItem> myOrderByShipmentId(int shipmentId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from CustomerOrderItem where shipment.shipmentId = '" + shipmentId + "'";
		Query query = session.createQuery(hql);
		List<CustomerOrderItem> customerOrderItems = query.list();
 		return customerOrderItems;
	}
}
