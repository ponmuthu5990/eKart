package com.niit.ekartback.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ekartback.model.Supplier;
@Repository
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void save(Supplier supplier) {
		Session session=sessionFactory.getCurrentSession();
		session.save(supplier);
	}

	public void update(Supplier supplier) {
		Session session=sessionFactory.getCurrentSession();
		session.update(supplier);
	}

	public List<Supplier> list() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> supplierList=query.list();
		return supplierList;
	}

	public void delete(Supplier supplier) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(supplier);
	}

	public Supplier getBySupplierId(int supplierId) {
		Session session=sessionFactory.getCurrentSession();
		Supplier supplier=(Supplier) session.get(Supplier.class, supplierId);
		return supplier;
	}

}
