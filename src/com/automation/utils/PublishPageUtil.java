/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.utils <br>
 * 文件名：PublishPageUtil.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-上午10:46:04<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 类名称：PublishPageUtil <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 上午10:46:04 <br>
 * 修改备注：TODO <br>
 * 
 */
public class PublishPageUtil {

	static ApplicationContext context = new ClassPathXmlApplicationContext(
			new String[] { "com/wei/ssi/conf/spring/*.xml" });

	private final static String FILE_DIR_PATH = PathUtils.getRootPath();// 获取项目部署根目录
																		// 如：F:\openwork\mn606\WebRoot

	public static void main(String[] args) {
		// createIndex();
	}
}
