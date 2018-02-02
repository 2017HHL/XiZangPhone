package com.mingnong.xizangphone.adapter;


import android.os.Environment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.HomeBean;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.service.SDFileHelper;
import com.mingnong.xizangphone.utils.NetWorkUtils;
import com.mingnong.xizangphone.view.recyclerview.BaseQuickAdapter;
import com.mingnong.xizangphone.view.recyclerview.BaseViewHolder;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by wyw on 2016/11/1.
 */

public class HomeBeanAdapeter extends BaseQuickAdapter<HomeBean.DataList> {


    public HomeBeanAdapeter(List<HomeBean.DataList> dataList) {
        super(R.layout.adapter_home_item, dataList);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.DataList item) {
        helper.setText(R.id.tv_title, item.getFMNAME());
        if (NetWorkUtils.isOpenNetwork(MyApplication.getContext())) {
            Glide.with(mContext).load(NetClient.PIC_URL + item.getIMG()).into((ImageView) helper.getView(R.id.img));
            SDFileHelper SDFileHelper = new SDFileHelper(mContext);
            SDFileHelper.savePicture( item.getIMG(),NetClient.PIC_URL);
        }else {
            //本地文件
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                String filePath = null;
                try {
                    filePath = Environment.getExternalStorageDirectory().getCanonicalPath() + "/QianXianImage";
                } catch (IOException e) {
                    e.printStackTrace();
                }
                File dir1 = new File(filePath+"/"+item.getIMG().split("/|-")[1]);
                //加载图片
                Glide.with(mContext).load(dir1).into((ImageView) helper.getView(R.id.img));
            }
        }
    }

}
