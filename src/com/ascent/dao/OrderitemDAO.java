package com.ascent.dao;

import java.util.List;

import com.ascent.po.Orderitem;

public interface OrderitemDAO {

	//根据orderid 查询orderitem 集合中对象是Product
	public List findOrderitemByOrderid(String orderid);
	//根据orderid和pid查询orderitem
	public Orderitem findOrderitemByOrderidPid(String orderid,String pid);
	//删除orderitem
	public void deleteOrderitem(Orderitem orderitem);
}
