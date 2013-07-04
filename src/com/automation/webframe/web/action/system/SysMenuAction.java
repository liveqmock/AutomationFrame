/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.action.system <br>
 * 文件名：SysMenuAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午2:40:40<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.action.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.automation.webframe.entity.BaseBean.DELETED;
import com.automation.webframe.entity.SysMenu;
import com.automation.webframe.entity.SysMenuBtn;
import com.automation.webframe.service.SysMenuBtnService;
import com.automation.webframe.service.SysMenuService;
import com.automation.webframe.utils.HtmlUtils;
import com.automation.webframe.utils.TreeUtils;
import com.automation.webframe.web.vo.SysMenuModel;
import com.automation.webframe.web.vo.TreeNode;

/**
 * 
 * 类名称：SysMenuAction <br>
 * 类描述：系统菜单Action <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午2:40:40 <br>
 * 修改备注：TODO <br>
 * 
 */
@Controller
@RequestMapping("/sysMenu")
public class SysMenuAction extends BaseAction {

	private final static Logger logger = Logger.getLogger(SysMenuAction.class);

	/** 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错 */
	@Autowired(required = false)
	private SysMenuService<SysMenu> sysMenuService;

	@Autowired
	private SysMenuBtnService<SysMenuBtn> sysMenuBtnService;

	/**
	 * 方法：menu <br>
	 * 描述：ilook 首页 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:42:32 <br>
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/menu")
	public ModelAndView menu(SysMenuModel model, HttpServletRequest request)
			throws Exception {
		Map<String, Object> context = getRootMap();
		model.setDeleted(DELETED.NO.key);
		List<SysMenu> dataList = sysMenuService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("sys/sysMenu", context);
	}

	/**
	 * 方法：rootMenu <br>
	 * 描述：顶级菜单 json <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:42:38 <br>
	 * 
	 * @param menuId
	 *            此菜单id不查询，可以为空
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/rootMenuJson")
	public void rootMenu(Integer menuId, HttpServletResponse response)
			throws Exception {
		List<SysMenu> dataList = sysMenuService.getRootMenu(menuId);
		if (dataList == null) {
			dataList = new ArrayList<SysMenu>();
		}
		HtmlUtils.writerJson(response, dataList);
	}

	/**
	 * 方法：dataList <br>
	 * 描述：json 列表页面 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:42:50 <br>
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void dataList(SysMenuModel model, HttpServletResponse response)
			throws Exception {
		List<SysMenu> dataList = sysMenuService.queryByList(model);
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
	 * 日期： 2013-6-24 下午2:43:10 <br>
	 * 
	 * @param bean
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysMenu bean, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 设置菜单按钮数据
		List<SysMenuBtn> btns = getReqBtns(request);
		bean.setBtns(btns);
		if (bean.getId() == null) {
			bean.setDeleted(DELETED.NO.key);
			sysMenuService.add(bean);
		} else {
			sysMenuService.update(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}

	/**
	 * 方法：getId <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:46:09 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = new HashMap<String, Object>();
		SysMenu bean = sysMenuService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		List<SysMenuBtn> btns = sysMenuBtnService.queryByMenuid(id);
		bean.setBtns(btns);
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtils.writerJson(response, context);
	}

	/**
	 * 方法：delete <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:46:13 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletResponse response)
			throws Exception {
		if (id != null && id.length > 0) {
			sysMenuService.delete(id);
			sendSuccessMessage(response, "删除成功");
		} else {
			sendFailureMessage(response, "未选中记录");
		}
	}

	/**
	 * 方法：getMenuTree <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:46:18 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getMenuTree")
	public void getMenuTree(Integer id, HttpServletResponse response)
			throws Exception {
		List<TreeNode> menuTree = treeMenu();
		HtmlUtils.writerJson(response, menuTree);
	}

	/**
	 * 方法：treeMenu <br>
	 * 描述：构建树形菜单 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:46:23 <br>
	 * 
	 * @return
	 */
	public List<TreeNode> treeMenu() {
		List<SysMenu> rootMenus = sysMenuService.getRootMenu(null);// 根节点
		List<SysMenu> childMenus = sysMenuService.getChildMenu();// 子节点
		List<SysMenuBtn> childBtns = sysMenuBtnService.queryByAll();
		TreeUtils util = new TreeUtils(rootMenus, childMenus, childBtns);
		return util.getTreeNode();
	}

	/**
	 * 方法：getReqBtns <br>
	 * 描述：获取请求的菜单按钮数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:46:35 <br>
	 * 
	 * @param request
	 * @return
	 */
	public List<SysMenuBtn> getReqBtns(HttpServletRequest request) {
		List<SysMenuBtn> btnList = new ArrayList<SysMenuBtn>();
		String[] btnId = request.getParameterValues("btnId");
		String[] btnName = request.getParameterValues("btnName");
		String[] btnType = request.getParameterValues("btnType");
		String[] actionUrls = request.getParameterValues("actionUrls");
		String[] deleteFlag = request.getParameterValues("deleteFlag");
		if (btnId == null || btnId.length < 1) {
			return null;
		}

		for (int i = 0; i < btnId.length; i++) {
			if (StringUtils.isNotBlank(btnName[i])
					&& StringUtils.isNotBlank(btnType[i])) {
				SysMenuBtn btn = new SysMenuBtn();
				if (StringUtils.isNotBlank(btnId[i])
						&& NumberUtils.isNumber(btnId[i])) {
					btn.setId(NumberUtils.toInt(btnId[i]));
				}
				btn.setBtnName(btnName[i]);
				btn.setBtnType(btnType[i]);
				btn.setActionUrls(actionUrls[i]);
				btn.setDeleteFlag(deleteFlag[i]);
				btnList.add(btn);
			}
		}
		return btnList;
	}
}
