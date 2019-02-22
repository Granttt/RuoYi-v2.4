package com.ruoyi.website.link.mapper;


import com.ruoyi.website.link.entity.LinkInfo;

import java.util.List;

/**
 * 公司联系方式 数据层
 * 
 * @author xingyu
 * @date 2019-01-14
 */
public interface LinkInfoMapper {
	/**
     * 查询公司联系方式信息
     * 
     * @param linkId 公司联系方式ID
     * @return 公司联系方式信息
     */
	LinkInfo selectLinkInfoById(Integer linkId);
	
	/**
     * 查询公司联系方式列表
     * 
     * @param linkInfo 公司联系方式信息
     * @return 公司联系方式集合
     */
	List<LinkInfo> selectLinkInfoList(LinkInfo linkInfo);
	
	/**
     * 新增公司联系方式
     * 
     * @param linkInfo 公司联系方式信息
     * @return 结果
     */
	int insertLinkInfo(LinkInfo linkInfo);
	
	/**
     * 修改公司联系方式
     * 
     * @param linkInfo 公司联系方式信息
     * @return 结果
     */
	int updateLinkInfo(LinkInfo linkInfo);
	
	/**
     * 删除公司联系方式
     * 
     * @param linkId 公司联系方式ID
     * @return 结果
     */
	int deleteLinkInfoById(Integer linkId);
	
	/**
     * 批量删除公司联系方式
     * 
     * @param linkIds 需要删除的数据ID
     * @return 结果
     */
	int deleteLinkInfoByIds(String[] linkIds);
	
}