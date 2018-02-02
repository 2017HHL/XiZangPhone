package com.mingnong.xizangphone.interfac;

/**
 * Created by wyw on 2016/11/10.
 */
public interface IProductPrintBActivity extends IMVPActivity {
    void setTime(String applyTime, String id);

    void uploadComplete();

    void saveSuccess();
}
