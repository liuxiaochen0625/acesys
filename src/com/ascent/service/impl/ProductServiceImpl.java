package com.ascent.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ascent.dao.ProductDAO;
import com.ascent.po.Product;
import com.ascent.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO;
	//注入ProductDAO
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	//添加商品方法实现
	public void saveProduct(Product product) {
		productDAO.saveProduct(product);
	}
//	根据商品编号查询商品
	public Product findByProductId(String productId) {
		return productDAO.findByProductId(productId);
	}
	public ArrayList getData(String sql, int firstRow, int maxRow) {
		return productDAO.getData(sql, firstRow, maxRow);
	}
	public int getTotalRows() {
		return productDAO.getTotalRows();
	}
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}
	public Product findByPid(String pid) {
		return productDAO.findByPid(pid);
	}
	public void saveExcelProduct(ArrayList arrayList) {
		productDAO.saveExcelProduct(arrayList);
	}
	public List findAll() {
		return productDAO.findAll();
	}
	public List findBySearchProperty(String searchName, String searchValue) {
		return productDAO.findBySearchProperty(searchName, searchValue);
	}
	public List findByUid(Integer uid) {
		// TODO Auto-generated method stub
		return productDAO.findByUid(uid);
	}
	public List findNewProducts() {
		// TODO Auto-generated method stub
		return productDAO.findNewProducts();
	}

}
