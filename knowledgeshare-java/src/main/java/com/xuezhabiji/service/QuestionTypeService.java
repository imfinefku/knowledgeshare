package com.xuezhabiji.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuezhabiji.bean.QuestionType;
import com.xuezhabiji.dao.QuestionTypeDao;

/**
 * 试题知识点service
 * 
 * @author xuduo
 *
 */
@Service
public class QuestionTypeService {

	@Autowired
	private QuestionTypeDao dao;

	public List<QuestionType> getAll() {
		return dao.getAll();
	}

	public List<QuestionType> getPage(Map dataMap) {
		return dao.getPage(dataMap);
	}

	public int getPageCount(Map dataMap) {
		return dao.getPageCount(dataMap);
	}
	
	public List<QuestionType> getAllAndCount(){
		return dao.getAllAndCount();
	}
}
