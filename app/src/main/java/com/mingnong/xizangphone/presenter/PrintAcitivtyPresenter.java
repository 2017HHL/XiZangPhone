package com.mingnong.xizangphone.presenter;


import android.util.Log;

import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IPrintAcitivty;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wyw on 2016/11/10.
 */
public class PrintAcitivtyPresenter extends BaseActivityPresenter<IPrintAcitivty>{

    public PrintAcitivtyPresenter(IPrintAcitivty view) {
        super(view);
    }

    public void upload() {
        addSubscribe(getRequest().printCheck(String.valueOf(getUser().getUSERID()),
                getMachineNumber(), getSerialNumber())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(baseMsg -> {
                    Log.e("PrintAcitivtyPresenter", baseMsg.getErrorMsg());
                },Throwable::printStackTrace));

    }

    public void saveMachineNumber(String machineNumber) {
        getSpUtils().saveData(Contance.DATA_MACHINE_NUMBER,machineNumber);
    }

    public void saveSerialNumber(String serialNumber) {
        getSpUtils().saveData(Contance.DATA_SERIAL_NUMBER,serialNumber);
    }
    public String getMachineNumber() {
        return getSpUtils().getData(Contance.DATA_MACHINE_NUMBER,"",String.class);
    }

    public String getSerialNumber() {
       return  getSpUtils().getData(Contance.DATA_SERIAL_NUMBER,"",String.class);
    }
}
