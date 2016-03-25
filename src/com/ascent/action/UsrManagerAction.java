package com.ascent.action;

import java.util.ArrayList;
import java.util.List;
import com.ascent.po.Usr;
import com.ascent.util.PageBean;
import com.opensymphony.xwork2.ActionContext;

public class UsrManagerAction extends BaseAction {
	//查询页数
	private String jumpPage;
//	页面展现用户列表的 处理结果集合
	private ArrayList dataList;
	//用户uid
	private String uid;
	/**
	 * 下面是用户修改信息时对应信息字段及setter、getter方法
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
	
	//处理结果提示字段
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
	
//	返回分页数目的结果集合
	public PageBean listData(String number){	//  返回一个封装数据库查询数据的页面对象
		PageBean page = new PageBean(usrService.getTotalRows());
		
		int pageNum = Integer.parseInt(number);
		String sql = "from Usr u order by u.id ";
		ArrayList data =usrService.getData(sql,page.rowsPage*(pageNum-1), page.rowsPage);
		page.currentPage = pageNum;
		page.data = data;
		
		return page;
	}
	//展现用户列表调用方法（用户列表分页）
	public String page()throws Exception{
		this.pageReturn();
		return "show_users";
	}
	//修改用户前按照用户uid提取用户返回到用户信息修改页面
	public String find_update()throws Exception{
		Usr u = usrService.findById(this.getUid());	
		ActionContext.getContext().getSession().put("UID", this.getUid());
		ActionContext.getContext().getSession().put("UID_Productuser", u);
		return "updateuser";
	}
	//修改用户信息
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
			this.setTip(this.getText("productuserM_tip.update.error"));//修改用户信息错误，请重新修改
			return "updateuser_error";
		}
	}
	//用户权限修改
	public String updatesuperuser() throws Exception{
		Usr u = usrService.findById(this.getUid());
		u.setSuperuser(this.getSuperuser());
		boolean bl = usrService.updateUsr(u);
		if(bl==true){
			this.pageReturn();
			return "show_users";
		}else{
			this.setTip(this.getText("productuserM_tip.update.error"));//修改用户信息错误，请重新修改
			return "changesuperuser_error";
		}
	}
	//删除用户  软删除  将del_flag设置为1标志 不可用用户
	public String delete() throws Exception{
		Usr u = usrService.findById(this.getUid());
		u.setDelsoft("1");
		boolean bl =usrService.updateUsr(u);
		if(bl==true){
			this.pageReturn();
		}
		return "show_users";
		
	}
	//恢复用户 将del_flag设置为0标志 可用用户
	public String restore() throws Exception{
		Usr u =usrService.findById(this.getUid());
		u.setDelsoft("0");
		boolean bl = usrService.updateUsr(u);
		if(bl==true){
			this.pageReturn();
		}
		return "show_users";
		
	}
	
	//订单管理管理员通过uid查看用户信息
	public String findByUid()throws Exception{
		Usr u = usrService.findById(this.getUid());	
		ActionContext.getContext().getSession().put("uid_puser", u);
		return "admin_order_user";
	}
	
//	进行分页返回信息方法 每个需要返回分页结果的方法都需要调用它
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
