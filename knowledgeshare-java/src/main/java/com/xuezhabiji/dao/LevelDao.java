package com.xuezhabiji.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xuezhabiji.bean.Level;

@Mapper
public interface LevelDao {
	
	public List<Level> getPage(Map dataMap);
	
	public int getPageCount(Map dataMap);
	
	public List<Level> getAll();
}
