/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：SiteColumnService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午11:00:49<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.webframe.mapper.SiteColumnMapper;

/**
 * 
 * 类名称：SiteColumnService <br>
 * 类描述：站点栏目服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午11:00:49 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("siteColumnService")
public class SiteColumnService<T> extends BaseService<T> {
	/** 输出日志 */
	private final static Logger logger = Logger
			.getLogger(SiteColumnService.class);

	@Autowired
	private SiteColumnMapper<T> mapper;

	/**
	 * 方法：queryBySiteId <br>
	 * 描述：根据站点id查询栏目 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午11:05:01 <br>
	 * 
	 * @param siteId
	 * @return
	 */
	public List<T> queryBySiteId(Integer siteId) {
		logger.debug("根据ID查询站点");
		return getMapper().queryBySiteId(siteId);
	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.automation.webframe.service.BaseService#getMapper()
	 */
	@Override
	public SiteColumnMapper<T> getMapper() {
		return mapper;
	}

}
