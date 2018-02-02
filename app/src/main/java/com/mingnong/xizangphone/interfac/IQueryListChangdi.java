package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.QueryListChangDI;
import com.mingnong.xizangphone.bean.QueryTuZaiBean;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7 0007.
 */
public interface IQueryListChangdi extends IMVPActivity{
     void setData(List<QueryListChangDI.DataListBean> data);
    void addListData(List<QueryListChangDI.DataListBean> list);
}
