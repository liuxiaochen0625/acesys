package com.ascent.service;

import com.ascent.po.Mailtb;

public interface MailService {
//	插入或更新管理员邮件
	public boolean saveMail(Mailtb mailtb);
	//删除mail
	public void deleteMail(Mailtb mailtb);
	//查询mail
	public Mailtb findMail();
//	修改邮箱
	public boolean updateMail(Mailtb mailtb);
}
