package com.xuezhabiji.bean;

import java.io.Serializable;

/**
 * 试题
 * 
 * @author xuduo
 *
 */
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5291536051876902414L;

	public static final String DANXUAN = "单选";
	public static final String JIANDA = "简答";
	public static final int DANXUAN_SCORE = 3;
	public static final int JIANDA_SCORE = 20;

	private String id;
	private String title;
	private String type;
	private String questiontypetitle;
	private String questiontypeid;
	private String image;
	private String a;
	private String b;
	private String c;
	private String d;
	private String answer;
	private String analysis;
	private int score;
	private long addtime;
	private long updatetime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuestiontypetitle() {
		return questiontypetitle;
	}

	public void setQuestiontypetitle(String questiontypetitle) {
		this.questiontypetitle = questiontypetitle;
	}

	public String getQuestiontypeid() {
		return questiontypeid;
	}

	public void setQuestiontypeid(String questiontypeid) {
		this.questiontypeid = questiontypeid;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getScore() {
		return score;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public long getAddtime() {
		return addtime;
	}

	public void setAddtime(long addtime) {
		this.addtime = addtime;
	}

	public long getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(long updatetime) {
		this.updatetime = updatetime;
	}
}
