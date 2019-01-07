package com.bwie.my.fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bwie.R;
import com.bwie.mvp.presenter.HomeBannerPresenter;
import com.bwie.mvp.view.homeview.HomeBannerView;
import com.bwie.my.activity.sou.SouActivity;
import com.bwie.my.adapter.homeadapter.Home_Hot_Line_Adapter;
import com.bwie.my.adapter.homeadapter.Home_Magic_Line_Adapter;
import com.bwie.my.adapter.homeadapter.Home_Quality_Line_Adapter;
import com.bwie.my.bean.home.HomeBannerBean;
import com.bwie.my.bean.home.HomeCommodityBean;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * date:2018/12/5.
 * Created by 王丙均
 */

public class HomeFragment extends Fragment implements HomeBannerView {
    public static final String BUNDLE_TITLE = "title";
    private static final String TAG = "HomeFragment";
    View view;
    HomeBannerPresenter homeBannerPresenter;
    Home_Hot_Line_Adapter home_hot_line_adapter;

    Home_Magic_Line_Adapter home_magic_line_adapter;
    Home_Quality_Line_Adapter home_quality_line_adapter;


    Unbinder unbinder;
    @BindView(R.id.ed_sou)
    EditText edSou;
    @BindView(R.id.mo_li_shi_shang)
    ImageView moLiShiShang;

    private List<String> imagebean = new ArrayList<>();

    @BindView(R.id.menu_n)
    ImageView menuN;
    @BindView(R.id.search_n)
    ImageView searchN;

    @BindView(R.id.bga_banner)
    FlyBanner flyBanner;
    @BindView(R.id.re_)
    ImageView re;
    @BindView(R.id.re_recyclerView)
    RecyclerView reRecyclerView;

    @BindView(R.id.mo_)
    ImageView mo;
    @BindView(R.id.mo_recyclerView)
    RecyclerView moRecyclerView;
    @BindView(R.id.pin_)
    ImageView pin;
    @BindView(R.id.sheng_recyclerView)
    RecyclerView shengRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.home_fragment_layout, container, false);
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        unbinder = ButterKnife.bind(this, view);//ButterKnife绑定
        //轮播图的P层
        homeBannerPresenter = new HomeBannerPresenter();
        homeBannerPresenter.attachView(this);
        homeBannerPresenter.getHomeBanner();
        //热线销售P
        homeBannerPresenter.attachView(this);
        homeBannerPresenter.getHot();


//        reRecyclerView.addItemDecoration(/);


        return view;
    }

    public static HomeFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_TITLE, title);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override//这是轮播图的
    public void OnHomeBannerSuccess(HomeBannerBean bannerBean) {
        List<HomeBannerBean.ResultBean> result = bannerBean.getResult();
        for (int i = 0; i < result.size(); i++) {
            imagebean.add(bannerBean.getResult().get(i).getImageUrl());
        }
        flyBanner.setImagesUrl(imagebean);//将得到的图片数据添加

    }
    /**
     * 自定义的RecyclerView的item这是线性布局的
     */
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildPosition(view) == 0){
                outRect.top = space;
            }
        }
    }
    /**
     * 自定义的RecyclerView的item这是网格布局的
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount; //列数
        private int spacing; //间隔
        private boolean includeEdge; //是否包含边缘

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            //这里是关键，需要根据你有几列来判断
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    @Override
    public void OnHomeCommoditySuccess(HomeCommodityBean.ResultBean homeCommodityBean) {
        int space = 10;
//      热销新品
        List<HomeCommodityBean.ResultBean.RxxpBean.CommodityListBean> commodityList = homeCommodityBean.getRxxp().get(0).getCommodityList();
        RecyclerView.LayoutManager gridLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        reRecyclerView.setLayoutManager(gridLayoutManager);

        home_hot_line_adapter = new Home_Hot_Line_Adapter(getActivity(), commodityList);
        reRecyclerView.setAdapter(home_hot_line_adapter);
        // 3 columns
        int spanCount = 3;
        // 50px
        int spacing = 20;
        boolean includeEdge = false;
        reRecyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
       // reRecyclerView.addItemDecoration(new SpacesItemDecoration(space));

//      魔力时尚
        List<HomeCommodityBean.ResultBean.MlssBean.CommodityListBeanXX> mlss = homeCommodityBean.getMlss().get(0).getCommodityList();
        RecyclerView.LayoutManager mlsh = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        moRecyclerView.setLayoutManager(mlsh);
        home_magic_line_adapter = new Home_Magic_Line_Adapter(getActivity(), mlss);
        moRecyclerView.setAdapter(home_magic_line_adapter);
        moRecyclerView.addItemDecoration(new SpacesItemDecoration(space));

//      品质生活
        List<HomeCommodityBean.ResultBean.PzshBean.CommodityListBeanX> commodityList1 = homeCommodityBean.getPzsh().get(0).getCommodityList();
        GridLayoutManager pzsh = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        shengRecyclerView.setLayoutManager(pzsh);
        home_quality_line_adapter = new Home_Quality_Line_Adapter(getActivity(), commodityList1);
        shengRecyclerView.setAdapter(home_quality_line_adapter);

        shengRecyclerView.addItemDecoration(new SpacesItemDecoration(space));
    }


    @Override
    public void OnFailed(Throwable t) {

        Toast.makeText(getActivity(), "错误的是;:：" + t, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        homeBannerPresenter.detachView();
    }

    @OnClick({R.id.menu_n, R.id.search_n, R.id.re_, R.id.mo_, R.id.pin_})
    public void onViewClicked(final View view) {
        switch (view.getId()) {
            case R.id.menu_n:
                Toast.makeText(getActivity(), "menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search_n:
               Toast.makeText(getActivity(), "search_n", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),SouActivity.class);
                startActivity(intent);

                break;
            case R.id.re_:
                Toast.makeText(getActivity(), "re_", Toast.LENGTH_SHORT).show();


                break;
            case R.id.mo_:
                Toast.makeText(getActivity(), "mo_", Toast.LENGTH_SHORT).show();

                break;
            case R.id.pin_:
                Toast.makeText(getActivity(), "pin_", Toast.LENGTH_SHORT).show();

                break;

            default:
                break;
        }
    }
}