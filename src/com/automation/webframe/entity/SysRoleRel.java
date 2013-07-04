/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.entity <br>
 * 文件名：SysRoleRel.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-上午11:45:04<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.entity;

/**
 * 
 * 类名称：SysRoleRel <br>
 * 类描述：系统角色关联实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 上午11:45:04 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysRoleRel extends BaseBean {

	/** 角色主键 sys_role.id */
	private Integer roleId;

	/** 关联主键 type=0管理sys_menu.id, type=1关联sys_user.id */
	private Integer objId;

	/** 关联类型 0=菜单,1=用户 */
	private Integer relType;

	/**
	 * 
	 * 类名称：RelType <br>
	 * 类描述：角色类型枚举类 <br>
	 * 创建人：赵增斌 <br>
	 * 修改人：赵增斌 <br>
	 * 修改时间：2013-6-20 上午11:47:20 <br>
	 * 修改备注：TODO <br>
	 * 
	 */
	public static enum RelType {
		MENU(0, "菜单"), USER(1, "用户"), BTN(2, "按钮");
		public int key;
		public String value;

		/**
		 * 标题：构造器 <br>
		 * 描述：TODO <br>
		 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-6-20 上午11:47:37 <br>
		 * 
		 * @param key
		 * @param value
		 */
		private RelType(int key, String value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * 方法：get <br>
		 * 描述：通过枚举key获取枚举 <br>
		 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-6-20 上午11:48:05 <br>
		 * 
		 * @param key
		 * @return
		 */
		public static RelType get(int key) {
			RelType[] values = RelType.values();
			for (RelType object : values) {
				if (object.key == key) {
					return object;
				}
			}
			return null;
		}
	}

	/**
	 * @retrun the roleId <br>
	 * 
	 *         时间: 2013-6-20 上午11:48:17 <br>
	 */

	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:48:17
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @retrun the objId <br>
	 * 
	 *         时间: 2013-6-20 上午11:48:17 <br>
	 */

	public Integer getObjId() {
		return objId;
	}

	/**
	 * @param objId
	 *            the objId to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:48:17
	 */
	public void setObjId(Integer objId) {
		this.objId = objId;
	}

	/**
	 * @retrun the relType <br>
	 * 
	 *         时间: 2013-6-20 上午11:48:17 <br>
	 */

	public Integer getRelType() {
		return relType;
	}

	/**
	 * @param relType
	 *            the relType to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:48:17
	 */
	public void setRelType(Integer relType) {
		this.relType = relType;
	}

}
