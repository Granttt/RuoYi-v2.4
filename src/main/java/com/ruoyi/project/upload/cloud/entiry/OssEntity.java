package com.ruoyi.project.upload.cloud.entiry;

/**
 * oss
 *
 * @author xingyu
 * @date 2019/1/24
 */
public class OssEntity {
    /**
     * 编号
     */
    private Integer id;
    /**
     * URL
     */
    private String url;
    /**
     * key
     */
    private String key;
    /**
     * hash
     */
    private String hash;
    /**
     * fsize
     */
    private Long fsize;
    /**
     * mimeType
     */
    private String mimeType;
    /**
     * putTime
     */
    private Long putTime;
    /**
     * endUser
     */
    private String endUser;

    /**
     * date
     *
     */
    private String uploadDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getFsize() {
        return fsize;
    }

    public void setFsize(Long fsize) {
        this.fsize = fsize;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Long getPutTime() {
        return putTime;
    }

    public void setPutTime(Long putTime) {
        this.putTime = putTime;
    }

    public String getEndUser() {
        return endUser;
    }

    public void setEndUser(String endUser) {
        this.endUser = endUser;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }
}

