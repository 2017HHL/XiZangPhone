package com.mingnong.xizangphone.view;

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
import com.mingnong.xizangphone.utils.OtherUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by zhyzh on 2017/3/29.
 */

public class HeadSearchView {
    private Spinner spStartYear;
    private Spinner spStartMonth;
    private Spinner spStartDay;
    private Spinner spEndYear;
    private Spinner spEndMonth;
    private Spinner spEndDay;
    //数据源
    private List<String> startDayList;
    private List<String> endDayList;

    private View headerView;
    private Context mContext;
    private EditText editText;

    private OnSearchListener onSearchListener;

    public HeadSearchView(Context mContext, RecyclerView viewGroup, OnSearchListener onSearchListener) {
        this.mContext = mContext;
        this.onSearchListener = onSearchListener;
        init(viewGroup);
    }


    public interface OnSearchListener {
        void onSearch(String strat, String end, String data);

    }

    //
    private void init(ViewGroup viewGroup) {
        headerView = LayoutInflater.from(mContext).inflate(R.layout.adapter_search_header, viewGroup, false);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        headerView.setLayoutParams(params);
        editText = (EditText) headerView.findViewById(R.id.et_seek_content);

        spStartYear = (Spinner) headerView.findViewById(R.id.spinner_start_year);
        spStartMonth = (Spinner) headerView.findViewById(R.id.spinner_start_month);
        spStartDay = (Spinner) headerView.findViewById(R.id.spinner_start_day);
        spEndYear = (Spinner) headerView.findViewById(R.id.spinner_end_year);
        spEndMonth = (Spinner) headerView.findViewById(R.id.spinner_end_month);
        spEndDay = (Spinner) headerView.findViewById(R.id.spinner_end_day);
        setTime();
        bindListener();

    }

    private void bindListener() {
        spStartYear.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onStartSpinnerSelect();
            }
        });
        spStartMonth.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onStartSpinnerSelect();
            }
        });
        spEndYear.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onEndSpinnerSelect();
            }
        });
        spEndMonth.setOnItemSelectedListener(new SimpleOnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onEndSpinnerSelect();
            }
        });
        headerView.findViewById(R.id.bt_search).setOnClickListener(v -> {
            if (onSearchListener != null)
                onSearchListener.onSearch(spStartYear.getSelectedItem().toString() + "-" +
                                spStartMonth.getSelectedItem().toString() + "-" +
                                spStartDay.getSelectedItem().toString(),
                        spEndYear.getSelectedItem().toString() + "-" +
                                spEndMonth.getSelectedItem().toString() + "-" +
                                spEndDay.getSelectedItem().toString(), editText.getText().toString());
        });
    }

    /**
     * @return index 0  startDate
     * index 1  endDate
     * index 2  searchText
     */
    public String[] getCurrentParams() {
        return new String[]{spStartYear.getSelectedItem().toString() + "-" +
                spStartMonth.getSelectedItem().toString() + "-" +
                spStartDay.getSelectedItem().toString(), spEndYear.getSelectedItem().toString() + "-" +
                spEndMonth.getSelectedItem().toString() + "-" +
                spEndDay.getSelectedItem().toString(), editText.getText().toString()};
    }

    private void onStartSpinnerSelect() {
        startDayList.clear();
        String year = spStartYear.getSelectedItem().toString();
        Integer month = Integer.valueOf(spStartMonth.getSelectedItem().toString());
        startDayList.addAll(OtherUtil.createDays(year, String.valueOf(month)));
        ((ArrayAdapter) spStartDay.getAdapter()).notifyDataSetChanged();
    }

    private void onEndSpinnerSelect() {
        endDayList.clear();
        String year = spEndYear.getSelectedItem().toString();
        Integer month = Integer.valueOf(spEndMonth.getSelectedItem().toString());
        endDayList.addAll(OtherUtil.createDays(year, String.valueOf(month)));
        ((ArrayAdapter) spEndDay.getAdapter()).notifyDataSetChanged();
    }

    private void setTime() {
        spStartYear.setAdapter(new ArrayAdapter<>(mContext, R.layout.spinner_simple, R.id.tv,
                OtherUtil.createYears()));
        spStartMonth.setAdapter(new ArrayAdapter<>(mContext, R.layout.spinner_simple, R.id.tv,
                OtherUtil.createMonths()));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        startDayList = OtherUtil.createDays(String.valueOf(calendar.get(Calendar.YEAR)),
                String.valueOf(calendar.get(Calendar.MONTH) + 1));
        spStartDay.setAdapter(new ArrayAdapter<>(mContext, R.layout.spinner_simple, R.id.tv, startDayList));

        spEndYear.setAdapter(new ArrayAdapter<>(mContext, R.layout.spinner_simple, R.id.tv,
                OtherUtil.createYears()));
        spEndMonth.setAdapter(new ArrayAdapter<>(mContext, R.layout.spinner_simple, R.id.tv,
                OtherUtil.createMonths()));
        calendar.setTime(new Date());
        endDayList = OtherUtil.createDays(String.valueOf(calendar.get(Calendar.YEAR)),
                String.valueOf(calendar.get(Calendar.MONTH) + 1));
        spEndDay.setAdapter(new ArrayAdapter<>(mContext, R.layout.spinner_simple, R.id.tv, endDayList));

        //默认月初
        spStartYear.setSelection(4);
        spStartMonth.setSelection(OtherUtil.getCurrentMonthPosition());
        spStartDay.setSelection(0);
        //默认当天
        spEndYear.setSelection(4);
        spEndMonth.setSelection(OtherUtil.getCurrentMonthPosition());
        spEndDay.setSelection(OtherUtil.getCurrentDayPosition());
    }

    public View getHeaderView() {
        return headerView;
    }
}
