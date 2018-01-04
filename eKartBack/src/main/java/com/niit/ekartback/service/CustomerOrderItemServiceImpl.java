package com.niit.ekartback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekartback.DAO.CustomerOrderItemDAO;
import com.niit.ekartback.model.CustomerOrderItem;

@Service
@Transactional
public class CustomerOrderItemServiceImpl implements CustomerOrderItemService {
	@Autowired
	private CustomerOrderItemDAO customerOrderItemDAO;

	public void save(CustomerOrderItem customerOrderItem) {
		customerOrderItemDAO.save(customerOrderItem);
	}

	public void delete(CustomerOrderItem customerOrderItem) {
		customerOrderItemDAO.delete(customerOrderItem);

	}

	public void deleteAll() {
		customerOrderItemDAO.deleteAll();

	}

	public void saveOrUpdate(CustomerOrderItem customerOrderItem) {
		customerOrderItemDAO.saveOrUpdate(customerOrderItem);
	}

	public boolean checkingOrderItem(String id, String status) {
		// TODO Auto-generated method stub
		return customerOrderItemDAO.checkingOrderItem(id, status);
	}

	public List<CustomerOrderItem> myOrder(int userId) {
		// TODO Auto-generated method stub
		return customerOrderItemDAO.myOrder(userId);
	}

	public List<CustomerOrderItem> Order() {
		// TODO Auto-generated method stub
		return customerOrderItemDAO.Order();
	}

	public List<CustomerOrderItem> myOrderByShipmentId(int shipmentId) {
		// TODO Auto-generated method stub
		return customerOrderItemDAO.myOrderByShipmentId(shipmentId);
	}
}
