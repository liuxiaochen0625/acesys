package com.ascent.action;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletResponseAware;
import com.ascent.po.Product;
import com.ascent.util.ShopCart;
import com.opensymphony.xwork2.ActionContext;
@SuppressWarnings("serial")
public class CartManagerAction extends BaseAction implements ServletResponseAware{
	//下面是页面传递参数及setter、getter方法
	private String pid;
	private String quantity;
	private String tip;
	
	//使用HttpServletResponse 需要的参数
	private HttpServletResponse response;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	@SuppressWarnings("unchecked")
	//添加商品到购物车方法
	public String add()throws Exception{
		@SuppressWarnings("unused")
		ShopCart shopCart =(ShopCart)ActionContext.getContext().getSession().get("shopcart");
		if(shopCart==null){
			//如果初次则创建shopcart
			shopCart = new ShopCart();
		}
		boolean bl =shopCart.checkPid(this.getPid());
		if(bl){//购物车已经添加  不做添加操作 
			//Ajax返回该商品已经添加过的提示
			String dthtml =this.getText("cartM_tip.pro_added") ;//"该商品已经添加过";
			response.setContentType("text/html; charset=gb2312");          
	        try {
				response.getWriter().print(dthtml);//返回name到 页面；
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{//添加到购物车
			Product p = productService.findByPid(pid);
			p.setQuantity("5g");
			shopCart.addProduct(pid,p);
			ActionContext.getContext().getSession().put("shopcart", shopCart);
			//Ajax返回商品名正确添加的提示
			String dthtml = this.getText("cartM_tip.pro.add.succ") ; //"添加该商品到购物车成功"
			response.setContentType("text/html; charset=gb2312");          
	        try {
				response.getWriter().print(dthtml);//返回name到 页面；
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//将购物车展现方法
	@SuppressWarnings("unchecked")
	public String cartShow()throws Exception{
		Collection cartList = this.cartList();
		ActionContext.getContext().getSession().put("cartshowlist", cartList);
		return "cartshow";
	}
	
	//删除购物车中某一商品
	@SuppressWarnings("unchecked")
	public String delete()throws Exception{
		ShopCart shopCart =(ShopCart)ActionContext.getContext().getSession().get("shopcart");
		shopCart.delProduct(this.getPid());
		ActionContext.getContext().getSession().put("shopcart", shopCart);
		Collection cartList = this.cartList();
		ActionContext.getContext().getSession().put("cartshowlist", cartList);
		return "cartshow";
	}
	
	
	//修改购物车某商品质量
	@SuppressWarnings("unchecked")
	public String updateQuantity()throws Exception{
		ShopCart shopCart =(ShopCart)ActionContext.getContext().getSession().get("shopcart");
		shopCart.updateQuantity(this.getPid(), this.getQuantity());
		ActionContext.getContext().getSession().put("shopcart", shopCart);
		String dthtml = this.getText("cartM_tip.pro.quantity.update");  //"商品质量已经修改"
		response.setContentType("text/html; charset=gb2312");          
        try {
			response.getWriter().print(dthtml);//返回name到 页面；
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//展现购物车前将hashmap中values转换为List集合的公用方法
	public Collection cartList(){
		ShopCart shopCart =(ShopCart)ActionContext.getContext().getSession().get("shopcart");
		Collection cartList= null;
		if(shopCart==null){//未购买过东西 
			this.setTip(this.getText("cartM_tip.pro.no")); //"您的购物车没商品"
		}else if(shopCart.getHashMap().values().size()<1){//购买过  但是全删除完了
			this.setTip(this.getText("cartM_tip.pro.no")); //"您的购物车没商品"
		}else{
			cartList = shopCart.getHashMap().values();
		}
		return cartList;
	}
	
	//实现ServletResponseAware接口必须实现的方法
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
