/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.entity <br>
 * 文件名：SysConfig.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-下午2:50:20<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.entity;

import com.automation.webframe.entity.BaseBean.STATE;

/**
 * 
 * 类名称：SysConfig <br>
 * 类描述：系统配置实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 下午2:50:20 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SysConfig {
	/**
	 * 
	 * 类名称：SQL <br>
	 * 类描述：sql类型 <br>
	 * 创建人：赵增斌 <br>
	 * 修改人：赵增斌 <br>
	 * 修改时间：2013-6-20 下午2:58:22 <br>
	 * 修改备注：TODO <br>
	 * 
	 */
	public static enum SQL {
		oracle(1, "oracle"), mysql(1, "mysql");
		public int key;

		public String value;

		/**
		 * 标题：构造器 <br>
		 * 描述：TODO <br>
		 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-6-20 下午3:06:16 <br>
		 * 
		 * @param key
		 * @param value
		 */
		private SQL(int key, String value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * 方法：get <br>
		 * 描述：通过枚举key获取枚举 <br>
		 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-6-20 下午3:06:20 <br>
		 * 
		 * @param key
		 * @return
		 */
		public static STATE get(int key) {
			STATE[] values = STATE.values();
			for (STATE object : values) {
				if (object.key == key) {
					return object;
				}
			}
			return null;
		}

		/**
		 * @retrun the key <br>
		 * 
		 *         时间: 2013-6-20 下午3:11:07 <br>
		 */

		public int getKey() {
			return key;
		}

		/**
		 * @param key
		 *            the key to set <br>
		 * 
		 *            时间: 2013-6-20 下午3:11:07
		 */
		public void setKey(int key) {
			this.key = key;
		}

		/**
		 * @retrun the value <br>
		 * 
		 *         时间: 2013-6-20 下午3:11:07 <br>
		 */

		public String getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set <br>
		 * 
		 *            时间: 2013-6-20 下午3:11:07
		 */
		public void setValue(String value) {
			this.value = value;
		}

	}
}
