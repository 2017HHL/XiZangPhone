package com.mingnong.xizangphone.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.activity.AboutUsActivity;
import com.mingnong.xizangphone.activity.LoginActivity;
import com.mingnong.xizangphone.broadcast.DownloadReceiver;
import com.mingnong.xizangphone.dialog.DownloadDialog;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IMoreFragment;
import com.mingnong.xizangphone.presenter.MoreFragmentPresenter;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.SPUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class MoreFragment extends MVPFragment<MoreFragmentPresenter> implements IMoreFragment {

    @BindView(R.id.bt_update)
    Button btUpdate;
    @BindView(R.id.bt_about_us)
    Button btAboutUs;
    @BindView(R.id.bt_exit)
    Button btExit;
    private DownloadDialog downloadDialog;
    private DownloadReceiver downloadReceiver;
    private IntentFilter intentFilter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    protected void bindListener() {
        RxView.clicks(btExit).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> {
                    SPUtils.getInstance().removeKey(Contance.USER_PSW);
                    startActivity(new Intent(getContext(), LoginActivity.class));
                    getActivity().finish();
                });
        RxView.clicks(btUpdate).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> {
                    getPresenter().updateApk();
                });
        RxView.clicks(btAboutUs).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> {
                    startActivity(new Intent(getContext(), AboutUsActivity.class));
                });
    }

    @Override
    public void onResume() {
        super.onResume();
        downloadReceiver = new DownloadReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction(DownloadReceiver.Action);
        getActivity().registerReceiver(downloadReceiver, intentFilter);
    }

    @Override
    protected void bindDate() {
        downloadDialog = new DownloadDialog.Builder(getContext()).setTitle("下载apk")
                .setMessage("下载中").setCanCancel(false).create();
    }

    @Override
    protected MoreFragmentPresenter createPresenter() {
        return new MoreFragmentPresenter(this);
    }

    @Override
    public void setDownDialogProgress(long bytesRead, long contentLength, boolean done) {
        downloadDialog.setProgress((int) (bytesRead / 1024));
        downloadDialog.setMax((int) (contentLength / 1024));
        if (done) {
            downloadDialog.dismiss();
        }
    }

    @Override
    public void onDownloadDone(int type) {
        Intent intent = new Intent(getContext(), DownloadReceiver.class);
        intent.setAction(DownloadReceiver.Action);
        switch (type) {
            //下载APK
            case Contance.TYPE_APK_DONE:
                intent.putExtra(DownloadReceiver.DOWNLOAD, DownloadReceiver.DOWNLAOD_APK);
                intent.putExtra(DownloadReceiver.PATH, FileUtil.getInstance().getApkFile().getAbsolutePath());
                break;
            case Contance.TYPE_DB_DONE:
                intent.putExtra(DownloadReceiver.DOWNLOAD, DownloadReceiver.DOWNLOAD_DB);
                intent.putExtra(DownloadReceiver.PATH, FileUtil.getInstance().getDbFile().getAbsolutePath());
                break;
            case Contance.TYPE_DEX_DONE:
//                intent.putExtra(DownloadReceiver.DOWNLOAD,DownloadReceiver.DOWNLAOD_DEX);
//                intent.putExtra(DownloadReceiver.PATH, FileUtil.getInstance().getDexFile().getAbsolutePath());
                break;
            case Contance.TYPE_PATCH_DONE:
                intent.putExtra(DownloadReceiver.DOWNLOAD, DownloadReceiver.DOWNLAOD_PATCH);
                intent.putExtra(DownloadReceiver.PATH, FileUtil.getInstance().getOuterPatchFile().getAbsolutePath());
                break;
        }
        getContext().sendBroadcast(intent);
    }

    @Override
    public void showApkDialog() {

        new AlertDialog.Builder(getContext()).setTitle("下载apk")
                .setMessage("是否下载apk")
                .setCancelable(false)
                .setNegativeButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().startDownApk();
                        //显示进度栏
                        MoreFragment.this.downloadDialog.show();
                    }
                }).setPositiveButton("否", (dialog, which) -> getPresenter().updateDb()).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(downloadReceiver);
    }
}
