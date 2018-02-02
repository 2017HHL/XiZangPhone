package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.bean.QueryProductABean;
import com.mingnong.xizangphone.bean.QueryTuZaiBean;
import com.mingnong.xizangphone.interfac.ITuZaiJianYiChaXunActivity;
import com.mingnong.xizangphone.runnable.CompleteImp;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;

import java.util.List;

/**
 * Created by HUANG on 2017/7/4.
 */
public class TuZaiJianYiChaXunActivityP extends BaseActivityPresenter<ITuZaiJianYiChaXunActivity>{
    public TuZaiJianYiChaXunActivityP(ITuZaiJianYiChaXunActivity view) {
        super(view);
    }
    public void getTuZaiData(String value,String sdate,String jdate){

        addSubscribe(NetClient.getTuZaiData("0"+getUser().getUSERID()+"","TZQD","-1","cTime,QCargoOwner,memo1,QYongTu,QAttn",value,sdate,jdate)
                .map(queryTuZaiBean -> {
                    List<QueryTuZaiBean.DataListBean> dataList = new StatusException(queryTuZaiBean).getObjectRefreshDataList(QueryTuZaiBean.DataListBean.class);
                    return dataList;
                })
                .subscribe(dataListBeen -> getView().setData(dataListBeen),new ExceptionImp(getView()), new CompleteImp(getView())));

    }


    public void loadData(String value,String sdate,String jdate,String fstid){

        addSubscribe(NetClient.getTuZaiData(getUser().getUSERID()+"","TZQD",fstid,"cTime,QCargoOwner,memo1,QYongTu,QAttn",value,sdate,jdate)
                .map(queryTuZaiBean -> {
                    List<QueryTuZaiBean.DataListBean> dataList = new StatusException(queryTuZaiBean).getObjectDataList(QueryTuZaiBean.DataListBean.class);
                    if (dataList.size()==0){
                        getView().showToast("没有数据了");
                    }
                    return dataList;
                }).subscribe(DataListEntity-> getView().addListData(DataListEntity),new ExceptionImp(getView()), new CompleteImp(getView())));
    }
}
