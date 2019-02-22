package com.ruoyi.website.proj.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 项目表 proj_info
 *
 * @author xingyu
 * @date 2019-01-15
 */
public class ProjInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 项目ID
     */
    private String id;
    /**
     * 分类ID
     */
    private Long menuId;
    /**
     * 分类名称
     */
    private String menuName;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 合作方
     */
    private String partner;
    /**
     * 缩略图
     */
    private String image;
    /**
     * 项目链接
     */
    private String link;
    /**
     * 打开方式
     */
    private String openMode;
    /**
     * 描述、摘要
     */
    private String description;
    /**
     * 制作日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productionTime;
    /**
     * 描述、摘要
     */
    private String content;
    /**
     * 排序
     */
    private Integer oderNum;
    /**
     * 点击数
     */
    private Integer hits;
    /**
     * 是否典型案例
     */
    private String typical;
    /**
     * 备注信息
     */
    private String remarks;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getPartner() {
        return partner;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setOpenMode(String openMode) {
        this.openMode = openMode;
    }

    public String getOpenMode() {
        return openMode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Date getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(Date productionTime) {
        this.productionTime = productionTime;
    }

    public void setOderNum(Integer oderNum) {
        this.oderNum = oderNum;
    }

    public Integer getOderNum() {
        return oderNum;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getHits() {
        return hits;
    }

    public String getTypical() {
        return typical;
    }

    public void setTypical(String typical) {
        this.typical = typical;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("menuId", getMenuId())
                .append("menuName", getMenuName())
                .append("title", getTitle())
                .append("author", getAuthor())
                .append("partner", getPartner())
                .append("image", getImage())
                .append("link", getLink())
                .append("openMode", getOpenMode())
                .append("description", getDescription())
                .append("productionTime",getProductionTime())
                .append("content",getContent())
                .append("oderNum", getOderNum())
                .append("hits", getHits())
                .append("typical", getTypical())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remarks", getRemarks())
                .toString();
    }
}
