package com.mingnong.xizangphone.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;


import com.mingnong.xizangphone.MyApplication;

import java.io.File;
import java.io.IOException;

import static com.igexin.sdk.GTServiceManager.context;


/**
 * Created by wyw on 2016/9/9.
 */
public class TakePictureUtil {
    //后面拼接 1.jpeg
    public static String DEFAULT_FILE_NAME = "default_picture_name";
    public static String DEFAULT_FILE_DIR_NAME = "default_dir";
    public static String FILE_POSTFIX = ".jpeg";
    public static int DEFAULT_WIDTH = 480;
    public static int DEFAULT_HEIGHT = 480;

    /**
     * 获取照片存储的位置
     *
     * @return
     */
    public static File getStoreDir() {
        return MyApplication.getContext().getExternalFilesDir("store");
    }


    public static File getPictureFile() {
        File file = new File(MyApplication.getContext().getExternalFilesDir("") + File.separator + "picture.png");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }


    public static void takePicture(Activity activity, int requestCode) {
        Intent intentP = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intentP.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(getPictureFile()));
        activity.startActivityForResult(intentP, requestCode);
    }

    public static File takePicture(Activity activity, int requestCode, File pictureFile) {
        if (pictureFile.exists()) pictureFile.delete();
        Intent intentP = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uri =
                    FileProvider.getUriForFile(context, "com.mingnong.hunanapp.fileprovider", pictureFile);
            // 由于没有在Activity环境下启动Activity,设置下面的标签
//                intentP.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intentP.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION |
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//                intentP.setDataAndType(uri, "application/vnd.android.package-archive");
            intentP.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        } else {
            intentP.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(pictureFile));
        }
        activity.startActivityForResult(intentP, requestCode);
        return pictureFile;
    }

    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     *
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     * If a deletion fails, the method stops attempting to
     * delete and returns "false".
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
    /** */
    /**
     * 文件重命名
     *
     * @param path    文件目录
     * @param oldname 原来的文件名
     * @param newname 新文件名
     */
    public static void renameFile(String path, String oldname, String newname) {
        if (!oldname.equals(newname)) {//新的文件名和以前文件名不同时,才有必要进行重命名
            File oldfile = new File(path + "/" + oldname);
            File newfile = new File(path + "/" + newname);
            if (!oldfile.exists()) {
                return;//重命名文件不存在
            }
            //若在该目录下已经有一个文件和新文件名相同，则不允许重命名
            if (newfile.exists()) newfile.delete();
            oldfile.renameTo(newfile);
        } else {
            System.out.println("新文件名和旧文件名相同...");
        }
    }


}
