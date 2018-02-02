package com.mingnong.xizangphone.interfac;


import com.mingnong.xizangphone.dao.ProductApplyBean;

import java.util.List;

/**
 * Created by wyw on 2016/11/1.
 */

public interface IProductDeclareListActivity extends IMVPActivity {
    void addList(List<ProductApplyBean> list);

    void setList(List<ProductApplyBean> list);

    void loadComplete();
}
