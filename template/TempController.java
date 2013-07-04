/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.action <br>
 * 文件名：${className}.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：${time} <br>
 * Copyright (c) 2013 ${copyright}-版权所有<br>
 *
 */
package com.automation.webframe.web.action.${classNameLower};

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


import com.automation.webframe.bean.${className};
import com.automation.webframe.bean.SiteType;
import com.automation.webframe.bean.BaseBean.DELETED;
import com.automation.webframe.model.${className}Model;
import com.automation.webframe.service.${className}Service;
import com.automation.webframe.utils.HtmlUtils;
 

/**
 * 
 * 类名称：${className} <br>
 * 类描述：${remark}Action <br>
 * 创建人：${createUser} <br>
 * 修改人：${modifyUser} <br>
 * 修改时间：${time} <br>
 * 修改备注：TODO <br>
 * 
 */
@Controller
@RequestMapping("/${lowerName}") 
public class ${className}Action extends BaseAction{
	
	/* 输出日志**/
	private final static Logger loggger= Logger.getLogger(${className}Action.class);
	
	// Servrice start
	/* 自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错 **/
	@Autowired(required=false)
	private ${className}Service<${className}> ${lowerName}Service; 
	
	
	
	
	
	/**
	 * 方法：list <br>
	 * 描述：查询列表 <br>
	 * 作者：${author} <br>
	 * 日期：${time} <br>
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list") 
	public ModelAndView list(${className}Model model,HttpServletRequest request) throws Exception{
		Map<String,Object>  context = getRootMap();
		return forword("${lowerName}/list",context); 
	}
	
	
	/**
	 * 方法：datalist <br>
	 * 描述：查询数据列表 <br>
	 * 作者：${author} <br>
	 * 日期：${time} <br>
	 * 
	 * @param model
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/dataList") 
	public void  datalist(${className}Model model,HttpServletResponse response) throws Exception{
		model.setDeleted(0);
		List<${className}> dataList = ${lowerName}Service.queryByList(model);
		//设置页面数据
		Map<String,Object> jsonMap = new HashMap<String,Object>();
		jsonMap.put("total",model.getPager().getRowCount());
		jsonMap.put("rows", dataList);
		HtmlUtil.writerJson(response, jsonMap);
	}
	
	/**
	 * 方法：save <br>
	 * 描述：添加或保存数据 <br>
	 * 作者：${author} <br>
	 * 日期：${time} <br>
	 * 
	 * @param bean
	 * @param typeIds
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public void save(${className} bean,Integer[] typeIds,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = new HashMap<String,Object>();
		bean.setDeleted(DELETED.NO.key);
		if(bean.getId() == null){
			${lowerName}Service.add(bean);
		}else{
			${lowerName}Service.update(bean);
		}
		sendSuccessMessage(response, "保存成功~");
	}
	
	/**
	 * 方法：getId <br>
	 * 描述：根据ID查询 <br>
	 * 作者：${author} <br>
	 * 日期：${time} <br>
	 * 
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getId")
	public void getId(Integer id,HttpServletResponse response) throws Exception{
		Map<String,Object>  context = new HashMap();
		${className} bean  = ${lowerName}Service.queryById(id);
		if(bean  == null){
			sendFailureMessage(response, "没有找到对应的记录!");
			return;
		}
		context.put(SUCCESS, true);
		context.put("data", bean);
		HtmlUtil.writerJson(response, context);
	}
	
	
	/**
	 * 方法：delete <br>
	 * 描述：删除 <br>
	 * 作者：${author} <br>
	 * 日期：${time} <br>
	 * 
	 * @param id
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public void delete(Integer id,HttpServletResponse response) throws Exception{
		${lowerName}Service.delete(id);
		sendSuccessMessage(response, "删除成功");
	}

}
