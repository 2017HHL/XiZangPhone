package com.mingnong.xizangphone.presenter;


import com.mingnong.xizangphone.activity.MainActivity;
import com.mingnong.xizangphone.bean.BaseMsgBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IMoreFragment;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.download.DownlaodClient;
import com.mingnong.xizangphone.runnable.download.DownloadProgressHandler;
import com.mingnong.xizangphone.runnable.download.ProgressHelper;
import com.mingnong.xizangphone.utils.AppUtils;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.OtherUtil;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by wyw on 2016/11/15.
 */
public class MoreFragmentPresenter extends BaseFragmentPresenter<IMoreFragment> {
    public MoreFragmentPresenter(IMoreFragment mView) {
        super(mView);
    }

    /**
     * 是否更新apk
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
                        getView().showToast("已经是最新版本");
                        //请求数据库版本
                        updateDb();
                    }
                }, e -> getView().showToast(e.getMessage())));
    }


    public void updateDb() {
        String dbVersion = getSpUtils().getData(Contance.SP_DB_VERSION, "1.0", String.class);
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


//        String dbVersion = getSpUtils().getData(Contance.SP_DB_VERSION, "1.0", String.class);
//        addSubscribe(getRequest().checkDbVersion(OtherUtil.getTableName(MainActivity.class, "updateDb()"), dbVersion)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(result -> {
//                    if (result.getErrorCode() == 0) {
//                        //直接下载,不需要提示
//                        startDownDb(result.getData().getResult());
//                    } else {
//                        updatePatch();
//                    }
//                }, e -> {
//                }));
    }

    private void updatePatch() {
        String patchVersion = getSpUtils().getData(Contance.SP_PATCH_VERSION, "1.0", String.class);
        addSubscribe(getRequest().checkPatchVersion(OtherUtil.getTableName(MainActivity.class, "updatePatch()"), patchVersion)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(result -> {
                    if (result.getErrorCode() == 0) {
                        //直接下载,不需要提示
                        startDownPatch(result.getData().getResult());
                    }
                }, e -> {
                }));
    }

    /**
     * 开始下载apk
     */
    public void startDownApk() {
        getView().showApkDialog();
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

    /**
     * 开始下载数据库
     */
    private void startDownDb(String version) {
        //删除之前数据
        FileUtil.getInstance().getDbFile().delete();
        //删除内部数据库
        FileUtil.getInstance().getInternalDbFile().delete();
        ProgressHelper.setProgressHandler(new DownloadProgressHandler() {
            @Override
            protected void onProgress(long progress, long total, boolean done) {
                if (done) {
                    //更换db版本号
                    getSpUtils().saveData(Contance.SP_DB_VERSION, version);
                    getView().onDownloadDone(Contance.TYPE_DB_DONE);
                }
            }
        });
        DownlaodClient.getInstance().downloadDb(FileUtil.getInstance().getDbFile().getAbsolutePath());
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

}
