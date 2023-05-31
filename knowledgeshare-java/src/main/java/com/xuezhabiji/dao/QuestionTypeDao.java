package com.xuezhabiji.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xuezhabiji.bean.QuestionType;

@Mapper
public interface QuestionTypeDao {

	public List<QuestionType> getAll();

	public List<QuestionType> getPage(Map dataMap);

	public int getPageCount(Map dataMap);
	
	public List<QuestionType> getAllAndCount();
}
