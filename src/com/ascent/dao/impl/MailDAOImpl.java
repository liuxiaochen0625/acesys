package com.ascent.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.MailDAO;
import com.ascent.po.Mailtb;

public class MailDAOImpl extends HibernateDaoSupport implements MailDAO {

	public void deleteMail(Mailtb mailtb) {
		this.getHibernateTemplate().delete(mailtb);
	}

	public boolean saveMail(Mailtb mailtb) {
		boolean bl =false;
		try{
			this.getHibernateTemplate().save(mailtb);
			bl=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return bl;
	}

	public Mailtb findMail() {
		List list = this.getHibernateTemplate().find("from Mailtb");
		if(list.size()>0){
			return (Mailtb)list.get(0);
		}
		return null;
	}

	public boolean updateMail(Mailtb mailtb) {
		try{
			this.getHibernateTemplate().update(mailtb);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	
}
