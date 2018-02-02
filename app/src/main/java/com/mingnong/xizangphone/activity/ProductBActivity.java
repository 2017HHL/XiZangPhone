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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.BaseMsgBean;
import com.mingnong.xizangphone.bean.ProductBUploadBean;
import com.mingnong.xizangphone.bean.QueryProductBBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IProductBActivity;
import com.mingnong.xizangphone.interfac.ITime;
import com.mingnong.xizangphone.presenter.ProductBActivityPresenter;
import com.mingnong.xizangphone.presenter.TimePresenter;
import com.mingnong.xizangphone.utils.OtherUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.text.TextUtils.isEmpty;

/**
 * Created by Administrator on 2017/4/19.
 */
public class ProductBActivity extends MVPActivity<ProductBActivityPresenter> implements IProductBActivity, ITime {

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
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.et_product_name)
    EditText etProductName;
    @BindView(R.id.et_anim_count)
    EditText etAnimCount;
    @BindView(R.id.sp_product_danwei)
    Spinner spProductDanwei;
    @BindView(R.id.et_dizhi)
    EditText etDizhi;
    @BindView(R.id.et_start_place)
    EditText etStartPlace;
    @BindView(R.id.et_product_area)
    EditText etProductArea;
    @BindView(R.id.et_end_place)
    EditText etEndPlace;
    @BindView(R.id.et_quarantine_flag_no)
    EditText etQuarantineFlagNo;
    @BindView(R.id.et_remark)
    EditText etRemark;
    @BindView(R.id.et_signature_checked)
    EditText etSignatureChecked;
    @BindView(R.id.tv_prove_time)
    TextView tvProveTime;
    @BindView(R.id.bt_baocun)
    Button btBaocun;
    TimePresenter timePresenter;
    @BindView(R.id.btn_search)
    Button btnSearch;
    private ProductBUploadBean uploadBean;
    private String jianyi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_b_add);
        ButterKnife.bind(this);
    }

    @Override
    protected ProductBActivityPresenter createPresenter() {
        return new ProductBActivityPresenter(this);
    }

    @Override
    public void bindData() {
        tvTitle.setText("省内动物产品检疫（产品B）");
        timePresenter = new TimePresenter(this);
        timePresenter.getTime();

        //检疫证号
        if (OtherUtil.GET_CHANA != null) {
            etQuarantineNo.setText(OtherUtil.GET_CHANA);
        }
        getPresenter().getJianyiZhenghao();

        spProductDanwei.setAdapter(new ArrayAdapter<>(this, R.layout.spinner_simple, R.id.tv,
                getResources().getStringArray(R.array.product_danwei)));
        etSignatureChecked.setText(getPresenter().getUser().getFUNAME());//官方兽医签字
    }

    @Override
    public void bindListener() {
        btnSearch.setOnClickListener(v -> {
            Intent intent = new Intent(ProductBActivity.this, ProductBSearchActivity.class);
            startActivityForResult(intent, Contance.ACTIVITY_CODE);
        });

        etQuarantineNo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                } else {
                    jianyi = etQuarantineNo.getText().toString();
                    OtherUtil.setGetChana(jianyi);
                }
            }
        });

        btBaocun.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
//                getPresenter().upLoad(getData());
                if (isChecked()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProductBActivity.this);
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == Contance.ACTIVITY_CODE) {
                QueryProductBBean.DataListBean dataListBean = (QueryProductBBean.DataListBean) data.getSerializableExtra(Contance.ACTIVITY_DATA);
                etQuarantineNo.setText(dataListBean.getPBNUMBER());//编号
                etUserName.setText(dataListBean.getPBCARGOOWNER());//货主
                etProductName.setText(dataListBean.getPBNAME());//产品名称
                etAnimCount.setText(dataListBean.getPBQUANTITY() + "");//数量
                etDizhi.setText(dataListBean.getPBPRODUCTIONUNIT());//生产单位地址
                etStartPlace.setText(dataListBean.getPBUNITNAME());//生产单位名称
                etProductArea.setText(dataListBean.getPBORIGIN());//产地
                etEndPlace.setText(dataListBean.getPBDESTINATIONS());//目的地
                etQuarantineFlagNo.setText(dataListBean.getPBSIGN());//检疫标志号
                etRemark.setText(dataListBean.getPBHZNUMBER());//文档未说明，暂时定位备注
                etSignatureChecked.setText(dataListBean.getPBVETERINARY());//官方兽医签字
                tvProveTime.setText(dataListBean.getDATEQF());//签发日期
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
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
        if (isEmpty(getString(etProductName))) {
            showToast("产品名称不能为空");
            etProductName.requestFocus();//获取焦点
            focusKeywordView(etProductName);
            changeTintColor(etProductName);
            return false;
        }
        changeTintColor(etProductName);
        if (isEmpty(getString(etAnimCount))) {
            showToast("数量不能为空");
            etAnimCount.requestFocus();//获取焦点
            focusKeywordView(etAnimCount);
            changeTintColor(etAnimCount);
            return false;
        }
        changeTintColor(etAnimCount);
        if (isEmpty(getString(etProductArea))) {
            showToast("产地不能为空");
            etProductArea.requestFocus();//获取焦点
            focusKeywordView(etProductArea);
            changeTintColor(etProductArea);
            return false;
        }
        changeTintColor(etProductArea);
        if (isEmpty(getString(etDizhi))) {
            showToast("地址不能为空");
            etDizhi.requestFocus();//获取焦点
            focusKeywordView(etDizhi);
            changeTintColor(etDizhi);
            return false;
        }
        changeTintColor(etDizhi);
        if (isEmpty(getString(etStartPlace))) {
            showToast("生成单位名称不能为空");
            etStartPlace.requestFocus();//获取焦点
            focusKeywordView(etStartPlace);
            changeTintColor(etStartPlace);
            return false;
        }
        changeTintColor(etStartPlace);
        if (isEmpty(getString(etEndPlace))) {
            showToast("目的地不能为空");
            etEndPlace.requestFocus();//获取焦点
            focusKeywordView(etEndPlace);
            changeTintColor(etEndPlace);
            return false;
        }
        changeTintColor(etEndPlace);
        if (isEmpty(getString(etSignatureChecked))) {
            showToast("官方兽医签字不能为空");
            etSignatureChecked.requestFocus();//获取焦点
            focusKeywordView(etSignatureChecked);
            changeTintColor(etSignatureChecked);
            return false;
        }
        changeTintColor(etSignatureChecked);
        return true;
    }

    private ProductBUploadBean getData() {
        uploadBean = new ProductBUploadBean();
        uploadBean.setPBNumber(etQuarantineNo.getText().toString());//编号
        uploadBean.setPBCargoOwner(etUserName.getText().toString());//货主
        uploadBean.setPBName(etProductName.getText().toString());//产品名称
        uploadBean.setPBQuantity(etAnimCount.getText().toString());//数量
        uploadBean.setPBOrigin(etProductArea.getText().toString());//产地
        uploadBean.setPBUnitName(etStartPlace.getText().toString());//生产单位名称
        uploadBean.setPBProductionunit(etDizhi.getText().toString());//生产单位地址
        uploadBean.setPBDestinations(etEndPlace.getText().toString());//目的地
        uploadBean.setPBSign(etQuarantineFlagNo.getText().toString());//检疫标志号
        uploadBean.setPBVeterinary(etSignatureChecked.getText().toString());//官方兽医签字
        uploadBean.setPBDanWei(spProductDanwei.getSelectedItem().toString());//单位:至/个
        uploadBean.setIsPrant("0");//状态:0未打印,1打印默认0
        uploadBean.setSaveId(1);//自增ID
//        uploadBean.setPBYouXiaoRi();//有效到达日界面没有
        uploadBean.setPBHzNumber(etRemark.getText().toString());//文档没有解暂时当备注
        uploadBean.setUploadType(1);//上传标识符:0未上传,1已上传
        uploadBean.setUploadTypeSheng(1);//上传标识符:0未上传,1已上传（区分省上传记录）
        uploadBean.setDateQF(tvProveTime.getText().toString());//签发日期
        return uploadBean;
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
        if (OtherUtil.getGetChana() == null) {
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
                        bundle.putString(Contance.ACTIVITY_TYPE, Contance.TYPE_PRINT_PRODUCT_B);
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
