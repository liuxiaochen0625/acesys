package com.ascent.dao;

import com.ascent.po.Mailtb;

public interface MailDAO {

	//�������Ա�ʼ�
	public boolean saveMail(Mailtb mailtb);
	//ɾ��mail
	public void deleteMail(Mailtb mailtb);
	//��ѯmail
	public Mailtb findMail();
	//�޸�����
	public boolean updateMail(Mailtb mailtb);
}
