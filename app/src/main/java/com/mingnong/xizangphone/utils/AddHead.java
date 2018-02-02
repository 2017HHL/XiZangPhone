package com.mingnong.xizangphone.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.SimpleOnItemSelectedListener;
import com.mingnong.xizangphone.view.HeadSearchView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by song on 2017/6/14.
 */

public class AddHead {


    private View headerView;
    private Context mContext;

    private AddHead.OnSearchListener onSearchListener;

    public AddHead(Context mContext, RecyclerView viewGroup, AddHead.OnSearchListener onSearchListener) {
        this.mContext = mContext;
        this.onSearchListener = onSearchListener;
        init(viewGroup);
    }


    public interface OnSearchListener {
        void onDate();

    }

    //
    private void init(ViewGroup viewGroup) {
        headerView = LayoutInflater.from(mContext).inflate(R.layout.adapter_add, viewGroup, false);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        headerView.setLayoutParams(params);

        bindListener();

    }

    private void bindListener() {

        headerView.findViewById(R.id.bt_search).setOnClickListener(v -> {
            onSearchListener.onDate();
        });
    }


    public View getHeaderView() {
        return headerView;
    }
}
