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

public class SouAdapter extends RecyclerView.Adapter<SouAdapter.MyViewHolder> {
    private Context context;
    private List<SouBean.ResultBean> souList;

    public SouAdapter(Context context, List<SouBean.ResultBean> souList) {
        this.context = context;
        this.souList = souList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(View.inflate(context, R.layout.sou_adapter, null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.show_souAdapterTitle.setText(souList.get(position).getCommodityName());
        holder.show_souAdapterPrice.setText(String.valueOf("￥"+souList.get(position).getPrice()+""));

        Uri uri = Uri.parse(souList.get(position).getMasterPic());//图片的切割
        AbstractDraweeController fresco = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .build();
        holder.show_adapterSimple.setController(fresco);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//点击时将pid传到商品的详情去
                Intent intent = new Intent(context, InfoActivity.class);
                int pid = souList.get(position).getCommodityId();
                intent.putExtra("pid",pid);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return souList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView show_adapterSimple;
        private TextView show_souAdapterTitle;
        private TextView show_souAdapterPrice;
        public MyViewHolder(View itemView) {
            super(itemView);
            show_adapterSimple = (SimpleDraweeView) itemView.findViewById(R.id.show_adapterSimple);
            show_souAdapterTitle = (TextView) itemView.findViewById(R.id.show_souAdapterTitle);
            show_souAdapterPrice = (TextView) itemView.findViewById(R.id.show_souAdapterPrice);
        }
    }
}
