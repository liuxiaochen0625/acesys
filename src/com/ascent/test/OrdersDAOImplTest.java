package com.ascent.test;

import com.ascent.dao.OrdersDAO;
import com.ascent.dao.UsrDAO;

public class OrdersDAOImplTest extends SpringTestCase {

	private OrdersDAO ordersDAO;
	protected void setUp() throws Exception {
		super.setUp();
		ordersDAO = (OrdersDAO)getApplicationContext().getBean ("ordersDAO");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFindAllOrders() {
		ordersDAO.findAllOrders();
	}

}
