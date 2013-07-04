/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.action.system <br>
 * 文件名：SiteMainAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午2:33:14<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.action.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.automation.webframe.entity.BaseBean.DELETED;
import com.automation.webframe.entity.SiteMain;
import com.automation.webframe.entity.SiteType;
import com.automation.webframe.service.SiteMainService;
import com.automation.webframe.service.SiteTypeService;
import com.automation.webframe.utils.HtmlUtils;
import com.automation.webframe.web.vo.SiteMainModel;

/**
 * 
 * 类名称：SiteMainAction <br>
 * 类描述：站点主类Action <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午2:33:14 <br>
 * 修改备注：TODO <br>
 * 
 */
@Controller
@RequestMapping("/siteMain")
public class SiteMainAction extends BaseAction {

	/** 站点主题服务 */
	@Autowired
	private SiteMainService<SiteMain> siteMainService;

	/** 站点类型服务 */
	@Autowired
	private SiteTypeService<SiteType> siteTypeService;

	/**
	 * 方法：list <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:34:12 <br>
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(SiteMainModel model, HttpServletRequest request)
			throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("siteMain/siteMain", context);
	}

	/**
	 * 方法：datalist <br>
	 * 描述：ilook 首页 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:34:19 <br>
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void datalist(SiteMainModel model, HttpServletResponse response)
			throws Exception {
		model.setDeleted(0);
		List<SiteMain> dataList = siteMainService.queryByList(model);
		for (SiteMain bean : dataList) {
			String types = getTypeStr(bean.getId());
			bean.setTypes(types);
		}
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
	 * 日期： 2013-6-24 下午2:34:25 <br>
	 * 
	 * @param bean
	 * @param typeIds
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SiteMain bean, Integer[] typeIds,
			HttpServletResponse response) throws Exception {
		Map<String, Object> context = new HashMap<String, Object>();
		bean.setDeleted(DELETED.NO.key);
		if (bean.getId() == null) {
			siteMainService.add(bean);
		} else {
			siteMainService.update(bean);
		}
		siteMainService.addTypeRel(typeIds, bean.getId());
		sendSuccessMessage(response, "保存成功~");
	}

	/**
	 * 方法：getId <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:34:35 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = new HashMap();
		SiteMain bean = siteMainService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		List<SiteType> types = siteTypeService.queryBySiteId(bean.getId());
		if (types != null && !types.isEmpty()) {
			int[] typeIds = new int[types.size()];
			for (int i = 0; i < types.size(); i++) {
				typeIds[i] = types.get(i).getId();
			}
			bean.setTypeIds(typeIds);
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
	 * 日期： 2013-6-24 下午2:34:40 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletResponse response)
			throws Exception {
		siteMainService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

	/**
	 * 方法：getTypeStr <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:34:43 <br>
	 * 
	 * @param siteId
	 * @return
	 * @throws Exception
	 */
	private String getTypeStr(Integer siteId) throws Exception {
		List<SiteType> types = siteTypeService.queryBySiteId(siteId);
		if (types == null || types.isEmpty()) {
			return null;
		}
		StringBuffer str = new StringBuffer();
		int i = 1;
		for (SiteType type : types) {
			str.append(type.getName());
			if (i < types.size()) {
				str.append(",");
			}
			i++;
		}
		return str.toString();

	}

}
