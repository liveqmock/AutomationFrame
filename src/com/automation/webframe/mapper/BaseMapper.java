/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.mapper <br>
 * 文件名：BaseMapper.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-20-下午2:31:31<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.mapper;

import java.util.List;

import com.automation.webframe.web.vo.BaseModel;

/**
 * 
 * 类名称：BaseMapper <br>
 * 类描述：基础mapper类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-20 下午2:31:31 <br>
 * 修改备注：TODO <br>
 * 
 */
public interface BaseMapper<T> {

	/**
	 * 方法：add <br>
	 * 描述：添加实体 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:55:40 <br>
	 * 
	 * @param t
	 */
	public void add(T t);

	/**
	 * 方法：update <br>
	 * 描述：修改实体 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:55:52 <br>
	 * 
	 * @param t
	 */
	public void update(T t);

	/**
	 * 方法：updateBySelective <br>
	 * 描述：选择性修改实体 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:56:01 <br>
	 * 
	 * @param t
	 */
	public void updateBySelective(T t);

	/**
	 * 方法：delete <br>
	 * 描述：根据ID删除实体 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:56:12 <br>
	 * 
	 * @param id
	 */
	public void delete(Object id);

	/**
	 * 方法：queryByCount <br>
	 * 描述：查询数量 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:56:26 <br>
	 * 
	 * @param model
	 * @return
	 */
	public int queryByCount(BaseModel model);

	/**
	 * 方法：queryByList <br>
	 * 描述：查询集合 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:56:38 <br>
	 * 
	 * @param model
	 * @return
	 */
	public List<T> queryByList(BaseModel model);

	/**
	 * 方法：queryById <br>
	 * 描述：根据ID查询 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:56:49 <br>
	 * 
	 * @param id
	 * @return
	 */
	public T queryById(Object id);
}
