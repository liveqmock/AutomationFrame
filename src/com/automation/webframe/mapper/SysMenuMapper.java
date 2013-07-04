/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.mapper <br>
 * 文件名：SysMenuMapper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午10:32:12<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * 类名称：SysMenuMapper <br>
 * 类描述：系统菜单Mapper <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午10:32:12 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface SysMenuMapper<T> extends BaseMapper<T> {

	/**
	 * 方法：queryByAll <br>
	 * 描述：查询所有系统菜单列表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:34:17 <br>
	 * 
	 * @return
	 */
	public List<T> queryByAll();

	/**
	 * 方法：getRootMenu <br>
	 * 描述：获取顶级菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:34:58 <br>
	 * 
	 * @param map
	 * @return
	 */
	public List<T> getRootMenu(Map<String, Object> map);

	/**
	 * 方法：getChildMenu <br>
	 * 描述：获取子菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:36:49 <br>
	 * 
	 * @return
	 */
	public List<T> getChildMenu();

	/**
	 * 方法：getMenuByRoleId <br>
	 * 描述：根据权限id查询菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:36:59 <br>
	 * 
	 * @param roleId
	 * @return
	 */
	public List<T> getMenuByRoleId(Integer roleId);

	/**
	 * 方法：getRootMenuByUser <br>
	 * 描述：根据用户id查询父菜单菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:37:07 <br>
	 * 
	 * @param userId
	 * @return
	 */
	public List<T> getRootMenuByUser(Integer userId);

	/**
	 * 方法：getChildMenuByUser <br>
	 * 描述：根据用户id查询子菜单菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:37:17 <br>
	 * 
	 * @param userId
	 * @return
	 */
	public List<T> getChildMenuByUser(Integer userId);

}
