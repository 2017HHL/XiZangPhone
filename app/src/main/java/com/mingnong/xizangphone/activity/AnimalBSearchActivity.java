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
import com.mingnong.xizangphone.adapter.AnimalASearchAdapter;
import com.mingnong.xizangphone.adapter.AnimalBSearchAdapter;
import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IAnimalBSearchActivity;
import com.mingnong.xizangphone.interfac.IMVPList;
import com.mingnong.xizangphone.presenter.AnimalBSearchActivityPresenter;
import com.mingnong.xizangphone.utils.RecyclerItemClickSupport;
import com.mingnong.xizangphone.view.NewHeadView;
import com.mingnong.xizangphone.view.springview.container.RotationFooter;
import com.mingnong.xizangphone.view.springview.container.RotationHeader;
import com.mingnong.xizangphone.view.springview.widget.SpringView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.id.list;
import static com.mingnong.xizangphone.MyApplication.getContext;

/**
 * Created by Administrator on 2017/6/20.
 */
public class AnimalBSearchActivity extends MVPActivity<AnimalBSearchActivityPresenter> implements IAnimalBSearchActivity, SpringView.OnFreshListener, IMVPList {

    @BindView(R.id.recycler)
    RecyclerView mRecyclerView;
    @BindView(R.id.springView)
    SpringView springView;
    @BindView(R.id.view_empty)
    RelativeLayout viewEmpty;

    private String value = "";
    private AnimalBSearchAdapter adapter;
    private NewHeadView headSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);
        ButterKnife.bind(this);
    }

    @Override
    protected AnimalBSearchActivityPresenter createPresenter() {
        return new AnimalBSearchActivityPresenter(this);
    }

    @Override
    public void bindData() {
        setTitle("动物B搜索");
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
        headSearchView = new NewHeadView(this, mRecyclerView, new NewHeadView.OnSearchListener() {
            @Override
            public void onSearch(String data) {
                value = data;
                getPresenter().refresh(value);
            }
        });
        adapter = new AnimalBSearchAdapter(this, new ArrayList<>(), headSearchView.getHeaderView());
        mRecyclerView.setAdapter(adapter);
        getPresenter().refresh(value);
    }

    @Override
    public void bindListener() {
        viewEmpty.setOnClickListener(v -> manualRefresh());

        RecyclerItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new RecyclerItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                if (position != 0) {
                    Intent intent = new Intent(AnimalBSearchActivity.this, AnimalBActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Contance.ACTIVITY_DATA, (Serializable) adapter.getDates().get(position - 1));
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
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
            getPresenter().loadData(value, adapter.getDates().get(adapter.getDates().size() - 1).getTID());
        }
    }

    @Override
    public void setData(List<QueryAnimBBean.DataListBean> dataListEntity) {
        adapter.setmDatas(dataListEntity);
    }

    @Override
    public void addListData(List<QueryAnimBBean.DataListBean> list) {
        if (list.size() == 0) {
            return;
        } else {
            adapter.addAll(list);
        }
    }
}
