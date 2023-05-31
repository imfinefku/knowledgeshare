package com.xuezhabiji.bean;

import java.io.Serializable;

/**
 * 试卷主表
 * 
 * @author xuduo
 *
 */
public class Exampaper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4766846999389022146L;

	public static final int SCORE = 100;

	private String id;
	private String title;
	private int score;
	private int status;
	private long addtime;
	private long updatetime;
	private String level;

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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}
