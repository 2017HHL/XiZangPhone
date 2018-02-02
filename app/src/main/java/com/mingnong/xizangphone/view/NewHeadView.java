package com.mingnong.xizangphone.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;

import com.mingnong.xizangphone.R;

/**
 * Created by Administrator on 2017/6/20.
 */

public class NewHeadView {
    private View headerView;
    private Context mContext;
    private EditText editText;

    private OnSearchListener onSearchListener;

    public NewHeadView(Context mContext, RecyclerView viewGroup, OnSearchListener onSearchListener) {
        this.mContext = mContext;
        this.onSearchListener = onSearchListener;
        init(viewGroup);
    }


    public interface OnSearchListener {
        void onSearch(String data);
    }

    private void init(ViewGroup viewGroup) {
        headerView = LayoutInflater.from(mContext).inflate(R.layout.adapter_new_search_header, viewGroup, false);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        headerView.setLayoutParams(params);
        editText = (EditText) headerView.findViewById(R.id.et_seek_content);

        bindListener();

    }

    private void bindListener() {
        headerView.findViewById(R.id.bt_search).setOnClickListener(v -> {
            if (onSearchListener != null)
                onSearchListener.onSearch(editText.getText().toString());
        });
    }

    public View getHeaderView() {
        return headerView;
    }

}
