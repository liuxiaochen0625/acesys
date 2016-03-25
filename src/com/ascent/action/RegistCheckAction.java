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
			this.setTip(this.getText("registCheck_tip.username.require"));//"�û�������Ϊ��"
			return SUCCESS;
		}
		if(this.usrService.findByUserName(this.getUsername())==null){
			this.setTip(this.getText("registCheck_tip.username.ok",new String[]{this.getUsername()}));//"��ϲ�����û���"+this.getUsername()+"����ʹ��"
		}else{
			this.setTip(this.getText("registCheck_tip.username.used",new String[]{this.getUsername()}));//"�Բ����û���"+this.getUsername()+"�ѱ�ռ��"
		}
		return SUCCESS;
	}
}
