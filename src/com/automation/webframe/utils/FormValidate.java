/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.utils <br>
 * 文件名：FormValidate.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午1:38:24<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.automation.exception.ServiceException;

/**
 * 
 * 类名称：FormValidate <br>
 * 类描述：参数验证 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午1:38:24 <br>
 * 修改备注：TODO <br>
 * 
 */
public class FormValidate {

	/**
	 * 方法：validNull <br>
	 * 描述：参数验证 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:38:51 <br>
	 * 
	 * @param value
	 * @param msg
	 * @throws ServiceException
	 */
	public static void validNull(String value, String msg)
			throws ServiceException {
		if (StringUtils.isBlank(value)) {
			throw new ServiceException(msg);
		}
	}

	/**
	 * 方法：validLen <br>
	 * 描述：判断字符串长度 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:39:02 <br>
	 * 
	 * @param value
	 * @param minLen
	 * @param maxLen
	 * @param msg
	 * @throws ServiceException
	 */
	public static void validLen(String value, Integer minLen, Integer maxLen,
			String msg) throws ServiceException {
		int len = StringUtils.isNotBlank(value) ? value.length() : 0;
		if (len < minLen || len > maxLen) {
			throw new ServiceException(msg);
		}
	}

	/**
	 * 方法：validNumber <br>
	 * 描述：验证是否数字 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:39:14 <br>
	 * 
	 * @param value
	 * @param msg
	 * @throws ServiceException
	 */
	public static void validNumber(String value, String msg)
			throws ServiceException {
		if (!NumberUtils.isNumber(value)) {
			throw new ServiceException(msg);
		}
	}

	/**
	 * 方法：validInt <br>
	 * 描述：验证是否int 数字 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:39:25 <br>
	 * 
	 * @param value
	 * @param msg
	 * @throws ServiceException
	 */
	public static void validInt(String value, String msg)
			throws ServiceException {
		try {
			Integer.parseInt(value);
		} catch (Exception e) {
			throw new ServiceException(msg);
		}
	}

	/**
	 * 方法：validFloat <br>
	 * 描述：验证是否Float 数字 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:39:32 <br>
	 * 
	 * @param value
	 * @param msg
	 * @throws ServiceException
	 */
	public static void validFloat(String value, String msg)
			throws ServiceException {
		try {
			Float.parseFloat(value);
		} catch (Exception e) {
			throw new ServiceException(msg);
		}
	}

}
