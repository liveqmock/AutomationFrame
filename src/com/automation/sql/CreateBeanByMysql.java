/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.sql <br>
 * 文件名：CreateBeanByMysql.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-下午3:17:06<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.automation.sql.dto.ColumnData;

/**
 * 
 * 类名称：CreateBeanByMysql <br>
 * 类描述：根据mysql 生成实体 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 下午3:17:06 <br>
 * 修改备注：TODO <br>
 * 
 */
public class CreateBeanByMysql extends AbstractCreateBean {

	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	String SQLTables = "show tables";

	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 方法：getTables <br>
	 * 描述：TODO <br>
	 * 
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getTables()
	 */
	@Override
	public List<String> getTables() throws Exception {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(SQLTables);
		ResultSet rs = ps.executeQuery();
		List<String> list = new ArrayList<String>();
		while (rs.next()) {
			String tableName = rs.getString(1);
			list.add(tableName);
		}
		rs.close();
		ps.close();
		con.close();
		return list;
	}

	/**
	 * 方法：getColumnDatas <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getColumnDatas(java.lang.String)
	 */
	@Override
	public List<ColumnData> getColumnDatas(String tableName) throws Exception {
		String SQLColumns = "SELECT distinct COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT FROM information_schema.columns WHERE table_name =  '"
				+ tableName + "' ";
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(SQLColumns);
		List<ColumnData> columnList = new ArrayList<ColumnData>();
		ResultSet rs = ps.executeQuery();
		StringBuffer str = new StringBuffer();
		StringBuffer getset = new StringBuffer();
		while (rs.next()) {
			String name = rs.getString(1);
			String type = rs.getString(2);
			String comment = rs.getString(3);
			type = sqlTypeTrans4JavaType(type);

			ColumnData cd = new ColumnData();
			cd.setColumnName(name);
			cd.setDataType(type);
			cd.setColumnComment(comment);
			columnList.add(cd);
		}
		argv = str.toString();
		method = getset.toString();
		rs.close();
		ps.close();
		con.close();
		return columnList;
	}

	private String method;
	private String argv;

	/**
	 * 方法：getBeanFeilds <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getBeanFeilds(java.lang.String)
	 */
	@Override
	public String getBeanFeilds(String tableName) throws Exception {
		List<ColumnData> dataList = getColumnDatas(tableName);
		StringBuffer str = new StringBuffer();
		StringBuffer getset = new StringBuffer();
		for (ColumnData d : dataList) {
			String name = d.getColumnName();
			String type = d.getDataType();
			if (name.equals("packSize")) {
				System.out.println(type);
			}
			String comment = d.getColumnComment();
			// type=this.getType(type);
			String maxChar = name.substring(0, 1).toUpperCase();
			str.append("/* " + comment + " **/");
			str.append("\r\t").append("private ").append(type + " ")
					.append(name).append(";");
			str.append("\r\t");
			str.append("\r\t");
			String method = maxChar + name.substring(1, name.length());
			getset.append("\r\t").append("public ").append(type + " ")
					.append("get" + method + "() {\r\t");
			getset.append("    return this.").append(name).append(";\r\t}");
			getset.append("\r\t")
					.append("public void ")
					.append("set" + method + "(" + type + " " + name
							+ ") {\r\t");
			getset.append("    this." + name + "=").append(name)
					.append(";\r\t}");
		}
		argv = str.toString();
		method = getset.toString();
		return argv + method;
	}

	/**
	 * 方法：getColumnsMap <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getColumnsMap(java.lang.String)
	 */
	@Override
	public List<Map<String, String>> getColumnsMap(String tableName)
			throws Exception {
		String SQLColumns = "SELECT distinct COLUMN_NAME, DATA_TYPE, COLUMN_COMMENT FROM information_schema.columns WHERE  table_schema = 'ssi' and table_name =  '"
				+ tableName + "' ";
		// String SQLColumns="desc "+tableName;
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(SQLColumns);
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Map<String, String> columnsMap = new HashMap<String, String>();
			String name = rs.getString(1);
			String type = rs.getString(2);
			String comment = rs.getString(3);
			type = sqlTypeTrans4JavaType(type);
			columnsMap.put("COLUMN_NAME", name);
			columnsMap.put("DATA_TYPE", type);
			columnsMap.put("COLUMN_COMMENT", comment);
			listMap.add(columnsMap);
		}
		rs.close();
		ps.close();
		con.close();
		return listMap;
	}

	/**
	 * 方法：getPackage <br>
	 * 描述：TODO <br>
	 * 
	 * @param type
	 * @param createPath
	 * @param content
	 * @param packageName
	 * @param className
	 * @param extendsClassName
	 * @param importName
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getPackage(int, java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String,
	 *      java.lang.String, java.lang.String[])
	 */
	@Override
	public void getPackage(int type, String createPath, String content,
			String packageName, String className, String extendsClassName,
			String... importName) throws Exception {
		if (null == packageName) {
			packageName = "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("package ").append(packageName).append(";\r");
		sb.append("\r");
		for (int i = 0; i < importName.length; i++) {
			sb.append("import ").append(importName[i]).append(";\r");
		}
		sb.append("\r");
		sb.append("/**\r *  entity. @author wolf Date:"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date()) + "\r */");
		sb.append("\r");
		sb.append("\rpublic class ").append(className);
		if (null != extendsClassName) {
			sb.append(" extends ").append(extendsClassName);
		}
		if (type == 1) { // bean
			sb.append(" ").append("implements java.io.Serializable {\r");
		} else {
			sb.append(" {\r");
		}
		sb.append("\r\t");
		sb.append("private static final long serialVersionUID = 1L;\r\t");
		String temp = className.substring(0, 1).toLowerCase();
		temp += className.substring(1, className.length());
		if (type == 1) {
			sb.append("private " + className + " " + temp + "; // entity ");
		}
		sb.append(content);
		sb.append("\r}");
		System.out.println(sb.toString());
		this.createFile(createPath, "", sb.toString());
	}

	/**
	 * 方法：getTablesNameToClassName <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @return
	 * @see com.automation.sql.CreateBean#getTablesNameToClassName(java.lang.String)
	 */
	@Override
	public String getTablesNameToClassName(String tableName) {
		String[] split = tableName.split("_");
		if (split.length > 1) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < split.length; i++) {
				String tempTableName = split[i].substring(0, 1).toUpperCase()
						+ split[i].substring(1, split[i].length());
				sb.append(tempTableName);
			}
			System.out.println(sb.toString());
			return sb.toString();
		} else {
			String tempTables = split[0].substring(0, 1).toUpperCase()
					+ split[0].substring(1, split[0].length());
			return tempTables;
		}
	}

	/**
	 * 
	 * <br>
	 * <b>功能：</b>生成sql语句<br>
	 * <b>作者：</b>肖财高<br>
	 * <b>日期：</b> 2011-12-21 <br>
	 * 
	 * @param tableName
	 * @throws Exception
	 */
	static String selectStr = "select ";
	static String from = " from ";

	/**
	 * 方法：getAutoCreateSql <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getAutoCreateSql(java.lang.String)
	 */
	@Override
	public Map<String, Object> getAutoCreateSql(String tableName)
			throws Exception {
		Map<String, Object> sqlMap = new HashMap<String, Object>();
		List<ColumnData> columnDatas = getColumnDatas(tableName);
		String columns = this.getColumnSplit(columnDatas);
		String[] columnList = getColumnList(columns); // 表所有字段
		String columnFields = getColumnFields(columns); // 表所有字段 按","隔开
		String insert = "insert into " + tableName + "("
				+ columns.replaceAll("\\|", ",") + ")\n values(#{"
				+ columns.replaceAll("\\|", "},#{") + "})";
		String update = getUpdateSql(tableName, columnList);
		String updateSelective = getUpdateSelectiveSql(tableName, columnDatas);
		String selectById = getSelectByIdSql(tableName, columnList);
		String delete = getDeleteSql(tableName, columnList);
		sqlMap.put("columnList", columnList);
		sqlMap.put("columnFields", columnFields);
		sqlMap.put(
				"insert",
				insert.replace("#{createTime}", "now()").replace(
						"#{updateTime}", "now()"));
		sqlMap.put(
				"update",
				update.replace("#{createTime}", "now()").replace(
						"#{updateTime}", "now()"));
		sqlMap.put("delete", delete);
		sqlMap.put("updateSelective", updateSelective);
		sqlMap.put("selectById", selectById);
		return sqlMap;
	}

	/**
	 * 方法：getDeleteSql <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getDeleteSql(java.lang.String,
	 *      java.lang.String[])
	 */
	@Override
	public String getDeleteSql(String tableName, String[] columnsList)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("delete ");
		sb.append("\t from ").append(tableName).append(" where ");
		sb.append(columnsList[0]).append(" = #{").append(columnsList[0])
				.append("}");
		return sb.toString();
	}

	/**
	 * 方法：getSelectByIdSql <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getSelectByIdSql(java.lang.String,
	 *      java.lang.String[])
	 */
	@Override
	public String getSelectByIdSql(String tableName, String[] columnsList)
			throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select <include refid=\"Base_Column_List\" /> \n");
		sb.append("\t from ").append(tableName).append(" where ");
		sb.append(columnsList[0]).append(" = #{").append(columnsList[0])
				.append("}");
		return sb.toString();
	}

	/**
	 * 方法：getColumnFields <br>
	 * 描述：TODO <br>
	 * 
	 * @param columns
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getColumnFields(java.lang.String)
	 */
	@Override
	public String getColumnFields(String columns) throws Exception {
		String fields = columns;
		if (fields != null && !"".equals(fields)) {
			fields = fields.replaceAll("[|]", ",");
		}
		return fields;
	}

	/**
	 * 方法：getColumnList <br>
	 * 描述：TODO <br>
	 * 
	 * @param columns
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getColumnList(java.lang.String)
	 */
	@Override
	public String[] getColumnList(String columns) throws Exception {
		String[] columnList = columns.split("[|]");
		return columnList;
	}

	/**
	 * 方法：getUpdateSql <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @param columnsList
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getUpdateSql(java.lang.String,
	 *      java.lang.String[])
	 */
	@Override
	public String getUpdateSql(String tableName, String[] columnsList)
			throws Exception {
		StringBuffer sb = new StringBuffer();

		for (int i = 1; i < columnsList.length; i++) {
			String column = columnsList[i];
			if ("CREATETIME".equals(column.toUpperCase()))
				continue;

			if ("UPDATETIME".equals(column.toUpperCase()))
				sb.append(column + "=now()");
			else
				sb.append(column + "=#{" + column + "}");
			// 最后一个字段不需要","
			if ((i + 1) < columnsList.length) {
				sb.append(",");
			}
		}
		String update = "update " + tableName + " set " + sb.toString()
				+ " where " + columnsList[0] + "=#{" + columnsList[0] + "}";
		return update;
	}

	/**
	 * 方法：getUpdateSelectiveSql <br>
	 * 描述：TODO <br>
	 * 
	 * @param tableName
	 * @param columnList
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getUpdateSelectiveSql(java.lang.String,
	 *      java.util.List)
	 */
	@Override
	public String getUpdateSelectiveSql(String tableName,
			List<ColumnData> columnList) throws Exception {
		StringBuffer sb = new StringBuffer();
		ColumnData cd = columnList.get(0); // 获取第一条记录，主键
		sb.append("\t<trim  suffixOverrides=\",\" >\n");
		for (int i = 1; i < columnList.size(); i++) {
			ColumnData data = columnList.get(i);
			String columnName = data.getColumnName();
			sb.append("\t<if test=\"").append(columnName).append(" != null ");
			// String 还要判断是否为空
			if ("String" == data.getDataType()) {
				sb.append(" and ").append(columnName).append(" != ''");
			}
			sb.append(" \">\n\t\t");
			sb.append(columnName + "=#{" + columnName + "},\n");
			sb.append("\t</if>\n");
		}
		sb.append("\t</trim>");
		String update = "update " + tableName + " set \n" + sb.toString()
				+ " where " + cd.getColumnName() + "=#{" + cd.getColumnName()
				+ "}";
		return update;
	}

	/**
	 * 方法：getColumnSplit <br>
	 * 描述：TODO <br>
	 * 
	 * @param columnList
	 * @return
	 * @throws Exception
	 * @see com.automation.sql.CreateBean#getColumnSplit(java.util.List)
	 */
	@Override
	public String getColumnSplit(List<ColumnData> columnList) throws Exception {
		StringBuffer commonColumns = new StringBuffer();
		for (ColumnData data : columnList) {
			commonColumns.append(data.getColumnName() + "|");
		}
		return commonColumns.delete(commonColumns.length() - 1,
				commonColumns.length()).toString();
	}

}
