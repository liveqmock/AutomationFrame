/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.utils <br>
 * 文件名：SessionUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午1:50:18<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.utils;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.automation.utils.Constant.SuperAdmin;
import com.automation.webframe.entity.SysUser;

/**
 * 
 * 类名称：SessionUtils <br>
 * 类描述：Session 工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午1:50:18 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SessionUtils {

	protected static final Logger logger = Logger.getLogger(SessionUtils.class);

	private static final String SESSION_USER = "session_user";

	/** 验证码 */
	private static final String SESSION_VALIDATECODE = "session_validatecode";

	/** 系统能够访问的URL */
	private static final String SESSION_ACCESS_URLS = "session_access_urls";

	/** 系统菜单按钮 */
	private static final String SESSION_MENUBTN_MAP = "session_menubtn_map";

	/**
	 * 方法：setAttr <br>
	 * 描述：设置session的值 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:02 <br>
	 * 
	 * @param request
	 * @param key
	 * @param value
	 */
	public static void setAttr(HttpServletRequest request, String key,
			Object value) {
		request.getSession(true).setAttribute(key, value);
	}

	/**
	 * 方法：getAttr <br>
	 * 描述：获取session的值 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:08 <br>
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public static Object getAttr(HttpServletRequest request, String key) {
		return request.getSession(true).getAttribute(key);
	}

	/**
	 * 方法：removeAttr <br>
	 * 描述：删除Session值 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:16 <br>
	 * 
	 * @param request
	 * @param key
	 */
	public static void removeAttr(HttpServletRequest request, String key) {
		request.getSession(true).removeAttribute(key);
	}

	/**
	 * 方法：setUser <br>
	 * 描述：设置用户信息 到session <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:23 <br>
	 * 
	 * @param request
	 * @param user
	 */
	public static void setUser(HttpServletRequest request, SysUser user) {
		request.getSession(true).setAttribute(SESSION_USER, user);
	}

	/**
	 * 方法：getUser <br>
	 * 描述：从session中获取用户信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:32 <br>
	 * 
	 * @param request
	 * @return
	 */
	public static SysUser getUser(HttpServletRequest request) {
		return (SysUser) request.getSession(true).getAttribute(SESSION_USER);
	}

	/**
	 * 方法：getUserId <br>
	 * 描述：从session中获取用户信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:38 <br>
	 * 
	 * @param request
	 * @return
	 */
	public static Integer getUserId(HttpServletRequest request) {
		SysUser user = getUser(request);
		if (user != null) {
			return user.getId();
		}
		return null;
	}

	/**
	 * 方法：removeUser <br>
	 * 描述：从session中获取用户信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:46 <br>
	 * 
	 * @param request
	 */
	public static void removeUser(HttpServletRequest request) {
		removeAttr(request, SESSION_USER);
	}

	/**
	 * 方法：setValidateCode <br>
	 * 描述：设置验证码 到session <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:51:55 <br>
	 * 
	 * @param request
	 * @param validateCode
	 */
	public static void setValidateCode(HttpServletRequest request,
			String validateCode) {
		request.getSession(true).setAttribute(SESSION_VALIDATECODE,
				validateCode);
	}

	/**
	 * 方法：getValidateCode <br>
	 * 描述：从session中获取验证码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:52:03 <br>
	 * 
	 * @param request
	 * @return
	 */
	public static String getValidateCode(HttpServletRequest request) {
		return (String) request.getSession(true).getAttribute(
				SESSION_VALIDATECODE);
	}

	/**
	 * 方法：removeValidateCode <br>
	 * 描述：从session中获删除验证码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:52:10 <br>
	 * 
	 * @param request
	 */
	public static void removeValidateCode(HttpServletRequest request) {
		removeAttr(request, SESSION_VALIDATECODE);
	}

	/**
	 * 方法：isAdmin <br>
	 * 描述：判断当前登录用户是否超级管理员 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:52:21 <br>
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAdmin(HttpServletRequest request) {
		// 判断登录用户是否超级管理员
		SysUser user = getUser(request);
		if (user == null || user.getSuperAdmin() != SuperAdmin.YES.key) {
			return false;
		}
		return true;
	}

	/**
	 * 方法：setAccessUrl <br>
	 * 描述：判断当前登录用户是否超级管理员 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:52:32 <br>
	 * 
	 * @param request
	 * @param accessUrls
	 */
	public static void setAccessUrl(HttpServletRequest request,
			List<String> accessUrls) {
		// 判断登录用户是否超级管理员
		setAttr(request, SESSION_ACCESS_URLS, accessUrls);
	}

	/**
	 * 方法：isAccessUrl <br>
	 * 描述：判断URL是否可访问 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:52:41 <br>
	 * 
	 * @param request
	 * @param url
	 * @return
	 */
	public static boolean isAccessUrl(HttpServletRequest request, String url) {
		List<String> accessUrls = (List) getAttr(request, SESSION_ACCESS_URLS);
		if (accessUrls == null || accessUrls.isEmpty()
				|| !accessUrls.contains(url)) {
			return false;
		}
		return true;
	}

	/**
	 * 方法：setMemuBtnMap <br>
	 * 描述：设置菜单按钮 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:52:53 <br>
	 * 
	 * @param request
	 * @param btnMap
	 */
	public static void setMemuBtnMap(HttpServletRequest request,
			Map<String, List> btnMap) {
		// 判断登录用户是否超级管理员
		setAttr(request, SESSION_MENUBTN_MAP, btnMap);
	}

	/**
	 * 方法：getMemuBtnListVal <br>
	 * 描述：获取菜单按钮 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:53:04 <br>
	 * 
	 * @param request
	 * @param menuUri
	 * @return
	 */
	public static List<String> getMemuBtnListVal(HttpServletRequest request,
			String menuUri) {
		// 判断登录用户是否超级管理员
		Map btnMap = (Map) getAttr(request, SESSION_MENUBTN_MAP);
		if (btnMap == null || btnMap.isEmpty()) {
			return null;
		}
		return (List<String>) btnMap.get(menuUri);
	}

	// private static final String SESSION_ACCESS_URLS = "session_access_urls";
	// //系统能够访问的URL
	//
	//
	// private static final String SESSION_MENUBTN_MAP = "session_menubtn_map";
	// //系统菜单按钮

}
