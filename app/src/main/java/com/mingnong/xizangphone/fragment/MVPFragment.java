package com.mingnong.xizangphone.fragment;


import android.content.Context;
import android.widget.Toast;

import com.mingnong.xizangphone.interfac.IMVPFragment;
import com.mingnong.xizangphone.presenter.BaseFragmentPresenter;

/**
 * Created by wyw on 2016/11/1.
 */

public abstract class MVPFragment<T extends BaseFragmentPresenter> extends BaseFragment implements IMVPFragment {
    protected T presenter;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = createPresenter();
    }

    protected abstract T createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachActivity();
        }
    }

    public void showProgress() {
        if (!getDialog().isShowing()) {
            getDialog().show();
        }
    }

    @Override
    public void hideProgress() {
        if (getDialog().isShowing()) {
            getDialog().dismiss();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public T getPresenter() {
        return presenter;
    }
}
