package com.mingnong.xizangphone.presenter;

import com.google.gson.Gson;
import com.mingnong.xizangphone.dao.Animal_A;
import com.mingnong.xizangphone.dao.StoreAnimalA;
import com.mingnong.xizangphone.dao.local.DBInnerController;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IAnimPrintAActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wyw on 2016/11/11.
 */
public class AnimPrintAActivityPresenter extends BaseActivityPresenter<IAnimPrintAActivity> {
    public AnimPrintAActivityPresenter(IAnimPrintAActivity view) {
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
                    getView().setTime(data.split("\\.")[0], data.replaceAll("-|:|\\.| ", ""));
                }, throwable -> {
                    //设置当前系统时间
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.CHINA);
                    String s = format.format(new Date());
                    getView().setTime(s.split("\\.")[0], s.replaceAll("-|:|\\.| ", ""));
                }));
    }


    public void upload(Animal_A bean) {
        if (bean.getGlid() != -2) {
            addSubscribe(getRequest().processAnimAndProduct(Contance.TYPE_PRINT_ANIM_A, new Gson().toJson(bean)
                    , "null", String.valueOf(getUser().getUSERID()))
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(() -> getView().showProgress())
                    .map(baseMsg -> {
                        if (baseMsg.getErrorCode() != 0)
                            throw new IllegalArgumentException(baseMsg.getErrorMsg());
                        return baseMsg;
                    })
                    .subscribe(baseMsg -> getView().uploadComplete(),
                            throwable -> {
                                getView().showToast(throwable.getMessage());
                                getView().hideProgress();
                            }, () -> getView().hideProgress()));
        } else {
            Long id = DBInnerController.getDaoSession().getAnimal_ADao().insert(bean);
            DBInnerController.getDaoSession().getStoreAnimalADao().insert(
                    new StoreAnimalA(null, id, String.valueOf(getUser().getUSERID()), Contance.TYPE_PRINT_ANIM_A));
            getView().saveSuccess();
        }
    }

    public String getMachineNumber() {
        return getSpUtils().getData(Contance.DATA_MACHINE_NUMBER, "", String.class);
    }

    public String getSerialNumber() {
        return getSpUtils().getData(Contance.DATA_SERIAL_NUMBER, "", String.class);
    }
}
