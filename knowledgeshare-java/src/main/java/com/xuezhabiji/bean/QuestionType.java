package com.xuezhabiji.bean;

import java.io.Serializable;

/**
 * 试题、知识点类别
 * @author xuduo
 *
 */
public class QuestionType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7362540247277224700L;
	
	private String id;
	private String title;
	private long addtime;
	private int count;

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

	public long getAddtime() {
		return addtime;
	}

	public void setAddtime(long addtime) {
		this.addtime = addtime;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
