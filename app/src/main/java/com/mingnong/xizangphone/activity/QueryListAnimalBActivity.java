package com.mingnong.xizangphone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.adapter.QueryAnimBAdapter;
import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IMVPList;
import com.mingnong.xizangphone.interfac.IQueryListAnimalBActivity;
import com.mingnong.xizangphone.presenter.QueryListAnimalBActivityPresenter;
import com.mingnong.xizangphone.utils.RecyclerItemClickSupport;
import com.mingnong.xizangphone.view.HeadSearchView;
import com.mingnong.xizangphone.view.springview.container.RotationFooter;
import com.mingnong.xizangphone.view.springview.container.RotationHeader;
import com.mingnong.xizangphone.view.springview.widget.SpringView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.mingnong.xizangphone.MyApplication.getContext;

/**
 * 动物B查询列表
 * Created by Administrator on 2017/5/19.
 */

public class QueryListAnimalBActivity extends MVPActivity<QueryListAnimalBActivityPresenter> implements IQueryListAnimalBActivity,
        SpringView.OnFreshListener, IMVPList {

    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.springView)
    SpringView springView;
    @BindView(R.id.view_empty)
    RelativeLayout viewEmpty;

    String value = "";
    String startStr = "";
    String endStr = "";
    private HeadSearchView headerView;
    private QueryAnimBAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);
    }

    @Override
    protected QueryListAnimalBActivityPresenter createPresenter() {
        return new QueryListAnimalBActivityPresenter(this);
    }


    @Override
    public void bindData() {
        setTitle("动物B查询列表");
        mRecyclerView.setHasFixedSize(true);
        springView.setType(SpringView.Type.FOLLOW);
        springView.setGive(SpringView.Give.BOTH);
        springView.setHeader(new RotationHeader(getContext()));   //参数为：logo图片资源，是否显示文字
        springView.setFooter(new RotationFooter(getContext()));
        springView.setListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        headerView = new HeadSearchView(this, mRecyclerView, new HeadSearchView.OnSearchListener() {
            @Override
            public void onSearch(String strat, String end, String data) {
                value = data;
                startStr = strat;
                endStr = end;
                getPresenter().getAnimBListData(data, strat, end);
            }
        });
        adapter = new QueryAnimBAdapter(this, new ArrayList<>(), headerView.getHeaderView());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void bindListener() {
        viewEmpty.setOnClickListener(v -> manualRefresh());
        RecyclerItemClickSupport.addTo(mRecyclerView).setOnItemClickListener((recyclerView, position, v) -> {
            if (position != 0) {
                Intent intent = new Intent(this, QueryDetilAnimalBActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(Contance.ACTIVITY_DATA, (Serializable) adapter.getDates().get(position - 1));
                intent.putExtras(bundle);
                startActivity(intent);
            }

        });
    }

    /**
     * 手动刷新
     */
    public void manualRefresh() {
        viewEmpty.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                springView.callFresh();
            }
        }, 500);
    }

    @Override
    public void onRefresh() {
        springView.onFinishFreshAndLoad();
    }

    @Override
    public void onLoadmore() {
        springView.onFinishFreshAndLoad();
        if (adapter.getDates().size() > 0) {
            getPresenter().loadData(value, startStr, endStr, adapter.getDates().get(adapter.getDates().size() - 1).getTID());
        }
    }

    @Override
    public void setData(List<QueryAnimBBean.DataListBean> list) {
        adapter.setmDatas(list);
    }

    @Override
    public void addListData(List<QueryAnimBBean.DataListBean> list) {
        adapter.addAll(list);
    }

    @Override
    public void onError() {
        springView.onFinishFreshAndLoad();
    }

    @Override
    public void refreshNone() {
        adapter.clear();
        springView.onFinishFreshAndLoad();
    }
}
