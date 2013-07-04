/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.entity <br>
 * 文件名：SysMenu.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-上午11:36:29<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.entity;

import java.util.List;

/**
 * 
 * 类名称：SysMenu <br>
 * 类描述：系统菜单实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 上午11:36:29 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysMenu extends BaseBean {

	/** 主键 */
	private Integer id;

	/** 菜单名称 */
	private String name;

	/** 菜单名称 */
	private String url;

	/** 父id 关联sys_menu.id */
	private Integer parentId;

	/** 是否删除,0=未删除，1=已删除 */
	private Integer deleted;

	/** 创建时间 */
	private java.sql.Timestamp createTime;

	/** 修改时间 */
	private java.sql.Timestamp updateTime;

	/** 排序 */
	private Integer rank;

	/** 注册Action 按钮|分隔 */
	private String actions;

	/** 子菜单总数 */
	private int subCount;

	// 菜单按钮
	private List<SysMenuBtn> btns;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:29 <br>
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:29
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the name <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:29 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:29
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @retrun the url <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:29 <br>
	 */

	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:29
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @retrun the parentId <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:29 <br>
	 */

	public Integer getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:29
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * @retrun the deleted <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:29 <br>
	 */

	public Integer getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:29
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	/**
	 * @retrun the createTime <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:29 <br>
	 */

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:29
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @retrun the updateTime <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:29 <br>
	 */

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:29
	 */
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @retrun the rank <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:29 <br>
	 */

	public Integer getRank() {
		return rank;
	}

	/**
	 * @param rank
	 *            the rank to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:29
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	/**
	 * @retrun the actions <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:29 <br>
	 */

	public String getActions() {
		return actions;
	}

	/**
	 * @param actions
	 *            the actions to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:29
	 */
	public void setActions(String actions) {
		this.actions = actions;
	}

	/**
	 * @retrun the subCount <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:29 <br>
	 */

	public int getSubCount() {
		return subCount;
	}

	/**
	 * @param subCount
	 *            the subCount to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:29
	 */
	public void setSubCount(int subCount) {
		this.subCount = subCount;
	}

	/**
	 * @retrun the btns <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:29 <br>
	 */

	public List<SysMenuBtn> getBtns() {
		return btns;
	}

	/**
	 * @param btns
	 *            the btns to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:29
	 */
	public void setBtns(List<SysMenuBtn> btns) {
		this.btns = btns;
	}

}
