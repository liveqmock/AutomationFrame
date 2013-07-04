/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.main <br>
 * 文件名：CreateJava.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午4:10:46<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.velocity.VelocityContext;

import com.automation.sql.CreateBeanByMysql;
import com.automation.utils.CommonPageParser;
import com.automation.utils.Constant;
import com.automation.utils.WolfXmlUtil;

/**
 * 
 * 类名称：CreateJava <br>
 * 类描述：生成文件 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午4:10:46 <br>
 * 修改备注：TODO <br>
 * 
 */
public class CreateJava {

	/** 获取自动化配置文件 */
	private static ResourceBundle AUTOMATION_CONF = ResourceBundle
			.getBundle("automation");

	private static String AUTHOR = AUTOMATION_CONF.getString("author");

	private static String CREATE_USER = AUTOMATION_CONF
			.getString("create.user");

	private static String MODIFY_USER = AUTOMATION_CONF
			.getString("modify.user");

	private static String DATASOURCE_TYPE = AUTOMATION_CONF
			.getString("datasource.type");

	private static String COPYRIGHT = AUTOMATION_CONF.getString("copyright");

	/** 获取数据库相应信息 */
	private static ResourceBundle DATASOURCE_CONF = ResourceBundle
			.getBundle("application_development");

	private static String URL = DATASOURCE_CONF.getString("jdbc.url");

	private static String USERNAME = DATASOURCE_CONF.getString("jdbc.username");

	private static String PASSWORD = DATASOURCE_CONF.getString("jdbc.password");

	private static String rootPath = Constant.WORK_ROOT_PATH;

	private static String actionPath = "D:" + File.separator + "Documents"
			+ File.separator + "workspace" + File.separator + "AutoProject";

	private static String TABLE_NAME = "recommend_info_tab";

	private static String REMARK = "精品推荐";

	public static void main(String[] args) {
		CreateBeanByMysql createBean = new CreateBeanByMysql();
		createBean.setSqlInfo(URL, USERNAME, PASSWORD);
		/** 此处修改成你的 表名 和 中文注释 ***/
		String codeName = "页面";// 中文注释 当然你用英文也是可以的
		String className = createBean.getTablesNameToClassName(TABLE_NAME);
		String lowerName = className.substring(0, 1).toLowerCase()
				+ className.substring(1, className.length());

		// 根路径
		String srcPath = rootPath + "src" + File.separator;
		// 包路径
		String pckPath = rootPath + "src" + File.separator + "com"
				+ File.separator + "automation" + File.separator + "webframe"
				+ File.separator + File.separator;
		// 页面路径，放到WEB-INF下面是为了不让手动输入路径访问jsp页面，起到安全作用
		String webPath = rootPath + File.separator + "WebContent"
				+ File.separator + "jsp" + File.separator;

		// java,xml文件名称
		String modelPath = "web" + File.separator + "vo" + File.separator
				+ className + "Model.java";
		String beanPath = "entity" + File.separator + className + ".java";
		String mapperPath = "mapper" + File.separator + className
				+ "Mapper.java";
		String servicePath = "service" + File.separator + className
				+ "Service.java";
		String controllerPath = "web" + File.separator + "action"
				+ File.separator + className.toLowerCase() + File.separator
				+ className + "Action.java";
		String sqlMapperPath = "mapper" + File.separator + "xml"
				+ File.separator + className + "Mapper.xml";
		// jsp页面路径
		String pageEditPath = lowerName + File.separator + lowerName
				+ "Edit.jsp";
		String pageListPath = lowerName + File.separator + lowerName
				+ "List.jsp";

		VelocityContext context = new VelocityContext();
		GregorianCalendar ca = new GregorianCalendar();
		String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date())
				+ " " + (ca.get(GregorianCalendar.AM_PM) == 0 ? "上午" : "下午")
				+ new SimpleDateFormat("HH:mm:ss").format(new Date());
		context.put("className", className); //
		context.put("lowerName", lowerName);
		context.put("codeName", codeName);
		context.put("tableName", TABLE_NAME);
		// 设置注释相关信息
		context.put("time", time);
		context.put("author", AUTHOR);
		context.put("createUser", CREATE_USER);
		context.put("modifyUser", MODIFY_USER);
		context.put("remark", REMARK);
		context.put("copyright", COPYRIGHT);
		context.put("classNameLower", className.toLowerCase());

		/****************************** 生成bean字段 *********************************/
		try {
			context.put("feilds", createBean.getBeanFeilds(TABLE_NAME)); // 生成bean
		} catch (Exception e) {
			e.printStackTrace();
		}

		/******************************* 生成sql语句 **********************************/
		try {
			Map<String, Object> sqlMap = createBean
					.getAutoCreateSql(TABLE_NAME);
			context.put("columnDatas", createBean.getColumnDatas(TABLE_NAME)); // 生成bean
			context.put("SQL", sqlMap);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		//
		// -------------------生成文件代码---------------------/
		CommonPageParser
				.WriterPage(context, "TempBean.java", pckPath, beanPath); // 生成实体Bean
		CommonPageParser.WriterPage(context, "TempModel.java", pckPath,
				modelPath); // 生成Model
		CommonPageParser.WriterPage(context, "TempMapper.java", pckPath,
				mapperPath); // 生成MybatisMapper接口 相当于Dao
		CommonPageParser.WriterPage(context, "TempService.java", pckPath,
				servicePath);// 生成Service
		CommonPageParser.WriterPage(context, "TempMapper.xml", pckPath,
				sqlMapperPath);// 生成Mybatis xml配置文件
		CommonPageParser.WriterPage(context, "TempController.java", pckPath,
				controllerPath);// 生成Controller
		// 相当于接口
		// 生JSP页面，如果不需要可以注释掉
		context.put("basePath", "${e:basePath()}");
		CommonPageParser.WriterPage(context, "TempList.jsp", webPath,
				pageListPath);// 生成Controller 相当于接口
		CommonPageParser.WriterPage(context, "TempEdit.jsp", webPath,
				pageEditPath);// 生成Controller 相当于接口

		/************************* 修改xml文件 *****************************/
		WolfXmlUtil xml = new WolfXmlUtil();
		Map<String, String> attrMap = new HashMap<String, String>();
		try {
			/** 引入到mybatis-config.xml 配置文件 */
			// attrMap.clear();
			// attrMap.put("resource","com/yiya/mybatis/"+className+"Mapper.xml");
			// xml.getAddNode(rootPath+"conf/mybatis-config.xml",
			// "/configuration/mappers", "mapper", attrMap, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取项目的路径
	 * 
	 * @return
	 */
	public static String getRootPath() {
		String rootPath = "";
		try {
			File file = new File(CommonPageParser.class.getResource("/")
					.getFile());
			rootPath = file.getParentFile().getParentFile().getParent()
					+ "+File.separator+";
			rootPath = java.net.URLDecoder.decode(rootPath, "utf-8");
			System.out.println(rootPath);
			return rootPath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rootPath;
	}
}
