package com.mingnong.xizangphone.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by wyw on 2016/7/26.
 */
public class PictureUtils {
    public static Bitmap zoomImg(Bitmap bm, int newWidth, int newHeight) {

        int width = bm.getWidth();
        int height = bm.getHeight();

        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片   www.2cto.com
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }

    public static Bitmap decodeSampleBitmapFromResource(Resources resource, int resId,
                                                        int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resource, resId, options);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = calculateSampleSize(options, reqWidth, reqHeight);
        return BitmapFactory.decodeResource(resource, resId, options);
    }

    public static Bitmap decodeSampleBitmapFromFile(String path,
                                                    int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = calculateSampleSize(options, reqWidth, reqHeight);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeFile(path, options);
    }

    /**
     * FileInputStream 是一种有序的�?,两次decodeFileInputStream调用影响�?
     * 文件流的位置属�??,导致第二次decode的�?�是null , 只能用fd
     *
     * @param fis
     * @param reqWidth
     * @param reqHeight
     * @return
     * @throws IOException
     */
    public static Bitmap decodeSampleBitmapFromFileInputStream(FileInputStream fis, int reqWidth, int reqHeight) throws IOException {
        FileDescriptor fd = fis.getFD();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fd, null, options);
        options.inSampleSize = calculateSampleSize(options, reqWidth, reqHeight);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeFileDescriptor(fd, null, options);
    }

    private static int calculateSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int sampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfWidth = width / 2;
            int halfHeight = height / 2;
            while ((halfHeight / sampleSize) >= reqHeight &&
                    (halfWidth / sampleSize) >= reqWidth) {
                sampleSize *= 2;
            }
        }
        return sampleSize;
    }

    /**
     * 获取图片 字符串表�? base64压缩
     *
     * @param imgPath
     * @return
     */
    public static String getPictureStr(String imgPath) {

        if (fileIsExist(imgPath)) {
            byte[] buffer = compressBmpToFile(imgPath);
            return Base64.encodeToString(buffer, Base64.DEFAULT);
        }
        return "";
    }


    public static String getPictureStr(Bitmap bitmap) {
        if (bitmap != null) {
            return Base64.encodeToString(compressBmp(bitmap), Base64.DEFAULT);
        }
        return "";
    }

    /**
     * 将字符串转换换成Bitmap
     *
     * @param bitmapString
     * @return
     */
    public static Bitmap getBitmapByString(String bitmapString) {
        //base64解码
        byte[] bitmap = Base64.decode(bitmapString.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bitmap, 0, bitmap.length);
    }

    private static byte[] compressBmp(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int options = 80;
        bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
        while (baos.toByteArray().length / 1024 > 600) {
            baos.reset();
            options -= 10;
            bmp.compress(Bitmap.CompressFormat.JPEG, options, baos);
        }
        return baos.toByteArray();
    }

    // 图片质量压缩
    private static byte[] compressBmpToFile(String picturePath) {
        return compressBmp(getBitmap(picturePath));
    }

    //// TODO: 2016/7/22 错误的写�?
    public static Bitmap getBitmap(String imgPath) {
        // Get bitmap through image path
        BitmapFactory.Options newOpts = new BitmapFactory.Options();
        newOpts.inJustDecodeBounds = false;
        newOpts.inPurgeable = true;
        newOpts.inInputShareable = true;
        // Do not compress
        newOpts.inSampleSize = 4;
        newOpts.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeFile(imgPath, newOpts);
    }

    public static boolean fileIsExist(String strFile) {
        try {
            File f = new File(strFile);
            if (!f.exists()) {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
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
}
