package com.xuezhabiji.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuezhabiji.bean.Manager;
import com.xuezhabiji.dao.ManagerDao;

@Service
public class ManagerService {

	@Autowired
	private ManagerDao dao;

	public Manager login(Manager manager) {
		return dao.login(manager);
	}

}
