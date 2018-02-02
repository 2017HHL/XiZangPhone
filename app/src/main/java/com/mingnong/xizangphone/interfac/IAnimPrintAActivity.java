package com.mingnong.xizangphone.interfac;

/**
 * Created by wyw on 2016/11/11.
 */
public interface IAnimPrintAActivity extends IMVPActivity{
    void setTime(String applyTime, String id);

    void uploadComplete();

    void saveSuccess();
}
