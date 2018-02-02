package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.QueryProductABean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */

public interface IQueryListProductAActivity extends IMVPActivity{
    void addListData(List<QueryProductABean.DataListBean> list);
    void setData(List<QueryProductABean.DataListBean> dataListEntity);

}
