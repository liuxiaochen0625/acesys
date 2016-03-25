package com.ascent.service.impl;

import java.util.List;

import com.ascent.dao.OrdersDAO;
import com.ascent.po.Orders;
import com.ascent.service.OrdersService;

public class OrdersServiceImpl implements OrdersService {
	private OrdersDAO ordersDAO;
	public OrdersDAO getOrdersDAO() {
		return ordersDAO;
	}
	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}
	public Integer savaOrder(Orders order) {
		return ordersDAO.savaOrder(order);
	}
	public void deleteOrder(Orders order) {
		ordersDAO.deleteOrder(order);
	}
	public List findAllOrders() {
		return ordersDAO.findAllOrders();
	}
	public Orders findOrderById(String orderid) {
		return ordersDAO.findOrderById(orderid);
	}
	public List findOrdersByUid(Integer uid) {
		return ordersDAO.findOrdersByUid(uid);
	}

}
