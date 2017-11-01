package com.niit.ekartback.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.CustomerOrderItem;
import com.niit.ekartback.model.Shipment;
import com.niit.ekartback.model.Shipping;

@Repository
public class ShipmentDAOImpl implements ShipmentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Shipment save(Shipment shipment) {
		Session session = sessionFactory.getCurrentSession();

		session.save(shipment);
		return shipment;
	}

	public void update(Shipment shipment) {
		Session session = sessionFactory.getCurrentSession();

		session.update(shipment);
		
	}

	public Shipment delete(Shipment shipment) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(shipment);
		return null;
	}

	public Shipment getByShipmentId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Shipment where shipmentId= '" + id + "'");
		// query.setString(0,username);
		Shipment shipment = (Shipment) query.uniqueResult();
		return shipment;
	}

	public Shipment getByTrackingId(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Shipment where orderTrackingId= '" + id + "'");
		// query.setString(0,username);
		Shipment shipment = (Shipment) query.uniqueResult();
		return shipment;
	}

	public List<Shipment> shimentDetails() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Shipment");
		List<Shipment> shipments = query.list();
		return shipments;
	}

	public Shipment getByCustomerId(int userId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Shipment where customer.userId= '" + userId + "'and status = 'DELIVERED'");
		// query.setString(0,username);
		Shipment shipment = (Shipment) query.uniqueResult();
		return shipment;
	}

}
