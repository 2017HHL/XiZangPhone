package com.mingnong.xizangphone.service;


import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.mingnong.xizangphone.MyApplication;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by hyj on 2017/6/30.
 * 图片下载
 */

public class SDFileHelper {
    private Context context;
    public SDFileHelper(){}
    public SDFileHelper(Context context){
        super();
        this.context = context;
    }
    //Glide保存图片
    public void savePicture(final String fileName,String url){
        Glide.with(context).load(url+fileName).asBitmap().toBytes().into(new SimpleTarget<byte[]>() {
            @Override
            public void onResourceReady(byte[] resource, GlideAnimation<? super byte[]> glideAnimation) {
              try {
                  saveFileToSD(fileName,resource);
              }catch (Exception e){
                  e.printStackTrace();
              }
            }
        });
    }
//往SD卡写入文件的方法
    private void saveFileToSD(String fileName, byte[] resource) throws Exception {
        //如果手机已插入SD卡，且APP具体读写SD卡权限
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            String filePath = Environment.getExternalStorageDirectory().getCanonicalPath()+"/QianXianImage";
            File dir1 = new File(filePath);
            if (!dir1.exists()){
                dir1.mkdirs();
            }
            fileName = filePath+"/"+fileName.split("/|-")[1];
            //这里就不要openFileOutput了，那是往手机内存中写入数据的
            FileOutputStream output = new FileOutputStream(fileName);
            //将byres写入到输出流中
            output.write(resource);
           //关闭输出流
            output.close();
        }else {
            Toast.makeText(context,"SD卡不存在或者不可读写",Toast.LENGTH_LONG).show();
        }
    }
}
