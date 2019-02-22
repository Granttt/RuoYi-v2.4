package com.ruoyi.website.proj.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.website.proj.entity.ProjInfo;
import com.ruoyi.website.proj.mapper.ProjInfoMapper;
import com.ruoyi.website.proj.service.IProjInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目 服务层实现
 * 
 * @author xingyu
 * @date 2019-01-15
 */
@Service
public class ProjInfoServiceImpl implements IProjInfoService {
	@Autowired
	private ProjInfoMapper projInfoMapper;

	/**
     * 查询项目信息
     * 
     * @param id 项目ID
     * @return 项目信息
     */
    @Override
	public ProjInfo selectProjInfoById(String id) {
	    return projInfoMapper.selectProjInfoById(id);
	}
	
	/**
     * 查询项目列表
     * 
     * @param projInfo 项目信息
     * @return 项目集合
     */
	@Override
	public List<ProjInfo> selectProjInfoList(ProjInfo projInfo) {
	    return projInfoMapper.selectProjInfoList(projInfo);
	}
	
    /**
     * 新增项目
     * 
     * @param projInfo 项目信息
     * @return 结果
     */
	@Override
	public int insertProjInfo(ProjInfo projInfo) {
	    return projInfoMapper.insertProjInfo(projInfo);
	}
	
	/**
     * 修改项目
     * 
     * @param projInfo 项目信息
     * @return 结果
     */
	@Override
	public int updateProjInfo(ProjInfo projInfo) {
	    return projInfoMapper.updateProjInfo(projInfo);
	}

	/**
     * 删除项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProjInfoByIds(String ids) {
		return projInfoMapper.deleteProjInfoByIds(Convert.toStrArray(ids));
	}
	
}
