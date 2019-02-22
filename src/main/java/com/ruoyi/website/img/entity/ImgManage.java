package com.ruoyi.website.img.entity;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 图片管理表 img_manage
 *
 * @author xingyu
 * @date 2019-01-12
 */
public class ImgManage extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long imgId;
    /**
     * 分类id
     */
    private Long menuId;
    /**
     * 分类名称
     */
    private String menuName;
    /**
     * 图片名称
     */
    private String imageName;
    /**
     * 图片描述
     */
    private String imageDesc;
    /**
     * 图片内容
     */
    private String imageContent;
    /**
     * 图片链接
     */
    private String imageUrl;
    /**
     * 图片分类
     */
    private String imageSort;
    /**
     * 显示顺序
     */
    private Integer orderNum;
    /**
     * 状态（0正常 1停用）
     */
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public Long getImgId() {
        return imgId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageDesc(String imageDesc) {
        this.imageDesc = imageDesc;
    }

    public String getImageDesc() {
        return imageDesc;
    }

    public void setImageContent(String imageContent) {
        this.imageContent = imageContent;
    }

    public String getImageContent() {
        return imageContent;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageSort(String imageSort) {
        this.imageSort = imageSort;
    }

    public String getImageSort() {
        return imageSort;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("imgId" , getImgId())
                .append("menuId" , getMenuId())
                .append("menuName", getMenuName())
                .append("imageName" , getImageName())
                .append("imageDesc" , getImageDesc())
                .append("imageContent" , getImageContent())
                .append("imageUrl" , getImageUrl())
                .append("imageSort" , getImageSort())
                .append("orderNum" , getOrderNum())
                .append("status" , getStatus())
                .append("delFlag" , getDelFlag())
                .append("createBy" , getCreateBy())
                .append("createTime" , getCreateTime())
                .append("updateBy" , getUpdateBy())
                .append("updateTime" , getUpdateTime())
                .toString();
    }
}
