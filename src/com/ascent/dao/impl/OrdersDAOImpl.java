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
			LOGGER.debug("���涩���ɹ���");
			return order.getId();
		}catch(Exception e){
			LOGGER.debug("���涩��ʧ�ܣ�");
			e.printStackTrace();
			return null;
		}
	}

	public void deleteOrder(Orders order) {
		try{
			this.getHibernateTemplate().delete(order);
			LOGGER.debug("ɾ�������ɹ���");
		}catch(Exception e){
			LOGGER.debug("ɾ������ʧ�ܣ�");
			e.printStackTrace();
		}
	}

	public List findAllOrders() {
		LOGGER.debug("��ѯ���ж�����");
		return this.getHibernateTemplate().find("from Orders o order by o.id desc");
	}

	public Orders findOrderById(String orderid) {
		List list =this.getHibernateTemplate().find("from Orders o where o.id=?",new Integer(orderid));
		if(list.size()>0){
			LOGGER.debug("���ݶ���id�ɹ���ѯ��������");
			return (Orders)list.get(0);
		}
		LOGGER.debug("���ݶ���idδ��ѯ��������");
		return null;
	}

	public List findOrdersByUid(Integer uid) {
		LOGGER.debug("�����û�id��ѯ�û���Ӧ���еĶ�����");
		return this.getHibernateTemplate().find("from Orders o where o.usrid=? order by o.id",uid);
	}

}
