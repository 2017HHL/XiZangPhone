package com.mingnong.xizangphone.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.jakewharton.rxbinding.view.RxView;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.activity.AnimProcessActivity;
import com.mingnong.xizangphone.adapter.AnimQuarantineListAdapter;
import com.mingnong.xizangphone.dao.local.DBInnerController;
import com.mingnong.xizangphone.dao.local.StoreAnimalADao;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.utils.RecyclerItemClickSupport;
import com.mingnong.xizangphone.view.CustomSwipeRefreshLayout;
import com.mingnong.xizangphone.view.recyclerview.BaseQuickAdapter;
import com.mingnong.xizangphone.view.recyclerview.animation.SlideInLeftAnimation;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;


/**
 * Created by wyw on 2016/11/9.
 * 动物检疫申报待受理信息
 */

public class LocalAnimFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.swipeLayout)
    CustomSwipeRefreshLayout swipeLayout;
    @BindView(R.id.bt_retry)
    Button btRetry;
    @BindView(R.id.rl_empty)
    RelativeLayout rlEmpty;

    private AnimQuarantineListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }


    @Override
    protected void bindListener() {
        swipeLayout.setOnRefreshListener(this);
        adapter.setOnLoadMoreListener(this);
        RecyclerItemClickSupport.addTo(recyclerview).setOnItemClickListener((recyclerView, position, v) -> {
            Intent intent = new Intent(getContext(), AnimProcessActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(Contance.START_ACTIVITY_DATA, adapter.getData().get(position));
            intent.putExtras(bundle);
            startActivity(intent);
        });
        RxView.clicks(btRetry).throttleFirst(150, TimeUnit.MILLISECONDS).subscribe(aVoid -> {
            refresh();
        });
    }

    @Override
    protected void bindDate() {
        adapter = new AnimQuarantineListAdapter(new ArrayList<>());
        adapter.openLoadMore(10, true);
        adapter.openLoadAnimation(new SlideInLeftAnimation());
        recyclerview.hasFixedSize();
        recyclerview.setAdapter(adapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        refresh();
        /**
         * 防止点查询 把之前的regist顶掉
         */
    }

    private void refresh() {
        if (rlEmpty != null) rlEmpty.setVisibility(View.GONE);
        swipeLayout.setRefreshing(true);
    }

    @Override
    public void onRefresh() {
        StoreAnimalADao aDao = DBInnerController.getDaoSession().getStoreAnimalADao();
        aDao.queryBuilder().build();
    }

    @Override
    public void onLoadMoreRequested() {

    }

//    @Override
//    public void addList(List<AnimalApplyBean> list) {
//        if (list == null) {
//            adapter.notifyDataChangedAfterLoadMore(false);
//            View view = LayoutInflater.from(getContext()).inflate(R.layout.default_recycler_load_finish, (ViewGroup) recyclerview.getParent(), false);
//            adapter.addFooterView(view);
//            Toast.makeText(getContext(), "没有数据了", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (list.size() < 10) {
//            new Handler().postDelayed(() -> {
//                adapter.notifyDataChangedAfterLoadMore(list,false);
//                View view = LayoutInflater.from(getContext()).inflate(R.layout.default_recycler_load_finish, (ViewGroup) recyclerview.getParent(), false);
//                adapter.addFooterView(view);
//                Toast.makeText(getContext(), "没有数据了", Toast.LENGTH_SHORT).show();
//            }, 500);
//            return ;
//        }
//        new Handler().postDelayed(() -> adapter.notifyDataChangedAfterLoadMore(list, true), 500);
//    }

//    @Override
//    public void loadComplete() {
//        if (swipeLayout.isRefreshing()) swipeLayout.setRefreshing(false);
//    }

//    @Override
//    public void setList(List<AnimalApplyBean> list) {
//        if (list == null) {
//            new Handler().postDelayed(() -> {
//                adapter.notifyDataChangedAfterLoadMore(new ArrayList<>(),false);
////                Toast.makeText(getContext(), "没有数据", Toast.LENGTH_SHORT).show();
//                if (rlEmpty != null)
//                rlEmpty.setVisibility(View.VISIBLE);
//            }, 500);
//        }else {
//            if (rlEmpty != null)
//            rlEmpty.setVisibility(View.GONE);
//            adapter.setNewData(list);
//            adapter.openLoadMore(10, true);
//        }
//    }
}
