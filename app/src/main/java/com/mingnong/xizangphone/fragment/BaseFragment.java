package com.mingnong.xizangphone.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wyw on 2016/7/25.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    protected DisplayMetrics metrics;
    private Unbinder bind;
    private ProgressDialog dialog;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(metrics);
        dialog = new ProgressDialog(context);
        dialog.setMessage("加载中");
    }

    @Override
    public void onClick(View view) {

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind = ButterKnife.bind(this, view);
        bindDate();
        bindListener();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (bind != null) bind.unbind();
    }

    protected abstract void bindListener();

    protected abstract void bindDate();

    public ProgressDialog getDialog() {
        return dialog;
    }
}
