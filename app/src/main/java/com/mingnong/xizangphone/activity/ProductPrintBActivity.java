package com.mingnong.xizangphone.activity;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.ProductApplyBean;
import com.mingnong.xizangphone.dao.Product_B;
import com.mingnong.xizangphone.bus.RefreshBus;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IProductPrintBActivity;
import com.mingnong.xizangphone.presenter.ProductPrintBActivityPresenter;
import com.mingnong.xizangphone.runnable.RxBus;
import com.mingnong.xizangphone.utils.OtherUtil;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * 产品B证打印
 */
public class ProductPrintBActivity extends MVPActivity<ProductPrintBActivityPresenter> implements IProductPrintBActivity {


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
    @BindView(R.id.tv_product_place)
    TextView tvProductPlace;
    @BindView(R.id.tv_end_place)
    TextView tvEndPlace;
    @BindView(R.id.et_flag_jianyi)
    EditText etFlagJianyi;
    @BindView(R.id.tvTransport3)
    TextView tvTransport3;
    @BindView(R.id.tvVehicleNo4)
    TextView tvVehicleNo4;
    @BindView(R.id.tvDeliveryBefore4)
    TextView tvDeliveryBefore4;
    @BindView(R.id.tv_qianfa_time)
    TextView tvQianfaTime;
    @BindView(R.id.tvqzi3)
    TextView tvqzi3;
    @BindView(R.id.et_remark)
    EditText etRemark;
    @BindView(R.id.tvnumber4)
    TextView tvnumber4;
    @BindView(R.id.bt_print)
    Button btPrint;
    private Product_B bean;
    private ProductApplyBean productApplyBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_print_bactivity);
    }

    @Override
    protected ProductPrintBActivityPresenter createPresenter() {
        return new ProductPrintBActivityPresenter(this);
    }

    @Override
    public void bindData() {
        setTitle("产品B");
        bean = new Product_B();
        productApplyBean = (ProductApplyBean) getIntent().getExtras().get(Contance.START_ACTIVITY_DATA);
        if (productApplyBean != null) {
            etNo.setSelection(2);
            tvUserName.setText(productApplyBean.getQCPCargoOwner());//货主
            tvUserPhone.setText(productApplyBean.getQCPPhone());//货主电话
            tvProductType.setText(productApplyBean.getFSmemo1());//产品种类
            tvNumber.setText(productApplyBean.getQCPQuantity()+productApplyBean.getQCPDanWei());//产品数量以及单位
            etProductionUnit.setText(productApplyBean.getQCPsource());//生产单位
            tvStartPlace.setText(productApplyBean.getQCPShiQy()
                    +productApplyBean.getQCPXianQy()+productApplyBean.getQCPDiZhiQy());//地址 市县+详细地址
            tvProductPlace.setText(productApplyBean.getQCPShiQy() + productApplyBean.getQCPXianQy());//市县
            tvEndPlace.setText(productApplyBean.getQCPShengDd()+productApplyBean.getQCPShiDd()
                    +productApplyBean.getQCPXianDd()+productApplyBean.getQCPDiZhiDd());//到达地点
            etRemark.setText(productApplyBean.getRemarks());
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
        RxBus.getInstance().post(new RefreshBus(RefreshBus.QuarantineProductFragment));
        //成功上传数据,显示是否打印的对话框
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
                    Intent intent = new Intent(this,PrintAcitivty.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(Contance.START_ACTIVITY_TYPE, Contance.TYPE_PRINT_PRODUCT_B);
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
        return true;
    }

    private Product_B getData() {
        bean.setId(OtherUtil.toString(etNo));
        try {
            // 票证打印
            this.bean.setGlid(Integer.valueOf(productApplyBean.getFStId()));
        }catch (Exception e) {e.printStackTrace();}
        bean.setShipper(OtherUtil.toString(tvUserName));//货主姓名
        //不需要上传货主电话
//        bean.setShipper_phone(OtherUtil.toString(tvUserPhone));//货主电话
        bean.setProduct_name(productApplyBean.getFSmemo1());//全名 目前没用
        bean.setProduct_name1(productApplyBean.getQCProductOne());//类别一
        bean.setProduct_name2(productApplyBean.getQCProductTwo());//类别二
        bean.setProduct_name3(productApplyBean.getQCProductThree());//类别三
        bean.setFSmemo1(productApplyBean.getFSmemo1());//全名
        bean.setPQuantity(String.valueOf(productApplyBean.getQCPQuantity()));
        bean.setPQuantityDW(String.valueOf(productApplyBean.getQCPDanWei()));
        bean.setCD(productApplyBean.getQCPShiQy()+
                productApplyBean.getQCPXianQy());//产地
        bean.setDZ(productApplyBean.getQCPShiQy()+
                productApplyBean.getQCPXianQy()
                +productApplyBean.getQCPDiZhiQy());//地址
        bean.setMDD(productApplyBean.getQCPShiDd()+
                productApplyBean.getQCPXianDd()
                +productApplyBean.getQCPDiZhiDd());//到达地址
        bean.setJYBZH(OtherUtil.toString(etFlagJianyi));//检疫标志号
        bean.setRemark(OtherUtil.toString(etRemark)); //备注
        bean.setDateQF(OtherUtil.toString(tvQianfaTime));//签发日期
        bean.setTZGFSYQZ(productApplyBean.getQCPAttn());//官方兽医姓名
        bean.setZt("已打印");
        bean.setSCDWMC(OtherUtil.toString(etProductionUnit));//生产单位名称
        bean.setFSmemo2(getPresenter().getMachineNumber());
        bean.setFSmemo3(getPresenter().getSerialNumber());
        return bean;
    }
}
