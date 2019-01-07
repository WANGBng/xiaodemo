package com.bwie.mvp.model;

import com.bwie.my.bean.home.HomeBannerBean;
import com.bwie.my.bean.home.HomeCommodityBean;
import com.bwie.my.utils.HttpUtils;

import io.reactivex.Observable;

/**
 * date:2018/12/4.
 * Created by 王丙均
 * 首页
 */

public class HomeModel {//轮播图的
    public Observable<HomeBannerBean> getHomeBanner(){
        Observable<HomeBannerBean> banner = HttpUtils.getInstence().api.getBanner();
        return banner;
    }//首页展示的
    public Observable<HomeCommodityBean> getCommodity(){
        Observable<HomeCommodityBean> commodity = HttpUtils.getInstence().api.getCommodity();
        return commodity;
    }
}