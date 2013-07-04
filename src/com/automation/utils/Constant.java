/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.utils <br>
 * 文件名：Constant.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午3:08:35<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.utils;

import java.util.ResourceBundle;

/**
 * 
 * 类名称：Constant <br>
 * 类描述：常量类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午3:08:35 <br>
 * 修改备注：TODO <br>
 * 
 */
public class Constant {

	private static ResourceBundle res = ResourceBundle.getBundle("sysconfig");

	/** 网站名称 */
	public static String SSI_WEBSITE_NAME = res.getString("ssi.website.name");

	/** 网站域名 */
	public static String SSI_WEBSITE_DOMAIN = res
			.getString("ssi.website.domain");

	/** 网站地址 */
	public static String SSI_WEBSITE_URL = res.getString("ssi.website.url");

	/** 项目根路径 线上是tomcat的，本地可以配成工作空间项目 */
	public static String WORK_ROOT_PATH = res.getString("work.root.path");

	/** 模板根目录 */
	public static String WORK_TEMPLATE_PATH = res
			.getString("work.template.path");

	/** 上传根目录地址 http://image.mn606.com/ */
	public static String UPLOAD_URL = res.getString("upload.url");

	/** 搜索的域名 */
	public static String SEARCH_URL = res.getString("search.url");

	/** lookmn的域名 */
	public static String LOOK_URL = res.getString("look.url");

	/** 搜索图片过滤分数0.0-.1.0之间的小数 */
	public static String SEARCH_SCORE = res.getString("search.score");

	/** 上传路径 */
	public static String UPLOAD_PATH = res.getString("upload.path");

	/** 上传图片大小 */
	public static String UPLOAD_PIC_SIZE = res.getString("upload.pic.size");

	/** 所以文件存放根目录 */
	public static String INDEX_BASE_DIR = res.getString("index.base.dir");

	/**
	 * 
	 * 类名称：SuperAdmin <br>
	 * 类描述：超级管理员常量 <br>
	 * 创建人：赵增斌 <br>
	 * 修改人：赵增斌 <br>
	 * 修改时间：2013-6-21 下午3:11:18 <br>
	 * 修改备注：TODO <br>
	 * 
	 */
	public static enum SuperAdmin {
		NO(0, "否"), YES(1, "是");
		public int key;
		public String value;

		private SuperAdmin(int key, String value) {
			this.key = key;
			this.value = value;
		}

		public static SuperAdmin get(int key) {
			SuperAdmin[] values = SuperAdmin.values();
			for (SuperAdmin object : values) {
				if (object.key == key) {
					return object;
				}
			}
			return null;
		}
	}

}
