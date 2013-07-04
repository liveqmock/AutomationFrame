/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.interceptor <br>
 * 文件名：ExceptionInterceptor.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午3:03:50<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.interceptor;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.automation.exception.ServiceException;
import com.automation.webframe.utils.HtmlUtils;

/**
 * 
 * 类名称：ExceptionInterceptor <br>
 * 类描述：异常拦截器 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午3:03:50 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ExceptionInterceptor extends HandlerInterceptorAdapter {
	private final static Logger log = Logger
			.getLogger(ExceptionInterceptor.class);

	/**
	 * 方法：afterCompletion <br>
	 * 描述：TODO <br>
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#afterCompletion(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (ex != null) {
			String msg = "";
			if (ex instanceof ServiceException) {
				msg = ex.getMessage();
			} else if (ex instanceof NullPointerException) {
				msg = "空指针异常";
			} else if (ex instanceof IOException) {
				msg = "文件读写异常";
			} else {
				msg = ex.toString();
			}
			logger(request, handler, ex);
			response.setStatus(response.SC_SERVICE_UNAVAILABLE);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("success", false);
			result.put("msg", msg);
			HtmlUtils.writerJson(response, result);
		} else {
			super.afterCompletion(request, response, handler, ex);
		}
	}

	/**
	 * 方法：logger <br>
	 * 描述：记录日志 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午3:04:26 <br>
	 * 
	 * @param request
	 * @param handler
	 * @param ex
	 */
	public void logger(HttpServletRequest request, Object handler, Exception ex) {
		StringBuffer msg = new StringBuffer();
		msg.append("异常拦截日志");
		msg.append("[uri＝").append(request.getRequestURI()).append("]");
		Enumeration<String> enumer = request.getParameterNames();
		while (enumer.hasMoreElements()) {
			String name = (String) enumer.nextElement();
			String[] values = request.getParameterValues(name);
			msg.append("[").append(name).append("=");
			if (values != null) {
				int i = 0;
				for (String value : values) {
					i++;
					msg.append(value);
					if (i < values.length) {
						msg.append("｜");
					}

				}
			}
			msg.append("]");
		}
		log.error(msg, ex);
	}

}
