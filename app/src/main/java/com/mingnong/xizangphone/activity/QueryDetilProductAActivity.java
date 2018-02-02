package com.mingnong.xizangphone.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.ProductAUploadBean;
import com.mingnong.xizangphone.bean.QueryProductABean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IQueryDetilProductAActivity;
import com.mingnong.xizangphone.presenter.QueryDetilProductAActivityPresenter;
import com.mingnong.xizangphone.utils.BorisPrint;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.PrintView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QueryDetilProductAActivity extends MVPActivity<QueryDetilProductAActivityPresenter> implements IQueryDetilProductAActivity {
    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.et_quarantine_no)
    TextView etQuarantineNo;
    @BindView(R.id.et_user_name)
    TextView etUserName;
    @BindView(R.id.et_user_phone)
    TextView etUserPhone;
    @BindView(R.id.et_product_name)
    TextView etProductName;
    @BindView(R.id.et_product_count)
    TextView etProductCount;
    @BindView(R.id.tv_product_danwei)
    TextView tvProductDanwei;
    @BindView(R.id.et_start_name)
    TextView etStartName;
    @BindView(R.id.et_start_place)
    TextView etStartPlace;
    @BindView(R.id.et_end_place)
    TextView etEndPlace;
    @BindView(R.id.et_carrier_name)
    TextView etCarrierName;
    @BindView(R.id.et_carrier_phone)
    TextView etCarrierPhone;
    @BindView(R.id.et_carrier_util_number)
    TextView etCarrierUtilNumber;
    @BindView(R.id.et_steriallier_method)
    TextView etSteriallierMethod;
    @BindView(R.id.et_transportation)
    TextView etTransportation;
    @BindView(R.id.tv_youxiaodaodari)
    TextView tvYouxiaodaodari;
    @BindView(R.id.et_remark)
    TextView etRemark;
    @BindView(R.id.et_signature_checked)
    TextView etSignatureChecked;
    @BindView(R.id.et_check_phone)
    TextView etCheckPhone;
    @BindView(R.id.tv_prove_time)
    TextView tvProveTime;
    @BindView(R.id.bt_baocun)
    Button btBaocun;
    private ProductAUploadBean uploadBean;
    private QueryProductABean.DataListBean dataListBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_detil_product_a);
        ButterKnife.bind(this);
    }

    @Override
    protected QueryDetilProductAActivityPresenter createPresenter() {
        return new QueryDetilProductAActivityPresenter(this);
    }

    @Override
    public void bindData() {
        tvTitle.setText("产品A查询详情");
        dataListBean = (QueryProductABean.DataListBean) getIntent().getSerializableExtra(Contance.ACTIVITY_DATA);
        etQuarantineNo.setText(dataListBean.getPNUMBER());//编号
        etUserName.setText(dataListBean.getPCARGOOWNER());//货主
        etUserPhone.setText(dataListBean.getPPHONE());//联系电话
        etProductName.setText(dataListBean.getPNAME());//产品名称
        etProductCount.setText(dataListBean.getPQUANTITY() + "");//数量
        tvProductDanwei.setText(dataListBean.getPDANWEI());//单位-只/个
        etStartName.setText(dataListBean.getPUNITNAME());//生产单位名称
        etStartPlace.setText(dataListBean.getPPRODUCTIONUNIT());//生产单位地址
        etEndPlace.setText(dataListBean.getPMEMO2());//目的地
        etCarrierName.setText(dataListBean.getPCARRIER());//承运人
        etCarrierPhone.setText(dataListBean.getPPHONECYR());//联系电话
        etCarrierUtilNumber.setText(dataListBean.getPTRADEMARK());//运载工具牌号
        etSteriallierMethod.setText(dataListBean.getPDISINFECTION());//装运前消毒方式
        etTransportation.setText(dataListBean.getPYUNZAI());//运载方式
        tvYouxiaodaodari.setText(dataListBean.getPYOUXIAORI() + "");//有效到达日
        etRemark.setText(dataListBean.getPMEMO1());//备注
        etSignatureChecked.setText(dataListBean.getPVETERINARY());//官方兽医签字
        etCheckPhone.setText(dataListBean.getPDWPHONE());//动物卫生监督所联系电话
        tvProveTime.setText(dataListBean.getDATEQF());//签发日期
    }

    @Override
    public void bindListener() {
        btBaocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
    }

    public ProductAUploadBean getData() {
        uploadBean = new ProductAUploadBean();
        uploadBean.setPNumber(etQuarantineNo.getText().toString());//编号
        uploadBean.setPCargoOwner(etUserName.getText().toString());//货主
        uploadBean.setPPhone(etUserPhone.getText().toString());//电话
        uploadBean.setPName(etProductName.getText().toString());//产品名称
        uploadBean.setPQuantity(etProductCount.getText().toString());//数量
        uploadBean.setPUnitName(etStartName.getText().toString());//生产单位名称
        uploadBean.setPProductionunit(etStartPlace.getText().toString());//生产单位地址
        uploadBean.setPSheng(dataListBean.getPSHENG());//省-市/州
        uploadBean.setPShi(dataListBean.getPSHI());//市-州
        uploadBean.setPXian(dataListBean.getPXIAN());//县-市/区
        uploadBean.setPCarrier(etCarrierName.getText().toString());//承运人
        uploadBean.setPPhoneCyr(etCarrierPhone.getText().toString());//联系电话
        uploadBean.setPTrademark(etCarrierUtilNumber.getText().toString());//运载工具牌号
        uploadBean.setPDisinfection(etSteriallierMethod.getText().toString());//装运前消毒方式
        uploadBean.setPYouXiaoRi(Integer.parseInt(dataListBean.getPYOUXIAORI() + ""));//有效到达日
        uploadBean.setPVeterinary(etSignatureChecked.getText().toString());//官方兽医签字
        uploadBean.setPDwPhone(etCheckPhone.getText().toString());//动物卫生监督所联系电话
        uploadBean.setPDanWei(dataListBean.getPDANWEI());//单位-只/个
        uploadBean.setPYunZai(dataListBean.getPYUNZAI());   //运载方式
        uploadBean.setDateQF(tvProveTime.getText().toString());//签发日期
        uploadBean.setPMemo1(etRemark.getText().toString());//备注
        uploadBean.setPMemo2(dataListBean.getPMEMO2());//目的地
        uploadBean.setPMemo3(dataListBean.getPXIAN());//保存-县/市/区
        uploadBean.setPMemo4(etStartName.getText().toString() + etStartPlace.getText().toString());//生产单位名称及地址
        uploadBean.setIsPrant("保存");//状态:保存/打印/报废
        uploadBean.setSaveId(1);//数据的自增Id
        uploadBean.setPDiDian(dataListBean.getPDIDIAN());//县区市后详细地点
        uploadBean.setUploadType(1);//上传标识符:0未上传,1已上传
        uploadBean.setUploadTypeSheng(1);//上传标识符:0未上传,1已上传（区分省上传记录）
        uploadBean.setPSheng(dataListBean.getPSHENG());
        uploadBean.setPShi(dataListBean.getPSHI());
        uploadBean.setPXian(dataListBean.getPXIAN());
        return uploadBean;
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
