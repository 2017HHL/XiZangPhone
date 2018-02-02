package com.mingnong.xizangphone.interfac;


import com.mingnong.xizangphone.bean.HomeBean;

import java.util.List;

/**
 * Created by wyw on 2016/11/1.
 */

public interface IHomeFragment extends IMVPFragment {

    void refreshComplete(List<HomeBean.DataList> dataLists);
    void notIntenet();
}
