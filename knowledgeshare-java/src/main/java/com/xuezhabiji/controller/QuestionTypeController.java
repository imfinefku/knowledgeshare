package com.xuezhabiji.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.xuezhabiji.bean.QuestionType;
import com.xuezhabiji.common.CommonResult;
import com.xuezhabiji.service.QuestionTypeService;

/**
 * 试题知识点类别controller
 * 
 * @author xuduo
 *
 */
@RestController
@RequestMapping("questionType")
public class QuestionTypeController {

	@Autowired
	private QuestionTypeService service;

	/**
	 * 分页获取试题知识点类型
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
		List<QuestionType> rtnList = service.getPage(dataMap);
		int count = service.getPageCount(dataMap);
		Map rtnMap = new HashMap();
		rtnMap.put("data", rtnList);
		rtnMap.put("count", count);
		rtnMap.put("code", 0);
		return CommonResult.success(rtnMap);
	}
	
	/**
	 * 获取所有的知识点类型
	 * @return
	 */
	@GetMapping("/getAll")
	public CommonResult getAll() {
		List<QuestionType> rtnList=service.getAll();
		return CommonResult.success(rtnList);
	}
}
