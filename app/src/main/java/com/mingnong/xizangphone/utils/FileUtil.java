package com.mingnong.xizangphone.utils;

import android.content.Context;
import android.graphics.Bitmap;

import com.mingnong.xizangphone.MyApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by wyw on 2016/11/3.
 */

public class FileUtil {
    private static FileUtil instance;
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_PATCH = "patch";
    private static final String DIR_BUG = "bug";
    private static final String FILE_BUG_POSTFIX = ".bug";
    //文件名字
    public static final String APK_NAME = "HuNanApp.apk";
    public static final String DB_NAME = "userdata.dbx";
    public static final String PATCH_NAME = "patch.jar";
    private Context mContext;

    public FileUtil(Context mContext) {
        this.mContext = mContext;
    }

    public synchronized static FileUtil getInstance() {
        if (instance == null) {
            instance = new FileUtil(MyApplication.getContext());
        }
        return instance;
    }
    //获取sd bug绝对路径
    public File getBugDir() {
        return mContext.getExternalFilesDir(DIR_BUG);
    }
    //获取sd绝对路径
    public String getBugDirPath() {
        return getBugDir().getAbsolutePath();
    }
    //获取sd储存
    public File getPatchDir() {
        return mContext.getExternalFilesDir(DIR_PATCH);
    }
    //获取sd缓存
    public File getCacheDir() {
        return mContext.getExternalFilesDir(DIR_CACHE);
    }

    public File getCacheFile() {
        File file = new File(getCacheDir(), "retrofitCache");
        if (!file.exists()) try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    //获取sd缓存绝对路径
    public String getCacheDirPath() {
        return getCacheDir().getAbsolutePath();
    }

    public File getDataDir() {
        return mContext.getExternalFilesDir(DIR_DATA);
    }
    //获取sd  data绝对路径
    public String getDataDirPath() {
        return getDataDir().getAbsolutePath();
    }
    //获取数据库路径
    public File getInternalDbFile() {
        return mContext.getDatabasePath(DB_NAME);
    }

    public String getInternalDbPath() {
        return getInternalDbFile().getAbsolutePath();
    }

    /**
     * patch文件位置
     *
     * @return
     */
    public File getOuterPatchFile() {
        return new File(getPatchDir(), PATCH_NAME);
    }

    /**
     * 内部 patch文件位置
     *
     * @return
     */
    public File getInternalPatchFile() {
        File file = new File(mContext.getFilesDir(), "patch");
        if (!file.exists()) file.mkdirs();
        return new File(file, PATCH_NAME);
    }

    /**
     * apk文件位置
     *
     * @return
     */
    public File getApkFile() {
        return new File(getCacheDir(), APK_NAME);
    }

    /**
     * db文件位置
     *
     * @return
     */
    public File getDbFile() {
        return new File(getCacheDir(), DB_NAME);
    }

    /**
     * 拷贝到apk安装路径的数据库目录下
     *
     * @return 拷贝是否成功
     */
    public boolean copyDbTointerPath(String path) {
        boolean b = false;
        //判断文件夹是否存在
        String dirPath = getInternalDbPath().substring(0, getInternalDbPath().lastIndexOf(File.separator) + 1);
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File dbFile = getInternalDbFile();
        if (!isDbFileExists(dbFile, true)) {
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(new File(path));
                os = new FileOutputStream(dbFile);
                int length;
                byte[] buf = new byte[1024 * 2];
                while ((length = is.read(buf)) != -1) {
                    os.write(buf, 0, length);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return !b;
    }

    /**
     * 拷贝到apk安装路径的数据库目录下
     *
     * @return 拷贝是否成功
     */
    public boolean copyToInterPath(String srcFile, String destFile) {
        boolean b = false;
        //判断文件夹是否存在
        String dirPath = destFile.substring(0, destFile.lastIndexOf(File.separator) + 1);
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File dest = new File(destFile);
        if (!(b = isFileExists(dest, true))) {
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(new File(srcFile));
                os = new FileOutputStream(dest);
                int length;
                byte[] buf = new byte[1024 * 2];
                while ((length = is.read(buf)) != -1) {
                    os.write(buf, 0, length);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return !b;
    }

    private static boolean isFileExists(File f, boolean refresh) {
        boolean b = false;
        if (f.exists()) {
            if (refresh) {
                f.delete();
                b = false;
            } else {
                b = true;
            }
        }
        return b;
    }

    /**
     * 检查DB文件是否存在
     *
     * @param f       文件名
     * @param refresh 是否覆盖之前的db文件
     * @return
     */
    private static boolean isDbFileExists(File f, boolean refresh) {
        boolean b = false;
        if (f.exists()) {
            if (refresh) {
                f.delete();
                b = false;
            } else {
                b = true;
            }
        }
        return b;
    }

    /**
     * 打印图片保存
     */
    public String save2Local(Bitmap bitmap, String path) {
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] photoBytes = baos.toByteArray();
            if (photoBytes != null) {
                new FileOutputStream(new File(path)).write(photoBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null)
                    baos.close();
                bitmap.recycle();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path;
    }

}
