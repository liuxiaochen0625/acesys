package com.ascent.test;
import junit.framework.Test;
import junit.framework.TestSuite;
public class AcesysDAOTest {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for acesys");
		// $JUnit-BEGIN$
		//���ProductuserDAOImplTest������
		suite.addTestSuite(UsrDAOImplTest.class);
		
		//���ﻹ�����������������
		
		// $Junit-END$
		return suite;
	}

}
