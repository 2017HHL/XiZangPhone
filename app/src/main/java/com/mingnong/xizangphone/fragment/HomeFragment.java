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
import com.mingnong.xizangphone.activity.AnimalAActivity;
import com.mingnong.xizangphone.activity.AnimalBActivity;
import com.mingnong.xizangphone.activity.ChanDiJianYiActivity;
import com.mingnong.xizangphone.activity.ProductAActivity;
import com.mingnong.xizangphone.activity.ProductBActivity;
import com.mingnong.xizangphone.activity.ShowSdActivity;
import com.mingnong.xizangphone.activity.TuZaiJianYiActivity;
import com.mingnong.xizangphone.activity.WuHaiHuaActivity;
import com.mingnong.xizangphone.adapter.HomeBeanAdapeter;
import com.mingnong.xizangphone.bean.HomeBean;
import com.mingnong.xizangphone.interfac.IHomeFragment;
import com.mingnong.xizangphone.presenter.HomeFragmentPresenter;
import com.mingnong.xizangphone.utils.RecyclerItemClickSupport;
import com.mingnong.xizangphone.view.CustomSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

public class HomeFragment extends MVPFragment<HomeFragmentPresenter> implements IHomeFragment, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.swipeLayout)
    CustomSwipeRefreshLayout swipeLayout;
    //    @BindView(R.id.bt_name)
//    Button btName;
    Unbinder unbinder;
    private HomeBeanAdapeter adapter;
    private int size;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    protected void bindListener() {
//        btName.setOnClickListener(v -> {
//            startActivity(new Intent(getActivity(), ShowSdActivity.class));
//        } );
        swipeLayout.setOnRefreshListener(this);
        RecyclerItemClickSupport.addTo(recyclerview).setOnItemClickListener((recyclerView, position, v) -> {
                    HomeBean.DataList data = adapter.getData().get(position);
                    switch (data.getTID()) {
                        case "5":
                            //产品A
                            startActivity(new Intent(getActivity(), ProductAActivity.class));
                            break;
                        case "6":
                            //产品B
                            startActivity(new Intent(getActivity(), ProductBActivity.class));
                            break;
                        case "7":
                            //动物A
                            startActivity(new Intent(getActivity(), AnimalAActivity.class));
                            break;
                        case "8":
                            //动物B
                            startActivity(new Intent(getActivity(), AnimalBActivity.class));
                            break;
                        case "9":
                            //无害化处理
                            startActivity(new Intent(getActivity(), WuHaiHuaActivity.class));
                            break;
                        case "10":
                            //通知公告
                            startActivity(new Intent(getActivity(), ShowSdActivity.class));
                            break;
                        case "11":
                            //产地检疫
                            startActivity(new Intent(getActivity(), ChanDiJianYiActivity.class));
                            break;
                        case "12":
                            //屠宰检疫
                            startActivity(new Intent(getActivity(), TuZaiJianYiActivity.class));
                            break;
                    }
                }
        );
    }

    @Override
    protected void bindDate() {
        recyclerview.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerview.hasFixedSize();
        adapter = new HomeBeanAdapeter(new ArrayList<>());
        recyclerview.setAdapter(adapter);
        swipeLayout.post(() -> swipeLayout.setRefreshing(true));
        presenter.refresh();
    }

    @Override
    protected HomeFragmentPresenter createPresenter() {
        return new HomeFragmentPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        presenter.refresh();
    }

    @Override
    public void refreshComplete(List<HomeBean.DataList> dataLists) {
        SaveList(dataLists);
        swipeLayout.post(() -> swipeLayout.setRefreshing(false));
        List<HomeBean.DataList> list = new ArrayList<>();
        for (int i = 0; i < dataLists.size(); i++) {
            if ("39".equals(dataLists.get(i).getFMPARENT()) && "0".equals(dataLists.get(i).getTYPE())) {
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
            if ("39".equals(dataLists.get(i).getFMPARENT()) && "0".equals(dataLists.get(i).getTYPE())) {
                list.add(dataLists.get(i));
            }
        }
        adapter.setNewData(list);
    }


    /**
     * 存储
     */

    public void SaveList(List<HomeBean.DataList> list) {
        //存储操作
        SharedPreferences sp = getActivity().getSharedPreferences("mylist", Context.MODE_PRIVATE);
        String listString = new Gson().toJson(list);
        if (sp.getString("mylistStr", "") != null && sp.getString("mylistStr", "").equals(listString)) {
            return;
        } else {
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("mylistStr", listString);//存储
            edit.commit();
        }
    }

    /**
     * 取值
     */

    public List<HomeBean.DataList> GetList() {
        SharedPreferences sp = getActivity().getSharedPreferences("mylist", Context.MODE_PRIVATE);
        String liststr = sp.getString("mylistStr", "");
        List<HomeBean.DataList> lists = new Gson().fromJson(liststr, new TypeToken<List<HomeBean.DataList>>() {
        }.getType());
        return lists;
    }
}
