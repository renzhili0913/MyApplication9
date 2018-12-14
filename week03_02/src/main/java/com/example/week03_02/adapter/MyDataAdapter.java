package com.example.week03_02.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week03_02.R;
import com.example.week03_02.bean.PhotoBean;

import java.util.ArrayList;
import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /**数据集合*/
    private List<PhotoBean.DataBean> list;
    /**上下文*/
    private Context context;
    /**状态值*/
    private boolean falg;
    private View view;

    public MyDataAdapter(Context context, boolean falg) {
        this.context = context;
        this.falg = falg;
        list=new ArrayList<>();
    }
    /**上拉刷新的方法*/
    public void setList(List<PhotoBean.DataBean> data) {
       list.clear();
       if (data!=null){
        list.addAll(data);
       }
       notifyDataSetChanged();
    }
    /**下拉加载数据的方法*/
    public void addList(List<PhotoBean.DataBean> data) {
        if (data!=null){
            list.addAll(data);
        }
        notifyDataSetChanged();
    }
    /**定义一个提供所有数据的方法，供外面调用*/
    public List<PhotoBean.DataBean> getData(){
        return  list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //判断状态值，确定我们要加载的布局
        if (falg){
            //加载线性布局
            view = LayoutInflater.from(context).inflate(R.layout.linear_item,viewGroup,false);
        }else{
            //加载网格布局
            view = LayoutInflater.from(context).inflate(R.layout.grid_item,viewGroup,false);
        }
        //返回viewHolder到onBindViewHolder
        return new LinearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        //获取每一个条目上展示的所有数据
        PhotoBean.DataBean dataBean = list.get(i);
        //强转viewHolder为我们自己的ViewHolder
        LinearViewHolder linearViewHolder = (LinearViewHolder) viewHolder;
        //给条目控件赋值
        linearViewHolder.title.setText(dataBean.getTitle());
        linearViewHolder.price.setText("价格："+dataBean.getPrice());
        linearViewHolder.salenum.setText("销量："+dataBean.getSalenum());
        //获取图片路径字段
        String img = dataBean.getImages();
        //截取图片字段为图片路径放入imgs数组中
        String[] imgs = img.split("\\|");
        //展示数组中第一张图片
        Glide.with(context).load(imgs[0]).into(linearViewHolder.images);
        //条目点击事件
        linearViewHolder.constraintlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断接口不为空
                if (click!=null){
                 click.onClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        ImageView images;
        TextView title,price,salenum;
        ConstraintLayout constraintlayout;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            //获取控件资源id
            images=itemView.findViewById(R.id.images);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
            salenum=itemView.findViewById(R.id.salenum);
            //获取条目布局
            constraintlayout=itemView.findViewById(R.id.constraintlayout);
        }
    }
    /**声明接口*/
    Click click;
    /**定义接口回调方法*/
    public void setOnClickListener(Click click){
         this.click=click;
     }
     /**定义接口*/
    public interface Click {
        void onClick(int position);
    }
}
