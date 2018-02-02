package com.mingnong.xizangphone.interfac;

/**
 * Created by wyw on 2016/11/18.
 */
public interface IMainActivity extends IMVPActivity{
    void setDownDialogProgress(long bytesRead, long contentLength, boolean done);

    /**
     * 下载完成 发送广播
     * @param type
     */
    void onDownloadDone(int type);

    void showApkDialog();

}
