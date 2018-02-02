package com.mingnong.xizangphone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.QueryAnimBBean;
import com.mingnong.xizangphone.bean.QueryWHHBean;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */

public class QueryWHHAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<QueryWHHBean.DataListBean> list;
    private Context context;
    private View headerView;
    private final LayoutInflater mLayoutInflater;

    //建立枚举，2个item类型
    public enum ITEM_TYPE {
        ITEM_HEAD,
        ITEM_LISTVIEM
    }

    public QueryWHHAdapter(Context context, List<QueryWHHBean.DataListBean> list, View headerView) {
        this.context = context;
        this.headerView = headerView;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setmDatas(List<QueryWHHBean.DataListBean> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.clear();
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void addAll(List<QueryWHHBean.DataListBean> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }


    public List<QueryWHHBean.DataListBean> getDates() {
        return list;
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_HEAD.ordinal()) {
            return new HeadViewHolder(headerView);
        } else {
            return new ListviewViewHolder(mLayoutInflater.inflate(R.layout.whh_adapter, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ListviewViewHolder) {
            ((ListviewViewHolder) holder).tvShidiName.setText(list.get(position - 1).getFCTIYNAME());
            ((ListviewViewHolder) holder).tvQuxianName.setText(list.get(position - 1).getFCOUNTYNAME());
            ((ListviewViewHolder) holder).tvTuzaiName.setText(list.get(position - 1).getSLAUGHTNAME());
            ((ListviewViewHolder) holder).tvDaibiaoName.setText(list.get(position - 1).getFDEALDATE() + "");
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

        private TextView tvShidiName;
        private TextView tvQuxianName;
        private TextView tvTuzaiName;
        private TextView tvDaibiaoName;

        private ListviewViewHolder(View view) {
            super(view);
            tvShidiName = (TextView) view.findViewById(R.id.tv_shidi_name);
            tvQuxianName = (TextView) view.findViewById(R.id.tv_quxian_name);
            tvTuzaiName = (TextView) view.findViewById(R.id.tv_tuzai_name);
            tvDaibiaoName = (TextView) view.findViewById(R.id.tv_daibiao_name);

        }
    }

    private class HeadViewHolder extends RecyclerView.ViewHolder {
        private HeadViewHolder(View view) {
            super(view);
        }
    }
}
