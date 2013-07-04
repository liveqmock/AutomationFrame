/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.action.system <br>
 * 文件名：SiteTypeAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午2:38:13<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.action.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.automation.webframe.entity.SiteType;
import com.automation.webframe.service.SiteTypeService;
import com.automation.webframe.utils.HtmlUtils;
import com.automation.webframe.web.vo.SiteTypeModel;

/**
 * 
 * 类名称：SiteTypeAction <br>
 * 类描述：站点类型Action <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午2:38:13 <br>
 * 修改备注：TODO <br>
 * 
 */
@Controller
@RequestMapping("/siteType")
public class SiteTypeAction extends BaseAction {

	private final static Logger logger = Logger.getLogger(SiteTypeAction.class);

	/** 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错 */
	@Autowired(required = false)
	private SiteTypeService<SiteType> siteTypeService;

	/**
	 * 方法：list <br>
	 * 描述：ilook 首页 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:38:55 <br>
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(SiteTypeModel model, HttpServletRequest request)
			throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("siteMain/siteType", context);
	}

	/**
	 * 方法：typeListJson <br>
	 * 描述：json 列表页面 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:39:10 <br>
	 * 
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/typeListJson")
	public void typeListJson(HttpServletResponse response) throws Exception {
		List<SiteType> dataList = siteTypeService.queryByAll();
		HtmlUtils.writerJson(response, dataList);
	}

	/**
	 * 方法：dataList <br>
	 * 描述：json 列表页面 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:39:23 <br>
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void dataList(SiteTypeModel model, HttpServletResponse response)
			throws Exception {
		List<SiteType> dataList = siteTypeService.queryByList(model);
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtils.writerJson(response, jsonMap);
	}

	/**
	 * 方法：save <br>
	 * 描述：添加或修改数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:39:34 <br>
	 * 
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SiteType bean, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = new HashMap<String, Object>();
		if (bean.getId() == null) {
			siteTypeService.add(bean);
		} else {
			siteTypeService.update(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}

	/**
	 * 方法：getId <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:39:41 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = new HashMap();
		SiteType bean = siteTypeService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtils.writerJson(response, context);
	}

	/**
	 * 方法：delete <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:39:45 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletResponse response)
			throws Exception {
		siteTypeService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

}
