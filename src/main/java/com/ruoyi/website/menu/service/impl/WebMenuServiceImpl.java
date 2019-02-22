package com.ruoyi.website.menu.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.support.Convert;
import com.ruoyi.website.menu.entity.WebMenu;
import com.ruoyi.website.menu.mapper.WebMenuMapper;
import com.ruoyi.website.menu.service.IWebMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网站菜单 服务层实现
 * 
 * @author xingyu
 * @date 2019-01-25
 */
@Service
public class WebMenuServiceImpl implements IWebMenuService {

	@Autowired
	private WebMenuMapper webMenuMapper;

	/**
     * 查询网站菜单信息
     * 
     * @param menuId 网站菜单ID
     * @return 网站菜单信息
     */
    @Override
	public WebMenu selectWebMenuById(Long menuId) {
	    return webMenuMapper.selectWebMenuById(menuId);
	}
	
	/**
     * 查询网站菜单列表
     * 
     * @param webMenu 网站菜单信息
     * @return 网站菜单集合
     */
	@Override
	public List<WebMenu> selectWebMenuList(WebMenu webMenu) {
	    return webMenuMapper.selectWebMenuList(webMenu);
	}

	/**
	 * 查询子数量
	 *
	 * @param parentId ID
	 * @return 结果
	 */
	@Override
	public int selectWebMenuCount(Long parentId) {
		WebMenu webMenu = new WebMenu();
		webMenu.setParentId(parentId);
		return webMenuMapper.selectWebMenuCount(webMenu);
	}
	
    /**
     * 新增网站菜单
     * 
     * @param webMenu 网站菜单信息
     * @return 结果
     */
	@Override
	public int insertWebMenu(WebMenu webMenu) {
		WebMenu webMenu2 = webMenuMapper.selectWebMenuById(webMenu.getParentId());
		webMenu.setAncestors(webMenu2.getAncestors()+","+webMenu.getParentId());
	    return webMenuMapper.insertWebMenu(webMenu);
	}
	
	/**
     * 修改网站菜单
     * 
     * @param webMenu 网站菜单信息
     * @return 结果
     */
	@Override
	public int updateWebMenu(WebMenu webMenu) {
		WebMenu webMenu2 = webMenuMapper.selectWebMenuById(webMenu.getParentId());
		webMenu.setAncestors(webMenu2.getAncestors()+","+webMenu.getParentId());
	    return webMenuMapper.updateWebMenu(webMenu);
	}

	/**
     * 删除网站菜单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteWebMenuByIds(String ids) {
		return webMenuMapper.deleteWebMenuByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Map<String, Object>> selectTree(WebMenu webMenu) {
		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		List<WebMenu> menuList = webMenuMapper.selectWebMenuList(webMenu);
		trees = getTrees(menuList);
		return trees;
	}
	@Override
	public List<WebMenu> selectWebMenuByParent(Long parentId){
		List<WebMenu> menuList = webMenuMapper.selectWebMenuByParent(parentId);
		return menuList;
	}

	@Override
	public List<WebMenu> selectWebMenuChild(WebMenu webMenu) {
		List<WebMenu> menuList = webMenuMapper.selectWebMenuChild(webMenu);
		return menuList;
	}

	@Override
	public List<WebMenu> selectWebMenuTag(Long parentId) {
		List<WebMenu> menuList = webMenuMapper.selectWebMenuTag(parentId);
		return menuList;
	}

	/**
	 * 对象转菜单树
	 *
	 * @param menuList     列表
	 * @return 菜单树
	 */
	public List<Map<String, Object>> getTrees(List<WebMenu> menuList) {
		List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
		for (WebMenu menu : menuList) {
			if (UserConstants.DEPT_NORMAL.equals(menu.getStatus())) {
				Map<String, Object> menuMap = new HashMap<String, Object>(16);
				menuMap.put("id", menu.getMenuId());
				menuMap.put("pId", menu.getParentId());
				menuMap.put("name", menu.getMenuName());
				menuMap.put("title", menu.getMenuName());
				trees.add(menuMap);
			}
		}
		return trees;
	}


}
