package com.ascent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.OrderitemDAO;
import com.ascent.po.Orderitem;

public class OrderitemDAOImpl extends HibernateDaoSupport implements
		OrderitemDAO {

	public void deleteOrderitem(Orderitem orderitem) {
		this.getHibernateTemplate().delete(orderitem);
	}

	public List findOrderitemByOrderid(String orderid) {
		String sql = "select p from Product p,Orderitem o where p.id=o.productid and o.orders.id=?";
		return this.getHibernateTemplate().find(sql,new Integer(orderid));
	}

	public Orderitem findOrderitemByOrderidPid(String orderid, String pid) {
		String sql = "from Orderitem o where o.orders.id=? and o.productid=?";
		List list = this.getHibernateTemplate().find(sql, new Integer []{new Integer(orderid),new Integer(pid)});
		if(list.size()>0){
			return (Orderitem)list.get(0);
		}
		return null;
	}

}
