/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.mapper <br>
 * 文件名：SysUserMapper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午10:46:31<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.mapper;

import com.automation.webframe.web.vo.SysUserModel;

/**
 * 
 * 类名称：SysUserMapper <br>
 * 类描述：系统用户Mapper <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午10:46:31 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface SysUserMapper<T> extends BaseMapper<T> {

	/**
	 * 方法：queryLogin <br>
	 * 描述：检查登录 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:47:13 <br>
	 * 
	 * @param model
	 * @return
	 */
	public T queryLogin(SysUserModel model);

	/**
	 * 方法：getUserCountByEmail <br>
	 * 描述：查询邮箱总数，检查是否存在 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:47:21 <br>
	 * 
	 * @param email
	 * @return
	 */
	public int getUserCountByEmail(String email);

}
