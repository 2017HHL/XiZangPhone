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
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.SimpleOnItemSelectedListener;
import com.mingnong.xizangphone.bean.BaseMsgBean;
import com.mingnong.xizangphone.bean.ProductAUploadBean;
import com.mingnong.xizangphone.bean.QueryProductABean;
import com.mingnong.xizangphone.dao.LocalGreenDao;
import com.mingnong.xizangphone.dao.Unit;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IProductAActivity;
import com.mingnong.xizangphone.interfac.ITime;
import com.mingnong.xizangphone.presenter.ProductAActivityPresenter;
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
import static com.mingnong.xizangphone.R.id.sp_prod_name1;

/**
 * Created by Administrator on 2017/4/19.
 */
public class ProductAActivity extends MVPActivity<ProductAActivityPresenter> implements IProductAActivity, ITime {


    TimePresenter timePresenter;
    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.et_quarantine_no)
    EditText etQuarantineNo;
    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_user_phone)
    EditText etUserPhone;
    @BindView(sp_prod_name1)
    Spinner spProdName1;
    @BindView(R.id.sp_prod_name2)
    Spinner spProdName2;
    @BindView(R.id.sp_prod_name3)
    Spinner spProdName3;
    @BindView(R.id.et_product_count)
    EditText etProductCount;
    @BindView(R.id.sp_product_danwei)
    Spinner spProductDanwei;
    @BindView(R.id.et_start_place)
    EditText etStartPlace;
    @BindView(R.id.sp_qiyun_sheng)
    Spinner spQiyunSheng;
    @BindView(R.id.sp_qiyun_shi)
    Spinner spQiyunShi;
    @BindView(R.id.sp_qiyun_xian)
    Spinner spQiyunXian;
    @BindView(R.id.et_qiyun_xiang)
    EditText etQiyunXiang;
    @BindView(R.id.sp_daoda_sheng)
    Spinner spDaodaSheng;
    @BindView(R.id.sp_daoda_shi)
    Spinner spDaodaShi;
    @BindView(R.id.sp_daoda_xian)
    Spinner spDaodaXian;
    @BindView(R.id.et_daoda_xiang)
    EditText etDaodaXiang;
    @BindView(R.id.et_carrier_name)
    EditText etCarrierName;
    @BindView(R.id.et_carrier_phone)
    EditText etCarrierPhone;
    @BindView(R.id.et_carrier_util_number)
    EditText etCarrierUtilNumber;
    @BindView(R.id.et_steriallier_method)
    EditText etSteriallierMethod;
    @BindView(R.id.rb_railway)
    RadioButton rbRailway;
    @BindView(R.id.rb_highway)
    RadioButton rbHighway;
    @BindView(R.id.rb_waveway)
    RadioButton rbWaveway;
    @BindView(R.id.rb_aviation)
    RadioButton rbAviation;
    @BindView(R.id.rg_transportation)
    RadioGroup rgTransportation;
    @BindView(R.id.et_remark)
    EditText etRemark;
    @BindView(R.id.et_signature_checked)
    EditText etSignatureChecked;
    @BindView(R.id.et_check_phone)
    EditText etCheckPhone;
    @BindView(R.id.tv_prove_time)
    TextView tvProveTime;
    @BindView(R.id.bt_baocun)
    Button btBaocun;
    @BindView(R.id.sp_youxiangday)
    Spinner spYouxiangday;
    @BindView(R.id.btn_search)
    Button btnSearch;

    private List<Unit> startCity, startCounty, endProvince, endCity, endCounty;
    private Unit startProvince;
    private ProductAUploadBean uploadBean;
    private int tid;
    private String jianyi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_a_add);
        ButterKnife.bind(this);
    }

    @Override
    protected ProductAActivityPresenter createPresenter() {
        return new ProductAActivityPresenter(this);
    }

    @Override
    public void bindData() {
        tvTitle.setText("省外动物产品检疫（产品A）");
        timePresenter = new TimePresenter(this);
        timePresenter.getTime();

        //检疫证号
        if (OtherUtil.GET_JIANYI != null) {
            etQuarantineNo.setText(OtherUtil.GET_JIANYI);
        }

        getPresenter().getJianyiZhenghao();

        spProdName1.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.product_name_1)));
        spProductDanwei.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.product_danwei)));
        spProdName3.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.product_name3)));

        spYouxiangday.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                OtherUtil.createWeeks()));
        etSignatureChecked.setText(getPresenter().getUser().getFUNAME());//官方兽医签字
        setPlace();

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
        spQiyunSheng.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                new String[]{startProvince.getUName()}));

        spQiyunShi.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(startCity)));

        spQiyunXian.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(startCounty)));

        spDaodaSheng.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(endProvince)));

        spDaodaShi.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(endCity)));

        spDaodaXian.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getList(endCounty)));
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
            Intent intent = new Intent(ProductAActivity.this, ProductASearchActivity.class);
            startActivityForResult(intent, Contance.ACTIVITY_CODE);
        });

        spProdName1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    spProdName2.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv, getResources().
                            getStringArray(R.array.product_name_11)));
                } else if (position == 1) {
                    spProdName2.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv, getResources().
                            getStringArray(R.array.product_name_12)));
                } else if (position == 2) {
                    spProdName2.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv, getResources().
                            getStringArray(R.array.product_name_13)));
                } else if (position == 3) {
                    spProdName2.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv, getResources().
                            getStringArray(R.array.product_name_14)));
                } else if (position == 4) {
                    spProdName2.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv, getResources().
                            getStringArray(R.array.product_name_15)));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spProdName2.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name2 = spProdName2.getSelectedItem().toString();
                if (name2.equals("其它畜产品") || name2.equals("狗肉") || name2.equals("兔肉") || name2.equals("驴肉") || name2.equals("筋")
                        || name2.equals("鹌鹑肉") || name2.equals("鸽肉") || name2.equals("其他禽产品") || name2.equals("其他禽副产品") ||
                        name2.equals("精液") || name2.equals("胚胎") || name2.equals("种蛋") || name2.equals("卵") || name2.equals("其它产品")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_mei)));
                } else if (name2.equals("猪肉")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_zhurou)));
                } else if (name2.equals("牛肉")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_niurou)));
                } else if (name2.equals("羊肉")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_yangrou)));
                } else if (name2.equals("脏器")) {
                    if (spProdName1.getSelectedItem().toString().equals("畜副产品")) {
                        spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                                getResources().getStringArray(R.array.product_zangqi1)));
                    } else {
                        spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                                getResources().getStringArray(R.array.product_zangqi2)));
                    }
                } else if (name2.equals("血液")) {
                    if (spProdName1.getSelectedItem().toString().equals("畜副产品")) {
                        spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                                getResources().getStringArray(R.array.product_xueye1)));
                    } else {
                        spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                                getResources().getStringArray(R.array.product_xueye2)));
                    }

                } else if (name2.equals("生皮")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_shengpi)));
                } else if (name2.equals("原毛")) {
                    if (spProdName1.getSelectedItem().toString().equals("畜副产品")) {
                        spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                                getResources().getStringArray(R.array.product_yuanmao1)));
                    } else {
                        spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                                getResources().getStringArray(R.array.product_yuanmao2)));
                    }
                } else if (name2.equals("骨")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_gu)));
                } else if (name2.equals("角")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_jiao)));
                } else if (name2.equals("头")) {
                    if (spProdName1.getSelectedItem().toString().equals("畜副产品")) {
                        spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                                getResources().getStringArray(R.array.product_tou)));
                    } else {
                        spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                                getResources().getStringArray(R.array.product_mei)));
                    }
                } else if (name2.equals("蹄")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_ti)));
                } else if (name2.equals("脂")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_zhi)));
                } else if (name2.equals("鸡肉")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_jirou)));
                } else if (name2.equals("鸭肉")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_yarou)));
                } else if (name2.equals("鹅肉")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_erou)));
                } else if (name2.equals("绒")) {
                    spProdName3.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                            getResources().getStringArray(R.array.product_rong)));
                }
            }
        });


        spQiyunShi.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                List<Unit> queryCitys = LocalGreenDao.getInstance().queryCitysOrCountries(startCity.get(position).getTId());
                spQiyunXian.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                        getList(queryCitys)));
            }
        });
        spDaodaSheng.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //转化为成员变量，是因为要更新城市列表
                tid = Integer.parseInt(endProvince.get(position).getTId());
                List<Unit> units = LocalGreenDao.getInstance().queryCitys(tid);
                spDaodaShi.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                        getList(units)));
            }
        });
        spDaodaShi.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                List<Unit> queryCitt = LocalGreenDao.getInstance().queryCitysOrCountries(LocalGreenDao.getInstance().queryCitys(tid).get(position).getTId());
                spDaodaXian.setAdapter(new ArrayAdapter<>(ProductAActivity.this, R.layout.spinner_simple, R.id.tv,
                        getList(queryCitt)));
            }
        });

        btBaocun.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProductAActivity.this);
                    builder.setTitle("注意")
                            .setMessage("请确认检疫证号是否正确:" + etQuarantineNo.getText().toString())
                            .setPositiveButton("是", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    getPresenter().upLoad(getData());
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
        etQuarantineNo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                } else {
                    jianyi = etQuarantineNo.getText().toString();
                    OtherUtil.setGetJianyi(jianyi);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == Contance.ACTIVITY_CODE) {
                QueryProductABean.DataListBean dataListBean = (QueryProductABean.DataListBean) data.getSerializableExtra(Contance.ACTIVITY_DATA);
                etQuarantineNo.setText(dataListBean.getPNUMBER());//编号
                etUserName.setText(dataListBean.getPCARGOOWNER());//货主
                etUserPhone.setText(dataListBean.getPPHONE());//联系电话
                etProductCount.setText(dataListBean.getPQUANTITY() + "");//数量
                etStartPlace.setText(dataListBean.getPUNITNAME());//生产单位名称
                etQiyunXiang.setText(dataListBean.getPPRODUCTIONUNIT());//生产单位地址
                etDaodaXiang.setText(dataListBean.getPMEMO2());//目的地
                etCarrierName.setText(dataListBean.getPCARRIER());//承运人
                etCarrierPhone.setText(dataListBean.getPPHONECYR());//联系电话
                etCarrierUtilNumber.setText(dataListBean.getPTRADEMARK());//运载工具牌号
                etSteriallierMethod.setText(dataListBean.getPDISINFECTION());//装运前消毒方式
                etRemark.setText(dataListBean.getPMEMO1());//备注
                etSignatureChecked.setText(dataListBean.getPVETERINARY());//官方兽医签字
                etCheckPhone.setText(dataListBean.getPDWPHONE());//动物卫生监督所联系电话
                tvProveTime.setText(dataListBean.getDATEQF());//签发日期
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private ProductAUploadBean getData() {
        uploadBean = new ProductAUploadBean();
        uploadBean.setPNumber(etQuarantineNo.getText().toString());//编号
        uploadBean.setPCargoOwner(etUserName.getText().toString());//货主
        uploadBean.setPPhone(etUserPhone.getText().toString());//电话
        if (spProdName3.getSelectedItem().toString().equals("请选择")) {
            uploadBean.setPName(spProdName1.getSelectedItem().toString() + spProdName2.getSelectedItem().toString());//产品名称
        } else {
            uploadBean.setPName(spProdName1.getSelectedItem().toString() + spProdName2.getSelectedItem().toString()
                    + spProdName3.getSelectedItem().toString());//产品名称
        }
        uploadBean.setPQuantity(etProductCount.getText().toString());//数量
        uploadBean.setPUnitName(etStartPlace.getText().toString());//生产单位名称
        uploadBean.setPProductionunit(etQiyunXiang.getText().toString());//生产单位地址
        uploadBean.setPQySheng(spQiyunSheng.getSelectedItem().toString());//省-市/州
        uploadBean.setPQyShi(spQiyunShi.getSelectedItem().toString());//市-州
        uploadBean.setPQyXian(spQiyunXian.getSelectedItem().toString());//县-市/区
        uploadBean.setPCarrier(etCarrierName.getText().toString());//承运人
        uploadBean.setPPhoneCyr(etCarrierPhone.getText().toString());//联系电话
        uploadBean.setPTrademark(etCarrierUtilNumber.getText().toString());//运载工具牌号
        uploadBean.setPDisinfection(etSteriallierMethod.getText().toString());//装运前消毒方式
        uploadBean.setPYouXiaoRi(Integer.parseInt(spYouxiangday.getSelectedItem().toString()));//有效到达日
        uploadBean.setPVeterinary(etSignatureChecked.getText().toString());//官方兽医签字
        uploadBean.setPDwPhone(etCheckPhone.getText().toString());//动物卫生监督所联系电话
        uploadBean.setPDanWei(spProductDanwei.getSelectedItem().toString());//单位-只/个
        //运载方式
        if (rbRailway.isChecked()) {
            uploadBean.setPYunZai("铁路");
        } else if (rbHighway.isChecked()) {
            uploadBean.setPYunZai("公路");
        } else if (rbWaveway.isChecked()) {
            uploadBean.setPYunZai("水路");
        } else if (rbAviation.isChecked()) {
            uploadBean.setPYunZai("航空");
        }
        uploadBean.setDateQF(tvProveTime.getText().toString());//签发日期
        uploadBean.setPMemo1(etRemark.getText().toString());//备注
        uploadBean.setPMemo2(etDaodaXiang.getText().toString());//目的地
        uploadBean.setPSheng(spDaodaSheng.getSelectedItem().toString());
        uploadBean.setPShi(spDaodaShi.getSelectedItem().toString());
        uploadBean.setPXian(spDaodaXian.getSelectedItem().toString());
        uploadBean.setPMemo3(spDaodaSheng.getSelectedItem().toString() + spDaodaShi.getSelectedItem().toString() +
                spDaodaXian.getSelectedItem().toString());//保存-县/市/区
        uploadBean.setPMemo4(etStartPlace.getText().toString() + etQiyunXiang.getText().toString());//生产单位名称及地址
        uploadBean.setIsPrant("保存");//状态:保存/打印/报废
        uploadBean.setSaveId(1);//数据的自增Id
        uploadBean.setPDiDian(etQiyunXiang.getText().toString());//县区市后详细地点
        uploadBean.setUploadType(1);//上传标识符:0未上传,1已上传
        uploadBean.setUploadTypeSheng(1);//上传标识符:0未上传,1已上传（区分省上传记录）
        return uploadBean;

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean isChecked() {
        if (isEmpty(getString(etQuarantineNo))) {
            showToast("检疫证编号不能为空");
            etQuarantineNo.requestFocus();//获取焦点
            focusKeywordView(etQuarantineNo);
            changeTintColor(etQuarantineNo);
            return false;
        }
        changeTintColor(etQuarantineNo);
        if (isEmpty(getString(etUserName))) {
            showToast("货主姓名不能为空");
            etUserName.requestFocus();//获取焦点
            focusKeywordView(etUserName);
            changeTintColor(etUserName);
            return false;
        }
        changeTintColor(etUserName);
        if (isEmpty(getString(etUserPhone))) {
            showToast("联系电话能为空");
            etUserPhone.requestFocus();//获取焦点
            focusKeywordView(etUserPhone);
            changeTintColor(etUserPhone);
            return false;
        }
        changeTintColor(etUserPhone);
        if (isEmpty(getString(etProductCount))) {
            showToast("数量不能为空");
            etProductCount.requestFocus();//获取焦点
            focusKeywordView(etProductCount);
            changeTintColor(etProductCount);
            return false;
        }
        changeTintColor(etProductCount);

        if (isEmpty(getString(etStartPlace))) {
            showToast("生产单位名称不能为空");
            etStartPlace.requestFocus();//获取焦点
            focusKeywordView(etStartPlace);
            changeTintColor(etStartPlace);
            return false;
        }
        changeTintColor(etStartPlace);
        if (isEmpty(getString(etQiyunXiang))) {
            showToast("起运地乡不能为空");
            etQiyunXiang.requestFocus();//获取焦点
            focusKeywordView(etQiyunXiang);
            changeTintColor(etQiyunXiang);
            return false;
        }
        changeTintColor(etQiyunXiang);

        if (isEmpty(getString(etDaodaXiang))) {
            showToast("到达地乡不能为空");
            etDaodaXiang.requestFocus();//获取焦点
            focusKeywordView(etDaodaXiang);
            changeTintColor(etDaodaXiang);
            return false;
        }
        changeTintColor(etDaodaXiang);


        if (isEmpty(getString(etCarrierName))) {
            showToast("承运人不能为空");
            etCarrierName.requestFocus();//获取焦点
            focusKeywordView(etCarrierName);
            changeTintColor(etCarrierName);
            return false;
        }
        changeTintColor(etCarrierName);
        if (isEmpty(getString(etCarrierPhone))) {
            showToast("承运人电话不能为空");
            etCarrierPhone.requestFocus();//获取焦点
            focusKeywordView(etCarrierPhone);
            changeTintColor(etCarrierPhone);
            return false;
        }
        changeTintColor(etCarrierPhone);
        if (isEmpty(getString(etCarrierUtilNumber))) {
            showToast("运载工具号不能为空");
            etCarrierUtilNumber.requestFocus();//获取焦点
            focusKeywordView(etCarrierUtilNumber);
            changeTintColor(etCarrierUtilNumber);
            return false;
        }
        changeTintColor(etCarrierUtilNumber);
        if (isEmpty(getString(etSteriallierMethod))) {
            showToast("消毒方式不能为空");
            etSteriallierMethod.requestFocus();//获取焦点
            focusKeywordView(etSteriallierMethod);
            changeTintColor(etSteriallierMethod);
            return false;
        }
        changeTintColor(etSteriallierMethod);
        if (isEmpty(getString(etSignatureChecked))) {
            showToast("官方兽医签字不能为空");
            etSignatureChecked.requestFocus();//获取焦点
            focusKeywordView(etSignatureChecked);
            changeTintColor(etSignatureChecked);
            return false;
        }
        changeTintColor(etSignatureChecked);
        if (isEmpty(getString(etCheckPhone))) {
            showToast("动物卫生监督所电话不能为空");
            etCheckPhone.requestFocus();//获取焦点
            focusKeywordView(etCheckPhone);
            changeTintColor(etCheckPhone);
            return false;
        }
        changeTintColor(etCheckPhone);
        return true;
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
    public void upLoadSucceed() {
        //成功上传数据,显示是否打印的对话框
        openPrintDialog();
    }

    @Override
    public void zhenghao(BaseMsgBean.Data dataListBean) {
        if (OtherUtil.getGetJianyi() == null) {
            jianyi = dataListBean.getResult();
            etQuarantineNo.setText(jianyi);//检疫证号
        }

    }

    private void openPrintDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View inflate = layoutInflater.inflate(R.layout.tishi_activity, null);
        new AlertDialog.Builder(this)
                .setTitle("是否打印")
                .setCancelable(false)
                .setView(inflate)
                .setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), PrintAcitivty.class);
                        Bundle bundle = new Bundle();
                        bundle.putString(Contance.ACTIVITY_TYPE, Contance.TYPE_PRINT_PRODUCT_A);
//                        bundle.putString(Contance.START_ACTIVITY_PRINTID, printId);
                        bundle.putSerializable(Contance.ACTIVITY_DATA, uploadBean);
                        intent.putExtras(bundle);
                        startActivity(intent);
//                        setResult(RESULT_OK, intent1);
                        finish();

                    }
                })
                .setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        setResult(RESULT_OK, intent1);
                        finish();
                    }
                })
                .show();

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
