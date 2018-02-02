package com.mingnong.xizangphone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.adapter.QueryListCDAdapter;
import com.mingnong.xizangphone.adapter.QueryTuZaiAdapter;
import com.mingnong.xizangphone.bean.QueryListChangDI;
import com.mingnong.xizangphone.bean.QueryTuZaiBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IMVPList;
import com.mingnong.xizangphone.interfac.IQueryListChangdi;
import com.mingnong.xizangphone.presenter.QueryListChangDiPresenter;
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

public class QueryListChangDiActivity extends MVPActivity<QueryListChangDiPresenter> implements IQueryListChangdi,SpringView.OnFreshListener,IMVPList {

    @BindView(R.id.bt_back)
    ImageView btBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.bt_add)
    ImageView btAdd;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.springView)
    SpringView springView;
    @BindView(R.id.view_empty)
    RelativeLayout viewEmpty;
    String value = "";
    String startStr = "";
    String endStr = "";
    private HeadSearchView headerView;
    private QueryListCDAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_list_chang_di);
        ButterKnife.bind(this);
    }

    @Override
    protected QueryListChangDiPresenter createPresenter() {
        return new QueryListChangDiPresenter(this);
    }

    @Override
    public void bindData() {
        tvTitle.setText("场地检疫申报单");

        springView.setType(SpringView.Type.FOLLOW);
        springView.setGive(SpringView.Give.BOTH);
        springView.setHeader(new RotationHeader(getContext()));
        springView.setFooter(new RotationFooter(getContext()));
        springView.setListener(this);



        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recycler.setItemAnimator(new DefaultItemAnimator());

        headerView = new HeadSearchView(this, recycler, new HeadSearchView.OnSearchListener() {
            @Override
            public void onSearch(String strat, String end, String data) {
                value = data;
                startStr = strat;
                endStr = end;
                getPresenter().getChanDiListData(value, startStr, endStr);
            }
        });

        adapter = new QueryListCDAdapter(this,new ArrayList<>(),headerView.getHeaderView());

        recycler.setAdapter(adapter);

    }

    @Override
    public void bindListener() {
        RecyclerItemClickSupport.addTo(recycler).setOnItemClickListener(new RecyclerItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                if (position != 0) {
                    Intent intent = new Intent(QueryListChangDiActivity.this, QueryDetilChangDiActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Contance.ACTIVITY_DATA, (Serializable) adapter.getDates().get(position - 1));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
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
    public void setData(List<QueryListChangDI.DataListBean> data) {
        adapter.setmDatas(data);
    }

    @Override
    public void addListData(List<QueryListChangDI.DataListBean> list) {
        adapter.addAll(list);
    }
}
