package com.example.renzhilli20181211.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.renzhilli20181211.R;
import com.example.renzhilli20181211.bean.UserBean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

public class MyBaseAdapter extends BaseAdapter {
    private static final int COUNT_ITEM =2 ;
    private static final int BANNER_ITEM =0 ;
    private static final int DATA_ITEM = 1;
    private List<UserBean.DataBean> list;
    private List<UserBean.DataBean> mbanner;
    private Context context;

    public MyBaseAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
        mbanner=new ArrayList<>();
    }
    public void setBanner(List<UserBean.DataBean> data) {
        mbanner.clear();
        if (data!=null){
            mbanner.addAll(data);
        }
        notifyDataSetChanged();
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

    @Override
    public int getViewTypeCount() {
        return COUNT_ITEM;
    }

    @Override
    public int getItemViewType(int position) {
        return position==0&&hasBanner()?BANNER_ITEM:DATA_ITEM;
    }
    public boolean hasBanner(){
        return mbanner.size()>0;
    }
    @Override
    public int getCount() {
        return list.size()+(hasBanner()?1:0);
    }

    @Override
    public UserBean.DataBean getItem(int position) {
        return list.get(hasBanner()?position-1:position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItemViewType(position)==BANNER_ITEM){
            bannerViewHolder holder;
            if (convertView==null){
                convertView=LayoutInflater.from(context).inflate(R.layout.banner_item,parent,false);
                holder=new bannerViewHolder(convertView);
            }else{
                holder= (bannerViewHolder) convertView.getTag();
            }
            holder.bindBanner(mbanner);
        }else{
            listViewHolder holder;
            if (convertView==null){
                convertView=LayoutInflater.from(context).inflate(R.layout.data_item,parent,false);
                holder=new listViewHolder(convertView);
            }else{
                holder= (listViewHolder) convertView.getTag();
            }
            holder.bindData(getItem(position));
        }
        return convertView;
    }
    class bannerViewHolder{
        Banner banner;
        public bannerViewHolder(View convertView) {
            banner=convertView.findViewById(R.id.banner);
            convertView.setTag(this);
        }
        public void bindBanner(List<UserBean.DataBean> mbanner) {
            //设置样式
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            banner.setImageLoader(new ImageLoaderInterface<ImageView>() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    UserBean.DataBean dataBean = (UserBean.DataBean) path;
                    com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage(dataBean.hasIcon(),imageView);
                }

                @Override
                public ImageView createImageView(Context context) {
                    ImageView imageView = new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return imageView;
                }
            });
            banner.setImages(mbanner);
            banner.start();

        }
    }
    class listViewHolder{
        ImageView icon;
        TextView title,createtime;

        public listViewHolder(View convertView) {
            title=convertView.findViewById(R.id.title_data);
            createtime=convertView.findViewById(R.id.createtime);
            icon=convertView.findViewById(R.id.icon);
            convertView.setTag(this);
        }

        public void bindData(UserBean.DataBean item) {
            title.setText(item.getTitle());
            createtime.setText(item.getCreatetime());
            //通过ImageLoader加载图片
            //ImageLoader.getInstance().displayImage(item.hasIcon(),icon);
            //通过Glide加载图片
            Glide.with(context).load(item.hasIcon()).into(icon);
        }
    }
}
