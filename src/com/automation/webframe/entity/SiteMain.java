/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.entity <br>
 * 文件名：SiteMain.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-上午11:13:10<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.entity;

import java.sql.Timestamp;

/**
 * 
 * 类名称：SiteMain <br>
 * 类描述：站点主类实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 上午11:13:10 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SiteMain extends BaseBean {

	/** 主键 */
	private Integer id;

	/** NULL网站简称 */
	private String name;

	/** 域名 不带http:// */
	private String domain;

	/** 网址连接 带http:// */
	private String link;

	/** 状态 0禁用 1可用 2审核中 */
	private Integer state;

	/** 创建时间 */
	private Timestamp createTime;

	/** 修改时间 */
	private Timestamp updateTime;

	/** NULL排序 */
	private Integer rank = 1;

	/** 图片URL */
	private String pic;

	/** 删除状态 0=未删除 1=删除 */
	private Integer deleted;

	/** 站点类型， 按","区分 */
	private String types;

	/** 类型id */
	private int[] typeIds = {};

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the name <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @retrun the domain <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public String getDomain() {
		return domain;
	}

	/**
	 * @param domain
	 *            the domain to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}

	/**
	 * @retrun the link <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public String getLink() {
		return link;
	}

	/**
	 * @param link
	 *            the link to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @retrun the state <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public Integer getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * @retrun the createTime <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @retrun the updateTime <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @retrun the rank <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public Integer getRank() {
		return rank;
	}

	/**
	 * @param rank
	 *            the rank to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}

	/**
	 * @retrun the pic <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public String getPic() {
		return pic;
	}

	/**
	 * @param pic
	 *            the pic to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

	/**
	 * @retrun the deleted <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public Integer getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	/**
	 * @retrun the types <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public String getTypes() {
		return types;
	}

	/**
	 * @param types
	 *            the types to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setTypes(String types) {
		this.types = types;
	}

	/**
	 * @retrun the typeIds <br>
	 * 
	 *         时间: 2013-6-20 上午11:16:19 <br>
	 */

	public int[] getTypeIds() {
		return typeIds;
	}

	/**
	 * @param typeIds
	 *            the typeIds to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:16:19
	 */
	public void setTypeIds(int[] typeIds) {
		this.typeIds = typeIds;
	}

}
