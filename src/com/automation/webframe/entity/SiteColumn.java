/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.entity <br>
 * 文件名：SiteColumn.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-上午11:05:21<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.entity;

/**
 * 
 * 类名称：SiteColumn <br>
 * 类描述：站点栏目实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 上午11:05:21 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SiteColumn extends BaseBean {

	/** 主键id */
	private Integer id;

	/** 站点id 管理site_main.id */
	private Integer siteId;

	/** 栏目名称 */
	private String name;

	/** 连接地址 */
	private String link;

	/** 图片地址 */
	private String pic;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-6-20 上午11:11:29 <br>
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:11:29
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the siteId <br>
	 * 
	 *         时间: 2013-6-20 上午11:11:29 <br>
	 */

	public Integer getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId
	 *            the siteId to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:11:29
	 */
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	/**
	 * @retrun the name <br>
	 * 
	 *         时间: 2013-6-20 上午11:11:29 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:11:29
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @retrun the link <br>
	 * 
	 *         时间: 2013-6-20 上午11:11:29 <br>
	 */

	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:11:29
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @retrun the pic <br>
	 * 
	 *         时间: 2013-6-20 上午11:11:29 <br>
	 */

	public String getPic() {
		return pic;
	}

	/**
	 * @param pic
	 *            the pic to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:11:29
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

}
