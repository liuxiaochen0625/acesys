package com.ascent.dao;

import java.util.List;

import com.ascent.po.Orderitem;

public interface OrderitemDAO {

	//����orderid ��ѯorderitem �����ж�����Product
	public List findOrderitemByOrderid(String orderid);
	//����orderid��pid��ѯorderitem
	public Orderitem findOrderitemByOrderidPid(String orderid,String pid);
	//ɾ��orderitem
	public void deleteOrderitem(Orderitem orderitem);
}
