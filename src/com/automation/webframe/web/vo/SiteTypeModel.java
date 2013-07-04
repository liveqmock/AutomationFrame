/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.vo <br>
 * 文件名：SiteTypeModel.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-下午5:40:33<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.vo;

/**
 * 
 * 类名称：SiteTypeModel <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 下午5:40:33 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SiteTypeModel extends BaseModel {

	/** id 主键 */
	private Integer id;

	/** 分类名称 */
	private String name;

	/** code 英文和数字 */
	private String code;

	/** 排序 */
	private Integer rank;

	/** 描述 */
	private String descr;

	/** 状态 0=可用,1=禁用 */
	private Integer state;

	/** 创建时间 */
	private java.sql.Timestamp createTime;

	/** 修改时间 */
	private java.sql.Timestamp updateTime;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-6-20 下午5:42:04 <br>
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:42:04
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the name <br>
	 * 
	 *         时间: 2013-6-20 下午5:42:04 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:42:04
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @retrun the code <br>
	 * 
	 *         时间: 2013-6-20 下午5:42:04 <br>
	 */

	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:42:04
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @retrun the rank <br>
	 * 
	 *         时间: 2013-6-20 下午5:42:04 <br>
	 */

	public Integer getRank() {
		return rank;
	}

	/**
	 * @param rank
	 *            the rank to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:42:04
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	/**
	 * @retrun the descr <br>
	 * 
	 *         时间: 2013-6-20 下午5:42:04 <br>
	 */

	public String getDescr() {
		return descr;
	}

	/**
	 * @param descr
	 *            the descr to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:42:04
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

	/**
	 * @retrun the state <br>
	 * 
	 *         时间: 2013-6-20 下午5:42:04 <br>
	 */

	public Integer getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:42:04
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * @retrun the createTime <br>
	 * 
	 *         时间: 2013-6-20 下午5:42:04 <br>
	 */

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:42:04
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @retrun the updateTime <br>
	 * 
	 *         时间: 2013-6-20 下午5:42:04 <br>
	 */

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:42:04
	 */
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}
