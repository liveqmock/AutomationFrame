/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.mapper <br>
 * 文件名：SiteMainMapper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午10:21:07<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.mapper;

import java.util.Map;

/**
 * 
 * 类名称：SiteMainMapper <br>
 * 类描述：站点主类Mapper <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午10:21:07 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface SiteMainMapper<T> extends BaseMapper<T> {

	/**
	 * 方法：addTypeRel <br>
	 * 描述：管理站点类型 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:21:40 <br>
	 * 
	 * @param map
	 */
	public void addTypeRel(Map<String, Object> map);

	/**
	 * 方法：deleteTypeRel <br>
	 * 描述：删除关联的数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:21:57 <br>
	 * 
	 * @param siteId
	 */
	public void deleteTypeRel(Integer siteId);
}
