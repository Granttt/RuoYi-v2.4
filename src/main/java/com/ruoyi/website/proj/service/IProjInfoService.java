package com.ruoyi.website.proj.service;


import com.ruoyi.website.proj.entity.ProjInfo;

import java.util.List;

/**
 * 项目 服务层
 * 
 * @author xingyu
 * @date 2019-01-15
 */
public interface IProjInfoService {
	/**
     * 查询项目信息
     * 
     * @param id 项目ID
     * @return 项目信息
     */
	ProjInfo selectProjInfoById(String id);
	
	/**
     * 查询项目列表
     * 
     * @param projInfo 项目信息
     * @return 项目集合
     */
	List<ProjInfo> selectProjInfoList(ProjInfo projInfo);
	
	/**
     * 新增项目
     * 
     * @param projInfo 项目信息
     * @return 结果
     */
	int insertProjInfo(ProjInfo projInfo);
	
	/**
     * 修改项目
     * 
     * @param projInfo 项目信息
     * @return 结果
     */
	int updateProjInfo(ProjInfo projInfo);
		
	/**
     * 删除项目信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteProjInfoByIds(String ids);
	
}
