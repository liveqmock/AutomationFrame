/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.interceptor <br>
 * 文件名：AuthInterceptor.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午3:00:12<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.automation.webframe.annotation.Auth;
import com.automation.webframe.entity.SysUser;
import com.automation.webframe.utils.HtmlUtils;
import com.automation.webframe.utils.SessionUtils;
import com.automation.webframe.web.action.system.BaseAction;

/**
 * 
 * 类名称：AuthInterceptor <br>
 * 类描述：安全拦截器 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午3:00:12 <br>
 * 修改备注：TODO <br>
 * 
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	/**  */
	private final static Logger logger = Logger
			.getLogger(AuthInterceptor.class);

	/**
	 * 方法：preHandle <br>
	 * 描述：TODO <br>
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		Auth auth = method.getMethod().getAnnotation(Auth.class);
		// //验证登陆超时问题 auth = null，默认验证
		if (auth == null || auth.verifyLogin()) {
			String baseUri = request.getContextPath();
			String path = request.getServletPath();
			SysUser user = SessionUtils.getUser(request);

			if (user == null) {
				if (path.endsWith(".shtml")) {
					response.setStatus(response.SC_GATEWAY_TIMEOUT);
					response.sendRedirect(baseUri + "/login.shtml");
					return false;
				} else {
					response.setStatus(response.SC_GATEWAY_TIMEOUT);
					Map<String, Object> result = new HashMap<String, Object>();
					result.put(BaseAction.SUCCESS, false);
					result.put(BaseAction.LOGOUT_FLAG, true);// 登录标记 true 退出
					result.put(BaseAction.MSG, "登录超时.");
					HtmlUtils.writerJson(response, result);
					return false;
				}
			}
		}
		// 验证URL权限
		if (auth == null || auth.verifyURL()) {
			// 判断是否超级管理员
			if (!SessionUtils.isAdmin(request)) {
				String menuUrl = StringUtils.remove(request.getRequestURI(),
						request.getContextPath());
				;
				if (!SessionUtils.isAccessUrl(request,
						StringUtils.trim(menuUrl))) {
					// 日志记录
					String userMail = SessionUtils.getUser(request).getEmail();
					String msg = "URL权限验证不通过:[url=" + menuUrl + "][email ="
							+ userMail + "]";
					logger.error(msg);

					response.setStatus(response.SC_FORBIDDEN);
					Map<String, Object> result = new HashMap<String, Object>();
					result.put(BaseAction.SUCCESS, false);
					result.put(BaseAction.MSG, "没有权限访问,请联系管理员.");
					HtmlUtils.writerJson(response, result);
					return false;
				}
			}
		}
		return super.preHandle(request, response, handler);
	}

}
