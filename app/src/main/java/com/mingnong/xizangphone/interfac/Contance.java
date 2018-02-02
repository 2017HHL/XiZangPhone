package com.mingnong.xizangphone.interfac;

/**
 * Created by wyw on 2016/10/31.
 */

public interface Contance {
    //机器码和序列号
    String DATA_MACHINE_NUMBER = "MachineNumber";
    String DATA_SERIAL_NUMBER = "SerialNumber";
    String DATA_PERMISSION = "Permission";
    //下载
    int TYPE_APK_DONE = 0; //apk下载完成标志
    int TYPE_DB_DONE = 1; //db下载完成标志
    int TYPE_PATCH_DONE = 2; //patch下载完成标志
    int TYPE_DEX_DONE = 3; //dex下载完成标志

    //动物种类 产品种类
    String TYPE_PRINT_ANIM_A = "AMA";
    String TYPE_PRINT_ANIM_B = "AMB";
    String TYPE_PRINT_PRODUCT_A = "PDA";
    String TYPE_PRINT_PRODUCT_B = "PDB";

    String TYPE_REQUEST_ANIM = "DWSBD";//申报
    String TYPE_REQUEST_PRODUCT = "CPSBD";//申报
    String TYPE_REQUEST_ANIM_SHOULI = "DWSBD2";//受理
    String TYPE_REQUEST_PRODUCT_SHOULI = "CPSBD2";//受理

    String ACTIVITY_DATA = "data";
    String ACTIVITY_TYPE = "type";

    //    shareperference对应的 user
    String USER_OBJECT = "user";
    String USER_NAME = "name";
    String USER_PSW = "psw";
    String SP_PATCH_VERSION = "patch_version";
    String SP_DEX_VERSION = "dex_version";
    String SP_DB_VERSION = "db_version";
//    String IMG_URL = "http://192.168.0.55/XZAPP/";//图片前缀
    //    String IMG_PRE = "http://www.hndwwj.org.cn:8886/HuNanAPP/";//前缀
    String START_ACTIVITY_TYPE = "type";
    String START_ACTIVITY_DATA = "data";

    int ACTIVITY_REQUEST_CODE = 100;
    int ACTIVITY_CODE = 200;
}
