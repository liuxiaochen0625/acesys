package com.ascent.service;

import java.util.ArrayList;
import java.util.List;

import com.ascent.po.Product;

public interface ProductService {
//	添加商品方法
	public void saveProduct(Product product);
//	根据商品编号查询商品
	public Product findByProductId(String productId);
//	返回查询所有行 分页
	public int getTotalRows();
	//查询分页设置数量的数据
	public  ArrayList getData(String sql,int firstRow,int maxRow);
//	修改商品
	public void updateProduct(Product product);
//	根据pid主键查询商品
	public Product findByPid(String pid);
//	批量添加商品--excel
	public void saveExcelProduct(ArrayList arrayList);
//	查询所有商品
	public List findAll();
//	根据查询条件查询
	public List findBySearchProperty(String searchName,String searchValue);
//	根据用户id查询分配商品
	public List findByUid(Integer uid);
//	查询所有新产品
	public List findNewProducts();
}
