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

	//�û�id
	private String uid;
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	//���ش������ֶ�
	private String tip;
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	//orderid�ֶ�
	private String orderid;
	
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	//�����ǽ���ʱ�û���Ϣ
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
	//���㷽��
	public String checkout()throws Exception{
		
		String content ="";//�ʼ�����
		String message="";//���շ���message
		//���ﳵ��Ʒ����
		Collection col =(Collection)ActionContext.getContext().getSession().get("cartshowlist");
		Iterator it = col.iterator();
		
		if(this.getUid()!=null){//��Ҫ�涩���ͷ��ʼ�
			Orders orders = new Orders();
			
			orders.setUsrid(new Integer(this.getUid())); //���ö���uid
			orders.setDelsoft("0");//���ö�����ɾ��λ 
			//ʹ�õ�ǰʱ���ʽ�����һ���������
			String ordernumber = new SimpleDateFormat("yyyyMMddhhmmss").format(new java.util.Date());
			orders.setOrdernumber(ordernumber);//���ö����ı��
			orders.setCreatetime(new java.sql.Date(System.currentTimeMillis()));//���ö�������ʱ��
			
			Set orderitemSet = new HashSet();//����Ҫ���ö����Ķ������
			while(it.hasNext()){
				Product p = (Product)it.next();
				Orderitem oi = new Orderitem();//������Ҫ��ӵ�set�е�ÿ��orderitem
				oi.setProductid(p.getId());//����ÿ��orderitem��Productid
				oi.setQuantity(p.getQuantity());//����ÿ��orderitem��quantity
				oi.setOrders(orders); //��ÿ��orderitem���ø���α����orders��1��
				orderitemSet.add(oi);//��ÿ��orderitem��ӵ��������
				
				//���汣�涩�� ����Ϊ���ʼ�����
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
			orders.setOrderitems(orderitemSet);//��������ϳ�ʼ����orders�����У�2��
			
			int orderId = ordersService.savaOrder(orders).intValue();//���涩���������ض�����
			
			this.setTip(this.getText("ordersM_tip.order.regist.checkout", new String[]{""+ordernumber}));//���Ķ������ǡ�"+orderId+"������ѡ�����Ʒ��Ϣ����Ա�Ѿ��յ���
		}else{//����Ҫ�涩�� ִ�з��ʼ�����
			//����ֱ��ִ�з��ʼ�����
			while(it.hasNext()){
				Product p = (Product)it.next();
				// ����Ϊ���ʼ�����
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
			this.setTip(this.getText("ordersM_tip.order.noregist.checkout"));//���Ƿ�ע���û�����ѡ�����Ʒ��Ϣ����Ա�Ѿ��յ���
		}
		message="<html xmlns='http://www.w3.org/1999/xhtml'> <head><meta http-equiv='Content-Type' content='text/html; charset=gb2312'/><style type='text/css'> <!-- <br> .table_cc {color:#FFFFFF; font-weight:bold; font-size:12px;} <br> .table_hei {font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#000000;} <br> .table_hui {font-family:Arial, Helvetica, sans-serif; font-size:12px; font-weight:bold; color:#666666;} --></style></head> <br>" +
				" <body><table width='550' border='0' cellspacing='0'><tr> <td height='18' colspan='7' bgcolor='#1B83D8'><div align='center' class='table_cc'><div align='left'>��Ʒ��Ϣ</div> </div></td></tr> <tr> <td width='71' height='26' bgcolor='#FFFFFF' class='table_hui'>��Category </td> <td width='100' bgcolor='#FFFFFF' class='table_hui'>CAS </td><td width='107' bgcolor='#FFFFFF' class='table_hui'> Name</td><td width='64' bgcolor='#FFFFFF' class='table_hui'>Formula</td><td width='82' bgcolor='#FFFFFF' class='table_hui'>Weight</td><td width='59' height='26' bgcolor='#FFFFFF' class='table_hui'>Quantity </td></tr><br>"+content+" </table>     <table width='550' border='0'><tr> <td height='1' colspan='4' bgcolor='#8CC6FF'></td></tr><tr> <td height='17' colspan='4'  bgcolor='#1B83D8' class='table_cc'>�û���Ϣ </td></tr><tr><td width='78' height='30' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td><td width='91'class='table_hui'>�û����� </td><td width='365' bgcolor='#FFFFFF' class='table_hui'>"+this.getUsername()+"</td></tr><tr><td width='78' height='23' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td>  <td width='91' height='23' class='table_hui'>�绰��</td><td width='365' bgcolor='#FFFFFF' class='table_hui'>"+this.getTel()+"</td></tr><tr><td width='78' height='23' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td> <td width='91' height='23' class='table_hui'>Email:</td> <td width='365' class='table_hui'>"+this.getEmail()+"</td></tr><tr> <td width='78' height='23' bgcolor='#FFFFFF' class='table_hui'>&nbsp;</td> <td width='91' height='23' class='table_hui'>��˾����:</td> <td width='365' class='table_hui'>"+this.getCompanyname()+"</td></tr></table>  </div></div></body></html>";
		Mailtb mailtb = mailService.findMail();
		if(mailtb!=null){
			new SendMail().sendMessage(mailtb.getFromaddress(), mailtb.getFromaddress().substring(0,mailtb.getFromaddress().indexOf("@")), mailtb.getFrompassword(),mailtb.getToaddress(), this.getEmail(), message);
		}else{
			this.setTip(this.getText("ordersM_tip.order.mail.no"));//�Բ��𣬹���Ա����δ���ã��ʼ�δ�ܷ��ͣ�����ϵ����Ա��
		}
		//������ﳵ
		ShopCart shopCart =(ShopCart)ActionContext.getContext().getSession().get("shopcart");
		shopCart.emptyCart();
		
		return "checkoutsucc";
	}
	
	//������ѯչ�ַ���
	@SuppressWarnings("unchecked")
	public String show()throws Exception{
		Usr u = (Usr)ActionContext.getContext().getSession().get("usr");
		List orderList = ordersService.findOrdersByUid(u.getId());
		ActionContext.getContext().getSession().put("orderlist", orderList);
		return "ordershow";
	}
	//����Ա������
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
