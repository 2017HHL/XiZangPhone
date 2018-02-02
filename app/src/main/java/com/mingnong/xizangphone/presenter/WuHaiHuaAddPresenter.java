package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.bean.QueryProductABean;
import com.mingnong.xizangphone.bean.WuHaIHuaAddBean;
import com.mingnong.xizangphone.interfac.IWuHaiHuaAdd;
import com.mingnong.xizangphone.runnable.CompleteImp;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;

import java.util.List;

/**
 * Created by song on 2017/6/14.
 */

public class WuHaiHuaAddPresenter extends BaseActivityPresenter<IWuHaiHuaAdd> {
    public WuHaiHuaAddPresenter(IWuHaiHuaAdd view) {
        super(view);
    }

    public void getData() {

        addSubscribe(NetClient.getAddData(getUser().getUSERID())
                .map(animAQueryListBean -> {
                    List<WuHaIHuaAddBean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectRefreshDataList(WuHaIHuaAddBean.DataListBean.class);
                    return dataList;
                }).subscribe(DataListEntity -> getView().setData(DataListEntity), new ExceptionImp(getView()), new CompleteImp(getView())));
    }

}
