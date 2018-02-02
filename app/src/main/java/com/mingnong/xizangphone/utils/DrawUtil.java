package com.mingnong.xizangphone.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.bean.AnimAUploadBean;
import com.mingnong.xizangphone.bean.AnimBUploadBean;
import com.mingnong.xizangphone.bean.ProductAUploadBean;
import com.mingnong.xizangphone.bean.ProductBUploadBean;
import com.mingnong.xizangphone.bean.QueryAnimABean;
import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.runnable.NetClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

public class DrawUtil {
    private ChangeLock changeLock = new ChangeLock();
    ;
    private Context context;
    private SharedPreferences pref;
    private Bitmap cachebitmap;
    private Canvas cachecanvas;
    private Paint paint;
    private Paint paint1;
    private String dir = MyApplication.getContext().getExternalFilesDir("").getAbsolutePath();

    private float JsPxValue(double cm) {
        double rv = cm * (96 / 2.54);
        return Float.parseFloat(Double.toString(rv));
    }

    public DrawUtil(Context context) {
        super();
        this.context = context;
        init();

    }

    public void init() {
        cachebitmap = Bitmap.createBitmap(794, 1123, Config.ARGB_8888);
        cachecanvas = new Canvas(cachebitmap);
        cachecanvas.drawColor(Color.WHITE);

        paint = new Paint();
        paint.setAntiAlias(true); // //设置是否使用抗锯齿功能，会消耗较大资源，绘制图形速度会变慢。
        paint.setColor(Color.BLACK);
        paint.setTextSize(10); // 设置绘制文字的字号大小

        // Paint即画笔，在绘图过程中起到了极其重要的作用，画笔主要保存了颜色，
        paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setColor(Color.BLACK);
        paint1.setTextSize(16);

    }

    /**
     * 动物A
     *
     * @param animal_A
     * @return
     */
    public Bitmap Animal_A(AnimAUploadBean animal_A) { // Animal_A animal_A
        // Bitmap cachebitmap1 = Bitmap.createBitmap(794,
        // 1123,Config.ARGB_8888);
        // Canvas cachecanvas1 = newd Canvas(cachebitmap1);
        // cachecanvas1.drawColor(Color.WHITE);
        //X轴  Y轴 宽 高
        writeText(animal_A.getACargoOwner(), 4.3F, 3.77F, 6.9F, 1.2F);    //货主
        //联系电话
        writeText(animal_A.getAPhone(), 14.1F, 3.77F, 5.4F, 1.2F);        //货主电话

//        String request = animal_A.getAnimal_species2().trim();
//        if (request.equals("")) {
//            //动物种类
//            writeText(animal_A.getAnimal_species(), 4.3F, 4.86F, 6.9F, 1.2F);
//        } else {
//            //动物种类
//            writeText(animal_A.getAnimal_species1() + "," + request, 4.3F, 4.86F, 6.9F, 1.2F);
//        }
        //动物种类
        writeText(animal_A.getAXuZhong(), 4.3F, 4.92F, 6.9F, 1.2F);

        //数量及单位
        writeText(changeLock.changeToQuantity_unit(animal_A.getAQuantity() + "")
                + animal_A.getADanWei(), 14.1F, 4.92F, 5.4F, 1.2F);            //数量及单位
        //启运省
        writeText(animal_A.getAShengQy(), 4.3F, 6.35F, 2.6F, 0.9F);            //启运省
        //启运市
        writeText(animal_A.getAShiQy(), 7.4F, 6.35F, 2.5F, 0.9F);            //启运市
        //启运县
        writeText(animal_A.getAXianQy(), 11.4F, 6.35F, 2.5F, 0.9F);        //启运县
        //启运乡
        writeText(animal_A.getAXiangQy(), 16.1F, 6.35F, 2.3F, 0.9F);        // 启运镇
        //村
        writeText(animal_A.getACunQy(), 10F, 7.0F, 4.8F, 0.7F);        //启运村
        String fdfs = animal_A.getATypeQy();                        //起运地类别
        if (fdfs.equals("养殖场")) {        //养殖场
            writeText("√", 16F, 7.1F, 1F, 1F);
        } else if (fdfs.equals("交易市场")) {        //交易市场
            writeText("√", 18.1F, 6.7F, 1F, 1F);
        } else if (fdfs.equals("散养户")) {
            writeText("", 18.1F, 7.1F, 1F, 1F);
        }
        //到达省
        writeText(animal_A.getAShengDd(), 4.3F, 8.12F, 2.6F, 0.9F);
        //到达市
        writeText(animal_A.getAShiDd(), 7.4F, 8.12F, 2.5F, 0.9F);
        //到达县
        writeText(animal_A.getAXianDd(), 11.4F, 8.12F, 2.5F, 0.9F);
        //到达镇
        writeText(animal_A.getAXiangDd(), 16.1F, 8.12F, 2.3F, 0.9F);
        //到达村
        writeText(animal_A.getACunDd(), 10F, 8.8F, 3F, 0.7F);
        String sdf = animal_A.getATypeDd();         //到达地类别
        if (sdf.equals("养殖场")) {
            writeText("√", 14.3F, 8.66F, 1F, 1F);
        } else if (sdf.equals("屠宰场")) {
            writeText("√", 16.1F, 8.66F, 1F, 1F);
        } else if (sdf.equals("交易市场")) {
            writeText("√", 18.2F, 8.66F, 1F, 1F);
        } else if (sdf.equals("散养户")) {
            writeText("", 18.2F, 8.66F, 1F, 1F);
        }
        //用途
        writeText(animal_A.getAYongTu(), 4.3F, 9.83F, 2.1F, 1.1F);
        //承运人
        writeText(animal_A.getACarrier(), 9F, 9.83F, 5.7F, 1.1F);
        //承运人电话
        writeText(animal_A.getAPhoneCyr(), 16.3F, 9.83F, 3.3F, 1.1F);

        // cachecanvas.drawText(animal_A.getCarrier_phone(), JsPxValue(16.3),
        // JsPxValue(9.9), paint1);

        String fashi = animal_A.getAYunZai().trim();
        if (fashi.equals("公路")) {
            writeText("√", 4.58F, 11F, 1F, 1F);
        }
        if (fashi.equals("铁路")) {
            writeText("√", 6.5F, 11F, 1F, 1F);
        }
        if (fashi.equals("水路")) {
            writeText("√", 8.6F, 11F, 1F, 1F);
        }
        if (fashi.equals("航空")) {
            writeText("√", 10.7F, 11F, 1F, 1F);

        }
//        String[] fsa = fashi.split(",");
//        for (int i = 0; i < fsa.length; i++) {
//
//            if (fsa[i].trim().equals("公路")) {
//                writeText("√", 4.58F, 10.70F, 1F, 1F);
//                // cachecanvas1.drawText("鈭�", JsPxValue(4.52),JsPxValue(11.2),
//                // paint1);
//            }
//            if (fsa[i].trim().equals("铁路")) {
//                writeText("√", 6.5F, 10.70F, 1F, 1F);
//                // cachecanvas1.drawText("鈭�", JsPxValue(6.58), JsPxValue(11.2),
//                // paint1);
//            }
//            if (fsa[i].trim().equals("水路")) {
//                writeText("√", 8.6F, 10.70F, 1F, 1F);
//                // cachecanvas1.drawText("鈭�", JsPxValue(8.71),JsPxValue(11.2),
//                // paint1);
//            }
//            if (fsa[i].trim().equals("航空")) {
//                writeText("√", 10.7F, 10.70F, 1F, 1F);
//
//            }
//        }
        // 运载工具牌号
        writeText(animal_A.getATrademark(), 16.4F, 11F, 3.3F, 1.1F);
        // 消毒
        writeText(animal_A.getADisinfection(), 12F, 12.2F, 7.6F, 0.6F);
        //有效到达日
        writeText(changeLock.numToUpperETA1(animal_A.getAYouXiaoRi() + ""), 7.4F, 13.59F, 1.4F, 0.6F);

        writeText(animal_A.getAVeterinary(), 14F, 14.9F, 7.6F, 0.6F);//官方兽医签字
        //2016/11/1 10:12:16
        String[] nian = animal_A.getDateQF().trim().split(" ");
        String[] split = nian[0].split("-|/");
        String year = split[0];
        String Month = split[1];
        String Date = split[2];
//        String shijian = nian[1];

        writeText(changeLock.Change(year), 12.1F, 16.37F, 1.8F,        //年
                0.5F);
        writeText(changeLock.numToUpperModer(Integer.parseInt(Month)), 14.5F, 16.37F, 1.5F, 0.5F);
        writeText(
                changeLock.numToUpperday(Integer.parseInt(Date)),
                16.2F, 16.37F, 1.6F, 0.5F);
        //时分秒
//        writeText(shijian, 18F, 16.2F, 1.6F, 0.5F);

        // 耳标号
        writeText(animal_A.getAEarTag(), 4.3F, 18.45F, 15F, 3F);
        // 备注
        writeText(animal_A.getAMemo1(), 4.3F, 24.5F, 15F, 3F);
        // 动物监督电话
        writeText(animal_A.getADwPhone(), 6.7F, 26.8F, 15F, 1F);

        Bitmap bitmap1 = Create2DCode(NetClient.BASE_URL
                ///////////AQASQR.aspx?N=8708001356&u=1&D=2017-05-31\

                + "XZpt/PhoneE/AQASQR.aspx?N=" + animal_A.getSaveId()
                +"&u="+ animal_A.getANumber()
                +"&D="+animal_A.getDateQF());
        cachecanvas.drawBitmap(bitmap1, JsPxValue(1.2), JsPxValue(0), paint);
        bitmap1.recycle();

        return cachebitmap;
    }

    /**
     * 动物A查询
     *
     * @param animal_A
     * @return
     */
    public Bitmap QueryAnimal_A(QueryAnimABean.DataListBean animal_A) { // Animal_A animal_A
        writeText(animal_A.getACARGOOWNER(), 4.3F, 3.77F, 6.9F, 1.2F);    //货主
        //联系电话
        writeText(animal_A.getAPHONE(), 14.1F, 3.77F, 5.4F, 1.2F);        //货主电话

//        String request = animal_A.getAnimal_species2().trim();
//        if (request.equals("")) {
//            //动物种类
//            writeText(animal_A.getAnimal_species(), 4.3F, 4.86F, 6.9F, 1.2F);
//        } else {
//            //动物种类
//            writeText(animal_A.getAnimal_species1() + "," + request, 4.3F, 4.86F, 6.9F, 1.2F);
//        }
        //动物种类
        writeText(animal_A.getAXUZHONG(), 4.3F, 4.92F, 6.9F, 1.2F);

        //数量及单位
        writeText(changeLock.changeToQuantity_unit(animal_A.getAQUANTITY() + "")
                + animal_A.getADANWEI(), 14.1F, 4.92F, 5.4F, 1.2F);            //数量及单位
        //启运省
        writeText(animal_A.getASHENGQY(), 4.3F, 6.35F, 2.6F, 0.9F);            //启运省
        //启运市
        writeText(animal_A.getASHIQY(), 7.4F, 6.35F, 2.5F, 0.9F);            //启运市
        //启运县
        writeText(animal_A.getAXIANQY(), 11.4F, 6.35F, 2.5F, 0.9F);        //启运县
        //启运乡
        writeText(animal_A.getAXIANGQY(), 16.1F, 6.35F, 2.3F, 0.9F);        // 启运镇
        //村
        writeText(animal_A.getACUNQY(), 10F, 7.0F, 4.8F, 0.7F);        //启运村
        String fdfs = animal_A.getATYPEQY();                        //起运地类别
        if (fdfs.equals("养殖场")) {        //养殖场
            writeText("√", 16F, 7.1F, 1F, 1F);
        } else if (fdfs.equals("交易市场")) {        //交易市场
            writeText("√", 18.1F, 6.7F, 1F, 1F);
        } else if (fdfs.equals("散养户")) {
            writeText("", 18.1F, 7.1F, 1F, 1F);
        }
        //到达省
        writeText(animal_A.getASHENGDD(), 4.3F, 8.12F, 2.6F, 0.9F);
        //到达市
        writeText(animal_A.getASHIDD(), 7.4F, 8.12F, 2.5F, 0.9F);
        //到达县
        writeText(animal_A.getAXIANDD(), 11.4F, 8.12F, 2.5F, 0.9F);
        //到达镇
        writeText(animal_A.getAXIANGDD(), 16.1F, 8.12F, 2.3F, 0.9F);
        //到达村
        writeText(animal_A.getACUNDD(), 10F, 8.8F, 3F, 0.7F);
        String sdf = animal_A.getATYPEDD();         //到达地类别
        if (sdf.equals("养殖场")) {
            writeText("√", 14.3F, 8.69F, 1F, 1F);
        } else if (sdf.equals("屠宰场")) {
            writeText("√", 16.1F, 8.69F, 1F, 1F);
        } else if (sdf.equals("交易市场")) {
            writeText("√", 18.2F, 8.69F, 1F, 1F);
        } else if (sdf.equals("散养户")) {
            writeText("", 18.2F, 8.69F, 1F, 1F);
        }
        //用途
        writeText(animal_A.getAYONGTU(), 4.3F, 9.83F, 2.1F, 1.1F);
        //承运人
        writeText(animal_A.getACARRIER(), 9F, 9.83F, 5.7F, 1.1F);
        //承运人电话
        writeText(animal_A.getAPHONECYR(), 16.3F, 9.83F, 3.3F, 1.1F);

        String fashi = animal_A.getAYUNZAI().trim();        //运载方式
        if (fashi.equals("公路")) {
            writeText("√", 4.58F, 11F, 1F, 1F);
        }
        if (fashi.equals("铁路")) {
            writeText("√", 6.5F, 11F, 1F, 1F);
        }
        if (fashi.equals("水路")) {
            writeText("√", 8.6F, 11F, 1F, 1F);
        }
        if (fashi.equals("航空")) {
            writeText("√", 10.7F, 11F, 1F, 1F);
        }
        // 运载工具牌号
        writeText(animal_A.getATRADEMARK(), 16.4F, 11F, 3.3F, 1.1F);
        // 消毒
        writeText(animal_A.getADISINFECTION(), 12F, 12.2F, 7.6F, 0.6F);
        //有效到达日
        writeText(changeLock.numToUpperETA1(animal_A.getAYOUXIAORI() + ""), 7.7F, 13.59F, 1.4F, 0.6F);

        writeText(animal_A.getAVETERINARY(), 14F, 14.9F, 7.6F, 0.6F);//官方兽医签字

        String[] nian = animal_A.getDATEQF().trim().split(" ");
        String[] split = nian[0].split("-|/");
        String year = split[0];
        String Month = split[1];
        String Date = split[2];
//        String shijian = nian[1];

        writeText(changeLock.Change(year), 12.1F, 16.37F, 1.8F,        //年
                0.5F);
        writeText(changeLock.numToUpperModer(Integer.parseInt(Month)), 14.5F, 16.37F, 1.5F, 0.5F);
        writeText(
                changeLock.numToUpperday(Integer.parseInt(Date)),
                16.2F, 16.37F, 1.6F, 0.5F);
        //时分秒
//        writeText(shijian, 18F, 16.2F, 1.6F, 0.5F);

        // 耳标号
        writeText(animal_A.getAEARTAG(), 4.3F, 18.45F, 15F, 3F);
        // 备注
        writeText(animal_A.getAMEMO1(), 4.3F, 24.5F, 15F, 3F);
        // 动物监督电话
        writeText(animal_A.getADWPHONE(), 6.7F, 26.8F, 15F, 1F);

        Bitmap bitmap1 = Create2DCode(NetClient.BASE_URL
                + "XZpt/PhoneE/AQASQR.aspx?N=" + animal_A.getTID()
                +"&u="+ animal_A.getANUMBER()
                +"&D="+animal_A.getDATEQF());

        cachecanvas.drawBitmap(bitmap1, JsPxValue(4), JsPxValue(14.7), paint);
        bitmap1.recycle();

        return cachebitmap;
    }

    private void writeText(String value, float x, float y, float width, float height) {

        TextPaint textPaint = new TextPaint();

        textPaint.setColor(Color.BLACK);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(16.0F);
        int w = (int) JsPxValue(width);
        StaticLayout layout = new StaticLayout(value, textPaint, w, Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
        float h = JsPxValue(height);
        while (true) {
            if (layout.getHeight() <= h) {
                break;
            } else {
                textPaint.setTextSize(textPaint.getTextSize() - 1);
                layout = new StaticLayout(value, textPaint, w,
                        Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
            }
        }
        cachecanvas.translate(JsPxValue(x), JsPxValue(y));
        layout.draw(cachecanvas);
        cachecanvas.translate(-JsPxValue(x), -JsPxValue(y));
    }

    /**
     * 动物B
     *
     * @param animal_B
     * @param isSign
     * @return
     */

    public Bitmap Animal_B(AnimBUploadBean animal_B, String TableName, boolean isSign) {

        writeText(animal_B.getAQCargoOwner(), 4.3F, 3.8F, 6.9F, 1.2F);//货主
        writeText(animal_B.getAQPhone(), 14.5F, 3.8F, 5.4F, 1.2F);// 联系电话
//        String requset = animal_B.getAQXuZhongTwo();
//        if (requset.equals("")) {
//            writeText(animal_B.getAQXuZhong(), 4F, 4.54F, 1.85F, 1.0F);//动物种类
//            //第二个
//            writeText(animal_B.getAQXuZhong(), 4F, 18.88F, 1.85F, 1.0F);            //动物种类
//        } else {
//            writeText(animal_B.getAQXuZhongOne() + "," + requset, 4F, 4.54F, 1.85F, 1.0F);//动物种类
//            //第二个
//            writeText(animal_B.getAQXuZhongOne() + "," + requset, 4F, 18.88F, 1.85F, 1.0F);            //动物种类
//        }
        writeText(animal_B.getAQXuZhong(), 3.9F, 4.92F, 6.9F, 1.2F);//动物种类
        String ss = String.valueOf(animal_B.getAQQuantity());
        writeText(changeLock.changeToQuantity_unit(ss)            //数量及单位
                + animal_B.getAQDanWei(), 8.38F, 4.92F, 5.4F, 1.0F);

        writeText(animal_B.getAQYongTu(), 16F, 4.92F, 3.55F, 1.0F);                //用途

        writeText(animal_B.getAQShiQy(), 4.2F, 5.82F, 3.2F, 0.6F);    //启运市
        writeText(animal_B.getAQXianQy(), 8.58F, 5.82F, 3.4F, 0.6F);    //启运县
        writeText(animal_B.getAQXiangQy(), 14.5F, 5.82F, 3.9F, 0.6F);//乡

        writeText(animal_B.getAQCunQy(), 8.58F, 6.64F, 4.8F, 0.7F);        //启运村
        String dff = animal_B.getAQTypeQy();
        if (dff.equals("养殖场")) {
            writeText("√", 16.28F, 6.53F, 1F, 1F);
            writeText("√", 16.28F, 20.8F, 1F, 1F);
        } else if (dff.equals("交易市场")) {
            writeText("√", 18F, 6.53F, 1F, 1F);
            writeText("√", 18F, 20.8F, 1F, 1F);
        } else if (dff.equals("散养户")) {
            writeText("", 18F, 6.53F, 1F, 1F);
            writeText("", 18F, 20.8F, 1F, 1F);
        }
        writeText(animal_B.getAQShiDd(), 4.2F, 7.2F, 3.2F, 0.6F);            //到达市
        writeText(animal_B.getAQXianDd(), 8.58F, 7.2F, 3.4F, 0.6F);        //到达县
        writeText(animal_B.getAQXiangDd(), 14.5F, 7.2F, 3.9F, 0.6F);        //到达镇
        writeText(animal_B.getAQCunDd(), 8.58F, 7.94F, 4.8F, 0.7F);        //到达村
        String kl = animal_B.getAQTypeDd();
        if (kl.equals("养殖场")) {
            writeText("√", 14.28F, 7.8F, 1F, 1F);
            writeText("√", 14.28F, 22.15F, 1F, 1F);
        } else if (kl.equals("屠宰场")) {
            writeText("√", 16.28F, 7.8F, 1F, 1F);
            writeText("√", 16.28F, 22.15F, 1F, 1F);
        } else if (kl.equals("交易市场")) {
            writeText("√", 18F, 7.8F, 1F, 1F);
            writeText("√", 18F, 22.15F, 1F, 1F);
        } else if (kl.equals("散养户")) {
            writeText("√", 18F, 7.8F, 1F, 1F);
            writeText("√", 18F, 22.15F, 1F, 1F);
        }
        writeText(animal_B.getAQEarTag(), 4F, 8.81F, 15.3F, 1F);                //耳标号

        String[] nian = animal_B.getDateQF().trim().split(" ");
        String[] split = nian[0].split("-|/");
        String Year = split[0];
        String Month = split[1];
        String Date = split[2];
//        String shijian = nian[1];

        writeText(animal_B.getAQVeterinary(), 14F, 10.5F, 14.3F, 1F); // 官方签字


        writeText(changeLock.Change(Year), 12.35F, 11.52F, 2F,        //年
                0.5F);
        writeText(changeLock.numToUpperModer(Integer.parseInt(Month)), 15.08F, 11.52F, 1.4F, 0.5F);      //月                  //月
        writeText(
                changeLock.numToUpperday(Integer.parseInt(Date)),
                16.4F, 11.52F, 1.2F, 0.5F);                            //日
//        writeText(shijian, 18F, 11.52F, 1.2F, 0.5F);
//        writeText("本证24小时有效", 5.2F, 11.52F, 14.3F, 1F);//有效1

        writeText(animal_B.getAQCargoOwner(), 4.3F, 17.97F, 7.0F, 1.0F);            //货主
        writeText(animal_B.getAQPhone(), 14.5F, 17.97F, 5.0F, 1.0F);            // 联系电话

        writeText(animal_B.getAQXuZhong(), 3.9F, 19.12F, 6.9F, 1.2F);       //动物种类
        writeText(changeLock.changeToQuantity_unit(ss)                      //数量和单位
                + animal_B.getAQDanWei(), 8.4F, 19.12F, 5.4F, 1.0F);
        writeText(animal_B.getAQYongTu(), 16F, 19.12F, 3.55F, 1.0F);

        writeText(animal_B.getAQShiQy(), 4F, 20.14F, 7.0F, 1.0F);            //市
        writeText(animal_B.getAQXianQy(), 8.4F, 20.14F, 3.4F, 0.6F);         //县
        writeText(animal_B.getAQXiangQy(), 14.2F, 20.14F, 3.9F, 0.6F);       //乡
        writeText(animal_B.getAQCunQy(), 8.4F, 20.78F, 4.6F, 0.6F);         //村

        writeText(animal_B.getAQShiDd(), 4F, 21.5F, 3.2F, 0.6F);            //市
        writeText(animal_B.getAQXianDd(), 8.4F, 21.5F, 3.4F, 0.6F);         //县
        writeText(animal_B.getAQXiangDd(), 14.2F, 21.5F, 3.9F, 0.6F);       //乡
        writeText(animal_B.getAQCunDd(), 8.4F, 22.14F, 3.1F, 0.6F);         //村

        writeText(animal_B.getAQEarTag(), 4F, 23.1F, 15.3F, 1F);           //耳标

        writeText(animal_B.getAQVeterinary(), 14F, 24.8F, 14.3F, 1F); // 官方签字
        writeText(changeLock.Change(Year), 12.35F, 25.79F, 2F, 0.5F);             //年
        writeText(changeLock.numToUpperModer(Integer.parseInt(Month)), 15.08F, 25.79F, 2F, 0.5F);//月
        writeText(changeLock.numToUpperday(Integer.parseInt(Date)), 16.4F, 25.79F, 2F, 0.5F);//日
//        writeText(shijian, 18F, 25.4F, 2F, 0.5F);
//        writeText("本证24小时有效", 5.2F, 25.79F, 14.3F, 1F);//有效2

        Bitmap bitmap11 = Create2DCode(NetClient.BASE_URL
                + "XZpt/PhoneE/AQBSQR.aspx?N=" + animal_B.getSaveId()
                +"&u="+ animal_B.getAQNumber()
                +"&D="+animal_B.getDateQF());
        cachecanvas.drawBitmap(bitmap11, JsPxValue(1.5), JsPxValue(0), paint);
        Bitmap bitmap12 = Create2DCode(NetClient.BASE_URL
                + "XZpt/PhoneE/AQBSQR.aspx?N=" + animal_B.getSaveId()
                +"&u="+ animal_B.getAQNumber()
                +"&D="+animal_B.getDateQF());
        cachecanvas.drawBitmap(bitmap12, JsPxValue(1.5), JsPxValue(14.60), paint);

        if (isSign) {
            Bitmap bmpProductB = GetNativeSignImage(10, TableName);
            if (bmpProductB != null) {
                cachecanvas.drawBitmap(bmpProductB, JsPxValue(15.2),
                        JsPxValue(9.2), paint);
                cachecanvas.drawBitmap(bmpProductB, JsPxValue(15.2),
                        JsPxValue(23.8), paint);
                bmpProductB.recycle();
            }

        }
        return cachebitmap;
    }

    /**
     * 动物B查询
     *
     * @param animal_B
     * @param TableName
     * @param isSign
     * @return
     */
    public Bitmap QueryAnimal_B(QueryAnimBBean.DataListBean animal_B, String TableName, boolean isSign) {

        writeText(animal_B.getAQCARGOOWNER(), 4.3F, 3.77F, 6.9F, 1.2F);//货主
        writeText(animal_B.getAQPHONE(), 14.5F, 3.77F, 5.4F, 1.2F);// 联系电话
        writeText(animal_B.getAQXUZHONG(), 3.9F, 4.91F, 6.9F, 1.2F);//动物种类
        String ss = String.valueOf(animal_B.getAQQUANTITY() + "");
        writeText(changeLock.changeToQuantity_unit(ss)            //数量及单位
                + animal_B.getAQDANWEI(), 8.38F, 4.91F, 5.4F, 1.0F);

        writeText(animal_B.getAQYONGTU(), 16F, 4.91F, 3.55F, 1.0F);                //用途

        writeText(animal_B.getAQSHIQY(), 4.2F, 5.72F, 3.2F, 0.6F);    //启运市
        writeText(animal_B.getAQXIANQY(), 8.58F, 5.72F, 3.4F, 0.6F);    //启运县
        writeText(animal_B.getAQXIANGQY(), 14.5F, 5.72F, 3.9F, 0.6F);//乡

        writeText(animal_B.getAQCUNQY(), 8.58F, 6.53F, 4.8F, 0.7F);        //启运村
        String dff = animal_B.getAQTYPEQY();
        if (dff.equals("养殖场")) {
            writeText("√", 16.28F, 6.53F, 1F, 1F);
            writeText("√", 16.28F, 20.8F, 1F, 1F);
        } else if (dff.equals("交易市场")) {
            writeText("√", 18F, 6.53F, 1F, 1F);
            writeText("√", 18F, 20.8F, 1F, 1F);
        } else if (dff.equals("散养户")) {
            writeText("", 18F, 6.53F, 1F, 1F);
            writeText("", 18F, 20.8F, 1F, 1F);
        }
        writeText(animal_B.getAQSHIDD(), 4.2F, 7.1F, 3.2F, 0.6F);            //到达市
        writeText(animal_B.getAQXIANDD(), 8.58F, 7.1F, 3.4F, 0.6F);        //到达县
        writeText(animal_B.getAQXIANGDD(), 14.5F, 7.1F, 3.9F, 0.6F);        //到达镇
        writeText(animal_B.getAQCUNDD(), 8.58F, 7.82F, 4.8F, 0.7F);        //到达村
        String kl = animal_B.getAQTYPEDD();
        if (kl.equals("养殖场")) {
            writeText("√", 14.28F, 7.8F, 1F, 1F);
            writeText("√", 14.28F, 22.15F, 1F, 1F);
        } else if (kl.equals("屠宰场")) {
            writeText("√", 16.28F, 7.8F, 1F, 1F);
            writeText("√", 16.28F, 22.15F, 1F, 1F);
        } else if (kl.equals("交易市场")) {
            writeText("√", 18F, 7.8F, 1F, 1F);
            writeText("√", 18F, 22.15F, 1F, 1F);
        } else if (kl.equals("散养户")) {
            writeText("√", 18F, 7.8F, 1F, 1F);
            writeText("√", 18F, 22.15F, 1F, 1F);
        }
        writeText(animal_B.getAQEARTAG(), 4F, 8.81F, 15.3F, 1F);                //耳标号

        String[] nian = animal_B.getDATEQF().trim().split(" ");
        String[] split = nian[0].split("-|/");
        String Year = split[0];
        String Month = split[1];
        String Date = split[2];
//        String shijian = nian[1];

        writeText(animal_B.getAQVETERINARY(), 14F, 10.5F, 14.3F, 1F); // 官方签字


        writeText(changeLock.Change(Year), 12.65F, 11.52F, 2F,        //年
                0.5F);
        writeText(changeLock.numToUpperModer(Integer.parseInt(Month)), 15.28F, 11.52F, 1.4F, 0.5F);      //月                  //月
        writeText(
                changeLock.numToUpperday(Integer.parseInt(Date)),
                16.4F, 11.52F, 1.2F, 0.5F);                            //日
//        writeText(shijian, 18F, 11.52F, 1.2F, 0.5F);
//        writeText("本证24小时有效", 5.2F, 11.82F, 14.3F, 1F);//有效1

        writeText(animal_B.getAQCARGOOWNER(), 4F, 17.97F, 7.0F, 1.0F);            //货主
        writeText(animal_B.getAQPHONE(), 14.4F, 17.97F, 5.0F, 1.0F);            // 联系电话

        writeText(animal_B.getAQXUZHONG(), 3.9F, 19.09F, 6.9F, 1.2F);       //动物种类
        writeText(changeLock.changeToQuantity_unit(ss)                      //数量和单位
                + animal_B.getAQDANWEI(), 8.4F, 19.09F, 5.4F, 1.0F);
        writeText(animal_B.getAQYONGTU(), 16F, 19.09F, 3.55F, 1.0F);

        writeText(animal_B.getAQSHIQY(), 4F, 20.14F, 7.0F, 1.0F);            //市
        writeText(animal_B.getAQXIANQY(), 8.4F, 20.14F, 3.4F, 0.6F);         //县
        writeText(animal_B.getAQXIANGQY(), 14.2F, 20.14F, 3.9F, 0.6F);       //乡
        writeText(animal_B.getAQCUNQY(), 8.4F, 20.78F, 4.6F, 0.6F);         //村

        writeText(animal_B.getAQSHIDD(), 4F, 21.5F, 3.2F, 0.6F);            //市
        writeText(animal_B.getAQXIANDD(), 8.4F, 21.5F, 3.4F, 0.6F);         //县
        writeText(animal_B.getAQXIANGDD(), 14.2F, 21.5F, 3.9F, 0.6F);       //乡
        writeText(animal_B.getAQCUNDD(), 8.4F, 22F, 3.1F, 0.6F);         //村

        writeText(animal_B.getAQEARTAG(), 4F, 23.1F, 15.3F, 1F);           //耳标

        writeText(animal_B.getAQVETERINARY(), 14F, 24.8F, 14.3F, 1F); // 官方签字
        writeText(changeLock.Change(Year), 12.65F, 25.79F, 2F, 0.5F);             //年
        writeText(changeLock.numToUpperModer(Integer.parseInt(Month)), 15.28F, 25.79F, 2F, 0.5F);//月
        writeText(changeLock.numToUpperday(Integer.parseInt(Date)), 16.4F, 25.79F, 2F, 0.5F);//日
//        writeText(shijian, 18F, 25.4F, 2F, 0.5F);
//        writeText("本证24小时有效", 5.2F, 26.09F, 14.3F, 1F);//有效2

        Bitmap bitmap11 = Create2DCode(NetClient.BASE_URL
                + "XZpt/PhoneE/AQBSQR.aspx?N=" + animal_B.getTID()
                +"&u="+ animal_B.getAQNUMBER()
                +"&D="+animal_B.getDATEQF());

        cachecanvas.drawBitmap(bitmap11, JsPxValue(2.5), JsPxValue(10.05), paint);
        Bitmap bitmap12 = Create2DCode(NetClient.BASE_URL
                + "XZpt/PhoneE/AQBSQR.aspx?N=" + animal_B.getTID()
                +"&u="+ animal_B.getAQNUMBER()
                +"&D="+animal_B.getDATEQF());
        cachecanvas.drawBitmap(bitmap12, JsPxValue(2.5), JsPxValue(24.15), paint);

        if (isSign) {
            Bitmap bmpProductB = GetNativeSignImage(10, TableName);
            if (bmpProductB != null) {
                cachecanvas.drawBitmap(bmpProductB, JsPxValue(15.2),
                        JsPxValue(9.2), paint);
                cachecanvas.drawBitmap(bmpProductB, JsPxValue(15.2),
                        JsPxValue(14.60), paint);
                bmpProductB.recycle();
            }

        }
        return cachebitmap;
    }

    /**
     * 浜у搧A琛�
     *
     * @param product_A //产品A
     * @return
     */
    public Bitmap Product_A(ProductAUploadBean product_A, String TableName) {

        String shipper = product_A.getPCargoOwner().trim();
        String Shipper_phone = product_A.getPPhone().trim();
//        String Product_name = product_A.getProduct_name().trim();

        writeText(shipper, 6F, 4.02F, 6.2F, 1.2F);// 货主
        writeText(Shipper_phone, 13.88F, 3.93F, 5.6F, 1.2F);// 电话
        writeText(product_A.getPName(), 6F, 5.10F, 6.2F, 1F); // 产品名称
//		String request = product_A.getProduct_name2().trim();
//		if(request.equals("")){
//			writeText(product_A.getProduct_name().trim()+","+product_A.getProduct_name1().trim() , 5.1F, 5.16F, 6.2F, 1.2F);// 产品名称
//		}else{
//			writeText(Product_name+","+product_A.getProduct_name1().trim() +","+request , 5.1F, 5.16F, 6.2F, 1.2F);// 产品名称
//		}

        String shu = String.valueOf(product_A.getPQuantity());//数量
        writeText(changeLock.changeToQuantity_unit1(shu)
                + product_A.getPDanWei(), 13.88F, 5.20F, 5.6F, 1.2F);//数量及单位

        writeText(product_A.getPUnitName()+ "\t"+ product_A.getPSheng().trim() + product_A.getPShi().trim() +
                        product_A.getPXian().trim() + product_A.getPProductionunit().trim()
                , 5.1F, 6.46F, 14.3F, 1.3F);        //生产单位名称地址

        writeText(product_A.getPSheng(), 5.1F, 7.85F, 2.6F, 1.2F);    //达到省
        writeText(product_A.getPShi(), 8.4F, 7.85F, 2.6F, 1.2F);    // 达到市
        writeText(product_A.getPXian(), 12.6F, 7.85F, 2.6F, 1.2F);    //达到县
        writeText(product_A.getPCarrier(), 5.1F, 9.20F, 6.2F, 1.2F);    // 承运人

        writeText(product_A.getPPhoneCyr(), 13.88F, 9.20F, 6.2F, 1.2F);        //承运人电话
        String[] ss = product_A.getPYunZai().split(",");
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].trim().equals("公路")) {
                writeText("√", 4.89F, 10.44F, 1F, 1F);
            }
            if (ss[i].trim().equals("铁路")) {
                writeText("√", 7.58F, 10.44F, 1F, 1F);
            }
            if (ss[i].trim().equals("水路")) {
                writeText("√", 10.18F, 10.44F, 1F, 1F);
            }
            if (ss[i].trim().equals("航空")) {
                writeText("√", 13.1F, 10.44F, 1F, 1F);
            }
        }

        writeText(product_A.getPTrademark(), 6.1F, 11.69F, 5.1F, 1.2F);    //运载工具牌号

        writeText(product_A.getPDisinfection(), 14.0F, 11.69F, 5.2F, 1F);        //装运消毒

        writeText(changeLock.numToUpperETA1(product_A.getPYouXiaoRi() + ""), 8.35F, 13.6F, 1.2F, 0.8F);        // 有效到达日

        String[] nian = product_A.getDateQF().trim().split(" ");
        String[] split = nian[0].split("-|/");
        String Year = split[0];
        String Month = split[1];
        String Date = split[2];
//        String shijian = nian[1];

        writeText(product_A.getPVeterinary(), 14F, 15.2F, 7.6F, 0.6F);//官方兽医

        writeText(changeLock.Change(Year), 12.10F, 16.8F, 1.6F, 0.7F);// 年
        writeText(changeLock.numToUpperModer(Integer.parseInt(Month)), 14.65F, 16.8F, 1.6F, 0.7F);// 月

        writeText(changeLock.numToUpperday(Integer.parseInt(Date)), 16.0F, 16.8F, 1.6F, 0.7F);// 日

//        writeText(shijian, 18F, 16.8F, 1.6F, 0.7F);// 日

        writeText(product_A.getPMemo1(), 4.9F, 24.7F, 14.3F, 4.6F);        //		备





        // 注

        writeText(product_A.getPDwPhone(), 7.6F, 27.0F, 14.3F, 2.1F);        //动物卫生电话

        Bitmap bitmap1 = Create2DCode(NetClient.BASE_URL
                + "XZpt/PhoneE/APASQR.aspx?N=" + product_A.getSaveId()
                +"&u="+ product_A.getPNumber()
                +"&D="+product_A.getDateQF());
        cachecanvas.drawBitmap(bitmap1, JsPxValue(4.1), JsPxValue(14.7), paint);
        bitmap1.recycle();

        return cachebitmap;
    }

    /**
     * 产品B
     *
     * @param product_B
     * @param isSign
     * @return
     */
    public Bitmap Product_B(ProductBUploadBean product_B, String TableName, Boolean isSign) { // Animal_A

        writeText(product_B.getPBCargoOwner(), 5.1F, 3.69F, 5.8F, 1F); // 货主1
        writeText(product_B.getPBCargoOwner().trim(), 5.1F, 18.0F, 5.8F, 1F);//货2

        writeText(product_B.getPBName(), 13.35F, 3.69F, 6.2F, 1F); // 产品名称1
        writeText(product_B.getPBName(), 13.35F, 18.0F, 6.2F, 1F); // 产品名称2
//		String request = product_B.getProduct_name2().trim();
//		String requdd = product_B.getProduct_name().trim();
//		if(request.equals(requdd)){
//			writeText(product_B.getProduct_name1()+","+product_B.getProduct_name(), 13.35F, 3.64F, 6.2F, 1F); // 产品名称
//			//第二个
//			writeText(product_B.getProduct_name1()+","+product_B.getProduct_name(), 13.35F, 18F, 6.2F, 1F); // 产品名称
//		}else{
//			writeText(request+","+product_B.getProduct_name1() +","+product_B.getProduct_name(), 13.35F, 3.64F, 6.2F, 1F); // 产品名称
//			//第二个
//			writeText(request+","+product_B.getProduct_name1() +","+product_B.getProduct_name(), 13.35F, 18F, 6.2F, 1F); // 产品名称
//		}


        writeText(changeLock.changeToQuantity_unit1(product_B.getPBQuantity())
                + product_B.getPBDanWei(), 5.1F, 4.87F, 5.8F, 1F); //数量及单位1
        writeText(changeLock.changeToQuantity_unit1(product_B.getPBQuantity())
                + product_B.getPBDanWei(), 5.1F, 19.0F, 5.8F, 1F);//数量及单位2

        writeText(product_B.getPBOrigin().trim(), 13.35F, 4.87F, 6.2F, 1F); //产地1
        writeText(product_B.getPBOrigin().trim(), 13.35F, 19.0F, 6.2F, 1F); //产地2

        writeText(product_B.getPBOrigin().trim() + "\t" + product_B.getPBProductionunit().trim(), 5.1F, 5.8F, 14.3F, 1F);//生产单位名称  地址1
        writeText(product_B.getPBOrigin().trim() + "\t" + product_B.getPBProductionunit().trim(), 5.1F, 20.0F, 14.3F, 1F);//生产单位名称  地址2

        writeText(product_B.getPBDestinations().trim(), 5.1F, 7F, 14.3F, 1F);//目的地1
        writeText(product_B.getPBDestinations().trim(), 5.1F, 21.0F, 14.3F, 1F); //目的地2

        writeText(product_B.getPBSign().trim(), 5.1F, 7.9F, 14.3F, 1F); //检疫标志号1
        writeText(product_B.getPBSign().trim(), 5.1F, 22.0F, 14.3F, 1F); //检疫标志号2

        writeText(product_B.getPBHzNumber().trim(), 5.1F, 9F, 14.3F, 1F);    //备注1
        writeText(product_B.getPBHzNumber().trim(), 5.1F, 23.4F, 14.3F, 1F); //备注2

        writeText(product_B.getPBVeterinary(), 15.2F, 10.5F, 14.3F, 1F); // 官方签字1
        writeText(product_B.getPBVeterinary(), 15.2F, 24.8F, 14.3F, 1F); // 官方签字2

        String[] nian = product_B.getDateQF().trim().split(" ");
        String[] split = nian[0].split("-|/");
        String year = split[0];
        String month = split[1];
        String day = split[2];
//        String shijian = nian[1];
        //时间日期
        writeText(changeLock.Change(year), 13.3F, 11.36F, 1.4F, 0.7F);//年1
        writeText(changeLock.Change(year), 13.3F, 25.5F, 1.4F, 0.7F);//年2
        writeText(changeLock.numToUpperModer(Integer.parseInt(month)), 15.58F, 11.36F, 1.2F, 0.5F);//月1
        writeText(changeLock.numToUpperModer(Integer.parseInt(month)), 15.58F, 25.5F, 1.2F, 0.5F);//月2
        writeText(changeLock.numToUpperday(Integer.parseInt(day)), 16.9F, 11.36F, 1.2F, 0.5F);//日1
        writeText(changeLock.numToUpperday(Integer.parseInt(day)), 16.9F, 25.5F, 1.2F, 0.5F);//日2
//        writeText(shijian, 18.6F, 11.36F, 1.2F, 0.5F);//时分秒
//        writeText(shijian, 18.6F, 25.5F, 1.2F, 0.5F);//时分秒
//        writeText("本证24小时内有效", 6.6F, 11.9F, 5F, 0.6F);//本证24小时内有效1
//        writeText("本证24小时内有效", 6.6F, 26.1F, 5F, 0.6F);//本证24小时内有效2

        Bitmap bitmap11 = Create2DCode(NetClient.BASE_URL
                + "XZpt/PhoneE/APBSQR.aspx?N=" + product_B.getSaveId()
                +"&u="+ product_B.getPBNumber()
                +"&D="+product_B.getDateQF());
        cachecanvas.drawBitmap(bitmap11, JsPxValue(2), JsPxValue(0), paint);//二维码1
//        cachecanvas.drawBitmap(bitmap11, JsPxValue(4), JsPxValue(9.9), paint);//二维码1

        Bitmap bitmap12 = Create2DCode(NetClient.BASE_URL
                + "XZpt/PhoneE/APBSQR.aspx?N=" + product_B.getSaveId()
                +"&u="+ product_B.getPBNumber()
                +"&D="+product_B.getDateQF());
        cachecanvas.drawBitmap(bitmap12, JsPxValue(2), JsPxValue(14.60), paint);//二维码2

        if (isSign) {
            Bitmap bmpProductB = GetNativeSignImage(10, TableName);
            if (bmpProductB != null) {
                cachecanvas.drawBitmap(bmpProductB, JsPxValue(15.2),
                        JsPxValue(10), paint);
                cachecanvas.drawBitmap(bmpProductB, JsPxValue(15.2),
                        JsPxValue(14.60), paint);
                bmpProductB.recycle();
            }
        }
        return cachebitmap;
    }


    /***
     * 目前无用
     *
     * @return
     */
    @SuppressWarnings("static-access")
    private Bitmap GetNativeSignImage(int multiple, String TableName) {
        pref = context.getSharedPreferences("data", context.MODE_PRIVATE);
        String Time = pref.getString("UserAccount", "");

        Bitmap map = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = (int) multiple; /* 鍥剧墖闀垮鏂瑰悜缂╁皬鍊嶆暟 */
        options.inJustDecodeBounds = false;
        try {
            File file = new File(dir + File.separator + "image" + File.separator + TableName + "Sign_"
                    + Time + ".jpg");
            Uri uri = Uri.fromFile(file);
            InputStream input = context.getContentResolver().openInputStream(uri);
            map = BitmapFactory.decodeStream(input, null, options);
            input.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();

            return null;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }

    /***
     * @param str
     * @return Bitmap
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Bitmap Create2DCode(String str) {

        BitMatrix matrix = null;
        Hashtable hints = new Hashtable();
        hints.put(EncodeHintType.CHARACTER_SET, "GBK");
        try {
            matrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE,
                    120, 120, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    pixels[y * width + x] = 0xff000000;
                }
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Config.ARGB_8888);
        // 閫氳繃鍍忕礌鏁扮粍鐢熸垚bitmap
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

}
