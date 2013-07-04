/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：SysUserService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午2:29:28<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automation.webframe.entity.SysRoleRel;
import com.automation.webframe.entity.SysRoleRel.RelType;
import com.automation.webframe.mapper.SysUserMapper;
import com.automation.webframe.web.vo.SysUserModel;

/**
 * 
 * 类名称：SysUserService <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午2:29:28 <br>
 * 修改备注：TODO <br>
 * 
 */
@Service("sysUserService")
public class SysUserService<T> extends BaseService<T> {

	/** 输出日志 */
	private final static Logger logger = Logger.getLogger(SysUserService.class);

	@Autowired
	private SysUserMapper<T> mapper;

	@Autowired
	private SysRoleRelService<SysRoleRel> sysRoleRelService;

	/**
	 * 方法：delete <br>
	 * 描述：TODO <br>
	 * 
	 * @param ids
	 * @throws Exception
	 * @see com.automation.webframe.service.BaseService#delete(java.lang.Object[])
	 */
	@Override
	public void delete(Object... ids) throws Exception {
		super.delete(ids);
		for (Object id : ids) {
			sysRoleRelService.deleteByObjId((Integer) id, RelType.USER.key);
		}
	}

	/**
	 * 方法：queryLogin <br>
	 * 描述：检查登录 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:31:13 <br>
	 * 
	 * @param email
	 * @param pwd
	 * @return
	 */
	public T queryLogin(String email, String pwd) {
		SysUserModel model = new SysUserModel();
		model.setEmail(email);
		model.setPwd(pwd);
		return getMapper().queryLogin(model);
	}

	/**
	 * 方法：getUserCountByEmail <br>
	 * 描述：查询邮箱总数，检查是否存在 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:31:23 <br>
	 * 
	 * @param email
	 * @return
	 */
	public int getUserCountByEmail(String email) {
		return getMapper().getUserCountByEmail(email);
	}

	/**
	 * 方法：getUserRole <br>
	 * 描述：查询用户权限 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:31:32 <br>
	 * 
	 * @param userId
	 * @return
	 */
	public List<SysRoleRel> getUserRole(Integer userId) {
		return sysRoleRelService.queryByObjId(userId, RelType.USER.key);
	}

	/**
	 * 方法：addUserRole <br>
	 * 描述：添加用户权限 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午2:31:42 <br>
	 * 
	 * @param userId
	 * @param roleIds
	 * @throws Exception
	 */
	public void addUserRole(Integer userId, Integer[] roleIds) throws Exception {
		if (userId == null || roleIds == null || roleIds.length < 1) {
			return;
		}
		// 清除关联关系
		sysRoleRelService.deleteByObjId(userId, RelType.USER.key);
		for (Integer roleId : roleIds) {
			SysRoleRel rel = new SysRoleRel();
			rel.setRoleId(roleId);
			rel.setObjId(userId);
			rel.setRelType(RelType.USER.key);
			sysRoleRelService.add(rel);
		}
	}

	/**
	 * 方法：getMapper <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @see com.automation.webframe.service.BaseService#getMapper()
	 */
	@Override
	public SysUserMapper<T> getMapper() {
		return mapper;
	}

}
