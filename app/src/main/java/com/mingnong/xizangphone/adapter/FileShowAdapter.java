package com.mingnong.xizangphone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingnong.xizangphone.R;
import com.mingnong.xizangphone.dao.XiaoXiDaoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyw on 2017/6/20.
 */

public class FileShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<XiaoXiDaoBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater mLayoutInflater;
    View headerView;

//    //建立枚举，2个item类型
//    public enum ITEM_TYPE {
//        ITEM_HEAD,
//        ITEM_LISTVIEM
//    }

    public FileShowAdapter(Context context, List<XiaoXiDaoBean> list) {
        this.context = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    public List<XiaoXiDaoBean> getDates() {
        return list;
    }

    public void setmDatas(List<XiaoXiDaoBean> list) {
        if (this.list == null) {
            this.list = list;
        } else {
//            this.list.clear();
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void addAll(List<XiaoXiDaoBean> list) {
        if (this.list == null) {
            this.list = list;
        } else {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ListviewViewHolder(mLayoutInflater.inflate(R.layout.adapter_file_show, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ListviewViewHolder) {
            ((ListviewViewHolder) holder).tvFileName.setText(list.get(position).getFileNameList());
            ((ListviewViewHolder) holder).tvModifyTime.setText(list.get(position).getCidTongZhiName());
            ((ListviewViewHolder) holder).tvFileType.setText(list.get(position).getIsm());
        }
    }

//    //设置ITEM类型，可以自由发挥，这里设置item 0单数显示head item 其他显示listview item
//    @Override
//    public int getItemViewType(int position) {
//        return FileShowAdapter.ITEM_TYPE.ITEM_LISTVIEM.ordinal();
//    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ListviewViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFileName;
        private TextView tvModifyTime;
        private TextView tvFileType;
        private ListviewViewHolder(View view) {
            super(view);
            tvFileName = (TextView) view.findViewById(R.id.tv_file_name);
            tvModifyTime = (TextView) view.findViewById(R.id.tv_modify_time);
            tvFileType = (TextView) view.findViewById(R.id.tv_file_type);
        }
    }



//    private ArrayList<FileBean> mData;
//    private Context mContext;
//    public FileShowAdapter(Context mContext,ArrayList<FileBean> mData) {
//        this.mData = mData;
//        this.mContext = mContext;
//    }
//
//    public void setmData(ArrayList<FileBean> mData) {
//        this.mData = mData;
//    }
//
//    @Override
//    public int getCount() {
//        return mData==null?0:mData.size();
//    }
//
//    @Override
//    public FileBean getItem(int position) {
//        return mData.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//        if (convertView == null) {
//            convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_file_show, parent, false);
//            convertView.setTag(viewHolder =new ViewHolder(convertView));
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//        viewHolder.tvFileName.setText(getItem(position).getFileName());
//        viewHolder.tvModifyTime.setText(getItem(position).getModifyDate());
//        viewHolder.tvFileType.setText(getItem(position).getFileType());
//        return convertView;
//    }
//
//    private static class ViewHolder{
//        private TextView tvFileName,tvModifyTime,tvFileType;
//
//        public ViewHolder(View parent) {
//            tvFileName = (TextView) parent.findViewById(R.id.tv_file_name);
//            tvModifyTime = (TextView) parent.findViewById(R.id.tv_modify_time);
//            tvFileType = (TextView) parent.findViewById(R.id.tv_file_type);
//        }
//    }
}
