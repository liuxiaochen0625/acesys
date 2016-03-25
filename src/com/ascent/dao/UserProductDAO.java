package com.ascent.dao;

import com.ascent.po.UserProduct;

public interface UserProductDAO {
	//����uid��pid��ѯ
	public UserProduct findByProperty(String uid,String pid);
	//����uid��ѯ
	public UserProduct findByUid(String uid);
	//����
	public void saveUerProduct(UserProduct userProduct);
}
