package com.niit.ekartback.DAO;

import com.niit.ekartback.model.Shipping;

public interface ShippingDAO {

	public void save(Shipping shipping);

	public void update(Shipping shipping);

	public Shipping delete(Shipping shipping);

	public Shipping getByShippingId(int id);
}
