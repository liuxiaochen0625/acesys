package com.ascent.action;

public class ProductIdCheckAction extends BaseAction {
	private String productId;
	private String tip;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String execute()throws Exception{
		//System.out.println("-------------");
		if(this.getProductId()==null||"".equals(this.getProductId().trim())){
			this.setTip(this.getText("productidcheck_tip.id.required"));//商品编号不能为空
			return SUCCESS;
		}
		if(this.productService.findByProductId(this.getProductId())==null){
			this.setTip(this.getText("productidcheck_tip.id.ok",new String[]{this.getProductId()}));//此编号"+this.getProductId()+"可以使用
		}else{
			this.setTip(this.getText("productidcheck_tip.id.used",new String[]{this.getProductId()}));//此编号"+this.getProductId()+"已被占用
		}
		return SUCCESS;
	}
}
