/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.mapper <br>
 * 文件名：SiteScoreMapper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午10:22:46<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.mapper;

import java.util.Map;

/**
 * 
 * 类名称：SiteScoreMapper <br>
 * 类描述：站点积分相关Mapper <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午10:22:46 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface SiteScoreMapper<T> extends BaseMapper<T> {

	/**
	 * 方法：saveScore <br>
	 * 描述：保存积分相关信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:23:18 <br>
	 * 
	 * @param map
	 */
	public void addScore(Map<String, Object> map);

}
