package com.ascent.service.impl;

import java.util.List;

import com.ascent.dao.OrderitemDAO;
import com.ascent.po.Orderitem;
import com.ascent.service.OrderitemService;

public class OrderitemServiceImpl implements OrderitemService {

	private OrderitemDAO orderitemDAO;
	
	public OrderitemDAO getOrderitemDAO() {
		return orderitemDAO;
	}

	public void setOrderitemDAO(OrderitemDAO orderitemDAO) {
		this.orderitemDAO = orderitemDAO;
	}

	public void deleteOrderitem(Orderitem orderitem) {
		orderitemDAO.deleteOrderitem(orderitem);
	}

	public List findOrderitemByOrderid(String orderid) {
		return orderitemDAO.findOrderitemByOrderid(orderid);
	}

	public Orderitem findOrderitemByOrderidPid(String orderid, String pid) {
		return orderitemDAO.findOrderitemByOrderidPid(orderid, pid);
	}

}
