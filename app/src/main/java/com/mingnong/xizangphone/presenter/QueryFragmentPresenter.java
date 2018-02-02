package com.mingnong.xizangphone.presenter;


import com.mingnong.xizangphone.MyApplication;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IQueryFragment;
import com.mingnong.xizangphone.runnable.NetClient;
import com.mingnong.xizangphone.utils.NetWorkUtils;

/**
 * Created by wyw on 2016/11/29.
 */
public class QueryFragmentPresenter extends BaseFragmentPresenter<IQueryFragment> {
    public QueryFragmentPresenter(IQueryFragment mView) {
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
        } else {
            getView().notIntenet();
        }
    }
}
