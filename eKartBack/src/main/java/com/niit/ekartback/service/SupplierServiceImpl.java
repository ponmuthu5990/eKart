package com.niit.ekartback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekartback.DAO.SupplierDAO;
import com.niit.ekartback.model.Supplier;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierDAO supplierDAO;

	public void save(Supplier supplier) {
		supplierDAO.save(supplier);
	}

	public void update(Supplier supplier) {
		supplierDAO.update(supplier);
	}

	public List<Supplier> list() {
		// TODO Auto-generated method stub
		return supplierDAO.list();
	}

	public void delete(Supplier supplier) {
		supplierDAO.delete(supplier);

	}

	public Supplier getBySupplierId(int supplierId) {
		// TODO Auto-generated method stub
		return supplierDAO.getBySupplierId(supplierId);
	}

}
