package com.ruoyi.website.link.service;


import com.ruoyi.website.link.entity.LinkInfo;

import java.util.List;

/**
 * 公司联系方式 服务层
 * 
 * @author xingyu
 * @date 2019-01-14
 */
public interface ILinkInfoService {
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
     * 删除公司联系方式信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteLinkInfoByIds(String ids);
	
}
