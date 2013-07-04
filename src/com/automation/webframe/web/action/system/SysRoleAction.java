/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.action.system <br>
 * 文件名：SysRoleAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午2:47:33<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.action.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.automation.webframe.entity.SysMenu;
import com.automation.webframe.entity.SysRole;
import com.automation.webframe.entity.SysRoleRel;
import com.automation.webframe.entity.SysRoleRel.RelType;
import com.automation.webframe.service.SysMenuService;
import com.automation.webframe.service.SysRoleRelService;
import com.automation.webframe.service.SysRoleService;
import com.automation.webframe.utils.HtmlUtils;
import com.automation.webframe.web.vo.SysRoleModel;

/**
 * 
 * 类名称：SysRoleAction <br>
 * 类描述：系统角色Action <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午2:47:33 <br>
 * 修改备注：TODO <br>
 * 
 */
@Controller
@RequestMapping("/sysRole")
public class SysRoleAction extends BaseAction {

	private final static Logger logger = Logger.getLogger(SysRoleAction.class);

	/**  */
	@Autowired(required = false)
	private SysRoleService<SysRole> sysRoleService;

	/**  */
	@Autowired(required = false)
	private SysMenuService<SysMenu> sysMenuService;

	/**  */
	@Autowired(required = false)
	private SysRoleRelService<SysRoleRel> sysRoleRelService;

	/**
	 * 方法：list <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:48:30 <br>
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/role")
	public ModelAndView list(SysRoleModel model, HttpServletRequest request)
			throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("sys/sysRole", context);
	}

	/**
	 * 方法：datalist <br>
	 * 描述：ilook 首页 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:48:39 <br>
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void datalist(SysRoleModel model, HttpServletResponse response)
			throws Exception {
		List<SysRole> dataList = sysRoleService.queryByList(model);
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
	 * 日期： 2013-6-24 下午2:48:46 <br>
	 * 
	 * @param bean
	 * @param menuIds
	 * @param btnIds
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysRole bean, Integer[] menuIds, Integer[] btnIds,
			HttpServletResponse response) throws Exception {
		if (bean.getId() == null) {
			sysRoleService.add(bean, menuIds, btnIds);
		} else {
			sysRoleService.update(bean, menuIds, btnIds);
		}
		sendSuccessMessage(response, "保存成功~");
	}

	/**
	 * 方法：getId <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:48:53 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = new HashMap<String, Object>();
		SysRole bean = sysRoleService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		// 获取权限关联的菜单
		Integer[] menuIds = null;
		List<SysMenu> menuList = sysMenuService.getMenuByRoleId(id);
		if (menuList != null) {
			menuIds = new Integer[menuList.size()];
			int i = 0;
			for (SysMenu item : menuList) {
				menuIds[i] = item.getId();
				i++;
			}
		}
		// 获取权限下关联的按钮
		Integer[] btnIds = null;
		List<SysRoleRel> btnList = sysRoleRelService.queryByRoleId(id,
				RelType.BTN.key);
		if (btnList != null) {
			btnIds = new Integer[btnList.size()];
			int i = 0;
			for (SysRoleRel item : btnList) {
				btnIds[i] = item.getObjId();
				i++;
			}
		}

		// 将对象转成Map
		Map<String, Object> data = BeanUtils.describe(bean);
		data.put("menuIds", menuIds);
		data.put("btnIds", btnIds);
		context.put(SUCCESS, true);
		context.put("data", data);
		HtmlUtils.writerJson(response, context);
	}

	/**
	 * 方法：delete <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:48:58 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletResponse response)
			throws Exception {
		sysRoleService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

	/**
	 * 方法：loadRoleList <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:49:04 <br>
	 * 
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/loadRoleList")
	public void loadRoleList(HttpServletResponse response) throws Exception {
		List<SysRole> roloList = sysRoleService.queryAllList();
		HtmlUtils.writerJson(response, roloList);
	}

}
