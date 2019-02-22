package com.ruoyi.website.img.mapper;

import com.ruoyi.website.img.entity.ImgManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图片管理 数据层
 * 
 * @author xingyu
 * @date 2019-01-12
 */
public interface ImgManageMapper {
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
     * 删除图片管理
     * 
     * @param imgId 图片管理ID
     * @return 结果
     */
	int deleteImgManageById(Long imgId);
	
	/**
     * 批量删除图片管理
     * 
     * @param imgIds 需要删除的数据ID
     * @return 结果
     */
	int deleteImgManageByIds(String[] imgIds);

	/**
	 * 分页查询团队风采
	 * @param arg0 起始位置
	 * @param arg1 分页大小
	 * @return 结果
	 */
	List<ImgManage> selectTeamList(@Param("menuId") Long menuId, @Param("imageSort") String imageSort, @Param("status") String status, @Param("arg0") Integer arg0, @Param("arg1") Integer arg1);

	/**
	 * 查询总条数
	 * @param imgManage entity
	 * @return 结果
	 */
	int selectImgCount(ImgManage imgManage);
	
}