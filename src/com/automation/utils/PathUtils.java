/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.utils <br>
 * 文件名：PathUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-上午9:54:05<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * 
 * 类名称：PathUtils <br>
 * 类描述：详细的功能描述 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 上午9:54:05 <br>
 * 修改备注：TODO <br>
 * 
 */
public class PathUtils {

	private static Logger log = Logger.getLogger(PathUtils.class);

	/**
	 * 方法：getRootPath <br>
	 * 描述：获取项目部署所在根目录 如：F:\openwork\mn606\WebRoot <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:54:30 <br>
	 * 
	 * @return
	 */
	public static String getRootPath() {

		// String rootPath ="";
		// try{
		// File file = new File(PathUtil.class.getResource("/").getFile());
		// rootPath = file.getParentFile().getParent();
		// rootPath = java.net.URLDecoder.decode(rootPath,"utf-8");
		// return rootPath;
		// }catch(Exception e){
		// e.printStackTrace();
		// }
		return Constant.WORK_ROOT_PATH;
	}

	/**
	 * 方法：getBasePath <br>
	 * 描述：主站项目路径 http://www.yy606.com/ <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:54:38 <br>
	 * 
	 * @return
	 */
	public static String getBasePath() {
		String str = Constant.SSI_WEBSITE_URL;
		if (StringUtils.isNotBlank(str)) {
			try {
				return URLDecoder.decode(str, "utf-8");
			} catch (UnsupportedEncodingException e) {
				log.error("获取根路径异常：", e);
			}
		}
		return str;
	}

	/**
	 * 方法：getBasePath <br>
	 * 描述：主站项目路径 http://www.yy606.com/ <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:54:48 <br>
	 * 
	 * @param patth
	 * @return
	 */
	public static String getBasePath(String patth) {
		return getBasePath() + patth;
	}

	/**
	 * 方法：classifyUrl <br>
	 * 描述：获取分类的URL <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:54:56 <br>
	 * 
	 * @param classifyId
	 *            分类id
	 * @param pageId
	 *            分页编号
	 * @return http://localhost:8080/mn606/classify/2012061009115579058-1.html
	 */
	public static String classifyUrl(Long classifyId, Integer pageId) {
		if (pageId == null || pageId < 1) {
			pageId = 1;
		}
		StringBuffer url = new StringBuffer(getBasePath());
		// 判断分类id是否为空
		if (classifyId != null && classifyId > 1) {
			url.append("classify/").append(classifyId).append("-");
		} else {
			url.append("list/");
		}
		url.append(pageId).append(".html");
		return url.toString();
	}

	/**
	 * 方法：albumUrl <br>
	 * 描述：获取相册的URL <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:55:18 <br>
	 * 
	 * @param albumId
	 *            相册Id
	 * @param pageId
	 *            分页编号
	 * @return http://localhost:8080/mn606/album/2012061009115579058-1.html
	 */
	public static String albumUrl(Long albumId, Integer pageId) {
		if (pageId == null || pageId < 1) {
			pageId = 1;
		}
		StringBuffer url = new StringBuffer(getBasePath());
		url.append("album/").append(albumId);
		url.append("-").append(pageId).append(".html");
		return url.toString();
	}

	/**
	 * 方法：picPageUrl <br>
	 * 描述：图片详细页面的URL <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:55:34 <br>
	 * 
	 * @param picId
	 *            页面
	 * @return http://localhost:8080/mn606/pic/2012061723135819196.html
	 */
	public static String picPageUrl(Long picId) {
		StringBuffer url = new StringBuffer(getBasePath());
		url.append("pic/").append(picId).append(".html");
		return url.toString();
	}

	/**
	 * 方法：messageUrl <br>
	 * 描述：留言墙的URL <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:55:49 <br>
	 * 
	 * @param pageId
	 *            页面
	 * @return http://localhost:8080/mn606/message/1.html
	 */
	public static String messageUrl(Integer pageId) {
		StringBuffer url = new StringBuffer(getBasePath());
		url.append("message/");
		if (pageId > 1) {
			url.append(pageId).append(".html");
		}
		return url.toString();
	}

	/**
	 * 方法：getImageBaseURL <br>
	 * 描述：获取图片根路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:56:05 <br>
	 * 
	 * @return http://image.ssi.com/upload/image/
	 */
	public static String getImageBaseURL() {
		return Constant.UPLOAD_URL;
		// return null;
	}

	/**
	 * 方法：pic <br>
	 * 描述：获取图片URL 加上域名 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:56:22 <br>
	 * 
	 * @param picUrl
	 *            数据库picUrl字段内容，不带域名
	 * @return
	 */
	public static String pic(String picUrl) {
		if (StringUtils.isNotBlank(picUrl)) {
			// 将"\"替换成"/"
			picUrl = picUrl.replaceAll("\\\\", "/");
			return PathUtils.getImageURL(picUrl);
		}
		return "";
	}

	/**
	 * 方法：minPic <br>
	 * 描述：获取图片URL 加上域名 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:56:37 <br>
	 * 
	 * @param picUrl
	 *            数据库picUrl字段内容，不带域名
	 * @param size
	 *            图片尺寸 格式：50_50 具体规格请查看配置文件appkey.properties
	 * @return
	 */
	public static String minPic(String picUrl, String size) {
		if (StringUtils.isNotBlank(size)) {
			picUrl = PathUtils.minPicPath(picUrl, size);
		}
		return pic(picUrl);
	}

	/**
	 * 方法：getImageURL <br>
	 * 描述：图片路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:56:57 <br>
	 * 
	 * @param picUrl
	 * @return 返回图片路径 http://image.ssi.com/upload/image/photo/1111.jpg
	 */
	public static String getImageURL(String picUrl) {
		if (picUrl.indexOf("http://") < 0) {
			return getImageBaseURL() + picUrl;
		}
		return picUrl;
	}

	/**
	 * 方法：uploadPicPath <br>
	 * 描述：获取上传图片路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:57:11 <br>
	 * 
	 * @param fileName
	 *            文件名称 2012061717081386488.jpg
	 * @param sizeDir
	 *            尺寸目录 格式:100_100 原图:ori
	 * @return \images\2012\06\17\100_100\1111.jpg
	 */
	public static String uploadPicPath(String fileName, String sizeDir) {
		Date now = new Date(); // 当前日期
		StringBuffer path = new StringBuffer();
		// path.append(Constant.UPLOAD_PATH); //上传根目录
		path.append("images").append(File.separatorChar);// 图片根目录
		path.append(DateUtils.convertDateToYear(now))
				.append(File.separatorChar); // 年
												// 2012
		path.append(DateUtils.convertDateToMonth(now)).append(
				File.separatorChar); // 月 06
		path.append(DateUtils.convertDateToDay(now)).append(File.separatorChar); // 日
																					// 17
		path.append(sizeDir).append(File.separatorChar); // 图片
		path.append(fileName);
		return path.toString();
	}

	/**
	 * 方法：uploadPath <br>
	 * 描述：获取上传图片路径 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:57:33 <br>
	 * 
	 * @param fileName
	 *            文件名称 2012061717081386488.jpg
	 * @param dir
	 *            尺寸目录 格式:100_100 原图:ori
	 * @param sizeDir
	 *            \images\2012\06\17\100_100\1111.jpg
	 * @return
	 */
	public static String uploadPath(String fileName, String dir, String sizeDir) {
		Date now = new Date(); // 当前日期
		StringBuffer path = new StringBuffer();
		path.append(Constant.UPLOAD_PATH); // 上传根目录
		path.append(dir).append(File.separatorChar);// 图片根目录
		path.append(DateUtils.convertDateToYear(now))
				.append(File.separatorChar); // 年
												// 2012
		path.append(DateUtils.convertDateToMonth(now)).append(
				File.separatorChar); // 月 06
		path.append(DateUtils.convertDateToDay(now)).append(File.separatorChar); // 日
																					// 17
		path.append(sizeDir).append(File.separatorChar); // 图片
		path.append(fileName);
		return path.toString();
	}

	/**
	 * 方法：minPicPath <br>
	 * 描述：获取小图，将路径中ori 替换成指定 尺寸目录 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:57:54 <br>
	 * 
	 * @param picPath
	 *            \images\2012\06\17\ori\2012061717081386488.jpg
	 * @param sizeDir
	 *            200_200
	 * @return \images\2012\06\17\200_200\2012061717135895318.jpg
	 */
	public static String minPicPath(String picPath, String sizeDir) {
		if (StringUtils.isBlank(picPath)) {
			return "";
		}
		String path = picPath.replace("ori", sizeDir);
		return path;
	}

	public static String searchUrl(String url) {

		return url.toString();
	}

	/**
	 * 方法：searchSimUrl <br>
	 * 描述：搜索相似图片URL <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:58:15 <br>
	 * 
	 * @param picUrl
	 * @param title
	 * @param pageId
	 * @return
	 */
	public static String searchSimUrl(String picUrl, String title,
			Integer pageId) {
		StringBuffer url = new StringBuffer(Constant.SEARCH_URL);
		url.append("similar");
		if (StringUtils.isNotBlank(picUrl)) {
			if (picUrl.indexOf("http://") < 0) {
				picUrl = pic(picUrl);
			}
			url.append("?picUrl=").append(picUrl);
		} else {
			return url.toString();
		}
		if (pageId != null & pageId > 1) {
			url.append("&page=").append(pageId);
		}
		if (StringUtils.isNotBlank(title)) {
			url.append("&title=").append(title);
		}
		return url.toString();
	}

	/**
	 * 方法：ilookListUrl <br>
	 * 描述：获取分类的URL <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:58:27 <br>
	 * 
	 * @param classifyId
	 *            分类id
	 * @param pageId
	 *            分页编号
	 * @return 
	 *         http://localhost:8080/mn606/app/classify/2012061009115579058-1.html
	 */
	public static String ilookListUrl(Long classifyId, Integer pageId) {
		if (pageId == null || pageId < 1) {
			pageId = 1;
		}
		StringBuffer url = new StringBuffer(Constant.LOOK_URL);
		// 判断分类id是否为空
		if (classifyId != null && classifyId > 1) {
			url.append("classify/").append(classifyId).append("-");
		} else {
			url.append("list/");
		}
		url.append(pageId).append(".html");
		return url.toString();
	}

	/**
	 * 方法：ilookItemUrl <br>
	 * 描述：获取分类的URL <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午9:58:48 <br>
	 * 
	 * @param picId
	 *            图片id
	 * @return http://localhost:8080/mn606/classify/2012061009115579058-1.html
	 */
	public static String ilookItemUrl(Long picId) {
		StringBuffer url = new StringBuffer(Constant.LOOK_URL);
		url.append("item/").append(picId).append(".html");
		return url.toString();
	}

	/****************** ilook MM url end *******************************/
	public static void main(String[] args) {
		// String t =
		// uploadPicPath(MethodUtil.getInit().getLongId()+".jpg","ori");
		// t = minPicPath(t,"200_200");
		System.out.println(getRootPath());
	}

}
