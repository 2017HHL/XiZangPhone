package com.mingnong.xizangphone.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.presenter.BaseActivityPresenter;
import com.mingnong.xizangphone.utils.BorisPrint;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.PrintView;

import java.io.File;

import butterknife.BindView;

/**
 * 动物B查询详情
 * Created by Administrator on 2017/5/19.
 */

public class QueryDetilAnimalBActivity extends MVPActivity {


    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.et_jianyizheng_bianhao)
    TextView etJianyizhengBianhao;
    @BindView(R.id.et_huozhu_name)
    TextView etHuozhuName;
    @BindView(R.id.et_huozhu_phone)
    TextView etHuozhuPhone;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.et_animal_type)
    TextView etAnimalType;
    @BindView(R.id.et_animal_leixing)
    TextView etAnimalLeixing;
    @BindView(R.id.et_animal_danwei)
    TextView etAnimalDanwei;
    @BindView(R.id.et_animal_number)
    TextView etAnimalNumber;
    @BindView(R.id.et_animal_yongtu)
    TextView etAnimalYongtu;
    @BindView(R.id.et_qiyun_type)
    TextView etQiyunType;
    @BindView(R.id.et_qiyun_shi)
    TextView etQiyunShi;
    @BindView(R.id.et_qiyun_xian)
    TextView etQiyunXian;
    @BindView(R.id.et_start_village)
    TextView etStartVillage;
    @BindView(R.id.et_start_other)
    TextView etStartOther;
    @BindView(R.id.et_daoda_type)
    TextView etDaodaType;
    @BindView(R.id.et_daoda_shi)
    TextView etDaodaShi;
    @BindView(R.id.et_daoda_xian)
    TextView etDaodaXian;
    @BindView(R.id.et_end_village)
    TextView etEndVillage;
    @BindView(R.id.et_end_other)
    TextView etEndOther;
    @BindView(R.id.tv_erbiao)
    TextView tvErbiao;
    @BindView(R.id.et_signature_checked)
    TextView etSignatureChecked;
    @BindView(R.id.tv_prove_time)
    TextView tvProveTime;
    @BindView(R.id.bt_print)
    Button btPrint;
    private QueryAnimBBean.DataListBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_detil_animal_b);
    }

    @Override
    protected BaseActivityPresenter createPresenter() {
        return null;
    }

    @Override
    public void bindData() {
        setTitle("动物B查询详情");
        bean = (QueryAnimBBean.DataListBean) getIntent().getSerializableExtra(Contance.ACTIVITY_DATA);
        etJianyizhengBianhao.setText(bean.getAQNUMBER());//检疫证编号
        etHuozhuName.setText(bean.getAQCARGOOWNER());//货主
        etHuozhuPhone.setText(bean.getAQPHONE());//联系电话
        etAnimalType.setText(bean.getAQXUZHONG());//动物种类
        etAnimalLeixing.setText(bean.getAQXUZHONG());//动物种类
        etAnimalDanwei.setText(bean.getAQDANWEI());//单位
        etAnimalYongtu.setText(bean.getAQYONGTU());//用途
        etAnimalNumber.setText(bean.getAQQUANTITY() + "");//数量
        etQiyunType.setText(bean.getAQTYPEQY());//起运地类别
        etQiyunShi.setText(bean.getAQSHIQY());//启运市
        etQiyunXian.setText(bean.getAQXIANQY());//启运县
        etStartVillage.setText(bean.getAQXIANGQY());//启运乡
        etStartOther.setText(bean.getAQCUNQY());//启运村
        etDaodaType.setText(bean.getAQTYPEDD());//到达地类别
        etDaodaShi.setText(bean.getAQSHIDD());//到达市
        etDaodaXian.setText(bean.getAQXIANDD());//到达县
        etEndVillage.setText(bean.getAQXIANGDD());//到达乡
        etEndOther.setText(bean.getAQCUNDD());//到达村
        tvErbiao.setText(bean.getAQEARTAG());//耳标号
        etSignatureChecked.setText(bean.getAQVETERINARY());//官方兽医签字
        tvProveTime.setText(bean.getDATEQF());//签发日期
    }

    @Override
    public void bindListener() {
        btPrint.setOnClickListener(v -> {
            init();
        });
    }

    private void init() {
        BorisPrint bPrint = new BorisPrint(MyApplication.getContext(), null);
        File file2 = new File(FileUtil.getInstance().getCacheDirPath(), "anim2.jpg");
        if (file2.exists()) file2.delete();
        PrintView<QueryAnimBBean.DataListBean> printView2 = new PrintView<>(this, bean);
        String path2 = FileUtil.getInstance().save2Local(printView2.getcacheBitmap(), file2.getAbsolutePath());
        bPrint.print(path2, 1);
    }


}
