package com.ruoyi.website.img.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.website.img.entity.ImgManage;
import com.ruoyi.website.img.mapper.ImgManageMapper;
import com.ruoyi.website.img.service.IImgManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图片管理 服务层实现
 * 
 * @author xingyu
 * @date 2019-01-12
 */
@Service
public class ImgManageServiceImpl implements IImgManageService {
	@Autowired
	private ImgManageMapper imgManageMapper;

	/**
     * 查询图片管理信息
     * 
     * @param imgId 图片管理ID
     * @return 图片管理信息
     */
    @Override
	public ImgManage selectImgManageById(Long imgId) {
	    return imgManageMapper.selectImgManageById(imgId);
	}
	
	/**
     * 查询图片管理列表
     * 
     * @param imgManage 图片管理信息
     * @return 图片管理集合
     */
	@Override
	public List<ImgManage> selectImgManageList(ImgManage imgManage) {
	    return imgManageMapper.selectImgManageList(imgManage);
	}
	
    /**
     * 新增图片管理
     * 
     * @param imgManage 图片管理信息
     * @return 结果
     */
	@Override
	public int insertImgManage(ImgManage imgManage) {
	    return imgManageMapper.insertImgManage(imgManage);
	}
	
	/**
     * 修改图片管理
     * 
     * @param imgManage 图片管理信息
     * @return 结果
     */
	@Override
	public int updateImgManage(ImgManage imgManage) {
	    return imgManageMapper.updateImgManage(imgManage);
	}

	/**
     * 删除图片管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteImgManageByIds(String ids) {
		return imgManageMapper.deleteImgManageByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<ImgManage> selectTeamList(Long menuId,String imageSort,String status ,Integer arg0, Integer arg1) {
		return imgManageMapper.selectTeamList(menuId,imageSort,status,arg0,arg1);
	}

	@Override
	public int selectImgCount(ImgManage imgManage) {
		return imgManageMapper.selectImgCount(imgManage);
	}

}
