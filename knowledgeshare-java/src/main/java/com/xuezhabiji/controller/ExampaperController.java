package com.xuezhabiji.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xuezhabiji.bean.Exampaper;
import com.xuezhabiji.bean.ExampaperQuestion;
import com.xuezhabiji.common.CommonResult;
import com.xuezhabiji.service.ExampaperService;

import cn.hutool.core.lang.UUID;

/**
 * 试卷库controller
 * 
 * @author xuduo
 *
 */
@RestController
@RequestMapping("exampaper")
public class ExampaperController {

	@Autowired
	private ExampaperService service;

	/**
	 * 分页获取试卷库数据
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
		List<Exampaper> rtnList = service.getPage(dataMap);
		int count = service.getPageCount(dataMap);
		Map rtnMap = new HashMap();
		rtnMap.put("data", rtnList);
		rtnMap.put("count", count);
		rtnMap.put("code", 0);
		return CommonResult.success(rtnMap);
	}
	
	/**
	 * 获取试卷的子卷
	 * @param exampaperid
	 * @return
	 */
	@GetMapping("/getSubByExampaperid/{exampaperid}")
	public CommonResult getSubByExampaperid(@PathVariable String exampaperid) {
		List<ExampaperQuestion> rtnList=service.getSubByExampaperid(exampaperid);
		return CommonResult.success(rtnList);
	}
}
