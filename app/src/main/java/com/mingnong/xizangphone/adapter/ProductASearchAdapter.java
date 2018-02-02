package com.mingnong.xizangphone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.bean.QueryProductABean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public class ProductASearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<QueryProductABean.DataListBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater mLayoutInflater;
    View headerView;


    //建立枚举，2个item类型
    public enum ITEM_TYPE {
        ITEM_HEAD,
        ITEM_LISTVIEM
    }

    public ProductASearchAdapter(Context context, List<QueryProductABean.DataListBean> list, View headerView) {
        this.context = context;
        this.headerView = headerView;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    public List<QueryProductABean.DataListBean> getDates() {
        return list;
    }

    public void setmDatas(List<QueryProductABean.DataListBean> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.clear();
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void addAll(List<QueryProductABean.DataListBean> list) {
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
            return new ListviewViewHolder(mLayoutInflater.inflate(R.layout.productaaa_adapter, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProductASearchAdapter.ListviewViewHolder) {
            ((ProductASearchAdapter.ListviewViewHolder) holder).tvQianfaDate.setText(list.get(position - 1).getDATEQF());//签发日期
            ((ProductASearchAdapter.ListviewViewHolder) holder).tvJianyiBianhao.setText(list.get(position - 1).getPNUMBER());//检疫证编号
            ((ProductASearchAdapter.ListviewViewHolder) holder).tvHouzhuName.setText(list.get(position - 1).getPCARGOOWNER());//货主
            ((ProductASearchAdapter.ListviewViewHolder) holder).tvAnimalType.setText(list.get(position - 1).getPUNITNAME());//生产单位名称
            ((ProductASearchAdapter.ListviewViewHolder) holder).tvQuantityDanwei.setText(list.get(position - 1).getPQUANTITY() + list.get(position - 1).getPDANWEI());//数量及单位
        }
    }

    //设置ITEM类型，可以自由发挥，这里设置item 0单数显示head item 其他显示listview item
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ProductASearchAdapter.ITEM_TYPE.ITEM_HEAD.ordinal();
        } else {
            return ProductASearchAdapter.ITEM_TYPE.ITEM_LISTVIEM.ordinal();
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
