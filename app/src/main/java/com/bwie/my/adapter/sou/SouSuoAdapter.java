package com.bwie.my.adapter.sou;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.R;
import com.bwie.my.activity.sou.InfoActivity;
import com.bwie.my.bean.sou.SouBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2018/12/17.
 *
 * @author 王丙均
 */

public class SouSuoAdapter extends RecyclerView.Adapter<SouSuoAdapter.ViewHolder> {
    private Context context;
    private List<SouBean.ResultBean> soulist;

    public SouSuoAdapter(Context context, List<SouBean.ResultBean> soulist) {
        this.context = context;
        this.soulist = soulist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.showlayout, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView_selanum.setText(String.valueOf("销量:"+soulist.get(position).getSaleNum()));
        holder.show_adapter_title.setText(soulist.get(position).getCommodityName());
        holder.show_adapter_price.setText(String.valueOf("价格:"+soulist.get(position).getPrice()));
        String images = soulist.get(position).getMasterPic();
        String[] split = images.split("\\|");
        Uri parse = Uri.parse(soulist.get(position).getMasterPic());
        AbstractDraweeController fresco = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .build();
        holder.simpleDraweeView.setController(fresco);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InfoActivity.class);
                int pid = soulist.get(position).getCommodityId();
                intent.putExtra("pid",pid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return soulist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView simpleDraweeView;
        private TextView show_adapter_title;
        private TextView show_adapter_price;
        private TextView textView_selanum;
        public ViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.show_adapter_simple);
            show_adapter_title = (TextView) itemView.findViewById(R.id.show_adapter_title);
            show_adapter_price = (TextView) itemView.findViewById(R.id.show_adapter_price);
            textView_selanum = (TextView) itemView.findViewById(R.id.show_adapter_selanum);
        }
    }



}
