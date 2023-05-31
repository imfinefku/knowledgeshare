package com.xuezhabiji.bean;

import java.io.Serializable;

/**
 * 知识点
 * @author xuduo
 *
 */
public class Knowledge implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4471379519608999103L;
	
	private String id;
	private String title;
	private String questiontypetitle;
	private String questiontypeid;
	private String image;
	private String content;
	private long addtime;
	private long updatetime;
	
	private String lastKnowledge;
	private String nextKnowledge;

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getLastKnowledge() {
		return lastKnowledge;
	}

	public void setLastKnowledge(String lastKnowledge) {
		this.lastKnowledge = lastKnowledge;
	}

	public String getNextKnowledge() {
		return nextKnowledge;
	}

	public void setNextKnowledge(String nextKnowledge) {
		this.nextKnowledge = nextKnowledge;
	}
}
