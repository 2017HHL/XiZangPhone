package com.mingnong.xizangphone.adapter;


import android.text.TextUtils;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.ProductApplyBean;
import com.mingnong.xizangphone.view.recyclerview.BaseQuickAdapter;
import com.mingnong.xizangphone.view.recyclerview.BaseViewHolder;

import java.util.List;

/**
 * Created by wyw on 2016/11/2.
 * 产品申报
 */

public class ProductQuarantineListAdapter extends BaseQuickAdapter<ProductApplyBean> {
    public ProductQuarantineListAdapter(List<ProductApplyBean> data) {
        super(R.layout.adapter_product_quarantine_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductApplyBean item) {
        String number = String.valueOf(item.getQCPQuantity()) + item.getQCPDanWei();
        helper.setText(R.id.tv_no,  TextUtils.isEmpty(item.getQCPNumber())?"":item.getQCPNumber())//编号
                .setText(R.id.tv_name,  TextUtils.isEmpty(item.getQCPCargoOwner())?"":item.getQCPCargoOwner()) //货主
                .setText(R.id.tv_phone, TextUtils.isEmpty(item.getQCPPhone())?"":item.getQCPPhone()) //申报人电话
                .setText(R.id.tv_state, TextUtils.isEmpty(item.getIsPrant())?"":item.getIsPrant())//状态
                .setText(R.id.tv_type, TextUtils.isEmpty(item.getQCPType())?"":item.getQCPType())//类型 省内 省外
                .setText(R.id.tv_anim_type, TextUtils.isEmpty(item.getFSmemo1())?"":item.getFSmemo1())//种类
                .setText(R.id.tv_anim_number, TextUtils.isEmpty(number)?"":number)//数量
                .setText(R.id.tv_apply_name, TextUtils.isEmpty(item.getFSuserName())?"":item.getFSuserName())//申报人
                .setText(R.id.tv_start_place_time, TextUtils.isEmpty(item.getDateQy())?"":item.getDateQy());//启运时间
    }
}
