/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.entity <br>
 * 文件名：SiteScore.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-上午11:17:19<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.entity;

/**
 * 
 * 类名称：SiteScore <br>
 * 类描述：站点积分相关实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 上午11:17:19 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SiteScore extends BaseBean {

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
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-20 上午11:17:50 <br>
	 */
	public SiteScore() {

	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-20 上午11:17:55 <br>
	 * 
	 * @param siteId
	 * @param viewNum
	 * @param likeNum
	 * @param shareNum
	 * @param clickNum
	 * @param collectNum
	 * @param commentNum
	 */
	public SiteScore(Integer siteId, Integer viewNum, Integer likeNum,
			Integer shareNum, Integer clickNum, Integer collectNum,
			Integer commentNum) {
		super();
		this.siteId = siteId;
		this.viewNum = viewNum;
		this.likeNum = likeNum;
		this.shareNum = shareNum;
		this.clickNum = clickNum;
		this.collectNum = collectNum;
		this.commentNum = commentNum;
	}

	/**
	 * 
	 * 类名称：ScoreType <br>
	 * 类描述：积分类型枚举类 <br>
	 * 创建人：赵增斌 <br>
	 * 修改人：赵增斌 <br>
	 * 修改时间：2013-6-20 上午11:19:19 <br>
	 * 修改备注：TODO <br>
	 * 
	 */
	public static enum ScoreType {
		VIEW(1, "viewNum"), LIKE(2, "likeNum"), SHARE(1, "shareNum"), CLICK(2,
				"clickNum"), COLLECT(1, "collectNum"), COMMENT(2, "commentNum");
		public int key;
		public String value;

		/**
		 * 标题：构造器 <br>
		 * 描述：TODO <br>
		 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-6-20 上午11:19:34 <br>
		 * 
		 * @param key
		 * @param value
		 */
		private ScoreType(int key, String value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * 方法：get <br>
		 * 描述：通过枚举key获取枚举 <br>
		 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
		 * weibo:http://weibo.com/zhaozengbin <br>
		 * 日期： 2013-6-20 上午11:19:37 <br>
		 * 
		 * @param key
		 * @return
		 */
		public static ScoreType get(int key) {
			ScoreType[] values = ScoreType.values();
			for (ScoreType object : values) {
				if (object.key == key) {
					return object;
				}
			}
			return null;
		}
	}

	/**
	 * @retrun the siteId <br>
	 * 
	 *         时间: 2013-6-20 上午11:19:58 <br>
	 */

	public Integer getSiteId() {
		return siteId;
	}

	/**
	 * @param siteId
	 *            the siteId to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:19:58
	 */
	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}

	/**
	 * @retrun the viewNum <br>
	 * 
	 *         时间: 2013-6-20 上午11:19:58 <br>
	 */

	public Integer getViewNum() {
		return viewNum;
	}

	/**
	 * @param viewNum
	 *            the viewNum to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:19:58
	 */
	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}

	/**
	 * @retrun the likeNum <br>
	 * 
	 *         时间: 2013-6-20 上午11:19:58 <br>
	 */

	public Integer getLikeNum() {
		return likeNum;
	}

	/**
	 * @param likeNum
	 *            the likeNum to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:19:58
	 */
	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}

	/**
	 * @retrun the shareNum <br>
	 * 
	 *         时间: 2013-6-20 上午11:19:58 <br>
	 */

	public Integer getShareNum() {
		return shareNum;
	}

	/**
	 * @param shareNum
	 *            the shareNum to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:19:58
	 */
	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}

	/**
	 * @retrun the clickNum <br>
	 * 
	 *         时间: 2013-6-20 上午11:19:58 <br>
	 */

	public Integer getClickNum() {
		return clickNum;
	}

	/**
	 * @param clickNum
	 *            the clickNum to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:19:58
	 */
	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	/**
	 * @retrun the collectNum <br>
	 * 
	 *         时间: 2013-6-20 上午11:19:58 <br>
	 */

	public Integer getCollectNum() {
		return collectNum;
	}

	/**
	 * @param collectNum
	 *            the collectNum to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:19:58
	 */
	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}

	/**
	 * @retrun the commentNum <br>
	 * 
	 *         时间: 2013-6-20 上午11:19:58 <br>
	 */

	public Integer getCommentNum() {
		return commentNum;
	}

	/**
	 * @param commentNum
	 *            the commentNum to set <br>
	 * 
	 *            时间: 2013-6-20 上午11:19:58
	 */
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

}
