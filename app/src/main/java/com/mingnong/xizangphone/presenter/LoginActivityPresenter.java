package com.mingnong.xizangphone.presenter;


import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.dao.User;
import com.mingnong.xizangphone.dao.local.DBInnerController;
import com.mingnong.xizangphone.dao.local.UserDao;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.ILoginActivity;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.download.DownlaodClient;
import com.mingnong.xizangphone.runnable.download.DownloadProgressHandler;
import com.mingnong.xizangphone.runnable.download.ProgressHelper;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.NetWorkUtils;

import java.util.List;

/**
 * Created by wyw on 2016/10/31.
 */

public class LoginActivityPresenter extends BaseActivityPresenter<ILoginActivity> {

    public LoginActivityPresenter(ILoginActivity view) {
        super(view);
//        updateApk();
    }

    public void login(String userName, String psw) {
        if (NetWorkUtils.isOpenNetwork(MyApplication.getContext())) {
            addSubscribe(NetClient.login1(userName, psw)
                    .doOnSubscribe(() -> getView().showProgress())
                    .map(loginBean -> {
                        if (loginBean == null) {
                            throw new IllegalArgumentException("null");
                        }
                        if (loginBean.getErrorCode() != 0) {
                            throw new IllegalArgumentException(loginBean.getErrorMsg());
                        }else {
                            //从数据库查找是否存在用户
                            UserDao userDao = DBInnerController.getDaoSession().getUserDao();
                            List<User> list = userDao.queryBuilder().where(UserDao.Properties.FUACCOUNT.eq(userName),
                                    UserDao.Properties.FUPASSWORD.eq(psw)).build().list();
                            User user = new User();
                            user.setFUACCOUNT(userName);
                            user.setFUPASSWORD(psw);
                            if (list != null && list.size() > 0) {
//                               userDao.update(user);
                            }else {
                                userDao.insert(user);
                            }
                        }

                        return loginBean.getData();
                    })
                    .subscribe(user -> {
                                getSpUtils().saveObjectData(Contance.USER_OBJECT, user);
                                getSpUtils().saveData(Contance.USER_NAME, userName);
                                getSpUtils().saveData(Contance.USER_PSW, psw);
                                //存入数据库 遍历数据库所有的用户对比账户名
                                UserDao userDao = DBInnerController.getDaoSession().getUserDao();
                                List<User> list = userDao.queryBuilder().where(UserDao.Properties.USERID.eq(user.getUSERID())).build().list();
                                if (list != null && list.size() > 0) {
                                    user.setCId(list.get(0).getCId());
                                    userDao.update(user);
                                } else {
                                    user.setCId(null);
                                    userDao.insertOrReplace(user);
                                }
                                getView().loginSuccessful();
                            }, throwable -> {
                                getView().showToast(throwable.getMessage());
                                getView().hideProgress();
                            },
                            () -> getView().hideProgress()));
        } else {
            //从数据库查找是否存在用户
            UserDao userDao = DBInnerController.getDaoSession().getUserDao();
            List<User> list = userDao.queryBuilder().where(UserDao.Properties.FUACCOUNT.eq(userName),
                    UserDao.Properties.FUPASSWORD.eq(psw)).build().list();
            if (list != null && list.size() > 0) {
                //list
                getSpUtils().saveObjectData(Contance.USER_OBJECT, list.get(0));
                getView().loginSuccessful();
            } else {
                getView().showToast("数据库没有该数据,请在联网状态下登录");
            }
        }

    }

//    /**
//     * 是否更新
//     */
//    public void updateApk() {
//        addSubscribe(getRequest().checkApkVersion(MainActivity.class.getSimpleName()+"$updateApk()",AppUtils.getAppVersionName() + "-HN")
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(result -> {
//                    if (result.getErrorCode() == 0) {
//                        //弹出apk下载对话框
//                        getView().showApkDialog();
//                    } else {
//                        //请求数据库版本
//                        updateDb();
//                    }
//                }, e -> getView().showToast(e.getMessage())));
//    }

//    public void updateDb() {
//        String dbVersion = getSpUtils().getData(Contance.SP_DB_VERSION, "0.0", String.class);
//        addSubscribe(getRequest().checkDbVersion(dbVersion)
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
//    }

//    private void updatePatch() {
//        String patchVersion = getSpUtils().getData(Contance.SP_PATCH_VERSION, "1.0", String.class);
//        addSubscribe(getRequest().checkPatchVersion(patchVersion)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(result -> {
//                    if (result.getErrorCode() == 0) {
//                        //直接下载,不需要提示
//                        startDownPatch(result.getData().getResult());
//                    }
//                }, e -> {
//                }));
//    }


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
    /**
     * 开始下载dex文件
     */
//    private void startDownDex() {
    //删除之前dex文件
//        FileUtils.getInstance().getDexFile().delete();
//        ProgressHelper.setProgressHandler(new DownloadProgressHandler() {
//            @Override
//            protected void onProgress(long progress, long total, boolean done) {
//                if (done) {
//                    getView().onDownloadDone(Contance.TYPE_DEX_DONE);
//                }
//            }
//        });
//        DownlaodClient.getInstance().downloadDex(FileUtils.getInstance().getDexFile().getAbsolutePath());
//    }

}
