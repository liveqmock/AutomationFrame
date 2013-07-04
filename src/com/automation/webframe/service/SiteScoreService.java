/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：SiteScoreService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午11:18:59<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.webframe.entity.SiteScore;
import com.automation.webframe.entity.SiteScore.ScoreType;
import com.automation.webframe.mapper.SiteScoreMapper;

/**
 * 
 * 类名称：SiteScoreService <br>
 * 类描述：站点积分相关服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午11:18:59 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("siteScoreService")
public class SiteScoreService<T> extends BaseService<T> {

	/** 输出日志 */
	private final static Logger logger = Logger
			.getLogger(SiteScoreService.class);

	@Autowired
	private SiteScoreMapper<T> mapper;

	/**
	 * 方法：saveScore <br>
	 * 描述：添加积分相关 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午11:23:32 <br>
	 * 
	 * @param siteId
	 * @param scoreType
	 */
	@SuppressWarnings("unchecked")
	public void saveScore(Integer siteId, Integer scoreType) {
		logger.debug("添加积分相关");
		SiteScore score = (SiteScore) getMapper().queryById(siteId);
		if (score == null) {
			score = new SiteScore(siteId, 0, 0, 0, 0, 0, 0);
			getMapper().add((T) score);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			String value = ScoreType.get(scoreType).value;
			map.put("siteId", siteId);
			map.put("column", value);
			getMapper().addScore(map);
		}

	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.automation.webframe.service.BaseService#getMapper()
	 */
	@Override
	public SiteScoreMapper<T> getMapper() {
		return mapper;
	}

}
