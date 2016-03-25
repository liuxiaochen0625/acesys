package com.ascent.service;

import java.util.ArrayList;
import java.util.List;

import com.ascent.po.Usr;

public interface UsrService {
	//ע�᷽��
	public Usr saveUsr(Usr usr);
	//����������ѯ����
	public Usr findByUserName(String username);
	//�û���½��֤�ķ���
	public Usr checkUsr(String username,String password);
//	��ѯ�����û�
	public List findAll();
//	���ز�ѯ������ ��ҳ
	public int getTotalRows();
	//��ѯ��ҳ��������������
	public  ArrayList getData( final  String sql, final   int  firstRow, final   int  maxRow);
	//��������ѯ�û�
	public Usr findById(String uid);
	//ɾ���û�
	public boolean deleteUsr(String uid);
	//�޸��û���Ϣ
	public boolean updateUsr(Usr usr);
	
}
