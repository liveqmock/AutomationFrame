/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.mapper <br>
 * 文件名：SysRoleMapper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午10:38:55<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.mapper;

import java.util.List;

/**
 * 
 * 类名称：SysRoleMapper <br>
 * 类描述：系统权限Mapper <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午10:38:55 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface SysRoleMapper<T> extends BaseMapper<T> {

	/**
	 * 方法：queryAllList <br>
	 * 描述：查询全部有效的权限 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:39:30 <br>
	 * 
	 * @return
	 */
	public List<T> queryAllList();

	/**
	 * 方法：queryByUserid <br>
	 * 描述：根据用户Id查询权限 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:39:38 <br>
	 * 
	 * @param userid
	 * @return
	 */
	public List<T> queryByUserid(Integer userid);
}
