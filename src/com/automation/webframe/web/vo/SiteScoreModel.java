/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.vo <br>
 * 文件名：SiteScoreModel.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-下午5:38:33<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.vo;

/**
 * 
 * 类名称：SiteScoreModel <br>
 * 类描述：站点积分相关实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 下午5:38:33 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SiteScoreModel extends BaseModel {

	/** 站点id 管理site_main.id */
	private Integer siteId;

	/** 浏览次数 */
	private Integer viewNum;

	/** 喜欢数量 */
	private Integer likeNum;

	/** 分享次数 */
	private Integer shareNum;

	/** 点击次数 */
	private Integer clickNum;

	/** 收藏总数 */
	private Integer collectNum;

	/** 评论总数 */
	private Integer commentNum;

	/**
	 * @retrun the siteId <br>
	 * 
	 *         时间: 2013-6-20 下午5:40:09 <br>
	 */

	public Integer getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId
	 *            the siteId to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:40:09
	 */
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	/**
	 * @retrun the viewNum <br>
	 * 
	 *         时间: 2013-6-20 下午5:40:09 <br>
	 */

	public Integer getViewNum() {
		return viewNum;
	}

	/**
	 * @param viewNum
	 *            the viewNum to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:40:09
	 */
	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}

	/**
	 * @retrun the likeNum <br>
	 * 
	 *         时间: 2013-6-20 下午5:40:09 <br>
	 */

	public Integer getLikeNum() {
		return likeNum;
	}

	/**
	 * @param likeNum
	 *            the likeNum to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:40:09
	 */
	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}

	/**
	 * @retrun the shareNum <br>
	 * 
	 *         时间: 2013-6-20 下午5:40:09 <br>
	 */

	public Integer getShareNum() {
		return shareNum;
	}

	/**
	 * @param shareNum
	 *            the shareNum to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:40:09
	 */
	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}

	/**
	 * @retrun the clickNum <br>
	 * 
	 *         时间: 2013-6-20 下午5:40:09 <br>
	 */

	public Integer getClickNum() {
		return clickNum;
	}

	/**
	 * @param clickNum
	 *            the clickNum to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:40:09
	 */
	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	/**
	 * @retrun the collectNum <br>
	 * 
	 *         时间: 2013-6-20 下午5:40:09 <br>
	 */

	public Integer getCollectNum() {
		return collectNum;
	}

	/**
	 * @param collectNum
	 *            the collectNum to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:40:09
	 */
	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}

	/**
	 * @retrun the commentNum <br>
	 * 
	 *         时间: 2013-6-20 下午5:40:09 <br>
	 */

	public Integer getCommentNum() {
		return commentNum;
	}

	/**
	 * @param commentNum
	 *            the commentNum to set <br>
	 * 
	 *            时间: 2013-6-20 下午5:40:09
	 */
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

}
