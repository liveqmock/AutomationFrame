/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.utils <br>
 * 文件名：SpringContextUtil.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-上午10:48:47<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * 类名称：SpringContextUtil <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 上午10:48:47 <br>
 * 修改备注：TODO <br>
 * 
 */
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext; // Spring应用上下文环境

	/**
	 * 方法：setApplicationContext <br>
	 * 描述：实现ApplicationContextAware接口的回调方法，设置上下文环境 <br>
	 * 
	 * @param arg0
	 * @throws BeansException
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;

	}

	/**
	 * @retrun the applicationContext <br>
	 * 
	 *         时间: 2013-6-24 上午10:50:30 <br>
	 */

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 方法：getBean <br>
	 * 描述：获取对象 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:50:34 <br>
	 * 
	 * @param name
	 * @return 一个以所给名字注册的bean的实例
	 * @throws BeansException
	 */
	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

	/**
	 * 方法：getBean <br>
	 * 描述：获取类型为requiredType的对象
	 * 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException） <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:50:52 <br>
	 * 
	 * @param name
	 *            bean注册名
	 * @param requiredType
	 *            返回对象类型
	 * @return 返回requiredType类型对象
	 * @throws BeansException
	 */
	public static Object getBean(String name, Class requiredType)
			throws BeansException {
		return applicationContext.getBean(name, requiredType);
	}

	/**
	 * 方法：containsBean <br>
	 * 描述：如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:51:13 <br>
	 * 
	 * @param name
	 * @return
	 */
	public static boolean containsBean(String name) {
		return applicationContext.containsBean(name);
	}

	/**
	 * 方法：isSingleton <br>
	 * 描述：判断以给定名字注册的bean定义是一个singleton还是一个prototype。
	 * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException） <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:51:21 <br>
	 * 
	 * @param name
	 * @return
	 * @throws NoSuchBeanDefinitionException
	 */
	public static boolean isSingleton(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.isSingleton(name);
	}

	/**
	 * 方法：getType <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:51:31 <br>
	 * 
	 * @param name
	 * @return 注册对象的类型
	 * @throws NoSuchBeanDefinitionException
	 */
	public static Class getType(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.getType(name);
	}

	/**
	 * 方法：getAliases <br>
	 * 描述： 如果给定的bean名字在bean定义中有别名，则返回这些别名 <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 上午10:51:40 <br>
	 * 
	 * @param name
	 * @return
	 * @throws NoSuchBeanDefinitionException
	 */
	public static String[] getAliases(String name)
			throws NoSuchBeanDefinitionException {
		return applicationContext.getAliases(name);
	}

}
