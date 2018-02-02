package com.mingnong.xizangphone.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.epson.isv.eprinterdriver.Common.EpsPrinter;
import com.epson.isv.eprinterdriver.Common.EpsStatus;
import com.epson.isv.eprinterdriver.Ctrl.EPSetting;
import com.epson.isv.eprinterdriver.Ctrl.EPrintManager;
import com.epson.isv.eprinterdriver.Ctrl.EPrintManager.EPRINT_FILETYPE;
import com.epson.isv.eprinterdriver.Ctrl.IPrintListener;
import com.epson.isv.eprinterdriver.Ctrl.ISearchPrinterListener;
import com.epson.isv.eprinterdriver.Ctrl.PageAttribute;
import com.epson.isv.eprinterdriver.Ctrl.PageAttribute.MediaSizeID;
import com.epson.isv.eprinterdriver.Ctrl.PageAttribute.MediaTypeID;
import com.epson.isv.eprinterdriver.Ctrl.PageAttribute.PrintQuality;

/**
 * 打印
 *
 * @author pc1
 */
public class BorisPrint {

    Context context;
    EPrintManager epManager;
    EPSetting setting;
    String imagePath;
    int a = 1;


    @SuppressLint("Instantiatable")
    public BorisPrint(Context mycontext, OnFindPrinterListener listener) {
        context = mycontext;
//        File file = new File(MyApplicaition.getContext().getFilesDir(), "/lib/armeabi/libeprinterdriver.so");
//        if (!file.exists()) {
//            CommonUtils.initAssetsFile();
//        }
        init(listener);
    }

    @SuppressLint("SdCardPath")
    public void init(OnFindPrinterListener listener) {
        String libpath = "/data/data/com.mingnong.xizangphone/lib";
        String libname = "libeprinterdriver.so";
        epManager = EPrintManager.instance();
        epManager.initEscprLib(context.getApplicationContext(), libpath,
                libname);
        epManager.addPrintListener(new PrinterListenerImp());
        epManager.addSearchListener(new SearchListenerImp() {
            @Override
            public void onFindPrinter(EpsPrinter printer) {
//                if (!listener.doSomething(printer.getPrinterID())) return;
                if (listener != null && !listener.doSomething(printer.getPrinterID())) return;
                super.onFindPrinter(printer);
            }
        });
        setting = EPSetting.instance();
        PageAttribute epPageAttri = new PageAttribute(MediaSizeID.EPS_MSID_A4,
                MediaTypeID.EPS_MTID_PLAIN, PrintQuality.EPS_MQID_NORMAL);
        setting.setSelPageAttri(epPageAttri);
        setting.setPrintDirection(EPSetting.PRINT_DIR_UNI);
        setting.setColorMode(EPSetting.COLOR_MODE_MONOCHROME);
        setting.setPaperSource(EPSetting.PAPER_SOURCE_NOT_SPEC);
        setting.setBorderless(true);
        setting.setDuplexPrint(false);
        setting.setTotalPages(1);
        setting.setTemporaryImageFilePath(context.getCacheDir().getAbsolutePath() + "/temp.jpg");

    }

    public void print(String ppath, int num) {
        epManager.cancelFindPrinter();
        epManager.cancelPrint();
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        imagePath = ppath;
        a = num;
        epManager.findPrinter(30);
    }

    private class PrinterListenerImp implements IPrintListener {

        @Override
        public void onCleaningTime(int arg0) {

        }

        @Override
        public void onPageFinished(int arg0, int arg1) {
            System.gc();
        }

        @Override
        public void onPrintAutoContinue() {
        }

        @Override
        public void onPrintBegin() {
            System.gc();
        }

        @Override
        public void onPrintFinished(int arg0) {
            System.gc();
            a = a - 1;
            if (a > 0) {
                Toast.makeText(context, "打印第二份", Toast.LENGTH_SHORT).show();
                EPrintManager.instance().startPrint(imagePath, EPRINT_FILETYPE.JPEG);
            } else {
                Toast.makeText(context, "打印完成", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onPrintPause(int arg0, int arg1, EpsStatus arg2) {

        }

        @Override
        public void onPrintResume() {
        }
    }

    private class SearchListenerImp implements ISearchPrinterListener {
        @Override
        public void onFindPrinter(EpsPrinter printer) {
            Toast.makeText(context, "找到打印机", Toast.LENGTH_SHORT).show();
            epManager.cancelFindPrinter();
//            if (EPrintManager.instance().isPrintBusy()) {
//                Toast.makeText(context, "打印机忙．．．", Toast.LENGTH_SHORT).show();
//                return;
//            }
            setting.setSelEpsPrinter(printer);
            Toast.makeText(context, "开始打印内容", Toast.LENGTH_SHORT).show();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            EPrintManager.instance().startPrint(imagePath,
                    EPRINT_FILETYPE.JPEG);
        }

        @Override
        public void onSearchBegin() {
            Toast.makeText(context, "开始查找打印机", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSearchFinished(int arg0) {
            Toast.makeText(context, "打印机查找完成", Toast.LENGTH_SHORT).show();

        }
    }

    public interface OnFindPrinterListener {
        /**
         * 如果返回false 那么不打印
         *
         * @param serialNumber
         * @return
         */
        boolean doSomething(String serialNumber);
    }
}
