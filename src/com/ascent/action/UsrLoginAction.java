package com.ascent.action;
import java.util.ArrayList;
import java.util.List;

import com.ascent.po.Usr;
import com.ascent.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
@SuppressWarnings("serial")
public class UsrLoginAction extends BaseAction {
	private String username;
	private String password;
	private String tip;
	//页面展现用户列表的 处理结果集合
	private ArrayList dataList;
	public ArrayList getDataList() {
		return dataList;
	}
	public void setDataList(ArrayList dataList) {
		this.dataList = dataList;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	@SuppressWarnings("unchecked")
	public String execute()throws Exception{
		Usr u = usrService.checkUsr(this.getUsername(), this.getPassword());
		if(u==null){	//用户登录失败
			this.setTip(this.getText("userL_tip.login.fail"));//"用户名和密码不匹配错误"
			return ERROR;
		}else
		{	//用户登录成功  这里开始判断权限 将用户保存到session
			ActionContext.getContext().getSession().put("usr", u);
			String superuser = u.getSuperuser();
			if(superuser.equals("1")){//普通注册用户
				return "success_1";
			}else if(superuser.equals("2")){//分配了能看到某些药品价格的用户
				return "success_2";
			}else if(superuser.equals("3")){//admin 因为第一次来此页面 设置页数为1 
				PageBean page = this.listData("1");
				//ActionContext.getContext().getSession().put("pageBean",page);
				ActionContext.getContext().getSession().put("product_page_list",page);
				this.setDataList(page.getData());
				//取得所有商品，给用户分配商品权限时使用
				List allProductList = productService.findAll();
				ActionContext.getContext().getSession().put("allProductList",allProductList);
				return "success_3";
			}
			return SUCCESS;
		}
		
		
	}
	
	//返回分页数目的结果集合 查询包括del_flag 为1的标志删除用户（不活动用户）
	public PageBean listData(String number){	//  返回一个封装数据库查询数据的页面对象
		PageBean page = new PageBean(usrService.getTotalRows());
		
		int pageNum = Integer.parseInt(number);
		String sql = "from Usr u  order by u.id";
		ArrayList data = usrService.getData(sql,page.rowsPage*(pageNum-1), page.rowsPage);
		page.currentPage = pageNum;
		page.data = data;
		
		return page;
	}
}
