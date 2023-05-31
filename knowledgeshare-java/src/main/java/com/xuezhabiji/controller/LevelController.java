package com.xuezhabiji.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xuezhabiji.bean.Level;
import com.xuezhabiji.common.CommonResult;
import com.xuezhabiji.service.LevelService;

import cn.hutool.core.lang.UUID;

/**
 * 等级管理
 * 
 * @author xuduo
 *
 */
@RestController
@RequestMapping("level")
public class LevelController {

	@Autowired
	private LevelService service;

	/**
	 * 获取等级分页数据
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping("/getPage")
	public CommonResult getPage(HttpServletRequest request, HttpServletResponse response, @RequestParam int page,
			@RequestParam int limit) {
		int start = limit * page - limit;
		Map dataMap = new HashMap();
		dataMap.put("start", start);
		dataMap.put("limit", limit);
		List<Level> rtnList = service.getPage(dataMap);
		int count = service.getPageCount(dataMap);
		Map rtnMap = new HashMap();
		rtnMap.put("data", rtnList);
		rtnMap.put("count", count);
		rtnMap.put("code", 0);
		return CommonResult.success(rtnMap);
	}

	/**
	 * 获取所有级别数据
	 * 
	 * @return
	 */
	@GetMapping("/getAll")
	public CommonResult getAll() {
		List<Level> rtnList = service.getAll();
		return CommonResult.success(rtnList);
	}
}
