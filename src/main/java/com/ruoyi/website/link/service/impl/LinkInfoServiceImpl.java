package com.ruoyi.website.link.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.website.link.entity.LinkInfo;
import com.ruoyi.website.link.mapper.LinkInfoMapper;
import com.ruoyi.website.link.service.ILinkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公司联系方式 服务层实现
 * 
 * @author xingyu
 * @date 2019-01-14
 */
@Service
public class LinkInfoServiceImpl implements ILinkInfoService {
	@Autowired
	private LinkInfoMapper linkInfoMapper;

	/**
     * 查询公司联系方式信息
     * 
     * @param linkId 公司联系方式ID
     * @return 公司联系方式信息
     */
    @Override
	public LinkInfo selectLinkInfoById(Integer linkId) {
	    return linkInfoMapper.selectLinkInfoById(linkId);
	}
	
	/**
     * 查询公司联系方式列表
     * 
     * @param linkInfo 公司联系方式信息
     * @return 公司联系方式集合
     */
	@Override
	public List<LinkInfo> selectLinkInfoList(LinkInfo linkInfo) {
	    return linkInfoMapper.selectLinkInfoList(linkInfo);
	}
	
    /**
     * 新增公司联系方式
     * 
     * @param linkInfo 公司联系方式信息
     * @return 结果
     */
	@Override
	public int insertLinkInfo(LinkInfo linkInfo) {
	    return linkInfoMapper.insertLinkInfo(linkInfo);
	}
	
	/**
     * 修改公司联系方式
     * 
     * @param linkInfo 公司联系方式信息
     * @return 结果
     */
	@Override
	public int updateLinkInfo(LinkInfo linkInfo) {
	    return linkInfoMapper.updateLinkInfo(linkInfo);
	}

	/**
     * 删除公司联系方式对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLinkInfoByIds(String ids) {
		return linkInfoMapper.deleteLinkInfoByIds(Convert.toStrArray(ids));
	}
	
}
