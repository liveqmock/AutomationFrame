/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.utils <br>
 * 文件名：CookieUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午1:34:18<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 
 * 类名称：CookieUtils <br>
 * 类描述：Cookie 工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午1:34:18 <br>
 * 修改备注：TODO <br>
 * 
 */
public class CookieUtils {

	protected static final Logger logger = Logger.getLogger(CookieUtils.class);

	/**
	 * 得到Cookie的值, 不编码
	 * 
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request,
			String cookieName) {
		return getCookieValue(request, cookieName, false);
	}

	/**
	 * 方法：getCookieValue <br>
	 * 描述：得到Cookie的值 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:36:12 <br>
	 * 
	 * @param request
	 * @param cookieName
	 * @param isDecoder
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request,
			String cookieName, boolean isDecoder) {
		Cookie cookieList[] = request.getCookies();
		if (cookieList == null || cookieName == null)
			return null;
		String retValue = null;
		try {
			for (int i = 0; i < cookieList.length; i++) {
				if (cookieList[i].getName().equals(cookieName)) {
					if (isDecoder) {
						retValue = URLDecoder.decode(cookieList[i].getValue(),
								"utf-8");
					} else {
						retValue = cookieList[i].getValue();
					}
					break;
				}
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("Cookie Decode Error.", e);
		}
		return retValue;
	}

	/**
	 * 方法：getCookieValue <br>
	 * 描述：得到Cookie的值 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:36:22 <br>
	 * 
	 * @param request
	 * @param cookieName
	 * @param encodeString
	 * @return
	 */
	public static String getCookieValue(HttpServletRequest request,
			String cookieName, String encodeString) {
		Cookie cookieList[] = request.getCookies();
		if (cookieList == null || cookieName == null)
			return null;
		String retValue = null;
		try {
			for (int i = 0; i < cookieList.length; i++) {
				if (cookieList[i].getName().equals(cookieName)) {

					retValue = URLDecoder.decode(cookieList[i].getValue(),
							encodeString);

					break;
				}
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("Cookie Decode Error.", e);
		}
		return retValue;
	}

	/**
	 * 方法：setCookie <br>
	 * 描述：设置Cookie的值 不设置生效时间默认浏览器关闭即失效,也不编码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:36:30 <br>
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 */
	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName, String cookieValue) {
		setCookie(request, response, cookieName, cookieValue, -1);
	}

	/**
	 * 方法：setCookie <br>
	 * 描述：设置Cookie的值 在指定时间内生效,但不编码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:36:38 <br>
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param cookieMaxage
	 */
	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName,
			String cookieValue, int cookieMaxage) {
		setCookie(request, response, cookieName, cookieValue, cookieMaxage,
				false);
	}

	/**
	 * 方法：setCookie <br>
	 * 描述：设置Cookie的值 不设置生效时间,但编码 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:36:49 <br>
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param isEncode
	 */
	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName,
			String cookieValue, boolean isEncode) {
		setCookie(request, response, cookieName, cookieValue, -1, isEncode);
	}

	/**
	 * 方法：setCookie <br>
	 * 描述：设置Cookie的值 在指定时间内生效, 编码参数 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:36:58 <br>
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param cookieMaxage
	 * @param isEncode
	 */
	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName,
			String cookieValue, int cookieMaxage, boolean isEncode) {
		doSetCookie(request, response, cookieName, cookieValue, cookieMaxage,
				isEncode);
	}

	/**
	 * 方法：setCookie <br>
	 * 描述：设置Cookie的值 在指定时间内生效, 编码参数(指定编码) <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:37:05 <br>
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param cookieMaxage
	 * @param encodeString
	 */
	public static void setCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName,
			String cookieValue, int cookieMaxage, String encodeString) {
		doSetCookie(request, response, cookieName, cookieValue, cookieMaxage,
				encodeString);
	}

	/**
	 * 方法：deleteCookie <br>
	 * 描述：删除Cookie带cookie域名 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:37:12 <br>
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 */
	public static void deleteCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName) {
		doSetCookie(request, response, cookieName, "", -1, false);
	}

	/**
	 * 方法：doSetCookie <br>
	 * 描述：设置Cookie的值，并使其在指定时间内生效 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:37:19 <br>
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param cookieMaxage
	 *            cookie生效的最大秒数
	 * @param isEncode
	 */
	private static final void doSetCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName,
			String cookieValue, int cookieMaxage, boolean isEncode) {
		try {
			if (cookieValue == null) {
				cookieValue = "";
			} else if (isEncode) {
				cookieValue = URLEncoder.encode(cookieValue, "utf-8");
			}
			Cookie cookie = new Cookie(cookieName, cookieValue);
			if (cookieMaxage > 0)
				cookie.setMaxAge(cookieMaxage);
			if (null != request)// 设置域名的cookie
				cookie.setDomain(getDomainName(request));
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (Exception e) {
			logger.error("Cookie Encode Error.", e);
		}
	}

	/**
	 * 方法：doSetCookie <br>
	 * 描述： 设置Cookie的值，并使其在指定时间内生效 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:37:35 <br>
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 * @param cookieMaxage
	 *            cookie生效的最大秒数
	 * @param encodeString
	 */
	private static final void doSetCookie(HttpServletRequest request,
			HttpServletResponse response, String cookieName,
			String cookieValue, int cookieMaxage, String encodeString) {
		try {
			if (cookieValue == null) {
				cookieValue = "";
			} else {
				cookieValue = URLEncoder.encode(cookieValue, encodeString);
			}
			Cookie cookie = new Cookie(cookieName, cookieValue);
			if (cookieMaxage > 0)
				cookie.setMaxAge(cookieMaxage);
			if (null != request)// 设置域名的cookie
				cookie.setDomain(getDomainName(request));
			cookie.setPath("/");
			response.addCookie(cookie);
		} catch (Exception e) {
			logger.error("Cookie Encode Error.", e);
		}
	}

	/**
	 * 方法：getDomainName <br>
	 * 描述：得到cookie的域名 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:37:51 <br>
	 * 
	 * @param request
	 * @return
	 */
	private static final String getDomainName(HttpServletRequest request) {
		String domainName = null;

		String serverName = request.getRequestURL().toString();
		if (serverName == null || serverName.equals("")) {
			domainName = "";
		} else {
			serverName = serverName.toLowerCase();
			serverName = serverName.substring(7);
			final int end = serverName.indexOf("/");
			serverName = serverName.substring(0, end);
			final String[] domains = serverName.split("\\.");
			int len = domains.length;
			if (len > 3) {
				// www.xxx.com.cn
				domainName = "." + domains[len - 3] + "." + domains[len - 2]
						+ "." + domains[len - 1];
			} else if (len <= 3 && len > 1) {
				// xxx.com or xxx.cn
				domainName = "." + domains[len - 2] + "." + domains[len - 1];
			} else {
				domainName = serverName;
			}
		}

		if (domainName != null && domainName.indexOf(":") > 0) {
			String[] ary = domainName.split("\\:");
			domainName = ary[0];
		}
		return domainName;
	}

}
