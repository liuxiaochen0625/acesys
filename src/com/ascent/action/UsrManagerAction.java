package com.ascent.action;

import java.util.ArrayList;
import java.util.List;
import com.ascent.po.Usr;
import com.ascent.util.PageBean;
import com.opensymphony.xwork2.ActionContext;

public class UsrManagerAction extends BaseAction {
	//��ѯҳ��
	private String jumpPage;
//	ҳ��չ���û��б�� ����������
	private ArrayList dataList;
	//�û�uid
	private String uid;
	/**
	 * �������û��޸���Ϣʱ��Ӧ��Ϣ�ֶμ�setter��getter����
	 */
	private String city;
	private String username;
	private String fullname;
	private String title;
	private String tel;
	private String password;
	private String zip;
	private String email;
	private String country;
	private String companyname;
	private String companyaddress;
	private String note;
	private String job;
	private String superuser;
	private String del_flag;
	
	//��������ʾ�ֶ�
	private String tip;
	
	public String getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getSuperuser() {
		return superuser;
	}
	public void setSuperuser(String superuser) {
		this.superuser = superuser;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public ArrayList getDataList() {
		return dataList;
	}
	public void setDataList(ArrayList dataList) {
		this.dataList = dataList;
	}
	public String getJumpPage() {
		return jumpPage;
	}
	public void setJumpPage(String jumpPage) {
		this.jumpPage = jumpPage;
	}
	
//	���ط�ҳ��Ŀ�Ľ������
	public PageBean listData(String number){	//  ����һ����װ���ݿ��ѯ���ݵ�ҳ�����
		PageBean page = new PageBean(usrService.getTotalRows());
		
		int pageNum = Integer.parseInt(number);
		String sql = "from Usr u order by u.id ";
		ArrayList data =usrService.getData(sql,page.rowsPage*(pageNum-1), page.rowsPage);
		page.currentPage = pageNum;
		page.data = data;
		
		return page;
	}
	//չ���û��б���÷������û��б��ҳ��
	public String page()throws Exception{
		this.pageReturn();
		return "show_users";
	}
	//�޸��û�ǰ�����û�uid��ȡ�û����ص��û���Ϣ�޸�ҳ��
	public String find_update()throws Exception{
		Usr u = usrService.findById(this.getUid());	
		ActionContext.getContext().getSession().put("UID", this.getUid());
		ActionContext.getContext().getSession().put("UID_Productuser", u);
		return "updateuser";
	}
	//�޸��û���Ϣ
	public String update() throws Exception{
		Usr u = usrService.findById(this.getUid());
		u.setCity(this.getCity());
		u.setUsername(this.getUsername());
		u.setCompanyaddress(this.getCompanyaddress());
		u.setCompanyname(this.getCompanyname());
		u.setEmail(this.getEmail());
		u.setCountry(this.getCountry());
		u.setFullname(this.getFullname());
		u.setJob(this.getJob());
		u.setTel(this.getTel());
		u.setTitle(this.getTitle());
		u.setZip(this.getZip());
		u.setNote(this.getNote());
		boolean bl = usrService.updateUsr(u);
		if(bl==true){
			this.pageReturn();
			return "show_users";
		}else{
			this.setTip(this.getText("productuserM_tip.update.error"));//�޸��û���Ϣ�����������޸�
			return "updateuser_error";
		}
	}
	//�û�Ȩ���޸�
	public String updatesuperuser() throws Exception{
		Usr u = usrService.findById(this.getUid());
		u.setSuperuser(this.getSuperuser());
		boolean bl = usrService.updateUsr(u);
		if(bl==true){
			this.pageReturn();
			return "show_users";
		}else{
			this.setTip(this.getText("productuserM_tip.update.error"));//�޸��û���Ϣ�����������޸�
			return "changesuperuser_error";
		}
	}
	//ɾ���û�  ��ɾ��  ��del_flag����Ϊ1��־ �������û�
	public String delete() throws Exception{
		Usr u = usrService.findById(this.getUid());
		u.setDelsoft("1");
		boolean bl =usrService.updateUsr(u);
		if(bl==true){
			this.pageReturn();
		}
		return "show_users";
		
	}
	//�ָ��û� ��del_flag����Ϊ0��־ �����û�
	public String restore() throws Exception{
		Usr u =usrService.findById(this.getUid());
		u.setDelsoft("0");
		boolean bl = usrService.updateUsr(u);
		if(bl==true){
			this.pageReturn();
		}
		return "show_users";
		
	}
	
	//�����������Աͨ��uid�鿴�û���Ϣ
	public String findByUid()throws Exception{
		Usr u = usrService.findById(this.getUid());	
		ActionContext.getContext().getSession().put("uid_puser", u);
		return "admin_order_user";
	}
	
//	���з�ҳ������Ϣ���� ÿ����Ҫ���ط�ҳ����ķ�������Ҫ������
	private void pageReturn(){
		String jump_page = this.getJumpPage();
		if(jump_page==null){
			jump_page="1";
		}
		PageBean page = this.listData(jump_page);
		ActionContext.getContext().getSession().put("product_page_list",page);
		this.setDataList(page.getData());
		
	}
	
	
}
