package com.ascent.dao;

import java.util.ArrayList;
import java.util.List;
import com.ascent.po.Usr;

public interface UsrDAO {
	//注册
	public Usr saveUsr(Usr usr);
	//按用户名查用户
	public Usr findByUserName(String username);
	//用户登陆验证的方法
	public Usr checkUsr(String username,String password);
	//	查询所有用户
	public List findAll();
	//返回查询所有行 分页
	public int getTotalRows();
	//查询分页设置数量的数据集合
	public  ArrayList getData(String sql,int firstRow,int maxRow);
//	按主键查询用户
	public Usr findById(String uid);
	//删除用户
	public boolean deleteUsr(String uid);
	//修改用户信息
	public boolean updateUsr(Usr usr);
	
}
