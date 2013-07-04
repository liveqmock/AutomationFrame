/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.utils <br>
 * 文件名：ObjectUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午5:45:23<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.utils;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * 类名称：ObjectUtils <br>
 * 类描述：对象工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午5:45:23 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ObjectUtils {

	/**
	 * 方法：isEmpty <br>
	 * 描述：判断集合是否为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:46:00 <br>
	 * 
	 * @param collection
	 *            集合
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection) {
		if (collection == null || collection.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isNotEmpty <br>
	 * 描述：判断集合是否不为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:46:15 <br>
	 * 
	 * @param collection
	 *            集合
	 * @return
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		if (collection != null && collection.size() >= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isEmpty <br>
	 * 描述：判断字符串是否为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:46:29 <br>
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string) {
		if (string == null || "".equals(string)) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isNotEmpty <br>
	 * 描述：判断字符串是否不为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:46:42 <br>
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNotEmpty(String string) {
		if (string != null && !"".equals(string)) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isEmpty <br>
	 * 描述：判断字符串是否为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:46:51 <br>
	 * 
	 * @param stringBuffer
	 * @return
	 */
	public static boolean isEmpty(StringBuffer stringBuffer) {
		if (stringBuffer == null || "".equals(stringBuffer)) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isNotEmpty <br>
	 * 描述：判断字符串是否不为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:47:01 <br>
	 * 
	 * @param stringBuffer
	 * @return
	 */
	public static boolean isNotEmpty(StringBuffer stringBuffer) {
		if (stringBuffer != null && !"".equals(stringBuffer)
				&& stringBuffer.length() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isEmpty <br>
	 * 描述：判断MAP是否为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:47:09 <br>
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * 方法：isNotEmpty <br>
	 * 描述：判断MAP是否不为空 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午5:47:19 <br>
	 * 
	 * @param map
	 * @return
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		if (map != null && !map.isEmpty()) {
			return true;
		}
		return false;
	}
}
