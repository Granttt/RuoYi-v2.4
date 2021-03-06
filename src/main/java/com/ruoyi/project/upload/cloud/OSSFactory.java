package com.ruoyi.project.upload.cloud;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.project.system.config.service.IConfigService;
import com.ruoyi.project.upload.cloud.CloudConstant.CloudService;

/**
 * 文件上传Factory
 * 阿里云OSS参考文档
 * https://help.aliyun.com/document_detail/32011.html?spm=a2c4g.11186623.6.659.64e27320p9MjBw
 * http://aliyun_portal_storage.oss.aliyuncs.com/oss_api/oss_javahtml/object.html#id13
 * @author xingyu
 */
public final class OSSFactory {

    private static IConfigService sysConfigService;

    static {
        OSSFactory.sysConfigService = SpringUtils.getBean(IConfigService.class);
    }

    public static CloudStorageService build() {
        String jsonconfig = sysConfigService.selectConfigByKey(CloudConstant.CLOUD_STORAGE_CONFIG_KEY);
        // 获取云存储配置信息
        CloudStorageConfig config = JSON.parseObject(jsonconfig, CloudStorageConfig.class);
        if (config.getType() == CloudService.QINIU.getValue()) {
            return new QiniuCloudStorageService(config);
        } else if (config.getType() == CloudService.ALIYUN.getValue()) {
            return new AliyunCloudStorageService(config);
        } else if (config.getType() == CloudService.QCLOUD.getValue()) {
            return new QcloudCloudStorageService(config);
        }
        return null;
    }
}
