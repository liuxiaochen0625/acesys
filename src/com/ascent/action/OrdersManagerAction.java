package com.ascent.action;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.ascent.util.SendMail;
import com.ascent.po.Orderitem;
import com.ascent.po.Orders;
import com.ascent.po.Product;
import com.ascent.po.Usr;
import com.ascent.util.ShopCart;
import com.ascent.po.Mailtb;
import com.opensymphony.xwork2.ActionContext;
@SuppressWarnings("serial")
public class OrdersManagerAction extends BaseAction {

	//用户id
	private String uid;
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	//返回处理结果字段
	private String tip;
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	//orderid字段
	private String orderid;
	
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	//下面是结算时用户信息
	private String username;
	private String tel;
	private String email;
	private String companyname;
	private String companyaddress;
	
	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@SuppressWarnings("unchecked")
	//结算方法
	public String checkout()throws Exception{
		
		String content ="";//邮件内容
		String message="";//最终发送message
		//购物车商品集合
		Collection col =(Collection)ActionContext.getContext().getSession().get("cartshowlist");
		Iterator it = col.iterator();
		
		if(this.getUid()!=null){//需要存订单和发邮件
			Orders orders = new Orders();
			
			orders.setUsrid(new Integer(this.getUid())); //设置订单uid
			orders.setDelsoft("0");//设置订单的删除位 
			//使用当前时间格式化获得一个订单编号
			String ordernumber = new SimpleDateFormat("yyyyMMddhhmmss").format(new java.util.Date());
			orders.setOrdernumber(ordernumber);//设置订单的编号
			orders.setCreatetime(new java.sql.Date(System.currentTimeMillis()));//设置订单创建时间
			
			Set orderitemSet = new HashSet();//后面要设置订单的订单项集合
			while(it.hasNext()){
				Product p = (Product)it.next();
				Orderitem oi = new Orderitem();//后面需要添加到set中的每个orderitem
				oi.setProductid(p.getId());//设置每个orderitem的Productid
				oi.setQuantity(p.getQuantity());//设置每个orderitem的quantity
				oi.setOrders(orders); //将每个orderitem设置给这次保存的orders（1）
				orderitemSet.add(oi);//将每个orderitem添加到订单项集合
				
				//上面保存订单 下面为发邮件功能
				String name  = p.getProductname();
				//String price = p.getPrice1();
				String catalog = p.getCategoryno();
				String cas =p.getCas(); 
				String formula = p.getFormula();
				String mw= p.getWeight();
				String quantity =p.getQuantity();
				String temp = "<tr  bgcolor='#99CCFF'> <td width='71' class='table_hei'>"+catalog+"</td><td width='100' class='table_hei'>"+cas+"</td><td width='107' class='table_hei'>"+name+"</td><td width='64' class='table_hei'>"+formula+"</td><td  width='82' class='table_hui'>"+mw+" g</td><td width='59' height='26'  class='table_hui'>"+quantity+"</td></tr>";
				content += temp;
			}
			orders.setOrderitems(orderitemSet);//将订单项集合初始化到orders订单中（2）
			
			int orderId = ordersService.savaOrder(orders).intValue();//保存订单，并返回订单号
			
			this.setTip(this.getText("ordersM_tip.order.regist.checkout", new String[]{""+ordernumber}));//您的订单号是【"+orderId+"】，您选择的商品信息管理员已经收到。
		}else{//不需要存订单 执行发邮件操作
			//下面直接执行发邮件功能
			while(it.hasNext()){
				Product p = (Product)it.next();
				// 下面为发邮件功能
				String name  = p.getProductname();
				//String price = p.getPrice1();
				String catalog = p.getCategoryno();
				String cas =p.getCas(); 
				String formula = p.getFormula();
				String mw= p.getWeight();
				String quantity =p.getQuantity();
				String temp = "<tr  bgcolor='#99CCFF'> <td width='71' class='table_hei'>"+catalog+"</td><td width='100' class='table_hei'>"+cas+"</td><td width='107' class='table_hei'>"+name+"</td><td width='64' class='table_hei'>"+formula+"</td><td  width='82' class='table_hui'>"+mw+"</td><td width='59' height='26'  class='table_hui'>"+quantity+"</td></tr>";
				content += temp;
			}
			this.setTip(this.getText("ordersM_tip.order.noregist.checkout"));//您是非注册用户，您选择的商品信息管理员已经收到。
		}
		message="<html xmlns='http://www.w3.org/1999/xhtml'> <head><meta http-equiv='Content-Type' content='text/html; charset=gb2312'/><style type='text/css'> <!-- <br> .table_cc {color:#FFFFFF; font-weight:bold; font-size:12px;} <br> .table_hei {font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#000000;} <br> .table_hui {font-family:Arial, Helvetica, sans-serif; font-size:12px; font-weight:bold; color:#666666;} --></style></head> <br>" +
				" <body><table width='550' border='0' cellspacing='0'><tr> <td height='18' colspan='7' bgcolor='#1B83D8'><div align='center' class='table_cc'><div align='left'>产品信息</div> </div></td></tr> <tr> <td width='71' height='26' bgcolor='#FFFFFF' class='table_hui'>　Category </td> <td width='100' bgcolor='#FFFFFF' class='table_hui'>CAS </td><td width='107' bgcolor='#FFFFFF' class='table_hui'> Name</td><td width='64' bgcolor='#FFFFFF' class='table_hui'>Formula</td><td width='82' bgcolor='#FFFFFF' class='table_hui'>Weight</td><td width='59' height='26' bgcolor='#FFFFFF' class='table_hui'>Quantity </td></tr><br>"+content+" </table>     <table width='550' border='0'><tr> <td height='1' colspan='4' bgcolor='#8CC6FF'></td></tr><tr> <td height='17' colspan='4'  bgcolor='#1B83D8' class='table_cc'>用户信息 </td></tr><tr><td width='78' height='30' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td><td width='91'class='table_hui'>用户名： </td><td width='365' bgcolor='#FFFFFF' class='table_hui'>"+this.getUsername()+"</td></tr><tr><td width='78' height='23' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td>  <td width='91' height='23' class='table_hui'>电话：</td><td width='365' bgcolor='#FFFFFF' class='table_hui'>"+this.getTel()+"</td></tr><tr><td width='78' height='23' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td> <td width='91' height='23' class='table_hui'>Email:</td> <td width='365' class='table_hui'>"+this.getEmail()+"</td></tr><tr> <td width='78' height='23' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td> <td width='91' height='23' class='table_hui'>公司名称:</td> <td width='365' class='table_hui'>"+this.getCompanyname()+"</td></tr></table>  </div></div></body></html>";
		Mailtb mailtb = mailService.findMail();
		if(mailtb!=null){
			new SendMail().sendMessage(mailtb.getFromaddress(), mailtb.getFromaddress().substring(0,mailtb.getFromaddress().indexOf("@")), mailtb.getFrompassword(),mailtb.getToaddress(), this.getEmail(), message);
		}else{
			this.setTip(this.getText("ordersM_tip.order.mail.no"));//对不起，管理员邮箱未设置，邮件未能发送，请联系管理员。
		}
		//清除购物车
		ShopCart shopCart =(ShopCart)ActionContext.getContext().getSession().get("shopcart");
		shopCart.emptyCart();
		
		return "checkoutsucc";
	}
	
	//订单查询展现方法
	@SuppressWarnings("unchecked")
	public String show()throws Exception{
		Usr u = (Usr)ActionContext.getContext().getSession().get("usr");
		List orderList = ordersService.findOrdersByUid(u.getId());
		ActionContext.getContext().getSession().put("orderlist", orderList);
		return "ordershow";
	}
	//管理员管理订单
	public String adminShow()throws Exception{
		List orderList = ordersService.findAllOrders();
		ActionContext.getContext().getSession().put("adminorderlist", orderList);
		return "adminordershow";
	} 
	
	public String delete()throws Exception{
		ordersService.deleteOrder(ordersService.findOrderById(this.getOrderid()));
		List orderList = ordersService.findAllOrders();
		ActionContext.getContext().getSession().put("adminorderlist", orderList);
		return "adminordershow";
	}
}
