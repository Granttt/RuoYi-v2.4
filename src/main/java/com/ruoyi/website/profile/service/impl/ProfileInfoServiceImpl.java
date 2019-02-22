package com.ruoyi.website.profile.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.website.profile.entity.ProfileInfo;
import com.ruoyi.website.profile.mapper.ProfileInfoMapper;
import com.ruoyi.website.profile.service.IProfileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公司简介 服务层实现
 * 
 * @author xingyu
 * @date 2019-01-28
 */
@Service
public class ProfileInfoServiceImpl implements IProfileInfoService {
	@Autowired
	private ProfileInfoMapper profileInfoMapper;

	/**
     * 查询公司简介信息
     * 
     * @param proId 公司简介ID
     * @return 公司简介信息
     */
    @Override
	public ProfileInfo selectProfileInfoById(Integer proId) {
	    return profileInfoMapper.selectProfileInfoById(proId);
	}
	
	/**
     * 查询公司简介列表
     * 
     * @param profileInfo 公司简介信息
     * @return 公司简介集合
     */
	@Override
	public List<ProfileInfo> selectProfileInfoList(ProfileInfo profileInfo) {
	    return profileInfoMapper.selectProfileInfoList(profileInfo);
	}
	
    /**
     * 新增公司简介
     * 
     * @param profileInfo 公司简介信息
     * @return 结果
     */
	@Override
	public int insertProfileInfo(ProfileInfo profileInfo) {
	    return profileInfoMapper.insertProfileInfo(profileInfo);
	}
	
	/**
     * 修改公司简介
     * 
     * @param profileInfo 公司简介信息
     * @return 结果
     */
	@Override
	public int updateProfileInfo(ProfileInfo profileInfo) {
	    return profileInfoMapper.updateProfileInfo(profileInfo);
	}

	/**
     * 删除公司简介对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProfileInfoByIds(String ids) {
		return profileInfoMapper.deleteProfileInfoByIds(Convert.toStrArray(ids));
	}
	
}
