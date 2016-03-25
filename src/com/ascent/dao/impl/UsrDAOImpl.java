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
	 * 注册Usr方法实现
	 */
	public Usr saveUsr(Usr usr) {
		try{
			this.getHibernateTemplate().save(usr);
			LOGGER.debug("保存用户信息到数据库成功！");
			return usr;
		}catch(Exception e){
			LOGGER.debug("保存用户信息到数据库失败！");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 根据用户名查询Usr
	 * 返回类型是Usr，以备查询用户有需要得到其他信息，所以返回该对象
	 * 当返回是null，说明该用户名的用户库中不存在，可以用来注册
	 */
	public Usr findByUserName(String username) {
		String sql = "from Usr u where u.username=? ";
		List list = this.getHibernateTemplate().find(sql, username);
		if(list.size()>0){
			LOGGER.debug("根据用户名查询到用户！");
			return (Usr) list.get(0);
		}
		LOGGER.debug("根据用户名未查询到用户！");
		return null;
	}
	/**
	 * 用户登陆验证的方法 delFlag为0标志正常可使用用户
	 */
	public Usr checkUsr(String username, String password) {
		String sql = "from Usr u where u.username=? and u.password=? and u.delsoft='0' ";
		List list = this.getHibernateTemplate().find(sql, new String []{username,password});
		if(list.size()>0){
			LOGGER.debug("登录用户信息正确！");
			return (Usr)list.get(0);
		}
		LOGGER.debug("登录用户信息不正确，没有该用户！");
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
	//查询总行数 分页 查询所有用户包括delsoft为1的标志删除用户
	public int getTotalRows() {
		String sql="from Usr u  order by u.id ";
		int totalRows = this.getHibernateTemplate().find(sql).size();
		LOGGER.debug("返回所有用户总数！");
		return totalRows;
	}
	
	/**
	 * @param sql 查询条件
	 * @param firstRow 第一条记录位置
	 * @param maxRow 查询几条
	 * @return list 返回查询一页记录的集合
	 */
	public  ArrayList getData(final String sql,final int firstRow, final int maxRow) {
		return  (ArrayList)this.getHibernateTemplate().executeFind( new  HibernateCallback(){
	             public  Object doInHibernate(Session session)  throws  SQLException,HibernateException {
	               Query q  =  session.createQuery(sql);
	               q.setFirstResult(firstRow);
	               q.setMaxResults(maxRow);	           
	               ArrayList data = (ArrayList) q.list();  
	               LOGGER.debug("返回用户记录集合！");
	               return  data;  
	               }
	        });      
	 }

	//删除用户 需求中为软删除 所以可能不用delete方法
	public boolean deleteUsr(String uid) {
		Usr u = (Usr)this.getHibernateTemplate().load(Usr.class, new Integer(uid));
		this.getHibernateTemplate().delete(u);
		return true;
	}
	//根据uid查询用户
	public Usr findById(String uid) {
		Usr u = (Usr)(this.getHibernateTemplate().find("from Usr u where u.id=?  ", new Integer(uid))).get(0);
		LOGGER.debug("根据用户id查询到用户！");
		return u;
	}
	//修改用户信息
	public boolean updateUsr(Usr usr) {
		this.getHibernateTemplate().saveOrUpdate(usr);
		LOGGER.debug("修改用户信息成功！");
		return true;
	}

}
