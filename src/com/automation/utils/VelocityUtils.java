/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.utils <br>
 * 文件名：VelocityUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-上午10:52:35<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.utils;

import org.apache.velocity.VelocityContext;

/**
 * 
 * 类名称：VelocityUtils <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 上午10:52:35 <br>
 * 修改备注：TODO <br>
 * 
 */
public class VelocityUtils {

	/**
	 * 方法：getContext <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:52:48 <br>
	 * 
	 * @return
	 */
	public static VelocityContext getContext() {
		VelocityContext context = new VelocityContext();
		context.put("PathUtil", new PathUtils());
		context.put("DateUtil", new DateUtils());
		context.put("StringUtil", new StringUtils());
		context.put("basePath", PathUtils.getBasePath());
		return context;
	}

}
