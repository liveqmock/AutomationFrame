/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.vo <br>
 * 文件名：SysMenuBtnModel.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-下午6:02:56<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.vo;

/**
 * 
 * 类名称：SysMenuBtnModel <br>
 * 类描述：系统菜单按钮模型 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 下午6:02:56 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysMenuBtnModel extends BaseModel {

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

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-6-20 下午6:04:21 <br>
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-6-20 下午6:04:21
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the menuid <br>
	 * 
	 *         时间: 2013-6-20 下午6:04:21 <br>
	 */

	public Integer getMenuid() {
		return menuid;
	}

	/**
	 * @param menuid
	 *            the menuid to set <br>
	 * 
	 *            时间: 2013-6-20 下午6:04:21
	 */
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	/**
	 * @retrun the btnName <br>
	 * 
	 *         时间: 2013-6-20 下午6:04:21 <br>
	 */

	public String getBtnName() {
		return btnName;
	}

	/**
	 * @param btnName
	 *            the btnName to set <br>
	 * 
	 *            时间: 2013-6-20 下午6:04:21
	 */
	public void setBtnName(String btnName) {
		this.btnName = btnName;
	}

	/**
	 * @retrun the btnType <br>
	 * 
	 *         时间: 2013-6-20 下午6:04:21 <br>
	 */

	public String getBtnType() {
		return btnType;
	}

	/**
	 * @param btnType
	 *            the btnType to set <br>
	 * 
	 *            时间: 2013-6-20 下午6:04:21
	 */
	public void setBtnType(String btnType) {
		this.btnType = btnType;
	}

	/**
	 * @retrun the actionUrls <br>
	 * 
	 *         时间: 2013-6-20 下午6:04:21 <br>
	 */

	public String getActionUrls() {
		return actionUrls;
	}

	/**
	 * @param actionUrls
	 *            the actionUrls to set <br>
	 * 
	 *            时间: 2013-6-20 下午6:04:21
	 */
	public void setActionUrls(String actionUrls) {
		this.actionUrls = actionUrls;
	}

}
