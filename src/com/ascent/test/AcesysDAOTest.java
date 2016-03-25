package com.ascent.test;
import junit.framework.Test;
import junit.framework.TestSuite;
public class AcesysDAOTest {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for acesys");
		// $JUnit-BEGIN$
		//添加ProductuserDAOImplTest测试类
		suite.addTestSuite(UsrDAOImplTest.class);
		
		//这里还可以添加其他测试类
		
		// $Junit-END$
		return suite;
	}

}
