package com.ascent.dao;

import com.ascent.po.UserProduct;

public interface UserProductDAO {
	//根据uid和pid查询
	public UserProduct findByProperty(String uid,String pid);
	//根据uid查询
	public UserProduct findByUid(String uid);
	//保存
	public void saveUerProduct(UserProduct userProduct);
}
