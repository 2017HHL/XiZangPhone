package com.mingnong.xizangphone.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.AnimalApplyBean;
import com.mingnong.xizangphone.dao.Animal_A;
import com.mingnong.xizangphone.bus.RefreshBus;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IAnimPrintAActivity;
import com.mingnong.xizangphone.presenter.AnimPrintAActivityPresenter;
import com.mingnong.xizangphone.runnable.RxBus;
import com.mingnong.xizangphone.utils.OtherUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;


public class AnimPrintAActivity extends MVPActivity<AnimPrintAActivityPresenter> implements IAnimPrintAActivity {

    @BindView(R.id.et_no)
    EditText etNo;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_user_phone)
    TextView tvUserPhone;
    @BindView(R.id.tv_anim_type)
    TextView tvAnimType;
    @BindView(R.id.tv_useage)
    TextView tvUseage;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.tv_start_place)
    TextView tvStartPlace;
    @BindView(R.id.tv_start_place_type)
    TextView tvStartPlaceType;
    @BindView(R.id.et_start_place_xiang)
    EditText etStartPlaceXiang;
    @BindView(R.id.et_start_place_tuzaichang)
    EditText etStartPlaceTuzaichang;
    @BindView(R.id.tv_start_place_country)
    TextView tvStartPlaceCountry;
    @BindView(R.id.tv_end_place)
    TextView tvEndPlace;
    @BindView(R.id.tv_end_place_type)
    TextView tvEndPlaceType;
    @BindView(R.id.et_end_place_xiang)
    EditText etEndPlaceXiang;
    @BindView(R.id.et_end_place_tuzaichang)
    EditText etEndPlaceTuzaichang;
    @BindView(R.id.tv_end_place_country)
    TextView tvEndPlaceCountry;
    @BindView(R.id.et_carrier_name)
    EditText etCarrierName;
    @BindView(R.id.et_carrier_phone)
    EditText etCarrierPhone;
    @BindView(R.id.tv_method)
    TextView tvMethod;
    @BindView(R.id.et_util_number)
    EditText etUtilNumber;
    @BindView(R.id.et_sterilize)
    EditText etSterilize;
    @BindView(R.id.spinner_effect_arrive_time)
    Spinner spinnerEffectArriveTime;
    @BindView(R.id.tv_qianfa_time)
    TextView tvQianfaTime;
    @BindView(R.id.et_erbiao)
    EditText etErbiao;
    @BindView(R.id.tv_guanfang_name)
    TextView tvGuanfangName;
    @BindView(R.id.tv_guanfang_phone)
    TextView tvGuanfangPhone;
    @BindView(R.id.et_remark)
    EditText etRemark;
    @BindView(R.id.bt_print)
    Button btPrint;
    @BindView(R.id.lin_erbiao)
    LinearLayout linErbiao;
    private Animal_A bean;
    private AnimalApplyBean animalApplyBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_print_a);
    }

    @Override
    protected AnimPrintAActivityPresenter createPresenter() {
        return new AnimPrintAActivityPresenter(this);
    }

    @Override
    public void bindData() {
        setTitle("动物A");
        animalApplyBean = (AnimalApplyBean) getIntent().getExtras().getSerializable(Contance.START_ACTIVITY_DATA);
        bean = new Animal_A();
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            list.add(String.valueOf(i));
        }
        spinnerEffectArriveTime.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,list));
        if (animalApplyBean != null) {
            tvGuanfangName.setText(animalApplyBean.getQDWAttn()); //官方兽医姓名
            tvGuanfangPhone.setText(animalApplyBean.getQDWJBRDianHua());//官方兽医电话
            tvUserName.setText(animalApplyBean.getQDWCargoOwner());//货主姓名
            tvUserPhone.setText(animalApplyBean.getQDWPhone());//货主电话
            tvAnimType.setText(animalApplyBean.getFSmemo1());//动物种类
            tvUseage.setText(animalApplyBean.getQDWYongTu()); //用途
            tvNumber.setText(animalApplyBean.getQDWQuantity() + animalApplyBean.getQDWDanWei());//数量以及单位
            tvStartPlace.setText(animalApplyBean.getQDWShengQy() + animalApplyBean.getQDWShiQy()
                    + animalApplyBean.getQDWXianQy());//启运地址
            tvEndPlace.setText(animalApplyBean.getQDWShengDd() + animalApplyBean.getQDWShiDd()
                    + animalApplyBean.getQDWXianDd());//到达地址
            etStartPlaceXiang.setText(animalApplyBean.getQDWXiangQy());//启运点乡镇
            etStartPlaceTuzaichang.setText(animalApplyBean.getQDWCunQy());//起运点村
            etEndPlaceXiang.setText(animalApplyBean.getQDWXiangDd());//到达地乡镇
            etEndPlaceTuzaichang.setText(animalApplyBean.getQDWCunDd());//到达地村
            etCarrierName.setText(animalApplyBean.getQDWChengYunRen());//承运人
            etCarrierPhone.setText(animalApplyBean.getQDWCyrDianHua());//承运人电话
            tvMethod.setText(animalApplyBean.getQDWYunZai());//运输 方式
            etUtilNumber.setText(animalApplyBean.getQDWTrademark());//运输工具号
            etSterilize.setText(animalApplyBean.getQDWDisinfection());//运载前消毒
            etErbiao.setText(animalApplyBean.getQDWErBiaoHao());//耳标号
            // 启运地点类别
            String startPlaceType = animalApplyBean.getQDWTypeQy();
            tvStartPlaceType.setText(startPlaceType);
            if (startPlaceType.equals("养殖场")) {
                tvStartPlaceCountry.setText("养殖场");
            } else if (startPlaceType.equals("交易市场")) {
                tvStartPlaceCountry.setText("交易市场");
            } else if (startPlaceType.equals("散养户")) {
                tvStartPlaceCountry.setText("村");
            } else {
                tvStartPlaceCountry.setText("");
            }
            //到达地点类别
            String endPlaceType = animalApplyBean.getQDWTypeDd();
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
            if ("猪".equals(animalApplyBean.getQDWXuZhongOne()) ||
                    "牛".equals(animalApplyBean.getQDWXuZhongOne()) ||
                    "羊".equals(animalApplyBean.getQDWXuZhongOne())) {
                linErbiao.setVisibility(View.VISIBLE);
            } else {
                linErbiao.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void bindListener() {
        RxView.clicks(btPrint).throttleFirst(1, TimeUnit.SECONDS).subscribe(aVoid -> {
            if (check())getPresenter().upload(getData());
        });
    }

    @Override
    public void setTime(String applyTime, String id) {
        tvQianfaTime.setText(applyTime);
    }

    @Override
    public void uploadComplete() {
        RxBus.getInstance().post(new RefreshBus(RefreshBus.QuarantineAnimFragment));
        //成功上传数据,关闭页面,没有网络无法打印
        openPrintDialog();
    }


    @Override
    public void saveSuccess() {
        showToast("保存至数据库成功");
        finish();
    }


    public void openPrintDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View viewAddEmployee = layoutInflater.inflate(
                R.layout.tishi_activity, null);
        new AlertDialog.Builder(this)
                .setTitle("是否打印")
                .setCancelable(false)
                .setView(viewAddEmployee)
                .setPositiveButton("是", (dialog, which) -> {
                    Intent intent = new Intent(this, PrintAcitivty.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(Contance.START_ACTIVITY_TYPE, Contance.TYPE_PRINT_ANIM_A);
                    bundle.putSerializable(Contance.START_ACTIVITY_DATA, bean);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    RxBus.getInstance().post(new RefreshBus(RefreshBus.NetWorkBadAnimAdd));
                    finish();
                })
                .setNegativeButton("否", (dialog, which) -> {
                    RxBus.getInstance().post(new RefreshBus(RefreshBus.NetWorkBadAnimAdd));
                    finish();
                }).show();
    }

    private boolean check() {
        if (OtherUtil.toString(etNo).length() != 10) {
            Toast.makeText(this, "开证编号长度不足10", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(OtherUtil.toString(etCarrierName))) {
            Toast.makeText(this, "请输入承运人姓名", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(OtherUtil.toString(etCarrierPhone))) {
            Toast.makeText(this, "请输入承运人电话", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(OtherUtil.toString(etUtilNumber))) {
            Toast.makeText(this, "请输入运载工具号", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(OtherUtil.toString(etSterilize))) {
            Toast.makeText(this, "请输入消毒方式", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ((animalApplyBean.getQDWXuZhongOne().contains("猪") ||
                animalApplyBean.getQDWXuZhongOne().contains("牛") ||
                animalApplyBean.getQDWXuZhongOne().contains("羊")) &&
                TextUtils.isEmpty(OtherUtil.toString(etErbiao))){
            Toast.makeText(this, "动物种类猪牛羊,必须填写耳标号", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private Animal_A getData() {
        bean.setId(OtherUtil.toString(etNo));
        bean.setShipper(OtherUtil.toString(tvUserName));
        bean.setShipper_phone(OtherUtil.toString(tvUserPhone));
        bean.setAnimal_species(animalApplyBean.getQDWXuZhong());
        bean.setAnimal_species1(animalApplyBean.getQDWXuZhongOne());
        bean.setAnimal_species2(animalApplyBean.getQDWXuZhongTwo());
        bean.setFSmemo1(animalApplyBean.getFSmemo1());
        bean.setPQuantity(String.valueOf(animalApplyBean.getQDWQuantity()));//数量
        bean.setInput_PDanWei(animalApplyBean.getQDWDanWei());
        bean.setProvince(animalApplyBean.getQDWShengQy());
        bean.setCity(animalApplyBean.getQDWShiQy());
        bean.setCounty(animalApplyBean.getQDWXianQy());
        bean.setTown(animalApplyBean.getQDWXiangQy());
        bean.setVillage(animalApplyBean.getQDWCunQy());
        bean.setInput_market(OtherUtil.toString(tvStartPlaceType));//启运地点类别
        bean.setProvince1(animalApplyBean.getQDWShengDd());
        bean.setCity1(animalApplyBean.getQDWShiDd());
        bean.setCounty1(animalApplyBean.getQDWXianDd());
        bean.setTown1(animalApplyBean.getQDWXiangDd());
        bean.setVillage1(animalApplyBean.getQDWCunDd());
        bean.setInput_market1(OtherUtil.toString(tvEndPlaceType));//到达地点类别
        bean.setUsage(animalApplyBean.getQDWYongTu());
        bean.setCarrier(OtherUtil.toString(etCarrierName));//承运人
        bean.setCarrier_phone(OtherUtil.toString(etCarrierPhone));//承运人电话
        bean.setQDWYunZai(animalApplyBean.getQDWYunZai());
        bean.setVehicle_mark(OtherUtil.toString(etUtilNumber));//运载工具号
        bean.setDisinfect(animalApplyBean.getQDWDisinfection());
        bean.setETA(spinnerEffectArriveTime.getSelectedItem().toString());//有效日
        bean.setDateQF(OtherUtil.toString(tvQianfaTime));
        bean.setBeast_id(animalApplyBean.getQDWErBiaoHao());
        bean.setRemark(OtherUtil.toString(etRemark));
        bean.setSupervise_Telephone(animalApplyBean.getQDWJBRDianHua());//官方兽医电话
        bean.setZt("已打印");
        bean.setGlid(Integer.valueOf(animalApplyBean.getFStId())); // 票证打印
        bean.setAVeterinary(animalApplyBean.getQDWAttn());//官方兽医
        bean.setFSmemo2(getPresenter().getMachineNumber());
        bean.setFSmemo3(getPresenter().getSerialNumber());
        return bean;
    }
}
