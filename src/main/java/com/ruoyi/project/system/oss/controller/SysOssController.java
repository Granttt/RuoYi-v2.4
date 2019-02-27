package com.ruoyi.project.system.oss.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.security.ValidatorUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.config.service.IConfigService;
import com.ruoyi.project.system.oss.entity.SysOss;
import com.ruoyi.project.system.oss.service.ISysOssService;
import com.ruoyi.project.upload.cloud.CloudConstant;
import com.ruoyi.project.upload.cloud.CloudConstant.CloudService;
import com.ruoyi.project.upload.cloud.CloudStorageConfig;
import com.ruoyi.project.upload.cloud.entiry.OssEntity;
import com.ruoyi.project.upload.cloud.valdator.AliyunGroup;
import com.ruoyi.project.upload.cloud.valdator.QcloudGroup;
import com.ruoyi.project.upload.cloud.valdator.QiniuGroup;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传 信息操作处理
 *
 * @author xingyu
 * @date 2019-01-10
 */
@Controller
@RequestMapping("/system/sysOss")
public class SysOssController extends BaseController {
    private String prefix = "system/oss";

    private final static String KEY = CloudConstant.CLOUD_STORAGE_CONFIG_KEY;

    @Autowired
    private ISysOssService sysOssService;

    @Autowired
    private IConfigService sysConfigService;

    @RequiresPermissions("system:sysOss:view")
    @GetMapping()
    public String sysOss(ModelMap mmap) {
        mmap.put("ossList", sysOssService.selectSysOssList(new SysOss()));
        return prefix + "/oss";
    }

    @RequiresPermissions("system:sysOss:view")
    @RequestMapping("ossList")
    public String ossList(ModelMap mmap) {
        String jsonconfig = sysConfigService.selectConfigByKey(CloudConstant.CLOUD_STORAGE_CONFIG_KEY);
        // 获取云存储配置信息
        CloudStorageConfig config = JSON.parseObject(jsonconfig, CloudStorageConfig.class);
        Configuration cfg = new Configuration(Zone.zone0());
        Auth auth = Auth.create(config.getQiniuAccessKey(), config.getQiniuSecretKey());
        BucketManager bucketManager = new BucketManager(auth, cfg);
        //文件名前缀
        String prefixs = "wangbo";
        //每次迭代的长度限制，最大1000，推荐值 1000
        int limit = 1000;
        //指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
        String delimiter = "";
        //列举空间文件列表
        BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(config.getQiniuBucketName(), prefixs, limit, delimiter);
        int i=1;
        List<OssEntity> ossEntityList = new ArrayList<>();
        while (fileListIterator.hasNext()) {
            //处理获取的file list结果
            FileInfo[] items = fileListIterator.next();
            for (FileInfo item : items) {
                OssEntity ossEntity = new OssEntity();
                ossEntity.setId(i);
                ossEntity.setUrl(config.getQiniuEntity()+"/"+item.key);
                ossEntity.setKey(item.key);
                ossEntity.setHash(item.hash);
                ossEntity.setFsize(item.fsize);
                ossEntity.setMimeType(item.mimeType);
                ossEntity.setPutTime(item.putTime);
                ossEntity.setEndUser(item.endUser);
                ossEntity.setUploadDate(DateUtils.stampToDate(item.putTime/1000));
                ossEntityList.add(ossEntity);
                i++;
            }
        }
        mmap.put("ossEntityList",ossEntityList);
        return prefix + "/ossList";
    }

    /**
     * 云存储配置信息
     */
    @RequestMapping("config")
    @RequiresPermissions("sys:oss:config")
    public String config(Model model) {
        String jsonconfig = sysConfigService.selectConfigByKey(CloudConstant.CLOUD_STORAGE_CONFIG_KEY);
        // 获取云存储配置信息
        CloudStorageConfig config = JSON.parseObject(jsonconfig, CloudStorageConfig.class);
        model.addAttribute("config", config);
        return prefix + "/config";
    }

    /**
     * 保存云存储配置信息
     */
    @RequestMapping("saveConfig")
    @RequiresPermissions("sys:oss:config")
    @ResponseBody
    public AjaxResult saveConfig(CloudStorageConfig config) {
        // 校验类型
        ValidatorUtils.validateEntity(config);
        if (config.getType() == CloudService.QINIU.getValue()) {
            // 校验七牛数据
            ValidatorUtils.validateEntity(config, QiniuGroup.class);
        } else if (config.getType() == CloudService.ALIYUN.getValue()) {
            // 校验阿里云数据
            ValidatorUtils.validateEntity(config, AliyunGroup.class);
        } else if (config.getType() == CloudService.QCLOUD.getValue()) {
            // 校验腾讯云数据
            ValidatorUtils.validateEntity(config, QcloudGroup.class);
        }
        return toAjax(sysConfigService.updateValueByKey(KEY, new Gson().toJson(config)));
    }

    /**
     * 查询文件上传列表
     */
    @RequiresPermissions("system:sysOss:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysOss sysOss) {
        startPage();
        List<SysOss> list = sysOssService.selectSysOssList(sysOss);
        return getDataTable(list);
    }


    /**
     * 导出文件上传列表
     */
    @RequiresPermissions("system:sysOss:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysOss sysOss) {
        List<SysOss> list = sysOssService.selectSysOssList(sysOss);
        ExcelUtil<SysOss> util = new ExcelUtil<SysOss>(SysOss.class);
        return util.exportExcel(list, "文件上传列表");
    }

    /**
     * 新增文件上传
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存文件上传
     */
    @RequiresPermissions("system:sysOss:add")
    @Log(title = "文件上传", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysOss sysOss) {
        return toAjax(sysOssService.insertSysOss(sysOss));
    }

    /**
     * 修改文件上传
     */
    @GetMapping("/edit/{fileId}")
    public String edit(@PathVariable("fileId") Long fileId, ModelMap mmap) {
        SysOss sysOss = sysOssService.selectSysOssById(fileId);
        mmap.put("sysOss", sysOss);
        return prefix + "/edit";
    }

    /**
     * 修改保存文件上传
     */
    @RequiresPermissions("system:sysOss:edit")
    @Log(title = "文件上传", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysOss sysOss) {
        return toAjax(sysOssService.updateSysOss(sysOss));
    }

    /**
     * 删除文件上传
     */
    @RequiresPermissions("system:sysOss:remove")
    @Log(title = "文件上传", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(sysOssService.deleteSysOssByIds(ids));
    }

}
