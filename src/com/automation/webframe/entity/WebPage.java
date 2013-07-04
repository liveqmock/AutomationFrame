/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.entity <br>
 * 文件名：WebPage.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-上午11:58:57<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.entity;

/**
 * 
 * 类名称：WebPage <br>
 * 类描述：站点页实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 上午11:58:57 <br>
 * 修改备注：TODO <br>
 * 
 */
public class WebPage extends BaseBean {

	/** 主键id */
	private Integer id;

	/** 页面名称 */
	private String name;

	/** 页面类型id web_type.id */
	private String typeid;

	/** 页面路径 */
	private String localPath;

	/** 页面标题 */
	private String title;

	/** 关键字 */
	private String keyword;

	/** 页面描述 */
	private String description;

	/** 删除状态 0=未删除，1=已删除 */
	private Integer deleted;

	/** 页面模板内容 */
	private String templateContent;

	/** 创建时间 */
	private java.sql.Timestamp createTime;

	/** 创建人 */
	private Integer createBy;

	/** 修改时间按 */
	private java.sql.Timestamp updateTime;

	/** 修改人 */
	private Integer updateBy;

	/**
	 * @retrun the id <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @retrun the name <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @retrun the typeid <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public String getTypeid() {
		return typeid;
	}

	/**
	 * @param typeid
	 *            the typeid to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	/**
	 * @retrun the localPath <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public String getLocalPath() {
		return localPath;
	}

	/**
	 * @param localPath
	 *            the localPath to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

	/**
	 * @retrun the title <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @retrun the keyword <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword
	 *            the keyword to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @retrun the description <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @retrun the deleted <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public Integer getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	/**
	 * @retrun the templateContent <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public String getTemplateContent() {
		return templateContent;
	}

	/**
	 * @param templateContent
	 *            the templateContent to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	/**
	 * @retrun the createTime <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @retrun the createBy <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public Integer getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy
	 *            the createBy to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	/**
	 * @retrun the updateTime <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @retrun the updateBy <br>
	 * 
	 *         时间: 2013-6-20 下午12:02:29 <br>
	 */

	public Integer getUpdateBy() {
		return updateBy;
	}

	/**
	 * @param updateBy
	 *            the updateBy to set <br>
	 * 
	 *            时间: 2013-6-20 下午12:02:29
	 */
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

}
