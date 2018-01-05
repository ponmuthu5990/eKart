package com.niit.ekartback.DAO;

import java.util.List;

import com.niit.ekartback.model.CustomerOrderItem;

public interface CustomerOrderItemDAO {

public void save(CustomerOrderItem customerOrderItem);
	
	public void delete(CustomerOrderItem customerOrderItem);
	
	public void deleteAll();
	
	public void saveOrUpdate(CustomerOrderItem customerOrderItem);
	
	public boolean checkingOrderItem(String id, String status);
	
	public List<CustomerOrderItem> myOrder(int userId);
	
	public List<CustomerOrderItem> myOrderByShipmentId(int shipmentId);
	
	public List<CustomerOrderItem> Order();
	
}
