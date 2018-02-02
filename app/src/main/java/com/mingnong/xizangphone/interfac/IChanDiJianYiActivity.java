package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.DanWeiBean;
import com.mingnong.xizangphone.bean.DongwuBean;
import com.mingnong.xizangphone.bean.ShenShiBean;

import java.util.List;

/**
 * Created by HUANG on 2017/7/4.
 */
public interface IChanDiJianYiActivity extends IMVPActivity {
    void uploadsuccess();
    void setData1(List<DongwuBean.DataListBean> dataListBean);
    void setData2(List<DanWeiBean.DataListBean> dataListBean);
    void setData3(List<DanWeiBean.DataListBean> dataListBean);
    void setData4(List<ShenShiBean.DataListBean> dataListBean);
}
