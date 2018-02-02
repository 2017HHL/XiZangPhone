package com.mingnong.xizangphone.activity;


import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.igexin.sdk.PushManager;
import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.adapter.ViewPagerAdapter;
import com.mingnong.xizangphone.broadcast.DownloadReceiver;
import com.mingnong.xizangphone.dialog.DownloadDialog;
import com.mingnong.xizangphone.fragment.BaseFragment;
import com.mingnong.xizangphone.fragment.HomeFragment;
import com.mingnong.xizangphone.fragment.MoreFragment;
import com.mingnong.xizangphone.fragment.QueryFragment;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IMainActivity;
import com.mingnong.xizangphone.presenter.MainActivityPresenter;
import com.mingnong.xizangphone.service.DemoIntentService;
import com.mingnong.xizangphone.service.DemoPushService;
import com.mingnong.xizangphone.service.OfflineUploadService;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.NetWorkUtils;
import com.mingnong.xizangphone.view.bottombar.BottomBar;
import com.mingnong.xizangphone.view.bottombar.OnTabClickListener;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends MVPActivity<MainActivityPresenter> implements IMainActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    ViewPagerAdapter adapter;
    private BottomBar bottomBar;

    private DownloadDialog downloadDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main, savedInstanceState);
    }

    @Override
    protected MainActivityPresenter createPresenter() {
        return new MainActivityPresenter(this);
    }

    @Override
    protected void beforeBindData(Bundle savedInstanceState) {
        bottomBar = BottomBar.attach(this, savedInstanceState);
    }

    @Override
    public void bindData() {
        getPresenter().getUseId(this);
        //判断是否存在网络，存在网络就上传离线缓存的数据
        if (NetWorkUtils.isOpenNetwork(MyApplication.getContext())) {
            Intent startIntent = new Intent(this, OfflineUploadService.class);
            startService(startIntent);
        }
        PushManager.getInstance().initialize(this.getApplicationContext(), DemoPushService.class);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), DemoIntentService.class);

        getBack().setVisibility(View.GONE);
        setTitle("动监e通");
        downloadDialog = new DownloadDialog.Builder(this).setTitle("下载apk")
                .setMessage("下载中").setCanCancel(false).create();
        bottomBar.noTabletGoodness();
        bottomBar.setItems(R.menu.bottom_menu);
        bottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        bottomBar.mapColorForTab(1, 0xFF5D4037);
        bottomBar.mapColorForTab(2, "#7B1FA2");
//        bottomBar.mapColorForTab(3, "#FF5252");
//        bottomBar.mapColorForTab(4, "#FF9800");

        List<BaseFragment> mFragments = new ArrayList<>();
        mFragments.add(new HomeFragment());
        mFragments.add(new QueryFragment());
        mFragments.add(new MoreFragment());
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragments);
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(3);

        //权限判断
        if (Build.VERSION.SDK_INT >= 23) {
            if (!MPermissions.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, 100)) {
                MPermissions.requestPermissions(this, 100, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE});
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, 100, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(100)
    public void permissionSuccess() {
        getPresenter().updateApk();
    }

    @PermissionDenied(100)
    public void permissionFail() {
        Toast.makeText(this, "权限申请失败,程序将不能正常运行", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void bindListener() {
        bottomBar.setOnTabClickListener(new OnTabClickListener() {
            @Override
            public void onTabSelected(int position) {
                viewpager.setCurrentItem(position);
            }

            @Override
            public void onTabReSelected(int position) {

            }
        });

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomBar.selectTabAtPosition(position, true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        bottomBar.onSaveInstanceState(outState);
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
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onDownloadDone(int type) {
        Intent intent = new Intent(this, DownloadReceiver.class);
        intent.setAction(DownloadReceiver.Action);
        switch (type) {
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
        sendBroadcast(intent);
    }

    @Override
    public void showApkDialog() {
        new AlertDialog.Builder(this).setTitle("下载apk")
                .setMessage("是否下载apk")
                .setCancelable(false)
                .setNegativeButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().startDownApk();
                        //显示对话框
                        MainActivity.this.downloadDialog.show();
                    }
                }).setPositiveButton("否", (dialog, which) -> getPresenter().updateDb()).show();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long secondTime = System.currentTimeMillis();

            if (secondTime - firstTime > 800) {// 如果两次按键时间间隔大于800毫秒，则不退出
                Toast.makeText(this, "再按一次退出程序...",
                        Toast.LENGTH_SHORT).show();
                firstTime = secondTime;// 更新firstTime
                return true;
            } else {
//                secheFile();
                System.exit(0);// 否则退出程序
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    private long firstTime = 0;

    @Override
    public void onDestroy() {
        super.onDestroy();
        Intent stopIntent = new Intent(this, OfflineUploadService.class);
        stopService(stopIntent);
    }
}