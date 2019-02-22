package com.ruoyi.project.system.oss.entity;

import com.ruoyi.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 文件上传表 sys_oss
 *
 * @author xingyu
 * @date 2019-01-10
 */
public class SysOss extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long fileId;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件储存位置（0本地，1七牛云，2阿里云，3腾讯云）
     */
    private String fileHome;
    /**
     * URL地址
     */
    private String fileUrl;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 状态（0正常 1关闭）
     */
    private String status;
    /**
     * 创建时间
     */
    private Date createDate;

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileHome() {
        return fileHome;
    }

    public void setFileHome(String fileHome) {
        this.fileHome = fileHome;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("fileId", getFileId())
                .append("fileName", getFileName())
                .append("fileHome",getFileHome())
                .append("fileUrl", getFileUrl())
                .append("fileType", getFileType())
                .append("status", getStatus())
                .append("createDate", getCreateDate())
                .toString();
    }
}
