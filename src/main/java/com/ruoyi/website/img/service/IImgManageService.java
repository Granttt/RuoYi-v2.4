package com.ruoyi.website.img.service;


import com.ruoyi.website.img.entity.ImgManage;

import java.util.List;

/**
 * 图片管理 服务层
 * 
 * @author xingyu
 * @date 2019-01-12
 */
public interface IImgManageService {
	/**
     * 查询图片管理信息
     * 
     * @param imgId 图片管理ID
     * @return 图片管理信息
     */
	ImgManage selectImgManageById(Long imgId);
	
	/**
     * 查询图片管理列表
     * 
     * @param imgManage 图片管理信息
     * @return 图片管理集合
     */
	List<ImgManage> selectImgManageList(ImgManage imgManage);
	
	/**
     * 新增图片管理
     * 
     * @param imgManage 图片管理信息
     * @return 结果
     */
	int insertImgManage(ImgManage imgManage);
	
	/**
     * 修改图片管理
     * 
     * @param imgManage 图片管理信息
     * @return 结果
     */
	int updateImgManage(ImgManage imgManage);
		
	/**
     * 删除图片管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	int deleteImgManageByIds(String ids);

	/**
	 * 分页查询团队风采
	 * @param imgManage entity
	 * @param arg0 起始位置
	 * @param arg1 分页大小
	 * @return 结果
	 */
	List<ImgManage> selectTeamList(Long menuId, String imageSort, String status, Integer arg0, Integer arg1);

	/**
	 * 查询总条数
	 * @param imgManage entity
	 * @return 总条数
	 */
	int selectImgCount(ImgManage imgManage);
}
