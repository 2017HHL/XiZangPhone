package com.mingnong.xizangphone.runnable;


import rx.Subscriber;

/**
 * Created by wyw on 2016/6/26.
 */
public class NetworkSubscriber<T extends Object> extends Subscriber<T> {
    LoadingInterface loadingInterface;

    public NetworkSubscriber() {
    }

    public NetworkSubscriber(LoadingInterface loadingInterface) {
        this.loadingInterface = loadingInterface;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (loadingInterface != null) {
            loadingInterface.showLoadingView();
        }
    }

    @Override
    public void onCompleted() {
        if (loadingInterface != null) {
            loadingInterface.hideLoadingView();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (loadingInterface == null) {
            loadingInterface.showErrorView();
        }
    }

    @Override
    public void onNext(T t) {
        if (loadingInterface == null) {
            loadingInterface.hideLoadingView();
        }
    }
}
