package com.mingnong.xizangphone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.QueryAnimABean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public class AnimalASearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<QueryAnimABean.DataListBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater mLayoutInflater;
    View headerView;


    //建立枚举，2个item类型
    public enum ITEM_TYPE {
        ITEM_HEAD,
        ITEM_LISTVIEM
    }

    public AnimalASearchAdapter(Context context, List<QueryAnimABean.DataListBean> list, View headerView) {
        this.context = context;
        this.headerView = headerView;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    public List<QueryAnimABean.DataListBean> getDates() {
        return list;
    }

    public void setmDatas(List<QueryAnimABean.DataListBean> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.clear();
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void addAll(List<QueryAnimABean.DataListBean> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == QueryProductAAdapter.ITEM_TYPE.ITEM_HEAD.ordinal()) {
            return new HeadViewHolder(headerView);
        } else {
            return new ListviewViewHolder(mLayoutInflater.inflate(R.layout.animalaaa_adapter, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ListviewViewHolder) {
            ((ListviewViewHolder) holder).tvHuozhuName.setText(list.get(position - 1).getACARGOOWNER());
            ((ListviewViewHolder) holder).tvShenbaoPhone.setText(list.get(position - 1).getAPHONE());
            ((ListviewViewHolder) holder).tvAnimalType.setText(list.get(position - 1).getAXUZHONG());
            ((ListviewViewHolder) holder).tvAnimalNumber.setText(list.get(position - 1).getAQUANTITY() + "");
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

        private TextView tvHuozhuName;
        private TextView tvShenbaoPhone;
        private TextView tvAnimalType;
        private TextView tvAnimalNumber;

        private ListviewViewHolder(View view) {
            super(view);
            tvHuozhuName = (TextView) view.findViewById(R.id.tv_huozhu_name);
            tvShenbaoPhone = (TextView) view.findViewById(R.id.tv_shenbao_phone);
            tvAnimalType = (TextView) view.findViewById(R.id.tv_animal_type);
            tvAnimalNumber = (TextView) view.findViewById(R.id.tv_animal_number);

        }
    }

    private class HeadViewHolder extends RecyclerView.ViewHolder {
        private HeadViewHolder(View view) {
            super(view);
        }
    }
}
