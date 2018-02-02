package com.mingnong.xizangphone.adapter;


import android.text.TextUtils;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.PrintRecordListBean;
import com.mingnong.xizangphone.view.recyclerview.BaseQuickAdapter;
import com.mingnong.xizangphone.view.recyclerview.BaseViewHolder;

import java.util.List;

/**
 * Created by wyw on 2016/11/29.
 */

public class PrintRecordAdapter extends BaseQuickAdapter<PrintRecordListBean.DataListBean> {
    public PrintRecordAdapter(List<PrintRecordListBean.DataListBean> dataList) {
        super(R.layout.adapter_print_record, dataList);
    }

    @Override
    protected void convert(BaseViewHolder helper, PrintRecordListBean.DataListBean item) {
        helper.setText(R.id.tv_no, TextUtils.isEmpty(item.getANumber())?"":item.getANumber())
                .setText(R.id.tv_apply_time, TextUtils.isEmpty(item.getDateQF())?"":item.getDateQF())
                .setText(R.id.tv_name, TextUtils.isEmpty(item.getACargoOwner())?"":item.getACargoOwner())
                .setText(R.id.tv_state, TextUtils.isEmpty(item.getIsPrant())?"":item.getIsPrant());

    }
}
