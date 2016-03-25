package com.ascent.test;
import com.ascent.dao.UsrDAO;
import com.ascent.po.Usr;
import com.ascent.test.SpringTestCase;
public class UsrDAOImplTest extends SpringTestCase{

	private UsrDAO usrDAO;
	protected void setUp() throws Exception {
		super.setUp();
		usrDAO = (UsrDAO)getApplicationContext().getBean ("usrDAO");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Test method for 'com.ascent.dao.impl.ProductuserDAOImpl.saveProductuser(Productuser productuser)'
	 */

	public void testSaveProductuser() {
		Usr u = new Usr();
		u.setUsername("usrJunit");
		u.setPassword("usrJunit");
		u.setEmail("usrJunit@gmail.com");
		usrDAO.saveUsr(u);
	}

	
	public void testFindByUserName(){
		Usr p = usrDAO.findByUserName("usrJunit");
	}
}
