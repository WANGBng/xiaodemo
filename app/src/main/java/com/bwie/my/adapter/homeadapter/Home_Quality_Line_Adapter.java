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
 * @author wangbingjun 王丙均
 */

public class Home_Quality_Line_Adapter extends RecyclerView.Adapter<Home_Quality_Line_Adapter.ViewHolder> {
    private Context context;
    private List<HomeCommodityBean.ResultBean.PzshBean.CommodityListBeanX> list;

    public Home_Quality_Line_Adapter(Context context, List<HomeCommodityBean.ResultBean.PzshBean.CommodityListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.home_quality_line_adapter, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        HomeCommodityBean.ResultBean.PzshBean.CommodityListBeanX commodityListBeanX = list.get(position);

        holder.quality_title.setText(commodityListBeanX.getCommodityName());
        holder.quality_price.setText(String.valueOf("￥"+commodityListBeanX.getPrice()));

        Uri uri = Uri.parse(commodityListBeanX.getMasterPic());
        holder.quality_simple.setImageURI(uri);


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
        private SimpleDraweeView quality_simple;
        private TextView quality_title;
        private TextView quality_price;

        public ViewHolder(View itemView) {
            super(itemView);
            quality_simple = (SimpleDraweeView) itemView.findViewById(R.id.quality_simple);
            quality_title = (TextView) itemView.findViewById(R.id.quality_title);
            quality_price = (TextView) itemView.findViewById(R.id.quality_price);
        }
    }
}
