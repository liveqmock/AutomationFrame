/**
 * 项目名：AutomationFrame <br>
 * 包名： com.automation.webframe.web.eidt <br>
 * 文件名：MyEditor.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午2:23:34<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.eidt;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

/**
 * 
 * 类名称：MyEditor <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午2:23:34 <br>
 * 修改备注：TODO <br>
 * 
 */
public class MyEditor extends PropertyEditorSupport {

	/**
	 * 方法：setAsText <br>
	 * 描述：TODO <br>
	 * 
	 * @param text
	 * @throws IllegalArgumentException
	 * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text == null || text.equals(""))
			text = "0";
		if (!StringUtils.hasText(text)) {

			setValue(null);
		} else {
			setValue(Integer.parseInt(text));// 这句话是最重要的，他的目的是通过传入参数的类型来匹配相应的databind
		}
	}

	/**
	 * 方法：getAsText <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see java.beans.PropertyEditorSupport#getAsText()
	 */
	@Override
	public String getAsText() {
		return getValue().toString();
	}
}
