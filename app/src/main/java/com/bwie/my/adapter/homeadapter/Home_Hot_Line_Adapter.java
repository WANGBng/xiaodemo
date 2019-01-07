package com.bwie.my.adapter.homeadapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.R;
import com.bwie.my.activity.sou.InfoActivity;
import com.bwie.my.bean.home.HomeCommodityBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2018/12/6.
 * Created by 王丙均
 */

public class Home_Hot_Line_Adapter extends RecyclerView.Adapter<Home_Hot_Line_Adapter.ViewHolder> {
    private Context context;
    private List<HomeCommodityBean.ResultBean.RxxpBean.CommodityListBean> list;

    public Home_Hot_Line_Adapter(Context context, List<HomeCommodityBean.ResultBean.RxxpBean.CommodityListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.home_hot_line_adapter, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Uri uri = Uri.parse(list.get(position).getMasterPic());
        holder.rxxp_simple.setImageURI(uri);
        holder.rxxp_te_title.setText(list.get(position).getCommodityName());
        holder.rxxp_te_price.setText(String.valueOf("￥："+list.get(position).getPrice()));
//        holder.itemView.
//        Log.e("TAG", "onBindViewHolder:ss啥时间内的拉开几十年的辣会计师 "+list.size() );
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,InfoActivity.class);
                int commodityId = list.get(position).getCommodityId();
                intent.putExtra("pid",commodityId);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         SimpleDraweeView rxxp_simple;
         TextView rxxp_te_title;
         TextView rxxp_te_price;
        public ViewHolder(View itemView) {
            super(itemView);
            rxxp_simple = (SimpleDraweeView) itemView.findViewById(R.id.rxxp_simple);
            rxxp_te_title = (TextView) itemView.findViewById(R.id.rxxp_te_title);
            rxxp_te_price = (TextView) itemView.findViewById(R.id.rxxp_te_price);
        }
    }
}
