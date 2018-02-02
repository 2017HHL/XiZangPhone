package com.mingnong.xizangphone.dao.external;

import android.content.Context;

import com.mingnong.xizangphone.bean.UploadBean;
import com.mingnong.xizangphone.dao.User;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IMVPActivity;
import com.mingnong.xizangphone.presenter.BaseActivityPresenter;
import com.mingnong.xizangphone.runnable.DoOnSubscriber;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.utils.SPUtils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wyw on 2017/5/19.
 */

public class OfflineUploadManager {
    private volatile static OfflineUploadManager instance;
    private ExecutorService service;
    private PrintDB db;
    private UseidDB useidDB;
    private User user;


    public OfflineUploadManager(Context context) {
        service = Executors.newSingleThreadExecutor();
        db = PrintDB.getInstance(context);
        useidDB = UseidDB.getInstance(context);
    }

    public static final synchronized OfflineUploadManager getInstance(final Context context) {
        if (instance == null) {
            instance = new OfflineUploadManager(context.getApplicationContext());
        }
        return instance;
    }

    public SPUtils getSpUtils() {
        return SPUtils.getInstance();
    }

    public User getUser() {
        if (user == null) {
            user = (User) getSpUtils().getObjectData(Contance.USER_OBJECT);
//            user = new User();
        }
        return user;
    }

    public String getUserId() {
        //Log.e("-----------","------------------------------getUserId()-------------------------------");
        return String.valueOf(getUser().getUSERID());
    }

    public void startUpload() {
//        Future<List<UploadBean>> future = service.submit(new Callable<List<UploadBean>>() {
//            @Override
//            public List<UploadBean> call() throws Exception {
//                return ;
//            }
//        });
        service.submit(() -> {
            List<UploadBean> list = db.query();
            List<String> userIdList = useidDB.query();
            if (list != null && userIdList != null) {
                for (UploadBean bean : list) {
                    if (userIdList != null) {
                        //上传
                        NetClient.upload(userIdList.get(0), bean.getTableName(), bean.getJson())
                                .map(animAUploadBean -> {
                                    //判断是否上传完成,上传完成删除数据
                                    if (animAUploadBean.getErrorCode() == 0) {
                                        db.delete(bean.getPrintId());
                                    }
                                    return null;
                                }).subscribe(o -> {
                        }, throwable -> {
                        });
                        //上传完成删除数据
//                    db.delete(bean.getPrintId());
                    }
                }
            }
        });
    }

}
