package com.ascent.service;

import java.util.List;

import com.ascent.po.Orders;

public interface OrdersService {
//	���ɶ����ķ���
	public Integer savaOrder(Orders order);
//	����uid��ѯ����
	public List findOrdersByUid(Integer uid);
	//��ѯ���Զ���
	public List findAllOrders();
	//ɾ������
	public void deleteOrder(Orders order);
	//���ݶ�����orderid��ѯ����
	public Orders findOrderById(String orderid);
}
