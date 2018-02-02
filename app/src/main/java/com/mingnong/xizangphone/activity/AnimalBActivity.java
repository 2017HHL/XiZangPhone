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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.SimpleOnItemSelectedListener;
import com.mingnong.xizangphone.bean.AnimBUploadBean;
import com.mingnong.xizangphone.bean.BaseMsgBean;
import com.mingnong.xizangphone.bean.QueryAnimABean;
import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.dao.LocalGreenDao;
import com.mingnong.xizangphone.dao.Unit;
import com.mingnong.xizangphone.dialog.ErBiaoDialog;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IAnimalBActivity;
import com.mingnong.xizangphone.interfac.ITime;
import com.mingnong.xizangphone.presenter.AnimalBActivityPresenter;
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


/**
 * Created by Administrator on 2017/4/19.
 */
public class AnimalBActivity extends MVPActivity<AnimalBActivityPresenter> implements IAnimalBActivity, ITime {

    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.et_jianyizheng_bianhao)
    EditText etJianyizhengBianhao;
    @BindView(R.id.et_huozhu_name)
    EditText etHuozhuName;
    @BindView(R.id.et_huozhu_phone)
    EditText etHuozhuPhone;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.sp_animal_type)
    Spinner spAnimalType;
    @BindView(R.id.sp_animal_leixing)
    Spinner spAnimalLeixing;
    @BindView(R.id.sp_animal_danwei)
    Spinner spAnimalDanwei;
    @BindView(R.id.et_animal_number)
    EditText etAnimalNumber;
    @BindView(R.id.sp_animal_yongtu)
    Spinner spAnimalYongtu;
    @BindView(R.id.sp_qiyun_shi)
    Spinner spQiyunShi;
    @BindView(R.id.sp_qiyun_xian)
    Spinner spQiyunXian;
    @BindView(R.id.et_start_village)
    EditText etStartVillage;
    @BindView(R.id.et_start_other)
    EditText etStartOther;
    @BindView(R.id.sp_qiyun_type)
    Spinner spQiyunType;
    @BindView(R.id.sp_daoda_shi)
    Spinner spDaodaShi;
    @BindView(R.id.sp_daoda_xian)
    Spinner spDaodaXian;
    @BindView(R.id.et_end_village)
    EditText etEndVillage;
    @BindView(R.id.et_end_other)
    EditText etEndOther;
    @BindView(R.id.sp_daoda_type)
    Spinner spDaodaType;
    @BindView(R.id.tv_erbiao)
    TextView tvErbiao;
    @BindView(R.id.bt_erbiao)
    Button btErbiao;
    @BindView(R.id.et_signature_checked)
    EditText etSignatureChecked;
    @BindView(R.id.tv_prove_time)
    TextView tvProveTime;
    @BindView(R.id.bt_print)
    Button btPrint;
    ErBiaoDialog dialog;
    @BindView(R.id.btn_search)
    Button btnSearch;
    private TimePresenter timePresenter;
    private List<Unit> startCity, startCounty;
    private Unit startProvince;
    private String jianyi;
    //上传的实体类
    private AnimBUploadBean bUploadBean = new AnimBUploadBean();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_b_add);
        ButterKnife.bind(this);
    }

    @Override
    protected AnimalBActivityPresenter createPresenter() {
        return new AnimalBActivityPresenter(this);
    }

    @Override
    public void bindData() {
        setTitle("省内动物检疫(动物B)");
        timePresenter = new TimePresenter(this);
        timePresenter.getTime();
        setPlace();

        //检疫证号
        if (OtherUtil.GET_DONGB != null) {
            etJianyizhengBianhao.setText(OtherUtil.GET_DONGB);
        }
        getPresenter().getJianyiZhenghao();

        //用途
        spAnimalYongtu.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.useage)));

        //动物种类
        spAnimalType.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.anim_name)));

        spAnimalLeixing.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.anim_zhu)));

        //动物单位
        spAnimalDanwei.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.anim_danwei)));

        //起运，到达类别
        spQiyunType.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.start_place_type_list)));

        spDaodaType.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.end_place_type_list)));


    }

    private void setPlace() {
        startProvince = LocalGreenDao.getInstance().queryProvince(3030);
        startCity = LocalGreenDao.getInstance().queryCitys(startProvince.getTId());
        startCounty = LocalGreenDao.getInstance().queryCitysOrCountries(startCity.get(0).getTId());
        //设置启运地省市县
        spQiyunShi.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(startCity)));

        spQiyunXian.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(startCounty)));

        spDaodaShi.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(startCity)));

        spDaodaXian.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(startCounty)));
        spDaodaXian.setSelection(2);
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
            Intent intent = new Intent(AnimalBActivity.this, AnimalBSearchActivity.class);
            startActivityForResult(intent, Contance.ACTIVITY_CODE);
        });

        etJianyizhengBianhao.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                } else {
                    jianyi = etJianyizhengBianhao.getText().toString();
                    OtherUtil.setGetDongb(jianyi);
                }
            }
        });
        //动物种类变化
        spAnimalType.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spAnimalType.getSelectedItem().toString().contains("猪")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_zhu)));
                } else if (spAnimalType.getSelectedItem().toString().contains("牛")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_niu)));
                } else if (spAnimalType.getSelectedItem().toString().contains("羊")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_yang)));
                } else if (spAnimalType.getSelectedItem().toString().contains("鸡")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_ji)));
                } else if (spAnimalType.getSelectedItem().toString().contains("鸭")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_ya)));
                } else if (spAnimalType.getSelectedItem().toString().contains("鹅")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_e)));
                } else if (spAnimalType.getSelectedItem().toString().contains("实验动物")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_shiyan)));
                } else if (spAnimalType.getSelectedItem().toString().contains("观赏动物")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_guanshang)));
                } else if (spAnimalType.getSelectedItem().toString().contains("伴侣动物")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_banlv)));
                } else if (spAnimalType.getSelectedItem().toString().contains("演艺动物")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_yanyi)));
                } else if (spAnimalType.getSelectedItem().toString().contains("野生动物")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_yesheng)));
                } else if (spAnimalType.getSelectedItem().toString().contains("经济动物")) {
                    spAnimalLeixing.setVisibility(View.VISIBLE);
                    spAnimalLeixing.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.anim_jingji)));
                } else {
                    spAnimalLeixing.setVisibility(View.GONE);
                }
            }
        });

        spQiyunShi.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                List<Unit> queryCitys = LocalGreenDao.getInstance().queryCitysOrCountries(startCity.get(position).getTId());
                spQiyunXian.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                        getList(queryCitys)));

            }
        });

        spDaodaShi.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                List<Unit> queryCitys = LocalGreenDao.getInstance().queryCitysOrCountries(startCity.get(position).getTId());
                spDaodaXian.setAdapter(new ArrayAdapter<>(AnimalBActivity.this, R.layout.spinner_simple, R.id.tv,
                        getList(queryCitys)));
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
                if (check()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AnimalBActivity.this);
                    builder.setTitle("注意")
                            .setMessage("请确认检疫证号是否正确:" + etJianyizhengBianhao.getText().toString())
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == Contance.ACTIVITY_CODE) {
                QueryAnimBBean.DataListBean bean = (QueryAnimBBean.DataListBean) data.getSerializableExtra(Contance.ACTIVITY_DATA);
                etJianyizhengBianhao.setText(bean.getAQNUMBER());//检疫证编号
                etHuozhuName.setText(bean.getAQCARGOOWNER());//货主
                etHuozhuPhone.setText(bean.getAQPHONE());//联系电话
                etAnimalNumber.setText(bean.getAQQUANTITY() + "");//数量
                etStartVillage.setText(bean.getAQXIANGQY());//启运乡
                etStartOther.setText(bean.getAQCUNQY());//启运村
                etEndVillage.setText(bean.getAQXIANGDD());//到达乡
                etEndOther.setText(bean.getAQCUNDD());//到达村
                tvErbiao.setText(bean.getAQEARTAG());//耳标号
                etSignatureChecked.setText(bean.getAQVETERINARY());//官方兽医签字
                tvProveTime.setText(bean.getDATEQF());//签发日期
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private AnimBUploadBean getData() {
        bUploadBean = new AnimBUploadBean();
        bUploadBean.setAQNumber(etJianyizhengBianhao.getText().toString());//编号
        bUploadBean.setAQCargoOwner(etHuozhuName.getText().toString());//货主
        bUploadBean.setAQPhone(etHuozhuPhone.getText().toString());//联系电话
        bUploadBean.setAQQuantity(Integer.parseInt(etAnimalNumber.getText().toString()));//数量
        bUploadBean.setAQShiQy(spQiyunShi.getSelectedItem().toString());//市/州
        bUploadBean.setAQXianQy(spQiyunXian.getSelectedItem().toString());//县/市/区
        bUploadBean.setAQXiangQy(etStartVillage.getText().toString());//乡(镇)
        bUploadBean.setAQCunQy(etStartOther.getText().toString());//村
        bUploadBean.setAQTypeQy(spQiyunType.getSelectedItem().toString());//起运地类型
        bUploadBean.setAQShiDd(spDaodaShi.getSelectedItem().toString());//市/州
        bUploadBean.setAQXianDd(spDaodaXian.getSelectedItem().toString());//县/市/区
        bUploadBean.setAQXiangDd(etEndVillage.getText().toString());//乡/镇
        bUploadBean.setAQCunDd(etEndOther.getText().toString());//村
        bUploadBean.setAQTypeDd(spDaodaType.getSelectedItem().toString());//到达地类型
        bUploadBean.setAQVeterinary(etSignatureChecked.getText().toString());//官方兽医签字
        bUploadBean.setAQEarTag(tvErbiao.getText().toString());//牲畜耳标号
        bUploadBean.setAQXuZhong(spAnimalType.getSelectedItem().toString());//动物种类
        bUploadBean.setAQDanWei(spAnimalDanwei.getSelectedItem().toString());//单位
        bUploadBean.setAQYongTu(spAnimalYongtu.getSelectedItem().toString());//用途
        bUploadBean.setDateQF(tvProveTime.getText().toString());//签发日期
        bUploadBean.setAQMemo2(spQiyunShi.getSelectedItem().toString() + spQiyunXian.getSelectedItem().toString()
                + etStartVillage.getText().toString() + etStartOther.getText().toString());//拼接启运地
        bUploadBean.setAQMemo3(spDaodaShi.getSelectedItem().toString() + spDaodaXian.getSelectedItem().toString()
                + etEndVillage.getText().toString() + etEndOther.getText().toString());//拼接到达地
        bUploadBean.setIsPrant("保存");//状态:保存/打印/报废
        bUploadBean.setSaveId(1);//数据的自增Id
        bUploadBean.setUploadType(1);//上传标识符:0未上传,1已上传
        bUploadBean.setUploadTypeSheng(1);//上传标识符:0未上传,1已上传（区分省上传记录）

        bUploadBean.setAQMemo1("");//备注
        bUploadBean.setAQYouXiaoRi(0);//有效日
        String qiyunxian = spQiyunXian.getSelectedItem().toString();
        bUploadBean.setAQDiQuQy(qiyunxian.substring(qiyunxian.length() - 1));//保存启运地-县/市/区
        String daodaxian = spDaodaXian.getSelectedItem().toString();
        bUploadBean.setAQDiQuDd(daodaxian.substring(daodaxian.length() - 1));//保存到达地 县/市/区
        bUploadBean.setAQPlace(spQiyunShi.getSelectedItem().toString() + spQiyunXian.getSelectedItem().toString()
                + etStartVillage.getText().toString() + etStartOther.getText().toString());//保存起运地-养殖场
        bUploadBean.setAQArr(spDaodaShi.getSelectedItem().toString() + spDaodaXian.getSelectedItem().toString()
                + etEndVillage.getText().toString() + etEndOther.getText().toString());//保存到达地-养殖场

        return bUploadBean;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean check() {
        if (TextUtils.isEmpty(etJianyizhengBianhao.getText().toString())) {
            Toast.makeText(this, "检疫证号不能为空", Toast.LENGTH_LONG).show();
            etJianyizhengBianhao.requestFocus();//获取焦点
            focusKeywordView(etJianyizhengBianhao);
            changeTintColor(etJianyizhengBianhao);
            return false;
        }
        changeTintColor(etJianyizhengBianhao);
        if (TextUtils.isEmpty(etHuozhuName.getText().toString())) {
            Toast.makeText(this, "货主不能为空", Toast.LENGTH_LONG).show();
            etHuozhuName.requestFocus();//获取焦点
            focusKeywordView(etHuozhuName);
            changeTintColor(etHuozhuName);
            return false;
        }
        changeTintColor(etHuozhuName);
        if (TextUtils.isEmpty(etHuozhuPhone.getText().toString())) {
            Toast.makeText(this, "联系电话不能为空", Toast.LENGTH_LONG).show();
            etHuozhuPhone.requestFocus();//获取焦点
            focusKeywordView(etHuozhuPhone);
            changeTintColor(etHuozhuPhone);
            return false;
        }
        changeTintColor(etHuozhuPhone);
        if (TextUtils.isEmpty(etAnimalNumber.getText().toString())) {
            Toast.makeText(this, "数量不能为空", Toast.LENGTH_LONG).show();
            etAnimalNumber.requestFocus();//获取焦点
            focusKeywordView(etAnimalNumber);
            changeTintColor(etAnimalNumber);
            return false;
        }
        changeTintColor(etAnimalNumber);
        if (TextUtils.isEmpty(etSignatureChecked.getText().toString())) {
            Toast.makeText(this, "官方兽医签字不能为空", Toast.LENGTH_LONG).show();
            etSignatureChecked.requestFocus();//获取焦点
            focusKeywordView(etSignatureChecked);
            changeTintColor(etSignatureChecked);
            return false;
        }
        changeTintColor(etSignatureChecked);

        if (TextUtils.isEmpty(etStartVillage.getText().toString())) {
            Toast.makeText(this, "起运地乡镇不能为空", Toast.LENGTH_LONG).show();
            etStartVillage.requestFocus();//获取焦点
            focusKeywordView(etStartVillage);
            changeTintColor(etStartVillage);
            return false;
        }
        changeTintColor(etStartVillage);

        if (TextUtils.isEmpty(etStartOther.getText().toString())) {
            Toast.makeText(this, "起运地村不能为空", Toast.LENGTH_LONG).show();
            etStartOther.requestFocus();//获取焦点
            focusKeywordView(etStartOther);
            changeTintColor(etStartOther);
            return false;
        }
        changeTintColor(etStartOther);

        if (TextUtils.isEmpty(etEndVillage.getText().toString())) {
            Toast.makeText(this, "到达地乡镇不能为空", Toast.LENGTH_LONG).show();
            etEndVillage.requestFocus();//获取焦点
            focusKeywordView(etEndVillage);
            changeTintColor(etEndVillage);
            return false;
        }
        changeTintColor(etEndVillage);

        if (TextUtils.isEmpty(etEndOther.getText().toString())) {
            Toast.makeText(this, "到达地村不能为空", Toast.LENGTH_LONG).show();
            etEndOther.requestFocus();//获取焦点
            focusKeywordView(etEndOther);
            changeTintColor(etEndOther);
            return false;
        }
        changeTintColor(etEndOther);

        return true;
    }

    @Override
    public void setTime(String time, long longTime) {
//        String riqi = time.substring(0, 11);
//        String hour = time.substring(11, 13);
//        tvProveTime.setText(riqi + " " + hour + "时");
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
//        Toast.makeText(MyApplication.getContext(), "上传完成", Toast.LENGTH_SHORT).show();
//        finish();
        //成功上传数据,显示是否打印的对话框
        openPrintDialog();
    }

    @Override
    public void zhenghao(BaseMsgBean.Data dataListBean) {
        if (OtherUtil.getGetDongb() == null) {
            jianyi = dataListBean.getResult();
            etJianyizhengBianhao.setText(jianyi);//检疫证号
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
                    bundle.putString(Contance.START_ACTIVITY_TYPE, Contance.TYPE_PRINT_ANIM_B);
                    bundle.putSerializable(Contance.START_ACTIVITY_DATA, bUploadBean);
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
