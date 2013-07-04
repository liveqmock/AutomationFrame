/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.sql <br>
 * 文件名：MyBatisDB.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-上午10:05:04<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.sql;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.automation.utils.PathUtils;

/**
 * 
 * 类名称：MyBatisDB <br>
 * 类描述：MyBatisDB <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 上午10:05:04 <br>
 * 修改备注：TODO <br>
 * 
 */
public class MyBatisDB {

	private static SqlSessionFactory sqlMapper;

	static {

		String resource = PathUtils.getRootPath() + File.separator
				+ "mybatis-config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlMapper = new SqlSessionFactoryBuilder().build(reader);
	}

	/**
	 * 方法：getSqlSession <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:09:51 <br>
	 * 
	 * @return
	 */
	public static SqlSession getSqlSession() {
		if (sqlMapper == null) {
			return null;
		}
		return sqlMapper.openSession();
	}

	/**
	 * 方法：close <br>
	 * 描述：关闭SQLsession <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:10:02 <br>
	 */
	public static void close() {
		getSqlSession().close();
	}

	/**
	 * 方法：commit <br>
	 * 描述：确认SQLsession <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:10:06 <br>
	 */
	public static void commit() {
		getSqlSession().commit();
	}

	/**
	 * 方法：rollback <br>
	 * 描述：回滚SQLsession <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:10:10 <br>
	 */
	public static void rollback() {
		getSqlSession().rollback();
	}
}
