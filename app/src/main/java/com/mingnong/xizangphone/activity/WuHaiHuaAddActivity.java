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
import com.mingnong.xizangphone.adapter.WuHaiHuaAdapter;
import com.mingnong.xizangphone.bean.WuHaIHuaAddBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IWuHaiHuaAdd;
import com.mingnong.xizangphone.presenter.WuHaiHuaAddPresenter;
import com.mingnong.xizangphone.utils.AddHead;
import com.mingnong.xizangphone.utils.RecyclerItemClickSupport;
import com.mingnong.xizangphone.view.springview.container.RotationFooter;
import com.mingnong.xizangphone.view.springview.container.RotationHeader;
import com.mingnong.xizangphone.view.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.mingnong.xizangphone.MyApplication.getContext;

public class WuHaiHuaAddActivity extends MVPActivity<WuHaiHuaAddPresenter> implements IWuHaiHuaAdd, SpringView.OnFreshListener {

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


    private AddHead headerView;
    private WuHaiHuaAdapter adapter;
    private static final int TAKE_PHOTO_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wu_hai_hua_add);
    }

    @Override
    protected WuHaiHuaAddPresenter createPresenter() {
        return new WuHaiHuaAddPresenter(this);
    }

    @Override
    public void bindData() {
        tvTitle.setText("屠宰场查询列表");
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
        headerView = new AddHead(this, mRecyclerView, new AddHead.OnSearchListener() {
            @Override
            public void onDate() {
                getPresenter().getData();
            }
        }
        );
        adapter = new WuHaiHuaAdapter(this, new ArrayList<>(), headerView.getHeaderView());
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public void bindListener() {
        btBack.setOnClickListener(v -> {
            finish();
        });
        viewEmpty.setOnClickListener(v -> manualRefresh());
        RecyclerItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new RecyclerItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                if (position != 0) {
                    Intent intent = getIntent();
                    Bundle bundle = new Bundle();
                    WuHaIHuaAddBean.DataListBean listBean = adapter.getDates().get(position - 1);
                    bundle.putSerializable(Contance.ACTIVITY_DATA, listBean);
                    intent.putExtras(bundle);
                    setResult(100, intent);
                    finish();
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        adapter.clear();
        springView.onFinishFreshAndLoad();
    }

    @Override
    public void onLoadmore() {
        springView.onFinishFreshAndLoad();
        if (adapter.getDates().size() > 0) {
            getPresenter().getData();
        }
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
                getPresenter().getData();
            }
        }, 500);
    }

    @Override
    public void setData(List<WuHaIHuaAddBean.DataListBean> dataListEntity) {
        adapter.setmDatas(dataListEntity);
    }
}


