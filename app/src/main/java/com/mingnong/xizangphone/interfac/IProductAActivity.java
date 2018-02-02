package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.BaseMsgBean;
import com.mingnong.xizangphone.bean.ProductAUploadBean;

/**
 * Created by Administrator on 2017/4/19.
 */
public interface IProductAActivity extends IMVPActivity {
    //    void shouyijiandu(ProductAUploadBean uploadBean);
//
//    void uploadComplete(String string);
    void upLoadSucceed();

    void zhenghao(BaseMsgBean.Data dataListBean);
}
