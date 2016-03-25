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
	//ҳ��չ���û��б�� ����������
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
		if(u==null){	//�û���¼ʧ��
			this.setTip(this.getText("userL_tip.login.fail"));//"�û��������벻ƥ�����"
			return ERROR;
		}else
		{	//�û���¼�ɹ�  ���￪ʼ�ж�Ȩ�� ���û����浽session
			ActionContext.getContext().getSession().put("usr", u);
			String superuser = u.getSuperuser();
			if(superuser.equals("1")){//��ͨע���û�
				return "success_1";
			}else if(superuser.equals("2")){//�������ܿ���ĳЩҩƷ�۸���û�
				return "success_2";
			}else if(superuser.equals("3")){//admin ��Ϊ��һ������ҳ�� ����ҳ��Ϊ1 
				PageBean page = this.listData("1");
				//ActionContext.getContext().getSession().put("pageBean",page);
				ActionContext.getContext().getSession().put("product_page_list",page);
				this.setDataList(page.getData());
				//ȡ��������Ʒ�����û�������ƷȨ��ʱʹ��
				List allProductList = productService.findAll();
				ActionContext.getContext().getSession().put("allProductList",allProductList);
				return "success_3";
			}
			return SUCCESS;
		}
		
		
	}
	
	//���ط�ҳ��Ŀ�Ľ������ ��ѯ����del_flag Ϊ1�ı�־ɾ���û�������û���
	public PageBean listData(String number){	//  ����һ����װ���ݿ��ѯ���ݵ�ҳ�����
		PageBean page = new PageBean(usrService.getTotalRows());
		
		int pageNum = Integer.parseInt(number);
		String sql = "from Usr u  order by u.id";
		ArrayList data = usrService.getData(sql,page.rowsPage*(pageNum-1), page.rowsPage);
		page.currentPage = pageNum;
		page.data = data;
		
		return page;
	}
}
