package com.bwie.my.adapter.circleadapter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.R;
import com.bwie.my.bean.circle.Me_Circlr_Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * date:2018/12/14.
 * Created by 王丙均
 */

public class My_Circle_Activity_Adapter extends RecyclerView.Adapter<My_Circle_Activity_Adapter.ViewHolder> {
    private Context context;
    private List<Me_Circlr_Bean.ResultBean> list;

    public My_Circle_Activity_Adapter(Context context, List<Me_Circlr_Bean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.activity_my__circle_adapter, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.circle1_delete_title.setText(list.get(position).getContent());
        Uri uri1=Uri.parse(list.get(position).getImage());
        holder.circle1_delete_simple.setImageURI(uri1);
        Uri uri2=Uri.parse(list.get(position).getImage());
        holder.circle1_delete_simple2.setImageURI(uri2);
        holder.circle1_delete_date.setText(String.valueOf(list.get(position).getCreateTime()/1000));
//        (int) (System.currentTimeMillis() / 1000)

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView circle1_delete_title;
        private SimpleDraweeView circle1_delete_simple;
        private SimpleDraweeView circle1_delete_simple2;
        private TextView circle1_delete_date;
        private ImageView circle1_delete_zan;
        private TextView circle1_delete_num;
        public ViewHolder(View itemView) {
            super(itemView);
            circle1_delete_title = (TextView) itemView.findViewById(R.id.circle1_delete_title);
            circle1_delete_simple = (SimpleDraweeView) itemView.findViewById(R.id.circle1_delete_simple);
            circle1_delete_simple2 = (SimpleDraweeView) itemView.findViewById(R.id.circle1_delete_simple2);
            circle1_delete_date = (TextView) itemView.findViewById(R.id.circle1_delete_date);
            circle1_delete_num = (TextView) itemView.findViewById(R.id.circle1_delete_num);
            circle1_delete_zan = (ImageView) itemView.findViewById(R.id.circle1_delete_zan);
        }
    }
}
