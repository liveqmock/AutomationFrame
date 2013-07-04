/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.action.system <br>
 * 文件名：SiteColumnAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午2:31:08<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.action.system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.automation.webframe.entity.SiteColumn;
import com.automation.webframe.service.SiteColumnService;
import com.automation.webframe.web.vo.SiteColumnModel;

/**
 * 
 * 类名称：SiteColumnAction <br>
 * 类描述：站点栏目Action <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午2:31:08 <br>
 * 修改备注：TODO <br>
 * 
 */
@Controller
@RequestMapping("/sys/siteColumn")
public class SiteColumnAction extends BaseAction {

	private final static Logger log = Logger.getLogger(SiteColumnAction.class);

	/** 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错 */
	@Autowired(required = false)
	private SiteColumnService<SiteColumn> siteColumnService;

	/**
	 * 方法：list <br>
	 * 描述：ilook 首页 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:32:44 <br>
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(SiteColumnModel model, HttpServletRequest request)
			throws Exception {
		Map<String, Object> context = getRootMap();
		List<SiteColumn> dataList = siteColumnService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("siteColumn/list", context);
	}

}
