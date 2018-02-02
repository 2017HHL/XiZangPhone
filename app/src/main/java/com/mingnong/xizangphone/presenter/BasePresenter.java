package com.mingnong.xizangphone.presenter;

import com.mingnong.xizangphone.dao.User;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IMVP;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.utils.SPUtils;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by wyw on 2016/10/31.
 */

public class BasePresenter<G extends IMVP> implements Presenter<G> {
    //activity
//    private WeakReference<T> mActivity;

    private CompositeSubscription subscription;

    //接口
    private G mView;


    private NetClient.RequestService request;

    private User user;

    public BasePresenter(G view) {
        attachActivity(view);
    }


    @Override
    public void attachActivity(G view) {
//        this.mActivity = new WeakReference<>(activity);
        this.mView = view;
        request = NetClient.getRequest();
    }

    @Override
    public void detachActivity() {
//        if (mActivity != null) mActivity = null;
        if (mView != null) mView = null;
        onUnSubscribe();
    }

    @Override
    public void addSubscribe(Subscription subscription) {
        if (this.subscription == null) {
            this.subscription = new CompositeSubscription();
        }
        this.subscription.add(subscription);
    }

    @Override
    public void addSubscribe(Observable observable, Subscriber subscriber) {
        if (this.subscription == null) {
            this.subscription = new CompositeSubscription();
        }
        ;
        this.subscription.add(observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    @Override
    public void onUnSubscribe() {
        if (subscription != null && subscription.hasSubscriptions()) {
            subscription.unsubscribe();
        }
    }

//    public T getmActivity() {
//        return mActivity.get();
//    }

    public G getView() {
        return mView;
    }

    public SPUtils getSpUtils() {
        return SPUtils.getInstance();
    }

    public NetClient.RequestService getRequest() {
        return request;
    }

    //
    public User getUser() {
        if (user == null) {
            user = (User) getSpUtils().getObjectData(Contance.USER_OBJECT);
//            user = new User();
        }
        return user;
    }

    public String getUserId() {
        //Log.e("-----------","------------------------------getUserId()-------------------------------");
        return String.valueOf(getUser().getUSERID());
    }

    public String getFuName() {
        return String.valueOf(getUser().getFUNAME());
    }

}
