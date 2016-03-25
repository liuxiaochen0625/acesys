package com.ascent.test;
import junit.framework.TestCase;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
public class SpringTestCase extends TestCase {
	private static ApplicationContext applicationContext;

	  /**
	   * @see junit.framework.TestCase#setUp()
	   */
	  protected void setUp() throws Exception {
	    super.setUp();
	    File file = new File("WebRoot/WEB-INF/classes");
	    if (file.exists()) {
	      System.setProperty("webapp.root", file.getAbsolutePath());
	    }
	    else {
	      file = new File("acesys/WebRoot/");
	      System.setProperty("webapp.root", file.getAbsolutePath());
	    }
	    if (applicationContext == null) {
	      try {
	        applicationContext = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/applicationContext.xml");
	      }
	      catch (Exception ex) {
	        ex.printStackTrace();
	        applicationContext = new FileSystemXmlApplicationContext(
	            "acesys/WebRoot/WEB-INF/config/applicationContext.xml");
	      }
	    }
	  }

	  /**
	   * @return Returns the applicationContext.
	   */
	  public ApplicationContext getApplicationContext() {
	    return applicationContext;
	  }

	  /**
	   * 根据文件与类路径的相对位置获取实际的文件对象
	   * 
	   * @param filePath 文件与类路径的位置
	   * @return 文件对象
	   */
	  public File getFileByClass(String filePath) {
	    URL url = this.getClass().getResource(filePath);
	    String path;
	    try {
	      path = URLDecoder.decode(url.getFile(), "GBK");
	    }
	    catch (UnsupportedEncodingException ex) {
	      throw new RuntimeException(ex);
	    }
	    File file = new File(path);
	    if (!file.exists()) {
	      throw new RuntimeException("文件不存在！");
	    }
	    return file;
	  }
}

