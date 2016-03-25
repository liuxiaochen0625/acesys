package com.ascent.service.impl;

import com.ascent.dao.UserProductDAO;
import com.ascent.po.UserProduct;
import com.ascent.service.UserProductService;

public class UserProductServiceImpl implements UserProductService{
	private UserProductDAO userProductDAO;

	public UserProductDAO getUserProductDAO() {
		return userProductDAO;
	}

	public void setUserProductDAO(UserProductDAO userProductDAO) {
		this.userProductDAO = userProductDAO;
	}

	public UserProduct findByProperty(String uid, String pid) {
		// TODO Auto-generated method stub
		return userProductDAO.findByProperty(uid, pid);
	}

	public UserProduct findByUid(String uid) {
		// TODO Auto-generated method stub
		return userProductDAO.findByUid(uid);
	}

	public void saveUerProduct(UserProduct userProduct) {
		userProductDAO.saveUerProduct(userProduct);
	}
	
}
