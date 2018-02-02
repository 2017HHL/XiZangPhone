package com.mingnong.xizangphone.activity;

import android.os.Bundle;

import com.mingnong.xizangphone.R;


public class AboutUsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }

    @Override
    public void bindData() {
        setTitle("关于我们");
    }

    @Override
    public void bindListener() {

    }
}
