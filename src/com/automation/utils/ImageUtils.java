/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.utils <br>
 * 文件名：ImageUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-上午9:44:38<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.utils;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 
 * 类名称：ImageUtils <br>
 * 类描述：图片工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 上午9:44:38 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ImageUtils {

	/** 宽度 */
	private int width;

	/** 高度 */
	private int height;

	/**
	 * 标题：构造器 <br>
	 * 描述：计算出网络图片的宽 高 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:45:50 <br>
	 * 
	 * @param picUrl
	 * @throws Exception
	 */
	public ImageUtils(String picUrl) throws Exception {
		InputStream input = null;
		try {
			input = JMagickUtils.Utils.ofUrl(picUrl, picUrl).getInput();
			size(input);
		} catch (Exception e) {
			// System.out.println("出现异常："+picUrl);
			input = JMagickUtils.Utils.ofUrl(picUrl).getInput();
			size(input);
		}

	}

	/**
	 * 标题：构造器 <br>
	 * 描述：计算出InputStream图片的宽高 <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:46:02 <br>
	 * 
	 * @param input
	 * @throws Exception
	 */
	public ImageUtils(InputStream input) throws Exception {
		size(input);
	}

	/**
	 * 方法：size <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:46:41 <br>
	 * 
	 * @param input
	 * @throws Exception
	 */
	private void size(InputStream input) throws Exception {
		BufferedImage image = null;
		try {
			image = ImageIO.read(input);
			width = image.getWidth();
			height = image.getHeight();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			input = null; // 清理内存
			image = null; // 清理内存
		}
	}

	/**
	 * 方法：getMinHeight <br>
	 * 描述： 返回 计算出缩略图的高度 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:46:47 <br>
	 * 
	 * @return
	 */
	public int getMinHeight() {
		int h = 0, target_width = 200;
		h = (int) Math.round((height * target_width * 1.0 / width));
		return h;
	}

	/**
	 * @retrun the width <br>
	 * 
	 *         时间: 2013-6-24 上午9:47:07 <br>
	 */

	public int getWidth() {
		return width;
	}

	/**
	 * @retrun the height <br>
	 * 
	 *         时间: 2013-6-24 上午9:47:07 <br>
	 */

	public int getHeight() {
		return height;
	}

}
