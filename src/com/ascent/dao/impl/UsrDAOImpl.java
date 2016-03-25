package com.ascent.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ascent.dao.UsrDAO;
import com.ascent.po.Usr;


public class UsrDAOImpl extends HibernateDaoSupport implements
		UsrDAO {

	private static final Logger LOGGER = LogManager.getLogger(UsrDAOImpl.class);
	/**
	 * ע��Usr����ʵ��
	 */
	public Usr saveUsr(Usr usr) {
		try{
			this.getHibernateTemplate().save(usr);
			LOGGER.debug("�����û���Ϣ�����ݿ�ɹ���");
			return usr;
		}catch(Exception e){
			LOGGER.debug("�����û���Ϣ�����ݿ�ʧ�ܣ�");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * �����û�����ѯUsr
	 * ����������Usr���Ա���ѯ�û�����Ҫ�õ�������Ϣ�����Է��ظö���
	 * ��������null��˵�����û������û����в����ڣ���������ע��
	 */
	public Usr findByUserName(String username) {
		String sql = "from Usr u where u.username=? ";
		List list = this.getHibernateTemplate().find(sql, username);
		if(list.size()>0){
			LOGGER.debug("�����û�����ѯ���û���");
			return (Usr) list.get(0);
		}
		LOGGER.debug("�����û���δ��ѯ���û���");
		return null;
	}
	/**
	 * �û���½��֤�ķ��� delFlagΪ0��־������ʹ���û�
	 */
	public Usr checkUsr(String username, String password) {
		String sql = "from Usr u where u.username=? and u.password=? and u.delsoft='0' ";
		List list = this.getHibernateTemplate().find(sql, new String []{username,password});
		if(list.size()>0){
			LOGGER.debug("��¼�û���Ϣ��ȷ��");
			return (Usr)list.get(0);
		}
		LOGGER.debug("��¼�û���Ϣ����ȷ��û�и��û���");
		return null;
	}

	@SuppressWarnings("unchecked")
	public List findAll() {
		List list = new ArrayList();
		List l = this.getHibernateTemplate().find("from Usr u order by u.id");
		Iterator it = l.iterator();
		while(it.hasNext()){
			Usr u = (Usr)it.next();
			//u.setTemp4("<input type=\"checkbox\" name=\"infoid\" value=\""+u.getId()+"\">");
			list.add(u);
		}
		return list;
	}
	//��ѯ������ ��ҳ ��ѯ�����û�����delsoftΪ1�ı�־ɾ���û�
	public int getTotalRows() {
		String sql="from Usr u  order by u.id ";
		int totalRows = this.getHibernateTemplate().find(sql).size();
		LOGGER.debug("���������û�������");
		return totalRows;
	}
	
	/**
	 * @param sql ��ѯ����
	 * @param firstRow ��һ����¼λ��
	 * @param maxRow ��ѯ����
	 * @return list ���ز�ѯһҳ��¼�ļ���
	 */
	public  ArrayList getData(final String sql,final int firstRow, final int maxRow) {
		return  (ArrayList)this.getHibernateTemplate().executeFind( new  HibernateCallback(){
	             public  Object doInHibernate(Session session)  throws  SQLException,HibernateException {
	               Query q  =  session.createQuery(sql);
	               q.setFirstResult(firstRow);
	               q.setMaxResults(maxRow);	           
	               ArrayList data = (ArrayList) q.list();  
	               LOGGER.debug("�����û���¼���ϣ�");
	               return  data;  
	               }
	        });      
	 }

	//ɾ���û� ������Ϊ��ɾ�� ���Կ��ܲ���delete����
	public boolean deleteUsr(String uid) {
		Usr u = (Usr)this.getHibernateTemplate().load(Usr.class, new Integer(uid));
		this.getHibernateTemplate().delete(u);
		return true;
	}
	//����uid��ѯ�û�
	public Usr findById(String uid) {
		Usr u = (Usr)(this.getHibernateTemplate().find("from Usr u where u.id=?  ", new Integer(uid))).get(0);
		LOGGER.debug("�����û�id��ѯ���û���");
		return u;
	}
	//�޸��û���Ϣ
	public boolean updateUsr(Usr usr) {
		this.getHibernateTemplate().saveOrUpdate(usr);
		LOGGER.debug("�޸��û���Ϣ�ɹ���");
		return true;
	}

}
