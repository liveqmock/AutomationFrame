/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：SysEnumService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午2:00:11<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.automation.webframe.mapper.SysEnumMapper;

/**
 * 
 * 类名称：SysEnumService <br>
 * 类描述：系统枚举服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午2:00:11 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysEnumService<T> extends BaseService<T> {

	/** 输出日志 */
	private final static Logger logger = Logger.getLogger(SysEnumService.class);

	@Autowired
	private SysEnumMapper<T> mapper;

	public SysEnumMapper<T> getMapper() {
		return mapper;
	}

}
