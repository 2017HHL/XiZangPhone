package com.mingnong.xizangphone.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.ProductAUploadBean;
import com.mingnong.xizangphone.bean.QueryProductABean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.ITuZaiJianYiXingQActivity;
import com.mingnong.xizangphone.presenter.TuZaiJianYiXingQActivityP;
import com.mingnong.xizangphone.utils.BorisPrint;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.PrintView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TuZaiJianYiXingQActivity extends MVPActivity<TuZaiJianYiXingQActivityP> implements ITuZaiJianYiXingQActivity {

    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.et_tuzaimingc)
    TextView etTuzaimingc;
    @BindView(R.id.et_shenbaodan)
    TextView etShenbaodan;
    @BindView(R.id.et_huozhu)
    TextView etHuozhu;
    @BindView(R.id.et_lianxidihua)
    TextView etLianxidihua;
    @BindView(R.id.et_dongwuchanp1)
    TextView etDongwuchanp1;
    @BindView(R.id.et_dongwuchanp2)
    TextView etDongwuchanp2;
    @BindView(R.id.et_dongwuchanp3)
    TextView etDongwuchanp3;
    @BindView(R.id.et_shuliang)
    TextView etShuliang;
    @BindView(R.id.et_danwei)
    TextView etDanwei;
    @BindView(R.id.et_yongtu)
    TextView etYongtu;
    @BindView(R.id.et_shijian1)
    TextView etShijian1;
    @BindView(R.id.et_shijian2)
    TextView etShijian2;
    @BindView(R.id.et_laiyuan)
    TextView etLaiyuan;
    @BindView(R.id.et_qiyun1)
    TextView etQiyun1;
    @BindView(R.id.et_qiyun2)
    TextView etQiyun2;
    @BindView(R.id.et_qiyun3)
    TextView etQiyun3;
    @BindView(R.id.et_qiyun4)
    TextView etQiyun4;
    @BindView(R.id.et_daoda1)
    TextView etDaoda1;
    @BindView(R.id.et_daoda2)
    TextView etDaoda2;
    @BindView(R.id.et_daoda3)
    TextView etDaoda3;
    @BindView(R.id.et_daoda4)
    TextView etDaoda4;
    @BindView(R.id.et_shenbaojieg)
    TextView etShenbaojieg;
    @BindView(R.id.et_shoulididian)
    TextView etShoulididian;
    @BindView(R.id.et_liyou)
    TextView etLiyou;
    @BindView(R.id.et_shijian3)
    TextView etShijian3;
    @BindView(R.id.et_jilushijian)
    TextView etJilushijian;
    @BindView(R.id.et_jingbanren)
    TextView etJingbanren;
    @BindView(R.id.et_lianxidihua2)
    TextView etLianxidihua2;
    @BindView(R.id.et_beizhu)
    TextView etBeizhu;
    @BindView(R.id.bt_daying)
    Button btDaying;
    private ProductAUploadBean uploadBean;
    private QueryProductABean.DataListBean dataListBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_zai_jian_yi_xing_q);
        ButterKnife.bind(this);
    }

    @Override
    protected TuZaiJianYiXingQActivityP createPresenter() {
        return new TuZaiJianYiXingQActivityP(this);
    }

    @Override
    public void bindData() {
        tvTitle.setText("屠宰检疫申报单");
        dataListBean = (QueryProductABean.DataListBean) getIntent().getSerializableExtra(Contance.ACTIVITY_DATA);
        etShenbaodan.setText(dataListBean.getPNUMBER());//编号
        etHuozhu.setText(dataListBean.getPCARGOOWNER());//货主
        etLianxidihua.setText(dataListBean.getPPHONE());//联系电话
        etDongwuchanp1.setText(dataListBean.getPNAME());//产品名称
        etDongwuchanp2.setText(dataListBean.getPQUANTITY() + "");//数量
        etDongwuchanp3.setText(dataListBean.getPDANWEI());//单位-只/个
        etShuliang.setText(dataListBean.getPUNITNAME());//生产单位名称
        etDanwei.setText(dataListBean.getPPRODUCTIONUNIT());//生产单位地址
        etYongtu.setText(dataListBean.getPMEMO2());//目的地
        etShijian1.setText(dataListBean.getPCARRIER());//承运人
        etShijian2.setText(dataListBean.getPPHONECYR());//联系电话
        etShijian3.setText(dataListBean.getPTRADEMARK());//运载工具牌号
        etJilushijian.setText(dataListBean.getPDISINFECTION());//装运前消毒方式
        etLaiyuan.setText(dataListBean.getPYUNZAI());//运载方式
        etQiyun1.setText(dataListBean.getPYOUXIAORI() + "");//有效到达日
        etQiyun2.setText(dataListBean.getPMEMO1());//备注
        etQiyun3.setText(dataListBean.getPVETERINARY());//官方兽医签字
        etQiyun4.setText(dataListBean.getPDWPHONE());//动物卫生监督所联系电话
        etDaoda1.setText(dataListBean.getDATEQF());//签发日期
        etDaoda2.setText(dataListBean.getDATEQF());//签发日期
        etDaoda3.setText(dataListBean.getDATEQF());//签发日期
        etDaoda4.setText(dataListBean.getDATEQF());//签发日期
        etShenbaojieg.setText(dataListBean.getDATEQF());//签发日期
        etShoulididian.setText(dataListBean.getDATEQF());//签发日期
        etLiyou.setText(dataListBean.getDATEQF());//签发日期
        etJingbanren.setText(dataListBean.getDATEQF());//签发日期
        etLianxidihua2.setText(dataListBean.getDATEQF());//签发日期
        etBeizhu.setText(dataListBean.getDATEQF());//签发日期
    }

    @Override
    public void bindListener() {

    }
    public ProductAUploadBean getData() {
//        uploadBean = new ProductAUploadBean();
//        uploadBean.setPNumber(etQuarantineNo.getText().toString());//编号
//        uploadBean.setPCargoOwner(etUserName.getText().toString());//货主
//        uploadBean.setPPhone(etUserPhone.getText().toString());//电话
//        uploadBean.setPName(etProductName.getText().toString());//产品名称
//        uploadBean.setPQuantity(etProductCount.getText().toString());//数量
//        uploadBean.setPUnitName(etStartName.getText().toString());//生产单位名称
//        uploadBean.setPProductionunit(etStartPlace.getText().toString());//生产单位地址
//        uploadBean.setPSheng(dataListBean.getPSHENG());//省-市/州
//        uploadBean.setPShi(dataListBean.getPSHI());//市-州
//        uploadBean.setPXian(dataListBean.getPXIAN());//县-市/区
//        uploadBean.setPCarrier(etCarrierName.getText().toString());//承运人
//        uploadBean.setPPhoneCyr(etCarrierPhone.getText().toString());//联系电话
//        uploadBean.setPTrademark(etCarrierUtilNumber.getText().toString());//运载工具牌号
//        uploadBean.setPDisinfection(etSteriallierMethod.getText().toString());//装运前消毒方式
//        uploadBean.setPYouXiaoRi(Integer.parseInt(dataListBean.getPYOUXIAORI() + ""));//有效到达日
//        uploadBean.setPVeterinary(etSignatureChecked.getText().toString());//官方兽医签字
//        uploadBean.setPDwPhone(etCheckPhone.getText().toString());//动物卫生监督所联系电话
//        uploadBean.setPDanWei(dataListBean.getPDANWEI());//单位-只/个
//        uploadBean.setPYunZai(dataListBean.getPYUNZAI());   //运载方式
//        uploadBean.setDateQF(tvProveTime.getText().toString());//签发日期
//        uploadBean.setPMemo1(etRemark.getText().toString());//备注
//        uploadBean.setPMemo2(dataListBean.getPMEMO2());//目的地
//        uploadBean.setPMemo3(dataListBean.getPXIAN());//保存-县/市/区
//        uploadBean.setPMemo4(etStartName.getText().toString() + etStartPlace.getText().toString());//生产单位名称及地址
//        uploadBean.setIsPrant("保存");//状态:保存/打印/报废
//        uploadBean.setSaveId(1);//数据的自增Id
//        uploadBean.setPDiDian(dataListBean.getPDIDIAN());//县区市后详细地点
//        uploadBean.setUploadType(1);//上传标识符:0未上传,1已上传
//        uploadBean.setUploadTypeSheng(1);//上传标识符:0未上传,1已上传（区分省上传记录）
//        uploadBean.setPSheng(dataListBean.getPSHENG());
//        uploadBean.setPShi(dataListBean.getPSHI());
//        uploadBean.setPXian(dataListBean.getPXIAN());
        return uploadBean;
    }
    @OnClick(R.id.bt_daying)
    public void onViewClicked() {
        init();
    }
    private void init() {
        BorisPrint bPrint = new BorisPrint(MyApplication.getContext(), null);
        File file3 = new File(FileUtil.getInstance().getCacheDirPath(), "product1.jpg");
        if (file3.exists()) file3.delete();
        PrintView<ProductAUploadBean> printView3 = new PrintView<>(this, getData());
        String path3 = FileUtil.getInstance().save2Local(printView3.getcacheBitmap(), file3.getAbsolutePath());
        bPrint.print(path3, 2);
    }
}
