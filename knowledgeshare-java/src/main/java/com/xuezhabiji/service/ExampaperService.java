package com.xuezhabiji.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuezhabiji.bean.Exampaper;
import com.xuezhabiji.bean.ExampaperQuestion;
import com.xuezhabiji.bean.Question;
import com.xuezhabiji.dao.ExampaperDao;

@Service
public class ExampaperService {
	
	@Autowired
	private ExampaperDao dao;
	
	public List<Exampaper> getPage(Map dataMap) {
		return dao.getPage(dataMap);
	}

	public int getPageCount(Map dataMap) {
		return dao.getPageCount(dataMap);
	}
	
	public List<ExampaperQuestion> getSubByExampaperid(String exampaperid){
		return dao.getSubByExampaperid(exampaperid);
	}

	public List<Map> initLevelExampaperList(){
		return dao.initLevelExampaperList();
	}
	
	public List<Question> getExampaperSubById(String exampaperid){
		return dao.getExampaperSubById(exampaperid);
	}
}
