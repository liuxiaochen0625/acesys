package com.ascent.service;

import com.ascent.po.UserProduct;

public interface UserProductService {
//	����uid��pid��ѯ
	public UserProduct findByProperty(String uid,String pid);
	//����uid��ѯ
	public UserProduct findByUid(String uid);
	//����
	public void saveUerProduct(UserProduct userProduct);
}
