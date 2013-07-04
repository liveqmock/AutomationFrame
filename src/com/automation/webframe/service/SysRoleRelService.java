/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：SysRoleRelService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午2:15:41<br>
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

import com.automation.webframe.entity.SysRoleRel;
import com.automation.webframe.mapper.SysRoleRelMapper;

/**
 * 
 * 类名称：SysRoleRelService <br>
 * 类描述：系统角色管理服务 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午2:15:41 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("sysRoleRelService")
public class SysRoleRelService<T> extends BaseService<T> {

	/** 输出日志 */
	private final static Logger logger = Logger
			.getLogger(SysRoleRelService.class);

	@Autowired
	private SysRoleRelMapper<T> mapper;

	/**
	 * 方法：queryByRoleId <br>
	 * 描述：根据角色ID查询 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:18:12 <br>
	 * 
	 * @param roleId
	 * @param relType
	 * @return
	 */
	public List<SysRoleRel> queryByRoleId(Integer roleId, Integer relType) {
		logger.debug("根据角色ID查询");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("relType", relType);
		return getMapper().queryByRoleId(param);
	}

	/**
	 * 方法：queryByObjId <br>
	 * 描述：根据关联ID查询 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:18:33 <br>
	 * 
	 * @param objId
	 * @param relType
	 * @return
	 */
	public List<SysRoleRel> queryByObjId(Integer objId, Integer relType) {
		logger.debug("根据关联ID查询 ");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("relType", relType);
		return getMapper().queryByObjId(param);
	}

	/**
	 * 方法：deleteByObjId <br>
	 * 描述：根据关联对象id,关联类型删除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:18:47 <br>
	 * 
	 * @param objId
	 * @param relType
	 */
	public void deleteByObjId(Integer objId, Integer relType) {
		logger.debug("根据关联对象id,关联类型删除");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("objId", objId);
		param.put("relType", relType);
		getMapper().deleteByObjId(param);
	}

	/**
	 * 方法：deleteByRoleId <br>
	 * 描述：根据角色id删除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:18:58 <br>
	 * 
	 * @param roleId
	 */
	public void deleteByRoleId(Integer roleId) {
		logger.debug("根据角色id删除");
		deleteByRoleId(roleId, null);
	}

	/**
	 * 方法：deleteByRoleId <br>
	 * 描述：根据角色id,关联类型删除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:19:08 <br>
	 * 
	 * @param roleId
	 * @param relType
	 */
	public void deleteByRoleId(Integer roleId, Integer relType) {
		logger.debug("根据角色id,关联类型删除");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleId);
		param.put("relType", relType);
		getMapper().deleteByRoleId(param);
	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.automation.webframe.service.BaseService#getMapper()
	 */
	@Override
	public SysRoleRelMapper<T> getMapper() {
		return mapper;
	}

}
