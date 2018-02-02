package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.bean.QueryAnimABean;
import com.mingnong.xizangphone.interfac.IQueryListAnimalAActivity;
import com.mingnong.xizangphone.runnable.CompleteImp;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
public class QueryListAnimalAActivityPresenter extends BaseActivityPresenter<IQueryListAnimalAActivity> {
    public QueryListAnimalAActivityPresenter(IQueryListAnimalAActivity view) {
        super(view);
    }

    public void getAnimAListData(String value, String sdate, String jdate) {
        addSubscribe(NetClient.getAnimAListData(getUser().getUSERID() + "", "AMA", "-1", "cTime,ANumber,ACargoOwner, AQuantity,ACarrier,AYongTu,AXUZHONG", value, sdate, jdate)
                .map(animAQueryListBean -> {
                    List<QueryAnimABean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectRefreshDataList(QueryAnimABean.DataListBean.class);
                    return dataList;
                }).subscribe(dataListEntity -> getView().setData(dataListEntity), new ExceptionImp(getView()), new CompleteImp(getView())));

    }

    public void loadData(String value, String sdate, String jdate, int tid) {
        addSubscribe(NetClient.getAnimAListData(getUser().getUSERID() + "", "AMA", tid + "", "cTime,ANumber,ACargoOwner, AQuantity,ACarrier,AYongTu,AXUZHONG", value, sdate, jdate)
                .map(animAQueryListBean -> {
                    List<QueryAnimABean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectDataList(QueryAnimABean.DataListBean.class);
                    if (dataList.size() == 0) {
                        getView().showToast("没有数据了");
                    }
                    return dataList;
                }).subscribe(dataListEntity -> getView().addListData(dataListEntity), new ExceptionImp(getView()), new CompleteImp(getView())));

    }
}
