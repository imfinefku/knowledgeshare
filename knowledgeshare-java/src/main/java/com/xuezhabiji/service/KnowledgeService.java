package com.xuezhabiji.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuezhabiji.bean.Knowledge;
import com.xuezhabiji.dao.KnowledgeDao;

@Service
public class KnowledgeService {

	@Autowired
	private KnowledgeDao dao;

	public List<Knowledge> getPage(Map dataMap) {
		return dao.getPage(dataMap);
	}

	public int getPageCount(Map dataMap) {
		return dao.getPageCount(dataMap);
	}


	public List<Knowledge> getByQuestiontypeid(String questiontypeid) {
		return dao.getByQuestiontypeid(questiontypeid);
	}

	
	public List<Knowledge> getAll(){
		return dao.getAll();
	}
}
