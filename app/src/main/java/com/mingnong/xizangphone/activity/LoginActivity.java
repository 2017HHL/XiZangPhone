package com.mingnong.xizangphone.activity;


import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.broadcast.DownloadReceiver;
import com.mingnong.xizangphone.dialog.DownloadDialog;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.ILoginActivity;
import com.mingnong.xizangphone.presenter.LoginActivityPresenter;
import com.mingnong.xizangphone.utils.AppUtils;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.OtherUtil;
import com.mingnong.xizangphone.utils.SPUtils;
import com.zhy.m.permission.MPermissions;
import com.zhy.m.permission.PermissionDenied;
import com.zhy.m.permission.PermissionGrant;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * Created by wyw on 2016/10/31.
 */

public class LoginActivity extends MVPActivity<LoginActivityPresenter> implements ILoginActivity {

    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etPwd)
    EditText etPwd;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    private DownloadDialog downloadDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected LoginActivityPresenter createPresenter() {
        return new LoginActivityPresenter(this);
    }

    @Override
    public void bindData() {

//        setTitle("登录");
//        getBack().setVisibility(View.GONE);
        tvVersion.setText("当前版本: " + AppUtils.getAppVersionName(this, getPackageName()));
        downloadDialog = new DownloadDialog.Builder(this).setTitle("下载apk")
                .setMessage("下载中").setCanCancel(false).create();
//        User user = (User) SPUtils.getInstance().getObjectData(Contance.USER_OBJECT);
        String userName = SPUtils.getInstance().getData(Contance.USER_NAME, "", String.class);
        String psw = SPUtils.getInstance().getData(Contance.USER_PSW, "", String.class);
//        if (user != null) {
//            Log.e("LoginActivity", user.toString());
        etUserName.setText(userName);
        etPwd.setText(psw);
//        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (!MPermissions.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, 100)) {
                MPermissions.requestPermissions(this, 100, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE});
//            MPermissions.requestPermissions(this, 100, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
        }
//        AppUtils.installApk(this, FileUtil.getInstance().getApkFile().getPath());

//        checkPermission();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, 100, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @PermissionGrant(100)
    public void permissionSuccess() {
        Toast.makeText(this, "权限申请成功", Toast.LENGTH_SHORT).show();
    }

    @PermissionDenied(100)
    public void permissionFail() {
        Toast.makeText(this, "权限申请失败", Toast.LENGTH_SHORT).show();
    }

    //标准模板
//    private void checkPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission_group.STORAGE)
//                    != PackageManager.PERMISSION_DENIED) {
//                //告诉用户为什么需要这个权限
//                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//
//                } else {
//                    //申请授权 这个项目需要读写sdcard的权限
//                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
//                            Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
//                }
//            } else {
//
//            }
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case 100:
//                //如果权限拒绝 那么grantResults长度是0
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
//                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                    //获取权限
//                } else {
//
//                }
//                break;
//        }
//    }
    int i = 0;

    @Override
    public void bindListener() {
//        RxView.clicks(btLogin)
//                .throttleFirst(1, TimeUnit.SECONDS)
//                .subscribe(aVoid ->
//                {
////                    File file = new File(Environment.getExternalStorageDirectory(), OtherUtil.toString(etUserName));
////                    OtherUtil.openFile(file);
//                    i++;
//                    Intent intent = new Intent(this, DownloadService.class);
//                    intent.setAction(DownloadService.ADD_TASK);
//                    intent.putExtra("fileName", "pic" + i + ".jpg");
//                    intent.putExtra("url", "http://tu.duowan.com/images/qrcode210.png?v=20150521");
//                    startService(intent);
////                    if (TextUtils.isEmpty(OtherUtil.toString(etUserName))) {
////                        Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
////                        return;
////                    }
////                    if (TextUtils.isEmpty(OtherUtil.toString(etPwd))) {
////                        Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
////                        return;
////                    }
////                    getPresenter().login(etUserName.getText().toString(), etPwd.getText().toString());
//                });
        RxView.clicks(btLogin)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid ->
                {
                    if (TextUtils.isEmpty(OtherUtil.toString(etUserName))) {
                        Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(OtherUtil.toString(etPwd))) {
                        Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    getPresenter().login(etUserName.getText().toString(), etPwd.getText().toString());
                } );
    }




    @Override
    public void loginSuccessful() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
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
//        new AlertDialog.Builder(this).setTitle("下载apk")
//                .setMessage("是否下载apk")
//                .setCancelable(false)
//                .setNegativeButton("是", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        getPresenter().startDownApk();
//                        //显示对话框
//                        LoginActivity.this.downloadDialog.show();
//                    }
//                }).setPositiveButton("否", (dialog, which) -> getPresenter().updateDb()).show();
    }

    public void clearCache(View view) {
        SPUtils.getInstance().removeKey(Contance.USER_OBJECT);
    }
}