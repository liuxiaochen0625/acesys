package com.ascent.action;

import java.util.Map;

import com.ascent.po.Usr;
import com.opensymphony.xwork2.ActionContext;
@SuppressWarnings("serial")
public class RegistAction extends BaseAction {
	private String username;
	private String password;
	private String companyname;
	private String companyaddress;
	private String country;
	private String city;
	private String job;
	private String tel;
	private String zip;
	private String email;
	private String tip;
	private String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String execute()throws Exception{
		Map session =ActionContext.getContext().getSession();
		//��session��ȡ��֤��
		String code_temp = (String)session.get("CODE");
		//��session����֤��ǿ����գ�����ȫ
		session.put("CODE", null);
		
		if(!code_temp.equalsIgnoreCase(this.getCode().trim())){
			this.setTip(this.getText("regist_tip.code.error"));//"���������֤�벻ƥ�䣬������ע��"
			return ERROR;
		}else{
			if(this.usrService.findByUserName(this.getUsername())!=null){
				this.setTip(this.getText("regist_tip.username.used"));//"��ʹ�õ��û����Ѿ���ռ���ˣ�������ע��"
				return ERROR;
			}
			Usr u = new Usr();
			u.setUsername(this.getUsername());
			u.setPassword(this.getPassword());
			u.setCity(this.getCity());
			u.setCompanyname(this.getCompanyname());
			u.setCompanyaddress(this.getCompanyaddress());
			u.setCountry(this.getCountry());
			u.setJob(this.getJob());
			u.setTel(this.getTel());
			u.setZip(this.getZip());
			u.setEmail(this.getEmail());
			u.setSuperuser("1");
			u.setDelsoft("0");
			Usr  user=usrService.saveUsr(u);
			if(user!=null){
				session.put("productuser_regist",user);
				return SUCCESS;
			}else{
				this.setTip(this.getText("regist_tip.failure"));//"ע��ʧ���ˣ�������ע�ᣬ������ǲ��ܳɹ�ע�ᣬ�������Ա��ϵ"
				return ERROR;			
			}
		}
	}
}
