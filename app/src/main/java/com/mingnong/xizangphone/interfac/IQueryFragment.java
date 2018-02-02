package com.mingnong.xizangphone.interfac;


import com.mingnong.xizangphone.bean.HomeBean;

import java.util.List;

/**
 * Created by wyw on 2016/11/29.
 */
public interface IQueryFragment extends IMVPFragment{

    void refreshComplete(List<HomeBean.DataList> dataLists);
    void notIntenet();
}
