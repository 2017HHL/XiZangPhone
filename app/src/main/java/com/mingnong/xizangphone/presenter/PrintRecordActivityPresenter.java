package com.mingnong.xizangphone.presenter;


import com.mingnong.xizangphone.activity.PrintRecordActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wyw on 2016/11/29.
 */
public class PrintRecordActivityPresenter extends BaseActivityPresenter<PrintRecordActivity>{
    //主键id
    private String FStId;
    private String startDate;
    private String endDate;
    private String type;
    private String txt;
    private String table;

    public PrintRecordActivityPresenter(PrintRecordActivity view) {
        super(view);
    }

    public void loadmore() {
        addSubscribe(getRequest().search(getUser().getUSERID(),startDate,endDate,type,txt,table,FStId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .retry(3)
                .map(animListBean -> {
                    if (animListBean.getErrorCode() != 0 && animListBean.getErrorCode() != 2)
                        throw new IllegalArgumentException(animListBean.getErrorMsg());
                    if (animListBean.getData()!=null) FStId = animListBean.getData().get(animListBean.getData().size()-1).getFStId();
                    return animListBean.getData();
                }).subscribe(list -> {
                    getView().addList(list);
                },
                throwable -> {
                    getView().loadComplete();
                    getView().showToast(throwable.getMessage());
                },
                () -> getView().loadComplete()));
    }

    /**
     * update
     */
    public void search(String startDate, String endDate, String type, String txt, String table) {
        FStId = "0";
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.txt = txt;
        this.table = table;
        addSubscribe(getRequest().search(getUser().getUSERID(),startDate,endDate,type,txt,table,FStId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .retry(3)
                .map(list -> {
                    if (list.getErrorCode() != 0 && list.getErrorCode() != 2)
                        throw new IllegalArgumentException(list.getErrorMsg());
                    if (list.getData()!=null) FStId = list.getData().get(list.getData().size()-1).getFStId();
                    return list.getData();
                }).subscribe(list -> getView().setList(list),
                throwable -> {
                    getView().loadComplete();
                    getView().showToast(throwable.getMessage());
                },
                () -> getView().loadComplete()));
    }
}
