package com.ascent.service;

import java.util.ArrayList;
import java.util.List;

import com.ascent.po.Usr;

public interface UsrService {
	//注册方法
	public Usr saveUsr(Usr usr);
	//按照姓名查询方法
	public Usr findByUserName(String username);
	//用户登陆验证的方法
	public Usr checkUsr(String username,String password);
//	查询所有用户
	public List findAll();
//	返回查询所有行 分页
	public int getTotalRows();
	//查询分页设置数量的数据
	public  ArrayList getData( final  String sql, final   int  firstRow, final   int  maxRow);
	//按主键查询用户
	public Usr findById(String uid);
	//删除用户
	public boolean deleteUsr(String uid);
	//修改用户信息
	public boolean updateUsr(Usr usr);
	
}
