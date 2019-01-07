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
 * date:2018/12/7.
 * Created by 王丙均quality
 */

public class Home_Magic_Line_Adapter extends RecyclerView.Adapter<Home_Magic_Line_Adapter.ViewHolder> {
    private Context context;
    private List<HomeCommodityBean.ResultBean.MlssBean.CommodityListBeanXX> list;

    public Home_Magic_Line_Adapter(Context context, List<HomeCommodityBean.ResultBean.MlssBean.CommodityListBeanXX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.home_magic_line_adapter, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        HomeCommodityBean.ResultBean.MlssBean.CommodityListBeanXX commodityListBeanXX = list.get(position);

        holder.mlss_title.setText(commodityListBeanXX.getCommodityName());
        holder.mlss_price.setText(String.valueOf("￥"+commodityListBeanXX.getPrice()));

        Uri uri = Uri.parse(commodityListBeanXX.getMasterPic());

        holder.mlss_simple.setImageURI(uri);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,InfoActivity.class);
                int pid = list.get(position).getCommodityId();
                intent.putExtra("pid",pid);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         SimpleDraweeView mlss_simple;
         TextView mlss_title;
         TextView mlss_price;

        public ViewHolder(View itemView) {
            super(itemView);
            mlss_simple = itemView.findViewById(R.id.mlss_simple);
            mlss_title =  itemView.findViewById(R.id.mlss_title);
            mlss_price =  itemView.findViewById(R.id.mlss_price);
        }
    }
}
