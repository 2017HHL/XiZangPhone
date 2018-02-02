package com.mingnong.xizangphone.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.interfac.Contance;

/**
 * Created by wyw on 2017/2/16.
 */

public class NoticeDialog extends DialogFragment implements View.OnClickListener {
    private TextView tvNotice;
    private OnClickListener confirmListener;
    private OnClickListener cancelListener;

    public NoticeDialog setConfirmListener(OnClickListener confirmListener,OnClickListener cancelListener) {
        this.cancelListener = cancelListener;
        this.confirmListener = confirmListener;
        return this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.CustomDatePickerDialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.gravity = Gravity.CENTER_HORIZONTAL;
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setAttributes(params);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_notice, container);
        tvNotice = (TextView) view.findViewById(R.id.tv_notice);
        view.findViewById(R.id.bt_confirm).setOnClickListener(this);
        view.findViewById(R.id.bt_cancel).setOnClickListener(this);
        Bundle bundle = getArguments();
        tvNotice.setText(bundle == null?"是否去填写打印信息?打印信息必须在联网状态下载,本地存储模块中进行打印":bundle.getString(Contance.START_ACTIVITY_DATA, ""));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        int dialogHeight = ((int) (getContext().getResources().getDisplayMetrics().heightPixels * 0.3));
        int dialogWidth = (int) (getContext().getResources().getDisplayMetrics().widthPixels * 0.7);
        getDialog().getWindow().setLayout(dialogWidth,dialogHeight);
        getDialog().setCanceledOnTouchOutside(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_confirm:
                if (confirmListener != null) {
                    confirmListener.onClick(v);
                    dismiss();
                }
                break;
            case R.id.bt_cancel:
                if (cancelListener != null) {
                    cancelListener.onClick(v);
                    dismiss();
                }
                break;
        }
    }

    public interface OnClickListener{
        void onClick(View view);
    }
}
