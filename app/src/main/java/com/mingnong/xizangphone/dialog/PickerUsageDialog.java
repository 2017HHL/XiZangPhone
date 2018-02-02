package com.mingnong.xizangphone.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.Coder;
import com.mingnong.xizangphone.dao.external.DBExternalController;
import com.mingnong.xizangphone.dao.external.CoderDao;
import com.mingnong.xizangphone.view.datapicker.LoopView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyw on 2016/11/2.
 * 只有一列的datapickerdialog 用途
 */

public class PickerUsageDialog extends Dialog {
    private Params params;

    public PickerUsageDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    private void setParams(PickerUsageDialog.Params params) {
        this.params = params;
    }


    public void setSelection(String itemValue) {
        if (params.dataList.size() > 0) {
            int idx = params.dataList.indexOf(itemValue);
            if (idx >= 0) {
                params.initSelection = idx;
                params.loopData.setCurrentItem(params.initSelection);
            }
        }
    }
    private static final class Params {
        private boolean shadow = true;
        private boolean canCancel = true;
        private LoopView loopData;
        private String title;
        private String unit;
        private int initSelection;
        private OnDataSelectedListener callback;
        private List<Coder> dataList = new ArrayList<>();
    }

    public interface OnDataSelectedListener {
        void onDataSelected(String itemValue);
    }

    public static class Builder {
        private final Context context;
        private final PickerUsageDialog.Params params;

        public Builder(Context context) {
            this.context = context;
            params = new PickerUsageDialog.Params();
        }

        private final String getCurrDateValue() {
            return params.loopData.getCurrentItemValue();
        }


        public Builder setTitle(String title) {
            params.title = title;
            return this;
        }

        public Builder setUnit(String unit) {
            params.unit = unit;
            return this;
        }

        public Builder setSelection(int selection) {
            params.initSelection = selection;
            return this;
        }

        public Builder setOnDataSelectedListener(OnDataSelectedListener onDataSelectedListener) {
            params.callback = onDataSelectedListener;
            return this;
        }

        public Builder buildData() {
            params.dataList = buildeFirst();
            return this;
        }

        private List<Coder> buildeFirst() {
            CoderDao userDao = DBExternalController.getDaoSession().getCoderDao();
            return userDao.queryBuilder().where(CoderDao.Properties.CParent.eq("8")).build().list();
        }


        public PickerUsageDialog create() {
            final PickerUsageDialog dialog = new PickerUsageDialog(context, params.shadow ? R.style.Theme_Light_NoTitle_Dialog : R.style.Theme_Light_NoTitle_NoShadow_Dialog);
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_picker_first, null);

            if (!TextUtils.isEmpty(params.title)) {
                TextView txTitle = (TextView) view.findViewById(R.id.tv_title);
                txTitle.setText(params.title);
            }
            if (!TextUtils.isEmpty(params.unit)) {
                TextView txUnit = (TextView) view.findViewById(R.id.tx_unit);
                txUnit.setText(params.unit);
            }

            final LoopView loopData = (LoopView) view.findViewById(R.id.loop1);
            loopData.setArrayList(getList(params.dataList));
            loopData.setNotLoop();
            if (params.dataList.size() > 0) loopData.setCurrentItem(params.initSelection);
            view.findViewById(R.id.tv_finish).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    params.callback.onDataSelected(getCurrDateValue());
                }
            });

            Window win = dialog.getWindow();
            win.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams lp = win.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            win.setAttributes(lp);
            win.setGravity(Gravity.BOTTOM);
            win.setWindowAnimations(R.style.Animation_Bottom_Rising);
            dialog.setContentView(view);
            dialog.setCanceledOnTouchOutside(params.canCancel);
            dialog.setCancelable(params.canCancel);
            params.loopData = loopData;
            dialog.setParams(params);
            return dialog;
        }

        private List<String> getList(List<Coder> list) {
            ArrayList<String> result = new ArrayList<>();
            for (Coder coder : list) {
                result.add(coder.getCName());
            }
            return result;
        }
    }
}
