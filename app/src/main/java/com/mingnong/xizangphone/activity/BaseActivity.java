package com.mingnong.xizangphone.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.jakewharton.rxbinding.view.RxView;
import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.interfac.IActivity;
import com.mingnong.xizangphone.service.OfflineUploadService;
import com.mingnong.xizangphone.utils.NetWorkUtils;
import com.mingnong.xizangphone.view.StatusBarUtil;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wyw on 2016/10/31.
 */

public abstract class BaseActivity extends FragmentActivity implements IActivity {

    protected ImageView back, add;
    private TextView tvTitle;
    private Unbinder bind;
    private ProgressDialog dialog;

    public ImageView getBack() {
        return back;
    }

    public ImageView getAdd() {
        return add;
    }

    public ProgressDialog getDialog() {
        return dialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setContentView(int layoutResID, Bundle savedInstanceState) {
        super.setContentView(layoutResID);
        bind = ButterKnife.bind(this);
        setStatusBarColor();
        initBase();
        dialog = new ProgressDialog(this);
        dialog.setMessage("加载中");
        beforeBindData(savedInstanceState);
        bindData();
        bindListener();
    }

    protected void beforeBindData(Bundle savedInstanceState) {
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        bind = ButterKnife.bind(this);
        setStatusBarColor();
        initBase();
        dialog = new ProgressDialog(this);
        dialog.setMessage("加载中");
        bindData();
        bindListener();
    }


    protected void setStatusBarColor() {
        if (Build.VERSION.SDK_INT >= 23) {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.titleBarBg, getTheme()));
        } else {
            StatusBarUtil.setColor(this, getResources().getColor(R.color.titleBarBg));
        }
    }

    protected void initBase() {
        try {
            findBack();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            findTitle();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            findAdd();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void findAdd() throws Exception {
        add = (ImageView) findViewById(R.id.bt_add);
    }

    ;

    protected void setTitle(String title) {
        try {
            if (tvTitle != null) {
                tvTitle.setText(title);
            }
        } catch (Exception e) {

        }
    }

    private void findTitle() throws Exception {
        tvTitle = (TextView) findViewById(R.id.tv_title);
    }

    private void findBack() throws Exception {
        back = (ImageView) findViewById(R.id.bt_back);
//        back.setOnClickListener((view)->finish());
        RxView.clicks(back).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> finish());
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (NetWorkUtils.isOpenNetwork(MyApplication.getContext())) {
            Intent startIntent = new Intent(this, OfflineUploadService.class);
            startService(startIntent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }

    protected String getString(View view) {
        if (view instanceof EditText) return ((TextView) view).getText().toString();
        if (view instanceof Spinner)
            return ((Spinner) view).getSelectedItem().toString();
        if (view instanceof TextView) return ((TextView) view).getText().toString();
        return view.toString();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }


}
