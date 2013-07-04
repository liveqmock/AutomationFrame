/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.utils <br>
 * 文件名：URLUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午1:57:24<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 类名称：URLUtils <br>
 * 类描述：链接工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午1:57:24 <br>
 * 修改备注：TODO <br>
 * 
 */
public class URLUtils {

	private static ResourceBundle res = ResourceBundle.getBundle("urls");
	
	private static Map<String, String> urlsMap = null;

	/**
	 * 方法：getUrlMap <br>
	 * 描述：获取urlMap <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:57:39 <br>
	 * 
	 * @return
	 */
	public static Map<String, String> getUrlMap() {
		if (urlsMap != null && !urlsMap.isEmpty()) {
			return urlsMap;
		}
		urlsMap = new HashMap<String, String>();
		Enumeration e = res.getKeys();
		while (e.hasMoreElements()) {
			String key = e.nextElement().toString();
			String value = get(key);
			urlsMap.put(key, value);
			System.out.println(key + "---" + value);
		}
		return urlsMap;
	}

	/**
	 * 方法：get <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:57:49 <br>
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		return res.getString(key);
	}

	/**
	 * 方法：getReqUri <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:57:52 <br>
	 * 
	 * @param reqUrl
	 * @return
	 */
	public static String getReqUri(String reqUrl) {
		try {
			URL url = new URL(reqUrl);
			// System.out.println("getAuthority = "+url.getAuthority());
			// System.out.println("getDefaultPort = "+url.getDefaultPort());
			// System.out.println("getFile = "+url.getFile());
			// System.out.println("getHost"+ " = "+url.getHost());
			// System.out.println("getPath"+ " = "+url.getPath());
			// System.out.println("getPort"+ " = "+url.getPort());
			// System.out.println("getProtocol"+ " = "+url.getProtocol());
			// System.out.println("getQuery"+ " = "+url.getQuery());
			// System.out.println("getRef"+ " = "+url.getRef());
			// System.out.println("getUserInfo"+ " = "+url.getUserInfo());
			return url.getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 方法：getBtnAccessUrls <br>
	 * 描述：组装按钮下URL <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:57:55 <br>
	 * 
	 * @param menuUrl
	 * @param actionUrls
	 * @param accessUrls
	 */
	public static void getBtnAccessUrls(String menuUrl, String actionUrls,
			List<String> accessUrls) {
		if (menuUrl == null || actionUrls == null || accessUrls == null) {
			return;
		}
		String url = "save.do| action.do |/user/manger/abcd.do";
		String[] actions = StringUtils.split(actionUrls, "|");
		String menuUri = StringUtils.substringBeforeLast(menuUrl, "/");
		for (String action : actions) {
			action = StringUtils.trim(action);
			if (StringUtils.startsWith(action, "/"))
				accessUrls.add(action);
			else
				accessUrls.add(menuUri + "/" + action);
		}
	}

	/**
	 * 方法：main <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:58:04 <br>
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// String requrl = "http://127.0.0.1:8080/ms/sysMenu/menu.shtml";
		// requrl = "https://127.0.0.1:8080/ms/sysMenu/menu.shtml?A=1&B=2#111";
		// String uri = getReqUri(requrl);
		// System.out.println(uri);
		// System.out.println(StringUtils.remove(uri, "/ms/"));
		// System.err.println(getReqUri(requrl));\
		String menu = "/sysMneu/dataList.do";
		String url = "save.do| action.do |/user/manger/abcd.do";
		String[] actions = StringUtils.split(url, "|");
		String menuUri = StringUtils.substringBeforeLast(menu, "/");
		for (String action : actions) {
			action = StringUtils.trim(action);
			if (StringUtils.startsWith(action, "/"))
				System.out.println(action);
			else
				System.out.println(menuUri + "/" + action);
		}
	}

}
