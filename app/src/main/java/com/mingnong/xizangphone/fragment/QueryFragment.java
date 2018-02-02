package com.mingnong.xizangphone.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.activity.ChanDiJianYiActivity;
import com.mingnong.xizangphone.activity.QueryListAnimalAActivity;
import com.mingnong.xizangphone.activity.QueryListAnimalBActivity;
import com.mingnong.xizangphone.activity.QueryListChangDiActivity;
import com.mingnong.xizangphone.activity.QueryListProductAActivity;
import com.mingnong.xizangphone.activity.QueryListProductBActivity;
import com.mingnong.xizangphone.activity.QueryListWHHActivity;
import com.mingnong.xizangphone.activity.TuZaiJianYiActivity;
import com.mingnong.xizangphone.activity.TuZaiJianYiChaXunActivity;
import com.mingnong.xizangphone.adapter.HomeBeanAdapeter;
import com.mingnong.xizangphone.bean.HomeBean;
import com.mingnong.xizangphone.interfac.IQueryFragment;
import com.mingnong.xizangphone.presenter.QueryFragmentPresenter;
import com.mingnong.xizangphone.presenter.TuZaiJianYiChaXunActivityP;
import com.mingnong.xizangphone.utils.RecyclerItemClickSupport;
import com.mingnong.xizangphone.view.CustomSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class QueryFragment extends MVPFragment<QueryFragmentPresenter> implements IQueryFragment,
        SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.swipeLayout)
    CustomSwipeRefreshLayout swipeLayout;
    private HomeBeanAdapeter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_query, container, false);
        return view;
    }

    @Override
    protected void bindListener() {
        swipeLayout.setOnRefreshListener(this);
        RecyclerItemClickSupport.addTo(recyclerview).setOnItemClickListener((recyclerView, position, v) -> {
                    HomeBean.DataList data = adapter.getData().get(position);
                    switch (data.getTID()) {
                        case "5":
                            //产品A
                            startActivity(new Intent(getActivity(), QueryListProductAActivity.class));
                            break;
                        case "6":
                            //产品B
                            startActivity(new Intent(getActivity(), QueryListProductBActivity.class));
                            break;
                        case "7":
                            //动物A
                            startActivity(new Intent(getActivity(), QueryListAnimalAActivity.class));
                            break;
                        case "8":
                            //动物B
                            startActivity(new Intent(getActivity(), QueryListAnimalBActivity.class));
                            break;
                        case "9":
                            //无害化处理
                            startActivity(new Intent(getActivity(), QueryListWHHActivity.class));
                            break;
                        case "11":
                            //场地检疫
                            startActivity(new Intent(getActivity(), QueryListChangDiActivity.class));
                            break;
                        case "12":
                            //屠宰检疫
                            startActivity(new Intent(getActivity(), TuZaiJianYiChaXunActivity.class));
                            break;
                    }
                }
        );
    }

    @Override
    protected void bindDate() {
        recyclerview.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerview.hasFixedSize();
        recyclerview.setHasFixedSize(true);
        adapter = new HomeBeanAdapeter(new ArrayList<>());
        recyclerview.setAdapter(adapter);
        swipeLayout.post(() -> swipeLayout.setRefreshing(true));
        presenter.refresh();


    }

    @Override
    protected QueryFragmentPresenter createPresenter() {
        return new QueryFragmentPresenter(this);
    }


    @Override
    public void refreshComplete(List<HomeBean.DataList> dataLists) {
        swipeLayout.post(() -> swipeLayout.setRefreshing(false));
        List<HomeBean.DataList> list = new ArrayList<>();
        for (int i = 0; i < dataLists.size(); i++) {
            if ("39".equals(dataLists.get(i).getFMPARENT()) && "0".equals(dataLists.get(i).getTYPE()) && (!"10".equals(dataLists.get(i).getTID()))) {
                list.add(dataLists.get(i));
            }
        }
        adapter.setNewData(list);
    }

    @Override
    public void notIntenet() {
        swipeLayout.post(() -> swipeLayout.setRefreshing(false));
        List<HomeBean.DataList> dataLists = GetList();
        List<HomeBean.DataList> list = new ArrayList<>();
        for (int i = 0; i < dataLists.size(); i++) {
            if ("39".equals(dataLists.get(i).getFMPARENT()) && "0".equals(dataLists.get(i).getTYPE()) && (!"10".equals(dataLists.get(i).getTID()))) {
                list.add(dataLists.get(i));
            }
        }
        adapter.setNewData(list);
    }

    @Override
    public void onRefresh() {
        presenter.refresh();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public List<HomeBean.DataList> GetList() {
        SharedPreferences sp = getActivity().getSharedPreferences("mylist", Context.MODE_PRIVATE);
        String liststr = sp.getString("mylistStr", "");
        List<HomeBean.DataList> lists = new Gson().fromJson(liststr, new TypeToken<List<HomeBean.DataList>>() {
        }.getType());
        return lists;
    }
}
