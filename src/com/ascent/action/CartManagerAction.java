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
	//������ҳ�洫�ݲ�����setter��getter����
	private String pid;
	private String quantity;
	private String tip;
	
	//ʹ��HttpServletResponse ��Ҫ�Ĳ���
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
	//�����Ʒ�����ﳵ����
	public String add()throws Exception{
		@SuppressWarnings("unused")
		ShopCart shopCart =(ShopCart)ActionContext.getContext().getSession().get("shopcart");
		if(shopCart==null){
			//��������򴴽�shopcart
			shopCart = new ShopCart();
		}
		boolean bl =shopCart.checkPid(this.getPid());
		if(bl){//���ﳵ�Ѿ����  ������Ӳ��� 
			//Ajax���ظ���Ʒ�Ѿ���ӹ�����ʾ
			String dthtml =this.getText("cartM_tip.pro_added") ;//"����Ʒ�Ѿ���ӹ�";
			response.setContentType("text/html; charset=gb2312");          
	        try {
				response.getWriter().print(dthtml);//����name�� ҳ�棻
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{//��ӵ����ﳵ
			Product p = productService.findByPid(pid);
			p.setQuantity("5g");
			shopCart.addProduct(pid,p);
			ActionContext.getContext().getSession().put("shopcart", shopCart);
			//Ajax������Ʒ����ȷ��ӵ���ʾ
			String dthtml = this.getText("cartM_tip.pro.add.succ") ; //"��Ӹ���Ʒ�����ﳵ�ɹ�"
			response.setContentType("text/html; charset=gb2312");          
	        try {
				response.getWriter().print(dthtml);//����name�� ҳ�棻
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	//�����ﳵչ�ַ���
	@SuppressWarnings("unchecked")
	public String cartShow()throws Exception{
		Collection cartList = this.cartList();
		ActionContext.getContext().getSession().put("cartshowlist", cartList);
		return "cartshow";
	}
	
	//ɾ�����ﳵ��ĳһ��Ʒ
	@SuppressWarnings("unchecked")
	public String delete()throws Exception{
		ShopCart shopCart =(ShopCart)ActionContext.getContext().getSession().get("shopcart");
		shopCart.delProduct(this.getPid());
		ActionContext.getContext().getSession().put("shopcart", shopCart);
		Collection cartList = this.cartList();
		ActionContext.getContext().getSession().put("cartshowlist", cartList);
		return "cartshow";
	}
	
	
	//�޸Ĺ��ﳵĳ��Ʒ����
	@SuppressWarnings("unchecked")
	public String updateQuantity()throws Exception{
		ShopCart shopCart =(ShopCart)ActionContext.getContext().getSession().get("shopcart");
		shopCart.updateQuantity(this.getPid(), this.getQuantity());
		ActionContext.getContext().getSession().put("shopcart", shopCart);
		String dthtml = this.getText("cartM_tip.pro.quantity.update");  //"��Ʒ�����Ѿ��޸�"
		response.setContentType("text/html; charset=gb2312");          
        try {
			response.getWriter().print(dthtml);//����name�� ҳ�棻
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//չ�ֹ��ﳵǰ��hashmap��valuesת��ΪList���ϵĹ��÷���
	public Collection cartList(){
		ShopCart shopCart =(ShopCart)ActionContext.getContext().getSession().get("shopcart");
		Collection cartList= null;
		if(shopCart==null){//δ��������� 
			this.setTip(this.getText("cartM_tip.pro.no")); //"���Ĺ��ﳵû��Ʒ"
		}else if(shopCart.getHashMap().values().size()<1){//�����  ����ȫɾ������
			this.setTip(this.getText("cartM_tip.pro.no")); //"���Ĺ��ﳵû��Ʒ"
		}else{
			cartList = shopCart.getHashMap().values();
		}
		return cartList;
	}
	
	//ʵ��ServletResponseAware�ӿڱ���ʵ�ֵķ���
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
