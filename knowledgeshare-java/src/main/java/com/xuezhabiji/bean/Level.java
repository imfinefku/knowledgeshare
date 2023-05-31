package com.xuezhabiji.bean;

import java.io.Serializable;

/**
 * 等级表
 * @author xuduo
 *
 */
public class Level implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3133315640836509827L;
	
	private String id;
	
	private int code;
	
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
