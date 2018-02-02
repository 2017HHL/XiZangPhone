package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.bean.QueryWHHBean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public interface IQueryListWHHActivity extends IMVPActivity {

    void setData(List<QueryWHHBean.DataListBean> dataListEntity);

    void addListData(List<QueryWHHBean.DataListBean> dataListEntity);

}
