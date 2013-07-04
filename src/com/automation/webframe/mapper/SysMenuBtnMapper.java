/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.mapper <br>
 * 文件名：SysMenuBtnMapper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午10:28:07<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.mapper;

import java.util.List;

/**
 * 
 * 类名称：SysMenuBtnMapper <br>
 * 类描述：系统菜单按钮Mapper <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午10:28:07 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface SysMenuBtnMapper<T> extends BaseMapper<T> {

	/**
	 * 方法：queryByMenuid <br>
	 * 描述：根据id查询菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:29:05 <br>
	 * 
	 * @param menuid
	 * @return
	 */
	public List<T> queryByMenuid(Integer menuid);

	/**
	 * 方法：queryByMenuUrl <br>
	 * 描述：根据菜单链接查询菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:29:25 <br>
	 * 
	 * @param url
	 * @return
	 */
	public List<T> queryByMenuUrl(String url);

	/**
	 * 方法：deleteByMenuid <br>
	 * 描述：根据菜单ID删除菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:29:45 <br>
	 * 
	 * @param menuid
	 */
	public void deleteByMenuid(Integer menuid);

	/**
	 * 方法：getMenuBtnByUser <br>
	 * 描述：根据用户ID查询菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:30:00 <br>
	 * 
	 * @param userid
	 * @return
	 */
	public List<T> getMenuBtnByUser(Integer userid);

	/**
	 * 方法：queryByAll <br>
	 * 描述：查询所有菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:30:13 <br>
	 * 
	 * @return
	 */
	public List<T> queryByAll();
}
