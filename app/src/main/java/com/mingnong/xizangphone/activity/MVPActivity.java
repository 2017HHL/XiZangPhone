package com.mingnong.xizangphone.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.mingnong.xizangphone.interfac.IMVPActivity;
import com.mingnong.xizangphone.presenter.BaseActivityPresenter;
import com.mingnong.xizangphone.utils.KeyBoardUtils;


/**
 * Created by wyw on 2016/10/31.
 */

public abstract class MVPActivity<T extends BaseActivityPresenter> extends BaseActivity implements IMVPActivity {

    private T presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    protected abstract T createPresenter();

    public T getPresenter() {
        return presenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachActivity();
        }
    }

    /**
     * 点击空白处关闭软键盘
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            //获取当前有焦点的view
            View currentFocus = getCurrentFocus();
            if (KeyBoardUtils.isHideInput(currentFocus, ev)) {
                KeyBoardUtils.hideSoftInput(this, currentFocus.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
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
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
