package com.mingnong.xizangphone.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.QueryAnimABean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.presenter.BaseActivityPresenter;
import com.mingnong.xizangphone.utils.BorisPrint;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.PrintView;

import java.io.File;

import butterknife.BindView;

/**
 * 动物A查询详情
 * Created by Administrator on 2017/5/19.
 */

public class QueryDetilAnimalAActivity extends MVPActivity {

    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.et_jianyi_zhenghao)
    TextView etJianyiZhenghao;
    @BindView(R.id.et_huozhu)
    TextView etHuozhu;
    @BindView(R.id.et_huozhu_lianxiphone)
    TextView etHuozhuLianxiphone;
    @BindView(R.id.et_animal_name)
    TextView etAnimalName;
    @BindView(R.id.et_animal_type)
    TextView etAnimalType;
    @BindView(R.id.et_animal_danwei)
    TextView etAnimalDanwei;
    @BindView(R.id.et_animal_yongtu)
    TextView etAnimalYongtu;
    @BindView(R.id.et_animal_number)
    TextView etAnimalNumber;
    @BindView(R.id.et_qiyun_type)
    TextView etQiyunType;
    @BindView(R.id.et_qiyun_sheng)
    TextView etQiyunSheng;
    @BindView(R.id.et_qiyun_shi)
    TextView etQiyunShi;
    @BindView(R.id.et_qiyun_xian)
    TextView etQiyunXian;
    @BindView(R.id.et_qiyun_xiang)
    TextView etQiyunXiang;
    @BindView(R.id.et_qiyun_other)
    TextView etQiyunOther;
    @BindView(R.id.et_daoda_type)
    TextView etDaodaType;
    @BindView(R.id.et_daoda_sheng)
    TextView etDaodaSheng;
    @BindView(R.id.et_daoda_shi)
    TextView etDaodaShi;
    @BindView(R.id.et_daoda_xian)
    TextView etDaodaXian;
    @BindView(R.id.et_daoda_xiang)
    TextView etDaodaXiang;
    @BindView(R.id.et_daoda_other)
    TextView etDaodaOther;
    @BindView(R.id.et_chengyunren)
    TextView etChengyunren;
    @BindView(R.id.et_chengyunren_lianxiphone)
    TextView etChengyunrenLianxiphone;
    @BindView(R.id.et_yunzai_fangshi)
    TextView etYunzaiFangshi;
    @BindView(R.id.et_yunzai_paihao)
    TextView etYunzaiPaihao;
    @BindView(R.id.et_steriallier_method)
    TextView etSteriallierMethod;
    @BindView(R.id.et_youxiao_daodari)
    TextView etYouxiaoDaodari;
    @BindView(R.id.tv_erbiao)
    TextView tvErbiao;
    @BindView(R.id.et_beizhu)
    TextView etBeizhu;
    @BindView(R.id.et_signature_qianzi)
    TextView etSignatureQianzi;
    @BindView(R.id.et_jiandusuo_phone)
    TextView etJiandusuoPhone;
    @BindView(R.id.tv_prove_time)
    TextView tvProveTime;
    @BindView(R.id.bt_print)
    Button btPrint;

    private QueryAnimABean.DataListBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_detil_animal_a);
    }

    @Override
    protected BaseActivityPresenter createPresenter() {
        return null;
    }

    @Override
    public void bindData() {
        setTitle("动物A查询详情");
        bean = (QueryAnimABean.DataListBean) getIntent().getSerializableExtra(Contance.ACTIVITY_DATA);
        etJianyiZhenghao.setText(bean.getANUMBER());//检疫证号
        etHuozhu.setText(bean.getACARGOOWNER());//货主
        etHuozhuLianxiphone.setText(bean.getAPHONE());//联系电话
        etAnimalName.setText(bean.getAXUZHONG());//动物种类
        etAnimalType.setText(bean.getAXUZHONG());//动物种类
        etAnimalDanwei.setText(bean.getADANWEI());//单位
        etAnimalYongtu.setText(bean.getAYONGTU());//用途
        etAnimalNumber.setText(bean.getAQUANTITY() + "");//数量
        etQiyunType.setText(bean.getATYPEQY());//起运地类别
        etQiyunSheng.setText(bean.getASHENGQY());//启运省
        etQiyunShi.setText(bean.getASHIQY());//启运市
        etQiyunXian.setText(bean.getAXIANQY());//启运县
        etQiyunXiang.setText(bean.getAXIANGQY());//启运乡
        etQiyunOther.setText(bean.getACUNQY());//启运村
        etDaodaType.setText(bean.getATYPEDD());//到达地类别
        etDaodaSheng.setText(bean.getASHENGDD());//到达省
        etDaodaShi.setText(bean.getASHIDD());//到达市
        etDaodaXian.setText(bean.getAXIANDD());//到达县
        etDaodaXiang.setText(bean.getAXIANGDD());//到达乡
        etDaodaOther.setText(bean.getACUNDD());//到达村
        etChengyunren.setText(bean.getACARRIER());//承运人
        etChengyunrenLianxiphone.setText(bean.getAPHONECYR());//承运人联系电话
        etYunzaiFangshi.setText(bean.getAYUNZAI());//运载方式
        etYunzaiPaihao.setText(bean.getATRADEMARK());//运载工具牌号
        etSteriallierMethod.setText(bean.getADISINFECTION());//消毒
        etYouxiaoDaodari.setText(bean.getAYOUXIAORI() + "");//有效到达日
        tvErbiao.setText(bean.getAEARTAG());//耳标号
        etBeizhu.setText(bean.getAMEMO1());//备注
        etSignatureQianzi.setText(bean.getAVETERINARY());//官方兽医签字
        etJiandusuoPhone.setText(bean.getADWPHONE());//动物卫生监督所电话
        tvProveTime.setText(bean.getDATEQF());//签发日期
    }

    @Override
    public void bindListener() {
        btPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
    }

    private void init() {
        BorisPrint bPrint = new BorisPrint(MyApplication.getContext(), null);
        File file1 = new File(FileUtil.getInstance().getCacheDirPath(), "anim1.jpg");
        if (file1.exists()) file1.delete();
        PrintView<QueryAnimABean.DataListBean> printView1 = new PrintView<>(this, bean);
        String path1 = FileUtil.getInstance().save2Local(printView1.getcacheBitmap(), file1.getAbsolutePath());
        bPrint.print(path1, 2);
    }
}
