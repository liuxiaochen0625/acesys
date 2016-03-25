package com.ascent.dao.impl;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.ascent.dao.OrdersDAO;
import com.ascent.po.Orderitem;
import com.ascent.po.Orders;

public class OrdersDAOImpl extends HibernateDaoSupport implements OrdersDAO {

	private static final Logger LOGGER = LogManager.getLogger(OrdersDAOImpl.class);
	public Integer savaOrder(Orders order) {
		try{
			this.getHibernateTemplate().save(order);
			LOGGER.debug("保存订单成功！");
			return order.getId();
		}catch(Exception e){
			LOGGER.debug("保存订单失败！");
			e.printStackTrace();
			return null;
		}
	}

	public void deleteOrder(Orders order) {
		try{
			this.getHibernateTemplate().delete(order);
			LOGGER.debug("删除订单成功！");
		}catch(Exception e){
			LOGGER.debug("删除订单失败！");
			e.printStackTrace();
		}
	}

	public List findAllOrders() {
		LOGGER.debug("查询所有订单！");
		return this.getHibernateTemplate().find("from Orders o order by o.id desc");
	}

	public Orders findOrderById(String orderid) {
		List list =this.getHibernateTemplate().find("from Orders o where o.id=?",new Integer(orderid));
		if(list.size()>0){
			LOGGER.debug("根据订单id成功查询到订单！");
			return (Orders)list.get(0);
		}
		LOGGER.debug("根据订单id未查询到订单！");
		return null;
	}

	public List findOrdersByUid(Integer uid) {
		LOGGER.debug("根据用户id查询用户对应所有的订单！");
		return this.getHibernateTemplate().find("from Orders o where o.usrid=? order by o.id",uid);
	}

}
