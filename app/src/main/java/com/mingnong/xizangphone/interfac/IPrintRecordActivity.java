package com.mingnong.xizangphone.interfac;


import com.mingnong.xizangphone.bean.PrintRecordListBean;

import java.util.List;

/**
 * Created by wyw on 2016/11/29.
 */
public interface IPrintRecordActivity extends IMVPActivity {
    void addList(List<PrintRecordListBean.DataListBean> list);

    void setList(List<PrintRecordListBean.DataListBean> list);

    void loadComplete();
}
