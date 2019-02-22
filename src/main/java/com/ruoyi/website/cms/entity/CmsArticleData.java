package com.ruoyi.website.cms.entity;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文章详表 cms_article_data
 *
 * @author xingyu
 * @date 2019-01-10
 */
public class CmsArticleData extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String id;
    /**
     * 文章内容
     */
    private String content;
    /**
     * 文章来源
     */
    private String copyfrom;
    /**
     * 相关文章
     */
    private String relation;
    /**
     * 是否允许评论
     */
    private String allowComment;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setCopyfrom(String copyfrom) {
        this.copyfrom = copyfrom;
    }

    public String getCopyfrom() {
        return copyfrom;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    public void setAllowComment(String allowComment) {
        this.allowComment = allowComment;
    }

    public String getAllowComment() {
        return allowComment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("content", getContent())
                .append("copyfrom", getCopyfrom())
                .append("relation", getRelation())
                .append("allowComment", getAllowComment())
                .toString();
    }
}
