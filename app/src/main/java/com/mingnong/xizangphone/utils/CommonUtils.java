package com.mingnong.xizangphone.utils;

import android.content.Context;

import com.mingnong.xizangphone.MyApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wyw on 2016/7/11.
 */
public class CommonUtils {

    //每次进入app，遍历assets目录下所有的文件，是否在data/data目录下都已经存在，不存在则拷贝
    public static void initAssetsFile() {
        boolean needCopy = false;
        // 创建data/data目录
        File file = MyApplication.getContext().getFilesDir();
        String path = file.getAbsolutePath() + "/lib/armeabi/";
        // 遍历assets目录下所有的文件，是否在data/data目录下都已经存在
        try {
            String[] fileNames = MyApplication.getContext().getAssets().list("armeabi");
            for (int i = 0; fileNames != null && i < fileNames.length; i++) {
                if (!isFileExit(path + fileNames[i])) {
                    needCopy = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (needCopy) {
            CommonUtils.copyFilesFassets(MyApplication.getContext(), "armeabi", path);
        }
    }
    public static boolean isFileExit(String s) {
        return new File(s).exists();
    }
    //将旧目录中的文件全部复制到新目录
    public static void copyFilesFassets(Context context, String oldPath, String newPath) {
        try {
            // 获取assets目录下的所有文件及目录名
            String fileNames[] = context.getAssets().list(oldPath);

            // 如果是目录名，则将重复调用方法递归地将所有文件
            if (fileNames.length > 0) {
                File file = new File(newPath);
                file.mkdirs();
                for (String fileName : fileNames) {
                    copyFilesFassets(context, oldPath + "/" + fileName, newPath + "/" + fileName);
                }
            }
            // 如果是文件，则循环从输入流读取字节写入
            else {
                InputStream is = context.getAssets().open(oldPath);
                FileOutputStream fos = new FileOutputStream(new File(newPath));
                byte[] buffer = new byte[1024];
                int byteCount = 0;
                while ((byteCount = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, byteCount);
                }
                fos.flush();
                is.close();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
