/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.action.system <br>
 * 文件名：WebPageAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午2:53:32<br>
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

import com.automation.utils.DateUtils;
import com.automation.webframe.entity.BaseBean.DELETED;
import com.automation.webframe.entity.WebPage;
import com.automation.webframe.service.WebPageService;
import com.automation.webframe.utils.HtmlUtils;
import com.automation.webframe.utils.SessionUtils;
import com.automation.webframe.web.vo.WebPageModel;

/**
 * 
 * 类名称：WebPageAction <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午2:53:32 <br>
 * 修改备注：TODO <br>
 * 
 */
@Controller
@RequestMapping("/webPage")
public class WebPageAction extends BaseAction {

	private final static Logger logger = Logger.getLogger(WebPageAction.class);

	/** 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错 */
	@Autowired(required = false)
	private WebPageService<WebPage> webPageService;

	/**
	 * 方法：list <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:54:07 <br>
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(WebPageModel model, HttpServletRequest request)
			throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("web/webPage", context);
	}

	/**
	 * 方法：datalist <br>
	 * 描述：ilook 首页 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:54:13 <br>
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void datalist(WebPageModel model, HttpServletResponse response)
			throws Exception {
		model.setDeleted(0);
		List<WebPage> dataList = webPageService.queryByList(model);
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
	 * 日期： 2013-6-24 下午2:54:22 <br>
	 * 
	 * @param bean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(WebPage bean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> context = new HashMap<String, Object>();
		bean.setDeleted(DELETED.NO.key);
		Integer userId = SessionUtils.getUserId(request);
		if (bean.getId() == null) {
			bean.setCreateBy(userId);
			webPageService.add(bean);
		} else {
			bean.setUpdateBy(userId);
			bean.setUpdateTime(DateUtils.getDateByString(""));
			webPageService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}

	/**
	 * 方法：saveTemplate <br>
	 * 描述：保存页面模板 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:54:31 <br>
	 * 
	 * @param bean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/saveTemplate")
	public void saveTemplate(WebPage bean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, Object> context = new HashMap<String, Object>();
		Integer userId = SessionUtils.getUserId(request);
		if (bean.getId() == null) {
			sendFailureMessage(response, "保存失败,没有对应页面.");
			return;
		} else {
			bean.setUpdateBy(userId);
			bean.setUpdateTime(DateUtils.getDateByString(""));
			webPageService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}

	/**
	 * 方法：getId <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:54:41 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = new HashMap();
		WebPage bean = webPageService.queryById(id);
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
	 * 日期： 2013-6-24 下午2:54:44 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(Integer id, HttpServletResponse response)
			throws Exception {
		webPageService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

}
