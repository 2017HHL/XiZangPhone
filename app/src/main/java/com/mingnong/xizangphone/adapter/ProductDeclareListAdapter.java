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

public class ProductDeclareListAdapter extends BaseQuickAdapter<ProductApplyBean> {
    public ProductDeclareListAdapter(List<ProductApplyBean> data) {
        super(R.layout.adapter_product_declare_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductApplyBean item) {
        String number = String.valueOf(item.getQCPQuantity()) + item.getQCPDanWei();
        helper.setText(R.id.tv_no, TextUtils.isEmpty(item.getQCPNumber())?"":item.getQCPNumber())
                .setText(R.id.tv_type, TextUtils.isEmpty(item.getQCPType())?"":item.getQCPType())
                .setText(R.id.tv_name, TextUtils.isEmpty(item.getQCPCargoOwner())?"":item.getQCPCargoOwner())
                .setText(R.id.tv_phone, TextUtils.isEmpty(item.getQCPPhone())?"":item.getQCPPhone())
                .setText(R.id.tv_anim_type, TextUtils.isEmpty(item.getQCProduct())?"":item.getQCProduct())
                .setText(R.id.tv_anim_number, TextUtils.isEmpty(number)?"":number)
                .setText(R.id.tv_apply_name, TextUtils.isEmpty(item.getFSuserName())?"":item.getFSuserName())//申报人
                .setText(R.id.tv_time, TextUtils.isEmpty(item.getDateQF())?"":item.getDateQF());

    }
}
