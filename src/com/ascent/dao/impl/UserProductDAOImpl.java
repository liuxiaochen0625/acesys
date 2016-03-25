package com.ascent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.UserProductDAO;
import com.ascent.po.UserProduct;

public class UserProductDAOImpl extends HibernateDaoSupport implements
		UserProductDAO {

	public UserProduct findByProperty(String uid, String pid) {
		List list = this.getHibernateTemplate().find("from UserProduct up where up.usrid=? and up.productid=?", 
														new Integer []{new Integer(uid),new Integer(pid)});
		if(list.size()>0){
			return (UserProduct)list.get(0);
		}
		return null;
	}

	public UserProduct findByUid(String uid) {
		List list = this.getHibernateTemplate().find("from UserProduct up where up.usrid=? ", 
														new Integer(uid));
		if(list.size()>0){
		return (UserProduct)list.get(0);
		}
		return null;
	}

	public void saveUerProduct(UserProduct userProduct) {
		this.getHibernateTemplate().save(userProduct);
	}

}
