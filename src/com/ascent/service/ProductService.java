package com.ascent.service;

import java.util.ArrayList;
import java.util.List;

import com.ascent.po.Product;

public interface ProductService {
//	�����Ʒ����
	public void saveProduct(Product product);
//	������Ʒ��Ų�ѯ��Ʒ
	public Product findByProductId(String productId);
//	���ز�ѯ������ ��ҳ
	public int getTotalRows();
	//��ѯ��ҳ��������������
	public  ArrayList getData(String sql,int firstRow,int maxRow);
//	�޸���Ʒ
	public void updateProduct(Product product);
//	����pid������ѯ��Ʒ
	public Product findByPid(String pid);
//	���������Ʒ--excel
	public void saveExcelProduct(ArrayList arrayList);
//	��ѯ������Ʒ
	public List findAll();
//	���ݲ�ѯ������ѯ
	public List findBySearchProperty(String searchName,String searchValue);
//	�����û�id��ѯ������Ʒ
	public List findByUid(Integer uid);
//	��ѯ�����²�Ʒ
	public List findNewProducts();
}
