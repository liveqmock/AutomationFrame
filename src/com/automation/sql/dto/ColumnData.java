/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.sql.dto <br>
 * 文件名：ColumnData.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午2:39:39<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.sql.dto;

/**
 * 
 * 类名称：ColumnData <br>
 * 类描述：表字段类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午2:39:39 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ColumnData {

	/** 字段名称 */
	private String columnName;

	/** 数据类型 */
	private String dataType;

	/** 字段备注 */
	private String columnComment;

	/** 数据库类型 */
	private String jdbcType;

	/**  */
	private Integer scale;

	/**
	 * @retrun the scale <br>
	 * 
	 *         时间: 2013-6-24 下午1:22:01 <br>
	 */

	public Integer getScale() {
		return scale;
	}

	/**
	 * @param scale
	 *            the scale to set <br>
	 * 
	 *            时间: 2013-6-24 下午1:22:01
	 */
	public void setScale(Integer scale) {
		this.scale = scale;
	}

	/**
	 * @retrun the jdbcType <br>
	 * 
	 *         时间: 2013-6-24 下午12:27:16 <br>
	 */

	public String getJdbcType() {
		return jdbcType;
	}

	/**
	 * @param jdbcType
	 *            the jdbcType to set <br>
	 * 
	 *            时间: 2013-6-24 下午12:27:16
	 */
	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	/**
	 * @retrun the columnName <br>
	 * 
	 *         时间: 2013-6-21 下午2:40:26 <br>
	 */

	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName
	 *            the columnName to set <br>
	 * 
	 *            时间: 2013-6-21 下午2:40:26
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @retrun the dataType <br>
	 * 
	 *         时间: 2013-6-21 下午2:40:26 <br>
	 */

	public String getDataType() {
		return dataType;
	}

	/**
	 * @param dataType
	 *            the dataType to set <br>
	 * 
	 *            时间: 2013-6-21 下午2:40:26
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @retrun the columnComment <br>
	 * 
	 *         时间: 2013-6-21 下午2:40:26 <br>
	 */

	public String getColumnComment() {
		return columnComment;
	}

	/**
	 * @param columnComment
	 *            the columnComment to set <br>
	 * 
	 *            时间: 2013-6-21 下午2:40:26
	 */
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

}
