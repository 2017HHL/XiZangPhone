package com.mingnong.xizangphone.presenter;


import android.text.TextUtils;

import com.google.gson.Gson;
import com.mingnong.xizangphone.dao.ProductApplyBean;
import com.mingnong.xizangphone.dao.local.DBInnerController;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IProductProcessActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wyw on 2016/11/10.
 */
public class ProductProcessActivityPresenter extends BaseActivityPresenter<IProductProcessActivity> {

    public ProductProcessActivityPresenter(IProductProcessActivity view) {
        super(view);
        getTime();
    }

    public void getTime() {
        addSubscribe(getRequest().getTime()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .map(loginBean -> {
                    if (loginBean.getErrorCode() != 0)
                        throw new IllegalArgumentException(loginBean.getErrorMsg());
                    return loginBean.getData().getResult();
                })
                .subscribe(data -> {
                    //将2016-11-07 14:59:15.6562
                    getView().setTime(data.split(" ")[0], data.replaceAll("-|:|\\.| ", ""));
                }, throwable -> {
                    //设置当前系统时间
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.CHINA);
                    String s = format.format(new Date());
                    getView().setTime(s.split(" ")[0], s.replaceAll("-|:|\\.| ", ""));
                }));
    }

    public void upload(ProductApplyBean bean) {
        if (!TextUtils.equals(bean.getFStId(), "-2")) {
            addSubscribe(getRequest().updateAnimAndProduct(new Gson().toJson(bean), String.valueOf(getUser().getUSERID()), Contance.TYPE_REQUEST_PRODUCT)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(() -> getView().showProgress())
                    .map(baseMsg -> {
                        if (baseMsg.getErrorCode() != 0) {
                            throw new IllegalArgumentException(baseMsg.getErrorMsg());
                        }
                        return baseMsg;
                    })
                    .subscribe(baseMsg -> getView().uploadSuccess(),
                            throwable -> {
                                getView().hideProgress();
                                getView().showToast(throwable.getMessage());
                            }, () -> getView().hideProgress()));
        } else {
            DBInnerController.getDaoSession().getProductApplyBeanDao().update(bean);
            getView().uploadSuccess();
        }

    }

    public String getGuanfangName() {
        return getUser().getFUNAME();
    }

    public String getGuanfangPhone() {
        return getUser().getFUPHONE();
    }
}