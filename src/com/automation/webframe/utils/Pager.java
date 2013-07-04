/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.utils <br>
 * 文件名：Pager.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-下午2:35:23<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.utils;

import com.automation.webframe.entity.SysConfig;

/**
 * 
 * 类名称：Pager <br>
 * 类描述：分页实体类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 下午2:35:23 <br>
 * 修改备注：TODO <br>
 * 
 */
public class Pager {

	/** 当前页 */
	private int pageId = 1;

	/** 总行数 */
	private int rowCount = 0;

	/** 页大小 */
	private int pageSize = 10;

	/** 总页数 */
	private int pageCount = 0;

	/** 当前页起始记录 */
	private int pageOffset = 0;

	/** 当前页到达的记录 */
	private int pageTail = 0;

	/** 排序字段 */
	private String orderField;

	/** 排序条件 */
	private boolean orderDirection;

	/** 页面显示分页按钮个数 */
	private int length = 6;

	/** 开始分页数字 */
	private int startIndex = 0;

	/** 结束分页数字 */
	private int endIndex = 0;

	private int[] indexs;

	/** 进行分页类型 */
	private static String DO_PAGE_TYPE = "oracle";

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-20 下午2:41:09 <br>
	 */
	public Pager() {
		this.orderDirection = true;
	}

	// int pid = navigate.getPageId() ; //当前页
	// int pcount = navigate.getPageCount(); //总页数
	// int length=8; //共显示几个分页数字
	// int startIndex = pid - (length/2);
	// int endIndex = 0;
	// if( startIndex < 1){
	// startIndex = 1;
	// }
	// endIndex = (startIndex+length) <= pcount ? (startIndex+length) : pcount;

	/**
	 * @retrun the length <br>
	 * 
	 *         时间: 2013-6-20 下午2:38:51 <br>
	 */

	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set <br>
	 * 
	 *            时间: 2013-6-20 下午2:38:51
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @retrun the indexs <br>
	 * 
	 *         时间: 2013-6-20 下午2:39:31 <br>
	 */

	public int[] getIndexs() {
		int len = getEndIndex() - getStartIndex() + 1;
		indexs = new int[len];
		for (int i = 0; i < len; i++) {
			indexs[i] = (getStartIndex() + i);
		}
		return indexs;
	}

	/**
	 * @param indexs
	 *            the indexs to set <br>
	 * 
	 *            时间: 2013-6-20 下午2:39:31
	 */
	public void setIndexs(int[] indexs) {
		this.indexs = indexs;
	}

	/**
	 * @retrun the startIndex <br>
	 * 
	 *         时间: 2013-6-20 下午2:40:33 <br>
	 */

	public int getStartIndex() {
		startIndex = pageId - (length / 2);
		if (startIndex < 1) {
			startIndex = 1;
		}
		return startIndex;
	}

	/**
	 * @param startIndex
	 *            the startIndex to set <br>
	 * 
	 *            时间: 2013-6-20 下午2:40:33
	 */
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	/**
	 * @retrun the endIndex <br>
	 * 
	 *         时间: 2013-6-20 下午2:40:58 <br>
	 */

	public int getEndIndex() {
		if (getStartIndex() < 1) {
			setStartIndex(1);
		}
		endIndex = (getStartIndex() + length) <= getPageCount() ? (getStartIndex() + length)
				: getPageCount();
		return endIndex;
	}

	/**
	 * @param endIndex
	 *            the endIndex to set <br>
	 * 
	 *            时间: 2013-6-20 下午2:40:58
	 */
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	/**
	 * 方法：doPage <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-20 下午2:41:31 <br>
	 */
	protected void doPage() {
		this.pageCount = this.rowCount / this.pageSize + 1;
		// 如果模板==0，且总数大于1，则减一
		if ((this.rowCount % this.pageSize == 0) && pageCount > 1)
			this.pageCount--;

		if (DO_PAGE_TYPE.equalsIgnoreCase(SysConfig.SQL.oracle.getValue())) {
			// 如果输入也页面编号（pageId）大于总页数，将pageId设置为pageCount;
			if (this.pageId > this.pageCount)
				this.pageId = this.pageCount;
			this.pageOffset = (this.pageId - 1) * this.pageSize + 1;
			this.pageTail = this.pageOffset + this.pageSize - 1;
		} else if (DO_PAGE_TYPE
				.equalsIgnoreCase(SysConfig.SQL.mysql.getValue())) {
			// Mysql 算法
			this.pageOffset = (this.pageId - 1) * this.pageSize;
			this.pageTail = this.pageOffset + this.pageSize;
			if ((this.pageOffset + this.pageSize) > this.rowCount) {
				this.pageTail = this.rowCount;
			}
		}
	}

	/**
	 * 方法：getOrderCondition <br>
	 * 描述：获取排序条件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-20 下午3:40:32 <br>
	 * 
	 * @return
	 */
	public String getOrderCondition() {
		String condition = "";
		if (this.orderField != null && this.orderField.length() != 0) {
			condition = " order by " + orderField
					+ (orderDirection ? " " : " desc ");
		}
		return condition;
	}

	/**
	 * 方法：getMysqlQueryCondition <br>
	 * 描述：获取mysql排序查询条件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-20 下午3:41:07 <br>
	 * 
	 * @return
	 */
	public String getMysqlQueryCondition() {
		String condition = "";
		condition = " limit " + pageOffset + "," + pageSize;
		return condition;
	}

	/**
	 * @retrun the pageId <br>
	 * 
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public int getPageId() {
		return pageId;
	}

	/**
	 * @param pageId
	 *            the pageId to set <br>
	 * 
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	/**
	 * @retrun the rowCount <br>
	 * 
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public int getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount
	 *            the rowCount to set <br>
	 * 
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @retrun the pageSize <br>
	 * 
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set <br>
	 * 
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @retrun the pageCount <br>
	 * 
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public int getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount
	 *            the pageCount to set <br>
	 * 
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @retrun the pageOffset <br>
	 * 
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public int getPageOffset() {
		return pageOffset;
	}

	/**
	 * @param pageOffset
	 *            the pageOffset to set <br>
	 * 
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	/**
	 * @retrun the pageTail <br>
	 * 
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public int getPageTail() {
		return pageTail;
	}

	/**
	 * @param pageTail
	 *            the pageTail to set <br>
	 * 
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setPageTail(int pageTail) {
		this.pageTail = pageTail;
	}

	/**
	 * @retrun the orderField <br>
	 * 
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public String getOrderField() {
		return orderField;
	}

	/**
	 * @param orderField
	 *            the orderField to set <br>
	 * 
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	/**
	 * @retrun the orderDirection <br>
	 * 
	 *         时间: 2013-6-20 下午3:41:49 <br>
	 */

	public boolean isOrderDirection() {
		return orderDirection;
	}

	/**
	 * @param orderDirection
	 *            the orderDirection to set <br>
	 * 
	 *            时间: 2013-6-20 下午3:41:49
	 */
	public void setOrderDirection(boolean orderDirection) {
		this.orderDirection = orderDirection;
	}

}
