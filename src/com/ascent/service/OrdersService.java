package com.ascent.service;

import java.util.List;

import com.ascent.po.Orders;

public interface OrdersService {
//	生成订单的方法
	public Integer savaOrder(Orders order);
//	根据uid查询订单
	public List findOrdersByUid(Integer uid);
	//查询所以订单
	public List findAllOrders();
	//删除订单
	public void deleteOrder(Orders order);
	//根据订单号orderid查询订单
	public Orders findOrderById(String orderid);
}
