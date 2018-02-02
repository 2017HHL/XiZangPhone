package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.QueryProductABean;
import com.mingnong.xizangphone.bean.QueryProductBBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */

public interface IQueryListProductionBActivity extends IMVPActivity {
    void addListData(List<QueryProductBBean.DataListBean> list);
    void setData(List<QueryProductBBean.DataListBean> dataListEntity);
}
