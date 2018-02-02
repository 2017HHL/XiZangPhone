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
import com.mingnong.xizangphone.dao.AnimalApplyBean;
import com.mingnong.xizangphone.bus.RefreshBus;
import com.mingnong.xizangphone.dialog.PickerDateDialog;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IAnimProcessActivity;
import com.mingnong.xizangphone.presenter.AnimProcessActivityPresenter;
import com.mingnong.xizangphone.runnable.RxBus;
import com.mingnong.xizangphone.utils.OtherUtil;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * 动物AB证处理
 */
public class AnimProcessActivity extends MVPActivity<AnimProcessActivityPresenter>
        implements IAnimProcessActivity {

    @BindView(R.id.tv_no)
    TextView tvNo;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.tv_user_phone)
    TextView tvUserPhone;
    @BindView(R.id.tv_anim_type)
    TextView tvAnimType;
    @BindView(R.id.tv_useage)
    TextView tvUseage;
    @BindView(R.id.tv_source)
    TextView tvSource;
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
    @BindView(R.id.tv_carrier_name)
    TextView tvCarrierName;
    @BindView(R.id.tv_carrier_phone)
    TextView tvCarrierPhone;
    @BindView(R.id.tv_method)
    TextView tvMethod;
    @BindView(R.id.tv_util_number)
    TextView tvUtilNumber;
    @BindView(R.id.tv_sterilize)
    TextView tvSterilize;
    @BindView(R.id.tv_apply_time)
    TextView tvApplyTime;
    @BindView(R.id.tv_erbiao)
    TextView tvErbiao;
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
    @BindView(R.id.lin_carrier_name)
    LinearLayout linCarrierName;
    @BindView(R.id.lin_carrier_phone)
    LinearLayout linCarrierPhone;
    @BindView(R.id.lin_method)
    LinearLayout linMethod;
    @BindView(R.id.lin_util_number)
    LinearLayout linUtilNumber;
    @BindView(R.id.lin_sterilize)
    LinearLayout linSterilize;
    @BindView(R.id.lin_erbiao)
    LinearLayout linErbiao;

    private View view_shouli, view_no_shouli;

    //不受理
    EditText etReason;

    //受理
    EditText etTouShu, etItem1_1, etItem1_2, etItem2_1, etItem2_2, etItem3_1, etItem3_2;
    EditText etJianyiPlace;
    EditText etJianyiTime;
    Button btJianyiTime;
    EditText etProcessTime; //处理时间
    Spinner spinnerJianyiResult;
    LinearLayout linJianCe;//瘦肉精检测模块
    private AnimalApplyBean bean;

    private PickerDateDialog dateDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_process);
    }

    @Override
    protected AnimProcessActivityPresenter createPresenter() {
        return new AnimProcessActivityPresenter(this);
    }

    @Override
    public void bindData() {
        bean = (AnimalApplyBean) getIntent().getExtras().getSerializable(Contance.START_ACTIVITY_DATA);
        if (bean == null) {
            Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            return;
        }
        bindCommon();
        if (isAnimB()) {
            //产品B证
            setTitle("动物B");
            bindDataB();
        } else {
            //产品A证
            setTitle("动物A");
            bindDataA();
        }
    }

    private void bindDataA() {

    }

    private void bindDataB() {
        linCarrierName.setVisibility(View.GONE);
        linCarrierPhone.setVisibility(View.GONE);
        linSterilize.setVisibility(View.GONE);
    }

    /**
     * 是否是产品B证 true 是A证
     *
     * @return
     */
    private boolean isAnimB() {
        if ("省内".equals(bean.getQDWType())) {
            return true;
        }
        return false;
    }

    private void bindCommon() {
        dateDialog = new PickerDateDialog.Builder(this)
                .setOnDateSelectedListener(dates -> {
                    etJianyiTime.setText(dates[0] + "-" + dates[1] + "-" + dates[2]);
                }).create();
        view_shouli = getLayoutInflater().inflate(R.layout.anim_shouli, null);
        etJianyiPlace = (EditText) view_shouli.findViewById(R.id.et_jianyi_place);
        etJianyiTime = (EditText) view_shouli.findViewById(R.id.et_jianyi_time);
        etProcessTime = (EditText) view_shouli.findViewById(R.id.et_process_time);
        btJianyiTime = (Button) view_shouli.findViewById(R.id.bt_jianyi_time);
        spinnerJianyiResult = (Spinner) view_shouli.findViewById(R.id.spinner_jianyi_result);
        etTouShu = (EditText) view_shouli.findViewById(R.id.et_toushu);
        etItem1_1 = (EditText) view_shouli.findViewById(R.id.et_item1_1);
        etItem1_2 = (EditText) view_shouli.findViewById(R.id.et_item1_2);
        etItem2_1 = (EditText) view_shouli.findViewById(R.id.et_item2_1);
        etItem2_2 = (EditText) view_shouli.findViewById(R.id.et_item2_2);
        etItem3_1 = (EditText) view_shouli.findViewById(R.id.et_item3_1);
        etItem3_2 = (EditText) view_shouli.findViewById(R.id.et_item3_2);
        linJianCe = (LinearLayout) view_shouli.findViewById(R.id.lin_jiance);

        view_no_shouli = getLayoutInflater().inflate(R.layout.product_no_shouli, null);
        etReason = (EditText) view_no_shouli.findViewById(R.id.et_reason);

        linGroup.addView(view_shouli);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("合格");
        strings.add("不合格");
        spinnerJianyiResult.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, strings));

        etGuanfangName.setText(getPresenter().getGuanfangName());//设置官方检疫姓名
        etGuanfangPhone.setText(getPresenter().getGuanfangPhone());//设置官方检疫电话
        tvNo.setText(bean.getQDWNumber());//申报单编号
        tvUserName.setText(bean.getQDWCargoOwner());//货主姓名
        tvUserPhone.setText(bean.getQDWPhone());//货主电话
        tvAnimType.setText(bean.getFSmemo1());//动物种类
        tvUseage.setText(bean.getQDWYongTu()); //用途
        tvSource.setText(bean.getQDWLaiYuan()); //来源
        tvNumber.setText(bean.getQDWQuantity() + bean.getQDWDanWei());//数量以及单位
        tvStartPlace.setText(bean.getQDWShengQy() + bean.getQDWShiQy()
                + bean.getQDWXianQy());//启运地址
        tvEndPlace.setText(bean.getQDWShengDd() + bean.getQDWShiDd()
                + bean.getQDWXianDd());//到达地址
        etStartPlaceXiang.setText(bean.getQDWXiangQy());//启运点乡镇
        etStartPlaceTuzaichang.setText(bean.getQDWCunQy());//起运点村
        etEndPlaceXiang.setText(bean.getQDWXiangDd());//到达地乡镇
        etEndPlaceTuzaichang.setText(bean.getQDWCunDd());//到达地村
        tvCarrierName.setText(bean.getQDWChengYunRen());//承运人
        tvCarrierPhone.setText(bean.getQDWCyrDianHua());//承运人电话
        tvMethod.setText(bean.getQDWYunZai());//运输 方式
        tvUtilNumber.setText(bean.getQDWTrademark());//运输工具号
        tvSterilize.setText(bean.getQDWDisinfection());//运载前消毒
        tvErbiao.setText(bean.getQDWErBiaoHao());//耳标号
        tvApplyTime.setText(bean.getDateQF());//申报日期

        if ("生猪".equals(bean.getQDWXuZhongTwo()) ||
                "肉牛".equals(bean.getQDWXuZhongTwo()) ||
                "肉羊".equals(bean.getQDWXuZhongTwo())) {
            linErbiao.setVisibility(View.VISIBLE);
            linJianCe.setVisibility(View.VISIBLE);
        } else {
            linErbiao.setVisibility(View.GONE);
            linJianCe.setVisibility(View.GONE);
        }
        // 启运地点类别
        String startPlaceType = bean.getQDWTypeQy();
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
        //检疫地点
        etJianyiPlace.setText(bean.getQDWXiangQy() + "乡(镇)" + bean.getQDWCunQy());
    }

    private AnimalApplyBean getData() {
        bean.setQDWAttn(OtherUtil.toString(etGuanfangName));//官方兽医
        bean.setQDWJBRDianHua(OtherUtil.toString(etGuanfangPhone));//官方兽医电话
        bean.setQRemarks(OtherUtil.toString(etRemark));//备注
        if (rbAccept.isChecked()) {
            bean.setQDWAccepted("受理");//受理还是不受理
            bean.setQDWAddress(OtherUtil.toString(etJianyiPlace));//受理地点
            bean.setDateNpy(OtherUtil.toString(etJianyiTime));//检疫日期
            bean.setDateJL(OtherUtil.toString(etProcessTime));//处理日期
            bean.setQResults(spinnerJianyiResult.getSelectedItem().toString());//检疫结果
            bean.setIsPrant("已保存");//设置状态
            bean.setQLMSNumber(Integer.valueOf(TextUtils.isEmpty(OtherUtil.toString(etTouShu))?"0"
                    :OtherUtil.toString(etTouShu)));//设置头数
            bean.setQCHYin(Integer.valueOf(TextUtils.isEmpty(OtherUtil.toString(etTouShu))?"0"
                    :OtherUtil.toString(etItem1_1)));//盐酸克伦特罗-阴性数【瘦肉精抽检情况】
            bean.setQCHYang(Integer.valueOf(TextUtils.isEmpty(OtherUtil.toString(etTouShu))?"0"
                    :OtherUtil.toString(etItem1_2)));// 盐酸克伦特罗-阳性数【瘦肉精抽检情况】
            bean.setQPayleanYin(Integer.valueOf(TextUtils.isEmpty(OtherUtil.toString(etTouShu))?"0"
                    :OtherUtil.toString(etItem2_1)));// 莱克多巴胺-阴性数【瘦肉精抽检情况】
            bean.setQPayleanYang(Integer.valueOf(TextUtils.isEmpty(OtherUtil.toString(etTouShu))?"0"
                    :OtherUtil.toString(etItem2_2)));// 莱克多巴胺-阳性数【瘦肉精抽检情况】
            bean.setQsalbutamolYin(Integer.valueOf(TextUtils.isEmpty(OtherUtil.toString(etTouShu))?"0"
                    :OtherUtil.toString(etItem3_1)));// 沙丁胺醇-阴性数【瘦肉精抽检情况】
            bean.setQsalbutamolYang(Integer.valueOf(TextUtils.isEmpty(OtherUtil.toString(etTouShu))?"0"
                    :OtherUtil.toString(etItem3_2)));// 沙丁胺醇-阳性数【瘦肉精抽检情况】
        } else {
            bean.setQDWAccepted("不受理");//受理还是不受理
            bean.setQDWLiYou(OtherUtil.toString(etReason));//不受理理由
            bean.setIsPrant("已保存");//设置状态
        }
        return bean;
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
            Intent intent;
            if (isAnimB()) {
                intent = new Intent(this, AnimPrintBActivity.class);
            } else {
                intent = new Intent(this, AnimPrintAActivity.class);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable(Contance.START_ACTIVITY_DATA, bean);
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (rbAccept.isChecked() && spinnerJianyiResult.getSelectedItemPosition() == 1) {
            //处理产品单保存
            RxBus.getInstance().post(new RefreshBus(RefreshBus.QuarantineAnimFragment));
            Toast.makeText(this, "上传成功,请登录开证平台，开证检疫处理通知单!", Toast.LENGTH_LONG).show();
        } else {
            //不受理保存
            RxBus.getInstance().post(new RefreshBus(RefreshBus.QuarantineAnimFragment));
            Toast.makeText(this, "上传成功", Toast.LENGTH_LONG).show();
        }
        finish();
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
            int total = Integer.valueOf(OtherUtil.toString(etTouShu));
            int item1_1 = Integer.valueOf(OtherUtil.toString(etItem1_1));
            int item1_2 = Integer.valueOf(OtherUtil.toString(etItem1_2));
            int item2_1 = Integer.valueOf(OtherUtil.toString(etItem2_1));
            int item2_2 = Integer.valueOf(OtherUtil.toString(etItem2_2));
            int item3_1 = Integer.valueOf(OtherUtil.toString(etItem3_1));
            int item3_2 = Integer.valueOf(OtherUtil.toString(etItem3_2));
            if (item1_1 + item1_2 > total ||
                    item2_1 + item2_2 > total ||
                    item3_1 + item3_2 > total) {
                Toast.makeText(this, "阴性数 + 阳性数 > 头数", Toast.LENGTH_SHORT).show();
                return false;
            }
            if ((item1_2 > 0 || item2_2 > 0 || item3_2 > 0) && spinnerJianyiResult.getSelectedItemPosition() == 0) {
                Toast.makeText(this, "阳性数量不为0,检疫结果 请选择不合格", Toast.LENGTH_SHORT).show();
                return false;
            }
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
    public void bindListener() {
        etTouShu.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String total = OtherUtil.toString(etTouShu);
                if (TextUtils.isEmpty(total)) {
                    etTouShu.setText("0");
                }
//                if (!TextUtils.isEmpty(total) && !"0".equals(total)) {
//                    etItem1_1.setText(total);
//                    etItem2_1.setText(total);
//                    etItem3_1.setText(total);
//                }
            }
        });
        etItem1_1.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String numberString = OtherUtil.toString(etItem1_1);
                String total = OtherUtil.toString(etTouShu);
                if (TextUtils.isEmpty(numberString)) {
                    etItem1_1.setText("0");
                }
//                if (total.equals("0") ||
//                        TextUtils.isEmpty(total)) {
//                    etTouShu.setText(numberString);
//                    etItem2_1.setText(numberString);
//                    etItem3_1.setText(numberString);
//                }
            }
        });
        etItem2_1.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String numberString = OtherUtil.toString(etItem2_1);
                String total = OtherUtil.toString(etTouShu);
                if (TextUtils.isEmpty(numberString)) {
                    etItem2_1.setText("0");
                }
//                if (total.equals("0") ||
//                        TextUtils.isEmpty(total)) {
//                    etTouShu.setText(numberString);
//                    etItem1_1.setText(numberString);
//                    etItem3_1.setText(numberString);
//                }
            }
        });
        etItem3_1.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                String numberString = OtherUtil.toString(etItem3_1);
                String total = OtherUtil.toString(etTouShu);
                if (TextUtils.isEmpty(numberString)) {
                    etItem3_1.setText("0");
                }
//                if (total.equals("0") ||
//                        TextUtils.isEmpty(total)) {
//                    etTouShu.setText(numberString);
//                    etItem1_1.setText(numberString);
//                    etItem2_1.setText(numberString);
//                }
            }
        });
        etItem1_2.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                //失去焦点
                String numberString = OtherUtil.toString(etItem1_2);
                String total = OtherUtil.toString(etTouShu);
                if (TextUtils.isEmpty(total)) {
                    etTouShu.setText("0");
                }
//                if (TextUtils.isEmpty(numberString)) {
//                    etItem1_1.setText("0");
//                    etItem1_2.setText("0");
//                    return;
//                }
//                if (Integer.valueOf(numberString) <=
//                        Integer.valueOf(total) && Integer.valueOf(total) != 0) {
//                    etItem1_1.setText(String.valueOf(Integer.valueOf(total)
//                            - Integer.valueOf(numberString)));
//                } else {
//                    etItem1_1.setText("0");
//                    etItem1_2.setText(OtherUtil.toString(etTouShu));
//                }
            }
        });
        etItem2_2.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                //失去焦点
                String numberString = OtherUtil.toString(etItem2_2);
                String total = OtherUtil.toString(etTouShu);
                if (TextUtils.isEmpty(total)) {
                    etTouShu.setText("0");
                }
//                if (TextUtils.isEmpty(numberString)) {
//                    etItem2_1.setText("0");
//                    etItem2_2.setText("0");
//                    return;
//                }
//                if (Integer.valueOf(numberString) <=
//                        Integer.valueOf(total) && Integer.valueOf(total) != 0) {
//                    etItem2_1.setText(String.valueOf(Integer.valueOf(total)
//                            - Integer.valueOf(numberString)));
//                } else {
//                    etItem2_1.setText("0");
//                    etItem2_2.setText(OtherUtil.toString(etTouShu));
//                }
            }
        });
        etItem3_2.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                //失去焦点
                String numberString = OtherUtil.toString(etItem3_2);
                String total = OtherUtil.toString(etTouShu);
                if (TextUtils.isEmpty(total)) {
                    etTouShu.setText("0");
                }
//                if (TextUtils.isEmpty(numberString)) {
//                    etItem3_1.setText("0");
//                    etItem3_2.setText("0");
//                    return;
//                }
//                if (Integer.valueOf(numberString) <=
//                        Integer.valueOf(total) && Integer.valueOf(total) != 0) {
//                    etItem3_1.setText(String.valueOf(Integer.valueOf(total)
//                            - Integer.valueOf(numberString)));
//                } else {
//                    etItem3_1.setText("0");
//                    etItem3_2.setText(OtherUtil.toString(etTouShu));
//                }
            }
        });
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
                            if (isAnimB()) {
                                btSave.setText("动物B证打印");
                            } else {
                                btSave.setText("动物A证打印");
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
                            if (isAnimB()) {
                                btSave.setText("动物B证打印");
                            } else {
                                btSave.setText("动物A证打印");
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
                    if (check()) {
                        //列表会自动刷新
                        getPresenter().upload(getData());
                    }
                });
    }

}
