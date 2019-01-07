package com.bwie.mvp.presenter;

import com.bwie.base.presenter.BasePresenter;
import com.bwie.mvp.model.HomeModel;
import com.bwie.mvp.view.homeview.HomeBannerView;
import com.bwie.my.bean.home.HomeBannerBean;
import com.bwie.my.bean.home.HomeCommodityBean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * date:2018/12/4.
 * Created by 王丙均
 * 整个首页面的P层
 */
public class HomeBannerPresenter extends BasePresenter<HomeBannerView>{
    private final HomeModel homeModel;
    public HomeBannerPresenter(){
        homeModel = new HomeModel();
    }
    //轮播图
    public void getHomeBanner(){
        homeModel.getHomeBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {}
                    @Override
                    public void onNext(HomeBannerBean bannerBean) {
                        if (bannerBean!=null){
                            getView().OnHomeBannerSuccess(bannerBean);}}
                    @Override
                    public void onError(Throwable e) {
                        getView().OnFailed(e);
                    }
                    @Override
                    public void onComplete() {}
                });
    }

    //热线销售
    public void getHot(){
        homeModel.getCommodity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeCommodityBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(HomeCommodityBean homeCommodityBean) {
                        if (homeCommodityBean!=null){
                            HomeCommodityBean.ResultBean result = homeCommodityBean.getResult();
                            getView().OnHomeCommoditySuccess(result);
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        getView().OnFailed(e);
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }
}
