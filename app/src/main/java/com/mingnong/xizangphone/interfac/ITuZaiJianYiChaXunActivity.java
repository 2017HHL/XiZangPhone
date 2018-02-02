package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.QueryProductABean;
import com.mingnong.xizangphone.bean.QueryTuZaiBean;

import java.util.List;

/**
 * Created by HUANG on 2017/7/4.
 */
public interface ITuZaiJianYiChaXunActivity extends IMVPActivity {
    void addListData(List<QueryTuZaiBean.DataListBean> list);
    void setData(List<QueryTuZaiBean.DataListBean> dataListEntity);
}
