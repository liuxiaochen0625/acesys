package com.ascent.action;

import java.util.List;
import java.util.Map;

import com.ascent.po.Orderitem;
import com.opensymphony.xwork2.ActionContext;
@SuppressWarnings("serial")
public class OrderitemManagerAction extends BaseAction {

	private String orderid;
	private String pid;
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	//orderitem展现
	public String show ()throws Exception{
		List orderitemlist = orderitemService.findOrderitemByOrderid(this.getOrderid());
		Map session = ActionContext.getContext().getSession();
		session.put("orderid", this.getOrderid());
		session.put("orderitemlist", orderitemlist);
		return "orderitemshow";
	}
	
	//删除订单项
	public String delete()throws Exception{
		orderitemService.deleteOrderitem(orderitemService.findOrderitemByOrderidPid(this.getOrderid(), this.getPid()));
		List orderitemlist = orderitemService.findOrderitemByOrderid(this.getOrderid());
		Map session = ActionContext.getContext().getSession();
		session.put("orderid", this.getOrderid());
		session.put("orderitemlist", orderitemlist);
		return "orderitemshow";
		//Orderitem o = orderitemService.findOrderitemByOrderidPid(this.getOrderid(), this.getPid());
		//System.out.println("============="+o.getId());
		//return null;
	}
}
