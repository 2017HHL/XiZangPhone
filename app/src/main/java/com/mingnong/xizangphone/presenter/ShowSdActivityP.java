package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.dao.LocalGreenDao;
import com.mingnong.xizangphone.dao.XiaoXiDaoBean;
import com.mingnong.xizangphone.dao.external.DownloadDB;
import com.mingnong.xizangphone.interfac.IShowSdActivity;
import com.mingnong.xizangphone.runnable.DoOnSubscriber;
import com.mingnong.xizangphone.runnable.StatusException;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by HUANG on 2017/7/14.
 */
public class ShowSdActivityP extends BaseActivityPresenter<IShowSdActivity>{
    private DownloadDB db;
    private HashMap<String, Call> downCalls;//用来存放各个下载的请求
    private long completedSize;
    private OkHttpClient mClient;//OKHttpClient;
    private File file;

    public ShowSdActivityP(IShowSdActivity view) {
        super(view);
    }

    public void ChanDiJianYi5() {
        System.out.println("+++"+getUserId());
        addSubscribe(getRequest().Chandijianyi5(getUserId(),"VInform","-1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnSubscribe(new DoOnSubscriber(getView()))
                .map(zhiFaZhenHaoBean -> {
                    if (zhiFaZhenHaoBean.getErrorCode() != 0) {
                        throw new IllegalArgumentException(zhiFaZhenHaoBean.getErrorMsg());
                    }
                    List<XiaoXiDaoBean> dataBean = new StatusException(zhiFaZhenHaoBean).getObjectRefreshDataList(XiaoXiDaoBean.class);
                    LocalGreenDao.getInstance().saveXiaoxi(dataBean);
                    return dataBean;
                }).subscribe(dataBean -> getView().addListData(), throwable -> {
                }));
//                .map(userBean -> new StatusException(userBean).getObjectDataList(XiaoXiDaoBean.class))
//                .subscribe(xiaoxi -> {
//                    LocalGreenDao.getInstance().saveXiaoxi(xiaoxi);
//                }, new ExceptionImp(getView()), new CompleteImp(getView())));
    }
    public void ChanDiJianYi55(String tid) {
        addSubscribe(getRequest().Chandijianyi5(getUserId(),"VInform",tid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .doOnSubscribe(new DoOnSubscriber(getView()))
                .map(zhiFaZhenHaoBean -> {
                    if (zhiFaZhenHaoBean.getErrorCode() != 0) {
                        throw new IllegalArgumentException(zhiFaZhenHaoBean.getErrorMsg());
                    }
                    List<XiaoXiDaoBean> dataBean = new StatusException(zhiFaZhenHaoBean).getObjectRefreshDataList(XiaoXiDaoBean.class);
                    if (dataBean.size()==0){
                        getView().showToast("没有数据了");
                    }else {
                        LocalGreenDao.getInstance().saveXiaoxi(dataBean);
                    }
                    return dataBean;
                }).subscribe(dataBean -> getView().setData(dataBean), throwable -> {
                }));
//                .map(userBean -> new StatusException(userBean).getObjectDataList(XiaoXiDaoBean.class))
//                .subscribe(xiaoxi -> {
//                    LocalGreenDao.getInstance().saveXiaoxi(xiaoxi);
//                }, new ExceptionImp(getView()), new CompleteImp(getView())));
    }

}
