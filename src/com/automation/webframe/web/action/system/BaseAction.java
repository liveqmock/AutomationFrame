/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.action.system <br>
 * 文件名：BaseAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午2:20:50<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.action.system;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.automation.webframe.utils.HtmlUtils;
import com.automation.webframe.utils.URLUtils;
import com.automation.webframe.web.eidt.MyEditor;

/**
 * 
 * 类名称：BaseAction <br>
 * 类描述：基础Action <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午2:20:50 <br>
 * 修改备注：TODO <br>
 * 
 */
public class BaseAction {

	public final static String SUCCESS = "success";

	public final static String MSG = "msg";

	public final static String DATA = "data";

	public final static String LOGOUT_FLAG = "logoutFlag";

	/**
	 * 方法：initBinder <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:21:32 <br>
	 * 
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		binder.registerCustomEditor(int.class, new MyEditor());
	}

	/**
	 * 方法：getIpAddr <br>
	 * 描述：获取IP地址 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:21:39 <br>
	 * 
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 方法：getRootMap <br>
	 * 描述：所有ActionMap 统一从这里获取 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:21:50 <br>
	 * 
	 * @return
	 */
	public Map<String, Object> getRootMap() {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		// 添加url到 Map中
		rootMap.putAll(URLUtils.getUrlMap());
		return rootMap;
	}

	/**
	 * 方法：forword <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:22:08 <br>
	 * 
	 * @param viewName
	 * @param context
	 * @return
	 */
	public ModelAndView forword(String viewName, Map context) {
		return new ModelAndView(viewName, context);
	}

	/**
	 * 方法：error <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:22:11 <br>
	 * 
	 * @param errMsg
	 * @return
	 */
	public ModelAndView error(String errMsg) {
		return new ModelAndView("error");
	}

	/**
	 * 方法：sendSuccessMessage <br>
	 * 描述：提示成功信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:22:21 <br>
	 * 
	 * @param response
	 * @param message
	 */
	public void sendSuccessMessage(HttpServletResponse response, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, true);
		result.put(MSG, message);
		HtmlUtils.writerJson(response, result);
	}

	/**
	 * 方法：sendFailureMessage <br>
	 * 描述：提示失败信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:22:52 <br>
	 * 
	 * @param response
	 * @param message
	 */
	public void sendFailureMessage(HttpServletResponse response, String message) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(SUCCESS, false);
		result.put(MSG, message);
		HtmlUtils.writerJson(response, result);
	}
}
