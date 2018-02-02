package com.mingnong.xizangphone.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.AnimalApplyBean;
import com.mingnong.xizangphone.dao.Animal_B;
import com.mingnong.xizangphone.bus.RefreshBus;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IAnimPrintBActivity;
import com.mingnong.xizangphone.presenter.AnimPrintBActivityPresenter;
import com.mingnong.xizangphone.runnable.RxBus;
import com.mingnong.xizangphone.utils.OtherUtil;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class AnimPrintBActivity extends MVPActivity<AnimPrintBActivityPresenter> implements IAnimPrintBActivity {

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
    private Animal_B bean;
    private AnimalApplyBean animalApplyBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_print_b);
    }

    @Override
    protected AnimPrintBActivityPresenter createPresenter() {
        return new AnimPrintBActivityPresenter(this);
    }

    @Override
    public void bindData() {
        setTitle("动物B");
        animalApplyBean = (AnimalApplyBean) getIntent().getExtras().getSerializable(Contance.START_ACTIVITY_DATA);
        bean = new Animal_B();
        if (animalApplyBean != null) {
            etNo.setSelection(2);
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
            if (check()) getPresenter().upload(getData());
        });
    }

    @Override
    public void setTime(String applyTime, String id) {
        tvQianfaTime.setText(applyTime);
    }

    @Override
    public void uploadComplete() {
        RxBus.getInstance().post(new RefreshBus(RefreshBus.QuarantineAnimFragment));
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
                    Intent intent = new Intent(this, PrintAcitivty.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(Contance.START_ACTIVITY_TYPE, Contance.TYPE_PRINT_ANIM_B);
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
        if (("猪".equals(animalApplyBean.getQDWXuZhongOne()) ||
                "牛".equals(animalApplyBean.getQDWXuZhongOne()) ||
                "羊".equals(animalApplyBean.getQDWXuZhongOne())) &&
                TextUtils.isEmpty(OtherUtil.toString(etErbiao))) {
            Toast.makeText(this, "动物种类为猪牛羊时,必须填写耳标,耳标号之间用逗号分隔,", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private Animal_B getData() {
        bean.setAQNumber(OtherUtil.toString(etNo));
        bean.setAQCargoOwner(animalApplyBean.getQDWCargoOwner());
        bean.setAQPhone(animalApplyBean.getQDWPhone());
        bean.setAQQuantity(animalApplyBean.getQDWQuantity());
        bean.setAQShiQy(animalApplyBean.getQDWShiQy());
        bean.setAQXianQy(animalApplyBean.getQDWXianQy());
        bean.setAQXiangQy(animalApplyBean.getQDWXiangQy());
        bean.setAQCunQy(animalApplyBean.getQDWCunQy());
        bean.setAQTypeQy(animalApplyBean.getQDWTypeQy());
        bean.setFGlid(Integer.valueOf(animalApplyBean.getFStId())); // 票证打印
        bean.setAQShiDd(animalApplyBean.getQDWShiDd());
        bean.setAQXianDd(animalApplyBean.getQDWXianDd());
        bean.setAQXiangDd(animalApplyBean.getQDWXiangDd());
        bean.setAQCunDd(animalApplyBean.getQDWCunDd());
        bean.setAQTypeDd(animalApplyBean.getQDWTypeDd());
        bean.setAQVeterinary(animalApplyBean.getQDWAttn());
        bean.setAQEarTag(OtherUtil.toString(etErbiao));
        bean.setAQXuZhong(animalApplyBean.getQDWXuZhong());
        bean.setAQXuZhongOne(animalApplyBean.getQDWXuZhongOne());
        bean.setAQXuZhongTwo(animalApplyBean.getQDWXuZhongTwo());
        bean.setFSmemo1(animalApplyBean.getFSmemo1());
        bean.setAQDanWei(animalApplyBean.getQDWDanWei());
        bean.setAQYongTu(animalApplyBean.getQDWYongTu());
        bean.setDateQF(OtherUtil.toString(tvQianfaTime));
        bean.setIsPrant("已打印");
        bean.setFSmemo2(getPresenter().getMachineNumber());
        bean.setFSmemo3(getPresenter().getSerialNumber());
        return bean;
    }
}
