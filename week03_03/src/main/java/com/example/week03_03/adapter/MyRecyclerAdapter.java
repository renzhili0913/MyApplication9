package com.example.week03_03.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week03_03.R;
import com.example.week03_03.bean.UserBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{
    private static final int ONE_ITEM =0 ;
    private static final int THREE_ITEM =1 ;
    private Context context;
    private List<UserBean.DataBean> list;

    public MyRecyclerAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }
    /**下拉刷新*/
    public void setList(List<UserBean.DataBean> data) {
        list.clear();
        if (data!=null){
            list.addAll(data);
        }
        notifyDataSetChanged();
    }
    /**上拉加载*/
    public void addList(List<UserBean.DataBean> data) {
        if (data!=null){
            list.addAll(data);
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder holder =null;
        if (i==ONE_ITEM){
            View view = LayoutInflater.from(context).inflate(R.layout.one_item,viewGroup,false);
            holder=new OneViewHolder(view);
        }else if(i==THREE_ITEM){
            View view = LayoutInflater.from(context).inflate(R.layout.three_item,viewGroup,false);
            holder=new ThreeViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        UserBean.DataBean dataBean = list.get(i);
        if (getItemViewType(i)==ONE_ITEM){
            OneViewHolder oneViewHolder = (OneViewHolder) viewHolder;
            oneViewHolder.title.setText(dataBean.getTitle());
            oneViewHolder.date.setText(dataBean.getDate());
            Glide.with(context).load(dataBean.getThumbnail_pic_s()).into(oneViewHolder.thumbnail_pic_s);
            oneViewHolder.image_clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (click!=null){
                        click.onClick(i);
                    }
                }
            });
        }else if(getItemViewType(i)==THREE_ITEM){
            ThreeViewHolder threeViewHolder = (ThreeViewHolder) viewHolder;
            threeViewHolder.title.setText(dataBean.getTitle());
            Glide.with(context).load(dataBean.getThumbnail_pic_s()).into(threeViewHolder.thumbnail_pic_s);
            Glide.with(context).load(dataBean.getThumbnail_pic_s02()).into(threeViewHolder.thumbnail_pic_s02);
            Glide.with(context).load(dataBean.getThumbnail_pic_s03()).into(threeViewHolder.thumbnail_pic_s03);
            threeViewHolder.image_clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (click!=null){
                        click.onClick(i);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).isImage();
    }
    class OneViewHolder extends RecyclerView.ViewHolder{
        TextView title,date;
        ImageView thumbnail_pic_s;
        ImageButton image_clear;
        public OneViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            date=itemView.findViewById(R.id.date);
            thumbnail_pic_s=itemView.findViewById(R.id.thumbnail_pic_s);
            image_clear=itemView.findViewById(R.id.image_clear);
        }
    }
    class ThreeViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView thumbnail_pic_s,thumbnail_pic_s02,thumbnail_pic_s03;
        ImageButton image_clear;
        public ThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            thumbnail_pic_s=itemView.findViewById(R.id.thumbnail_pic_s);
            thumbnail_pic_s02=itemView.findViewById(R.id.thumbnail_pic_s02);
            thumbnail_pic_s03=itemView.findViewById(R.id.thumbnail_pic_s03);
            image_clear=itemView.findViewById(R.id.image_clear);
        }
    }
    //删除
    public void removeData(int position){
        list.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
    //声明
    Click click;
    public void setOnClickListener(Click click){
        this.click=click;
    }

    //定义接口
    public interface Click{
        void onClick(int position);
    }
}
