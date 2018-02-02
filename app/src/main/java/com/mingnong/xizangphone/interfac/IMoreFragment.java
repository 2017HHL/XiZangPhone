package com.mingnong.xizangphone.interfac;

/**
 * Created by wyw on 2016/11/15.
 */
public interface IMoreFragment extends IMVPFragment{
    void setDownDialogProgress(long bytesRead, long contentLength, boolean done);

    /**
     * 下载完成 发送广播
     * @param type
     */
    void onDownloadDone(int type);

    void showApkDialog();
}
