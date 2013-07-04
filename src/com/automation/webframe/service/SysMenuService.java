/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：SysMenuService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午2:06:20<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.webframe.entity.SysMenu;
import com.automation.webframe.entity.SysMenuBtn;
import com.automation.webframe.entity.SysRoleRel;
import com.automation.webframe.mapper.SysMenuMapper;

/**
 * 
 * 类名称：SysMenuService <br>
 * 类描述：系统菜单服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午2:06:20 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("sysMenuService")
public class SysMenuService<T> extends BaseService<T> {

	/** 输出日志 */
	private final static Logger logger = Logger.getLogger(SysMenuService.class);

	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;

	@Autowired
	private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;

	@Autowired
	private SysMenuMapper<T> mapper;

	/**
	 * 方法：saveBtns <br>
	 * 描述：保存菜单btn <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:07:32 <br>
	 * 
	 * @param menuid
	 * @param btns
	 * @throws Exception
	 */
	public void saveBtns(Integer menuid, List<SysMenuBtn> btns)
			throws Exception {
		logger.debug("保存菜单btn");
		if (btns == null || btns.isEmpty()) {
			return;
		}
		for (SysMenuBtn btn : btns) {
			if (btn.getId() != null && "1".equals(btn.getDeleteFlag())) {
				sysMenuBtnService.delete(btn.getId());
				continue;
			}
			btn.setMenuid(menuid);
			if (btn.getId() == null) {
				sysMenuBtnService.add(btn);
			} else {
				sysMenuBtnService.update(btn);
			}
		}

	}

	/**
	 * 方法：add <br>
	 * 描述：添加菜单 <br>
	 * 
	 * @param t
	 * @throws Exception
	 * @see com.automation.webframe.service.BaseService#add(java.lang.Object)
	 */
	@Override
	public void add(T t) throws Exception {
		logger.debug("添加菜单");
		super.add(t);
		SysMenu menu = (SysMenu) t;
		saveBtns(menu.getId(), menu.getBtns());
	}

	/**
	 * 方法：update <br>
	 * 描述：修改菜单 <br>
	 * 
	 * @param t
	 * @throws Exception
	 * @see com.automation.webframe.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(T t) throws Exception {
		logger.debug("修改菜单");
		super.update(t);
		SysMenu menu = (SysMenu) t;
		saveBtns(menu.getId(), menu.getBtns());
	}

	/**
	 * 方法：queryByAll <br>
	 * 描述：查询所有系统菜单列表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:11:50 <br>
	 * 
	 * @return
	 */
	public List<T> queryByAll() {
		logger.debug("查询所有系统菜单列表 ");
		return getMapper().queryByAll();
	}

	/**
	 * 方法：getRootMenu <br>
	 * 描述：获取顶级菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:12:01 <br>
	 * 
	 * @param menuId
	 * @return
	 */
	public List<T> getRootMenu(Integer menuId) {
		logger.debug("获取顶级菜单");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menuId", menuId);
		return getMapper().getRootMenu(map);
	}

	/**
	 * 方法：getChildMenu <br>
	 * 描述：获取子菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:12:09 <br>
	 * 
	 * @return
	 */
	public List<T> getChildMenu() {
		logger.debug("获取子菜单");
		return getMapper().getChildMenu();
	}

	/**
	 * 方法：getRootMenuByUser <br>
	 * 描述：根据用户id查询父菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:12:27 <br>
	 * 
	 * @param userId
	 * @return
	 */
	public List<T> getRootMenuByUser(Integer userId) {
		logger.debug("根据用户id查询父菜单");
		return getMapper().getRootMenuByUser(userId);
	}

	/**
	 * 方法：getChildMenuByUser <br>
	 * 描述：根据用户id查询子菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:12:35 <br>
	 * 
	 * @param userId
	 * @return
	 */
	public List<T> getChildMenuByUser(Integer userId) {
		logger.debug("根据用户id查询子菜单");
		return getMapper().getChildMenuByUser(userId);
	}

	/**
	 * 方法：getMenuByRoleId <br>
	 * 描述：根据权限id查询菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:12:43 <br>
	 * 
	 * @param roleId
	 * @return
	 */
	public List<T> getMenuByRoleId(Integer roleId) {
		logger.debug("根据权限id查询菜单");
		return getMapper().getMenuByRoleId(roleId);
	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.automation.webframe.service.BaseService#getMapper()
	 */
	@Override
	public SysMenuMapper<T> getMapper() {
		return mapper;
	}

}
