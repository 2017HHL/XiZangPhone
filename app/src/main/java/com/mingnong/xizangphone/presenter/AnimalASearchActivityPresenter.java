package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.bean.QueryAnimABean;
import com.mingnong.xizangphone.interfac.IAnimalASearchActivity;
import com.mingnong.xizangphone.runnable.CompleteImp;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public class AnimalASearchActivityPresenter extends BaseActivityPresenter<IAnimalASearchActivity> {
    public AnimalASearchActivityPresenter(IAnimalASearchActivity view) {
        super(view);
    }

    public void refresh(String value) {
        addSubscribe(NetClient.getAnimAListData(getUser().getUSERID() + "", "AMA", "-1", "cTime,ANumber,ACargoOwner, AQuantity,ACarrier,AYongTu,AXUZHONG", value, "", "")
                .map(animAQueryListBean -> {
                    List<QueryAnimABean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectRefreshDataList(QueryAnimABean.DataListBean.class);
                    return dataList;
                }).subscribe(dataListEntity -> getView().setData(dataListEntity), new ExceptionImp(getView()), new CompleteImp(getView())));
    }

    public void loadData(String value, int tid) {
        addSubscribe(NetClient.getAnimAListData(getUser().getUSERID() + "", "AMA", tid + "", "cTime,ANumber,ACargoOwner, AQuantity,ACarrier,AYongTu,AXUZHONG", value, "", "")
                .map(animAQueryListBean -> {
                    List<QueryAnimABean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectDataList(QueryAnimABean.DataListBean.class);
                    return dataList;
                }).subscribe(dataListEntity -> getView().addListData(dataListEntity), new ExceptionImp(getView()), new CompleteImp(getView())));

    }
}
