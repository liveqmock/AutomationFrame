/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：${className}.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：${time} <br>
 * Copyright (c) 2013 ${copyright}-版权所有<br>
 *
 */
package com.automation.webframe.service;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.webframe.mapper.${className}Mapper;


/**
 * 
 * 类名称：${className} <br>
 * 类描述：${remark}服务 <br>
 * 创建人：${createUser} <br>
 * 修改人：${modifyUser} <br>
 * 修改时间：${time} <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("$!{lowerName}Service")
public class ${className}Service<T> extends BaseService<T> {
	
	/** 输出日志 */
	private final static Logger logger= Logger.getLogger(${className}Service.class);

	/**  */
	@Autowired
    private ${className}Mapper<T> mapper;

    /**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.automation.webframe.service.BaseService#getMapper()
	 */
	@Override
	public ${className}Mapper<T> getMapper() {
		return mapper;
	}

}
