package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.bean.QueryProductABean;
import com.mingnong.xizangphone.bean.QueryProductBBean;
import com.mingnong.xizangphone.interfac.IQueryListProductionBActivity;
import com.mingnong.xizangphone.runnable.CompleteImp;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */

public class QueryListProductionBActivityPresenter extends BaseActivityPresenter<IQueryListProductionBActivity> {
    public QueryListProductionBActivityPresenter(IQueryListProductionBActivity view) {
        super(view);
    }

    public void getProductBData(String value,String sdate,String jdate){

        addSubscribe(NetClient.getProductBListData(getUser().getUSERID()+"","PDB","-1","cTime,PBNumber,PBCargoOwner, PBName,PBQuantity",value,sdate,jdate)
                .map(animAQueryListBean -> {
                    List<QueryProductBBean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectRefreshDataList(QueryProductBBean.DataListBean.class);
                    return dataList;
                }).subscribe(DataListEntity-> getView().setData(DataListEntity),new ExceptionImp(getView()), new CompleteImp(getView())));
    }


    public void loadData(String value,String sdate,String jdate,String fstid){

        addSubscribe(NetClient.getProductBListData(getUser().getUSERID()+"","PDB",fstid,"cTime,PBNumber,PBCargoOwner, PBName,PBQuantity",value,sdate,jdate)
                .map(animAQueryListBean -> {
                    List<QueryProductBBean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectDataList(QueryProductBBean.DataListBean.class);
                    if (dataList.size()==0){
                        getView().showToast("没有数据了");
                    }
                    return dataList;
                }).subscribe(DataListEntity-> getView().addListData(DataListEntity),new ExceptionImp(getView()), new CompleteImp(getView())));
    }

}
