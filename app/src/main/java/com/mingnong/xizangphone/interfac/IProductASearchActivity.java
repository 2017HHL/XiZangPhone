package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.QueryProductABean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public interface IProductASearchActivity extends IMVPActivity {

    void setData(List<QueryProductABean.DataListBean> dataListEntity);

    void addListData(List<QueryProductABean.DataListBean> dataListEntity);
}
