package com.bwie.my.adapter.circleadapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.R;
import com.bwie.my.bean.circle.CircleBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * date:2018/12/11.
 * @author 王丙均
 * 展示所有圈子的适配器
 */

public class CircleAdapter extends RecyclerView.Adapter<CircleAdapter.ViewHolder> {
    private Context context;
    private List<CircleBean.ResultBean> cList;

    int num = 0;
    int greatNum=0;
    int i=0;
    public CircleAdapter(Context context, List<CircleBean.ResultBean> cList) {
        this.context = context;
        this.cList = cList;
    }

    private final static int ITEM_ONE = 0;
    private final static int ITEM_TWO = 1;
    private final static int ITEM_THREE = 2;
    private final static int ITEM_FOUR = 3;
    private final static int ITEM_FILE = 4;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(View.inflate(context, R.layout.circle_layout_adapter, null));
    }

    @Override
    public int getItemViewType(int position) {
        String image = cList.get(position).getImage();
        if (image.length() ==ITEM_ONE &&image.length()!=ITEM_TWO &&image.length()!=ITEM_THREE &&image.length()!=ITEM_FOUR &&image.length()!=ITEM_FILE){
            return ITEM_ONE;
        }else if (image.length() !=ITEM_ONE &&image.length()==ITEM_TWO &&image.length()!=ITEM_THREE &&image.length()!=ITEM_FOUR &&image.length()!=ITEM_FILE){
            return ITEM_TWO;
        }else if (image.length() !=ITEM_ONE &&image.length()!=ITEM_TWO &&image.length()==ITEM_THREE &&image.length()!=ITEM_FOUR &&image.length()!=ITEM_FILE){
            return ITEM_THREE;
        }else if (image.length() !=ITEM_ONE &&image.length()!=ITEM_TWO &&image.length()!=ITEM_THREE &&image.length()==ITEM_FOUR &&image.length()!=ITEM_FILE){
            return ITEM_FOUR;
        }else if (image.length() !=ITEM_ONE &&image.length()!=ITEM_TWO &&image.length()!=ITEM_THREE &&image.length()!=ITEM_FOUR &&image.length()==ITEM_FILE){
            return ITEM_FILE;
        }else {
            return ITEM_ONE;
        }
    }
    public static Date getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Uri uri = Uri.parse(cList.get(position).getHeadPic());
        holder.circle_user_simple.setImageURI(uri);
        holder.circle_user_name.setText(cList.get(position).getNickName());
        holder.circle_date.setText(String.valueOf(cList.get(position).getCreateTime()+"getNowDate()"));
        holder.circle_title.setText(cList.get(position).getContent());
        Uri uri1 = Uri.parse(cList.get(0).getImage());
        holder.circle1_simple.setImageURI(uri1);
        Uri uri2 = Uri.parse(cList.get(1).getImage());
        holder.circle2_simple.setImageURI(uri2);
        holder.zanshu.setText(String.valueOf(cList.get(position).getGreatNum()));

       greatNum = cList.get(position).getGreatNum();

        i = greatNum+num;

            holder.zan_simple.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
    /**
     * 这有问题,还是先赶进度
     */
                    holder.zan_simple.setImageResource(R.mipmap.common_btn_prise_s_hdpi);
                    for (int j = 0; j < cList.size(); j++) {
                        holder.zanshu.setText(String.valueOf(cList.get(position).getGreatNum()+1));
                    }

    //                if ()

                }
            });
    }

    @Override
    public int getItemCount() {
        return cList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView circle_user_simple;
        private TextView circle_user_name;
        private TextView circle_date;
        private TextView circle_title;
        private SimpleDraweeView circle1_simple;
        private SimpleDraweeView circle2_simple;

        private ImageView zan_simple;
        private TextView zanshu;
        public ViewHolder(View itemView) {
            super(itemView);
            circle_user_simple = (SimpleDraweeView) itemView.findViewById(R.id.circle_user_simple);
            circle_user_name = (TextView) itemView.findViewById(R.id.circle_user_name);
            circle_date = (TextView) itemView.findViewById(R.id.circle_date);
            circle_title = (TextView) itemView.findViewById(R.id.circle_title);
            circle1_simple = (SimpleDraweeView) itemView.findViewById(R.id.circle1_simple);
            circle2_simple = (SimpleDraweeView) itemView.findViewById(R.id.circle2_simple);

            zanshu = (TextView) itemView.findViewById(R.id.zan_shu);
            zan_simple = (ImageView) itemView.findViewById(R.id.zan_simple);
        }
    }
}
