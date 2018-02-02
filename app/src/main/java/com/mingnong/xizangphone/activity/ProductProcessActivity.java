package com.mingnong.xizangphone.activity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.ProductApplyBean;
import com.mingnong.xizangphone.bus.RefreshBus;
import com.mingnong.xizangphone.dialog.PickerDateDialog;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IProductProcessActivity;
import com.mingnong.xizangphone.presenter.ProductProcessActivityPresenter;
import com.mingnong.xizangphone.runnable.RxBus;
import com.mingnong.xizangphone.utils.OtherUtil;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * 产品A B证处理
 */

public class ProductProcessActivity extends MVPActivity<ProductProcessActivityPresenter> implements IProductProcessActivity {

    @BindView(R.id.tv_no)
    TextView tvNo;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_product_type)
    TextView tvProductType;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.edtProductionUnitName) //?
            TextView edtProductionUnitName;
    @BindView(R.id.spinProductionUnitName)//?
            Button spinProductionUnitName;
    @BindView(R.id.tv_start_place)
    TextView tvStartPlace;
    @BindView(R.id.tv_end_place)
    TextView tvEndPlace;
    @BindView(R.id.et_carrier_name)
    TextView tvCarrierName;
    @BindView(R.id.et_carrier_phone)
    TextView tvCarrierPhone;
    @BindView(R.id.tv_method)
    TextView tvMethod;
    @BindView(R.id.tv_util_number)
    TextView tvUtilNumber;
    @BindView(R.id.tv_sterilize)
    TextView tvSterilize;
    @BindView(R.id.tv_apply_time)
    TextView tvApplyTime;
    @BindView(R.id.rb_accept)
    RadioButton rbAccept;
    @BindView(R.id.rb_no_accept)
    RadioButton rbNoAccept;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.lin_group)
    LinearLayout linGroup;
    @BindView(R.id.et_guanfang_name)
    EditText etGuanfangName;
    @BindView(R.id.et_guanfang_phone)
    EditText etGuanfangPhone;
    @BindView(R.id.et_remark)
    EditText etRemark;
    @BindView(R.id.bt_save)
    Button btSave;

    //不受理
    EditText etReason;

    //受理
    EditText etJianyiPlace;
    EditText etJianyiTime;
    Button btJianyiTime;
    EditText etProcessTime; //处理时间
    Spinner spinnerJianyiResult;

    private ProductApplyBean bean;

    private PickerDateDialog dateDialog;

    private View view_shouli, view_no_shouli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_process);
    }

    @Override
    protected ProductProcessActivityPresenter createPresenter() {
        return new ProductProcessActivityPresenter(this);
    }

    @Override
    public void bindData() {
        bean = (ProductApplyBean) getIntent().getExtras().getSerializable(Contance.START_ACTIVITY_DATA);
        if (bean == null) {
            Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            return;
        }
        bindCommon();
        if (isProductB()) {
            //产品B证
            setTitle("产品B");
            bindDataB();
        } else {
            //产品A证
            setTitle("产品A");
            bindDataA();
        }
    }

    /**
     * 是否是产品B证 true 是A证
     *
     * @return
     */
    private boolean isProductB() {
        if ("省内".equals(bean.getQCPType())) {
            return true;
        }
        return false;
    }

    /**
     * 动物B证数据初始化
     */
    private void bindDataB() {
        btSave.setText("产品B证打印");
    }

    /**
     * 动物A证数据初始化
     */
    private void bindDataA() {
        btSave.setText("产品A证打印");
    }

    /**
     * A证 B证 共同的东西
     */
    private void bindCommon() {
        dateDialog = new PickerDateDialog.Builder(this)
                .setOnDateSelectedListener(dates -> {
                    etJianyiTime.setText(dates[0] + "-" + dates[1] + "-" + dates[2]);
                }).create();
        view_shouli = getLayoutInflater().inflate(R.layout.product_shouli, null);
        etJianyiPlace = (EditText) view_shouli.findViewById(R.id.et_jianyi_place);
        etJianyiTime = (EditText) view_shouli.findViewById(R.id.et_jianyi_time);
        etProcessTime = (EditText) view_shouli.findViewById(R.id.et_process_time);
        btJianyiTime = (Button) view_shouli.findViewById(R.id.bt_jianyi_time);
        spinnerJianyiResult = (Spinner) view_shouli.findViewById(R.id.spinner_jianyi_result);

        view_no_shouli = getLayoutInflater().inflate(R.layout.product_no_shouli, null);
        etReason = (EditText) view_no_shouli.findViewById(R.id.et_reason);

        linGroup.addView(view_shouli);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("合格");
        strings.add("不合格");
        spinnerJianyiResult.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, strings));

        etJianyiPlace.setText(bean.getQCPsource());//设置检疫地点
        etGuanfangName.setText(getPresenter().getGuanfangName());//设置官方检疫姓名
        etGuanfangPhone.setText(getPresenter().getGuanfangPhone());//设置官方检疫电话
        tvNo.setText(bean.getQCPNumber());//申报单编号
        tvName.setText(bean.getQCPCargoOwner());//货主姓名
        tvPhone.setText(bean.getQCPPhone());//货主电话
        tvProductType.setText(bean.getFSmemo1());//产品种类
        tvNumber.setText(bean.getQCPNumber() + bean.getQCPDanWei());//数量以及单位
        tvStartPlace.setText(bean.getQCPShengQy() + bean.getQCPShiQy()
                + bean.getQCPXianQy() + bean.getQCPDiZhiQy());//启运地址
        tvEndPlace.setText(bean.getQCPShengDd() + bean.getQCPShiDd()
                + bean.getQCPXianDd() + bean.getQCPDiZhiDd());//到达地址
        tvCarrierName.setText(bean.getQCPChengYunRen());//承运人
        tvCarrierPhone.setText(bean.getQCPCyrDianHua());//承运人电话
        tvMethod.setText(bean.getQCPYunZai());//运输 方式
        tvUtilNumber.setText(bean.getQCPTrademark());//运输工具号
        tvSterilize.setText(bean.getQCPDisinfection());//运载前消毒
        tvApplyTime.setText(bean.getDateQF());//申报日期
    }

    @Override
    public void bindListener() {
        rg.setOnCheckedChangeListener((group, checkedId) -> {
            if (linGroup.getChildCount() != 0) linGroup.removeAllViews();
            switch (checkedId) {
                case R.id.rb_accept:
                    //受理
                    linGroup.addView(view_shouli);
                    //获取服务器当前时间
                    getPresenter().getTime();
                    switch (spinnerJianyiResult.getSelectedItemPosition()) {
                        case 0:
                            if (isProductB()) {
                                btSave.setText("产品B证打印");
                            } else {
                                btSave.setText("产品A证打印");
                            }
                            break;
                        case 1:
                            btSave.setText("处理通知单保存");
                            break;
                    }

                    break;
                case R.id.rb_no_accept:
                    //不受理
                    linGroup.addView(view_no_shouli);
                    btSave.setText("不受理保存");
                    break;
            }
        });
        spinnerJianyiResult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (rbAccept.isChecked()) {
                        switch (position) {
                            case 0:
                                //合格 一定是受理
                                if (isProductB()) {
                                    btSave.setText("产品B证打印");
                                } else {
                                    btSave.setText("产品A证打印");
                                }
                                break;
                            case 1:
                                btSave.setText("处理通知单保存");
                                break;
                        }
                    } else {
                        btSave.setText("不受理保存");
                    }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        RxView.clicks(btJianyiTime).throttleFirst(1, TimeUnit.SECONDS).subscribe(aVoid -> dateDialog.show());
        RxView.clicks(btSave).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(aVoid -> {
                    if (check()) getPresenter().upload(getData());
                });

    }

    private ProductApplyBean getData() {
        bean.setQCPAttn(OtherUtil.toString(etGuanfangName));//官方兽医
        bean.setQCPJBRDianHua(OtherUtil.toString(etGuanfangPhone));//官方兽医电话
        bean.setRemarks(OtherUtil.toString(etRemark));//备注
        if (rbAccept.isChecked()) {
            bean.setQCPAccepted("受理");//受理还是不受理
            bean.setQCPAddress(OtherUtil.toString(etJianyiPlace));//受理地点
            bean.setDateNpy(OtherUtil.toString(etJianyiTime));//检疫日期
            bean.setDateJL(OtherUtil.toString(etProcessTime));//处理日期
            bean.setQResults(spinnerJianyiResult.getSelectedItem().toString());//检疫结果
            bean.setIsPrant("已保存");//设置状态

        } else {
            bean.setQCPAccepted("不受理");//受理还是不受理
            bean.setQCPLiYou(OtherUtil.toString(etReason));//不受理理由
            bean.setIsPrant("已保存");//设置状态
        }
        return bean;
    }

    private boolean check() {
        if (!OtherUtil.isPhoneNumber(OtherUtil.toString(etGuanfangPhone))) {
            Toast.makeText(this, "动物卫生监督所电话格式不正确", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(OtherUtil.toString(etGuanfangName))) {
            Toast.makeText(this, "请输入官方兽医姓名", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(OtherUtil.toString(etGuanfangPhone))) {
            Toast.makeText(this, "请输入动物卫生监督所电话", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (bean == null) {
            Toast.makeText(this, "该条数据为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (rbAccept.isChecked()) {
            if (TextUtils.isEmpty(OtherUtil.toString(etJianyiPlace))) {
                Toast.makeText(this, "检疫地点不能为空", Toast.LENGTH_SHORT).show();
                return false;
            }
            //时间比较
            if (OtherUtil.compareTime(OtherUtil.toString(etProcessTime), OtherUtil.toString(etJianyiTime))) {
                Toast.makeText(this, "处理时间不能小于检疫时间", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else {
            if (TextUtils.isEmpty(OtherUtil.toString(etReason))) {
                Toast.makeText(this, "请输入不受理理由", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    @Override
    public void setTime(String result, String id) {
        //处理时间
        etProcessTime.setText(result);
        etJianyiTime.setText(result);
    }

    @Override
    public void uploadSuccess() {
        //a证
        if (rbAccept.isChecked() && spinnerJianyiResult.getSelectedItemPosition() == 0) {
            //产品a b证保存
            Intent intent;
            if (isProductB()) {
                intent = new Intent(this,ProductPrintBActivity.class);
            } else {
                intent = new Intent(this,ProductPrintAActivity.class);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable(Contance.START_ACTIVITY_DATA,bean);
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (rbAccept.isChecked() && spinnerJianyiResult.getSelectedItemPosition() == 1) {
            //处理产品单保存
            RxBus.getInstance().post(new RefreshBus(RefreshBus.QuarantineProductFragment));
            Toast.makeText(this, "上传成功,请登录开证平台，开证检疫处理通知单!", Toast.LENGTH_LONG).show();
        } else {
            //不受理保存
            RxBus.getInstance().post(new RefreshBus(RefreshBus.QuarantineProductFragment));
            Toast.makeText(this, "上传成功", Toast.LENGTH_LONG).show();
        }
        finish();
    }
}
