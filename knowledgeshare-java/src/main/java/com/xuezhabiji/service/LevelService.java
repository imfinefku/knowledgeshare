package com.xuezhabiji.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuezhabiji.bean.Level;
import com.xuezhabiji.dao.LevelDao;

@Service
public class LevelService {

	@Autowired
	private LevelDao dao;
	
	public List<Level> getPage(Map dataMap) {
		return dao.getPage(dataMap);
	}

	public int getPageCount(Map dataMap) {
		return dao.getPageCount(dataMap);
	}
	
	public List<Level> getAll() {
		return dao.getAll();
	}
}
