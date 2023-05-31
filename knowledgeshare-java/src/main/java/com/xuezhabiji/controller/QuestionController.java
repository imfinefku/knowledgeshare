package com.xuezhabiji.controller;

import java.util.*;

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

import com.xuezhabiji.bean.Question;
import com.xuezhabiji.common.CommonResult;
import com.xuezhabiji.service.QuestionService;

import cn.hutool.core.lang.UUID;

/**
 * 试题库controller
 * 
 * @author xuduo
 *
 */
@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	private QuestionService service;

	/**
	 * 分页获取试题库数据
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
		List<Question> rtnList = service.getPage(dataMap);
		int count = service.getPageCount(dataMap);
		Map rtnMap = new HashMap();
		rtnMap.put("data", rtnList);
		rtnMap.put("count", count);
		rtnMap.put("code", 0);
		return CommonResult.success(rtnMap);
	}

	@GetMapping("/getAll")
	public CommonResult getAll(HttpServletRequest request, HttpServletResponse response) {
		List<Question> allList = service.getAll();
		List<Question> xzList = new ArrayList<Question>();
		List<Question> jdList = new ArrayList<Question>();
		Map rtnMap = new HashMap();
		rtnMap.put("xz",xzList);
		rtnMap.put("jd",jdList);
		for (Question question : allList){
			if (question.getType().equals("简答")){
				jdList.add(question);
			}else{
				xzList.add(question);
			}
		}
		return CommonResult.success(rtnMap);
	}
}
