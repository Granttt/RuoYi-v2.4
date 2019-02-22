package com.ruoyi.project.upload;

import java.util.HashMap;

/**
 * @description: CKEditor编辑器上传图片返回格式
 * @author: xingyu
 */

public class UploadImageResModel extends HashMap<String, Object> {

    /**
     * 1成功，0失败
     */

    public UploadImageResModel(){
        put("uploaded", "0");
        put("error", "The file is too big.");
    }

    public static UploadImageResModel ok() {
        return new UploadImageResModel();
    }

    public static UploadImageResModel ok(Integer uploaded,String fileName, String url) {
        UploadImageResModel r = new UploadImageResModel();
        r.put("uploaded",uploaded);
        r.put("fileName",fileName);
        r.put("url",url);
        return r;
    }

    public static UploadImageResModel error(String msg) {
        UploadImageResModel r = new UploadImageResModel();
        r.put("uploaded",0);
        r.put("error",msg);
        return r;
    }

    @Override
    public UploadImageResModel put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}

