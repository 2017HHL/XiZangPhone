package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.QueryProductABean;

import java.util.List;

/**
 * Created by HUANG on 2017/7/4.
 */
public interface IChanDiJianYiChaXunActivity extends IMVPActivity {
    void addListData(List<QueryProductABean.DataListBean> list);
    void setData(List<QueryProductABean.DataListBean> dataListEntity);
}
