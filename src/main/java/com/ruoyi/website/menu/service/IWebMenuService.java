package com.ruoyi.website.menu.service;


import com.ruoyi.website.menu.entity.WebMenu;

import java.util.List;
import java.util.Map;

/**
 * 网站菜单 服务层
 * 
 * @author xingyu
 * @date 2019-01-25
 */
public interface IWebMenuService {
	/**
     * 查询网站菜单信息
     * 
     * @param menuId 网站菜单ID
     * @return 网站菜单信息
     */
	WebMenu selectWebMenuById(Long menuId);
	
	/**
     * 查询网站菜单列表
     * 
     * @param webMenu 网站菜单信息
     * @return 网站菜单集合
     */
	List<WebMenu> selectWebMenuList(WebMenu webMenu);
	
	/**
     * 新增网站菜单
     * 
     * @param webMenu 网站菜单信息
     * @return 结果
     */
	int insertWebMenu(WebMenu webMenu);
	
	/**
     * 修改网站菜单
     * 
     * @param webMenu 网站菜单信息
     * @return 结果
     */
	int updateWebMenu(WebMenu webMenu);
		
	/**
     * 删除网站菜单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteWebMenuByIds(String ids);

	/**
	 * 查询项目分类树
	 *
	 * @param webMenu 网站菜单信息
	 * @return 所有分类信息
	 */
	List<Map<String, Object>> selectTree(WebMenu webMenu);

	/**
	 * 查询子数量
	 * @param parentId 父级ID
	 * @return 结果
	 */
	int selectWebMenuCount(Long parentId);

	/**
	 * 根据父ID查询列表
	 * @param parentId 父级ID
	 * @return 结果
	 */
	List<WebMenu> selectWebMenuByParent(Long parentId);

	/**
	 * 查询子菜单列表不包含tag
	 * @param webMenu 菜单
	 * @return 结果
	 */
	List<WebMenu> selectWebMenuChild(WebMenu webMenu);

	/**
	 * 查询tag列表
	 * @param parentId 父级ID
	 * @return 结果
	 */
	List<WebMenu> selectWebMenuTag(Long parentId);
	
}
