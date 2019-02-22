package com.ruoyi.project.system.oss.mapper;


import com.ruoyi.project.system.oss.entity.SysOss;

import java.util.List;

/**
 * 文件上传 数据层
 * 
 * @author xingyu
 * @date 2019-01-10
 */
public interface SysOssMapper 
{
	/**
     * 查询文件上传信息
     * 
     * @param fileId 文件上传ID
     * @return 文件上传信息
     */
	public SysOss selectSysOssById(Long fileId);
	
	/**
     * 查询文件上传列表
     * 
     * @param sysOss 文件上传信息
     * @return 文件上传集合
     */
	public List<SysOss> selectSysOssList(SysOss sysOss);
	
	/**
     * 新增文件上传
     * 
     * @param sysOss 文件上传信息
     * @return 结果
     */
	public int insertSysOss(SysOss sysOss);
	
	/**
     * 修改文件上传
     * 
     * @param sysOss 文件上传信息
     * @return 结果
     */
	public int updateSysOss(SysOss sysOss);
	
	/**
     * 删除文件上传
     * 
     * @param fileId 文件上传ID
     * @return 结果
     */
	public int deleteSysOssById(Long fileId);
	
	/**
     * 批量删除文件上传
     * 
     * @param fileIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSysOssByIds(String[] fileIds);
	
}