/**
 * 项目名：AbstractCreateBean <br>
 * 包名：com.automation.sql <br>
 * 文件名：CreateBean.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午3:12:36<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.sql;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.automation.sql.dto.ColumnData;

/**
 * 
 * 类名称：AbstractCreateBean <br>
 * 类描述：生成Bean文件 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午3:12:36 <br>
 * 修改备注：TODO <br>
 * 
 */
public abstract class AbstractCreateBean {

	/** 数据库链接 */
	private Connection connection = null;

	/** 数据库地址 */
	static String url;

	/** 用户名 */
	static String username;

	/** 密码 */
	static String password;

	static String rt = "\r\t";

	private static final List<String> STRING_TYPE = Arrays.asList(new String[] {
			"char", "varchar", "tinytext", "text", "blob", "mediumtext",
			"mediumblob", "longtext", "longblob" });

	private static final List<String> INT_TYPE = Arrays.asList(new String[] {
			"tinyint", "smallint", "mediumint", "int", "bigint" });

	private static final List<String> LONG_TYPE = Arrays
			.asList(new String[] { "bigint" });

	private static final List<String> DOUBLE_TYPE = Arrays.asList(new String[] {
			"float", "double", "decimal" });

	private static final List<String> DATE_TYPE = Arrays.asList(new String[] {
			"date", "datetime", "timestamp", "time", "year" });

	/**
	 * 方法：setSqlInfo <br>
	 * 描述：设置sql信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:27:15 <br>
	 * 
	 * @param url
	 * @param username
	 * @param password
	 */
	@SuppressWarnings("static-access")
	public void setSqlInfo(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	/**
	 * 方法：getTables <br>
	 * 描述：获取表格 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:29:32 <br>
	 * 
	 * @return
	 */
	public abstract List<String> getTables() throws Exception;

	/**
	 * 方法：getColumnDatas <br>
	 * 描述：获取字段数据 查询表的字段，封装成List <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:31:09 <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract List<ColumnData> getColumnDatas(String tableName)
			throws Exception;

	/**
	 * 方法：getBeanFeilds <br>
	 * 描述：获取实体自字段 生成实体Bean 的属性和set,get方法 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:32:54 <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract String getBeanFeilds(String tableName) throws Exception;

	/**
	 * 方法：getColumnsMap <br>
	 * 描述：获取字段数据 查询表的字段，封装成List <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:35:41 <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract List<Map<String, String>> getColumnsMap(String tableName)
			throws Exception;

	/**
	 * 方法：getPackage <br>
	 * 描述：生成文件 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:52:35 <br>
	 * 
	 * @param type
	 * @param createPath
	 * @param content
	 * @param packageName
	 * @param className
	 * @param extendsClassName
	 * @param importName
	 * @throws Exception
	 */
	public abstract void getPackage(int type, String createPath,
			String content, String packageName, String className,
			String extendsClassName, String... importName) throws Exception;

	/**
	 * 方法：getTablesNameToClassName <br>
	 * 描述：通过表明获取雷鸣 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:55:35 <br>
	 * 
	 * @param tableName
	 * @return
	 */
	public abstract String getTablesNameToClassName(String tableName);

	/**
	 * 方法：getAutoCreateSql <br>
	 * 描述：自动生成sql语句 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:57:56 <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 */
	public abstract Map<String, Object> getAutoCreateSql(String tableName)
			throws Exception;

	/**
	 * 方法：getDeleteSql <br>
	 * 描述：获取删除sql语句 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:59:26 <br>
	 * 
	 * @param tableName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 */
	public abstract String getDeleteSql(String tableName, String[] columnsList)
			throws Exception;

	/**
	 * 方法：getSelectByIdSql <br>
	 * 描述：获取根据ID查询sql语句 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:00:08 <br>
	 * 
	 * @param tableName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 */
	public abstract String getSelectByIdSql(String tableName,
			String[] columnsList) throws Exception;

	/**
	 * 方法：getColumnFields <br>
	 * 描述：获取所有的字段，并按","分割 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:01:24 <br>
	 * 
	 * @param columns
	 * @return
	 * @throws Exception
	 */
	public abstract String getColumnFields(String columns) throws Exception;

	/**
	 * 方法：getColumnList <br>
	 * 描述：获取所有列 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:02:27 <br>
	 * 
	 * @param columns
	 * @return
	 * @throws Exception
	 */
	public abstract String[] getColumnList(String columns) throws Exception;

	/**
	 * 方法：getUpdateSql <br>
	 * 描述：获取修改sql语句 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:04:07 <br>
	 * 
	 * @param tableName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 */
	public abstract String getUpdateSql(String tableName, String[] columnsList)
			throws Exception;

	/**
	 * 方法：getUpdateSelectiveSql <br>
	 * 描述：获取根指定条件修改sql语句 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:05:09 <br>
	 * 
	 * @param tableName
	 * @param columnList
	 * @return
	 * @throws Exception
	 */
	public abstract String getUpdateSelectiveSql(String tableName,
			List<ColumnData> columnList) throws Exception;

	/**
	 * 方法：getColumnSplit <br>
	 * 描述：获取所有列名字<br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午4:06:34 <br>
	 * 
	 * @param columnList
	 * @return
	 * @throws Exception
	 */
	public abstract String getColumnSplit(List<ColumnData> columnList)
			throws Exception;

	/**
	 * 方法：createFile <br>
	 * 描述： <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:56:38 <br>
	 * 
	 * @param path
	 * @param fileName
	 * @param str
	 * @throws Exception
	 */
	public void createFile(String path, String fileName, String str)
			throws Exception {
		FileWriter writer = new FileWriter(new File(path + fileName));
		writer.write(new String(str.getBytes("utf-8")));
		writer.flush();
		writer.close();
	}

	/**
	 * 方法：sqlTypeTrans4JavaType <br>
	 * 描述：数据库字段类型转换java数据类型 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:37:12 <br>
	 * 
	 * @param type
	 * @return
	 */
	public String sqlTypeTrans4JavaType(String type) {
		type = type.toLowerCase();
		if (STRING_TYPE.contains(type)) {
			return "String";
		} else if (INT_TYPE.contains(type)) {
			return "Integer";
		} else if (LONG_TYPE.contains(type)) {
			return "Long";
		} else if (DATE_TYPE.contains(type)) {
			return "java.sql.Timestamp";
		} else if (DOUBLE_TYPE.contains(type)) {
			return "Double";
		}
		return null;
	}
	/**
	 * 方法：javaType4sqlTypeTrans <br>
	 * 描述：java数据类型 转换数据库字段类型<br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 下午3:37:12 <br>
	 * 
	 * @param type
	 * @return
	 */
	public String javaType4sqlTypeTrans(String type) {
		type = type.toLowerCase();
		if (STRING_TYPE.contains(type)) {
			return "String";
		} else if (INT_TYPE.contains(type)) {
			return "Integer";
		} else if (LONG_TYPE.contains(type)) {
			return "Long";
		} else if (DATE_TYPE.contains(type)) {
			return "java.sql.Timestamp";
		} else if (DOUBLE_TYPE.contains(type)) {
			return "Double";
		}
		return null;
	}

	/**
	 * @param connection
	 *            the connection to set <br>
	 * 
	 *            时间: 2013-6-21 下午3:22:44
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @retrun the connection <br>
	 * 
	 *         时间: 2013-6-21 下午3:22:57 <br>
	 */

	public Connection getConnection() throws Exception {
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
