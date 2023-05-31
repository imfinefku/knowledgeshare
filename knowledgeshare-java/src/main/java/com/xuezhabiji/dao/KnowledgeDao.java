package com.xuezhabiji.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xuezhabiji.bean.Knowledge;

@Mapper
public interface KnowledgeDao {
	
	public List<Knowledge> getPage(Map dataMap);
	
	public int getPageCount(Map dataMap);

	public List<Knowledge> getByQuestiontypeid(@Param("questiontypeid") String questiontypeid);
	
	public List<Knowledge> getAll();
}
