/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.mapper <br>
 * 文件名：SiteColumnMapper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午10:17:53<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.mapper;

import java.util.List;

/**
 * 
 * 类名称：SiteColumnMapper <br>
 * 类描述：站点栏目Mapper <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午10:17:53 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface SiteColumnMapper<T> extends BaseMapper<T> {

	/**
	 * 方法：queryBySiteId <br>
	 * 描述：根据站点id查询栏目 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:20:09 <br>
	 * 
	 * @param siteId
	 * @return
	 */
	public List<T> queryBySiteId(Integer siteId);
}
