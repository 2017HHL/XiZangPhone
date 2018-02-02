package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.bean.QueryProductABean;
import com.mingnong.xizangphone.interfac.IProductASearchActivity;
import com.mingnong.xizangphone.runnable.CompleteImp;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public class ProductASearchActivityPresenter extends BaseActivityPresenter<IProductASearchActivity> {

    public ProductASearchActivityPresenter(IProductASearchActivity view) {
        super(view);
    }

    public void refresh(String value) {
        addSubscribe(NetClient.getProductAListData(getUser().getUSERID()+"","PDA","-1","cTime,PNumber,PCargoOwner, PName,PQuantity,PCarrier",value,"","")
                .map(animAQueryListBean -> {
                    List<QueryProductABean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectRefreshDataList(QueryProductABean.DataListBean.class);
                    return dataList;
                }).subscribe(dataListEntity-> getView().setData(dataListEntity),new ExceptionImp(getView()), new CompleteImp(getView())));
    }

    public void loadData(String value,String fstid){

        addSubscribe(NetClient.getProductAListData(getUser().getUSERID()+"","PDA",fstid,"cTime,PNumber,PCargoOwner, PName,PQuantity,PCarrier",value,"","")
                .map(animAQueryListBean -> {
                    List<QueryProductABean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectDataList(QueryProductABean.DataListBean.class);
                    if (dataList.size()==0){
                        getView().showToast("没有数据了");
                    }
                    return dataList;
                }).subscribe(DataListEntity-> getView().addListData(DataListEntity),new ExceptionImp(getView()), new CompleteImp(getView())));
    }
}
