package com.ascent.service.impl;

import com.ascent.dao.MailDAO;
import com.ascent.po.Mailtb;
import com.ascent.service.MailService;

public class MailServiceImpl implements MailService {

	private MailDAO mailDAO;
	
	public MailDAO getMailDAO() {
		return mailDAO;
	}

	public void setMailDAO(MailDAO mailDAO) {
		this.mailDAO = mailDAO;
	}

	public void deleteMail(Mailtb mailtb) {
		mailDAO.deleteMail(mailtb);
	}

	public Mailtb findMail() {
		return mailDAO.findMail();
	}

	public boolean saveMail(Mailtb mailtb) {
		return mailDAO.saveMail(mailtb);
	}

	public boolean updateMail(Mailtb mailtb) {
		return mailDAO.updateMail(mailtb);
	}

}
