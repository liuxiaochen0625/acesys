package com.ascent.action;

import com.ascent.po.UserProduct;

public class UserProductAddAction extends BaseAction {
	private String uid;
	private String [] pid;
	private String tip;
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String[] getPid() {
		return pid;
	}
	public void setPid(String[] pid) {
		this.pid = pid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String execute()throws Exception{
		String p_id []=this.getPid();
		System.out.println(p_id.length);
		System.out.println(p_id[0]);
		System.out.println(uid);
		for(int i =0;i<p_id.length;i++){  //循环pid  进行插入  插入前先查询 有=不执行插入  无=进行插入
			UserProduct uptemp = userProductService.findByProperty(this.getUid(), p_id[i]);
			if(uptemp==null){
				UserProduct up = new UserProduct();
				up.setUsrid(new Integer(this.getUid()));
				up.setProductid(new Integer(p_id[i]));
				this.userProductService.saveUerProduct(up);
			}
		}
		return SUCCESS;
	}
}
