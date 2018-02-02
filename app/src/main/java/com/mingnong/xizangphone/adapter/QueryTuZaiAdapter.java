package com.mingnong.xizangphone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.QueryTuZaiBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HUANG on 2017/7/5.
 */
public class QueryTuZaiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<QueryTuZaiBean.DataListBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater mLayoutInflater;
    View headerView;

    //建立枚举，2个item类型
    public enum ITEM_TYPE {
        ITEM_HEAD,
        ITEM_LISTVIEM
    }

    public QueryTuZaiAdapter(Context context, List<QueryTuZaiBean.DataListBean> list, View headerView) {
        this.context = context;
        this.headerView = headerView;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    public List<QueryTuZaiBean.DataListBean> getDates() {
        return list;
    }

    public void setmDatas(List<QueryTuZaiBean.DataListBean> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.clear();
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void addAll(List<QueryTuZaiBean.DataListBean> list) {
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
            return new ListviewViewHolder(mLayoutInflater.inflate(R.layout.tuzai_adapter, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ListviewViewHolder) {
//            ((ListviewViewHolder) holder).tvHarmlseeType.setText(list.get(position - 1).getIsPrant());
            ((ListviewViewHolder) holder).tvQianfaDate.setText(list.get(position - 1).getDATEJL());//记录日期
            ((ListviewViewHolder) holder).tvJianyiBianhao.setText(list.get(position - 1).getQNUMBER());//检疫证编号
            ((ListviewViewHolder) holder).tvHouzhuName.setText(list.get(position - 1).getQCARGOOWNER());//货主
            ((ListviewViewHolder) holder).tvAnimalType.setText(list.get(position - 1).getQADDRESS());//检疫地点
            ((ListviewViewHolder) holder).tvQuantityDanwei.setText(list.get(position - 1).getQZZS() + list.get(position - 1).getQZZSDW());//数量及单位
        }
    }

    //设置ITEM类型，可以自由发挥，这里设置item 0单数显示head item 其他显示listview item
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return QueryTuZaiAdapter.ITEM_TYPE.ITEM_HEAD.ordinal();
        } else {
            return QueryTuZaiAdapter.ITEM_TYPE.ITEM_LISTVIEM.ordinal();
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

        private TextView tvQianfaDate;
        private TextView tvJianyiBianhao;
        private TextView tvHouzhuName;
        private TextView tvAnimalType;
        private TextView tvQuantityDanwei;

        private ListviewViewHolder(View view) {
            super(view);
            tvQianfaDate = (TextView) view.findViewById(R.id.tv_qianfapa_date);
            tvJianyiBianhao = (TextView) view.findViewById(R.id.tv_jianyipa_bianhao);
            tvHouzhuName = (TextView) view.findViewById(R.id.tv_huozhupa_name);
            tvAnimalType = (TextView) view.findViewById(R.id.tv_animalpa_type);
            tvQuantityDanwei = (TextView) view.findViewById(R.id.tv_quantitypa_danwei);

        }
    }

    private class HeadViewHolder extends RecyclerView.ViewHolder {
        private HeadViewHolder(View view) {
            super(view);

        }
    }

}
