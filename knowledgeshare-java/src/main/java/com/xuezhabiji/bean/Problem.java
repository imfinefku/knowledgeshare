package com.xuezhabiji.bean;

import java.io.Serializable;

/**
 * 问题反馈
 * @author xuduo
 *
 */
public class Problem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7052963461098282822L;

	private String id;
	private String title;
	private String content;
	private long addtime;
	private String adduser;

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

	public String getAdduser() {
		return adduser;
	}

	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}
}
