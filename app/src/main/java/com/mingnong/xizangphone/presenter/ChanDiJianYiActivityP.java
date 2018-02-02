package com.mingnong.xizangphone.presenter;

import android.widget.Toast;

import com.google.gson.Gson;
import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.bean.ChanDiJianYiBean;
import com.mingnong.xizangphone.bean.DanWeiBean;
import com.mingnong.xizangphone.bean.DongwuBean;
import com.mingnong.xizangphone.bean.ShenShiBean;
import com.mingnong.xizangphone.dao.external.PrintDB;
import com.mingnong.xizangphone.interfac.IChanDiJianYiActivity;
import com.mingnong.xizangphone.runnable.DoOnSubscriber;
import com.mingnong.xizangphone.runnable.ExceptionImp;
import com.mingnong.xizangphone.runnable.StatusException;
import com.mingnong.xizangphone.utils.NetWorkUtils;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by HUANG on 2017/7/4.
 */
public class ChanDiJianYiActivityP extends BaseActivityPresenter<IChanDiJianYiActivity>{
    public ChanDiJianYiActivityP(IChanDiJianYiActivity view) {
        super(view);
    }
    public void myupload(ChanDiJianYiBean data) {
        System.out.println("+++++++"+new Gson().toJson(data));
        if (NetWorkUtils.isOpenNetwork(MyApplication.getContext())) {
            addSubscribe(getRequest().upload(getUserId(), "CDQD", new Gson().toJson(data))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .doOnSubscribe(new DoOnSubscriber(getView()))
                    .map(baseMsgBean -> {
                        if (baseMsgBean.getErrorCode() != 0) {
                            throw new IllegalArgumentException(baseMsgBean.getErrorMsg());
                        }
                        return baseMsgBean.getErrorCode();
                    })
                    .subscribe(errorCode -> {
                    }, new ExceptionImp(getView()), () -> {
                        getView().hideProgress();
                        getView().showToast("上传成功");
                        getView().uploadsuccess();
                    }));

        } else {//在没有网络的时候，把要上传的数据存储的到数据库中，当有网络的时候在服务中上传
            Toast.makeText(MyApplication.getContext(), "当前无网络状态，数据已加入离线上传队列", Toast.LENGTH_SHORT).show();
            PrintDB.getInstance(MyApplication.getContext()).insert(getUserId(), "CDQD", new Gson().toJson(data));
        }
    }
    public void ChanDiJianYi(String ashxType) {
        addSubscribe(
                getRequest().Chandijianyi(ashxType)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .map(dongwuBean -> {
                            if (dongwuBean.getErrorCode() != 0) {
                                throw new IllegalArgumentException(dongwuBean.getErrorMsg());
                            }
                            List<DongwuBean.DataListBean> dataBean = new StatusException(dongwuBean).getObjectRefreshDataList(DongwuBean.DataListBean.class);
                            System.out.println("*****dataBean******"+dataBean);
                            return dataBean;
                        }).subscribe(dataBean -> getView().setData1(dataBean), throwable -> {
                }));
    }
    public void ChanDiJianYi2(String FieldType) {
        addSubscribe(
                getRequest().Chandijianyi2(FieldType)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .map(danWeiBean -> {
                            if (danWeiBean.getErrorCode() != 0) {
                                throw new IllegalArgumentException(danWeiBean.getErrorMsg());
                            }
                            List<DanWeiBean.DataListBean> dataBean = new StatusException(danWeiBean).getObjectRefreshDataList(DanWeiBean.DataListBean.class);
                            return dataBean;
                        }).subscribe(dataBean ->

                        getView().setData2(dataBean), throwable -> {
                }));
    }
    public void ChanDiJianYi3(String FieldType) {
        addSubscribe(
                getRequest().Chandijianyi2(FieldType)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .map(danWeiBean -> {
                            if (danWeiBean.getErrorCode() != 0) {
                                throw new IllegalArgumentException(danWeiBean.getErrorMsg());
                            }
                            List<DanWeiBean.DataListBean> dataBean = new StatusException(danWeiBean).getObjectRefreshDataList(DanWeiBean.DataListBean.class);
                            return dataBean;
                        }).subscribe(dataBean ->

                        getView().setData3(dataBean), throwable -> {
                }));
    }
    public void ChanDiJianYi4() {
        addSubscribe(
                getRequest().Chandijianyi4(getFSUNITID())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .map(danWeiBean -> {
                            if (danWeiBean.getErrorCode() != 0) {
                                throw new IllegalArgumentException(danWeiBean.getErrorMsg());
                            }
                            List<ShenShiBean.DataListBean> dataBean = new StatusException(danWeiBean).getObjectRefreshDataList(ShenShiBean.DataListBean.class);
                            return dataBean;
                        }).subscribe(dataBean ->

                        getView().setData4(dataBean), throwable -> {
                }));
    }
//    public void ChanDiJianYi5() {
//        addSubscribe(getRequest().Chandijianyi5(getFSUNITID())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribeOn(Schedulers.newThread())
//                        .doOnSubscribe(new DoOnSubscriber(getView()))
//                        .map(userBean -> new StatusException(userBean).getObjectDataList(ShenShiXianBean.class))
//                        .subscribe(user -> {
//                        LocalGreenDao.getInstance().saveShen(user);
//                }, new ExceptionImp(getView()), new CompleteImp(getView())));
//    }
}
