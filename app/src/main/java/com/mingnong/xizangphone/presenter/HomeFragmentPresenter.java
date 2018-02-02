package com.mingnong.xizangphone.presenter;

import android.util.Log;

import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.fragment.HomeFragment;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IHomeFragment;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.utils.NetWorkUtils;
import com.mingnong.xizangphone.utils.OtherUtil;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wyw on 2016/11/1.
 */

public class HomeFragmentPresenter extends BaseFragmentPresenter<IHomeFragment> {

    public HomeFragmentPresenter(IHomeFragment mView) {
        super(mView);
    }

    public void refresh() {
        if (NetWorkUtils.isOpenNetwork(MyApplication.getContext())) {
            addSubscribe(NetClient.getPermissionList(getUser().getFRID(), getUser().getUSERID() + "")
                    .map(homeBean -> {
                        if (homeBean.getErrorCode() != 0) {
                            throw new NullPointerException(homeBean.getErrorMsg());
                        }

                        return homeBean.getData();
                    })
                    .subscribe(dataLists -> {
                        getSpUtils().saveObjectData(Contance.DATA_PERMISSION, dataLists);
                        getView().refreshComplete(dataLists);
                    }, throwable -> {
                        getView().showToast(throwable.getMessage());
                    }));
        }else {
            getView().notIntenet();
        }

    }
}
