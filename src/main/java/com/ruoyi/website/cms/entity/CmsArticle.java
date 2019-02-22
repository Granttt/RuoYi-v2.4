package com.ruoyi.website.cms.entity;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文章表 cms_article
 *
 * @author xingyu
 * @date 2019-01-10
 */
public class CmsArticle extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String id;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * 文章链接
     */
    private String link;
    /**
     * 文章图片
     */
    private String image;
    /**
     * 关键字
     */
    private String keywords;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章来源
     */
    private String copyfrom;

    /**
     * 描述、摘要
     */
    private String description;
    /**
     * 权重，越大越靠前
     */
    private Integer weight;
    /**
     * 点击数
     */
    private Integer hits;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCopyfrom() {
        return copyfrom;
    }

    public void setCopyfrom(String copyfrom) {
        this.copyfrom = copyfrom;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getHits() {
        return hits;
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
                .append("title", getTitle())
                .append("author",getAuthor())
                .append("link", getLink())
                .append("image", getImage())
                .append("keywords", getKeywords())
                .append("content", getContent())
                .append("copyfrom", getCopyfrom())
                .append("description", getDescription())
                .append("weight", getWeight())
                .append("hits", getHits())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remarks", getRemarks())
                .toString();
    }
}
