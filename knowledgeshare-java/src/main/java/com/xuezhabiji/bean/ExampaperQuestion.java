package com.xuezhabiji.bean;

import java.io.Serializable;

/**
 * 试卷子表
 * 
 * @author xuduo
 *
 */
public class ExampaperQuestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2321182830359268621L;

	private String id;
	private String exampaperid;
	private String questionid;
	private String type;
	private int orders;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExampaperid() {
		return exampaperid;
	}

	public void setExampaperid(String exampaperid) {
		this.exampaperid = exampaperid;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
