package com.ruoyi.website.profile.service;


import com.ruoyi.website.profile.entity.ProfileInfo;

import java.util.List;

/**
 * 公司简介 服务层
 * 
 * @author xingyu
 * @date 2019-01-28
 */
public interface IProfileInfoService {
	/**
     * 查询公司简介信息
     * 
     * @param proId 公司简介ID
     * @return 公司简介信息
     */
	ProfileInfo selectProfileInfoById(Integer proId);
	
	/**
     * 查询公司简介列表
     * 
     * @param profileInfo 公司简介信息
     * @return 公司简介集合
     */
	List<ProfileInfo> selectProfileInfoList(ProfileInfo profileInfo);
	
	/**
     * 新增公司简介
     * 
     * @param profileInfo 公司简介信息
     * @return 结果
     */
	int insertProfileInfo(ProfileInfo profileInfo);
	
	/**
     * 修改公司简介
     * 
     * @param profileInfo 公司简介信息
     * @return 结果
     */
	int updateProfileInfo(ProfileInfo profileInfo);
		
	/**
     * 删除公司简介信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteProfileInfoByIds(String ids);
	
}
