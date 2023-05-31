package com.xuezhabiji.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.xuezhabiji.service.KnowledgeService;
import com.xuezhabiji.service.QuestionService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuezhabiji.bean.Knowledge;
import com.xuezhabiji.bean.Problem;
import com.xuezhabiji.bean.Question;
import com.xuezhabiji.bean.QuestionType;
import com.xuezhabiji.common.CommonCache;
import com.xuezhabiji.common.CommonResult;
import com.xuezhabiji.service.ExampaperService;
import com.xuezhabiji.service.ProblemService;

/**
 * 对外暴露接口
 * 
 * @author xuduo
 *
 */
@RestController
@RequestMapping("open")
public class OpenController {

	@Autowired
	private ProblemService problemService;

	@Autowired
	private ExampaperService exampaperService;

	@Autowired
	private CommonCache cache;

	@Autowired
	private KnowledgeService knowledgeService;

	@Autowired
	private QuestionService questionService;

	/**
	 * 获取所有的试题知识点类型
	 * 
	 * @return
	 */
	@GetMapping("/getAllQuestionType")
	public CommonResult getAllQuestionType() {
		cache.initAll();
		// 从缓存中获取知识点类型
		List<QuestionType> rtnList = cache.questionTypeList;
		return CommonResult.success(rtnList);
	}

	/**
	 * 根据试题知识点类型id获取所有该类型的知识点
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getKnowledgeByQuestionTypeId/{id}")
	public CommonResult getKnowledgeByQuestionTypeId(@PathVariable String id) {
		// 从缓存中根据知识点类型获取知识点
		List<Knowledge> rtnList = cache.typeKnowledgeMap.get(id);
		return CommonResult.success(rtnList);
	}
	
	/**
	 * 根据试题知识点类型id获取所有该类型的知识点
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getAllKnowledge")
	public CommonResult getAllKnowledge() {
		return CommonResult.success(cache.typeKnowledgeMap);
	}

	/**
	 * 根据知识点id获取所有该类型的知识点
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getKnowledgeById/{id}")
	public CommonResult getKnowledgeById(@PathVariable String id) {
		// 从缓存中根据知识点id获取知识点信息
		Knowledge rtn = cache.knowledgeMap.get(id);
		return CommonResult.success(rtn);
	}
	
	/**
	 * 根据知识点id获取所有该类型的知识点
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getAllKnowledgeContent")
	public CommonResult getAllKnowledgeContent() {
		return CommonResult.success(cache.knowledgeMap);
	}

	/**
	 * 根据知识点id获取所有该类型的知识点
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/getAllKnowledgeContent2")
	public CommonResult getAllKnowledgeContent2() {
		return CommonResult.success(knowledgeService.getAll());
	}

	/**
	 * 获取所有的试卷
	 * 
	 * @return
	 */
	@GetMapping("/getAllExampaper")
	public CommonResult getAllExampaper() {
		// 从缓存中获取试卷
		List<Map> rtnList = cache.levelExampaperList;
		return CommonResult.success(rtnList);
	}

	/**
	 * 根据试卷id获取该试卷的题目
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/getExampaperSubById/{id}")
	public CommonResult getExampaperSubById(@PathVariable String id) {
		List<Question> rtnList = exampaperService.getExampaperSubById(id);
		return CommonResult.success(rtnList);
	}

	/**
	 * 综合刷题
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/zongheshuati")
	public CommonResult zongheshuati() {
		List<Question> temptList = questionService.getAll();
		List<Question> tempList = new ArrayList<>();
		for (Question question : temptList){
			if (question.getType().equals("单选")){
				tempList.add(question);
			}
		}
		List<Question> rtnList = new ArrayList<Question>();
		if (tempList.size()<=20){
			for (int i=0;i<tempList.size();i++){
				int index = (int)(Math.random()*(tempList.size()-1));
				rtnList.add(tempList.get(index));
				tempList.remove(index);
			}
		}else{
			for (int i=0;i<20;i++){
				int index = (int)(Math.random()*(tempList.size()-1));
				rtnList.add(tempList.get(index));
				tempList.remove(index);
			}
		}
		return CommonResult.success(rtnList);
	}

}
