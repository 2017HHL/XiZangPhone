package com.mingnong.xizangphone.interfac;


import com.mingnong.xizangphone.dao.ProductApplyBean;

import java.util.List;

/**
 * Created by wyw on 2016/11/9.
 */

public interface IQuarantineProductFragment extends IMVPFragment {
    void addList(List<ProductApplyBean> list);

    void loadComplete();

    void setList(List<ProductApplyBean> list);
}
