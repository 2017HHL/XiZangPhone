package com.mingnong.xizangphone.activity;


import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.AnimAUploadBean;
import com.mingnong.xizangphone.bean.AnimBUploadBean;
import com.mingnong.xizangphone.bean.ProductAUploadBean;
import com.mingnong.xizangphone.bean.ProductBUploadBean;
import com.mingnong.xizangphone.dao.Animal_A;
import com.mingnong.xizangphone.dao.Animal_B;
import com.mingnong.xizangphone.dao.Product_A;
import com.mingnong.xizangphone.dao.Product_B;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IPrintAcitivty;
import com.mingnong.xizangphone.presenter.PrintAcitivtyPresenter;
import com.mingnong.xizangphone.utils.BorisPrint;
import com.mingnong.xizangphone.utils.FileUtil;
import com.mingnong.xizangphone.utils.OtherUtil;
import com.mingnong.xizangphone.utils.PrintView;

import java.io.File;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * 打印页面
 */
public class PrintAcitivty extends MVPActivity<PrintAcitivtyPresenter> implements IPrintAcitivty {

    @BindView(R.id.bt_print)
    Button btPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_acitivty);
    }

    @Override
    protected PrintAcitivtyPresenter createPresenter() {
        return new PrintAcitivtyPresenter(this);
    }

    @Override
    public void bindData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) return;
        switch (bundle.getString(Contance.START_ACTIVITY_TYPE, "")) {
            case Contance.TYPE_PRINT_ANIM_A:
                setTitle("动物A证打印");
                break;
            case Contance.TYPE_PRINT_ANIM_B:
                setTitle("动物B证打印");
                break;
            case Contance.TYPE_PRINT_PRODUCT_A:
                setTitle("产品A证打印");
                break;
            case Contance.TYPE_PRINT_PRODUCT_B:
                setTitle("产品B证打印");
                break;
            default:
                Toast.makeText(this, "数据错误", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void bindListener() {
//        RxView.clicks(btPrint).throttleFirst(500, TimeUnit.MILLISECONDS)
//                .subscribe(aVoid -> {
//                    if (!TextUtils.isEmpty(getPresenter().getMachineNumber())&&
//                            !TextUtils.isEmpty(getPresenter().getSerialNumber())) {
//                        //直接打印
//                        printer();
//                    } else {
//                        //打开对话框
//                        createDialog().show();
//                    }
//                    printer();
//                });

        btPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printer();
            }
        });
    }

    /**
     * 打开输入打印机编号的对话框
     */
    public AlertDialog createDialog() {
        // 使用自己的布局文件
        LayoutInflater factory = LayoutInflater.from(this);
        // 关联布局
        final View textEntryView = factory.inflate(R.layout.printer, null);
        EditText printer = (EditText) textEntryView.findViewById(R.id.printerNo);
        return new AlertDialog.Builder(this).setTitle("输入打印机的出厂编号")
                .setView(textEntryView)
                .setMessage("不要*符号，从英文字母开始输入!")
                .setPositiveButton("确定", (dialog, which) -> {
                    if (TextUtils.isEmpty(OtherUtil.toString(printer))
                            || OtherUtil.toString(printer).length() < 8) {
                        getPresenter().saveMachineNumber("");
                        Toast.makeText(this, "请正确的打印机编号,在机器的下方", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //保存
                    getPresenter().saveMachineNumber(OtherUtil.toString(printer));
                    //上传
                    getPresenter().upload();
                    //打印
                    printer();
                }).create();
    }

    /**
     *
     */
    private void printer() {
        BorisPrint bPrint = new BorisPrint(this, null);
//        BorisPrint bPrint = new BorisPrint(this, new BorisPrint.OnFindPrinterListener() {
//            @Override
//            public boolean doSomething(String serialNumber) {
////                serialNumber -> {
//                getPresenter().saveSerialNumber(serialNumber);
//                    if (TextUtils.isEmpty(getPresenter().getMachineNumber()))
//                        return false;
//
//                    if (TextUtils.isEmpty(getPresenter().getSerialNumber())
//                            || !getPresenter().getSerialNumber().equals(serialNumber)) {
//                        //弹出对话框重新输入
//                        getPresenter().saveMachineNumber("");
////                        createDialog().show();
//                        return false;
//                    }
//                    return true;
////                }
//            }
//        });
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) return;
        switch (bundle.getString(Contance.START_ACTIVITY_TYPE, "")) {
            case Contance.TYPE_PRINT_ANIM_A:
                File file1 = new File(FileUtil.getInstance().getCacheDirPath(), "anim1.jpg");
                if (file1.exists()) file1.delete();
                AnimAUploadBean bean1 = (AnimAUploadBean) bundle.getSerializable(Contance.START_ACTIVITY_DATA);
                PrintView<AnimAUploadBean> printView1 = new PrintView<>(this, bean1);
                String path1 = FileUtil.getInstance().save2Local(printView1.getcacheBitmap(), file1.getAbsolutePath());
                bPrint.print(path1, 2);
                break;
            case Contance.TYPE_PRINT_ANIM_B:
                File file2 = new File(FileUtil.getInstance().getCacheDirPath(), "anim2.jpg");
                if (file2.exists()) file2.delete();
                AnimBUploadBean bean2 = (AnimBUploadBean) bundle.getSerializable(Contance.START_ACTIVITY_DATA);
                PrintView<AnimBUploadBean> printView2 = new PrintView<>(this, bean2);
                String path2 = FileUtil.getInstance().save2Local(printView2.getcacheBitmap(), file2.getAbsolutePath());
                bPrint.print(path2, 1);
                break;
            case Contance.TYPE_PRINT_PRODUCT_A:
                File file3 = new File(FileUtil.getInstance().getCacheDirPath(), "product1.jpg");
                if (file3.exists()) file3.delete();
                ProductAUploadBean bean3 = (ProductAUploadBean) bundle.getSerializable(Contance.START_ACTIVITY_DATA);
                PrintView<ProductAUploadBean> printView3 = new PrintView<>(this, bean3);
                String path3 = FileUtil.getInstance().save2Local(printView3.getcacheBitmap(), file3.getAbsolutePath());
                bPrint.print(path3, 2);
                break;
            case Contance.TYPE_PRINT_PRODUCT_B:
                File file4 = new File(FileUtil.getInstance().getCacheDirPath(), "product2.jpg");
                if (file4.exists()) file4.delete();
                ProductBUploadBean bean4 = (ProductBUploadBean) bundle.getSerializable(Contance.START_ACTIVITY_DATA);
                PrintView<ProductBUploadBean> printView4 = new PrintView<>(this, bean4);
                String path4 = FileUtil.getInstance().save2Local(printView4.getcacheBitmap(), file4.getAbsolutePath());
                bPrint.print(path4, 1);
                break;
            default:
                Toast.makeText(this, "数据错误", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
