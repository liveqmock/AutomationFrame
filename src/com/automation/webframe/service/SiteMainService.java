/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：SiteMainService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午11:06:50<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.webframe.mapper.SiteMainMapper;

/**
 * 
 * 类名称：SiteMainService <br>
 * 类描述：站点主题服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午11:06:50 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("siteMainService")
public class SiteMainService<T> extends BaseService<T> {
	
	/**  */
	@Autowired
	private SiteMainMapper<T> siteMainMapper;

	/**
	 * 方法：addTypeRel <br>
	 * 描述：管理站点类型 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午11:16:00 <br>
	 * 
	 * @param typeIds
	 * @param siteId
	 */
	public void addTypeRel(Integer[] typeIds, Integer siteId) {
		// 先清理掉关联关系
		getMapper().deleteTypeRel(siteId);
		if (typeIds != null) {
			for (Integer typeId : typeIds) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("siteTypeId", typeId);
				map.put("siteId", siteId);
				getMapper().addTypeRel(map);
			}
		}
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
		for (Object id : ids) {
			getMapper().deleteTypeRel((Integer) id);
		}
		super.delete(ids);
	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.automation.webframe.service.BaseService#getMapper()
	 */
	@Override
	public SiteMainMapper<T> getMapper() {
		return siteMainMapper;
	}
}
