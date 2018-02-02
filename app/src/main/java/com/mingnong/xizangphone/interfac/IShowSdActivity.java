package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.dao.XiaoXiDaoBean;

import java.util.List;

/**
 * Created by HUANG on 2017/7/14.
 */
public interface IShowSdActivity extends IMVPActivity {
    void addListData();
    void setData(List<XiaoXiDaoBean> mylist);
}
