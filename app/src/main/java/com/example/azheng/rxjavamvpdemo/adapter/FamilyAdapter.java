package com.example.azheng.rxjavamvpdemo.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.azheng.rxjavamvpdemo.R;
import com.example.azheng.rxjavamvpdemo.bean.BeanFamily;
import com.example.azheng.rxjavamvpdemo.util.ButtonUtils;

import java.util.List;


/**
 * user：lqm
 * desc：家庭圈
 */

public class FamilyAdapter extends RecyclerView.Adapter<FamilyAdapter.VH> {

    private static final String TAG = "FamilyAdapter";
    private List<?> mDatas;
    private BeanFamily data;
    private Context mContext;
    private ButtonInterface buttonInterface;
    private DeleteInterface DeleteInterface;
    private OnItemClickListener onRecyclerViewItemClickListener;

    public FamilyAdapter(List<?> data, Context mContext) {
        this.mDatas = data;
        this.mContext = mContext;
    }

    public interface OnItemClickListener {
        void onLongClick(int position);
    }
    public void setOnRecyclerViewItemClickListener(OnItemClickListener onItemClickListener) {
        this.onRecyclerViewItemClickListener = onItemClickListener;
    }

    /**
     *列表点击事件需要的方法
     */
    public void buttonSetOnclick(FamilyAdapter.ButtonInterface buttonInterface){
        this.buttonInterface=buttonInterface;
    }

    /**
     * 列表点击事件对应的接口
     */
    public interface ButtonInterface {
        void onclick(View view, int position);
    }

    /**
     * 删除点击事件需要的方法
     */
    public void DeleteOnclick(FamilyAdapter.DeleteInterface DeleteInterface){
        this.DeleteInterface=DeleteInterface;
    }

    /**
     * 删除点击事件对应的接口
     */
    public interface DeleteInterface {
        void onclick(View view, int position);
    }


    /**
     * 删除某一条
     * */
    public void removeList(int position){
        mDatas.remove(position);//删除数据源,移除集合中当前下标的数据
        notifyItemRemoved(position);//刷新被删除的地方
        notifyItemRangeChanged(position, getItemCount()); //刷新被删除数据，以及其后面的数据
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(FamilyAdapter.VH holder, final int position) {
        data = (BeanFamily) mDatas.get(position);
        holder.tv_text.setText(data.getName());
        if (data.getPrecept().equals("")){
            holder.tv_family_cont.setText("未设置家训");
        }else {
            holder.tv_family_cont.setText(data.getPrecept());
        }
        if (data.isIsManager()){
            holder.iv_admin_qz.setVisibility(View.VISIBLE);
        }else {
            holder.iv_admin_qz.setVisibility(View.GONE);
        }

        Glide.with(mContext)
                .load(data.getAvatar())
                .apply(new RequestOptions().centerCrop().error(R.mipmap.icon_the_default_my))
                .into(holder.cimg_item);

        holder.linear_item.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ButtonUtils.isFastDoubleClick(R.id.linear_item)) {
                    if (buttonInterface != null) {
                        buttonInterface.onclick(v, position);
                    }
                }
            }
        });

        holder.card_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ButtonUtils.isFastDoubleClick(R.id.card_delete)) {
                    if (DeleteInterface != null) {
                        DeleteInterface.onclick(v, position);
                    }
                }
            }
        });

        //重点在这里判空然后做接口的绑定
        if (onRecyclerViewItemClickListener!=null) {
            holder.linear_item.setOnLongClickListener( new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onRecyclerViewItemClickListener.onLongClick(position);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class VH extends RecyclerView.ViewHolder{
        private TextView tv_text;
        private TextView tv_family_cont;
        private LinearLayout linear_item;
        private CardView card_delete;
        private ImageView cimg_item;
        private ImageView iv_admin_qz;
        public VH(View v) {
            super(v);
            tv_text = v.findViewById(R.id.tv_name);
            tv_family_cont = v.findViewById(R.id.tv_family_cont);
            linear_item = v.findViewById(R.id.linear_item);
            cimg_item = v.findViewById(R.id.cimg_item);
            iv_admin_qz = v.findViewById(R.id.iv_admin_qz);
            card_delete = v.findViewById(R.id.card_delete);
        }
    }

    @Override
    public FamilyAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_family_recy, parent, false);
        return new FamilyAdapter.VH(v);
    }
}