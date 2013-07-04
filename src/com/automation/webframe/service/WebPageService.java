/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：WebPageService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午2:36:47<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.webframe.mapper.WebPageMapper;

/**
 * 
 * 类名称：WebPageService <br>
 * 类描述：站点页服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午2:36:47 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("webPageService")
public class WebPageService<T> extends BaseService<T> {

	/** 输出日志 */
	private final static Logger logger = Logger.getLogger(WebPageService.class);

	@Autowired
	private WebPageMapper<T> mapper;

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.automation.webframe.service.BaseService#getMapper()
	 */
	@Override
	public WebPageMapper<T> getMapper() {
		return mapper;
	}

}
