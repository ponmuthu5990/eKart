package com.niit.ekartback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekartback.DAO.ShippingDAO;
import com.niit.ekartback.model.Shipping;

@Service
@Transactional
public class ShippingServiceImpl implements ShippingService {

	@Autowired
	private ShippingDAO shippingDAO;

	public void save(Shipping shipping) {
		shippingDAO.save(shipping);
	}

	public void update(Shipping shipping) {
		shippingDAO.update(shipping);
	}

	public Shipping getByShippingId(int id) {

		return shippingDAO.getByShippingId(id);
	}

	public Shipping delete(Shipping shipping) {
		// TODO Auto-generated method stub
		return shippingDAO.delete(shipping);
	}

}
