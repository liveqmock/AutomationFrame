/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.entity <br>
 * 文件名：SysUser.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-上午11:56:04<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.entity;

import java.sql.Timestamp;

/**
 * 
 * 类名称：SysUser <br>
 * 类描述：系统用户实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 上午11:56:04 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysUser extends BaseBean {

	/** id主键 */
	private Integer id;

	/** 邮箱也是登录帐号 */
	private String email;

	/** 登录密码 */
	private String pwd;

	/** 昵称 */
	private String nickName;

	/** 状态 0=可用,1=禁用 */
	private Integer state;

	/** 登录总次数 */
	private Integer loginCount;

	/** 最后登录时间 */
	private Timestamp loginTime;

	/** 删除状态 0=未删除,1=已删除 */
	private Integer deleted;

	/** 创建时间 */
	private Timestamp createTime;

	/** 修改时间 */
	private Timestamp updateTime;

	/** 创建人 */
	private Integer createBy;

	/** 修改人 */
	private Integer updateBy;

	/** 超级管理员 */
	private Integer superAdmin;

	/** 用户权限, 按","区分 */
	private String roleStr;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the email <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @retrun the pwd <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd
	 *            the pwd to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @retrun the nickName <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName
	 *            the nickName to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @retrun the state <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public Integer getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * @retrun the loginCount <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public Integer getLoginCount() {
		return loginCount;
	}

	/**
	 * @param loginCount
	 *            the loginCount to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	/**
	 * @retrun the loginTime <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public Timestamp getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime
	 *            the loginTime to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * @retrun the deleted <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public Integer getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	/**
	 * @retrun the createTime <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @retrun the updateTime <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @retrun the createBy <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public Integer getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy
	 *            the createBy to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	/**
	 * @retrun the updateBy <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public Integer getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy
	 *            the updateBy to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * @retrun the superAdmin <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public Integer getSuperAdmin() {
		return superAdmin;
	}

	/**
	 * @param superAdmin
	 *            the superAdmin to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setSuperAdmin(Integer superAdmin) {
		this.superAdmin = superAdmin;
	}

	/**
	 * @retrun the roleStr <br>
	 * 
	 *         时间: 2013-6-20 上午11:58:14 <br>
	 */

	public String getRoleStr() {
		return roleStr;
	}

	/**
	 * @param roleStr
	 *            the roleStr to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:58:14
	 */
	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}

}
