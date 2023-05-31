package com.xuezhabiji.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuezhabiji.bean.Manager;
import com.xuezhabiji.common.CommonResult;
import com.xuezhabiji.service.ManagerService;

/**
 * 登陆controller
 * 
 * @author xuduo
 *
 */
@RestController
@RequestMapping("manager")
public class ManagerController {

	@Autowired
	private ManagerService service;

	/**
	 * 管理员登陆
	 * 
	 * @param request
	 * @param manager
	 * @return
	 */
	@PostMapping("/login")
	public CommonResult login(HttpServletRequest request, @RequestBody Manager manager) {
		if (manager.getUsername() == null || manager.getUsername().length() > 20
				|| manager.getUsername().length() == 0) {
			return CommonResult.failed("账号不能为空且长度不能超过20个字符");
		}
		if (manager.getPassword() == null || manager.getPassword().length() > 20
				|| manager.getPassword().length() == 0) {
			return CommonResult.failed("密码不能为空且长度不能超过20个字符");
		}
		Manager loginManager = service.login(manager);
		if (loginManager != null) {
			request.getSession().setAttribute("user", loginManager);
			return CommonResult.success(loginManager);
		}
		return CommonResult.failed("登陆失败，账号或密码错误");
	}

	/**
	 * 注销
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping("/logout")
	public CommonResult logout(HttpServletRequest request) {
		request.getSession().setAttribute("user", null);
		return CommonResult.success();
	}
}
