/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.mapper <br>
 * 文件名：SiteTypeMapper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午10:25:48<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.mapper;

import java.util.List;

/**
 * 
 * 类名称：SiteTypeMapper <br>
 * 类描述：站点类型Mapper <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午10:25:48 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface SiteTypeMapper<T> extends BaseMapper<T> {

	/**
	 * 方法：deleteSiteRel <br>
	 * 描述：删除管理站点数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:26:25 <br>
	 * 
	 * @param siteTypeId
	 */
	public void deleteSiteRel(Integer siteTypeId);

	/**
	 * 方法：queryByAll <br>
	 * 描述：查所有站点类型 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:26:35 <br>
	 * 
	 * @return
	 */
	public List<T> queryByAll();

	/**
	 * 方法：queryBySiteId <br>
	 * 描述：根据站点ID查看站点 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:26:41 <br>
	 * 
	 * @param siteId
	 * @return
	 */
	public List<T> queryBySiteId(Integer siteId);

}
