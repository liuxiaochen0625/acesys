package com.ascent.service;

import com.ascent.po.Mailtb;

public interface MailService {
//	�������¹���Ա�ʼ�
	public boolean saveMail(Mailtb mailtb);
	//ɾ��mail
	public void deleteMail(Mailtb mailtb);
	//��ѯmail
	public Mailtb findMail();
//	�޸�����
	public boolean updateMail(Mailtb mailtb);
}
