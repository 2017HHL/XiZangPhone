package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.QueryAnimABean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface IQueryListAnimalAActivity extends IMVPActivity {
    void setData(List<QueryAnimABean.DataListBean> dataListEntity);

    void addListData(List<QueryAnimABean.DataListBean> dataListEntity);
}
