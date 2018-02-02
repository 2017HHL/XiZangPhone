package com.mingnong.xizangphone.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;

import com.mingnong.xizangphone.MyApplication;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wyw on 2016/12/23.
 */

public class PhotoUtils {
    public static int DEFAULT_WIDTH = 480;
    public static int DEFAULT_HEIGHT = 480;
    public static final int REQUEST_CODE_START = 400;

    /**
     * 获取无害化的dir
     *
     * @return
     */
    public static File getWuHaiHuaDir() {
        File store = new File(MyApplication.getContext().getExternalFilesDir("store"), "wuhaihua");
//        File store = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"Android/data/com.mingnong.changshaapp/files/store/wuhaihua");
        if (!store.exists()) {
            store.mkdirs();
        }
        return store;
    }

    /**
     * 产地检疫dir
     * @return
     */
    public static File getQuarantineDir() {
        File store = new File(MyApplication.getContext().getExternalFilesDir("store"), "quarantine");
//        File store = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"Android/data/com.mingnong.changshaapp/files/store/wuhaihua");
        if (!store.exists()) {
            store.mkdirs();
        }
        return store;
    }


    public synchronized static void saveSignPicture(Bitmap signBitmap,String name,String uuid) {
        new Thread(() -> {
            File file = new File(getWuHaiHuaDir(), uuid+name + ".jpg");
            if (file.exists()) file.delete();
            saveBitmap(file.getAbsolutePath(), signBitmap);
        }).start();

    }


    public static String takePicture(Activity activity, int requestCode, String name,File dir,String uuid) {
        //// TODO: 2016/12/27 需要改动
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.CAMERA},
                    requestCode);
            return null;
        } else {
            Intent intentP = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File file = new File(dir,uuid+ name + ".jpg");
            Uri contentUri = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                contentUri = FileProvider.getUriForFile(activity, "com.wyw.jiangsu.fileprovider", file);
                intentP.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION |
                        Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            } else {
                contentUri = Uri.fromFile(file);
            }
            intentP.putExtra(MediaStore.EXTRA_OUTPUT, contentUri);
//            intentP.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

//          intentP.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(activity,"com.jph.takephoto.fileprovider",getPictureWuhaihua(requestCode)));
            activity.startActivityForResult(intentP, requestCode);
            return file.getAbsolutePath();
        }
    }

    /**
     * 无害化的picture
     *  默认是无害化
     * @param activity
     * @param requestCode
     */
    public static String takePictureHarmless(Activity activity, int requestCode, String name,String uuid) {
            return takePicture(activity,requestCode,name,getWuHaiHuaDir(),uuid);
    }

    /**
     * 产地检疫拍照
     */
    public static String takePictureQuarantine(Activity activity, int requestCode, String name) {
        return takePicture(activity,requestCode,name,getQuarantineDir(),null);
    }

    public static void saveBitmap(String path, Bitmap bm) {
        File f = new File(path);
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取强制疫苗的保存路径
     * @return
     */
    public static File getVaccineDir() {
        File store = new File(MyApplication.getContext().getExternalFilesDir("store"), "vaccine");
        if (!store.exists()) {
            store.mkdirs();
        }
        return store;
    }

    /**
     * 删除 无害化文件夹下的所有文件
     */
    public static void deletePic() {
        File[] files = getWuHaiHuaDir().listFiles();
        for (File file : files) {
//            if (file.getAbsolutePath().endsWith(".jpg")) {
//                file.delete();
//            }
            file.delete();
        }
    }

    public static Bitmap decodeSampleBitmapFromFile(String path) {
        return decodeSampleBitmapFromFile(path, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public static Bitmap decodeSampleBitmapFromFile(String path,
                                                    int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        // 计算缩放比
        int h = options.outHeight;
        int w = options.outWidth;
        int beWidth = w / reqWidth;
        int beHeight = h / reqHeight;
        int scale;
        if (beWidth < beHeight) {
            scale = beWidth;
        } else {
            scale = beHeight;
        }
        if (scale <= 0) {
            scale = 1;
        }
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false; // 设为 false
//        options.inSampleSize = calculateSampleSize(options,reqWidth,reqHeight);
        return BitmapFactory.decodeFile(path, options);
    }

    public static Bitmap decodeSampleBitmapFromFile(byte[] buff) {
        return BitmapFactory.decodeByteArray(buff, 0, buff.length);
    }


    // 图片质量压缩
    public static byte[] compressBmpToFile(String picturePath) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bmp = getBitmap(picturePath);
        int options = 100;
        bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
        while (baos.toByteArray().length / 1024 > 500) {
            baos.reset();
            options -= 10;
            bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
        }
        //写出
        File pic = new File(picturePath);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(pic);
            fileOutputStream.write(baos.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return baos.toByteArray();
    }

    public static Bitmap getBitmap(String imgPath) {
        // Get bitmap through image path
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inJustDecodeBounds = false;
        newOpts.inPurgeable = true;
        newOpts.inInputShareable = true;
        // Do not compress
        newOpts.inSampleSize = 8;
        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeFile(imgPath, newOpts);
    }

}
