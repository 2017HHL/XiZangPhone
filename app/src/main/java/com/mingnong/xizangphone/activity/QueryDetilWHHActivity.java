package com.mingnong.xizangphone.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.bean.QueryWHHBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.presenter.BaseActivityPresenter;
import com.mingnong.xizangphone.runnable.NetClient;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/23.
 */
public class QueryDetilWHHActivity extends MVPActivity {

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
    @BindView(R.id.deadanimals_iv_deathPoultry2)
    ImageView deadanimalsIvDeathPoultry2;
    @BindView(R.id.deadanimals_iv_deathPoultry3)
    ImageView deadanimalsIvDeathPoultry3;
    @BindView(R.id.deadanimals_iv_deathPoultry4)
    ImageView deadanimalsIvDeathPoultry4;
    @BindView(R.id.bt_shouyiqianming)
    Button btShouyiqianming;
    @BindView(R.id.img_zhanzhang)
    ImageView imgZhanzhang;
    private QueryWHHBean.DataListBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whh_detil_activity);
        ButterKnife.bind(this);
    }

    @Override
    protected BaseActivityPresenter createPresenter() {
        return null;
    }

    @Override
    public void bindData() {
        setTitle("无害化查询详情");
        bean = (QueryWHHBean.DataListBean) getIntent().getSerializableExtra(Contance.ACTIVITY_DATA);


        etShixian.setText(bean.getFCTIYNAME());//市地名
        etQuxian.setText(bean.getFCOUNTYNAME());//区县名
        etDate.setText(bean.getFDEALDATE());//时间
        etMane.setText(bean.getSLAUGHTNAME());//屠宰场名称
        etMan.setText(bean.getFLEGALNAME());//法人代表
        etPhone.setText(bean.getFLEGALPHONE());//电话

        etXiaoji.setText(bean.getFSUMNUM());//小计
        etHuazhi.setText(bean.getFHARMHZNUM());//化制 高温
        etGaowen.setText(bean.getFHIGHTTEMPERATURENUM());//高温  深埋
        etShenmai.setText(bean.getFBURIEDDEEPNUM());//深埋  焚烧
        etFenshao.setText(bean.getFBURNNUM());//焚烧  化学处理
        etHuaxuechuli.setText(bean.getFHXDEALNUM());//化学处理  其他
        etQita.setText(bean.getFOTHERNUM());//其他

        etXiaoji1.setText(bean.getFPRODUCTSUM());//小计
        etHuazhi1.setText(bean.getFPRODUCTHZNUM());//化制
        etGaowen1.setText(bean.getFPRODUCTGWNUM());//高温
        etShenmai1.setText(bean.getFPRODUCTSMNUM());//深埋
        etFenshao1.setText(bean.getFPRODUCTFSNUM());//焚烧
        etHuaxuechuli1.setText(bean.getFPRODUCTHXNUM());//化学处理
        etQita1.setText(bean.getFPRODUCTOTHERNUM());//其他

        Glide.with(this).load(bean.getFPICTUREONE()).into((deadanimalsIvDeathPoultry1));
        Glide.with(this).load(bean.getFPICTURETWO()).into((deadanimalsIvDeathPoultry2));
        Glide.with(this).load(bean.getFPICTURETHREE()).into((deadanimalsIvDeathPoultry3));
        Glide.with(this).load(bean.getFPICTUREFOUR()).into((deadanimalsIvDeathPoultry4));//第四张图片格式不对
        Glide.with(this).load(bean.getFVETERINARY()).into((imgZhanzhang));


    }

    @Override
    public void bindListener() {

    }
}
