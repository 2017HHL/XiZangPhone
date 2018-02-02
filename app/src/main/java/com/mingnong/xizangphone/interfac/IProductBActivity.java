package com.mingnong.xizangphone.interfac;

import com.mingnong.xizangphone.bean.BaseMsgBean;

/**
 * Created by Administrator on 2017/4/19.
 */
public interface IProductBActivity extends IMVPActivity {
    void upLoadSucceed();

    void zhenghao(BaseMsgBean.Data dataListBean);
}
