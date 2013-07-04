/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：SiteTypeService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午11:30:47<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.webframe.entity.SiteType;
import com.automation.exception.ServiceException;
import com.automation.webframe.mapper.SiteTypeMapper;
import com.automation.webframe.web.vo.SiteTypeModel;

/**
 * 
 * 类名称：SiteTypeService <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午11:30:47 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("siteTypeService")
public class SiteTypeService<T> extends BaseService<T> {

	/** 输出日志 */
	private final static Logger logger = Logger
			.getLogger(SiteTypeService.class);

	@Autowired
	private SiteTypeMapper<T> mapper;

	/**
	 * 方法：add <br>
	 * 描述：TODO <br>
	 * 
	 * @param t
	 * @throws Exception
	 * @see com.automation.webframe.service.BaseService#add(java.lang.Object)
	 */
	@Override
	public void add(T t) throws Exception {
		logger.debug("添加站点类型");
		validation(t, 0);
		getMapper().add(t);
	}

	/**
	 * 方法：update <br>
	 * 描述：TODO <br>
	 * 
	 * @param t
	 * @throws Exception
	 * @see com.automation.webframe.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(T t) throws Exception {
		logger.debug("修改站点类型");
		validation(t, 1);
		getMapper().update(t);
	}

	/**
	 * 方法：delete <br>
	 * 描述：TODO <br>
	 * 
	 * @param ids
	 * @throws Exception
	 * @see com.automation.webframe.service.BaseService#delete(java.lang.Object[])
	 */
	@Override
	public void delete(Object... ids) throws Exception {
		logger.debug("根据ID删除站点类型");
		if (ids == null || ids.length < 1) {
			return;
		}
		for (Object id : ids) {
			getMapper().deleteSiteRel((Integer) id);
		}
		super.delete(ids);
	}

	/**
	 * 方法：queryByAll <br>
	 * 描述：查询所有 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午11:33:54 <br>
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<T> queryByAll() throws Exception {
		logger.debug("查询所有站点类型");
		return getMapper().queryByAll();
	}

	/**
	 * 方法：queryBySiteId <br>
	 * 描述：根据站点ID查询 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午11:34:04 <br>
	 * 
	 * @param siteId
	 * @return
	 * @throws Exception
	 */
	public List<T> queryBySiteId(Integer siteId) throws Exception {
		logger.debug("根据ID站点类型");
		return getMapper().queryBySiteId(siteId);
	}

	/**
	 * 方法：validation <br>
	 * 描述：验证是否重复 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午11:32:23 <br>
	 * 
	 * @param t
	 * @param num
	 * @throws Exception
	 */
	private void validation(T t, int num) throws Exception {
		SiteType bean = (SiteType) t;
		// 验证name是否重复
		SiteTypeModel model = new SiteTypeModel();
		model.setName(bean.getName());
		int count = getMapper().queryByCount(model);
		if (count > num) {
			throw new ServiceException("name is can't be duplicate");
		}
		// 验证code是否重复
		model.setName(null);
		model.setCode(bean.getCode());
		count = getMapper().queryByCount(model);
		if (count > num) {
			throw new ServiceException("code is can't be duplicate");
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
	public SiteTypeMapper<T> getMapper() {
		return mapper;
	}

}
