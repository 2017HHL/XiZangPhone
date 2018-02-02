package com.mingnong.xizangphone.activity;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.ChanDiJianYiBean;
import com.mingnong.xizangphone.bean.DanWeiBean;
import com.mingnong.xizangphone.bean.DongwuBean;
import com.mingnong.xizangphone.bean.ShenShiBean;
import com.mingnong.xizangphone.interfac.IChanDiJianYiActivity;
import com.mingnong.xizangphone.presenter.ChanDiJianYiActivityP;
import com.mingnong.xizangphone.utils.OtherUtil;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChanDiJianYiActivity extends MVPActivity<ChanDiJianYiActivityP> implements IChanDiJianYiActivity, DatePickerDialog.OnDateSetListener {

    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.et_shenbaodan)
    EditText etShenbaodan;
    @BindView(R.id.et_huozhu)
    EditText etHuozhu;
    @BindView(R.id.et_lianxidianhua1)
    EditText etLianxidianhua1;
    @BindView(R.id.sp_dongwu1)
    Spinner spDongwu1;
    @BindView(R.id.sp_dongwu2)
    Spinner spDongwu2;
    @BindView(R.id.sp_dongwu3)
    Spinner spDongwu3;
    @BindView(R.id.et_shuliang)
    EditText etShuliang;
    @BindView(R.id.animal_danwei)
    Spinner animalDanwei;
    @BindView(R.id.sp_yongtu)
    Spinner spYongtu;
    @BindView(R.id.bt_shijian1)
    Button btShijian1;
    @BindView(R.id.bt_shijian2)
    Button btShijian2;
    @BindView(R.id.et_laiyuan)
    EditText etLaiyuan;
    @BindView(R.id.sp_qiyun_didian1)
    Spinner spQiyunDidian1;
    @BindView(R.id.sp_qiyun_didian2)
    Spinner spQiyunDidian2;
    @BindView(R.id.sp_qiyun_didian3)
    Spinner spQiyunDidian3;
    @BindView(R.id.et_qiyun_other1)
    EditText etQiyunOther1;
    @BindView(R.id.daoda_didian1)
    Spinner daodaDidian1;
    @BindView(R.id.daoda_didian2)
    Spinner daodaDidian2;
    @BindView(R.id.daoda_didian3)
    Spinner daodaDidian3;
    @BindView(R.id.et_daoda_other1)
    EditText etDaodaOther1;
    @BindView(R.id.rg_shouli)
    RadioGroup rgShouli;
    @BindView(R.id.rb_weishouli)
    RadioButton rbWeishouli;
    @BindView(R.id.et_shoulididian)
    EditText etShoulididian;
    @BindView(R.id.et_anyou)
    EditText etAnyou;
    @BindView(R.id.bt_shijian3)
    Button btShijian3;
    @BindView(R.id.bt_shijian4)
    Button btShijian4;
    @BindView(R.id.et_jingbanren)
    EditText etJingbanren;
    @BindView(R.id.et_lianxidianhua2)
    EditText etLianxidianhua2;
    @BindView(R.id.et_beizhu)
    EditText etBeizhu;
    @BindView(R.id.bt_shangchuan)
    Button btShangchuan;
    private DatePickerDialog dateDialogStart1, dateDialogStart2, dateDialogStart3, dateDialogStart4;
    private RadioButton checkRadioButton;
    String[] my = new String[]{"动物", "动物产品"};
    private String ashxType = "";
    private String[] list = new String[]{"请选择"};
    private String[] list11 = new String[]{"请选择"};
    private String[] danweilist = new String[]{"请选择"};
    private String[] yongtulist = new String[]{"请选择"};
    private List<DongwuBean.DataListBean> mdataListBean;
    private String[] list2 = new String[]{"请选择"};
    private String shouli = "受理";
    private List<DanWeiBean.DataListBean> Danweilist;
    private List<ShenShiBean.DataListBean> shenshilist;
    private String[] shenshilist2=new String[]{"请选择"};
    private String[] shenshilist3=new String[]{"请选择"};
    private String[] list3= new String[]{"请选择"};
    private String[] list4= new String[]{"请选择"};
    private String[] list5= new String[]{"请选择"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chan_di_jian_yi);
        ButterKnife.bind(this);
    }

    @Override
    protected ChanDiJianYiActivityP createPresenter() {
        return new ChanDiJianYiActivityP(this);
    }

    @Override
    public void bindData() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tvTitle.setText("产地检疫申报单");
//        getPresenter().ChanDiJianYi5();
        getPresenter().ChanDiJianYi("0");
        getPresenter().ChanDiJianYi2("SLDW");
        getPresenter().ChanDiJianYi3("YT");
        getPresenter().ChanDiJianYi4();
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(System.currentTimeMillis());
        spDongwu1.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                my));
        spQiyunDidian3.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.useage)));
        daodaDidian3.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.useage)));
        dateDialogStart1 = new DatePickerDialog(this, this, mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
        dateDialogStart2 = new DatePickerDialog(this, this, mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
        dateDialogStart3 = new DatePickerDialog(this, this, mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
        dateDialogStart4 = new DatePickerDialog(this, this, mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
        rgShouli.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 点击事件获取的选择对象  
                checkRadioButton = (RadioButton) rgShouli.findViewById(checkedId);
                shouli = checkRadioButton.getText().toString();
                System.out.println("+++++++++" + checkRadioButton.getText());
            }
        });
        spQiyunDidian1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int a = 0;
                int b = 0;
                for (int i = 0; i < shenshilist.size(); i++) {
                    if (shenshilist3[position].toString().equals(shenshilist.get(i).getUparent().toString())) {
                        a++;
                    }
                }
                list3 = new String[a];
                list4 = new String[a];
                for (int i = 0; i < shenshilist.size(); i++) {
                    if (shenshilist3[position].toString().equals(shenshilist.get(i).getUparent().toString())) {
                        list3[b] = shenshilist.get(i).getUname();
                        list4[b] = shenshilist.get(i).getTid();
                        b++;
                    }
                }
                init2();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spQiyunDidian2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int a = 0;
                int b = 0;
                for (int i = 0; i < shenshilist.size(); i++) {
                    if (list4[position].toString().equals(shenshilist.get(i).getUparent().toString())) {
                        a++;
                    }
                }
                list5 = new String[a];
                for (int i = 0; i < shenshilist.size(); i++) {
                    if (list4[position].toString().equals(shenshilist.get(i).getUparent().toString())) {
                        list5[b] = shenshilist.get(i).getUname();
                        b++;
                    }
                }
                init3();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        daodaDidian1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int a = 0;
                int b = 0;
                for (int i = 0; i < shenshilist.size(); i++) {
                    if (shenshilist3[position].toString().equals(shenshilist.get(i).getUparent().toString())) {
                        a++;
                    }
                }
                list3 = new String[a];
                list4 = new String[a];
                for (int i = 0; i < shenshilist.size(); i++) {
                    if (shenshilist3[position].toString().equals(shenshilist.get(i).getUparent().toString())) {
                        list3[b] = shenshilist.get(i).getUname();
                        list4[b] = shenshilist.get(i).getTid();
                        b++;
                    }
                }
                init22();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        daodaDidian2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int a = 0;
                int b = 0;
                for (int i = 0; i < shenshilist.size(); i++) {
                    if (list4[position].toString().equals(shenshilist.get(i).getUparent().toString())) {
                        a++;
                    }
                }
                list5 = new String[a];
                for (int i = 0; i < shenshilist.size(); i++) {
                    if (list4[position].toString().equals(shenshilist.get(i).getUparent().toString())) {
                        list5[b] = shenshilist.get(i).getUname();
                        b++;
                    }
                }
                init33();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spDongwu1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    getPresenter().ChanDiJianYi("1");
                } else {
                    getPresenter().ChanDiJianYi("0");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spDongwu2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int a = 0;
                int b = 0;
                for (int i = 0; i < mdataListBean.size(); i++) {
                    if (mdataListBean.get(position).getTId().toString().equals(mdataListBean.get(i).getCParent().toString())) {
                        a++;
                    }
                }
                list2 = new String[a];
                for (int i = 0; i < mdataListBean.size(); i++) {
                    if (mdataListBean.get(position).getTId().toString().equals(mdataListBean.get(i).getCParent().toString())) {
                        list2[b] = mdataListBean.get(i).getCName();
                        b++;
                    }
                }
                init();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void init2() {
        if (list3.length == 0) {
            list3 = new String[]{"无"};
            spQiyunDidian2.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                    list3));
        } else {
            spQiyunDidian2.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                    list3));
        }
    }
    public void init22() {
        if (list3.length == 0) {
            list3 = new String[]{"无"};
            daodaDidian2.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                    list3));
        } else {
            daodaDidian2.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                    list3));
        }
    }
    public void init() {
        if (list2.length == 0) {
            list2 = new String[]{"无"};
            spDongwu3.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                    list2));
        } else {
            spDongwu3.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                    list2));
        }
    }
    public void init3() {
        if (list5.length == 0) {
            list5 = new String[]{"无"};
            spQiyunDidian3.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                    list5));
        } else {
            spQiyunDidian3.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                    list5));
        }
    }
    public void init33() {
        if (list5.length == 0) {
            list5 = new String[]{"无"};
            daodaDidian3.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                    list5));
        } else {
            daodaDidian3.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                    list5));
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public boolean Check() {
        if (etShenbaodan.getText().length() == 0) {
            Toast.makeText(ChanDiJianYiActivity.this, "请输入申报单号.....", Toast.LENGTH_SHORT).show();
            etShenbaodan.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            etShenbaodan.requestFocus();
            return false;
        }
        if (etHuozhu.getText().length() == 0) {
            Toast.makeText(ChanDiJianYiActivity.this, "请输入货主名称.....", Toast.LENGTH_SHORT).show();
            etHuozhu.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            etHuozhu.requestFocus();
            return false;
        }
        if (spDongwu3.getSelectedItem().toString().equals("")) {
            Toast.makeText(ChanDiJianYiActivity.this, "请输入申报单号.....", Toast.LENGTH_SHORT).show();
            spDongwu3.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            spDongwu3.requestFocus();
            return false;
        }
        if (etShuliang.getText().toString().equals("")) {
            Toast.makeText(ChanDiJianYiActivity.this, "请输入数量....", Toast.LENGTH_SHORT).show();
            etShuliang.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            etShuliang.requestFocus();
            return false;
        }
        if (animalDanwei.getSelectedItem().toString().contains("请选择")) {
            Toast.makeText(ChanDiJianYiActivity.this, "请输入单位.....", Toast.LENGTH_SHORT).show();
            animalDanwei.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            animalDanwei.requestFocus();
            return false;
        }
        if (spYongtu.getSelectedItem().toString().contains("请选择")) {
            Toast.makeText(ChanDiJianYiActivity.this, "请输入用途.....", Toast.LENGTH_SHORT).show();
            spYongtu.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            spYongtu.requestFocus();
            return false;
        }
        if (getString(btShijian1).equals("请选择时间")) {
            Toast.makeText(ChanDiJianYiActivity.this, "请选择申报时间.....", Toast.LENGTH_SHORT).show();
            btShijian1.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            btShijian1.requestFocus();
            return false;
        }
        if (getString(btShijian2).equals("请选择时间")) {
            Toast.makeText(ChanDiJianYiActivity.this, "请选择起运时间.....", Toast.LENGTH_SHORT).show();
            btShijian2.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            btShijian2.requestFocus();
            return false;
        }
        if (getString(btShijian3).equals("请选择时间")) {
            Toast.makeText(ChanDiJianYiActivity.this, "请选择检疫时间.....", Toast.LENGTH_SHORT).show();
            btShijian3.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            btShijian3.requestFocus();
            return false;
        }
        if (getString(btShijian4).equals("请选择时间")) {
            Toast.makeText(ChanDiJianYiActivity.this, "请选择记录时间.....", Toast.LENGTH_SHORT).show();
            btShijian4.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            btShijian4.requestFocus();
            return false;
        }
        if (getString(etQiyunOther1).isEmpty()) {
            Toast.makeText(ChanDiJianYiActivity.this, "请输入乡(镇).....", Toast.LENGTH_SHORT).show();
            Toast.makeText(ChanDiJianYiActivity.this, "请输入申报单号.....", Toast.LENGTH_SHORT).show();
            etQiyunOther1.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            etQiyunOther1.requestFocus();
            return false;
        }
        if (getString(etDaodaOther1).isEmpty()) {
            Toast.makeText(ChanDiJianYiActivity.this, "请输入乡(镇).....", Toast.LENGTH_SHORT).show();
            etDaodaOther1.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            etDaodaOther1.requestFocus();
            return false;
        }
        if (getString(etJingbanren).isEmpty()) {
            Toast.makeText(ChanDiJianYiActivity.this, "请输入经办人.....", Toast.LENGTH_SHORT).show();
            etJingbanren.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getBaseContext(), R.color.bule1)));
            etJingbanren.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void bindListener() {

    }

    @Override
    public void uploadsuccess() {

    }

    @Override
    public void setData1(List<DongwuBean.DataListBean> dataListBean) {
        mdataListBean = dataListBean;
        list = new String[dataListBean.size()];
        int a=0;
        int b=0;
        for (int i=0;i<mdataListBean.size();i++){
        if (mdataListBean.get(i).getCParent().equals("1000")){
            a++;
        }}
        String[] list111= new String[a];
        for (int i=0;i<mdataListBean.size();i++){
            if (mdataListBean.get(i).getCParent().equals("1000")){
                list111[b]=mdataListBean.get(i).getCName();
                b++;
            }}
        spDongwu2.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                list111));
    }

    @Override
    public void setData2(List<DanWeiBean.DataListBean> danweidataListBean) {
        danweilist = new String[danweidataListBean.size()];
        for (int i = 0; i < danweidataListBean.size(); i++) {
            danweilist[i] = danweidataListBean.get(i).getCName();
        }
        animalDanwei.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                danweilist));
    }

    @Override
    public void setData3(List<DanWeiBean.DataListBean> yongtudataListBean) {
        yongtulist = new String[yongtudataListBean.size()];
        for (int i = 0; i < yongtudataListBean.size(); i++) {
            yongtulist[i] = yongtudataListBean.get(i).getCName();
        }
        spYongtu.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                yongtulist));
    }

    @Override
    public void setData4(List<ShenShiBean.DataListBean> shendataListBean) {
//        List<ShenShiXianBean>list=LocalGreenDao.getInstance().queryShenShiXian();
//        System.out.println("++++++++++"+list.get(0).getUname());
        shenshilist=shendataListBean;
        shenshilist2 = new String[32];
        shenshilist3 = new String[32];
        int b=0;
        for (int i = 0; i < shendataListBean.size(); i++) {
            if (shenshilist.get(0).getTid().equals(shenshilist.get(i).getUparent())){
                shenshilist2[b] = shendataListBean.get(i).getUname();
                shenshilist3[b] = shendataListBean.get(i).getTid();
                b++;
            }
        }
        spQiyunDidian1.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                shenshilist2));
        daodaDidian1.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                shenshilist2));


//        LocalGreenDao localGreenDao=new LocalGreenDao(getApplicationContext());
//        localGreenDao.saveShen(dataListBean);
//        List<CodeXD>list = LocalGreenDao.getInstance().querySterilizeWay();
//        List<ShenShiXianBean>bean=localGreenDao.getInstance().queryShenShiXian();
//        System.out.println("////"+new Gson().toJson(bean)+"****"+new Gson().toJson(list));
    }


    @OnClick({R.id.bt_shijian1, R.id.bt_shijian2, R.id.bt_shijian3, R.id.bt_shijian4, R.id.bt_shangchuan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_shijian1:
                dateDialogStart1.show();
                break;
            case R.id.bt_shijian2:
                dateDialogStart2.show();
                break;
            case R.id.bt_shijian3:
                dateDialogStart3.show();
                break;
            case R.id.bt_shijian4:
                dateDialogStart4.show();
                break;
            case R.id.bt_shangchuan:
                if (Check()) {
                    getPresenter().myupload(getData());
                    Intent intent=new Intent(ChanDiJianYiActivity.this,MainActivity.class);
                    startActivity(intent);
                }

                break;
        }
    }

    private ChanDiJianYiBean getData() {
        ChanDiJianYiBean bean = new ChanDiJianYiBean();
        bean.setMemo1(spDongwu1.getSelectedItem().toString());
        bean.setQNumber(OtherUtil.toString(etShenbaodan));
        bean.setQCargoOwner(OtherUtil.toString(etHuozhu));
        bean.setQPhone(OtherUtil.toString(etLianxidianhua1));
        bean.setQQuantity(OtherUtil.toString(etShuliang));
        bean.setQSource(OtherUtil.toString(etLaiyuan));
        bean.setQPlace(spQiyunDidian1.getSelectedItem().toString());//起运地点
        bean.setQArr(daodaDidian1.getSelectedItem().toString());//到达地点
        bean.setQAccepted(shouli);
        bean.setCidShouLi(1);//是否受理code表编号
//
        bean.setQAddress(OtherUtil.toString(etShoulididian));
        bean.setQLiYou(OtherUtil.toString(etAnyou));
        bean.setQAttn(OtherUtil.toString(etJingbanren));
        bean.setQYongTu(spYongtu.getSelectedItem().toString());//用途
        bean.setQXuZhong(spDongwu3.getSelectedItem().toString());//动物种类(动物产品第三个选项框内值)
        bean.setQDanWei(animalDanwei.getSelectedItem().toString());
        bean.setDateNpy(OtherUtil.toString(btShijian1));//拟派员到达日期
        bean.setDateQy(OtherUtil.toString(btShijian1));
        bean.setDateQF(OtherUtil.toString(btShijian2));
        bean.setDateJL(OtherUtil.toString(btShijian3));


        bean.setTime(OtherUtil.toString(btShijian4));
        bean.setQMemo2(OtherUtil.toString(etLianxidianhua2));
        bean.setIsPrant("保存");
        bean.setUploadType(1);
        bean.setSaveId(1);
        bean.setUploadTypeSheng(1);
        bean.setPSheng(spQiyunDidian1.getSelectedItem().toString());
        bean.setPShi(spQiyunDidian2.getSelectedItem().toString());
        bean.setPXian(spQiyunDidian3.getSelectedItem().toString());
        bean.setPMemo3(OtherUtil.toString(etQiyunOther1));//详细（起运）保存县级别称

        bean.setPDiDian("县/市/区（起运）(目前不用填写)");
        bean.setPSheng1(daodaDidian1.getSelectedItem().toString());
        bean.setPShi1(daodaDidian2.getSelectedItem().toString());
        bean.setPXian1(daodaDidian3.getSelectedItem().toString());
        bean.setPMemo4(OtherUtil.toString(etDaodaOther1));
        bean.setqBZ(OtherUtil.toString(etBeizhu));
        bean.setM3(spDongwu2.getSelectedItem().toString());
        bean.setM4(spDongwu3.getSelectedItem().toString());
//        bean.setqZZS(1);
//        bean.setqZZSDW("");
        return bean;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String time = year + "-" + (month + 1) + "-" + dayOfMonth;
        if (view == dateDialogStart1.getDatePicker()) {
            btShijian1.setText(time);
        }
        if (view == dateDialogStart2.getDatePicker()) {
            btShijian2.setText(time);
        }
        if (view == dateDialogStart3.getDatePicker()) {
            btShijian3.setText(time);
        }
        if (view == dateDialogStart4.getDatePicker()) {
            btShijian4.setText(time);
        }
    }
}
