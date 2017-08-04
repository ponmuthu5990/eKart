package com.niit.ekartback.DAO;

import java.util.List;

import com.niit.ekartback.model.Supplier;

public interface SupplierDAO {
	public void save(Supplier supplier);

	public void update(Supplier supplier);
	
	public List<Supplier> list();
	
	public void delete(Supplier supplier);
	
	public Supplier getBySupplierId(int supplierId);
}
