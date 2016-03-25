package com.ascent.action;

public class RegistCheckAction extends BaseAction {
	private String username;
	private String tip;
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
	public String execute()throws Exception{
		if(this.getUsername()==null||"".equals(this.getUsername().trim())){
			this.setTip(this.getText("registCheck_tip.username.require"));//"用户名不能为空"
			return SUCCESS;
		}
		if(this.usrService.findByUserName(this.getUsername())==null){
			this.setTip(this.getText("registCheck_tip.username.ok",new String[]{this.getUsername()}));//"恭喜您！用户名"+this.getUsername()+"可以使用"
		}else{
			this.setTip(this.getText("registCheck_tip.username.used",new String[]{this.getUsername()}));//"对不起！用户名"+this.getUsername()+"已被占用"
		}
		return SUCCESS;
	}
}
