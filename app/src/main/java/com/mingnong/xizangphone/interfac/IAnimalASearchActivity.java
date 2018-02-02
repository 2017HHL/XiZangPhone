package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.QueryAnimABean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public interface IAnimalASearchActivity extends IMVPActivity {
    void setData(List<QueryAnimABean.DataListBean> dataListEntity);

    void addListData(List<QueryAnimABean.DataListBean> dataListEntity);
}
