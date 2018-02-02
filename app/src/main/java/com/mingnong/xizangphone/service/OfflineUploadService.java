package com.mingnong.xizangphone.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.dao.external.OfflineUploadManager;

/**
 * Created by Administrator on 2017/5/20.
 */

public class OfflineUploadService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,  int flags, int startId) {
        OfflineUploadManager.getInstance(MyApplication.getContext()).startUpload();
        return super.onStartCommand(intent, flags, startId);
    }
}
