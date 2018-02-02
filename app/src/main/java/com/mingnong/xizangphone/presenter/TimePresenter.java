package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.bean.BaseMsgBean;
import com.mingnong.xizangphone.interfac.ITime;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Administrator on 2017/5/3.
 */

public class TimePresenter extends BaseActivityPresenter<ITime> {

    public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CANADA);

    public TimePresenter(ITime view) {
        super(view);
    }

    public void getTime() {
        addSubscribe(NetClient.getDate()
                .map(baseMsgBean -> new StatusException(baseMsgBean).getObjectData(BaseMsgBean.Data.class))
                .subscribe(baseMsgBean -> {
                            long longTime = new Date().getTime();
                            try {
                                longTime = format.parse(baseMsgBean.getResult()).getTime();
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            getView().setTime(baseMsgBean.getResult(), longTime);
                        },
                        throwable -> {
                            //获取本地时间
                            Date date = new Date();
                            getView().setTime(format.format(date), date.getTime());
                        }));
    }

}
