package com.mingnong.xizangphone.activity;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.AnimalApplyBean;
import com.mingnong.xizangphone.interfac.Contance;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 产品检疫申报单详情
 */
public class AnimDeclareDetilActivity extends BaseActivity {


    @BindView(com.mingnong.xizangphone.R.id.et_no)
    EditText etNo;
    @BindView(R.id.et_type)
    EditText etType;
    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_user_phone)
    EditText etUserPhone;
    @BindView(R.id.et_anim_type)
    EditText etAnimType;
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.et_source)
    EditText etSource;
    @BindView(R.id.et_start_place_time)
    EditText etStartPlaceTime;
    @BindView(R.id.et_start_place)
    EditText etStartPlace;
    @BindView(R.id.et_end_place)
    EditText etEndPlace;
    @BindView(R.id.et_carrier_name)
    EditText etCarrierName;
    @BindView(R.id.et_carrier_phone)
    EditText etCarrierPhone;
    @BindView(R.id.et_method)
    EditText etMethod;
    @BindView(R.id.et_util_number)
    EditText etUtilNumber;
    @BindView(R.id.et_apply_time)
    EditText etApplyTime;
    @BindView(R.id.et_sterilize)
    EditText etSterilize;
    @BindView(R.id.et_usage)
    EditText etUsage;
    @BindView(R.id.tv_start_place_type)
    TextView tvStartPlaceType;
    @BindView(R.id.et_start_place_xiang)
    EditText etStartPlaceXiang;
    @BindView(R.id.et_start_place_tuzaichang)
    EditText etStartPlaceTuzaichang;
    @BindView(R.id.tv_start_place_country)
    TextView tvStartPlaceCountry;
    @BindView(R.id.tv_end_place_type)
    TextView tvEndPlaceType;
    @BindView(R.id.et_end_place_xiang)
    EditText etEndPlaceXiang;
    @BindView(R.id.et_end_place_tuzaichang)
    EditText etEndPlaceTuzaichang;
    @BindView(R.id.tv_end_place_country)
    TextView tvEndPlaceCountry;
    @BindView(R.id.et_erbiao)
    EditText etErbiao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_declare_detil);
        ButterKnife.bind(this);
    }

    @Override
    public void bindData() {
        setTitle("动物检疫申报单详情");
        AnimalApplyBean bean = (AnimalApplyBean) getIntent().getSerializableExtra(Contance.START_ACTIVITY_DATA);
        if (bean != null) {
            etNo.setText(bean.getQDWNumber());//申报单编号
            etType.setText(bean.getQDWType());//类型 省内 省外
            etUserName.setText(bean.getQDWCargoOwner());//货主姓名
            etUserPhone.setText(bean.getQDWPhone());//货主电话
            etAnimType.setText(bean.getFSmemo1());//动物种类
            etNumber.setText(bean.getQDWQuantity() + bean.getQDWDanWei());//数量以及单位
            etSource.setText(bean.getQDWLaiYuan());//来源
            etStartPlaceTime.setText(bean.getDateQy());//启运时间
            etStartPlace.setText(bean.getQDWShengQy() + bean.getQDWShiQy()
                    + bean.getQDWXianQy());//启运地址
            etStartPlaceXiang.setText(bean.getQDWXiangQy());
            etStartPlaceTuzaichang.setText(bean.getQDWCunQy());
            etEndPlace.setText(bean.getQDWShengDd() + bean.getQDWShiDd()
                    + bean.getQDWXianDd());//到达地址
            etEndPlaceXiang .setText(bean.getQDWXiangDd());
            etEndPlaceTuzaichang.setText(bean.getQDWCunDd());

            etCarrierName.setText(bean.getQDWChengYunRen());//承运人
            etCarrierPhone.setText(bean.getQDWCyrDianHua());//承运人电话
            etMethod.setText(bean.getQDWYunZai());//运输 方式
            etUtilNumber.setText(bean.getQDWTrademark());//运输工具号
            etSterilize.setText(bean.getQDWDisinfection());//运载前消毒
            etErbiao.setText(bean.getQDWErBiaoHao());//耳标号
            etApplyTime.setText(bean.getDateQF());//申报日期
            etUsage.setText(bean.getQDWYongTu());
            // 启运地点类别
            String startPlaceType = bean.getQDWTypeQy();
            tvStartPlaceType.setText(startPlaceType);
            if (startPlaceType.contains("养殖")) {
                tvStartPlaceCountry.setText("养殖场");
            } else if (startPlaceType.contains("交易市")) {
                tvStartPlaceCountry.setText("交易市场");
            } else if (startPlaceType.equals("散养户")) {
                tvStartPlaceCountry.setText("村");
            } else {
                tvStartPlaceCountry.setText("");
            }
            //到达地点类别
            String endPlaceType = bean.getQDWTypeDd();
            tvEndPlaceType.setText(endPlaceType);
            if (endPlaceType.equals("养殖场")) {
                tvEndPlaceCountry.setText("养殖场");
            } else if (endPlaceType.equals("交易市场")) {
                tvEndPlaceCountry.setText("交易市场");
            } else if (endPlaceType.equals("散养户")) {
                tvEndPlaceCountry.setText("村");
            } else if (endPlaceType.equals("屠宰场") ||
                    endPlaceType.equals("屠宰户")) {
                tvEndPlaceCountry.setText("屠宰场");
            } else {
                tvEndPlaceCountry.setText("");
            }
        }
    }

    @Override
    public void bindListener() {

    }
}
