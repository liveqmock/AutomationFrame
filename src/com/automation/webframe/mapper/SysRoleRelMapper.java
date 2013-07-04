/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.mapper <br>
 * 文件名：SysRoleRelMapper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午10:40:20<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.mapper;

import java.util.List;
import java.util.Map;

import com.automation.webframe.entity.SysRoleRel;

/**
 * 
 * 类名称：SysRoleRelMapper <br>
 * 类描述：系统权限关联Mapper <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午10:40:20 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface SysRoleRelMapper<T> extends BaseMapper<T> {

	/**
	 * 方法：deleteByRoleId <br>
	 * 描述：根据角色ID删除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:43:27 <br>
	 * 
	 * @param param
	 */
	public void deleteByRoleId(Map<String, Object> param);

	/**
	 * 方法：deleteByObjId <br>
	 * 描述：根据关联ID删除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:43:45 <br>
	 * 
	 * @param param
	 */
	public void deleteByObjId(Map<String, Object> param);

	/**
	 * 方法：queryByRoleId <br>
	 * 描述：根据角色ID查询 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:45:22 <br>
	 * 
	 * @param param
	 * @return
	 */
	public List<SysRoleRel> queryByRoleId(Map<String, Object> param);

	/**
	 * 方法：queryByObjId <br>
	 * 描述：根据关联ID查询 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:45:35 <br>
	 * 
	 * @param param
	 * @return
	 */
	public List<SysRoleRel> queryByObjId(Map<String, Object> param);

}
