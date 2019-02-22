package com.ruoyi.website.menu.mapper;


import com.ruoyi.website.menu.entity.WebMenu;

import java.util.List;

/**
 * 网站菜单 数据层
 * 
 * @author xingyu
 * @date 2019-01-25
 */
public interface WebMenuMapper {
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
     * 删除网站菜单
     * 
     * @param menuId 网站菜单ID
     * @return 结果
     */
	int deleteWebMenuById(Integer menuId);
	
	/**
     * 批量删除网站菜单
     * 
     * @param menuIds 需要删除的数据ID
     * @return 结果
     */
	int deleteWebMenuByIds(String[] menuIds);

	/**
	 * 查询分类总数
	 * @param webMenu 分类
	 * @return 结果
	 */
	int selectWebMenuCount(WebMenu webMenu);

	/**
	 * 根据父ID查询列表
	 * @param parentId 父ID
	 * @return
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
	 * @param parentId 父ID
	 * @return 结果
	 */
	List<WebMenu> selectWebMenuTag(Long parentId);
	
}