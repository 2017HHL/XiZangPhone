package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.bean.QueryListChangDI;
import com.mingnong.xizangphone.bean.QueryTuZaiBean;
import com.mingnong.xizangphone.interfac.IQueryListChangdi;
import com.mingnong.xizangphone.runnable.CompleteImp;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7 0007.
 */
public class QueryListChangDiPresenter extends BaseActivityPresenter<IQueryListChangdi>{
    public QueryListChangDiPresenter(IQueryListChangdi view) {
        super(view);
    }
    public void getChanDiListData(String Vlue,String Sdate,String Jdate){
        NetClient.getListChangDi(getUserId(),"CDQD","-1","cTime,QCargoOwner,memo1,QYongTu,QAttn","",Sdate,Jdate)
                .map(chanDiListData->{
                    List<QueryListChangDI.DataListBean> dataList = new StatusException(chanDiListData).getObjectRefreshDataList(QueryListChangDI.DataListBean.class);
                    return dataList;
                })
                .subscribe(data->getView().setData(data),new ExceptionImp(getView()), new CompleteImp(getView()));
    }


    public void loadData(String value, String Sdate, String Jdate, String fstid) {
        NetClient.getListChangDi(getUserId(),"CDQD",fstid,"cTime,QCargoOwner,memo1,QYongTu,QAttn","",Sdate,Jdate)
                .map(chanDiListData->{
                    List<QueryListChangDI.DataListBean> dataList = new StatusException(chanDiListData).getObjectDataList(QueryListChangDI.DataListBean.class);
                    return dataList;
                })
                .subscribe(data->getView().addListData(data),new ExceptionImp(getView()), new CompleteImp(getView()));

    }
}
