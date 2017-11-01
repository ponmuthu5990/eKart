package com.niit.ekartback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekartback.DAO.ShipmentDAO;
import com.niit.ekartback.model.Shipment;

@Service
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentDAO shipmentDAO;
	
	public Shipment save(Shipment shipment) {
	
		return shipmentDAO.save(shipment);
	}

	public void update(Shipment shipment) {
		shipmentDAO.update(shipment);
	}

	public Shipment delete(Shipment shipment) {
		// TODO Auto-generated method stub
		return shipmentDAO.delete(shipment);
	}

	public Shipment getByShippingId(int id) {
		// TODO Auto-generated method stub
		return shipmentDAO.getByShipmentId(id);
	}

	public Shipment getByTrackingId(String id) {
		// TODO Auto-generated method stub
		return shipmentDAO.getByTrackingId(id);
	}

	public List<Shipment> shimentDetails() {
		// TODO Auto-generated method stub
		return shipmentDAO.shimentDetails();
	}

	public Shipment getByCustomerId(int userId) {
		// TODO Auto-generated method stub
		return shipmentDAO.getByCustomerId(userId);
	}

}
