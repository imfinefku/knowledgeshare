package com.xuezhabiji.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuezhabiji.bean.Question;
import com.xuezhabiji.dao.QuestionDao;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao dao;

	public List<Question> getPage(Map dataMap) {
		return dao.getPage(dataMap);
	}

	public int getPageCount(Map dataMap) {
		return dao.getPageCount(dataMap);
	}

	public List<Question> getAll() {
		return dao.getAll();
	}
}
