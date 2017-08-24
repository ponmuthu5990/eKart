package com.niit.ekartback.service;

import com.niit.ekartback.model.Shipping;

public interface ShippingService {

	public void save(Shipping shipping);

	public void update(Shipping shipping);

	public Shipping getByShippingId(int id);
	
	public Shipping delete(Shipping shipping);
}
