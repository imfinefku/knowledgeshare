package com.xuezhabiji.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuezhabiji.bean.Problem;
import com.xuezhabiji.dao.ProblemDao;

@Service
public class ProblemService {

	@Autowired
	private ProblemDao dao;

	public List<Problem> getPage(Map dataMap) {
		return dao.getPage(dataMap);
	}

	public int getPageCount(Map dataMap) {
		return dao.getPageCount(dataMap);
	}
}
