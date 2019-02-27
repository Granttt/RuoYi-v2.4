package com.ruoyi.project.upload;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.project.system.oss.entity.SysOss;
import com.ruoyi.project.system.oss.service.ISysOssService;
import com.ruoyi.project.upload.cloud.CloudStorageService;
import com.ruoyi.project.upload.cloud.OSSFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @description: 图片上传
 * @author: xingyu
 */
@Controller
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private ISysOssService sysOssService;

    /** 图片命名格式 */
    private static final String DEFAULT_SUB_FOLDER_FORMAT_AUTO = "yyyyMMddHHmmss";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** 上传图片文件夹 */
    private static final String UPLOAD_PATH = Global.getProfile();

    /** 上传图片URL */
    private static final String URL_PATH = Global.getVisiteUrl();

    /** 上传图片 */
    @PostMapping("/upload")
    @ResponseBody
    public UploadImageResModel  uploadImg(@RequestParam("upload") MultipartFile multipartFile) {

        if (multipartFile == null || multipartFile.isEmpty()){
            return UploadImageResModel.error("isEmpty");
        }
        //生成新的文件名及存储位置
        String fileName = multipartFile.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString()
                .replaceAll("-", "")
                .concat(fileName.substring(fileName.lastIndexOf(".")));

        String fullPath = UPLOAD_PATH.concat(newFileName);

        try {
            File target = new File(fullPath);
            //判断文件父目录是否存在
            if (!target.getParentFile().exists()) {
                target.getParentFile().mkdirs();
            }
            //将上传文件写到服务器上指定的路径
            multipartFile.transferTo(target);

            String imgUrl = "http://localhost:80/profile/".concat(newFileName);
            //保存文件信息
            SysOss oss = new SysOss();
            oss.setFileUrl(imgUrl);
            oss.setFileName(fileName);
            oss.setFileHome("0");
            oss.setFileType(fileName.substring(fileName.lastIndexOf(".")+1));
            sysOssService.insertSysOss(oss);
            return UploadImageResModel.ok(1,fileName,imgUrl);
        } catch (IOException ex) {
            logger.error("上传图片异常", ex);
        }

        return UploadImageResModel.error("isEmpty");
    }
    /**
     * 上传图片--保存在本地
     */
    @PostMapping("/picUpload")
    @ResponseBody
    public UploadImageResModel picUpload(@RequestParam("file") MultipartFile file) throws IOException
    {
        if (file == null || file.isEmpty()){
            return UploadImageResModel.error("isEmpty");
        }
        //生成新的文件名及存储位置
        String fileName = file.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString()
                .replaceAll("-", "")
                .concat(fileName.substring(fileName.lastIndexOf(".")));

        String fullPath = UPLOAD_PATH.concat(newFileName);
        File target = new File(fullPath);
        //判断文件父目录是否存在
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }

        file.transferTo(target);

        String imgUrl = URL_PATH.concat(newFileName);
//        String avatar = FileUploadUtils.upload(file);//默认配置进行文件上传

        return UploadImageResModel.ok(1,fileName,imgUrl);

    }
    /** cloudUpload */
    @PostMapping("/cloudUpload")
    @ResponseBody
    public UploadImageResModel  cloudUpload(@RequestParam("upload") MultipartFile multipartFile) throws IOException{
        if (multipartFile.isEmpty()) {
            throw new BusinessException("上传文件不能为空");
        }
        //上传文件
        String fileName = multipartFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        CloudStorageService storage = OSSFactory.build();
        String url =storage.uploadSuffix(multipartFile.getBytes(), suffix);

        //保存文件信息
        SysOss oss = new SysOss();
        oss.setFileUrl(url);
        oss.setFileName(fileName);
        oss.setFileHome("1");
        oss.setFileType(fileName.substring(fileName.lastIndexOf(".")+1));
        sysOssService.insertSysOss(oss);

        return UploadImageResModel.ok(1,fileName,url);
    }

}
