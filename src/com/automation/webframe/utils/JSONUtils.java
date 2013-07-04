/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.utils <br>
 * 文件名：JSONUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午1:44:53<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

import com.automation.utils.DateUtils;

/**
 * 
 * 类名称：JSONUtils <br>
 * 类描述：JSON工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午1:44:53 <br>
 * 修改备注：TODO <br>
 * 
 */
public class JSONUtils {

	private static JSONUtils instance = null;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:45:55 <br>
	 */
	public JSONUtils() {

	}

	/**
	 * 方法：proxyCheck <br>
	 * 描述：代理类时做的检查.返回应该检查的对象. <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:46:02 <br>
	 * 
	 * @param bean
	 * @return
	 */
	protected Object proxyCheck(Object bean) {
		return bean;
	}

	/**
	 * 方法：toJSONString <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:46:10 <br>
	 * 
	 * @param obj
	 * @return
	 * @throws JSONException
	 */
	static public String toJSONString(Object obj) throws JSONException {
		return toJSONString(obj, false);
	}

	/**
	 * 方法：toJSONString <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:46:14 <br>
	 * 
	 * @param obj
	 * @param useClassConvert
	 * @return
	 * @throws JSONException
	 */
	static public String toJSONString(Object obj, boolean useClassConvert)
			throws JSONException {
		if (instance == null)
			instance = new JSONUtils();
		return instance.getJSONObject(obj, useClassConvert).toString();
	}

	/**
	 * 方法：getJSONArray <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:46:21 <br>
	 * 
	 * @param arrayObj
	 * @param useClassConvert
	 * @return
	 * @throws JSONException
	 */
	@SuppressWarnings("unchecked")
	private String getJSONArray(Object arrayObj, boolean useClassConvert)
			throws JSONException {
		if (arrayObj == null) {
			return "null";
		}
		arrayObj = proxyCheck(arrayObj);
		JSONArray jSONArray = new JSONArray();
		if (arrayObj instanceof Collection) {
			Iterator iterator = ((Collection) arrayObj).iterator();
			while (iterator.hasNext()) {
				Object rowObj = iterator.next();
				if (rowObj == null)
					jSONArray.put(new JSONStringObject(null));
				else if (rowObj.getClass().isArray()
						|| rowObj instanceof Collection)
					jSONArray.put(getJSONArray(rowObj, useClassConvert));
				else
					jSONArray.put(getJSONObject(rowObj, useClassConvert));
			}
		}
		if (arrayObj.getClass().isArray()) {
			int arrayLength = Array.getLength(arrayObj);
			for (int i = 0; i < arrayLength; i++) {
				Object rowObj = Array.get(arrayObj, i);
				if (rowObj == null)
					jSONArray.put(new JSONStringObject(null));
				else if (rowObj.getClass().isArray()
						|| rowObj instanceof Collection)
					jSONArray.put(getJSONArray(rowObj, useClassConvert));
				else
					jSONArray.put(getJSONObject(rowObj, useClassConvert));
			}
		}
		return jSONArray.toString();
	}

	/**
	 * 方法：getJSONObject <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:46:37 <br>
	 * 
	 * @param value
	 * @param useClassConvert
	 * @return
	 * @throws JSONException
	 */
	@SuppressWarnings("unchecked")
	JSONStringObject getJSONObject(Object value, boolean useClassConvert)
			throws JSONException {
		// 处理原始类型
		if (value == null) {
			return new JSONStringObject("null");
		}
		value = proxyCheck(value);
		if (value instanceof JSONString) {
			Object o;
			try {
				o = ((JSONString) value).toJSONString();
			} catch (Exception e) {
				throw new JSONException(e);
			}
			throw new JSONException("Bad value from toJSONString: " + o);
		}
		if (value instanceof Number) {
			return new JSONStringObject(
					JSONObject.numberToString((Number) value));
		}
		if (value instanceof Boolean || value instanceof JSONObject
				|| value instanceof JSONArray) {
			return new JSONStringObject(value.toString());
		}
		if (value instanceof Timestamp) {
			String str = DateUtils.getFormattedDateUtil((Timestamp) value,
					"yyyy-MM-dd HH:mm:ss");
			return new JSONStringObject(JSONObject.quote(str));
		}
		if (value instanceof Date) {
			String str = DateUtils.getFormattedDateUtil((Date) value,
					"yyyy-MM-dd HH:mm:ss");
			return new JSONStringObject(JSONObject.quote(str));
		}
		if (value instanceof String)
			return new JSONStringObject(JSONObject.quote(value.toString()));
		if (value instanceof Map) {

			JSONObject jSONObject = new JSONObject();

			Iterator iterator = ((Map) value).keySet().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next().toString();
				Object valueObj = ((Map) value).get(key);
				jSONObject.put(key, getJSONObject(valueObj, useClassConvert));
			}
			return new JSONStringObject(jSONObject.toString());
		}
		// class
		if (value instanceof Class)
			return new JSONStringObject(JSONObject.quote(((Class) value)
					.getSimpleName()));
		// 数组
		if (value instanceof Collection || value.getClass().isArray()) {
			return new JSONStringObject(getJSONArray(proxyCheck(value),
					useClassConvert));
		}
		return reflectObject(value, useClassConvert);
	}// value.equals(null)

	/**
	 * 方法：reflectObject <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:46:50 <br>
	 * 
	 * @param bean
	 * @param useClassConvert
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private JSONStringObject reflectObject(Object bean, boolean useClassConvert) {
		JSONObject jSONObject = new JSONObject();

		Class klass = bean.getClass();
		Method[] methods = klass.getMethods();
		for (int i = 0; i < methods.length; i += 1) {
			try {
				Method method = methods[i];
				String name = method.getName();
				String key = "";
				if (name.startsWith("get")) {
					key = name.substring(3);
				} else if (name.startsWith("is")) {
					key = name.substring(2);
				}
				if (key.length() > 0 && Character.isUpperCase(key.charAt(0))
						&& method.getParameterTypes().length == 0) {
					if (key.length() == 1) {
						key = key.toLowerCase();
					} else if (!Character.isUpperCase(key.charAt(1))) {
						key = key.substring(0, 1).toLowerCase()
								+ key.substring(1);
					}
					Object elementObj = method.invoke(bean, null);
					if (!useClassConvert && elementObj instanceof Class)
						continue;
					jSONObject.put(key,
							getJSONObject(elementObj, useClassConvert));
				}
			} catch (Exception e) {
				/**//* forget about it */
			}
		}
		return new JSONStringObject(jSONObject.toString());
	}
}
