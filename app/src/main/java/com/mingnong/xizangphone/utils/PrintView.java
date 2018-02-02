package com.mingnong.xizangphone.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.mingnong.xizangphone.bean.AnimAUploadBean;
import com.mingnong.xizangphone.bean.AnimBUploadBean;
import com.mingnong.xizangphone.bean.ProductAUploadBean;
import com.mingnong.xizangphone.bean.ProductBUploadBean;
import com.mingnong.xizangphone.bean.QueryAnimABean;
import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.dao.Animal_A;
import com.mingnong.xizangphone.dao.Animal_B;
import com.mingnong.xizangphone.dao.Product_A;
import com.mingnong.xizangphone.dao.Product_B;
import com.mingnong.xizangphone.interfac.Contance;

/**
 * Created by wyw on 2016/11/10.
 */

public class PrintView<T> extends View {

    Canvas cachecanvas; // 赋值过程中的画板
    Paint paint;
    Bitmap cachebitmap; // 最终生成的图片
    Paint paint1;
    Paint paintDate;
    Paint paintG;
    String type;
    T t;

    public PrintView(Context context, T t) {
        super(context);
        this.t = t;
        initCanvas();
    }

    public Bitmap getcacheBitmap() {
        return cachebitmap;
    }

    /***
     * 初始化绘图类
     */
    public void initCanvas() {
        paint = new Paint();
        paint.setAntiAlias(true); //是否抗锯齿
        paint.setColor(Color.BLACK);
        paint.setTextSize(10); // 设置画笔字体的大小

        paintG = new Paint();
        paintG.setAntiAlias(true); // //是否抗锯齿
        paintG.setColor(Color.BLACK);
        paintG.setTextSize(20); // 设置画笔字体的大小

        cachebitmap = Bitmap.createBitmap(1050, 1950, Bitmap.Config.ARGB_8888);// 生成的图片

        cachecanvas = new Canvas(cachebitmap);

        cachecanvas.drawColor(Color.WHITE);

        // 打印字体的笔
        paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setColor(Color.BLACK);
        paint1.setTextSize(30);

        // 打印日期的笔
        paintDate = new Paint();
        paintDate.setAntiAlias(true);
        paintDate.setColor(Color.BLACK);
        paintDate.setTextSize(20);
        //修改打印内容的尺寸
        DrawUtil drawUtil = new DrawUtil(getContext());// 传的参数是上下文对象
        if (t instanceof ProductAUploadBean){
            cachebitmap = drawUtil.Product_A((ProductAUploadBean) t,Contance.TYPE_PRINT_PRODUCT_A);
        }else if (t instanceof ProductBUploadBean){
            cachebitmap = drawUtil.Product_B((ProductBUploadBean) t,Contance.TYPE_PRINT_PRODUCT_B, false);
        }else if (t instanceof AnimAUploadBean) {
            cachebitmap = drawUtil.Animal_A((AnimAUploadBean) t);
        } else if (t instanceof AnimBUploadBean) {
            cachebitmap = drawUtil.Animal_B((AnimBUploadBean) t, Contance.TYPE_PRINT_ANIM_A, false);
        } else if(t instanceof QueryAnimABean.DataListBean){
            cachebitmap = drawUtil.QueryAnimal_A((QueryAnimABean.DataListBean) t);
        } else if (t instanceof QueryAnimBBean.DataListBean) {
            cachebitmap = drawUtil.QueryAnimal_B((QueryAnimBBean.DataListBean) t, Contance.TYPE_PRINT_ANIM_A, false);
        }
    }

    // 清除功能
    public void clear() {
        if (cachecanvas != null) {

            paint.setColor(Color.WHITE);
            cachecanvas.drawPaint(paint);
            paint.setColor(Color.BLACK);
            cachecanvas.drawColor(Color.WHITE); // 设置画图的背景颜色
            invalidate();
        }
    }

    /***
     * 生成二维码图片返回
     *
     * @param str
     * @return Bitmap
     */
    public Bitmap Create2DCode(String str) {
        // 生成二维矩阵,编码时指定大小,不要生成了图片以后再进行缩放,这样会模糊导致识别失败
        BitMatrix matrix = null;
        Log.i("ffss", str);
        try {
            matrix = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, 150, 150);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        int width = matrix.getWidth();
        int height = matrix.getHeight();
        // 二维矩阵转为一维像素数组,也就是一直横着排了
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    pixels[y * width + x] = 0xff000000;
                }
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        // 通过像素数组生成bitmap,具体参考api
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        return bitmap;
    }

}
