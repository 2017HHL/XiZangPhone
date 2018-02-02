package com.mingnong.xizangphone.interfac;

/**
 * Created by wyw on 2016/10/31.
 */

public interface ILoginActivity extends IMVPActivity {

    void setDownDialogProgress(long bytesRead, long contentLength, boolean done);

    /**
     * 下载完成 发送广播
     * @param type
     */
    void onDownloadDone(int type);

    void showApkDialog();

    void loginSuccessful();
}

