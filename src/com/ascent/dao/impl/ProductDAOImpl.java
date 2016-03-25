package com.ascent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.ProductDAO;
import com.ascent.po.Product;

public class ProductDAOImpl extends HibernateDaoSupport implements ProductDAO {
	//添加商品方法实现
	public void saveProduct(Product product) {
		this.getHibernateTemplate().save(product);
	}
	//	根据商品编号查询商品
	public Product findByProductId(String productId) {
		String sql = "from Product p where p.productnumber=? and p.delsoft='0'";
		List list = this.getHibernateTemplate().find(sql, productId);
		if(list.size()>0){
			Product product = (Product)list.get(0);
			return product;
			}
		return null;
	}
	/**
	 * @param sql
	 * @param firstRow
	 * @param maxRow
	 * @return list 对象，已包含一定数量的 User 在内
	 */
	public  ArrayList getData(final String sql,final int firstRow, final int maxRow) {
		return  (ArrayList)this.getHibernateTemplate().executeFind( new  HibernateCallback(){
	             public  Object doInHibernate(Session session)  throws  SQLException,HibernateException {
	               Query q  =  session.createQuery(sql);
	               q.setFirstResult(firstRow);
	               q.setMaxResults(maxRow);	           
	               ArrayList data = (ArrayList) q.list();  

	               return  data;  
	               }
	        });      
	 }
	public int getTotalRows() {
		String sql="from Product p where p.delsoft='0' order by p.id ";
		int totalRows = this.getHibernateTemplate().find(sql).size();
		return totalRows;
	}
	public void updateProduct(Product product) {
		System.out.println(product.getId());
		this.getHibernateTemplate().saveOrUpdate(product);
	}
//	根据pid主键查询商品
	public Product findByPid(String pid) {
		String sql = "from Product p where p.id=? and p.delsoft='0'";
		List list = this.getHibernateTemplate().find(sql, new Integer(pid));
		if(list.size()>0){
			Product product = (Product)list.get(0);
			return product;
			}
		return null;
	}
	//批量添加excel中产品
	public void saveExcelProduct(ArrayList arrayList) {
		for(int i=0;i<arrayList.size();i++){//for(1)
			//取出每个Sheet的内容
			ArrayList arrayList_Sheet=(ArrayList)arrayList.get(i);				
			for(int j=0;j<arrayList_Sheet.size();j++){//for(2)
				//取出每个Row的内容
				ArrayList arrayList_Row=(ArrayList)arrayList_Sheet.get(j);					
				Product p = new Product();
				for(int k=0;k<arrayList_Row.size();k++){//for(3)		
					
					p.setId(Integer.parseInt((String)arrayList_Row.get(0)));
					p.setCategoryno((String)arrayList_Row.get(1));
					p.setCas((String)arrayList_Row.get(2));
					p.setProductname((String)arrayList_Row.get(3));
					p.setImagepath((String)arrayList_Row.get(4));
					p.setMdlint((String)arrayList_Row.get(5));
					p.setFormula((String)arrayList_Row.get(6));
					p.setWeight((String)arrayList_Row.get(7));
					p.setPrice1(Float.parseFloat((String)arrayList_Row.get(8)));
					p.setPrice2(Float.parseFloat((String)arrayList_Row.get(9)));
					p.setStock((String)arrayList_Row.get(10));
					p.setRealstock((String)arrayList_Row.get(11));
					p.setIsnewproduct((String)arrayList_Row.get(12));
					p.setCategory((String)arrayList_Row.get(13));
					p.setNote((String)arrayList_Row.get(14));
					p.setDelsoft((String)arrayList_Row.get(15));
					
				}//for(3)				
				this.getHibernateTemplate().save(p);
			}//for(2)
			
		}//for(1)
	}
	public List findAll() {
		return this.getHibernateTemplate().find("from Product p where p.delsoft='0'");
	}
	
	public List findBySearchProperty(String searchName, String searchValue) {
		String sql = "from Product p where p."+searchName+" like '%"+searchValue+"%' and p.delsoft='0'";
		return this.getHibernateTemplate().find(sql);
	}
	public List findByUid(Integer uid) {
		String sql="select p from Product p ,UserProduct up where up.productid=p.id and up.usrid=? and p.delsoft='0' order by p.id";
		return this.getHibernateTemplate().find(sql, uid);
	}
	public List findNewProducts() {
		String sql ="from Product p where p.isnewproduct ='1' order by p.id desc";
		return this.getHibernateTemplate().find(sql);
	}

}
