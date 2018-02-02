package com.mingnong.xizangphone;

import android.app.Application;
import android.content.Context;
import android.util.Base64;

import com.dodola.rocoofix.RocooFix;
import com.facebook.stetho.Stetho;
import com.mingnong.xizangphone.dao.LocalGreenDao;
import com.mingnong.xizangphone.dao.User;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.utils.AppUtils;
import com.mingnong.xizangphone.utils.CrashHandler;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.NetWorkUtils;
import com.mingnong.xizangphone.utils.SPUtils;

import java.io.File;
import java.io.FileInputStream;

import rx.schedulers.Schedulers;


/**
 * Created by wyw on 2016/10/31.
 */

/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * ┃　　　┃   神兽保佑
 * ┃　　　┃   代码无BUG！
 * ┃　　　┗━━━┓
 * ┃　　　　　　　┣┓
 * ┃　　　　　　　┏┛
 * ┗┓┓┏━┳┓┏┛
 * ┃┫┫　┃┫┫
 * ┗┻┛　┗┻┛
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        RocooFix.init(this);
        RocooFix.applyPatch(this, FileUtil.getInstance().getInternalPatchFile().getAbsolutePath());
        Stetho.initializeWithDefaults(mContext);
//        CrashHandler.getInstance().init(mContext);
        deleteApk();

        LocalGreenDao.getInstance().insertOrUpdateUnit();
        LocalGreenDao.getInstance().insertOrUpdateCodeXD();
//        try {
//            FileUtil.getInstance().copyRawDBToApkDb(mContext, R.raw.user_data,
//                    "/data/data/com.mingnong.hunanapp/databases/", FileUtil.FILE_DB_NAME, true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        if (NetWorkUtils.isOpenNetwork(getContext())) {
//            File errLog = new File(CrashHandler.PATH);
//            if (errLog.exists()) {
//                File[] files = errLog.listFiles();
//                for (File file : files) {
//                    try {
//                        run(file);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
        }

    }

    private void deleteApk() {
        File apkFile = FileUtil.getInstance().getApkFile();
        if (apkFile.exists()) {
            apkFile.exists();
        }
    }

    public static Context getContext() {
        return mContext;
    }

    public void run(final File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        byte[] buf = new byte[(int) file.length()];
        fis.read(buf);
        fis.close();
        String errorinfo = new String(Base64.encode(buf, 0, buf.length, Base64.DEFAULT));

        User user = null;
        try {
            user = (User) SPUtils.getInstance().getObjectData(Contance.USER_OBJECT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            return;
        }
        NetClient.getRequest().uploadBugFile(AppUtils.getAppVersionName(), errorinfo,
                AppUtils.getMobileInfo(), String.valueOf(user.getUSERID()))
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(baseMsg -> {
                    if (baseMsg.getErrorCode() == 0) {
                        file.delete();
                    }
                });
    }

}
