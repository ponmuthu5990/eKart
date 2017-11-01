package com.niit.ekartback.service;

import java.util.List;

import com.niit.ekartback.model.Shipment;

public interface ShipmentService {

	public Shipment save(Shipment shipment);

	public void update(Shipment shipment);

	public Shipment delete(Shipment shipment);

	public Shipment getByShippingId(int id);
	
	public Shipment getByTrackingId(String id);
	
	public Shipment getByCustomerId(int userId);
	
	public List<Shipment> shimentDetails();
}
