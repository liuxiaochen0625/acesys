package com.ascent.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ascent.dao.UsrDAO;
import com.ascent.po.Usr;
import com.ascent.service.UsrService;

public class UsrServiceImpl implements UsrService {

	private UsrDAO usrDAO;
	
	public void setUsrDAO(UsrDAO usrDAO) {
		this.usrDAO = usrDAO;
	}
	
	public Usr saveUsr(Usr usr) {
		return usrDAO.saveUsr(usr);
	}
	public Usr findByUserName(String username) {
		return usrDAO.findByUserName(username);
	}
	public Usr checkUsr(String username, String password) {
		return usrDAO.checkUsr(username, password);
	}

	public List findAll() {
		return usrDAO.findAll();
	}

	public ArrayList getData(String sql, int firstRow, int maxRow) {
		return usrDAO.getData(sql, firstRow, maxRow);
	}

	public int getTotalRows() {
		return usrDAO.getTotalRows();
	}

	public boolean deleteUsr(String uid) {
		return usrDAO.deleteUsr(uid);
	}

	public Usr findById(String uid) {
		return usrDAO.findById(uid);
	}

	public boolean updateUsr(Usr usr) {
		return usrDAO.updateUsr(usr);
	}
	
}
