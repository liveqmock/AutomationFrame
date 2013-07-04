/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.entity <br>
 * 文件名：SysMenuBtn.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-上午11:39:00<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.entity;

/**
 * 
 * 类名称：SysMenuBtn <br>
 * 类描述：系统菜单按钮实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 上午11:39:00 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysMenuBtn extends BaseBean {

	/** 主键 */
	private Integer id;

	/** 菜单id关联 sys_menu.id */
	private Integer menuid;

	/** 按钮名称 */
	private String btnName;

	/** 按钮类型，用于列表页显示的按钮 */
	private String btnType;

	/** url注册，用"," 分隔 。用于权限控制URL */
	private String actionUrls;

	/** 删除标记，与数据库字段无关 1=删除,其他不删除 */
	private String deleteFlag;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:12 <br>
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:12
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the menuid <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:12 <br>
	 */

	public Integer getMenuid() {
		return menuid;
	}

	/**
	 * @param menuid
	 *            the menuid to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:12
	 */
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	/**
	 * @retrun the btnName <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:12 <br>
	 */

	public String getBtnName() {
		return btnName;
	}

	/**
	 * @param btnName
	 *            the btnName to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:12
	 */
	public void setBtnName(String btnName) {
		this.btnName = btnName;
	}

	/**
	 * @retrun the btnType <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:12 <br>
	 */

	public String getBtnType() {
		return btnType;
	}

	/**
	 * @param btnType
	 *            the btnType to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:12
	 */
	public void setBtnType(String btnType) {
		this.btnType = btnType;
	}

	/**
	 * @retrun the actionUrls <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:12 <br>
	 */

	public String getActionUrls() {
		return actionUrls;
	}

	/**
	 * @param actionUrls
	 *            the actionUrls to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:12
	 */
	public void setActionUrls(String actionUrls) {
		this.actionUrls = actionUrls;
	}

	/**
	 * @retrun the deleteFlag <br>
	 * 
	 *         时间: 2013-6-20 上午11:40:12 <br>
	 */

	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag
	 *            the deleteFlag to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:40:12
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
