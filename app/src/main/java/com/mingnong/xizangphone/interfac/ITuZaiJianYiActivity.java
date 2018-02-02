package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.DanWeiBean;
import com.mingnong.xizangphone.bean.DongwuBean;
import com.mingnong.xizangphone.bean.ShenShiBean;
import com.mingnong.xizangphone.bean.TuzaimingcBean;

import java.util.List;

/**
 * Created by HUANG on 2017/7/4.
 */
public interface ITuZaiJianYiActivity extends IMVPActivity {
    void uploadsuccess();
    void setData1(List<DongwuBean.DataListBean> dataListBean);
    void setData2(List<DanWeiBean.DataListBean> dataListBean);
    void setData3(List<DanWeiBean.DataListBean> dataListBean);
    void setData4(List<DanWeiBean.DataListBean> dataListBean);
    void setData5(List<TuzaimingcBean.DataListBean> dataListBean);
    void setData6(List<ShenShiBean.DataListBean> dataListBean);
}


