/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.entity <br>
 * 文件名：SysRole.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-上午11:42:06<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.entity;

/**
 * 
 * 类名称：SysRole <br>
 * 类描述：系统角色实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 上午11:42:06 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysRole extends BaseBean {

	/** id主键 */
	private Integer id;

	/** 角色名称 */
	private String roleName;

	/** 创建时间 */
	private java.sql.Timestamp createTime;

	/** 创建人 */
	private Integer createBy;

	/** 修改时间 */
	private java.sql.Timestamp updateTime;

	/** 修改人 */
	private Integer updateBy;

	/** 状态0=可用 1=禁用 */
	private Integer state;

	/** 角色描述 */
	private String descr;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-6-20 上午11:43:31 <br>
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:43:31
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the roleName <br>
	 * 
	 *         时间: 2013-6-20 上午11:43:31 <br>
	 */

	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:43:31
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @retrun the createTime <br>
	 * 
	 *         时间: 2013-6-20 上午11:43:31 <br>
	 */

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:43:31
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @retrun the createBy <br>
	 * 
	 *         时间: 2013-6-20 上午11:43:31 <br>
	 */

	public Integer getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy
	 *            the createBy to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:43:31
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	/**
	 * @retrun the updateTime <br>
	 * 
	 *         时间: 2013-6-20 上午11:43:31 <br>
	 */

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:43:31
	 */
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @retrun the updateBy <br>
	 * 
	 *         时间: 2013-6-20 上午11:43:31 <br>
	 */

	public Integer getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy
	 *            the updateBy to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:43:31
	 */
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * @retrun the state <br>
	 * 
	 *         时间: 2013-6-20 上午11:43:31 <br>
	 */

	public Integer getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:43:31
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * @retrun the descr <br>
	 * 
	 *         时间: 2013-6-20 上午11:43:31 <br>
	 */

	public String getDescr() {
		return descr;
	}

	/**
	 * @param descr
	 *            the descr to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:43:31
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

}
