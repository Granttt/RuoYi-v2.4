package com.ruoyi.project.system.oss.service;


import com.ruoyi.project.system.oss.entity.SysOss;

import java.util.List;

/**
 * 文件上传 服务层
 * 
 * @author xingyu
 * @date 2019-01-10
 */
public interface ISysOssService 
{
	/**
     * 查询文件上传信息
     * 
     * @param fileId 文件上传ID
     * @return 文件上传信息
     */
	SysOss selectSysOssById(Long fileId);
	
	/**
     * 查询文件上传列表
     * 
     * @param sysOss 文件上传信息
     * @return 文件上传集合
     */
	List<SysOss> selectSysOssList(SysOss sysOss);
	
	/**
     * 新增文件上传
     * 
     * @param sysOss 文件上传信息
     * @return 结果
     */
	int insertSysOss(SysOss sysOss);
	
	/**
     * 修改文件上传
     * 
     * @param sysOss 文件上传信息
     * @return 结果
     */
	int updateSysOss(SysOss sysOss);
		
	/**
     * 删除文件上传信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteSysOssByIds(String ids);
	
}
