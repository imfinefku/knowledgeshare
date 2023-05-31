package com.xuezhabiji.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.xuezhabiji.bean.Knowledge;
import com.xuezhabiji.bean.QuestionType;
import com.xuezhabiji.service.ExampaperService;
import com.xuezhabiji.service.KnowledgeService;
import com.xuezhabiji.service.QuestionTypeService;

/**
 * 公共缓存
 * 
 * @author xuduo
 *
 */
@Component
public class CommonCache implements CommandLineRunner {

	/**
	 * 知识点类型list缓存
	 */
	public static List<QuestionType> questionTypeList;

	/**
	 * 知识点类型和知识点map
	 */
	public static Map<String, List<Knowledge>> typeKnowledgeMap = new HashMap<String, List<Knowledge>>();

	/**
	 * 知识点详细内容map
	 */
	public static Map<String, Knowledge> knowledgeMap = new HashMap<String, Knowledge>();

	/**
	 * 等级试卷list
	 */
	public static List<Map> levelExampaperList = new ArrayList<Map>();

	@Autowired
	private QuestionTypeService questionTypeService;

	@Autowired
	private KnowledgeService knowledgeService;

	@Autowired
	private ExampaperService exampaperService;

	@Override
	public void run(String... args) throws Exception {
		initAll();
	}

	public void initAll() {
		initQuestionType();
		initTypeKnowledgeMap();
		initKnowledgeMap();
		initLevelExampaperList();
		System.out.println("============初始化缓存完成============");
	}

	/**
	 * 初始化知识点类型
	 */
	private void initQuestionType() {
		questionTypeList = questionTypeService.getAllAndCount();
	}

	/**
	 * 初始化知识点类型和知识点map
	 */
	private void initTypeKnowledgeMap() {
		if (questionTypeList != null && questionTypeList.size() > 0) {
			for (QuestionType questionType : questionTypeList) {
				List<Knowledge> dataList = knowledgeService.getByQuestiontypeid(questionType.getId());
				typeKnowledgeMap.put(questionType.getId(), dataList);
			}
		}
	}

	/**
	 * 初始化知识点map
	 */
	private void initKnowledgeMap() {
		List<Knowledge> dataList = knowledgeService.getAll();
		for (int i = 0; i < dataList.size(); i++) {
			Knowledge knowledge = dataList.get(i);
			Knowledge lastKnowledge = null;
			Knowledge nextKnowledge = null;
			if (i != 0) {
				lastKnowledge = dataList.get(i - 1);
			}
			if (i != (dataList.size() - 1)) {
				nextKnowledge = dataList.get(i + 1);
			}
			if (lastKnowledge != null && lastKnowledge.getQuestiontypeid().equals(knowledge.getQuestiontypeid())) {
				knowledge.setLastKnowledge(lastKnowledge.getId());
			}
			if (nextKnowledge != null && nextKnowledge.getQuestiontypeid().equals(knowledge.getQuestiontypeid())) {
				knowledge.setNextKnowledge(nextKnowledge.getId());
			}
			knowledgeMap.put(knowledge.getId(), knowledge);
		}
	}

	private void initLevelExampaperList() {
		levelExampaperList = exampaperService.initLevelExampaperList();
	}

}
