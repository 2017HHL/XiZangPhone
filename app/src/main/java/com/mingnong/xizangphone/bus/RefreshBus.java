package com.mingnong.xizangphone.bus;

/**
 * Created by wyw on 2016/11/9.
 */

public class RefreshBus {
    //0 AnimDeclareListActivity
    //1 ProductDeclareListActivity
    //2 QuarantineAnimFragment
    //3 QuarantineProductFragment
    public static final int AnimDeclareListActivity= 0;
    public static final int ProductDeclareListActivity= 1;
    public static final int QuarantineAnimFragment = 2;
    public static final int QuarantineProductFragment = 3;
    public static final int NetWorkBadAnimAdd = 4; //网络不好 动物申请
    public static final int NetWorkBadProductAdd = 5; //网络不好 动物申请

    private int number;

    public RefreshBus(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
