package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.WuHaIHuaAddBean;

import java.util.List;

/**
 * Created by song on 2017/6/14.
 */

public interface IWuHaiHuaAdd extends IMVPActivity {
    void setData(List<WuHaIHuaAddBean.DataListBean> dataListEntity);
}
