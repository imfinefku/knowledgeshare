package com.xuezhabiji.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.xuezhabiji.bean.Manager;

@Mapper
public interface ManagerDao {

	public Manager login(Manager manager);
}
