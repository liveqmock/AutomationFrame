/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：SysRoleService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午2:24:40<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.webframe.entity.BaseBean.STATE;
import com.automation.webframe.entity.SysRole;
import com.automation.webframe.entity.SysRoleRel;
import com.automation.webframe.entity.SysRoleRel.RelType;
import com.automation.webframe.mapper.SysRoleMapper;

/**
 * 
 * 类名称：SysRoleService <br>
 * 类描述：系统权限服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午2:24:40 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("sysRoleService")
public class SysRoleService<T> extends BaseService<T> {

	/** 输出日志 */
	private final static Logger logger = Logger.getLogger(SysRoleService.class);

	@Autowired
	private SysRoleMapper<T> mapper;

	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;

	/**
	 * 方法：addRoleMenuRel <br>
	 * 描述：添加角色&菜单关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:25:57 <br>
	 * 
	 * @param roleId
	 * @param menuIds
	 * @throws Exception
	 */
	public void addRoleMenuRel(Integer roleId, Integer[] menuIds)
			throws Exception {
		logger.debug("添加角色&菜单关系");
		if (roleId == null || menuIds == null || menuIds.length < 1) {
			return;
		}
		for (Integer menuid : menuIds) {
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(menuid);
			rel.setRelType(RelType.MENU.key);
			sysRoleRelService.add(rel);
		}
	}

	/**
	 * 方法：addRoleBtnRel <br>
	 * 描述：添加角色&菜单关系 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:26:07 <br>
	 * 
	 * @param roleId
	 * @param btnIds
	 * @throws Exception
	 */
	public void addRoleBtnRel(Integer roleId, Integer[] btnIds)
			throws Exception {
		logger.debug("添加角色&菜单关系");
		if (roleId == null || btnIds == null || btnIds.length < 1) {
			return;
		}
		for (Integer btnid : btnIds) {
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(btnid);
			rel.setRelType(RelType.BTN.key);
			sysRoleRelService.add(rel);
		}
	}

	/**
	 * 方法：add <br>
	 * 描述：添加 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:26:17 <br>
	 * 
	 * @param role
	 * @param menuIds
	 * @param btnIds
	 * @throws Exception
	 */
	public void add(SysRole role, Integer[] menuIds, Integer[] btnIds)
			throws Exception {
		logger.debug("添加");
		super.add((T) role);
		addRoleMenuRel(role.getId(), menuIds);
		addRoleBtnRel(role.getId(), btnIds);
	}

	/**
	 * 方法：delete <br>
	 * 描述：删除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:26:28 <br>
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void delete(Integer[] ids) throws Exception {
		logger.debug("删除");
		super.delete(ids);
		for (Integer id : ids) {
			// 清除关联关系
			sysRoleRelService.deleteByRoleId(id);
		}
	}

	/**
	 * 方法：update <br>
	 * 描述：修改 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:26:54 <br>
	 * 
	 * @param role
	 * @param menuIds
	 * @param btnIds
	 * @throws Exception
	 */
	public void update(SysRole role, Integer[] menuIds, Integer[] btnIds)
			throws Exception {
		logger.debug("修改");
		super.update((T) role);
		// 如果角色被禁用则删除关联的用户关系
		if (STATE.DISABLE.key == role.getState()) {
			sysRoleRelService.deleteByRoleId(role.getId(), RelType.USER.key);
		}
		// 清除关联关系
		sysRoleRelService.deleteByRoleId(role.getId(), RelType.MENU.key);
		sysRoleRelService.deleteByRoleId(role.getId(), RelType.BTN.key);
		addRoleMenuRel(role.getId(), menuIds);
		addRoleBtnRel(role.getId(), btnIds);

	}

	/**
	 * 方法：queryAllList <br>
	 * 描述：查询全部有效的权限 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:27:05 <br>
	 * 
	 * @return
	 */
	public List<T> queryAllList() {
		logger.debug("查询全部有效的权限");
		return getMapper().queryAllList();
	}

	/**
	 * 方法：queryByUserid <br>
	 * 描述：查询全部有效的权限 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:27:16 <br>
	 * 
	 * @param userid
	 * @return
	 */
	public List<T> queryByUserid(Integer userid) {
		logger.debug("查询全部有效的权限");
		return getMapper().queryByUserid(userid);
	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.automation.webframe.service.BaseService#getMapper()
	 */
	@Override
	public SysRoleMapper<T> getMapper() {
		return mapper;
	}

}
