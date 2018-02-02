package com.mingnong.xizangphone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.WuHaIHuaAddBean;

import java.util.ArrayList;
import java.util.List;

import static com.mingnong.xizangphone.R.id.bt_que;

/**
 * Created by song on 2017/6/14.
 */

public class WuHaiHuaAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<WuHaIHuaAddBean.DataListBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater mLayoutInflater;
    View headerView;

    //建立枚举，2个item类型
    public enum ITEM_TYPE {
        ITEM_HEAD,
        ITEM_LISTVIEM
    }

    public WuHaiHuaAdapter(Context context, List<WuHaIHuaAddBean.DataListBean> list, View headerView) {
        this.context = context;
        this.headerView = headerView;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    public void setmDatas(List<WuHaIHuaAddBean.DataListBean> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.clear();
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void addAll(List<WuHaIHuaAddBean.DataListBean> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public List<WuHaIHuaAddBean.DataListBean> getDates() {
        return list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new HeadViewHolder(headerView);
        } else {
            return new ListviewViewHolder(mLayoutInflater.inflate(R.layout.adapter_add_wuhaihua, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ListviewViewHolder) {

            ((ListviewViewHolder) holder).tv_shidi.setText(list.get(position -1).getShiName());//市地名
            ((ListviewViewHolder) holder).tv_quxian.setText(list.get(position -1 ).getUnitName());//区县名
            ((ListviewViewHolder) holder).tv_name.setText(list.get(position -1 ).getSName());//屠宰场名
            ((ListviewViewHolder) holder).tv_fading.setText(list.get(position -1 ).getSCorporateRe());//法定代表人
            ((ListviewViewHolder) holder).tv_photo.setText(list.get(position -1).getSTel());//联系电话

        }
    }

    //设置ITEM类型，可以自由发挥，这里设置item 0单数显示head item 其他显示listview item
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE.ITEM_HEAD.ordinal();
        } else {
            return ITEM_TYPE.ITEM_LISTVIEM.ordinal();
        }
    }

    @Override
    public int getItemCount() {
        if (list == null || list.size() == 0) {
            return 1;
        }
        return list.size() + 1;
    }


    private class ListviewViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_shidi;
        private TextView tv_quxian;
        private TextView tv_name;
        private TextView tv_fading;
        private TextView tv_photo;
//        private Button bt_que;

        private ListviewViewHolder(View view) {
            super(view);
            tv_shidi = (TextView) view.findViewById(R.id.tv_shidi);
            tv_quxian = (TextView) view.findViewById(R.id.tv_quxian);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_fading = (TextView) view.findViewById(R.id.tv_fading);
            tv_photo = (TextView) view.findViewById(R.id.tv_photo);
//            bt_que = (Button) view.findViewById(R.id.bt_que);
        }
    }

    private class HeadViewHolder extends RecyclerView.ViewHolder {
        private HeadViewHolder(View view) {
            super(view);
        }
    }
}
