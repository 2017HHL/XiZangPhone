package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.QueryProductBBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public interface IProductBSearchActivity extends IMVPActivity {

    void setData(List<QueryProductBBean.DataListBean> dataListEntity);

    void addListData(List<QueryProductBBean.DataListBean> dataListEntity);
}
