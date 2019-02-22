package com.ruoyi.website.link.entity;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 公司联系方式表 link_info
 *
 * @author xingyu
 * @date 2019-01-14
 */
public class LinkInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer linkId;
    /**
     * 电话
     */
    private String tel;
    /**
     * 地址
     */
    private String address;
    /**
     * E-Mail
     */
    private String mail;
    /**
     * QQ
     */
    private String qq;
    /**
     * 微信
     */
    private String wechat;
    /**
     * 微博
     */
    private String weibo;
    /**
     * 微信二维码
     */
    private String wxCode;
    /**
     * 微博二维码
     */
    private String wbCode;

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getQq() {
        return qq;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }

    public String getWxCode() {
        return wxCode;
    }

    public void setWbCode(String wbCode) {
        this.wbCode = wbCode;
    }

    public String getWbCode() {
        return wbCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("linkId", getLinkId())
                .append("address", getAddress())
                .append("tel", getTel())
                .append("mail", getMail())
                .append("qq", getQq())
                .append("wechat", getWechat())
                .append("weibo", getWeibo())
                .append("wxCode", getWxCode())
                .append("wbCode", getWbCode())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
