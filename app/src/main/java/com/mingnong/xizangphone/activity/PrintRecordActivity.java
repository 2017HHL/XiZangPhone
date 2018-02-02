package com.mingnong.xizangphone.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;
import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.adapter.PrintRecordAdapter;
import com.mingnong.xizangphone.bean.HomeBean;
import com.mingnong.xizangphone.bean.PrintRecordListBean;
import com.mingnong.xizangphone.interfac.Contance;
import com.mingnong.xizangphone.interfac.IPrintRecordActivity;
import com.mingnong.xizangphone.presenter.PrintRecordActivityPresenter;
import com.mingnong.xizangphone.utils.OtherUtil;
import com.mingnong.xizangphone.view.CustomSwipeRefreshLayout;
import com.mingnong.xizangphone.view.Fab;
import com.mingnong.xizangphone.view.materialsheetfab.DimOverlayFrameLayout;
import com.mingnong.xizangphone.view.materialsheetfab.MaterialSheetFab;
import com.mingnong.xizangphone.view.materialsheetfab.MaterialSheetFabEventListener;
import com.mingnong.xizangphone.view.recyclerview.BaseQuickAdapter;
import com.mingnong.xizangphone.view.recyclerview.animation.SlideInLeftAnimation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * Created by wyw on 2016/11/29.
 */

public class PrintRecordActivity extends MVPActivity<PrintRecordActivityPresenter> implements IPrintRecordActivity, SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.fab)
    Fab fab;
    @BindView(R.id.overlay)
    DimOverlayFrameLayout overlay;
    @BindView(R.id.spinner_start_year)
    Spinner spinnerStartYear;
    @BindView(R.id.spinner_start_month)
    Spinner spinnerStartMonth;
    @BindView(R.id.spinner_start_day)
    Spinner spinnerStartDay;
    @BindView(R.id.spinner_end_year)
    Spinner spinnerEndYear;
    @BindView(R.id.spinner_end_month)
    Spinner spinnerEndMonth;
    @BindView(R.id.spinner_end_day)
    Spinner spinnerEndDay;
    @BindView(R.id.spinner_content)
    Spinner spinnerContent;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.fab_sheet)
    CardView fabSheet;
    @BindView(R.id.bt_search)
    Button btSearch;
    @BindView(R.id.bt_clear)
    Button btClear;
    @BindView(R.id.swipeLayout)
    CustomSwipeRefreshLayout swipeLayout;
    private MaterialSheetFab materialSheetFab;
    private List<HomeBean.DataList.LXBean> lx;
    private PrintRecordAdapter adapter;
    private String tableName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_record);
    }

    @Override
    protected PrintRecordActivityPresenter createPresenter() {
        return new PrintRecordActivityPresenter(this);
    }

    @Override
    public void bindData() {
        materialSheetFab = new MaterialSheetFab<>(fab, fabSheet, overlay, Color.WHITE, Color.parseColor("#FFEB3B"));
        HomeBean.DataList dataList = (HomeBean.DataList) getIntent().getSerializableExtra(Contance.START_ACTIVITY_DATA);
        setTitle(dataList.getFmName());
        lx = dataList.getLX();
        ArrayList<String> list = new ArrayList<>();
        //设置类型
        for (int i = 0; i < lx.size(); i++) {
            list.add(lx.get(i).getName());
        }
        spinnerContent.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, list));

        tableName = dataList.getTName();
        //设置时间
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        spinnerStartYear.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, d(2012, year - 2012 + 10)));
        spinnerEndYear.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, d(2012, year - 2012 + 10)));
        spinnerStartMonth.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, d(1, 12)));
        spinnerEndMonth.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, d(1, 12)));
        spinnerStartDay.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, d(1, getMaxDay(year, month))));
        spinnerEndDay.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, d(1, getMaxDay(year, month))));

        //根据月份设置天数
        //设置为当前时间
        spinnerStartYear.setSelection(year - 2012);//年
        spinnerEndYear.setSelection(year - 2012);//年
        spinnerStartMonth.setSelection(c.get(Calendar.MONTH));//月
        spinnerEndMonth.setSelection(c.get(Calendar.MONTH));//月
        spinnerStartDay.setSelection(c.get(Calendar.DAY_OF_MONTH) - 1);//日
        spinnerEndDay.setSelection(c.get(Calendar.DAY_OF_MONTH) - 1);//日

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.hasFixedSize();
        adapter = new PrintRecordAdapter(new ArrayList<>());
        recyclerview.setAdapter(adapter);
        adapter.openLoadAnimation(new SlideInLeftAnimation());
        adapter.setOnLoadMoreListener(this);
        refresh();
    }

    @Override
    public void bindListener() {
        swipeLayout.setOnRefreshListener(this);
//        RecyclerItemClickSupport.addTo(recyclerview).setOnItemClickListener(this);
        RxView.clicks(btSearch).throttleFirst(150, TimeUnit.MICROSECONDS).subscribe(aVoid -> {
            if (!refresh()) return;
            materialSheetFab.hideSheet();
        });
        RxView.clicks(btClear).throttleFirst(150, TimeUnit.MICROSECONDS).subscribe(aVoid -> {
            etSearch.setText("");
        });
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH)
                {
                    if (!refresh()) return false;
                    materialSheetFab.hideSheet();
                }
                return false;
            }
        });
        materialSheetFab.setEventListener(new MaterialSheetFabEventListener() {
            @Override
            public void onShowSheet() {
            }

            @Override
            public void onHideSheet() {
            }
        });

    }

    /**
     * 将数字传化为集合，并且补充0
     *
     * @param startNum 数字起点
     * @param count    数字个数
     * @return
     */
    private List<String> d(int startNum, int count) {
        String[] values = new String[count];
        for (int i = startNum; i < startNum + count; i++) {
            String tempValue = (i < 10 ? "0" : "") + i;
            values[i - startNum] = tempValue;
        }
        return Arrays.asList(values);
    }

    /**
     * 获取当前月份的最大天数
     *
     * @param month 0-11
     * @return
     */
    private int getMaxDay(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(year, month, 1);
        c.roll(Calendar.DATE, false);
//        int maxDayOfMonth = c.get(Calendar.DATE);
//        Calendar c = Calendar.getInstance();
//        c.set(c.get(Calendar.YEAR),c.get(Calendar.MONTH),1);
//        c.roll(Calendar.DATE, false);
        return c.get(Calendar.DATE);
    }
    private boolean  refresh() {
        //拼接起始时间
        String startTime = spinnerStartYear.getSelectedItem().toString() + "-" +
                spinnerStartMonth.getSelectedItem().toString() + "-" +
                spinnerStartDay.getSelectedItem().toString();
        String endTime = spinnerEndYear.getSelectedItem().toString() + "-" +
                spinnerEndMonth.getSelectedItem().toString() + "-" +
                spinnerEndDay.getSelectedItem().toString();
        if (OtherUtil.compareTime(startTime, endTime)) {
            Toast.makeText(this, "开始时间不能大于结束时间", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (startTime.equals(endTime)) {
            getPresenter().search("", endTime, lx.get(spinnerContent.getSelectedItemPosition()).getLx(), OtherUtil.toString(etSearch), tableName);
        } else {
            getPresenter().search(startTime, endTime, lx.get(spinnerContent.getSelectedItemPosition()).getLx(), OtherUtil.toString(etSearch), tableName);
        }
        swipeLayout.setRefreshing(true);
        return true;
    }

    /**
     * 手动刷新
     */
    @Override
    public void onRefresh() {
        String startTime = spinnerStartYear.getSelectedItem().toString() + "-" +
                spinnerStartMonth.getSelectedItem().toString() + "-" +
                spinnerStartDay.getSelectedItem().toString();
        String endTime = spinnerEndYear.getSelectedItem().toString() + "-" +
                spinnerEndMonth.getSelectedItem().toString() + "-" +
                spinnerEndDay.getSelectedItem().toString();
        if (startTime.equals(endTime)) {
            getPresenter().search("", endTime, lx.get(spinnerContent.getSelectedItemPosition()).getLx(), OtherUtil.toString(etSearch), tableName);
        } else {
            getPresenter().search(startTime, endTime, lx.get(spinnerContent.getSelectedItemPosition()).getLx(), OtherUtil.toString(etSearch), tableName);
        }
    }
    /**
     *  加载更多
     */
    @Override
    public void onLoadMoreRequested() {
        getPresenter().loadmore();
    }

    @Override
    public void addList(List<PrintRecordListBean.DataListBean> list) {
        if (list == null) {
            adapter.notifyDataChangedAfterLoadMore(false);
            View view = getLayoutInflater().inflate(R.layout.default_recycler_load_finish, (ViewGroup) recyclerview.getParent(), false);
            adapter.addFooterView(view);
            Toast.makeText(this, "没有数据了", Toast.LENGTH_SHORT).show();
            return;
        }
        if (list.size() < 20) {
            new Handler().postDelayed(() -> {
                adapter.notifyDataChangedAfterLoadMore(list,false);
                View view = getLayoutInflater().inflate(R.layout.default_recycler_load_finish, (ViewGroup) recyclerview.getParent(), false);
                adapter.addFooterView(view);
                Toast.makeText(this, "没有数据了", Toast.LENGTH_SHORT).show();
            }, 500);
            return ;
        }
        new Handler().postDelayed(() -> adapter.notifyDataChangedAfterLoadMore(list, true), 500);
    }

    @Override
    public void setList(List<PrintRecordListBean.DataListBean> list) {
        if (list == null) {
            new Handler().postDelayed(() -> {
                adapter.notifyDataChangedAfterLoadMore(new ArrayList<>(),false);
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }, 500);
        }else {
            adapter.setNewData(list);
            adapter.openLoadMore(20, true);
        }
    }

    @Override
    public void loadComplete() {
        if (swipeLayout.isRefreshing()) swipeLayout.setRefreshing(false);
    }


    @Override
    public void onBackPressed() {
        if (materialSheetFab.isSheetVisible()) {
            materialSheetFab.hideSheet();
        } else {
            super.onBackPressed();
        }
    }
}
