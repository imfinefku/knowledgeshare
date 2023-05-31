package com.xuezhabiji.bean;

import java.io.Serializable;

/**
 * 管理员
 * @author xuduo
 *
 */
public class Manager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7771858557417631666L;
	
	private String id;
	private String name;
	private String username;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
