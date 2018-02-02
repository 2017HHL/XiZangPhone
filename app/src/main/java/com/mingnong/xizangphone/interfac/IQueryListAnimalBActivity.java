package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.QueryAnimBBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/20.
 */
public interface IQueryListAnimalBActivity extends IMVPActivity {

    void setData(List<QueryAnimBBean.DataListBean> dataListEntity);

    void addListData(List<QueryAnimBBean.DataListBean> dataListEntity);
}
