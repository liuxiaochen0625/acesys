package com.ascent.dao;

import java.util.List;

import com.ascent.po.Orders;

public interface OrdersDAO {
	//���ɶ����ķ���
	public Integer savaOrder(Orders order);
	//����uid��ѯ����
	public List findOrdersByUid(Integer uid);
	//��ѯ���Զ���
	public List findAllOrders();
	//ɾ������
	public void deleteOrder(Orders order);
	//���ݶ�����orderid��ѯ����
	public Orders findOrderById(String orderid);
}
