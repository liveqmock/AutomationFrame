/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.utils <br>
 * 文件名：RandomUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-上午10:46:51<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.utils;

import java.util.Random;

/**
 * 
 * 类名称：RandomUtils <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 上午10:46:51 <br>
 * 修改备注：TODO <br>
 * 
 */
public class RandomUtils {

	/**
	 * 方法：getRandom <br>
	 * 描述：产生0～max的随机整数 包括0 不包括max <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:47:01 <br>
	 * 
	 * @param max
	 *            随机数的上限
	 * @return
	 */
	public static int getRandom(int max) {
		return new Random().nextInt(max);
	}

	/**
	 * 方法：getRandom <br>
	 * 描述：产生 min～max的随机整数 包括 min 但不包括 max <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:47:13 <br>
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandom(int min, int max) {
		int r = getRandom(max - min);
		return r + min;
	}

	/**
	 * 方法：getRandomLong <br>
	 * 描述：产生0～max的随机整数 包括0 不包括max <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:47:24 <br>
	 * 
	 * @param max
	 *            随机数的上限
	 * @return
	 */
	public static long getRandomLong(long max) {
		long randNum = (long) (Math.random() * max);// + minId;
		return randNum;
	}

	/**
	 * 方法：getRandomLong <br>
	 * 描述：产生 min～max的随机整数 包括 min 但不包括 max <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:47:38 <br>
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static long getRandomLong(long min, long max) {
		long r = getRandomLong(max - min);
		return r + min;
	}

	/**
	 * 方法：getSQLRandom <br>
	 * 描述：随机获取图片 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:47:45 <br>
	 * 
	 * @param num
	 * @return
	 */
	public static long getSQLRandom(Long num) {
		Long newNum = getRandomLong(num);
		String numStr = newNum + "";
		if (numStr.length() < 8) {
			return newNum;
		}
		int randLen = getRandom(8, numStr.length());
		return Long.valueOf(numStr.substring(0, randLen));
	}
}
