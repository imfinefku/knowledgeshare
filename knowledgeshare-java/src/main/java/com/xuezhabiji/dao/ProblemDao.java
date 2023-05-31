package com.xuezhabiji.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.xuezhabiji.bean.Problem;

@Mapper
public interface ProblemDao {

	public List<Problem> getPage(Map dataMap);

	public int getPageCount(Map dataMap);
}
