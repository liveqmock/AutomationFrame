/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.exception <br>
 * 文件名：ServiceException.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-下午2:28:11<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.exception;

/**
 * 
 * 类名称：ServiceException <br>
 * 类描述：服务异常 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 下午2:28:11 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-20 下午2:28:52 <br>
	 * 
	 * @param err
	 */
	public ServiceException(String err) {
		super(err);
	}
}
