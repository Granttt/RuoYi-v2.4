package com.ruoyi.project.upload.cloud;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;

import java.io.*;

/**
 * 阿里云
 * https://help.aliyun.com/document_detail/32011.html?spm=a2c4g.11186623.2.13.4942c06digNdoB#concept-32011-zh
 * @author xingyu
 * @date 2019/1/23
 */
public class AliyunCloudStorageService extends CloudStorageService {
    private OSSClient client;

    public AliyunCloudStorageService(CloudStorageConfig config) {
        this.config = config;
        // 初始化
        init();
    }

    private void init() {
        client = new OSSClient(config.getAliyunEndPoint(), config.getAliyunAccessKeyId(),
                config.getAliyunAccessKeySecret());
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（path）。
            client.putObject(config.getAliyunBucketName(), path, inputStream);
        } catch (Exception e) {
            throw new RuntimeException("上传文件失败，请检查配置信息");
        }
        // 关闭OSSClient。
        client.shutdown();
        return config.getAliyunEntity() + "/" + path;
    }

    /**
     * OSS 读取Object(算不上下载，只能算读取)
     * 流式下载
     * @param path
     * @return
     * @throws IOException
     */
    public String readObject(String path) throws IOException {

        // 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
        OSSObject ossObject = client.getObject(config.getAliyunBucketName(), path);
        // 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
        InputStream content = ossObject.getObjectContent();
        if (content != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            while (true) {
                String line = reader.readLine();
                if (line == null){ break;}
                System.out.println("\n" + line);
            }
            // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
            content.close();
        }
        return null;
    }

    /**
     * 下载到本地文件
     * @param path
     * @return
     * 例：oss上文件完整路径为https://gaoxiyang.oss-cn-beijing.aliyuncs.com/ruoyi/20190228/997c9df348454701bd3d9feb3532ef11.jpg
     * 则path设置成ruoyi/20190228/997c9df348454701bd3d9feb3532ef11.jpg 多级目录
     */
    @Override
    public String download(String dir, String path){
        // 新建GetObjectRequest
        GetObjectRequest getObjectRequest = new GetObjectRequest(config.getAliyunBucketName(), path);
        //截取最后一个“/”后面的字符串，+1的作用是剔除“/” /997c9df348454701bd3d9feb3532ef11.jpg
        // 997c9df348454701bd3d9feb3532ef11.jpg
        String newPath=path.substring(path.lastIndexOf("/")+1);
        File target = new File(dir.concat(newPath));
        //判断文件父目录是否存在
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdirs();
        }
        if (getObjectRequest != null){
            // 下载Object到文件
            client.getObject(getObjectRequest, target);
        }else {
            throw new RuntimeException("下载文件失败，请检查配置信息");
        }
        // 关闭OSSClient。
        client.shutdown();
        return newPath;
    }

    @Override
    public String uploadSuffix(byte[] data, String suffix) {
        return upload(data, getPath(config.getAliyunPrefix(), suffix));
    }

    @Override
    public String uploadSuffix(InputStream inputStream, String suffix) {
        return upload(inputStream, getPath(config.getAliyunPrefix(), suffix));
    }
}

