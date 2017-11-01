package com.niit.ekartback.DAO;

import java.util.List;

import com.niit.ekartback.model.Shipment;

public interface ShipmentDAO {
	public Shipment save(Shipment shipment);

	public void update(Shipment shipping);

	public Shipment delete(Shipment shipping);

	public Shipment getByShipmentId(int id);

	public Shipment getByTrackingId(String id);

	public Shipment getByCustomerId(int userId);
	
	public List<Shipment> shimentDetails();
}
