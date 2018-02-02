package com.mingnong.xizangphone.activity;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.PublicInformation;
import com.mingnong.xizangphone.bean.WuHaIHuaAddBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IWuHaiHuaActivity;
import com.mingnong.xizangphone.presenter.WuHaiHuaActivityPresenter;
import com.mingnong.xizangphone.utils.CcWriteDiolog;
import com.mingnong.xizangphone.utils.DialogListener;
import com.mingnong.xizangphone.utils.PhotoUtil;
import com.mingnong.xizangphone.utils.PictureUtils;
import com.mingnong.xizangphone.utils.TakePictureUtil;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import butterknife.BindView;

import static com.mingnong.xizangphone.utils.PhotoUtils.compressBmpToFile;
import static com.mingnong.xizangphone.utils.PhotoUtils.decodeSampleBitmapFromFile;


public class WuHaiHuaActivity extends MVPActivity<WuHaiHuaActivityPresenter> implements IWuHaiHuaActivity, View.OnClickListener, DatePickerDialog.OnDateSetListener {
    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.et_shixian)
    EditText etShixian;
    @BindView(R.id.et_quxian)
    EditText etQuxian;
    @BindView(R.id.et_date)
    EditText etDate;
    @BindView(R.id.et_mane)
    EditText etMane;
    @BindView(R.id.bt_chaxun)
    Button btChaxun;
    @BindView(R.id.et_man)
    EditText etMan;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_xiaoji)
    EditText etXiaoji;
    @BindView(R.id.et_huazhi)
    EditText etHuazhi;
    @BindView(R.id.et_gaowen)
    EditText etGaowen;
    @BindView(R.id.et_shenmai)
    EditText etShenmai;
    @BindView(R.id.et_fenshao)
    EditText etFenshao;
    @BindView(R.id.et_huaxuechuli)
    EditText etHuaxuechuli;
    @BindView(R.id.et_qita)
    EditText etQita;
    @BindView(R.id.LL_01)
    LinearLayout LL01;
    @BindView(R.id.et_xiaoji1)
    EditText etXiaoji1;
    @BindView(R.id.et_huazhi1)
    EditText etHuazhi1;
    @BindView(R.id.et_gaowen1)
    EditText etGaowen1;
    @BindView(R.id.et_shenmai1)
    EditText etShenmai1;
    @BindView(R.id.et_fenshao1)
    EditText etFenshao1;
    @BindView(R.id.et_huaxuechuli1)
    EditText etHuaxuechuli1;
    @BindView(R.id.et_qita1)
    EditText etQita1;
    @BindView(R.id.LL_02)
    LinearLayout LL02;
    @BindView(R.id.deadanimals_iv_deathPoultry1)
    ImageView deadanimalsIvDeathPoultry1;
    @BindView(R.id.deadanimals_tv_deathPoultry1)
    TextView deadanimalsTvDeathPoultry1;
    @BindView(R.id.deadanimals_rl_deathPoultry1)
    RelativeLayout deadanimalsRlDeathPoultry1;
    @BindView(R.id.deadanimals_iv_deathPoultry2)
    ImageView deadanimalsIvDeathPoultry2;
    @BindView(R.id.deadanimals_tv_deathPoultry2)
    TextView deadanimalsTvDeathPoultry2;
    @BindView(R.id.deadanimals_rl_deathPoultry2)
    RelativeLayout deadanimalsRlDeathPoultry2;
    @BindView(R.id.deadanimals_iv_deathPoultry3)
    ImageView deadanimalsIvDeathPoultry3;
    @BindView(R.id.deadanimals_tv_deathPoultry3)
    TextView deadanimalsTvDeathPoultry3;
    @BindView(R.id.deadanimals_rl_deathPoultry3)
    RelativeLayout deadanimalsRlDeathPoultry3;
    @BindView(R.id.deadanimals_iv_deathPoultry4)
    ImageView deadanimalsIvDeathPoultry4;
    @BindView(R.id.deadanimals_tv_deathPoultry4)
    TextView deadanimalsTvDeathPoultry4;
    @BindView(R.id.deadanimals_rl_deathPoultry4)
    RelativeLayout deadanimalsRlDeathPoultry4;
    @BindView(R.id.bt_shouyiqianming)
    Button btShouyiqianming;
    @BindView(R.id.img_zhanzhang)
    ImageView imgZhanzhang;
    @BindView(R.id.bt_que)
    Button btQue;


    private DatePickerDialog dateDialog;
    private Bitmap bitmap;


    private File signCheckFile;
    private File storeTableDir = PhotoUtil.getWuHaiHuaDir();
    private String uID = "";
    private final String uuid = UUID.randomUUID().toString();
    PublicInformation publicInformation = new PublicInformation();
    private File file1, file2, file3, file4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wu_hai_hua);
    }

    @Override
    protected WuHaiHuaActivityPresenter createPresenter() {
        return new WuHaiHuaActivityPresenter(this);
    }

    @Override
    public void bindData() {
        setTitle("屠宰场病死生猪及生猪产品无害化处理");
        etDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        etHuazhi.setText("0");
        etGaowen.setText("0");
        etShenmai.setText("0");
        etFenshao.setText("0");
        etHuaxuechuli.setText("0");
        etQita.setText("0");
        etHuazhi1.setText("0");
        etGaowen1.setText("0");
        etShenmai1.setText("0");
        etFenshao1.setText("0");
        etHuaxuechuli1.setText("0");
        etQita1.setText("0");
        etXiaoji.setText("0");
        etXiaoji1.setText("0");
        //获取时间
        final Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(System.currentTimeMillis());

        dateDialog = new DatePickerDialog(this, this, mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));

    }


    @Override
    public void bindListener() {
        btChaxun.setOnClickListener(v -> {
            Intent intent = new Intent(this, WuHaiHuaAddActivity.class);
            startActivityForResult(intent, 100);
        });

        //无害化处理病害生猪
        etHuazhi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji.setText(Integer.parseInt(s.toString())
                            + Integer.parseInt(isEmpty(etGaowen))
                            + Integer.parseInt(isEmpty(etShenmai))
                            + Integer.parseInt(isEmpty(etFenshao))
                            + Integer.parseInt(isEmpty(etHuaxuechuli))
                            + Integer.parseInt(isEmpty(etQita)) + "");
                } else {
                    etXiaoji.setText(Integer.parseInt("0")
                            + Integer.parseInt(isEmpty(etGaowen))
                            + Integer.parseInt(isEmpty(etShenmai))
                            + Integer.parseInt(isEmpty(etFenshao))
                            + Integer.parseInt(isEmpty(etHuaxuechuli))
                            + Integer.parseInt(isEmpty(etQita)) + "");
                }
            }
        });

        etGaowen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji.setText(Integer.parseInt(isEmpty(etHuazhi))
                            + Integer.parseInt(s.toString())
                            + Integer.parseInt(isEmpty(etShenmai))
                            + Integer.parseInt(isEmpty(etFenshao))
                            + Integer.parseInt(isEmpty(etHuaxuechuli))
                            + Integer.parseInt(isEmpty(etQita)) + "");
                } else {
                    etXiaoji.setText(Integer.parseInt(isEmpty(etHuazhi))
                            + Integer.parseInt("0")
                            + Integer.parseInt(isEmpty(etShenmai))
                            + Integer.parseInt(isEmpty(etFenshao))
                            + Integer.parseInt(isEmpty(etHuaxuechuli))
                            + Integer.parseInt(isEmpty(etQita)) + "");
                }

            }
        });

        etShenmai.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji.setText(Integer.parseInt(isEmpty(etHuazhi))
                            + Integer.parseInt(isEmpty(etGaowen))
                            + Integer.parseInt(s.toString())
                            + Integer.parseInt(isEmpty(etFenshao))
                            + Integer.parseInt(isEmpty(etHuaxuechuli))
                            + Integer.parseInt(isEmpty(etQita)) + "");
                } else {
                    etXiaoji.setText(Integer.parseInt(isEmpty(etHuazhi))
                            + Integer.parseInt(isEmpty(etGaowen))
                            + Integer.parseInt("0")
                            + Integer.parseInt(isEmpty(etFenshao))
                            + Integer.parseInt(isEmpty(etHuaxuechuli))
                            + Integer.parseInt(isEmpty(etQita)) + "");
                }

            }
        });
        etFenshao.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji.setText(Integer.parseInt(isEmpty(etHuazhi))
                            + Integer.parseInt(isEmpty(etGaowen))
                            + Integer.parseInt(isEmpty(etShenmai))
                            + Integer.parseInt(s.toString())
                            + Integer.parseInt(isEmpty(etHuaxuechuli))
                            + Integer.parseInt(isEmpty(etQita)) + "");
                } else {
                    etXiaoji.setText(Integer.parseInt(isEmpty(etHuazhi))
                            + Integer.parseInt(isEmpty(etGaowen))
                            + Integer.parseInt(isEmpty(etShenmai))
                            + Integer.parseInt("0")
                            + Integer.parseInt(isEmpty(etHuaxuechuli))
                            + Integer.parseInt(isEmpty(etQita)) + "");
                }
            }
        });
        etHuaxuechuli.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji.setText(Integer.parseInt(isEmpty(etHuazhi))
                            + Integer.parseInt(isEmpty(etGaowen))
                            + Integer.parseInt(isEmpty(etShenmai))
                            + Integer.parseInt(isEmpty(etFenshao))
                            + Integer.parseInt(s.toString())
                            + Integer.parseInt(isEmpty(etQita)) + "");
                } else {
                    etXiaoji.setText(Integer.parseInt(isEmpty(etHuazhi))
                            + Integer.parseInt(isEmpty(etGaowen))
                            + Integer.parseInt(isEmpty(etShenmai))
                            + Integer.parseInt(isEmpty(etFenshao))
                            + Integer.parseInt("0")
                            + Integer.parseInt(isEmpty(etQita)) + "");
                }
            }
        });
        etQita.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji.setText(Integer.parseInt(isEmpty(etHuazhi))
                            + Integer.parseInt(isEmpty(etGaowen))
                            + Integer.parseInt(isEmpty(etShenmai))
                            + Integer.parseInt(isEmpty(etFenshao))
                            + Integer.parseInt(isEmpty(etHuaxuechuli))
                            + Integer.parseInt(s.toString()) + "");
                } else {
                    etXiaoji.setText(Integer.parseInt(isEmpty(etHuazhi))
                            + Integer.parseInt(isEmpty(etGaowen))
                            + Integer.parseInt(isEmpty(etShenmai))
                            + Integer.parseInt(isEmpty(etFenshao))
                            + Integer.parseInt(isEmpty(etHuaxuechuli))
                            + Integer.parseInt("0") + "");
                }
            }
        });
        //无害化处理病害生猪产品
        etHuazhi1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji1.setText(Integer.parseInt(s.toString())
                            + Integer.parseInt(isEmpty(etGaowen1))
                            + Integer.parseInt(isEmpty(etShenmai1))
                            + Integer.parseInt(isEmpty(etFenshao1))
                            + Integer.parseInt(isEmpty(etHuaxuechuli1))
                            + Integer.parseInt(isEmpty(etQita1)) + "");
                } else {
                    etXiaoji1.setText(Integer.parseInt("0")
                            + Integer.parseInt(isEmpty(etGaowen1))
                            + Integer.parseInt(isEmpty(etShenmai1))
                            + Integer.parseInt(isEmpty(etFenshao1))
                            + Integer.parseInt(isEmpty(etHuaxuechuli1))
                            + Integer.parseInt(isEmpty(etQita1)) + "");
                }
            }
        });

        etGaowen1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji1.setText(Integer.parseInt(isEmpty(etHuazhi1))
                            + Integer.parseInt(s.toString())
                            + Integer.parseInt(isEmpty(etShenmai1))
                            + Integer.parseInt(isEmpty(etFenshao1))
                            + Integer.parseInt(isEmpty(etHuaxuechuli1))
                            + Integer.parseInt(isEmpty(etQita1)) + "");
                } else {
                    etXiaoji1.setText(Integer.parseInt(isEmpty(etHuazhi1))
                            + Integer.parseInt("0")
                            + Integer.parseInt(isEmpty(etShenmai1))
                            + Integer.parseInt(isEmpty(etFenshao1))
                            + Integer.parseInt(isEmpty(etHuaxuechuli1))
                            + Integer.parseInt(isEmpty(etQita1)) + "");
                }

            }
        });

        etShenmai1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji1.setText(Integer.parseInt(isEmpty(etHuazhi1))
                            + Integer.parseInt(isEmpty(etGaowen1))
                            + Integer.parseInt(s.toString())
                            + Integer.parseInt(isEmpty(etFenshao1))
                            + Integer.parseInt(isEmpty(etHuaxuechuli1))
                            + Integer.parseInt(isEmpty(etQita1)) + "");
                } else {
                    etXiaoji1.setText(Integer.parseInt(isEmpty(etHuazhi1))
                            + Integer.parseInt(isEmpty(etGaowen1))
                            + Integer.parseInt("0")
                            + Integer.parseInt(isEmpty(etFenshao1))
                            + Integer.parseInt(isEmpty(etHuaxuechuli1))
                            + Integer.parseInt(isEmpty(etQita1)) + "");
                }

            }
        });
        etFenshao1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji1.setText(Integer.parseInt(isEmpty(etHuazhi1))
                            + Integer.parseInt(isEmpty(etGaowen1))
                            + Integer.parseInt(isEmpty(etShenmai1))
                            + Integer.parseInt(s.toString())
                            + Integer.parseInt(isEmpty(etHuaxuechuli1))
                            + Integer.parseInt(isEmpty(etQita1)) + "");
                } else {
                    etXiaoji1.setText(Integer.parseInt(isEmpty(etHuazhi1))
                            + Integer.parseInt(isEmpty(etGaowen1))
                            + Integer.parseInt(isEmpty(etShenmai1))
                            + Integer.parseInt("0")
                            + Integer.parseInt(isEmpty(etHuaxuechuli1))
                            + Integer.parseInt(isEmpty(etQita1)) + "");
                }
            }
        });
        etHuaxuechuli1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji1.setText(Integer.parseInt(isEmpty(etHuazhi1))
                            + Integer.parseInt(isEmpty(etGaowen1))
                            + Integer.parseInt(isEmpty(etShenmai1))
                            + Integer.parseInt(isEmpty(etFenshao1))
                            + Integer.parseInt(s.toString())
                            + Integer.parseInt(isEmpty(etQita1)) + "");
                } else {
                    etXiaoji1.setText(Integer.parseInt(isEmpty(etHuazhi1))
                            + Integer.parseInt(isEmpty(etGaowen1))
                            + Integer.parseInt(isEmpty(etShenmai1))
                            + Integer.parseInt(isEmpty(etFenshao1))
                            + Integer.parseInt("0")
                            + Integer.parseInt(isEmpty(etQita1)) + "");
                }
            }
        });
        etQita1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString())) {
                    etXiaoji1.setText(Integer.parseInt(isEmpty(etHuazhi1))
                            + Integer.parseInt(isEmpty(etGaowen1))
                            + Integer.parseInt(isEmpty(etShenmai1))
                            + Integer.parseInt(isEmpty(etFenshao1))
                            + Integer.parseInt(isEmpty(etHuaxuechuli1))
                            + Integer.parseInt(s.toString()) + "");
                } else {
                    etXiaoji1.setText(Integer.parseInt(isEmpty(etHuazhi1))
                            + Integer.parseInt(isEmpty(etGaowen1))
                            + Integer.parseInt(isEmpty(etShenmai1))
                            + Integer.parseInt(isEmpty(etFenshao1))
                            + Integer.parseInt(isEmpty(etHuaxuechuli1))
                            + Integer.parseInt("0") + "");
                }
            }
        });

        //4个拍照点击
        deadanimalsRlDeathPoultry1.setOnClickListener(this);
        deadanimalsRlDeathPoultry2.setOnClickListener(this);
        deadanimalsRlDeathPoultry3.setOnClickListener(this);
        deadanimalsRlDeathPoultry4.setOnClickListener(this);

        //签名
        btShouyiqianming.setOnClickListener(this);
        //上传
        btQue.setOnClickListener(this);
    }

    public void setText() {
        publicInformation.setFHarmHZNum(isEmpty(etHuazhi));
        publicInformation.setFSumNum(isEmpty(etXiaoji));       //小计1
        publicInformation.setFProductSum(isEmpty(etXiaoji1));       //小计2
        publicInformation.setFHightTemperatureNum(isEmpty(etGaowen));//高温
        publicInformation.setFBuriedDeepNum(isEmpty(etShenmai));//深埋
        publicInformation.setFBurnNum(isEmpty(etFenshao));//焚烧
        publicInformation.setFhxdealNum(isEmpty(etHuaxuechuli));//化学处理
        publicInformation.setFOtherNum(isEmpty(etQita));//其它
        publicInformation.setFProductHzNum(isEmpty(etHuazhi1));//化制
        publicInformation.setFProductGwNum(isEmpty(etGaowen1));//高温
        publicInformation.setFproductSmNum(isEmpty(etShenmai1));//深埋
        publicInformation.setFproductFsNum(isEmpty(etFenshao1));//焚烧
        publicInformation.setFProductHxNum(isEmpty(etHuaxuechuli1));//化学处理
        publicInformation.setFProductOtherNum(isEmpty(etQita1));//其它
    }


    //上传的东西
    public PublicInformation getDeclareInfo() {

        publicInformation.setFCtiyName(etShixian.getText().toString());//市地名
        publicInformation.setFCountyName(etQuxian.getText().toString());//区县名
        publicInformation.setFDealDate(etDate.getText().toString());//时间
        publicInformation.setSlaughtName(etMane.getText().toString());//屠宰场名称
        publicInformation.setFlegalName(etMan.getText().toString());//法人代表
        publicInformation.setFLegalPhone(etPhone.getText().toString());//电话


        publicInformation.setFVeterinary(uuid + "signCheck" + TakePictureUtil.FILE_POSTFIX);
        publicInformation.setFPictureOne(uuid + PhotoUtil.DEFAULT_FILE_NAME + 1 + PhotoUtil.FILE_POSTFIX);
        publicInformation.setFPictureTwo(uuid + PhotoUtil.DEFAULT_FILE_NAME + 2 + PhotoUtil.FILE_POSTFIX);
        publicInformation.setFPictureThree(uuid + PhotoUtil.DEFAULT_FILE_NAME + 3 + PhotoUtil.FILE_POSTFIX);
        publicInformation.setFPictureFour(uuid + PhotoUtil.DEFAULT_FILE_NAME + 4 + PhotoUtil.FILE_POSTFIX);

        setText();
        return publicInformation;
    }


    @Override
    public void setData(PublicInformation data) {

    }

    @Override
    public void isFinish() {
        Toast.makeText(this, "上传完成", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void uploadsuccess() {
        setResult(RESULT_OK);
        finish();
    }

    //上传判断
    public boolean judge() {
        if (etXiaoji.getText().toString().equals("0") && etXiaoji1.getText().toString().equals("0")) {
            Toast.makeText(this, "无害化处理病害生猪或无害化处理病害生猪产品不能为:0", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(etMane.getText().toString())) {
            Toast.makeText(this, "屠宰场名不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!new File(PhotoUtil.getWuHaiHuaDir(), uuid + "signCheck.jpeg").exists() || imgZhanzhang.getDrawable() == null) {
            Toast.makeText(this, "兽医签字不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (deadanimalsIvDeathPoultry1.getDrawable() == null && deadanimalsIvDeathPoultry2.getDrawable() == null
                && deadanimalsIvDeathPoultry3.getDrawable() == null && deadanimalsIvDeathPoultry4.getDrawable() == null) {
            Toast.makeText(this, "图片留档至少要有一张图片", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }


    //设置图片
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != 100) {
            File path = new File(PhotoUtil.getWuHaiHuaDir(), uuid + PhotoUtil.DEFAULT_FILE_NAME + requestCode + PhotoUtil.FILE_POSTFIX);
            bitmap = PictureUtils.decodeSampleBitmapFromFile(path.getAbsolutePath(), TakePictureUtil.DEFAULT_WIDTH,
                    TakePictureUtil.DEFAULT_HEIGHT);
//            PhotoUtils.saveBitmap(path.getAbsolutePath(), bitmap);
        }


        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Bitmap bitmap1 = decodeSampleBitmapFromFile(compressBmpToFile(file1.getAbsolutePath()));
                try {
                    deadanimalsIvDeathPoultry1.setImageBitmap(bitmap1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                Bitmap bitmap2 = decodeSampleBitmapFromFile(compressBmpToFile(file2.getAbsolutePath()));
                try {
                    deadanimalsIvDeathPoultry2.setImageBitmap(bitmap2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode == 3) {
            if (resultCode == Activity.RESULT_OK) {
                Bitmap bitmap3 = decodeSampleBitmapFromFile(compressBmpToFile(file3.getAbsolutePath()));
                try {
                    deadanimalsIvDeathPoultry3.setImageBitmap(bitmap3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode == 4) {
            if (resultCode == Activity.RESULT_OK) {
                Bitmap bitmap4 = decodeSampleBitmapFromFile(compressBmpToFile(file4.getAbsolutePath()));
                try {
                    deadanimalsIvDeathPoultry4.setImageBitmap(bitmap4);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (requestCode == 100) {
            if (data != null) {
                WuHaIHuaAddBean.DataListBean dataList = (WuHaIHuaAddBean.DataListBean) data.getSerializableExtra(Contance.ACTIVITY_DATA);

                etShixian.setText(dataList.getShiName());
                etQuxian.setText(dataList.getUnitName());
                etMane.setText(dataList.getSName());
                etMan.setText(dataList.getSCorporateRe());
                etPhone.setText(dataList.getSTel());
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            //申请WRITE_EXTERNAL_STORAGE权限  
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
        switch (v.getId()) {
            //病死畜禽照片
            case R.id.deadanimals_rl_deathPoultry1:
                PhotoUtil.takePictureWuHaiHua(WuHaiHuaActivity.this, 1, uuid);
                file1 = PhotoUtil.getPictureWuhaihua(1, uuid);
                break;
            case R.id.deadanimals_rl_deathPoultry2:
                PhotoUtil.takePictureWuHaiHua(WuHaiHuaActivity.this, 2, uuid);
                file2 = PhotoUtil.getPictureWuhaihua(2, uuid);
                break;
            case R.id.deadanimals_rl_deathPoultry3:
                PhotoUtil.takePictureWuHaiHua(WuHaiHuaActivity.this, 3, uuid);
                file3 = PhotoUtil.getPictureWuhaihua(3, uuid);
                break;
            case R.id.deadanimals_rl_deathPoultry4:
                PhotoUtil.takePictureWuHaiHua(WuHaiHuaActivity.this, 4, uuid);
                file4 = PhotoUtil.getPictureWuhaihua(4, uuid);
                break;
            //签名
            case R.id.bt_shouyiqianming:
                new CcWriteDiolog(WuHaiHuaActivity.this, new DialogListener() {
                    @Override
                    public void refreshActivity(final Object object) {
                        //存入对象中
//                        entity.setFInspectSign(PictureUtils.getPictureStr((Bitmap) object));
                        //存储至本地
                        new Thread() {
                            @Override
                            public void run() {
                                signCheckFile = new File(storeTableDir, uuid + "signCheck" + TakePictureUtil.FILE_POSTFIX);
                                if (signCheckFile.exists()) signCheckFile.delete();
                                PictureUtils.saveBitmap(signCheckFile.getAbsolutePath(), (Bitmap) object);
                            }
                        }.start();
                        imgZhanzhang.setImageBitmap((Bitmap) object);
                    }
                }).show();
                break;
            //上传
            case R.id.bt_que:
                if (judge()) {
                    getPresenter().getInfo(getDeclareInfo(), uuid);
                }
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    public String isEmpty(EditText edt) {
        if (TextUtils.isEmpty(edt.getText().toString())) {
            return "0";
        } else {
            return edt.getText().toString();
        }
    }

}

