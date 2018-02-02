package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.interfac.IQueryListAnimalBActivity;
import com.mingnong.xizangphone.runnable.CompleteImp;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;

import java.util.List;

/**
 * Created by Administrator on 2017/5/22.
 */

public class QueryListAnimalBActivityPresenter extends BaseActivityPresenter<IQueryListAnimalBActivity> {
    public QueryListAnimalBActivityPresenter(IQueryListAnimalBActivity view) {
        super(view);
    }

    public void getAnimBListData(String value, String sdate, String jdate) {
        addSubscribe(NetClient.getAnimBListData(getUser().getUSERID() + "", "AMB", "-1", "cTime,AQNumber,AQCargoOwner, AQQuantity,AQYongTu", value, sdate, jdate)
                .map(animAQueryListBean -> {
                    List<QueryAnimBBean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectRefreshDataList(QueryAnimBBean.DataListBean.class);
                    return dataList;
                }).subscribe(dataListEntity -> getView().setData(dataListEntity), new ExceptionImp(getView()), new CompleteImp(getView())));

    }

    public void loadData(String value, String sdate, String jdate, int tid) {
        addSubscribe(NetClient.getAnimBListData(getUser().getUSERID() + "", "AMB", tid + "", "cTime,AQNumber,AQCargoOwner, AQQuantity,AQYongTu", value, sdate, jdate)
                .map(animAQueryListBean -> {
                    List<QueryAnimBBean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectDataList(QueryAnimBBean.DataListBean.class);
                    return dataList;
                }).subscribe(dataListEntity -> getView().addListData(dataListEntity), new ExceptionImp(getView()), new CompleteImp(getView())));
    }
}
