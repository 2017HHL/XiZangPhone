package com.mingnong.xizangphone.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.QueryTuZaiBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IQuerDetilTuZaiActivity;
import com.mingnong.xizangphone.presenter.QueryDetilTuZaiPresnter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QueryDetilTuZaiActivity extends MVPActivity<QueryDetilTuZaiPresnter> implements IQuerDetilTuZaiActivity {

    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.name_tuzaichang)
    TextView nameTuzaichang;
    @BindView(R.id.number_shenbao)
    TextView numberShenbao;
    @BindView(R.id.tv_huozhu)
    TextView tvHuozhu;
    @BindView(R.id.lianxidianhua1)
    TextView lianxidianhua1;
    @BindView(R.id.tv_dongwuzhonglei)
    TextView tvDongwuzhonglei;
    @BindView(R.id.tv_shuliang)
    TextView tvShuliang;
    @BindView(R.id.tv_shuoliangdanwei)
    TextView tvShuoliangdanwei;
    @BindView(R.id.tv_zhunzaishu)
    TextView tvZhunzaishu;
    @BindView(R.id.tv_zhunzaishudanwei)
    TextView tvzhunzaishudanwei;
    @BindView(R.id.tv_yongtu)
    TextView tvYongtu;
    @BindView(R.id.tv_shijian1)
    TextView tvShijian1;
    @BindView(R.id.tv_shijian2)
    TextView tvShijian2;
    @BindView(R.id.tv_laiyuan)
    TextView tvLaiyuan;
    @BindView(R.id.tv_qiyundidian)
    TextView tvQiyundidian;
    @BindView(R.id.tv_daoda_other1)
    TextView tvDaodaOther1;
    @BindView(R.id.tv_shoulijieguo)
    TextView tvShoulijieguo;
    @BindView(R.id.tv_shoulididian)
    TextView tvShoulididian;
    @BindView(R.id.tv_liyou)
    TextView tvLiyou;
    @BindView(R.id.tv_jianyiriqi)
    TextView tvJianyiriqi;
    @BindView(R.id.tv_jiluriqi)
    TextView tvJiluriqi;
    @BindView(R.id.tv_jingbanren)
    TextView tvJingbanren;
    @BindView(R.id.tv_lianxidianhua)
    TextView tvLianxidianhua;
    @BindView(R.id.tv_beizhu)
    TextView tvBeizhu;
    @BindView(R.id.bt_shangchuan)
    Button btShangchuan;
    private QueryTuZaiBean.DataListBean bean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_detil_tu_zai);
        ButterKnife.bind(this);
    }

    @Override
    protected QueryDetilTuZaiPresnter createPresenter() {
        return new QueryDetilTuZaiPresnter(this);
    }

    @Override
    public void bindData() {
        setTitle("屠宰检疫查询详情");
        bean= ((QueryTuZaiBean.DataListBean) getIntent().getSerializableExtra(Contance.ACTIVITY_DATA));
        nameTuzaichang.setText(bean.getM2());
        numberShenbao.setText(bean.getQNUMBER());
        tvHuozhu.setText(bean.getQCARGOOWNER());
        lianxidianhua1.setText(bean.getQPHONE());
        tvDongwuzhonglei.setText(bean.getQXUZHONG());
        tvShuliang.setText(bean.getQQUANTITY());
        tvShuoliangdanwei.setText(bean.getQDANWEI());
        tvZhunzaishu.setText(bean.getQZZS());
        tvzhunzaishudanwei.setText(bean.getQZZSDW());
        tvYongtu.setText(bean.getQYONGTU());
        tvShijian1.setText(bean.getDATEQF());
        tvShijian2.setText(bean.getDATEQY());
        tvLaiyuan.setText(bean.getQSOURCE());
        tvQiyundidian.setText(bean.getPMEMO3());
        tvDaodaOther1.setText(bean.getPMEMO4());
        tvShoulijieguo.setText(bean.getQACCEPTED());
        tvShoulididian.setText(bean.getQADDRESS());
        tvLiyou.setText(bean.getQLIYOU());
        tvJianyiriqi.setText(bean.getTIME());
        tvJiluriqi.setText(bean.getCTIME());
        tvJingbanren.setText(bean.getQATTN());
        tvBeizhu.setText(bean.getQBZ());
    }

    @Override
    public void bindListener() {

    }
}
