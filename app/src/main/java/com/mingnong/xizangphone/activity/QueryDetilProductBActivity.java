package com.mingnong.xizangphone.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.ProductBUploadBean;
import com.mingnong.xizangphone.bean.QueryProductBBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IQueryDetilProductBActivity;
import com.mingnong.xizangphone.presenter.QueryDetilProductBActivityPresenter;
import com.mingnong.xizangphone.utils.BorisPrint;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.PrintView;

import java.io.File;

import butterknife.BindView;

public class QueryDetilProductBActivity extends MVPActivity<QueryDetilProductBActivityPresenter> implements IQueryDetilProductBActivity {


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
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.et_product_name)
    TextView etProductName;
    @BindView(R.id.et_anim_count)
    TextView etAnimCount;
    @BindView(R.id.tv_product_danwei)
    TextView tvProductDanwei;
    @BindView(R.id.et_dizhi)
    TextView etDizhi;
    @BindView(R.id.et_start_place)
    TextView etStartPlace;
    @BindView(R.id.et_product_area)
    TextView etProductArea;
    @BindView(R.id.et_end_place)
    TextView etEndPlace;
    @BindView(R.id.et_quarantine_flag_no)
    TextView etQuarantineFlagNo;
    @BindView(R.id.et_remark)
    TextView etRemark;
    @BindView(R.id.et_signature_checked)
    TextView etSignatureChecked;
    @BindView(R.id.tv_prove_time)
    TextView tvProveTime;
    @BindView(R.id.bt_baocun)
    Button btBaocun;
    private ProductBUploadBean uploadBean;
    private QueryProductBBean.DataListBean dataListBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_detil_production_b);
    }

    @Override
    protected QueryDetilProductBActivityPresenter createPresenter() {
        return new QueryDetilProductBActivityPresenter(this);
    }

    @Override
    public void bindData() {

        tvTitle.setText("产品B查询详情");
        dataListBean = (QueryProductBBean.DataListBean) getIntent().getSerializableExtra(Contance.ACTIVITY_DATA);
        etQuarantineNo.setText(dataListBean.getPBNUMBER());//编号
        etUserName.setText(dataListBean.getPBCARGOOWNER());//货主
        etProductName.setText(dataListBean.getPBNAME());//产品名称
        etAnimCount.setText(dataListBean.getPBQUANTITY() + "");//数量
        tvProductDanwei.setText(dataListBean.getPBDANWEI());//单位:至/个
        etDizhi.setText(dataListBean.getPBPRODUCTIONUNIT());//生产单位地址
        etStartPlace.setText(dataListBean.getPBUNITNAME());//生产单位名称
        etProductArea.setText(dataListBean.getPBORIGIN());//产地
        etEndPlace.setText(dataListBean.getPBDESTINATIONS());//目的地
        etQuarantineFlagNo.setText(dataListBean.getPBSIGN());//检疫标志号
        etRemark.setText(dataListBean.getPBHZNUMBER());//文档未说明，暂时定位备注
        etSignatureChecked.setText(dataListBean.getPBVETERINARY());//官方兽医签字
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

    public ProductBUploadBean getData() {
        uploadBean = new ProductBUploadBean();
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
        uploadBean.setPBDanWei(dataListBean.getPBDANWEI());//单位:至/个
        uploadBean.setIsPrant("0");//状态:0未打印,1打印默认0
        uploadBean.setSaveId(1);//自增ID
//        uploadBean.setPBYouXiaoRi();//有效到达日界面没有
        uploadBean.setPBHzNumber(etRemark.getText().toString());//文档没有解暂时当备注
        uploadBean.setUploadType(1);//上传标识符:0未上传,1已上传
        uploadBean.setUploadTypeSheng(1);//上传标识符:0未上传,1已上传（区分省上传记录）
        uploadBean.setDateQF(tvProveTime.getText().toString());//签发日期
        return uploadBean;
    }

    private void init() {
        BorisPrint bPrint = new BorisPrint(MyApplication.getContext(), null);
        File file3 = new File(FileUtil.getInstance().getCacheDirPath(), "product2.jpg");
        if (file3.exists()) file3.delete();
        PrintView<ProductBUploadBean> printView3 = new PrintView<>(this, getData());
        String path3 = FileUtil.getInstance().save2Local(printView3.getcacheBitmap(), file3.getAbsolutePath());
        bPrint.print(path3, 2);
    }
}
