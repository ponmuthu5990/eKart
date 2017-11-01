package com.niit.ekartback.DAO;

import com.niit.ekartback.model.Shipping;

public interface ShippingDAO {

	public void save(Shipping shipment);

	public void update(Shipping shipment);

	public Shipping delete(Shipping shipment);

	public Shipping getByShippingId(int id);
}
