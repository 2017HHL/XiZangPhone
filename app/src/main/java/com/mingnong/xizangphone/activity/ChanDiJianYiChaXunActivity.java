package com.mingnong.xizangphone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.adapter.ChandiAdapter;
import com.mingnong.xizangphone.bean.QueryProductABean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IChanDiJianYiChaXunActivity;
import com.mingnong.xizangphone.interfac.IMVPList;
import com.mingnong.xizangphone.presenter.ChanDiJianYiChaXunActivityP;
import com.mingnong.xizangphone.utils.RecyclerItemClickSupport;
import com.mingnong.xizangphone.view.HeadSearchView;
import com.mingnong.xizangphone.view.springview.container.RotationFooter;
import com.mingnong.xizangphone.view.springview.container.RotationHeader;
import com.mingnong.xizangphone.view.springview.widget.SpringView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.mingnong.xizangphone.MyApplication.getContext;

public class ChanDiJianYiChaXunActivity extends MVPActivity<ChanDiJianYiChaXunActivityP> implements IChanDiJianYiChaXunActivity, SpringView.OnFreshListener, IMVPList {
    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.springView)
    SpringView springView;
    @BindView(R.id.view_empty)
    RelativeLayout viewEmpty;
    private HeadSearchView headerView;
    private ChandiAdapter adapter;
    String value = "";
    String startStr = "";
    String endStr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chan_di_jian_yi_cha_xun);
        ButterKnife.bind(this);
    }

    @Override
    protected ChanDiJianYiChaXunActivityP createPresenter() {
        return new ChanDiJianYiChaXunActivityP(this);
    }

    @Override
    public void bindData() {
        tvTitle.setText("产地检疫查询");
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
                getPresenter().getProductAData(value, startStr, endStr);
            }
        });
        adapter = new ChandiAdapter(this, new ArrayList<>(), headerView.getHeaderView());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void bindListener() {
        viewEmpty.setOnClickListener(v -> manualRefresh());

        RecyclerItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new RecyclerItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                if (position != 0) {
                    Intent intent = new Intent(ChanDiJianYiChaXunActivity.this, QueryDetilProductAActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Contance.ACTIVITY_DATA, (Serializable) adapter.getDates().get(position - 1));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
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
                getPresenter().getProductAData(value, startStr, endStr);
            }
        }, 500);
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

    @Override
    public void onRefresh() {
        springView.onFinishFreshAndLoad();
    }

    @Override
    public void onLoadmore() {
        springView.onFinishFreshAndLoad();
        if (adapter.getDates().size() > 0) {
            getPresenter().loadData(value, startStr, endStr, adapter.getDates().get(adapter.getDates().size() - 1).getTID() + "");
        }
    }

    @Override
    public void addListData(List<QueryProductABean.DataListBean> list) {
        adapter.addAll(list);
    }

    @Override
    public void setData(List<QueryProductABean.DataListBean> dataListEntity) {
        adapter.setmDatas(dataListEntity);
    }
}
