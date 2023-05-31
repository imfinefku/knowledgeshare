package com.xuezhabiji.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 登陆过滤器
 * 
 * @author xuduo
 *
 */
@Component
@WebFilter(urlPatterns = "/*", filterName = "LoginFilter")
public class LoginFilter implements Filter {

	private static final Logger log = LoggerFactory.getLogger(LoginFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getRequestURI();
		if (path.equals("/") || path.equals("/index.html") || path.equals("/lo.html") || path.equals("/manager.jpg")
				|| path.startsWith("/view/") || path.startsWith("/img/") || path.startsWith("/js/")
				|| path.startsWith("/layui/") || path.startsWith("/open/") || path.equals("/manager/login") || path.startsWith("/showImage/")
				|| path.startsWith("/static/img/")) {
			chain.doFilter(req, resp);
		} else {
			Object curUser = req.getSession().getAttribute("user");
			if (curUser != null) {
				chain.doFilter(req, resp);
			} else {
				resp.sendRedirect("/index.html");
			}
		}

	}

	@Override
	public void destroy() {

	}

}
