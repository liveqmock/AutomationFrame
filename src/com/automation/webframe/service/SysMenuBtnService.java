/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：SysMenuBtnService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午11:42:48<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.webframe.mapper.SysMenuBtnMapper;

/**
 * 
 * 类名称：SysMenuBtnService <br>
 * 类描述：系统菜单按钮服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午11:42:48 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("sysMenuBtnService")
public class SysMenuBtnService<T> extends BaseService<T> {

	/** 输出日志 */
	private final static Logger logger = Logger
			.getLogger(SysMenuBtnService.class);

	@Autowired
	private SysMenuBtnMapper<T> mapper;

	/**
	 * 方法：queryByAll <br>
	 * 描述：查询所有 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午11:44:13 <br>
	 * 
	 * @return
	 */
	public List<T> queryByAll() {
		logger.debug("查询所有菜单");
		return getMapper().queryByAll();
	}

	/**
	 * 方法：queryByMenuid <br>
	 * 描述：根据菜单ID查询 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午11:44:22 <br>
	 * 
	 * @param menuid
	 * @return
	 */
	public List<T> queryByMenuid(Integer menuid) {
		logger.debug("根据菜单ID查询");
		return getMapper().queryByMenuid(menuid);
	}

	/**
	 * 方法：queryByMenuUrl <br>
	 * 描述：根据菜单链接查询 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午11:45:11 <br>
	 * 
	 * @param url
	 * @return
	 */
	public List<T> queryByMenuUrl(String url) {
		logger.debug("根据菜单链接查");
		return getMapper().queryByMenuUrl(url);
	}

	/**
	 * 方法：deleteByMenuid <br>
	 * 描述：根据菜单ID删除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午11:45:26 <br>
	 * 
	 * @param menuid
	 */
	public void deleteByMenuid(Integer menuid) {
		logger.debug("根据菜单ID删除");
		getMapper().deleteByMenuid(menuid);
	}

	/**
	 * 方法：getMenuBtnByUser <br>
	 * 描述：根据用户ID查询菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午11:45:36 <br>
	 * 
	 * @param userid
	 * @return
	 */
	public List<T> getMenuBtnByUser(Integer userid) {
		logger.debug("根据用户ID查询菜单");
		return getMapper().getMenuBtnByUser(userid);
	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.automation.webframe.service.BaseService#getMapper()
	 */
	@Override
	public SysMenuBtnMapper<T> getMapper() {
		return mapper;
	}

}
