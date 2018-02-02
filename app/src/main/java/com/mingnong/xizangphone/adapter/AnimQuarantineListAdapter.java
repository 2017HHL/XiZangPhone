package com.mingnong.xizangphone.adapter;


import android.text.TextUtils;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.AnimalApplyBean;
import com.mingnong.xizangphone.view.recyclerview.BaseQuickAdapter;
import com.mingnong.xizangphone.view.recyclerview.BaseViewHolder;

import java.util.List;

/**
 * Created by wyw on 2016/11/9.
 *
 */

public class AnimQuarantineListAdapter extends BaseQuickAdapter<AnimalApplyBean> {
    public AnimQuarantineListAdapter(List<AnimalApplyBean> data) {
        super(R.layout.adapter_anim_quarantine_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AnimalApplyBean item) {
        String number = String.valueOf(item.getQDWQuantity()) + item.getQDWDanWei();
        helper.setText(R.id.tv_no, TextUtils.isEmpty(item.getQDWNumber())?"":item.getQDWNumber())//编号
                .setText(R.id.tv_name, TextUtils.isEmpty(item.getQDWCargoOwner())?"":item.getQDWCargoOwner() ) //货主
                .setText(R.id.tv_phone, TextUtils.isEmpty(item.getQDWPhone())?"":item.getQDWPhone() ) //申报人电话
                .setText(R.id.tv_state, TextUtils.isEmpty(item.getIsPrant())?"":item.getIsPrant() )//状态
                .setText(R.id.tv_type, TextUtils.isEmpty(item.getQDWType())?"":item.getQDWType() )//类型 省内 省外
                .setText(R.id.tv_anim_type, TextUtils.isEmpty(item.getFSmemo1())?"":item.getFSmemo1() )//动物种类
                .setText(R.id.tv_anim_number, TextUtils.isEmpty(number)?"":number)
                .setText(R.id.tv_apply_name, TextUtils.isEmpty(item.getFSuserName())?"":item.getFSuserName())//申报人
                .setText(R.id.tv_start_place_time, TextUtils.isEmpty(item.getDateQy())?"":item.getDateQy());//启运时间
    }
}
