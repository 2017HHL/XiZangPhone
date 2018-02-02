package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.bean.QueryWHHBean;
import com.mingnong.xizangphone.interfac.IQueryListWHHActivity;
import com.mingnong.xizangphone.runnable.CompleteImp;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.runnable.StatusException;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class QueryListWHHActivityPresenter extends BaseActivityPresenter<IQueryListWHHActivity> {
    public QueryListWHHActivityPresenter(IQueryListWHHActivity view) {
        super(view);
    }

    public void getWHHListData(String value, String sdate, String jdate) {
        addSubscribe(NetClient.getWhhData(getUser().getUSERID() + "", "WHHCL", "-1", "FDEALDATE,FCTIYNAME,FCOUNTYNAME,SLAUGHTNAME,FLEGALNAME", value, sdate, jdate)
                .map(animAQueryListBean -> {
                    List<QueryWHHBean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectRefreshDataList(QueryWHHBean.DataListBean.class);
                    return dataList;
                }).subscribe(dataListEntity -> getView().setData(dataListEntity), new ExceptionImp(getView()), new CompleteImp(getView())));

    }

    public void loadData(String value, String sdate, String jdate, String tid) {
        addSubscribe(NetClient.getWhhData(getUser().getUSERID() + "", "WHHCL", tid + "", "FDEALDATE,FCTIYNAME,FCOUNTYNAME,SLAUGHTNAME,FLEGALNAME", value, sdate, jdate)
                .map(animAQueryListBean -> {
                    List<QueryWHHBean.DataListBean> dataList = new StatusException(animAQueryListBean).getObjectDataList(QueryWHHBean.DataListBean.class);
                    return dataList;
                }).subscribe(dataListEntity -> getView().addListData(dataListEntity), new ExceptionImp(getView()), new CompleteImp(getView())));
    }
}
