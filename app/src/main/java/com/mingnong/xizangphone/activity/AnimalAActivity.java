package com.mingnong.xizangphone.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.SimpleOnItemSelectedListener;
import com.mingnong.xizangphone.bean.AnimAUploadBean;
import com.mingnong.xizangphone.bean.BaseMsgBean;
import com.mingnong.xizangphone.bean.QueryAnimABean;
import com.mingnong.xizangphone.dao.LocalGreenDao;
import com.mingnong.xizangphone.dao.Unit;
import com.mingnong.xizangphone.dialog.ErBiaoDialog;
import com.mingnong.xizangphone.dialog.ListViewDialog;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IAnimalAActivity;
import com.mingnong.xizangphone.interfac.ITime;
import com.mingnong.xizangphone.presenter.AnimalAActivityPresenter;
import com.mingnong.xizangphone.presenter.TimePresenter;
import com.mingnong.xizangphone.utils.OtherUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.text.TextUtils.isEmpty;
import static com.mingnong.xizangphone.R.id.et_animal_number;


/**
 * 动物A上传
 * Created by Administrator on 2017/4/19.
 */
public class AnimalAActivity extends MVPActivity<AnimalAActivityPresenter> implements IAnimalAActivity, ITime {

    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.et_jianyi_zhenghao)
    EditText etJianyiZhenghao;
    @BindView(R.id.et_huozhu)
    EditText etHuozhu;
    @BindView(R.id.et_huozhu_lianxiphone)
    EditText etHuozhuLianxiphone;
    @BindView(R.id.animal_name)
    Spinner animalName;
    @BindView(R.id.animal_type)
    Spinner animalType;
    @BindView(R.id.animal_danwei)
    Spinner animalDanwei;
    @BindView(R.id.animal_yongtu)
    Spinner animalYongtu;
    @BindView(et_animal_number)
    EditText etAnimalNumber;
    @BindView(R.id.qiyun_type)
    Spinner qiyunType;
    @BindView(R.id.qiyun_sheng)
    Spinner qiyunSheng;
    @BindView(R.id.qiyun_shi)
    Spinner qiyunShi;
    @BindView(R.id.qiyun_xian)
    Spinner qiyunXian;
    @BindView(R.id.et_qiyun_xiang)
    EditText etQiyunXiang;
    @BindView(R.id.et_qiyun_other)
    EditText etQiyunOther;
    @BindView(R.id.daoda_type)
    Spinner daodaType;
    @BindView(R.id.daoda_sheng)
    Spinner daodaSheng;
    @BindView(R.id.daoda_shi)
    Spinner daodaShi;
    @BindView(R.id.daoda_xian)
    Spinner daodaXian;
    @BindView(R.id.et_daoda_xiang)
    EditText etDaodaXiang;
    @BindView(R.id.et_daoda_other)
    EditText etDaodaOther;
    @BindView(R.id.et_chengyunren)
    EditText etChengyunren;
    @BindView(R.id.et_chengyunren_lianxiphone)
    EditText etChengyunrenLianxiphone;
    @BindView(R.id.rb_railway)
    RadioButton rbRailway;
    @BindView(R.id.rb_highway)
    RadioButton rbHighway;
    @BindView(R.id.rb_waveway)
    RadioButton rbWaveway;
    @BindView(R.id.rb_aviation)
    RadioButton rbAviation;
    @BindView(R.id.et_yunzai_paihao)
    EditText etYunzaiPaihao;
    @BindView(R.id.et_steriallier_method)
    EditText etSteriallierMethod;
    @BindView(R.id.tv_erbiao)
    TextView tvErbiao;
    @BindView(R.id.bt_erbiao)
    Button btErbiao;
    @BindView(R.id.et_beizhu)
    EditText etBeizhu;
    @BindView(R.id.et_signature_qianzi)
    EditText etSignatureQianzi;
    @BindView(R.id.et_jiandusuo_phone)
    EditText etJiandusuoPhone;
    @BindView(R.id.tv_prove_time)
    TextView tvProveTime;
    @BindView(R.id.bt_print)
    Button btPrint;
    ErBiaoDialog dialog;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.sp_youxiangday)
    Spinner spYouxiangday;
    private TimePresenter timePresenter;
    private int tid;
    private List<Unit> startCity, startCounty, endProvince, endCity, endCounty;
    private Unit startProvince;
    //上传的实体类
    private AnimAUploadBean bean;
    //= new AnimAUploadBean();
    private String jianyi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_a_add);
        ButterKnife.bind(this);
    }

    @Override
    protected AnimalAActivityPresenter createPresenter() {
        return new AnimalAActivityPresenter(this);
    }

    @Override
    public void bindData() {
        setTitle("省外动物检疫(动物A)");
        timePresenter = new TimePresenter(this);
        timePresenter.getTime();
        setPlace();

        //检疫证号
        if (OtherUtil.GET_DONGA != null) {
            etJianyiZhenghao.setText(OtherUtil.GET_DONGA);
        }
        getPresenter().getJianyiZhenghao();

        //用途
        animalYongtu.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.useage)));

        //动物种类
        animalName.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.anim_name)));

        animalType.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.anim_zhu)));

        animalType.setSelection(3, true);

        //到达日
        spYouxiangday.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                OtherUtil.createWeeks()));

        //动物单位
        animalDanwei.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.anim_danwei)));

        //起运，到达类别
        qiyunType.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.start_place_type_list)));

        daodaType.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.end_place_type_list)));

    }

    /**
     * 设置地点
     */
    private void setPlace() {
        startProvince = LocalGreenDao.getInstance().queryProvince(3030);
        endProvince = LocalGreenDao.getInstance().queryProvinces();

        startCity = LocalGreenDao.getInstance().queryCitys(startProvince.getTId());
        endCity = LocalGreenDao.getInstance().queryCitys(startProvince.getTId());

        startCounty = LocalGreenDao.getInstance().queryCitysOrCountries(startCity.get(0).getTId());
        endCounty = LocalGreenDao.getInstance().queryCitysOrCountries(endCity.get(0).getTId());
        //设置启运地省市县
        qiyunSheng.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                new String[]{startProvince.getUName()}));

        qiyunShi.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(startCity)));

        qiyunXian.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(startCounty)));

        daodaSheng.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(endProvince)));

        daodaShi.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(endCity)));

        daodaXian.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(endCounty)));
        daodaXian.setSelection(2);
    }

    private List<String> getList(List<Unit> list) {

        List<String> list4 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUName() != null) {
                list4.add(list.get(i).getUName());
            }
        }
        return list4;
    }

    @Override
    public void bindListener() {
        btnSearch.setOnClickListener(v -> {
            Intent intent = new Intent(AnimalAActivity.this, AnimalASearchActivity.class);
            startActivityForResult(intent, Contance.ACTIVITY_CODE);
        });

        etJianyiZhenghao.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                } else {
                    jianyi = etJianyiZhenghao.getText().toString();
                    OtherUtil.setGetDonga(jianyi);
                }
            }
        });
        //动物种类变化
        animalName.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (animalName.getSelectedItem().toString().contains("猪")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_zhu)));
                } else if (animalName.getSelectedItem().toString().contains("牛")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_niu)));
                } else if (animalName.getSelectedItem().toString().contains("羊")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_yang)));
                } else if (animalName.getSelectedItem().toString().contains("鸡")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_ji)));
                } else if (animalName.getSelectedItem().toString().contains("鸭")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_ya)));
                } else if (animalName.getSelectedItem().toString().contains("鹅")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_e)));
                } else if (animalName.getSelectedItem().toString().contains("实验动物")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_shiyan)));
                } else if (animalName.getSelectedItem().toString().contains("观赏动物")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_guanshang)));
                } else if (animalName.getSelectedItem().toString().contains("伴侣动物")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_banlv)));
                } else if (animalName.getSelectedItem().toString().contains("演艺动物")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_yanyi)));
                } else if (animalName.getSelectedItem().toString().contains("野生动物")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_yesheng)));
                } else if (animalName.getSelectedItem().toString().contains("经济动物")) {
                    animalType.setVisibility(View.VISIBLE);
                    animalType.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_jingji)));
                } else {
                    animalType.setVisibility(View.GONE);
                }
            }
        });

        qiyunShi.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                List<Unit> queryCitys = LocalGreenDao.getInstance().queryCitysOrCountries(startCity.get(position).getTId());
                qiyunXian.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                        getList(queryCitys)));

            }
        });

        daodaSheng.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //转化为成员变量，是因为要更新城市列表
                tid = Integer.parseInt(endProvince.get(position).getTId());
                List<Unit> units = LocalGreenDao.getInstance().queryCitys(tid);
                daodaShi.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                        getList(units)));
            }
        });

        daodaShi.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                List<Unit> queryCitt = LocalGreenDao.getInstance().queryCitysOrCountries(LocalGreenDao.getInstance().queryCitys(tid).get(position).getTId());
                daodaXian.setAdapter(new ArrayAdapter<>(AnimalAActivity.this, R.layout.spinner_simple, R.id.tv,
                        getList(queryCitt)));
            }
        });

        //耳标点击
        btErbiao.setOnClickListener(v -> {
            if (isEmpty(etAnimalNumber.getText().toString()) || "0".equals(etAnimalNumber.getText().toString())) {
                showToast("动物数量必填");
            } else {
                new ErBiaoDialog(this, etAnimalNumber.getText().toString(), text -> tvErbiao.setText(text)).show();
            }
        });
        //上传
        btPrint.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AnimalAActivity.this);
                    builder.setTitle("注意")
                            .setMessage("请确认检疫证号是否正确:" + etJianyiZhenghao.getText().toString())
                            .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    getPresenter().upload(getData());
                                }
                            })
                            .setNegativeButton("否", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .show();
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean isChecked() {
        if (TextUtils.isEmpty(etJianyiZhenghao.getText().toString())) {
            Toast.makeText(this, "检疫证号不能为空", Toast.LENGTH_LONG).show();
            etJianyiZhenghao.requestFocus();//获取焦点
            focusKeywordView(etJianyiZhenghao);
            changeTintColor(etJianyiZhenghao);
            return false;
        }
        changeTintColor(etJianyiZhenghao);
        if (TextUtils.isEmpty(etHuozhu.getText().toString())) {
            Toast.makeText(this, "货主不能为空", Toast.LENGTH_LONG).show();
            etHuozhu.requestFocus();//获取焦点
            focusKeywordView(etHuozhu);
            changeTintColor(etHuozhu);

            return false;
        }
        changeTintColor(etHuozhu);
        if (TextUtils.isEmpty(etHuozhuLianxiphone.getText().toString())) {
            Toast.makeText(this, "联系电话不能为空", Toast.LENGTH_LONG).show();
            etHuozhuLianxiphone.requestFocus();//获取焦点
            focusKeywordView(etHuozhuLianxiphone);
            changeTintColor(etHuozhuLianxiphone);
            return false;
        }
        changeTintColor(etHuozhuLianxiphone);
        if (TextUtils.isEmpty(etAnimalNumber.getText().toString())) {
            Toast.makeText(this, "数量不能为空", Toast.LENGTH_LONG).show();
            etAnimalNumber.requestFocus();//获取焦点
            focusKeywordView(etAnimalNumber);
            changeTintColor(etAnimalNumber);
            return false;
        }
        changeTintColor(etAnimalNumber);
        if (TextUtils.isEmpty(etChengyunren.getText().toString())) {
            Toast.makeText(this, "承运人不能为空", Toast.LENGTH_LONG).show();
            etChengyunren.requestFocus();//获取焦点
            focusKeywordView(etChengyunren);
            changeTintColor(etChengyunren);
            return false;
        }
        changeTintColor(etChengyunren);
        if (TextUtils.isEmpty(etChengyunrenLianxiphone.getText().toString())) {
            Toast.makeText(this, "承运人联系电话不能为空", Toast.LENGTH_LONG).show();
            etChengyunrenLianxiphone.requestFocus();//获取焦点
            focusKeywordView(etChengyunrenLianxiphone);
            changeTintColor(etChengyunrenLianxiphone);
            return false;
        }
        changeTintColor(etChengyunrenLianxiphone);

        if (TextUtils.isEmpty(etJiandusuoPhone.getText().toString())) {
            Toast.makeText(this, "动物卫生监督所联系电话不能为空", Toast.LENGTH_LONG).show();
            etJiandusuoPhone.requestFocus();//获取焦点
            focusKeywordView(etJiandusuoPhone);
            changeTintColor(etJiandusuoPhone);
            return false;
        }
        changeTintColor(etJiandusuoPhone);
        if (TextUtils.isEmpty(etSignatureQianzi.getText().toString())) {
            Toast.makeText(this, "官方兽医签字不能为空", Toast.LENGTH_LONG).show();
            etSignatureQianzi.requestFocus();//获取焦点
            focusKeywordView(etSignatureQianzi);
            changeTintColor(etSignatureQianzi);
            return false;
        }
        changeTintColor(etSignatureQianzi);
        if (TextUtils.isEmpty(etYunzaiPaihao.getText().toString())) {
            Toast.makeText(this, "运载工具牌号不能为空", Toast.LENGTH_LONG).show();
            etYunzaiPaihao.requestFocus();//获取焦点
            focusKeywordView(etYunzaiPaihao);
            changeTintColor(etYunzaiPaihao);
            return false;
        }
        changeTintColor(etYunzaiPaihao);
        if (TextUtils.isEmpty(etSteriallierMethod.getText().toString())) {
            Toast.makeText(this, "消毒方式不能为空", Toast.LENGTH_LONG).show();
            etSteriallierMethod.requestFocus();//获取焦点
            focusKeywordView(etSteriallierMethod);
            changeTintColor(etSteriallierMethod);
            return false;
        }
        changeTintColor(etSteriallierMethod);
        if (TextUtils.isEmpty(etQiyunXiang.getText().toString())) {
            Toast.makeText(this, "起运地乡镇不能为空", Toast.LENGTH_LONG).show();
            etQiyunXiang.requestFocus();//获取焦点
            focusKeywordView(etQiyunXiang);
            changeTintColor(etQiyunXiang);
            return false;
        }
        changeTintColor(etQiyunXiang);
        if (TextUtils.isEmpty(etQiyunOther.getText().toString())) {
            Toast.makeText(this, "起运地村不能为空", Toast.LENGTH_LONG).show();
            etQiyunOther.requestFocus();//获取焦点
            focusKeywordView(etQiyunOther);
            changeTintColor(etQiyunOther);
            return false;
        }
        changeTintColor(etQiyunOther);
        if (TextUtils.isEmpty(etDaodaXiang.getText().toString())) {
            Toast.makeText(this, "到达地乡镇不能为空", Toast.LENGTH_LONG).show();
            etDaodaXiang.requestFocus();//获取焦点
            focusKeywordView(etDaodaXiang);
            changeTintColor(etDaodaXiang);
            return false;
        }
        changeTintColor(etDaodaXiang);
        if (TextUtils.isEmpty(etDaodaOther.getText().toString())) {
            Toast.makeText(this, "到达地村不能为空", Toast.LENGTH_LONG).show();
            etDaodaOther.requestFocus();//获取焦点
            focusKeywordView(etDaodaOther);
            changeTintColor(etDaodaOther);
            return false;
        }
        changeTintColor(etDaodaOther);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == Contance.ACTIVITY_CODE) {
                QueryAnimABean.DataListBean bean = (QueryAnimABean.DataListBean) data.getSerializableExtra(Contance.ACTIVITY_DATA);
                etJianyiZhenghao.setText(bean.getANUMBER());//检疫证号
                etHuozhu.setText(bean.getACARGOOWNER());//货主
                etHuozhuLianxiphone.setText(bean.getAPHONE());//联系电话
                etAnimalNumber.setText(bean.getAQUANTITY() + "");//数量
                etQiyunXiang.setText(bean.getAXIANGQY());//启运乡
                etQiyunOther.setText(bean.getACUNQY());//启运村
                etDaodaXiang.setText(bean.getAXIANGDD());//到达乡
                etDaodaOther.setText(bean.getACUNDD());//到达村
                etChengyunren.setText(bean.getACARRIER());//承运人
                etChengyunrenLianxiphone.setText(bean.getAPHONECYR());//承运人联系电话
                etYunzaiPaihao.setText(bean.getATRADEMARK());//运载工具牌号
                etSteriallierMethod.setText(bean.getADISINFECTION());//消毒
                tvErbiao.setText(bean.getAEARTAG());//耳标号
                etBeizhu.setText(bean.getAMEMO1());//备注
                etSignatureQianzi.setText(bean.getAVETERINARY());//官方兽医签字
                etJiandusuoPhone.setText(bean.getADWPHONE());//动物卫生监督所电话
                tvProveTime.setText(bean.getDATEQF());//签发日期
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public AnimAUploadBean getData() {
        //少一个种类类别
        bean = new AnimAUploadBean();
        bean.setANumber(etJianyiZhenghao.getText().toString());//编号
        bean.setACargoOwner(etHuozhu.getText().toString());//货主
        bean.setAPhone(etHuozhuLianxiphone.getText().toString());//联系电话
        bean.setAXuZhong(animalName.getSelectedItem().toString());//动物种类
        //种类分类
        bean.setADanWei(animalDanwei.getSelectedItem().toString());//单位-只/个
        bean.setAYongTu(animalYongtu.getSelectedItem().toString());//用途
        bean.setAQuantity(Integer.parseInt(etAnimalNumber.getText().toString()));//数量
        bean.setATypeQy(qiyunType.getSelectedItem().toString());//起运地类别

        bean.setAShengQy(qiyunSheng.getSelectedItem().toString());//启运省
        bean.setAShiQy(qiyunShi.getSelectedItem().toString());//启运市
        bean.setAXianQy(qiyunXian.getSelectedItem().toString());//启运县

        bean.setAXiangQy(etQiyunXiang.getText().toString());//乡(镇)
        bean.setACunQy(etQiyunOther.getText().toString());//村
        bean.setAPlace(qiyunSheng.getSelectedItem().toString() + qiyunShi.getSelectedItem().toString()
                + qiyunXian.getSelectedItem().toString() + etQiyunXiang.getText().toString() + etQiyunOther.getText().toString());//保存起运地

        bean.setAShengDd(daodaSheng.getSelectedItem().toString());//到达省
        bean.setAShiDd(daodaShi.getSelectedItem().toString());//到达市
        bean.setAXianDd(daodaXian.getSelectedItem().toString());//到达县

        bean.setAXiangDd(etDaodaXiang.getText().toString());//乡(镇)
        bean.setACunDd(etDaodaOther.getText().toString());//村
        String qiyunxian = qiyunXian.getSelectedItem().toString();
        bean.setADiQuQy(qiyunxian.substring(qiyunxian.length() - 1));//保存启运地--县/市/区
        String daodaxian = daodaXian.getSelectedItem().toString();
        bean.setADiQuDd(daodaxian.substring(daodaxian.length() - 1));//保存到达地--县/市/区
        //保存到达地 某某 养殖场信息等
        bean.setAArr(daodaSheng.getSelectedItem().toString() + daodaShi.getSelectedItem().toString()
                + daodaXian.getSelectedItem().toString() + etDaodaXiang.getText().toString() + etDaodaOther.getText().toString());
        bean.setAMemo2(qiyunSheng.getSelectedItem().toString() + qiyunShi.getSelectedItem().toString()
                + qiyunXian.getSelectedItem().toString() + etQiyunXiang.getText().toString() + etQiyunOther.getText().toString());//启运省市县乡镇村
        bean.setAMemo3(daodaSheng.getSelectedItem().toString() + daodaShi.getSelectedItem().toString()
                + daodaXian.getSelectedItem().toString() + etDaodaXiang.getText().toString() + etDaodaOther.getText().toString());//到达省市县乡镇村

        bean.setATypeDd(daodaType.getSelectedItem().toString());//到达地类别

        bean.setACarrier(etChengyunren.getText().toString());//承运人
        bean.setAPhoneCyr(etChengyunrenLianxiphone.getText().toString());//联系电话

        if (rbRailway.isChecked()) {//运输方式
            bean.setAYunZai("铁路");
        } else if (rbHighway.isChecked()) {
            bean.setAYunZai("公路");
        } else if (rbWaveway.isChecked()) {
            bean.setAYunZai("水路");
        } else if (rbAviation.isChecked()) {
            bean.setAYunZai("航空");
        }

        bean.setATrademark(etYunzaiPaihao.getText().toString());//运载工具牌号
        bean.setADisinfection(etSteriallierMethod.getText().toString());//装运前消毒情况
//        bean.setAYouXiaoRi(Integer.parseInt(etYouxiaoDaodari.getText().toString()));//有效到达日
        bean.setAYouXiaoRi(Integer.parseInt(spYouxiangday.getSelectedItem().toString()));//有效到达日
        bean.setAEarTag(tvErbiao.getText().toString()); //耳标号
        bean.setAMemo1(etBeizhu.getText().toString());//备注
        bean.setAVeterinary(etSignatureQianzi.getText().toString());//官方兽医签字
        bean.setADwPhone(etJiandusuoPhone.getText().toString());//动物卫生监督所联系电话
        bean.setDateQF(tvProveTime.getText().toString());//签发日期
        bean.setIsPrant("保存");//状态:保存/打印/报废
        bean.setSaveId(1);//数据的自增Id
        bean.setUploadType(1);//上传标识符:0未上传,1已上传
        bean.setUploadTypeSheng(1);//上传标识符:0未上传,1已上传（区分省上传记录）

        return bean;
    }

    @Override
    public void setTime(String time, long longTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int year = date.getYear() + 1900;
        int month = date.getMonth() + 1;
        int day = date.getDate();
        String riqi = time.substring(14, 16);
        String hour = time.substring(11, 13);
        tvProveTime.setText(year + "-" + month + "-" + day + " " + hour + ":" + riqi);//报检时间
    }

    @Override
    public void uploadsuccess() {
        //成功上传数据,显示是否打印的对话框
        openPrintDialog();
    }

    @Override
    public void zhenghao(BaseMsgBean.Data dataListBean) {
        if (OtherUtil.getGetDonga() == null) {
            jianyi = dataListBean.getResult();
            etJianyiZhenghao.setText(jianyi);//检疫证号
        }
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
                    finish();
                })
                .setNegativeButton("否", (dialog, which) -> {
                    finish();
                }).show();
    }

    /**
     *   
     *  * 得到输入框的文字  
     *  * @return  
     *  
     */
    public String getKeywordText(EditText edt) {
        return edt.getText().toString().trim();
    }

    /**
     *   
     *  * 将焦点移到输入框，弹起输入法  
     *  
     */
    public void focusKeywordView(EditText edt) {
        if (edt != null) {
            edt.requestFocus();
            edt.setSelection(getKeywordText(edt).length());
            showInputMethod(edt, true, 500);
        }
    }

    /**
     *   
     *  * 弹起输入法  
     *  * @param edit  
     *  * @param delay  
     *  * @param delayTime  
     *  
     */
    private void showInputMethod(final EditText edit, boolean delay, int delayTime) {
        if (delay) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    InputMethodManager imm = (InputMethodManager) getSystemService(
                            Context.INPUT_METHOD_SERVICE);

                    if (imm != null) {
                        imm.showSoftInput(edit, 0);
                    }
                }
            }, delayTime);
        } else {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(edit, 0);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void changeTintColor(EditText et) {
        if (et.requestFocus() == true) {
            et.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
        } else
            et.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule)));
        if (et.requestFocus() == false) {
            et.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule)));
        }
    }
}
