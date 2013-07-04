/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.web.action.system <br>
 * 文件名：SysUserAction.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午2:50:10<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.web.action.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.automation.exception.ServiceException;
import com.automation.utils.MethodUtils;
import com.automation.webframe.entity.BaseBean.DELETED;
import com.automation.webframe.entity.BaseBean.STATE;
import com.automation.webframe.entity.SysRole;
import com.automation.webframe.entity.SysRoleRel;
import com.automation.webframe.entity.SysUser;
import com.automation.webframe.service.SysRoleService;
import com.automation.webframe.service.SysUserService;
import com.automation.webframe.utils.HtmlUtils;
import com.automation.webframe.utils.SessionUtils;
import com.automation.webframe.web.vo.SysUserModel;

/**
 * 
 * 类名称：SysUserAction <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午2:50:10 <br>
 * 修改备注：TODO <br>
 * 
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserAction extends BaseAction {

	/**  */
	private final static Logger logger = Logger.getLogger(SysUserAction.class);

	/** 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。 */
	@Autowired(required = false)
	private SysUserService<SysUser> sysUserService;

	/**  */
	@Autowired(required = false)
	private SysRoleService<SysRole> sysRoleService;

	/**
	 * 方法：list <br>
	 * 描述：ilook 首页 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:51:00 <br>
	 * 
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(SysUserModel model, HttpServletRequest request)
			throws Exception {
		Map<String, Object> context = getRootMap();
		List<SysUser> dataList = sysUserService.queryByList(model);
		// 设置页面数据
		context.put("dataList", dataList);
		return forword("sys/sysUser", context);
	}

	/**
	 * 方法：dataList <br>
	 * 描述：json 列表页面 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:51:07 <br>
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/dataList")
	public void dataList(SysUserModel model, HttpServletResponse response)
			throws Exception {
		List<SysUser> dataList = sysUserService.queryByList(model);
		for (SysUser user : dataList) {
			List<SysRole> list = sysRoleService.queryByUserid(user.getId());
			user.setRoleStr(rolesToStr(list));
		}
		// 设置页面数据
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtils.writerJson(response, jsonMap);
	}

	/**
	 * 方法：rolesToStr <br>
	 * 描述： 角色列表转成字符串 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:51:16 <br>
	 * 
	 * @param list
	 * @return
	 */
	private String rolesToStr(List<SysRole> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			SysRole role = list.get(i);
			str.append(role.getRoleName());
			if ((i + 1) < list.size()) {
				str.append(",");
			}
		}
		return str.toString();
	}

	/**
	 * 方法：save <br>
	 * 描述：添加或修改数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:51:25 <br>
	 * 
	 * @param bean
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(SysUser bean, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = new HashMap<String, Object>();
		int count = sysUserService.getUserCountByEmail(bean.getEmail());
		if (bean.getId() == null) {
			if (count > 0) {
				throw new ServiceException("用户已存在.");
			}
			bean.setDeleted(DELETED.NO.key);
			sysUserService.add(bean);
		} else {
			if (count > 1) {
				throw new ServiceException("用户已存在.");
			}
			sysUserService.updateBySelective(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}

	/**
	 * 方法：getId <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:51:30 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	public void getId(Integer id, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = getRootMap();
		SysUser bean = sysUserService.queryById(id);
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
	 * 日期： 2013-6-24 下午2:51:32 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(Integer[] id, HttpServletResponse response)
			throws Exception {
		sysUserService.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

	/**
	 * 方法：updatePwd <br>
	 * 描述：添加或修改数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:51:38 <br>
	 * 
	 * @param id
	 * @param oldPwd
	 * @param newPwd
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/updatePwd")
	public void updatePwd(Integer id, String oldPwd, String newPwd,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		boolean isAdmin = SessionUtils.isAdmin(request); // 是否超级管理员
		SysUser bean = sysUserService.queryById(id);
		if (bean.getId() == null || DELETED.YES.key == bean.getDeleted()) {
			sendFailureMessage(response, "Sorry ,User is not exists.");
			return;
		}
		if (StringUtils.isBlank(newPwd)) {
			sendFailureMessage(response, "Password is required.");
			return;
		}
		// 不是超级管理员，匹配旧密码
		if (!isAdmin && !MethodUtils.ecompareMD5(oldPwd, bean.getPwd())) {
			sendFailureMessage(response, "Wrong old password.");
			return;
		}
		bean.setPwd(MethodUtils.MD5(newPwd));
		sysUserService.update(bean);
		sendSuccessMessage(response, "保存成功~");
	}

	/**
	 * 方法：userRole <br>
	 * 描述：用户授权页面 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:51:52 <br>
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userRole")
	public ModelAndView userRole(HttpServletRequest request) throws Exception {
		Map<String, Object> context = getRootMap();
		return forword("/sys/sysUserRole", context);
	}

	/**
	 * 方法：userList <br>
	 * 描述：用户授权列表 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:51:58 <br>
	 * 
	 * @param model
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/userList")
	public void userList(SysUserModel model, HttpServletResponse response)
			throws Exception {
		model.setState(STATE.ENABLE.key);
		dataList(model, response);
	}

	/**
	 * 方法：getUser <br>
	 * 描述：查询用户信息 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:52:06 <br>
	 * 
	 * @param id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/getUser")
	public void getUser(Integer id, HttpServletResponse response)
			throws Exception {
		Map<String, Object> context = getRootMap();
		SysUser bean = sysUserService.queryById(id);
		if (bean == null) {
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		Integer[] roleIds = null;
		List<SysRoleRel> roles = sysUserService.getUserRole(bean.getId());
		if (roles != null) {
			roleIds = new Integer[roles.size()];
			int i = 0;
			for (SysRoleRel rel : roles) {
				roleIds[i] = rel.getRoleId();
				i++;
			}
		}

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", bean.getId());
		data.put("email", bean.getEmail());
		data.put("roleIds", roleIds);
		context.put(SUCCESS, true);
		context.put("data", data);
		HtmlUtils.writerJson(response, context);

	}

	/**
	 * 方法：addUserRole <br>
	 * 描述：添加或修改数据 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午2:52:14 <br>
	 * 
	 * @param id
	 * @param roleIds
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/addUserRole")
	public void addUserRole(Integer id, Integer roleIds[],
			HttpServletResponse response) throws Exception {
		sysUserService.addUserRole(id, roleIds);
		sendSuccessMessage(response, "保存成功");
	}
}
