package com.mingnong.xizangphone.runnable;

import android.util.Log;
import android.widget.Toast;

import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.interfac.IMVP;
import com.mingnong.xizangphone.interfac.IMVPList;

import retrofit2.adapter.rxjava.HttpException;
import rx.functions.Action1;

/**
 * Created by wyw on 2016/12/20.
 * subscribe()回调完成监听
 */

public class ExceptionImp implements Action1<Throwable> {
    private IMVP view;

    public ExceptionImp() {
    }

    public ExceptionImp(IMVP view) {
        this.view = view;
    }

    @Override
    public void call(Throwable throwable) {
        throwable.printStackTrace();
        if (view != null) {
            view.hideProgress();
        }
        if (throwable instanceof RefreshException && view instanceof IMVPList) {
            ((IMVPList) view).refreshNone();
        }
        Log.e("ExceptionImp", "error: " + throwable.getMessage());
        if (throwable instanceof HttpException) {
            switch (((HttpException) throwable).code()) {
                case 404:
                    Toast.makeText(MyApplication.getContext(), "网页没有找到404", Toast.LENGTH_SHORT).show();
                case 500:
                    Toast.makeText(MyApplication.getContext(), "服务器错误500", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(MyApplication.getContext(), "error:" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (view instanceof IMVPList) {
            ((IMVPList) view).onError();
        }
    }
}
