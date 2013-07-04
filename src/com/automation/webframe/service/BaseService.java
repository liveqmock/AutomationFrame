/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.service <br>
 * 文件名：BaseService.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-21-上午10:52:19<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.service;

import java.util.List;

import com.automation.webframe.mapper.BaseMapper;
import com.automation.webframe.web.vo.BaseModel;

/**
 * 
 * 类名称：BaseService <br>
 * 类描述：基础服务层 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-21 上午10:52:19 <br>
 * 修改备注：TODO <br>
 * 
 */
public abstract class BaseService<T> {

	/**
	 * 方法：getMapper <br>
	 * 描述：BaserMapper 抽象get方法 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:53:28 <br>
	 * 
	 * @return
	 */
	public abstract BaseMapper<T> getMapper();

	/**
	 * 方法：add <br>
	 * 描述：添加对象 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:54:11 <br>
	 * 
	 * @param t
	 * @throws Exception
	 */
	public void add(T t) throws Exception {
		getMapper().add(t);
	}

	/**
	 * 方法：update <br>
	 * 描述：更新实体 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:54:21 <br>
	 * 
	 * @param t
	 * @throws Exception
	 */
	public void update(T t) throws Exception {
		getMapper().update(t);
	}

	/**
	 * 方法：updateBySelective <br>
	 * 描述：选择性更新 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:54:37 <br>
	 * 
	 * @param t
	 */
	public void updateBySelective(T t) {
		getMapper().updateBySelective(t);
	}

	/**
	 * 方法：delete <br>
	 * 描述：根据ID集合删除 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:55:07 <br>
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void delete(Object... ids) throws Exception {
		if (ids == null || ids.length < 1) {
			return;
		}
		for (Object id : ids) {
			getMapper().delete(id);
		}
	}

	/**
	 * 方法：queryByCount <br>
	 * 描述：查询数量 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:55:24 <br>
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int queryByCount(BaseModel model) throws Exception {
		return getMapper().queryByCount(model);
	}

	/**
	 * 方法：queryByList <br>
	 * 描述：查询集合 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:57:12 <br>
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public List<T> queryByList(BaseModel model) throws Exception {
		Integer rowCount = queryByCount(model);
		model.getPager().setRowCount(rowCount);
		return getMapper().queryByList(model);
	}

	/**
	 * 方法：queryById <br>
	 * 描述：根据ID查询 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-21 上午10:57:22 <br>
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public T queryById(Object id) throws Exception {
		return getMapper().queryById(id);
	}

}
