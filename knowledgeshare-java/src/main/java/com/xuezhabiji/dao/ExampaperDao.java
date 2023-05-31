package com.xuezhabiji.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xuezhabiji.bean.Exampaper;
import com.xuezhabiji.bean.ExampaperQuestion;
import com.xuezhabiji.bean.Question;

@Mapper
public interface ExampaperDao {
	public List<Exampaper> getPage(Map dataMap);
	
	public int getPageCount(Map dataMap);
	
	public List<ExampaperQuestion> getSubByExampaperid(@Param("exampaperid") String exampaperid);
	
	public List<Map> initLevelExampaperList();
	
	public List<Question> getExampaperSubById(@Param("exampaperid") String exampaperid);
}
