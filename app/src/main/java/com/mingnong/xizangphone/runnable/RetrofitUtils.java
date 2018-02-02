package com.mingnong.xizangphone.runnable;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by wyw on 2016/8/10.
 */
public class RetrofitUtils {
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";

    public static RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                MediaType.parse(MULTIPART_FORM_DATA), descriptionString);
    }

    /**
     * @param partName
     * @param filePath
     * @return
     */
    public static MultipartBody.Part prepareFilePart(String partName, String filePath) throws Exception {
       File file = new File(filePath);
        if (!file.exists()) {
            throw new Exception("文件不存在");
        }

        // 为file建立RequestBody实例
        RequestBody requestFile =
                RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file);

        // MultipartBody.Part借助文件名完成最终的上传
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }
}
