/**
 * 项目名：AutomationFrame <br>
 * 包名：com.automation.webframe.utils <br>
 * 文件名：TreeUtils.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-6-24-下午1:53:30<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.automation.webframe.utils;

import java.util.ArrayList;
import java.util.List;

import com.automation.webframe.entity.SysMenu;
import com.automation.webframe.entity.SysMenuBtn;
import com.automation.webframe.web.vo.TreeNode;

/**
 * 
 * 类名称：TreeUtils <br>
 * 类描述：树工具类 <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-6-24 下午1:53:30 <br>
 * 修改备注：TODO <br>
 * 
 */
public class TreeUtils {

	private final static String MENU_ID = "menu_";

	private final static String BTN_ID = "btn_";

	List<SysMenu> rootMenus;
	List<SysMenu> childMenus;
	List<SysMenuBtn> childBtns;

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:56:30 <br>
	 * 
	 * @param rootMenus
	 * @param childMenus
	 */
	public TreeUtils(List<SysMenu> rootMenus, List<SysMenu> childMenus) {
		this.rootMenus = rootMenus;
		this.childMenus = childMenus;
	}

	/**
	 * 标题：构造器 <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:56:32 <br>
	 * 
	 * @param rootMenus
	 * @param childMenus
	 * @param childBtns
	 */
	public TreeUtils(List<SysMenu> rootMenus, List<SysMenu> childMenus,
			List<SysMenuBtn> childBtns) {
		this.rootMenus = rootMenus;
		this.childMenus = childMenus;
		this.childBtns = childBtns;
	}

	/**
	 * 方法：getTreeNode <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:56:35 <br>
	 * 
	 * @return
	 */
	public List<TreeNode> getTreeNode() {
		return getRootNodes();
	}

	/**
	 * 方法：MenuToNode <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:56:38 <br>
	 * 
	 * @param menu
	 * @return
	 */
	private TreeNode MenuToNode(SysMenu menu) {
		if (menu == null) {
			return null;
		}
		TreeNode node = new TreeNode();
		node.setId(MENU_ID + menu.getId());
		node.setDataId(menu.getId());
		node.setText(menu.getName());
		node.setUrl(menu.getUrl());
		node.setParentId(menu.getParentId());
		node.getAttributes().put("type", "0");
		node.getAttributes().put("id", menu.getId());
		return node;
	}

	/**
	 * 方法：BtnToNode <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:56:44 <br>
	 * 
	 * @param btn
	 * @return
	 */
	private TreeNode BtnToNode(SysMenuBtn btn) {
		if (btn == null) {
			return null;
		}
		TreeNode node = new TreeNode();
		node.setId(BTN_ID + btn.getId());
		node.setDataId(btn.getId());
		node.setText(btn.getBtnName());
		node.setParentId(btn.getMenuid());
		node.getAttributes().put("type", "1");
		node.getAttributes().put("id", btn.getId());
		return node;
	}

	/**
	 * 方法：getRootNodes <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:56:48 <br>
	 * 
	 * @return
	 */
	private List<TreeNode> getRootNodes() {
		List<TreeNode> rootNodes = new ArrayList<TreeNode>();
		for (SysMenu menu : rootMenus) {
			TreeNode node = MenuToNode(menu);
			if (node != null) {
				addChlidNodes(node);
				rootNodes.add(node);
			}
		}
		return rootNodes;
	}

	/**
	 * 方法：addChlidNodes <br>
	 * 描述：TODO <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:56:51 <br>
	 * 
	 * @param rootNode
	 */
	private void addChlidNodes(TreeNode rootNode) {
		List<TreeNode> childNodes = new ArrayList<TreeNode>();
		for (SysMenu menu : childMenus) {
			if (rootNode.getDataId().equals(menu.getParentId())) {
				TreeNode node = MenuToNode(menu);
				if (childBtns != null && !childBtns.isEmpty()) {
					addChlidBtn(node);
				}
				childNodes.add(node);
			}
		}
		rootNode.setChildren(childNodes);
	}

	/**
	 * 方法：addChlidBtn <br>
	 * 描述： 设置菜单button <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-6-24 下午1:56:57 <br>
	 * 
	 * @param treeNode
	 */
	private void addChlidBtn(TreeNode treeNode) {
		List<TreeNode> childNodes = new ArrayList<TreeNode>();
		for (SysMenuBtn btn : childBtns) {
			if (treeNode.getDataId().equals(btn.getMenuid())) {
				TreeNode node = BtnToNode(btn);
				childNodes.add(node);
			}
		}
		treeNode.setChildren(childNodes);
	}

}
