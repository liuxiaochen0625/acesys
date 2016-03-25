package com.ascent.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.ascent.po.Mailtb;

public class MailManagerAction extends BaseAction implements ServletResponseAware{

	private String fromaddressname;
	private String fromaddresstype;
	private String frompassword;
	private String toaddress;
	private String tip;
	
	public String getToaddress() {
		return toaddress;
	}
	public void setToaddress(String toaddress) {
		this.toaddress = toaddress;
	}
	public String getFromaddressname() {
		return fromaddressname;
	}
	public void setFromaddressname(String fromaddressname) {
		this.fromaddressname = fromaddressname;
	}
	public String getFromaddresstype() {
		return fromaddresstype;
	}
	public void setFromaddresstype(String fromaddresstype) {
		this.fromaddresstype = fromaddresstype;
	}
	public String getFrompassword() {
		return frompassword;
	}
	public void setFrompassword(String frompassword) {
		this.frompassword = frompassword;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
//	ʹ��HttpServletResponse ��Ҫ�Ĳ���
	private HttpServletResponse response;
	
	
	public String add()throws Exception{
		boolean bl = false; //�жϷ��ر�־
		String fromaddress =this.getFromaddressname()+this.getFromaddresstype();
		Mailtb mailtb =mailService.findMail();
		if(mailtb==null){ //û�оͲ���
			Mailtb mailtb2 =new Mailtb();
			mailtb2.setFromaddress(fromaddress);
			mailtb2.setFrompassword(this.getFrompassword());
			mailtb2.setToaddress(this.getToaddress());
			bl=mailService.saveMail(mailtb2);
		}else{
			mailtb.setFromaddress(fromaddress);
			mailtb.setFrompassword(this.getFrompassword());
			mailtb.setToaddress(this.getToaddress());
			bl=mailService.updateMail(mailtb);
		}
		if(bl){
			this.setTip(this.getText("mailM_tip.mail.succ")); //�������óɹ�
			return "addmailsucc";
		}
		else{
			this.setTip(this.getText("mailM_tip.mail.fail")); //��������ʧ�ܣ�����������
			return "addmailfail";
		}
	}
	
	public String find()throws Exception{
		Mailtb mailtb =mailService.findMail();
		String dthtml = "";
		if(mailtb==null){
			dthtml=this.getText("mailM_tip.mail.no"); //����Ա���仹û���ù����������������ò���
			response.setContentType("text/html; charset=gb2312");          
	        try {
				response.getWriter().print(dthtml);//����name�� ҳ�棻
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			String faddress = mailtb.getFromaddress();
			String taddress = mailtb.getToaddress();
			dthtml="������ַ��"+faddress+"<br>�ռ���ַ��"+taddress+"<br>������޸ģ����������Ĳ���";
			response.setContentType("text/html; charset=gb2312");          
	        try {
				response.getWriter().print(dthtml);//����name�� ҳ�棻
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
//	ʵ��ServletResponseAware�ӿڱ���ʵ�ֵķ���
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
