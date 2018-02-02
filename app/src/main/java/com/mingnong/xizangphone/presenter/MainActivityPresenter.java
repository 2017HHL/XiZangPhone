package com.mingnong.xizangphone.presenter;


import android.content.Context;

import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.activity.MainActivity;
import com.mingnong.xizangphone.dao.external.UseidDB;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IMainActivity;
import com.mingnong.xizangphone.runnable.download.DownlaodClient;
import com.mingnong.xizangphone.runnable.download.DownloadProgressHandler;
import com.mingnong.xizangphone.runnable.download.ProgressHelper;
import com.mingnong.xizangphone.utils.AppUtils;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.NetWorkUtils;
import com.mingnong.xizangphone.utils.OtherUtil;

import java.io.File;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wyw on 2016/11/18.
 */
public class MainActivityPresenter extends BaseActivityPresenter<IMainActivity> {

    public MainActivityPresenter(IMainActivity view) {
        super(view);
    }

    /**
     * 是否更新
     */
    public void updateApk() {
        addSubscribe(getRequest().checkApkVersions(AppUtils.getAppVersionName())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(result -> {
                    if (result.getErrorCode() == 0) {
                        //弹出apk下载对话框
                        getView().showApkDialog();
                    } else {
//                        getView().showToast("已经是最新版本");
                        //请求数据库版本
                        updateDb();
                    }
                }, e -> getView().showToast(e.getMessage())));

    }

    public void updateDb() {
        String dbVersion = getSpUtils().getData(Contance.SP_DB_VERSION, "0.0", String.class);
        addSubscribe(getRequest().checkDbVersion(dbVersion)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(result -> {
                    if (result.getErrorCode() == 0) {
                        //直接下载,不需要提示
                        startDownDb(result.getData().getResult());
                    } else {
                        updatePatch();
                    }
                }, e -> {
                }));
    }

    private void updatePatch() {
        String patchVersion = getSpUtils().getData(Contance.SP_PATCH_VERSION, "1.0", String.class);
        addSubscribe(getRequest().checkPatchVersion(OtherUtil.getTableName(MainActivity.class, "updatePatch()"), patchVersion)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(result -> {
                    if (result.getErrorCode() == 0) {
                        //删除外部的补丁
                        File outerPatchFile = FileUtil.getInstance().getOuterPatchFile();
                        if (outerPatchFile.exists()) outerPatchFile.delete();
                        //直接下载,不需要提示
                        startDownPatch(result.getData().getResult());
                    } else if (result.getErrorCode() == 1) {
                        //本地版本号高 服务器 没数据
                        getSpUtils().saveData(Contance.SP_PATCH_VERSION, "1.0");
                    }
                }, e -> {
                }));
    }


    /**
     * 开始下载apk
     */
    public void startDownApk() {
        //删除外部以及内部补丁文件
        if (FileUtil.getInstance().getOuterPatchFile().exists())
            FileUtil.getInstance().getOuterPatchFile().delete();
        if (FileUtil.getInstance().getInternalPatchFile().exists())
            FileUtil.getInstance().getInternalPatchFile().delete();
//        getView().showApkDialog();
        ProgressHelper.setProgressHandler(new DownloadProgressHandler() {
            @Override
            protected void onProgress(long bytesRead, long contentLength, boolean done) {
                //在这里dismiss
                getView().setDownDialogProgress(bytesRead, contentLength, done);
                if (done) {
                    getView().onDownloadDone(Contance.TYPE_APK_DONE);
                }
            }
        });
        DownlaodClient.getInstance().downloadApk(FileUtil.getInstance().getApkFile().getAbsolutePath());
    }

    boolean download = false;

    /**
     * 开始下载数据库
     */
    private void startDownDb(String version) {
        if (NetWorkUtils.isOpenNetwork(MyApplication.getContext())) {
            //删除之前数据
            FileUtil.getInstance().getDbFile().delete();
            //删除内部数据库
            FileUtil.getInstance().getInternalDbFile().delete();
            ProgressHelper.setProgressHandler(new DownloadProgressHandler() {
                @Override
                protected void onProgress(long progress, long total, boolean done) {
                    if (done && !download) {
                        download = true;
                        //更换db版本号
                        getSpUtils().saveData(Contance.SP_DB_VERSION, version);
                        getView().onDownloadDone(Contance.TYPE_DB_DONE);
                    }
                }
            });
            DownlaodClient.getInstance().downloadDb(FileUtil.getInstance().getDbFile().getAbsolutePath());
        }
    }

    /**
     * 开始下载patch补丁
     */
    private void startDownPatch(String version) {
        //删除之前patch补丁
        FileUtil.getInstance().getOuterPatchFile().delete();
        FileUtil.getInstance().getInternalPatchFile().delete();
        ProgressHelper.setProgressHandler(new DownloadProgressHandler() {
            @Override
            protected void onProgress(long progress, long total, boolean done) {
                if (done) {
                    //更换patch版本号
                    getSpUtils().saveData(Contance.SP_PATCH_VERSION, version);
                    getView().onDownloadDone(Contance.TYPE_PATCH_DONE);
                }
            }
        });
        DownlaodClient.getInstance().downloadPatch(FileUtil.getInstance().getOuterPatchFile().getAbsolutePath());
    }

    public void getUseId(Context context) {
        if (NetWorkUtils.isOpenNetwork(MyApplication.getContext())) {
            UseidDB useidDB = UseidDB.getInstance(context);
            List<String> uerid = useidDB.query();
            if (uerid == null) {
                useidDB.insert(getUserId());
            } else {
                for (int i = 0; i < uerid.size(); i++) {
                    useidDB.delete(uerid.get(i));
                }
                useidDB.insert(getUserId());
            }
        }
    }
}
