package com.ruoyi.website.profile.entity;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 公司简介表 profile_info
 *
 * @author xingyu
 * @date 2019-01-28
 */
public class ProfileInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 访问ID
     */
    private Integer proId;
    /**
     * 公司简介
     */
    private String content;

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public Integer getProId() {
        return proId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("proId", getProId())
                .append("content", getContent())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
