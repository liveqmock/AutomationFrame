/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.entity <br>
 * 文件名：BaseBean.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin <br>
 * 日期：2013-6-20-上午10:48:01 <br>
 * Copyright (c) 2013 赵增斌-版权所有 <br>
 *
 */
package com.automation.webframe.entity;

/**
 * 
 * 类名称：BaseBean <br>
 * 类描述：基础实体 包含两种状态枚举 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 上午10:55:07 <br>
 * 修改备注：TODO <br>
 * 
 */
public class BaseBean {

	/**
	 * 
	 * 类名称：STATE <br>
	 * 类描述：状态枚举 <br>
	 * 创建人：赵增斌 <br>
	 * 修改人：赵增斌 <br>
	 * 修改时间：2013-6-20 上午10:57:55 <br>
	 * 修改备注：TODO <br>
	 * 
	 */
	public static enum STATE {
		ENABLE(0, "可用"), DISABLE(1, "禁用");
		public int key;
		public String value;

		/**
		 * 标题：构造器 <br>
		 * 描述：TODO <br>
		 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-6-20 上午10:58:24 <br>
		 * 
		 * @param key
		 * @param value
		 * <br>
		 */
		private STATE(int key, String value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * 方法：get <br>
		 * 描述：通过枚举key获取枚举 <br>
		 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-6-20 上午10:58:30 <br>
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
	}

	/**
	 * 
	 * 
	 * @author lu
	 * 
	 */
	/**
	 * 
	 * 类名称：DELETED <br>
	 * 类描述：删除枚举 <br>
	 * 创建人：赵增斌 <br>
	 * 修改人：赵增斌 <br>
	 * 修改时间：2013-6-20 上午10:59:52 <br>
	 * 修改备注：TODO <br>
	 * 
	 */
	public static enum DELETED {
		NO(0, "未删除"), YES(1, "已删除");
		public int key;
		public String value;

		/**
		 * 标题：构造器 <br>
		 * 描述：TODO <br>
		 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-6-20 上午11:00:14 <br>
		 * 
		 * @param key
		 * @param value
		 */
		private DELETED(int key, String value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * 方法：get <br>
		 * 描述：通过枚举key获取枚举 <br>
		 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-6-20 上午11:00:19 <br>
		 * 
		 * @param key
		 * @return
		 */
		public static DELETED get(int key) {
			DELETED[] values = DELETED.values();
			for (DELETED object : values) {
				if (object.key == key) {
					return object;
				}
			}
			return null;
		}
	}
}
