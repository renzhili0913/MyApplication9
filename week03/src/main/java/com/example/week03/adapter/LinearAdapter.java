package com.example.week03.adapter;

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
import com.example.week03.R;
import com.example.week03.bean.UserBean;
import java.util.ArrayList;
import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<UserBean.DataBean> list;
    private static final int TEXT_ITEM=0;
    private static final int IMAGE_THREE=2 ;
    private static final int IMAGE_ONE =1;
    public LinearAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<UserBean.DataBean> data) {
        list.clear();
        if (data!=null){
         list.addAll(data);
        }
        notifyDataSetChanged();
    }
    public void addList(List<UserBean.DataBean> data) {
        if (data!=null){
            list.addAll(data);
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            RecyclerView.ViewHolder holder=null;
            if (i==TEXT_ITEM){
                //View view =View.inflate(context,R.layout.text_item,null);
                View view = LayoutInflater.from(context).inflate(R.layout.text_item,viewGroup,false);
                holder=new TextViewHolder(view);
            }else if(i==IMAGE_ONE){
                //View view =View.inflate(context,R.layout.image_one_item,null);
                View view = LayoutInflater.from(context).inflate(R.layout.image_one_item,viewGroup,false);
                holder=new ImageOneViewHolder(view);
            }else{
                //View view =View.inflate(context,R.layout.image_three_item,null);
                View view = LayoutInflater.from(context).inflate(R.layout.image_three_item,viewGroup,false);
                holder=new ImageThreeViewHolder(view);
            }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int type = getItemViewType(i);
        switch (type){
            case TEXT_ITEM:
                TextViewHolder textViewHolder = (TextViewHolder) viewHolder;
                textViewHolder.title.setText(list.get(i).getTitle());
                //条目长按事件
                textViewHolder.constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        if (longClick!=null){
                            longClick.onLongClick(i);
                        }
                        return true;
                    }
                });
                break;
            case IMAGE_ONE:
                ImageOneViewHolder imageOneViewHolder = (ImageOneViewHolder) viewHolder;
                imageOneViewHolder.title.setText(list.get(i).getTitle());
                Glide.with(context).load(list.get(i).getThumbnail_pic_s()).into(imageOneViewHolder.thumbnail_pic_s);
                //条目长按事件
                imageOneViewHolder.constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        if (longClick!=null){
                            longClick.onLongClick(i);
                        }
                        return true;
                    }
                });
                //图片点击事件
                imageOneViewHolder.thumbnail_pic_s.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (click!=null){
                            click.onClick(v,i);
                        }
                    }
                });
                break;
            case IMAGE_THREE:
                ImageThreeViewHolder threeViewHolder = (ImageThreeViewHolder) viewHolder;
                threeViewHolder.title.setText(list.get(i).getTitle());
                Glide.with(context).load(list.get(i).getThumbnail_pic_s()).into(threeViewHolder.thumbnail_pic_s);
                Glide.with(context).load(list.get(i).getThumbnail_pic_s02()).into(threeViewHolder.thumbnail_pic_s02);
                Glide.with(context).load(list.get(i).getThumbnail_pic_s03()).into(threeViewHolder.thumbnail_pic_s03);
                //条目长按事件
                threeViewHolder.constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        if (longClick!=null){
                            longClick.onLongClick(i);
                        }
                        return true;
                    }
                });
                //图片点击事件
                threeViewHolder.thumbnail_pic_s.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (click!=null){
                            click.onClick(v,i);
                        }
                    }
                });
                //图片点击事件
                threeViewHolder.thumbnail_pic_s02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (click!=null){
                            click.onClick(v,i);
                        }
                    }
                });
                //图片点击事件
                threeViewHolder.thumbnail_pic_s03.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (click!=null){
                            click.onClick(v,i);
                        }
                    }
                });
                break;
                default:
                    break;

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        UserBean.DataBean dataBean = list.get(position);
        return dataBean.hasImage();
    }

    class TextViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ConstraintLayout constraintLayout;
        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            constraintLayout=itemView.findViewById(R.id.constraintlayout);
        }
    }
    class ImageOneViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView thumbnail_pic_s;
        private ConstraintLayout constraintLayout;
        public ImageOneViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            thumbnail_pic_s=itemView.findViewById(R.id.thumbnail_pic_s);
            constraintLayout=itemView.findViewById(R.id.constraintlayout);
        }
    }
    class ImageThreeViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView thumbnail_pic_s;
        private ImageView thumbnail_pic_s02;
        private ImageView thumbnail_pic_s03;
        private ConstraintLayout constraintLayout;
        public ImageThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            thumbnail_pic_s=itemView.findViewById(R.id.thumbnail_pic_s);
            thumbnail_pic_s02=itemView.findViewById(R.id.thumbnail_pic_s02);
            thumbnail_pic_s03=itemView.findViewById(R.id.thumbnail_pic_s03);
            constraintLayout=itemView.findViewById(R.id.constraintlayout);
        }
    }
    //删除
    public void removeData(int position){
        list.remove(position);

        notifyDataSetChanged();
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position,list.size());
       // notifyItemRangeRemoved(position,list.size());
    }
    //声明接口
    LongClick longClick;
    public void setOnLongClickListener(LongClick longClick){
        this.longClick=longClick;
    }
    //定义接口
    public  interface  LongClick{
        void onLongClick(int position);
    }

    //声明接口
    Click click;
    public void setOnClickListener(Click click){
        this.click=click;
    }
    //定义接口
    public  interface  Click{
        void onClick(View view,int position);
    }

}
