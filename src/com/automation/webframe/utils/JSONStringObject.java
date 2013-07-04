/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.utils <br>
 * 文件名：JSONStringObject.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午1:42:32<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.utils;

import org.json.JSONString;

/**
 * 
 * 类名称：JSONStringObject <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午1:42:32 <br>
 * 修改备注：TODO <br>
 * 
 */
public class JSONStringObject implements JSONString {

	/**  */
	private String jsonString = null;

	/**
	 * 标题：构造器 <br>
	 * 描述：JSON字符对象 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:43:32 <br>
	 * 
	 * @param jsonString
	 */
	public JSONStringObject(String jsonString) {
		this.jsonString = jsonString;
	}

	/**
	 * 方法：toJSONString <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see org.json.JSONString#toJSONString()
	 */
	@Override
	public String toJSONString() {
		return jsonString;
	}

	/**
	 * 方法：toString <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return jsonString;
	}

}
