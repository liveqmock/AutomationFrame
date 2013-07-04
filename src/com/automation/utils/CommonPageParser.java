/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.utils <br>
 * 文件名：CommonPageParser.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午2:41:19<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * 
 * 类名称：CommonPageParser <br>
 * 类描述：详细的功能描述 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午2:41:19 <br>
 * 修改备注：TODO <br>
 * 
 */
public class CommonPageParser {

	/** 输出日志 */
	private static final Logger logger = Logger
			.getLogger(CommonPageParser.class);

	private static VelocityEngine ve;// =
										// VelocityEngineUtil.getVelocityEngine();

	/** properties对象 */
	private static Properties properties;

	/** 内容编码 */
	private final static String CONTENT_ENCODING = "UTF-8";

	/** 是否可以替换文件 true =可以替换，false =不可以替换 */
	private static boolean IS_REPLACE = true;

	static {
		try {
			// 获取文件模板根路径
			String templateBasePath = PathUtils.getRootPath() + File.separator
					+ "template";// "Constant.WORK_TEMPLATE_PATH;
			Properties properties = new Properties();
			properties.setProperty(Velocity.RESOURCE_LOADER, "file");
			properties.setProperty("file.resource.loader.description",
					"Velocity File Resource Loader");
			properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH,
					templateBasePath);
			properties.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, "true");
			properties.setProperty(
					"file.resource.loader.modificationCheckInterval", "30");
			properties.setProperty(Velocity.RUNTIME_LOG_LOGSYSTEM_CLASS,
					"org.apache.velocity.runtime.log.Log4JLogChute");
			properties.setProperty("runtime.log.logsystem.log4j.logger",
					"org.apache.velocity");
			properties.setProperty("directive.set.null.allowed", "true");
			VelocityEngine velocityEngine = new VelocityEngine();
			velocityEngine.init(properties);
			ve = velocityEngine;
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * 方法：WriterPage <br>
	 * 描述：生成页面文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:06:09 <br>
	 * 
	 * @param context
	 *            内容上下文
	 * @param templateName
	 *            模板文件路径（相对路径）article\\article_main.html
	 * @param fileDirPath
	 * @param targetFile
	 *            生成页面文件路径（相对路径） vowo\index_1.html
	 */
	public static void WriterPage(VelocityContext context, String templateName,
			String fileDirPath, String targetFile) {
		try {
			File file = new File(fileDirPath + targetFile);
			if (!file.exists()) {
				new File(file.getParent()).mkdirs();
			} else {
				if (IS_REPLACE) {
					logger.info("替换文件" + file.getAbsolutePath());
				} else {
				}
			}

			Template template = ve.getTemplate(templateName, CONTENT_ENCODING);
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					fos, CONTENT_ENCODING));
			template.merge(context, writer);
			writer.flush();
			writer.close();
			fos.close();
			// System.out.println("页面生成成功"+file.getAbsolutePath());
		} catch (Exception e) {
			logger.error(e);
		}
	}

}
