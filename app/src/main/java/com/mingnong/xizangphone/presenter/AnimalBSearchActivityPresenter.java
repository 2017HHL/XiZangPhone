package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.interfac.IAnimalBSearchActivity;
import com.mingnong.xizangphone.runnable.CompleteImp;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public class AnimalBSearchActivityPresenter extends BaseActivityPresenter<IAnimalBSearchActivity> {
    public AnimalBSearchActivityPresenter(IAnimalBSearchActivity view) {
        super(view);
    }

    public void refresh(String value) {
        addSubscribe(NetClient.getAnimBListData(getUser().getUSERID() + "", "AMB", "-1", "cTime,AQNumber,AQCargoOwner, AQQuantity,AQYongTu", value, "", "")
                .map(animAQueryListBean -> {
                    List<QueryAnimBBean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectRefreshDataList(QueryAnimBBean.DataListBean.class);
                    return dataList;
                }).subscribe(dataListEntity -> getView().setData(dataListEntity), new ExceptionImp(getView()), new CompleteImp(getView())));
    }

    public void loadData(String value, int tid) {
        addSubscribe(NetClient.getAnimBListData(getUser().getUSERID() + "", "AMB", tid + "", "cTime,AQNumber,AQCargoOwner, AQQuantity,AQYongTu", value, "", "")
                .map(animAQueryListBean -> {
                    List<QueryAnimBBean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectDataList(QueryAnimBBean.DataListBean.class);
                    return dataList;
                }).subscribe(dataListEntity -> getView().addListData(dataListEntity), new ExceptionImp(getView()), new CompleteImp(getView())));
    }
}
