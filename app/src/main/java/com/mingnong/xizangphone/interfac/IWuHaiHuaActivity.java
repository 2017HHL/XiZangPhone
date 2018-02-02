package com.mingnong.xizangphone.interfac;


import com.mingnong.xizangphone.bean.PublicInformation;
import com.mingnong.xizangphone.bean.WuHaiHuaUpLocaBaen;

/**
 * Created by song on 2017/6/12.
 */

public interface IWuHaiHuaActivity extends IMVPActivity {


    void setData(PublicInformation data);

    void isFinish();

    void uploadsuccess();

}
