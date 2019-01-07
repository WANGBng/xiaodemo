package com.bwie.my.activity.sou;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.R;
import com.bwie.mvp.presenter.InfoPresenter;
import com.bwie.mvp.presenter.JiaGouPresenter;
import com.bwie.mvp.view.sou.InfoView;
import com.bwie.mvp.view.sou.JiaView;
import com.bwie.my.bean.sou.GoodsInfoBean;
import com.bwie.my.bean.sou.JiaGouBean;
import com.bwie.my.utils.Api;
import com.bwie.my.utils.Contest;
import com.bwie.my.utils.HttpUtils;
import com.facebook.drawee.view.SimpleDraweeView;

//import org.jsoup.Jsoup;
//import org.w3c.dom.Document;

//import java.lang.annotation.Documented;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 *
 */
public class InfoActivity extends AppCompatActivity implements InfoView,JiaView{

    @BindView(R.id.info_simple)
    SimpleDraweeView simple;
    @BindView(R.id.flyBanner)
    ViewPager flyBanner;
    @BindView(R.id.txt_subhead)
    TextView txtSubhead;

    private Api api;
    @BindView(R.id.txt_pric)
    TextView txtPric;
    @BindView(R.id.txt_price)
    TextView txtPrice;
    @BindView(R.id.txt_salenu)
    TextView txtSalenu;
    @BindView(R.id.txt_salenum)
    TextView txtSalenum;
    @BindView(R.id.gwc)
    TextView gwc;
    @BindView(R.id.jrgwc)
    TextView jrgwc;
    @BindView(R.id.ljgm)
    TextView ljgm;
    @BindView(R.id.buBar)
    LinearLayout buBar;
    String userId;
    int commodityId;
    Unbinder unbinder;
    InfoPresenter infoPresenter;
    private JiaGouPresenter jiaGouPresenter;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        unbinder = ButterKnife.bind(this);

        infoPresenter = new InfoPresenter();
        infoPresenter.attachView(this);

        int commodityId = getIntent().getIntExtra("commodityId", 1);
        infoPresenter.loadData(commodityId);
//就如缓存并且加入到购物车
        sharedPreferences = getSharedPreferences("flag", Context.MODE_PRIVATE);
        userId = sharedPreferences.getString("userId","1");

        jiaGouPresenter = new JiaGouPresenter();
        jiaGouPresenter.attachView(this);

    }

    @OnClick({R.id.gwc, R.id.jrgwc, R.id.ljgm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gwc:

                break;
            case R.id.jrgwc:
                Toast.makeText(this,"加入成功",Toast.LENGTH_SHORT).show();
                if (userId != null && "1".equals(userId)){
                    jiaGouPresenter.getJiaGou(userId,String.valueOf(commodityId));
                    Toast.makeText(this,"加入成功了，咱有的是钱!!!",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"你登录了么?没登录就去登陆",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ljgm:

                break;

            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
      //  if (infoPresenter!=null || jiaGouPresenter!=null ){
            infoPresenter.detachView();
            jiaGouPresenter.detachView();
       // }
    }

    @Override
    public void onSuccess(GoodsInfoBean goodsInfoBean) {
       // GoodsInfoBean.ResultBean result = goodsInfoBean.getResult();
        // String url1="http://172.17.8.100/small/commodity/v1/findCommodityDetailsById?userId=18&sessionId=15320748258726&commodityId=6";
      //  Document doc= Jsoup.connect().get();
        /*txtPric.setText(String.valueOf("￥"+result.getPicture()));
        txtPric.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        txtSubhead.setText(result.getCategoryName());
        txtSalenum.setText(String.valueOf(result.getCommentNum()));
*/
        /**
         *  txtPric.setText(String.valueOf("￥"+goodsInfoBean.getResult().getPicture()));
         txtPric.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
         txtSubhead.setText(goodsInfoBean.getResult().getCategoryName());
         txtSalenum.setText(String.valueOf(goodsInfoBean.getResult().getCommentNum()));
         */

    }
    @Override
    public void onError(String msg) {
    }
    @Override
    public void onJiaSuccess(JiaGouBean jiaGouBean) {
        if (jiaGouBean.getMessage().equals("加购成功")){
            Toast.makeText(this,"加购成功",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onJiaError(Throwable t) {
    }
}
