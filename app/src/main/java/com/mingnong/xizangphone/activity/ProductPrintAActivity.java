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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.ProductApplyBean;
import com.mingnong.xizangphone.dao.Product_A;
import com.mingnong.xizangphone.bus.RefreshBus;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IProductPrintAActivity;
import com.mingnong.xizangphone.presenter.ProductPrintAActivityPresenter;
import com.mingnong.xizangphone.runnable.RxBus;
import com.mingnong.xizangphone.utils.OtherUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

import static com.mingnong.xizangphone.R.id.spinner_effect_arrive_time;

/**
 * 产品A证打印详情
 */
public class ProductPrintAActivity extends MVPActivity<ProductPrintAActivityPresenter>
        implements IProductPrintAActivity {

    @BindView(R.id.et_no)
    EditText etNo;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_user_phone)
    TextView tvUserPhone;
    @BindView(R.id.tv_product_type)
    TextView tvProductType;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.et_production_unit)
    EditText etProductionUnit;
    @BindView(R.id.tv_start_place)
    TextView tvStartPlace;
    @BindView(R.id.tv_end_place)
    TextView tvEndPlace;
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
    @BindView(spinner_effect_arrive_time)
    Spinner spinnerEffectArriveTime;
    @BindView(R.id.tv_qianfa_time)
    TextView tvQianfaTime;
    @BindView(R.id.et_jiandu_phone)
    EditText etJianduPhone;
    @BindView(R.id.et_remark)
    EditText etRemark;
    @BindView(R.id.bt_print)
    Button btPrint;

    private Product_A bean;
    private ProductApplyBean productApplyBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_print_a);
    }

    @Override
    protected ProductPrintAActivityPresenter createPresenter() {
        return new ProductPrintAActivityPresenter(this);
    }
    @Override
    public void bindData() {
        setTitle("产品A");
        productApplyBean = (ProductApplyBean) getIntent().getExtras().get(Contance.START_ACTIVITY_DATA);
        this.bean = new Product_A();
        if (productApplyBean != null) {
            List<String> list = new ArrayList<>();
            for (int i = 1; i < 8; i++) {
                list.add(String.valueOf(i));
            }
            etNo.setSelection(2);
            spinnerEffectArriveTime.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,list));
            tvUserName.setText(productApplyBean.getQCPCargoOwner());//货主
            tvUserPhone.setText(productApplyBean.getQCPPhone());//货主电话
            tvProductType.setText(productApplyBean.getFSmemo1());//产品种类
            tvNumber.setText(productApplyBean.getQCPQuantity()+productApplyBean.getQCPDanWei());//产品数量以及单位
            tvStartPlace.setText(productApplyBean.getQCPShengQy()+productApplyBean.getQCPShiQy()
                    +productApplyBean.getQCPXianQy()+productApplyBean.getQCPDiZhiQy());//启运地址
            tvEndPlace.setText(productApplyBean.getQCPShengDd()+productApplyBean.getQCPShiDd()
                    +productApplyBean.getQCPXianDd()+productApplyBean.getQCPDiZhiDd());//到达地点
            etProductionUnit.setText(productApplyBean.getQCPsource());//生产单位名称
            etCarrierName.setText(productApplyBean.getQCPChengYunRen());//承运人
            etCarrierPhone.setText(productApplyBean.getQCPCyrDianHua());//承运人电话
            tvMethod.setText(productApplyBean.getQCPYunZai());//运载方式
            etUtilNumber.setText(productApplyBean.getQCPTrademark());//运载工具号
            etSterilize.setText(productApplyBean.getQCPDisinfection());//装载前经消毒
            etJianduPhone.setText(productApplyBean.getQCPJBRDianHua());//动物卫生监督所电话
            etRemark.setText(productApplyBean.getRemarks());//备注
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
        //年月日 时分秒
        tvQianfaTime.setText(applyTime);
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
                    Intent intent = new Intent(this,PrintAcitivty.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(Contance.START_ACTIVITY_TYPE, Contance.TYPE_PRINT_PRODUCT_A);
                    bundle.putSerializable(Contance.START_ACTIVITY_DATA, bean);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    RxBus.getInstance().post(new RefreshBus(RefreshBus.NetWorkBadProductAdd));
                    finish();
                })
                .setNegativeButton("否", (dialog, which) -> {
                    RxBus.getInstance().post(new RefreshBus(RefreshBus.NetWorkBadProductAdd));
                    finish();
                }).show();
    }

    @Override
    public void uploadComplete() {
        RxBus.getInstance().post(new RefreshBus(RefreshBus.QuarantineProductFragment));

        //成功上传数据,显示是否打印的对话框
        openPrintDialog();
    }

    @Override
    public void saveSuccess() {
        showToast("保存至数据库成功");
        finish();
    }

    private boolean check() {
        if (productApplyBean == null) {
            Toast.makeText(this, "数据错误,请重新打开", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (OtherUtil.toString(etNo).length() != 10) {
            Toast.makeText(this, "开证编号长度不够10", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(OtherUtil.toString(etProductionUnit))) {
            Toast.makeText(this, "请输入生产单位", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(this, "请输入生产工具号", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(OtherUtil.toString(etJianduPhone))) {
            Toast.makeText(this, "请输入卫生监督所电话", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(OtherUtil.toString(etSterilize))) {
            Toast.makeText(this, "请输入消毒方式", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public Product_A getData() {
        bean.setId(OtherUtil.toString(etNo));//编号
        try {
            this.bean.setGlid(Integer.valueOf(productApplyBean.getFStId()));
        }catch (Exception e) {e.printStackTrace();}
        bean.setShipper(OtherUtil.toString(tvUserName));//货主姓名
        bean.setShipper_phone(OtherUtil.toString(tvUserPhone));//货主电话
        bean.setProduct_name(productApplyBean.getFSmemo1());//全名
        bean.setProduct_name1(productApplyBean.getQCProductOne());//类别一
        bean.setProduct_name2(productApplyBean.getQCProductTwo());//类别二
        bean.setProduct_name3(productApplyBean.getQCProductThree());//类别三
        bean.setFSmemo1(productApplyBean.getFSmemo1());//全名
        bean.setPQuantity(String.valueOf(productApplyBean.getQCPQuantity()));
        bean.setInput_PDanWei(productApplyBean.getQCPDanWei());
        bean.setProvince(productApplyBean.getQCPShengQy());
        bean.setCity(productApplyBean.getQCPShiQy());
        bean.setCounty(productApplyBean.getQCPXianQy());
        bean.setTown(productApplyBean.getQCPDiZhiQy());
        bean.setProvince1(productApplyBean.getQCPShengDd());
        bean.setCity1(productApplyBean.getQCPShiDd());
        bean.setCounty1(productApplyBean.getQCPXianDd());
        bean.setTown1(productApplyBean.getQCPDiZhiDd());
        bean.setCarrier(OtherUtil.toString(etCarrierName));//承运人
        bean.setCarrier_phone(OtherUtil.toString(etCarrierPhone));//联系电话
        bean.setQCPYunZai(productApplyBean.getQCPYunZai());
        bean.setVehicle_mark(productApplyBean.getQCPTrademark());
        bean.setDisinfect(productApplyBean.getQCPDisinfection());
        bean.setPUnitName(OtherUtil.toString(etProductionUnit));//生产单位名称
        bean.setETA(spinnerEffectArriveTime.getSelectedItem().toString()); // 有效到达日
        bean.setDateQF(OtherUtil.toString(tvQianfaTime));//签发日期
        bean.setPVeterinary(productApplyBean.getQCPAttn());//官方兽医
        bean.setSupervise_Telephone(OtherUtil.toString(etJianduPhone));//官方兽医电话
        bean.setZt("已打印");
        bean.setFSmemo2(getPresenter().getMachineNumber());
        bean.setFSmemo3(getPresenter().getSerialNumber());
        bean.setRemark(OtherUtil.toString(etRemark));//备注
        return bean;
    }
}
