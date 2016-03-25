package com.ascent.action;
import com.ascent.service.MailService;
import com.ascent.service.OrderitemService;
import com.ascent.service.OrdersService;
import com.ascent.service.ProductService;
import com.ascent.service.UsrService;
import com.ascent.service.UserProductService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	//BaseAction中定义service接口，所有Action继承该父类 ，不用每个Action中都得引入了
	protected UsrService usrService;
	public UsrService getUsrService() {
		return usrService;
	}
	public void setUsrService(UsrService usrService) {
		this.usrService = usrService;
	}
	
	
	protected ProductService productService;
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	protected UserProductService userProductService;
	public UserProductService getUserProductService() {
		return userProductService;
	}
	public void setUserProductService(UserProductService userProductService) {
		this.userProductService = userProductService;
	}
	
	protected OrdersService ordersService;
	public OrdersService getOrdersService() {
		return ordersService;
	}
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
	protected OrderitemService orderitemService;
	public OrderitemService getOrderitemService() {
		return orderitemService;
	}
	public void setOrderitemService(OrderitemService orderitemService) {
		this.orderitemService = orderitemService;
	}
	protected MailService mailService;
	public MailService getMailService() {
		return mailService;
	}
	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
	
}
